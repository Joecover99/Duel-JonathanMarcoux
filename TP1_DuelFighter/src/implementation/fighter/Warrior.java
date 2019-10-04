package implementation.fighter;

import abstracts.fighter.IAptitude;
import abstracts.fighter.ISkill;
import exception.fighter.IllegalAptitudeIsOverMaxTotal;
import exception.fighter.IllegalAptitudeValueIsLessThenMinGap;
import exception.fighter.IllegalConcentrationValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalConcentrationValueIsEqualOrUnderZero;
import exception.fighter.IllegalDexterityValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalDexterityValueIsEqualOrUnderZero;
import exception.fighter.IllegalIntelligenceValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalIntelligenceValueIsEqualOrUnderZero;
import exception.fighter.IllegalStrenghtValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalStrenghtValueIsEqualOrUnderZero;

public class Warrior extends Fighter{
	public static int maxStrenght = 40;
	public static int maxConcentrationWarrior = 10;
	public final static int MINIMAL_GAP = 10;
	
	public Warrior(String name, int numberOfHp, int strenght, int dexterity, int intelligence, int concentration, ISkill skill1, ISkill skill2) throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
		super(name, numberOfHp, strenght, dexterity, intelligence, concentration, skill1, skill2);
		this.validateWarriorAptitude();
		validateAttribute(strenght, dexterity, intelligence, concentration);
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
		if(this.getIntelligence() < this.getConcentration() + MINIMAL_GAP){
			throw new IllegalAptitudeValueIsLessThenMinGap();
		}
	}
	private void validateDexterityValueIsAtLeastTheGapValueWithIntelligence() throws IllegalAptitudeValueIsLessThenMinGap {
		if(this.getDexterity() < this.getIntelligence() + MINIMAL_GAP){
			throw new IllegalAptitudeValueIsLessThenMinGap();
		}
	}
	private void validateStrenghtValueIsAtLeastTheGapValueWithDexterity() throws IllegalAptitudeValueIsLessThenMinGap {
		if(this.getStrength() < this.getDexterity() + MINIMAL_GAP) {
			throw new IllegalAptitudeValueIsLessThenMinGap(); 
		}
	}


}