package implementation.fighter;

import abstracts.fighter.IAptitude;

public class Aptitude implements IAptitude {
	
	private int strenght;
	private int dexterity;
	private int intelligence;
	private int concentration;
	private boolean isOver = true;
	private boolean isInTheRange = false;
	
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
	
	
	private boolean aptitudeIsOverTheMaxCapacity(){
		if(strenght + dexterity + intelligence + concentration <= 100){
			return isInTheRange;
		}
		return isOver;
	}
}
