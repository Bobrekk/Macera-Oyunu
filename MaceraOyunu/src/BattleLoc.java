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
			System.out.println("�uan buradas�n�z: " + this.getName());
			System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + obs.getName() + " var!");
			System.out.println("Sava� veya Ka�!");
			String sel = input.nextLine();
			sel = sel.toUpperCase();
			if (sel.equals("S")) {
				if (combat(obsNumber)) {
					System.out.println("Buradaki t�m d��manlar� �ld�rd�n�z!");
					if (this.award == "Yemek" && player.getInv().isFood() == false) {
						System.out.println(this.award + " Kazand�n�z!");
						player.getInv().setFood(true);;
					}
					else if (this.award == "Odun" && player.getInv().isFirewood() == false) {
						System.out.println(this.award + " Kazand�n�z!");
						player.getInv().setFirewood(true);
						}
					else if (this.award == "Su" && player.getInv().isWater() == false) {
						System.out.println(this.award + " Kazand�n�z!");
						player.getInv().setWater(true);
						}
					return true;
				}    	
				if (player.getHeal() <= 0) {
				   System.out.println("�ld�n�z!");
				   return false;
					}
				}
			else if (sel.equals("K")) {
				System.out.println("Ka�t�n�z!");
			}
			else {
				System.out.println("-5 IQ BERKAY");
			}
			return true;
		}
		else {
			System.out.println("�uan buradas�n�z: " + this.getName());
			System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + obs.getName() + " var!");
			System.out.println("Sava� veya Ka�!");
			String sel = input.nextLine();
			sel = sel.toUpperCase();
			if (sel.equals("S")) {
				if (combat(obsNumber)) {
					System.out.println("Buradaki t�m d��manlar� �ld�rd�n�z!");
					if (this.award == "Yemek" && player.getInv().isFood() == false) {
						System.out.println(this.award + " Kazand�n�z!");
						player.getInv().setFood(true);;
					}
					else if (this.award == "Odun" && player.getInv().isFirewood() == false) {
						System.out.println(this.award + " Kazand�n�z!");
						player.getInv().setFirewood(true);
						}
					else if (this.award == "Su" && player.getInv().isWater() == false) {
						System.out.println(this.award + " Kazand�n�z!");
						player.getInv().setWater(true);
						}
					return true;
				}
				if (player.getHeal() <= 0) {
					   System.out.println("�ld�n�z!");
					   return false;
						}
			    }
			else if (sel.equals("K")) {
				System.out.println("Ka�t�n�z!");
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
		    	System.out.print("Vur veya Ka�");
		    	String select = input.nextLine();
		    	select = select.toUpperCase();
		    	if (select.equals("V")) {
		    		System.out.println("Siz Vurdunuz!");
		    		obs.setHealth(obs.getHealth() - player.totalDmg());
		    		afterHit();
		    		if (obs.getHealth() > 0) {
		    			System.out.println("D��man vurdu!");
		    			player.setHeal(player.getHeal() - (obs.getDmg() - player.getInv().getArm()));
		    			afterHit();
		    		}
		    	}
		    	else if (select.equals("K")) {
		    		System.out.println("Ka�t�n�z!");
		    		break;
		    	}
		    	else {
		    		System.out.println("-5 IQ BERKAY");
		    		break;
		    	}
		    	}
		    if (obs.getHealth() <= 0 && player.getHeal() > 0) {
				System.out.println("Tebrikler D��man� �ld�rd�n�z!");
				player.setMoney(player.getMoney() + obs.getAward());
				System.out.println("G�ncel Paran�z: " + player.getMoney());
				obs.setHealth(defobsheal);
				}
			else {
				return false;
			}
		    }
		return true;
	}
	
		
	public void playerStats () {
		System.out.println("Oyuncunun �zellikleri: ");
		System.out.println("Can�: " + player.getHeal());
		System.out.println("Hasar�: " + player.totalDmg());
		System.out.println("Paras�: " + player.getMoney());
		if (player.getInv().getDmg() > 0) {
			System.out.println("Silah�: " + player.getInv().getwName());
		}
		if (player.getInv().getArm() > 0) {
			System.out.println("Z�rh�: " + player.getInv().getaName());
		}
	}
	public void enemyStats () {
		System.out.println(obs.getName() + " D��man�yla Kar��la�t�n�z !");
		System.out.println("Can�: " + obs.getHealth());
		System.out.println("Hasar�: " + obs.getDmg());
		System.out.println("�d�l�: " + obs.getAward());
	}
	public void afterHit () {
		System.out.println("Sizin Can�n�z: " + player.getHeal());
		System.out.println("D��man�n Can�: " + obs.getHealth());
	}
}
