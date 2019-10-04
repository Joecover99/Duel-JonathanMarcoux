package implementation.fighter;


import abstracts.fighter.ISkill;
import exception.fighter.IllegalAptitudeIsOverMaxTotal;
import exception.fighter.IllegalAptitudeLevelIsLessThenMinLevelForAthlete;
import exception.fighter.IllegalConcentrationValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalConcentrationValueIsEqualOrUnderZero;
import exception.fighter.IllegalDexterityValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalDexterityValueIsEqualOrUnderZero;
import exception.fighter.IllegalIntelligenceValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalIntelligenceValueIsEqualOrUnderZero;
import exception.fighter.IllegalStrenghtValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalStrenghtValueIsEqualOrUnderZero;

//import exception.fighter.IllegalAptitudeLevelException;

//import Employee.src.implementation.employee.IllegalInitialSalaryException;

public class Athlete extends Fighter{
	public final static int MINIMAL_LEVEL = 20;
	
	public Athlete(String name, int numberOfHp, int strenght, int dexterity, int intelligence, int concentration, ISkill skill1, ISkill skill2) throws IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
		super( name, numberOfHp, strenght, dexterity, intelligence, concentration, skill1, skill2);
		this.validateAthleteAptitude();
		validateAttribute(strenght, dexterity, intelligence, concentration);
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

	private void validateAthleteAptitude() throws IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
		this.validateAptitudeLevelIsOverMinLevelrequired();
	}
	
	private void validateAptitudeLevelIsOverMinLevelrequired() throws IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
		if(this.getStrength() < MINIMAL_LEVEL) throw new IllegalAptitudeLevelIsLessThenMinLevelForAthlete();
		
		if(this.getDexterity() < MINIMAL_LEVEL) throw new IllegalAptitudeLevelIsLessThenMinLevelForAthlete();
		
		if(this.getIntelligence() < MINIMAL_LEVEL) throw new IllegalAptitudeLevelIsLessThenMinLevelForAthlete();
		
		if(this.getConcentration() < MINIMAL_LEVEL) throw new IllegalAptitudeLevelIsLessThenMinLevelForAthlete();	
	}


	

}
