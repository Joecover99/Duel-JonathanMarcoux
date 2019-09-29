package implementation.fighter;

public class Mage extends Fighter{
	private float strenght = 17.5f;
	private float dexterity = 17.5f;
	private int intelligence;
	private int concentration;
	//private int maxStrenght = 40;
	//private int maxConcentrationFighter = 10;
	
	public Mage(String name, int id, int numberOfHp) {
		super(name, id, numberOfHp);
		// TODO Auto-generated constructor stub
	}
	//intelligence >= max(force, dextérité) + 15
	//concentration >= max(force, dextérité) + 15 
	public float getStrength() {
		return this.strenght;
	}
	
	public float getDexterity() {
		return this.dexterity;
	}
	
	public int getIntelligence() {
		if(intelligence >= strenght + dexterity + 15){
		return this.intelligence;
		}
		return this.intelligence;
	}
	
	public int getConcentration() {
		if(intelligence >= strenght + dexterity + 15){
		return this.concentration;
		}
		return this.concentration;
	}
}
