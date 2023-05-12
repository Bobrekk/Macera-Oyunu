import java.util.Scanner;
public class Game {
	Player player;
	Location location;
	Scanner input = new Scanner(System.in);
	public void login () {
		String playerName; 
		System.out.println("Oyuna Ho�geldiniz!");
		System.out.print("�sminizi Giriniz: ");
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
			System.out.println("1. G�venli Ev -> Size ait g�venli bir mekan, d��man yok!");
			System.out.println("2. Ma�ara -> Dikkat zombi ��kabilir!");
			System.out.println("3. Orman -> Dikkat vampir ��kabilir!");
			System.out.println("4. Nehir -> Dikkat ay� ��kabilir!");
			System.out.println("5. Ma�aza -> Buradan e�yalar�n�z� geli�tirebilirsiniz!");
			System.out.print("Gitmek istedi�iniz yer: ");
			int loc = input.nextInt();
			while (loc <= 0 || loc > 5) {
				System.out.println("Ge�ersiz say� girdiniz! L�tfen ge�erli bir say� giriniz!");
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
					System.out.println("Tebrikler Oyunu Kazand�n�z!");
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
