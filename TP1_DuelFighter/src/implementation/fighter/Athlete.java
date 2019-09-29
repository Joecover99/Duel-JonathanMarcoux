package implementation.fighter;

public class Athlete extends Fighter{
	private int strenght = 20;
	private int dexterity = 20;
	private int intelligence = 20;
	private int concentration = 20;
	
	public Athlete(String name, int id, int numberOfHp) {
		super(name, id, numberOfHp);
		// TODO Auto-generated constructor stub
	}
	//force >= 20 dextérité >= 20 intelligence >= 20 concentration >= 20 
	public int getStrength() {
		return this.strenght;
	}
	
	public int getDexterity() {
		return this.dexterity;
	}
	
	public int getIntelligence() {
		return this.intelligence;
	}
	
	public int getConcentration() {
		return this.concentration;
	}
}
