package implementation.fighter;

import abstracts.fighter.IAptitude;
import exception.fighter.IllegalAptitudeValueIsLessThenTheGap;

public class Mage extends Fighter{

	private int intelligence;
	private int concentration;
	public final static int GAP = 15;
	
	public Mage(String name, int numberOfHp, int strenght, int dexterity, int intelligence, int concentration) throws IllegalAptitudeValueIsLessThenTheGap {
		super(name, numberOfHp, strenght, dexterity, intelligence, concentration);
		this.validateMageAptitude();
	}
	
	@Override
	public int getStrength() {
		return this.strenght;
	}
	
	@Override
	public int getNbOfHp() {
		// TODO Auto-generated method stub
		return this.numberOfHp;
	}
	
	public int getIntelligence() {
		intelligence = Math.max(aptitude.getStrength(), aptitude.getDexterity()) + 15;
		return this.intelligence;
	}
	
	public int getConcentration() {
		concentration = Math.max(aptitude.getStrength(), aptitude.getDexterity()) + 15;
		return this.concentration;
	}
	
	private void validateMageAptitude() throws IllegalAptitudeValueIsLessThenTheGap{
		this.validateIntelligenceValueIsEqualsTheGapValueWithDexterityOrStrenght();
		this.validateConcentrationValueIsEqualsTheGapValueWithDexterityOrStrenght();
	}
	
	private void validateIntelligenceValueIsEqualsTheGapValueWithDexterityOrStrenght() throws IllegalAptitudeValueIsLessThenTheGap {
		if(aptitude.getIntelligence() < Math.max(aptitude.getStrength(), aptitude.getDexterity()) + 15) throw new IllegalAptitudeValueIsLessThenTheGap();
		
	}

	private void validateConcentrationValueIsEqualsTheGapValueWithDexterityOrStrenght() throws IllegalAptitudeValueIsLessThenTheGap {
		if(aptitude.getIntelligence() < Math.max(aptitude.getStrength(), aptitude.getDexterity()) + 15) throw new IllegalAptitudeValueIsLessThenTheGap();
		
	}




}
