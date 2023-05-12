import java.util.Scanner;
public abstract class BattleLoc extends Location {
	protected Obstacle obs;
	protected String award;
	Scanner input = new Scanner(System.in);
	public BattleLoc(Player player, String name,Obstacle obs,String award) {
		super(player);
		this.name = name;
		this.obs = obs;
		this.award = award;
	}
	public boolean getLoc () {
		int obsNumber = obs.obsNumber();
		if (obs.obsNumber() == 0) {
			System.out.println("Þuan buradasýnýz: " + this.getName());
			System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + obs.getName() + " var!");
			System.out.println("Savaþ veya Kaç!");
			String sel = input.nextLine();
			sel = sel.toUpperCase();
			if (sel.equals("S")) {
				if (combat(obsNumber)) {
					System.out.println("Buradaki tüm düþmanlarý öldürdünüz!");
					if (this.award == "Yemek" && player.getInv().isFood() == false) {
						System.out.println(this.award + " Kazandýnýz!");
						player.getInv().setFood(true);;
					}
					else if (this.award == "Odun" && player.getInv().isFirewood() == false) {
						System.out.println(this.award + " Kazandýnýz!");
						player.getInv().setFirewood(true);
						}
					else if (this.award == "Su" && player.getInv().isWater() == false) {
						System.out.println(this.award + " Kazandýnýz!");
						player.getInv().setWater(true);
						}
					return true;
				}    	
				if (player.getHeal() <= 0) {
				   System.out.println("Öldünüz!");
				   return false;
					}
				}
			else if (sel.equals("K")) {
				System.out.println("Kaçtýnýz!");
			}
			else {
				System.out.println("-5 IQ BERKAY");
			}
			return true;
		}
		else {
			System.out.println("Þuan buradasýnýz: " + this.getName());
			System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + obs.getName() + " var!");
			System.out.println("Savaþ veya Kaç!");
			String sel = input.nextLine();
			sel = sel.toUpperCase();
			if (sel.equals("S")) {
				if (combat(obsNumber)) {
					System.out.println("Buradaki tüm düþmanlarý öldürdünüz!");
					if (this.award == "Yemek" && player.getInv().isFood() == false) {
						System.out.println(this.award + " Kazandýnýz!");
						player.getInv().setFood(true);;
					}
					else if (this.award == "Odun" && player.getInv().isFirewood() == false) {
						System.out.println(this.award + " Kazandýnýz!");
						player.getInv().setFirewood(true);
						}
					else if (this.award == "Su" && player.getInv().isWater() == false) {
						System.out.println(this.award + " Kazandýnýz!");
						player.getInv().setWater(true);
						}
					return true;
				}
				if (player.getHeal() <= 0) {
					   System.out.println("Öldünüz!");
					   return false;
						}
			    }
			else if (sel.equals("K")) {
				System.out.println("Kaçtýnýz!");
			   }
			else {
				System.out.println("-5 IQ BERKAY");
			    }
	}
		return true;
	}
	public boolean combat (int obsNumber) {
		for (int i = 0; i < obsNumber; i++) {
			playerStats();
			enemyStats();
			int defobsheal = obs.getHealth();
		    while (player.getHeal() > 0 && obs.getHealth() > 0) {
		    	System.out.print("Vur veya Kaç");
		    	String select = input.nextLine();
		    	select = select.toUpperCase();
		    	if (select.equals("V")) {
		    		System.out.println("Siz Vurdunuz!");
		    		obs.setHealth(obs.getHealth() - player.totalDmg());
		    		afterHit();
		    		if (obs.getHealth() > 0) {
		    			System.out.println("Düþman vurdu!");
		    			player.setHeal(player.getHeal() - (obs.getDmg() - player.getInv().getArm()));
		    			afterHit();
		    		}
		    	}
		    	else if (select.equals("K")) {
		    		System.out.println("Kaçtýnýz!");
		    		break;
		    	}
		    	else {
		    		System.out.println("-5 IQ BERKAY");
		    		break;
		    	}
		    	}
		    if (obs.getHealth() <= 0 && player.getHeal() > 0) {
				System.out.println("Tebrikler Düþmaný Öldürdünüz!");
				player.setMoney(player.getMoney() + obs.getAward());
				System.out.println("Güncel Paranýz: " + player.getMoney());
				obs.setHealth(defobsheal);
				}
			else {
				return false;
			}
		    }
		return true;
	}
	
		
	public void playerStats () {
		System.out.println("Oyuncunun Özellikleri: ");
		System.out.println("Caný: " + player.getHeal());
		System.out.println("Hasarý: " + player.totalDmg());
		System.out.println("Parasý: " + player.getMoney());
		if (player.getInv().getDmg() > 0) {
			System.out.println("Silahý: " + player.getInv().getwName());
		}
		if (player.getInv().getArm() > 0) {
			System.out.println("Zýrhý: " + player.getInv().getaName());
		}
	}
	public void enemyStats () {
		System.out.println(obs.getName() + " Düþmanýyla Karþýlaþtýnýz !");
		System.out.println("Caný: " + obs.getHealth());
		System.out.println("Hasarý: " + obs.getDmg());
		System.out.println("Ödülü: " + obs.getAward());
	}
	public void afterHit () {
		System.out.println("Sizin Canýnýz: " + player.getHeal());
		System.out.println("Düþmanýn Caný: " + obs.getHealth());
	}
}
