import java.util.Scanner;
public class ToolStore extends NormalLoc {
	Scanner input = new Scanner (System.in);
	public ToolStore(Player player) {
		super(player, "Maðaza");
	}
	public boolean getLoc() {
		System.out.println("Maðazaya Hoþgeldiniz!");
		System.out.println("Paranýz: " + player.getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Zýrhlar");
		System.out.println("3. Çýkýþ");
		System.out.println("Ne Almak Ýstersiniz: ");
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
			System.out.println("Geçersiz Ýþlem Girdiniz!");
			break;
		}
		return true;
	}
	public int armorList () {
		System.out.println("1. Zýrh - Türü: Hafif, Engelleme: 1, Fiyatý: 15");
		System.out.println("2. Zýrh - Türü: Orta, Engelleme: 3, Fiyatý: 35");
		System.out.println("3. Zýrh - Türü: Aðýr, Engelleme: 5, Fiyatý: 40");
		System.out.println("4. Çýkýþ");
		System.out.println("Zýrh Seçiniz. ");
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
			aName = "Aðýr";
			avoid = 5;
			price = 40;
			break;
		case 4:
			break;
		default:
			System.out.println("Geçersiz Ýþlem Girdiniz!");
			break;			
		}
		if (player.getMoney() >= price && armorID < 4) {
			player.getInv().setArm(avoid);
			player.getInv().setaName(aName);
			player.setMoney(player.getMoney()-price);
			System.out.println(aName + " satýn aldýnýz! Önceki zýrhýnýz: " + player.getArm() + " Þimdiki zýrhýnýz: " + player.totalArm());
			System.out.println("Kalan Para: " + player.getMoney());
		}
		else if (player.getMoney() < price) {
			System.out.println("Yetersiz Para!");
		}
	}
	public int weaponsList () {
		System.out.println("1. Silah - Türü: Tabanca, Hasarý: 2, Fiyatý: 25");
		System.out.println("2. Silah - Türü: Kýlýç, Hasarý: 3, Fiyatý: 35");
		System.out.println("3. Silah - Türü: Tüfek, Hasarý: 7, Fiyatý: 45");
		System.out.println("4. Çýkýþ");
		System.out.println("Silah Seçiniz: ");
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
			wName = "Kýlýç";
			dmg = 3;
			price = 35;
			break;
		case 3:
			wName = "Tüfek";
			dmg = 7;
			price = 45;
			break;
		case 4:
			break;
		default:
			System.out.println("Geçersiz Ýþlem Girdiniz!");
			break;
		}
		if (player.getMoney() >= price && weaponID < 4) {
			player.getInv().setDmg(dmg);
			player.getInv().setwName(wName);
			player.setMoney(player.getMoney()-price);
			System.out.println(wName + " satýn aldýnýz! Önceki hasarýnýz: " + player.getDam() + " Þimdiki hasarýnýz: " + player.totalDmg());
			System.out.println("Kalan Para: " + player.getMoney());
		}
		else if (player.getMoney() < price) {
			System.out.println("Yetersiz Para!");
		}
	}
}
