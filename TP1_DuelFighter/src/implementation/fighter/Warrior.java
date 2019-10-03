package implementation.fighter;

public class Warrior extends Fighter{
	private int strenght = 31;
	private int dexterity = 21;
	private int intelligence = 11;
	private int concentration = 1;
	public static int maxStrenght = 40;
	private int maxConcentrationFighter = 10;
	
	public Warrior(String name, int numberOfHp) {
		super(name, numberOfHp);
		// TODO Auto-generated constructor stub
	}
	//force >= dextérité + 10 >= intelligence + 10 >= concentration 
	public int getStrength() {
		if(strenght >= maxStrenght){
		return this.aptitude.strenght;
		}
		return this.strenght;
	}
	
	public int getDexterity() {
		if(dexterity >= intelligence + 10){
		return this.aptitude.dexterity;
		}
		
		return this.dexterity;
	}
	
	public int getIntelligence() {
		if(intelligence >= concentration + 10){
		return this.aptitude.intelligence;
		}
		return this.aptitude.intelligence;
	}
	
	public int getConcentration() {
		if(concentration >= maxConcentrationFighter){
		return this.concentration;
		}
		return this.concentration;
	}
}
