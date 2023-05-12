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
			init ("Ok�u",7,18,20);
			break;
		case 3:
			init ("�ovalye",8,24,5);
			break;
		}
		System.out.println("Karakterinizin Ad�: " + getcName() + " " + "Hasar�: " + getDam() + " " + "Sa�l���: "  + getHeal() + " " + "Paras�: " + getMoney());
	}
	public int listCha () {
		System.out.println("Karakter Se�imine Ho�geldiniz!");
		System.out.println("Karakter Listesi:");
		System.out.println("1.Karakter - T�r�: Samuray, Hasar: 5, Sa�l�k: 21, Para: 15");
		System.out.println("2.Karakter - T�r�: Ok�u, Hasar: 7, Sa�l�k: 18, Para: 20");
		System.out.println("3.Karakter - T�r�: �ovalye, Hasar: 8, Sa�l�k: 24, Para: 5");
		System.out.print("Karakter Se�iminiz: ");
		int select = input.nextInt();
		while (select <= 0 || select > 3) {
			System.out.println("Ge�ersiz say� girdiniz! L�tfen ge�erli say� giriniz!");
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
