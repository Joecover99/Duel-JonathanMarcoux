package implementation.fighter;

import abstracts.fighter.IAptitude;
import exception.fighter.IllegalAptitudeLevelIsLessThenMinLevelForAthlete;

//import exception.fighter.IllegalAptitudeLevelException;

//import Employee.src.implementation.employee.IllegalInitialSalaryException;

public class Athlete extends Fighter{
	public final static int MINIMAL_LEVEL = 20;
	
	public Athlete(String name, int numberOfHp, IAptitude aptitude) throws IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
		super(name, numberOfHp, aptitude);
		this.validateAthleteAptitude();
	}
	
	@Override
	public int getStrength() {
		return this.aptitude.getStrength();
	}

	private void validateAthleteAptitude() throws IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
		this.validateAptitudeLevelIsOverMinLevelrequired();
	}
	
	private void validateAptitudeLevelIsOverMinLevelrequired() throws IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
		if(aptitude.getStrength() < MINIMAL_LEVEL) throw new IllegalAptitudeLevelIsLessThenMinLevelForAthlete();
		
		if(aptitude.getDexterity() < MINIMAL_LEVEL) throw new IllegalAptitudeLevelIsLessThenMinLevelForAthlete();
		
		if(aptitude.getIntelligence() < MINIMAL_LEVEL) throw new IllegalAptitudeLevelIsLessThenMinLevelForAthlete();
		
		if(aptitude.getConcentration() < MINIMAL_LEVEL) throw new IllegalAptitudeLevelIsLessThenMinLevelForAthlete();	
	}
	

}
