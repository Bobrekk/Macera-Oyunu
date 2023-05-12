
public class Inventory {
	private boolean water, food, firewood;
	private String wName, aName;
	private int dmg, arm;
	Inventory () {
		this.water = false;
		this.food = false;
		this.firewood = false;
		this.aName = null;
		this.wName = null;
		this.dmg = 0;
		this.arm = 0;
	}
	public boolean isWater() {
		return water;
	}
	public void setWater(boolean water) {
		this.water = water;
	}
	public boolean isFood() {
		return food;
	}
	public void setFood(boolean food) {
		this.food = food;
	}
	public boolean isFirewood() {
		return firewood;
	}
	public void setFirewood(boolean firewood) {
		this.firewood = firewood;
	}
	public String getwName() {
		return wName;
	}
	public void setwName(String wName) {
		this.wName = wName;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public int getDmg() {
		return dmg;
	}
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
	public int getArm() {
		return arm;
	}
	public void setArm(int arm) {
		this.arm = arm;
	}
	
}
