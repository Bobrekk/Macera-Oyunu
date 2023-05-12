import java.util.Scanner;
public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
	}
	public boolean getLoc () {
		Scanner input = new Scanner(System.in);
		System.out.println("Güvenli Evdesiniz!");
		System.out.println("Canýnýz: " + player.getHeal());
		System.out.println("1. 5 Can Yenileme Fiyatý: 5");
		System.out.println("2. 10 Can Yenileme Fiyatý: 10");
		System.out.println("3. Fulleme Fiyatý: 20");
		System.out.println("4. Çýkýþ");
		System.out.println("Hangisini Satýn Almak Ýstersiniz: ");
		int sel = input.nextInt();
		int heal;
		if (player.getMoney() > 0) {
			switch (sel) {
			case 1:
				heal = 5;
				if (player.getHeal() + heal < player.getrHeal()) {
					player.setHeal(player.getHeal() + heal);
					System.out.println("Ýyileþtiniz!");
					System.out.println("Canýnýz: " + player.getHeal());
					break;
				}
				else {
					System.out.println("Canýnýz Tam Olarak Doldurulamýyor!");
					break;
				}
			case 2: {
				heal = 10;
				if (player.getHeal() + heal < player.getrHeal()) {
					player.setHeal(player.getHeal() + heal);
					System.out.println("Ýyileþtiniz!");
					System.out.println("Canýnýz: " + player.getHeal());
					break;
				}
				else {
					System.out.println("Canýnýz Tam Olarak Doldurulamýyor!");
					break;
				}
			}
			case 3: {
				player.setHeal(player.getrHeal());
				System.out.println("Ýyileþtiniz!");
				System.out.println("Canýnýz: " + player.getHeal());
				break;
			}
			case 4:{
				break;
			}
			default:
				System.out.println("Geçersiz Deðer Girdiniz!");
				break;
			}
		}
		else {
			System.out.println("Paranýz Yetersiz!");
		}	
		return true;
		}
	}
