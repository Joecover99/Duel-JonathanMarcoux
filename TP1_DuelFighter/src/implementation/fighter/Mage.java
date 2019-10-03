package implementation.fighter;

public class Mage extends Fighter{
	private float strenght = 17.5f;
	private float dexterity = 17.5f;
	private int intelligence;
	private int concentration;
	//private int maxStrenght = 40;
	//private int maxConcentrationFighter = 10;
	
	public Mage(String name, int numberOfHp) {
		super(name, numberOfHp);
		// TODO Auto-generated constructor stub
	}

	public int getStrength() {
		return this.aptitude.strenght;
	}
	
	public float getDexterity() {
		return this.aptitude.dexterity;
	}
	
	public int getIntelligence() {
		if(intelligence >= strenght + dexterity + 15){
		return this.intelligence;
		}
		return this.aptitude.intelligence;
	}
	
	public int getConcentration() {
		if(intelligence >= strenght + dexterity + 15){
		return this.aptitude.concentration;
		}
		return this.aptitude.concentration;
	}
}
