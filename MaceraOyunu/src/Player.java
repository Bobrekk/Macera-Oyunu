import java.util.Scanner;
public class Player {
	private int dam , heal, money, rHeal,arm = 0;
	private String name,cName;
	private Inventory inv;
	Scanner input = new Scanner (System.in);
	public Player(String name) {
		this.name = name;
		this.inv = new Inventory ();
	}
	public void selectCha () {
		switch (listCha()) {
		case 1:
			init ("Samuray",5,21,15);
			break;
		case 2:
			init ("Okçu",7,18,20);
			break;
		case 3:
			init ("Þovalye",8,24,5);
			break;
		}
		System.out.println("Karakterinizin Adý: " + getcName() + " " + "Hasarý: " + getDam() + " " + "Saðlýðý: "  + getHeal() + " " + "Parasý: " + getMoney());
	}
	public int listCha () {
		System.out.println("Karakter Seçimine Hoþgeldiniz!");
		System.out.println("Karakter Listesi:");
		System.out.println("1.Karakter - Türü: Samuray, Hasar: 5, Saðlýk: 21, Para: 15");
		System.out.println("2.Karakter - Türü: Okçu, Hasar: 7, Saðlýk: 18, Para: 20");
		System.out.println("3.Karakter - Türü: Þovalye, Hasar: 8, Saðlýk: 24, Para: 5");
		System.out.print("Karakter Seçiminiz: ");
		int select = input.nextInt();
		while (select <= 0 || select > 3) {
			System.out.println("Geçersiz sayý girdiniz! Lütfen geçerli sayý giriniz!");
			select = input.nextInt();
		}
		return select;
	}
	public int totalDmg () {
		return this.getDam() + this.getInv().getDmg();
	}
	public int totalArm () {
		return this.getArm() + this.getInv().getArm();
	}
	public void init (String cn, int dam, int hl, int mn) {
		setcName (cn);
		setDam (dam);
		setHeal (hl);
		setMoney (mn);
		setrHeal (hl);
	}
	public int getrHeal() {
		return rHeal;
	}
	public void setrHeal(int rHeal) {
		this.rHeal = rHeal;
	}
	public int getDam() {
		return dam;
	}
	public void setDam(int dam) {
		this.dam = dam;
	}
	public int getHeal() {
		return heal;
	}
	public void setHeal(int heal) {
		this.heal = heal;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Inventory getInv() {
		return inv;
	}
	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	public int getArm() {
		return arm;
	}
	public void setArm(int arm) {
		this.arm = arm;
	}
	
}
