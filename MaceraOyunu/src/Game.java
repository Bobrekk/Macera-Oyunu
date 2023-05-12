import java.util.Scanner;
public class Game {
	Player player;
	Location location;
	Scanner input = new Scanner(System.in);
	public void login () {
		String playerName; 
		System.out.println("Oyuna Hoþgeldiniz!");
		System.out.print("Ýsminizi Giriniz: ");
		playerName = input.nextLine();
		player = new Player(playerName);
		player.selectCha();
		start();
	}
	public void start () {
		while (true) {
			System.out.println();
			System.out.println("---------------------------");
			System.out.println();
			System.out.println("1. Güvenli Ev -> Size ait güvenli bir mekan, düþman yok!");
			System.out.println("2. Maðara -> Dikkat zombi çýkabilir!");
			System.out.println("3. Orman -> Dikkat vampir çýkabilir!");
			System.out.println("4. Nehir -> Dikkat ayý çýkabilir!");
			System.out.println("5. Maðaza -> Buradan eþyalarýnýzý geliþtirebilirsiniz!");
			System.out.print("Gitmek istediðiniz yer: ");
			int loc = input.nextInt();
			while (loc <= 0 || loc > 5) {
				System.out.println("Geçersiz sayý girdiniz! Lütfen geçerli bir sayý giriniz!");
				loc = input.nextInt();
			}
			switch (loc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			}
			if (location.getClass().getName().equals("SafeHouse")) {
				if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println("Tebrikler Oyunu Kazandýnýz!");
					break;
				}
			}
			if (!location.getLoc()) {
				System.out.println("Oyun Bitti!");
				break;
			}
		}
	}
	
}
