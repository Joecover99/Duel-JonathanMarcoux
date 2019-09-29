package implementation.fighter;

public class Warrior extends Fighter{
	private int strenght = 31;
	private int dexterity = 21;
	private int intelligence = 11;
	private int concentration = 1;
	private int maxStrenght = 40;
	private int maxConcentrationFighter = 10;
	
	public Warrior(String name, int id, int numberOfHp) {
		super(name, id, numberOfHp);
		// TODO Auto-generated constructor stub
	}
	//force >= dextérité + 10 >= intelligence + 10 >= concentration 
	public int getStrength() {
		if(strenght >= maxStrenght){
		return this.strenght;
		}
		return this.strenght;
	}
	
	public int getDexterity() {
		if(dexterity >= intelligence + 10){
		return this.dexterity;
		}
		
		return this.dexterity;
	}
	
	public int getIntelligence() {
		if(intelligence >= concentration + 10){
		return this.intelligence;
		}
		return this.intelligence;
	}
	
	public int getConcentration() {
		if(concentration >= maxConcentrationFighter){
		return this.concentration;
		}
		return this.concentration;
	}
}
