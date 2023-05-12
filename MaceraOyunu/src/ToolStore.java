import java.util.Scanner;
public class ToolStore extends NormalLoc {
	Scanner input = new Scanner (System.in);
	public ToolStore(Player player) {
		super(player, "Ma�aza");
	}
	public boolean getLoc() {
		System.out.println("Ma�azaya Ho�geldiniz!");
		System.out.println("Paran�z: " + player.getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Z�rhlar");
		System.out.println("3. ��k��");
		System.out.println("Ne Almak �stersiniz: ");
		int select = input.nextInt();
		int selectItemID;
		switch (select) {
		case 1:
			selectItemID = weaponsList ();
			buyWeapon(selectItemID);
			break;
		case 2:
			selectItemID = armorList ();
			buyArmor(selectItemID);
			break;
		case 3:
			break;
		default:
			System.out.println("Ge�ersiz ��lem Girdiniz!");
			break;
		}
		return true;
	}
	public int armorList () {
		System.out.println("1. Z�rh - T�r�: Hafif, Engelleme: 1, Fiyat�: 15");
		System.out.println("2. Z�rh - T�r�: Orta, Engelleme: 3, Fiyat�: 35");
		System.out.println("3. Z�rh - T�r�: A��r, Engelleme: 5, Fiyat�: 40");
		System.out.println("4. ��k��");
		System.out.println("Z�rh Se�iniz. ");
		int selectArmor = input.nextInt();
		return selectArmor;
	}
	public void buyArmor (int armorID) {
		int avoid = 0,price = 0;
		String aName = null;
		switch (armorID) {
		case 1:
			aName = "Hafif";
			avoid = 1;
			price = 15;
			break;
		case 2:
			aName = "Orta";
			avoid = 3;
			price = 35;
			break;
		case 3:
			aName = "A��r";
			avoid = 5;
			price = 40;
			break;
		case 4:
			break;
		default:
			System.out.println("Ge�ersiz ��lem Girdiniz!");
			break;			
		}
		if (player.getMoney() >= price && armorID < 4) {
			player.getInv().setArm(avoid);
			player.getInv().setaName(aName);
			player.setMoney(player.getMoney()-price);
			System.out.println(aName + " sat�n ald�n�z! �nceki z�rh�n�z: " + player.getArm() + " �imdiki z�rh�n�z: " + player.totalArm());
			System.out.println("Kalan Para: " + player.getMoney());
		}
		else if (player.getMoney() < price) {
			System.out.println("Yetersiz Para!");
		}
	}
	public int weaponsList () {
		System.out.println("1. Silah - T�r�: Tabanca, Hasar�: 2, Fiyat�: 25");
		System.out.println("2. Silah - T�r�: K�l��, Hasar�: 3, Fiyat�: 35");
		System.out.println("3. Silah - T�r�: T�fek, Hasar�: 7, Fiyat�: 45");
		System.out.println("4. ��k��");
		System.out.println("Silah Se�iniz: ");
		int selectWeapon = input.nextInt();
		return selectWeapon;
	}
	
	public void buyWeapon (int weaponID) {
		int dmg = 0,price = 0;
		String wName = null;
		switch (weaponID) {
		case 1:
			wName = "Tabanca";
			dmg = 2;
			price = 25;
			break;
		case 2:
			wName = "K�l��";
			dmg = 3;
			price = 35;
			break;
		case 3:
			wName = "T�fek";
			dmg = 7;
			price = 45;
			break;
		case 4:
			break;
		default:
			System.out.println("Ge�ersiz ��lem Girdiniz!");
			break;
		}
		if (player.getMoney() >= price && weaponID < 4) {
			player.getInv().setDmg(dmg);
			player.getInv().setwName(wName);
			player.setMoney(player.getMoney()-price);
			System.out.println(wName + " sat�n ald�n�z! �nceki hasar�n�z: " + player.getDam() + " �imdiki hasar�n�z: " + player.totalDmg());
			System.out.println("Kalan Para: " + player.getMoney());
		}
		else if (player.getMoney() < price) {
			System.out.println("Yetersiz Para!");
		}
	}
}
