import java.util.Scanner;
public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "G�venli Ev");
	}
	public boolean getLoc () {
		Scanner input = new Scanner(System.in);
		System.out.println("G�venli Evdesiniz!");
		System.out.println("Can�n�z: " + player.getHeal());
		System.out.println("1. 5 Can Yenileme Fiyat�: 5");
		System.out.println("2. 10 Can Yenileme Fiyat�: 10");
		System.out.println("3. Fulleme Fiyat�: 20");
		System.out.println("4. ��k��");
		System.out.println("Hangisini Sat�n Almak �stersiniz: ");
		int sel = input.nextInt();
		int heal;
		if (player.getMoney() > 0) {
			switch (sel) {
			case 1:
				heal = 5;
				if (player.getHeal() + heal < player.getrHeal()) {
					player.setHeal(player.getHeal() + heal);
					System.out.println("�yile�tiniz!");
					System.out.println("Can�n�z: " + player.getHeal());
					break;
				}
				else {
					System.out.println("Can�n�z Tam Olarak Doldurulam�yor!");
					break;
				}
			case 2: {
				heal = 10;
				if (player.getHeal() + heal < player.getrHeal()) {
					player.setHeal(player.getHeal() + heal);
					System.out.println("�yile�tiniz!");
					System.out.println("Can�n�z: " + player.getHeal());
					break;
				}
				else {
					System.out.println("Can�n�z Tam Olarak Doldurulam�yor!");
					break;
				}
			}
			case 3: {
				player.setHeal(player.getrHeal());
				System.out.println("�yile�tiniz!");
				System.out.println("Can�n�z: " + player.getHeal());
				break;
			}
			case 4:{
				break;
			}
			default:
				System.out.println("Ge�ersiz De�er Girdiniz!");
				break;
			}
		}
		else {
			System.out.println("Paran�z Yetersiz!");
		}	
		return true;
		}
	}
