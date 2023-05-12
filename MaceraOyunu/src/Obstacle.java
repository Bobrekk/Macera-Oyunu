import java.util.Random;

public class Obstacle {
	private String name;
	int dmg,award,maxNumber,health;
	public Obstacle(String name, int dmg, int award, int maxNumber, int health) {
		this.name = name;
		this.dmg = dmg;
		this.award = award;
		this.maxNumber = maxNumber;
		this.health = health;
	}
	public int obsNumber () {
		Random r = new Random ();
		return r.nextInt(this.maxNumber + 1);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDmg() {
		return dmg;
	}
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
	public int getAward() {
		return award;
	}
	public void setAward(int award) {
		this.award = award;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
}
