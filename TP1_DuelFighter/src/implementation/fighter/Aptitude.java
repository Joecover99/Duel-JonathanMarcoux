package implementation.fighter;

import abstracts.fighter.IAptitude;

public class Aptitude implements IAptitude {
	
	private int strenght = 25;
	private int dexterity = 25;
	private int intelligence = 25;
	private int concentration = 25;
	
	public Aptitude(int strenght, int dexterity, int intelligence, int concentration) {
		this.strenght = strenght;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.concentration = concentration;
	}
	
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
