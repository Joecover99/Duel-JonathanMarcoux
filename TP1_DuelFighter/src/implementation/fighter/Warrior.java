package implementation.fighter;

import abstracts.fighter.IAptitude;
import exception.fighter.IllegalAptitudeValueIsLessThenMinGap;

public class Warrior extends Fighter{
	public static int maxStrenght = 40;
	public static int maxConcentrationWarrior = 10;
	public final static int MINIMAL_GAP = 10;
	
	public Warrior(String name, int numberOfHp, int strenght, int dexterity, int intelligence, int concentration) throws IllegalAptitudeValueIsLessThenMinGap {
		super(name, numberOfHp, strenght, dexterity, intelligence, concentration);
		this.validateWarriorAptitude();
	}
	
	@Override
	public int getStrength() {
		return this.strenght;
	}

	
	@Override
	public int getNbOfHp() {
		return this.numberOfHp;
	}
	
	private void validateWarriorAptitude() throws IllegalAptitudeValueIsLessThenMinGap {
		this.validateStrenghtValueIsAtLeastTheGapValueWithDexterity();
		this.validateDexterityValueIsAtLeastTheGapValueWithIntelligence();
		this.validateIntelligenceValueIsAtLeastTheGapValueWithConcentration();
		
		
		
	}
	private void validateIntelligenceValueIsAtLeastTheGapValueWithConcentration() throws IllegalAptitudeValueIsLessThenMinGap {
		if(aptitude.getIntelligence() < aptitude.getConcentration() + MINIMAL_GAP) throw new IllegalAptitudeValueIsLessThenMinGap();
		
	}
	private void validateDexterityValueIsAtLeastTheGapValueWithIntelligence()  throws IllegalAptitudeValueIsLessThenMinGap {
		if(aptitude.getDexterity() < aptitude.getIntelligence() + MINIMAL_GAP) throw new IllegalAptitudeValueIsLessThenMinGap();
		
	}
	private void validateStrenghtValueIsAtLeastTheGapValueWithDexterity() throws IllegalAptitudeValueIsLessThenMinGap {
		if(aptitude.getStrength() < aptitude.getDexterity() + MINIMAL_GAP) throw new IllegalAptitudeValueIsLessThenMinGap(); 
	}


}
