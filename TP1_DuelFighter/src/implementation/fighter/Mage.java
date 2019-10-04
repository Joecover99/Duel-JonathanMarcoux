package implementation.fighter;

import abstracts.fighter.ISkill;
import exception.fighter.IllegalAptitudeIsOverMaxTotal;
import exception.fighter.IllegalAptitudeValueIsLessThenTheGap;
import exception.fighter.IllegalConcentrationValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalConcentrationValueIsEqualOrUnderZero;
import exception.fighter.IllegalDexterityValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalDexterityValueIsEqualOrUnderZero;
import exception.fighter.IllegalIntelligenceValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalIntelligenceValueIsEqualOrUnderZero;
import exception.fighter.IllegalStrenghtValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalStrenghtValueIsEqualOrUnderZero;

public class Mage extends Fighter{

	private int intelligence;
	private int concentration;
	public final static int GAP = 15;
	
	public Mage(String name, int numberOfHp, int strenght, int dexterity, int intelligence, int concentration, ISkill skill1, ISkill skill2) throws IllegalAptitudeValueIsLessThenTheGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
		super(name, numberOfHp, strenght, dexterity, intelligence, concentration, skill1, skill2);
		this.validateMageAptitude();
		validateAttribute(strenght, dexterity, intelligence, concentration);
	}
	
	public int getIntelligence() {
		intelligence = Math.max(this.getStrength(), this.getDexterity()) + GAP;
		return this.intelligence;
	}
	
	public int getConcentration() {
		concentration = Math.max(this.getStrength(), this.getDexterity()) + GAP;
		return this.concentration;
	}
	
	private void validateMageAptitude() throws IllegalAptitudeValueIsLessThenTheGap{
		this.validateIntelligenceValueIsEqualsTheGapValueWithDexterityOrStrenght();
		this.validateConcentrationValueIsEqualsTheGapValueWithDexterityOrStrenght();
	}
	
	private void validateIntelligenceValueIsEqualsTheGapValueWithDexterityOrStrenght() throws IllegalAptitudeValueIsLessThenTheGap {
		if(this.getIntelligence() < Math.max(this.getStrength(), this.getDexterity()) + GAP) throw new IllegalAptitudeValueIsLessThenTheGap();
		
	}

	private void validateConcentrationValueIsEqualsTheGapValueWithDexterityOrStrenght() throws IllegalAptitudeValueIsLessThenTheGap {
		if(this.getConcentration() < Math.max(this.getStrength(), this.getDexterity()) + GAP) throw new IllegalAptitudeValueIsLessThenTheGap();
		
	}

	@Override
	public int getNbOfHp() {
		// TODO Auto-generated method stub
		return this.numberOfHp;
	}





}
