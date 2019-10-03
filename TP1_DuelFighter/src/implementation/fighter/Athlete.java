package implementation.fighter;

import abstracts.fighter.IAptitude;
import exception.fighter.IllegalAptitudeLevelIsLessThenMinLevelForAthlete;

//import exception.fighter.IllegalAptitudeLevelException;

//import Employee.src.implementation.employee.IllegalInitialSalaryException;

public class Athlete extends Fighter{
	public final static int MINIMAL_LEVEL = 20;
	
	public Athlete(String name, int numberOfHp, int strenght, int dexterity, int intelligence, int concentration) throws IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
		super( name, numberOfHp, strenght, dexterity, intelligence, concentration);
		this.validateAthleteAptitude();
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
		if(aptitude.getStrength() < MINIMAL_LEVEL) throw new IllegalAptitudeLevelIsLessThenMinLevelForAthlete();
		
		if(aptitude.getDexterity() < MINIMAL_LEVEL) throw new IllegalAptitudeLevelIsLessThenMinLevelForAthlete();
		
		if(aptitude.getIntelligence() < MINIMAL_LEVEL) throw new IllegalAptitudeLevelIsLessThenMinLevelForAthlete();
		
		if(aptitude.getConcentration() < MINIMAL_LEVEL) throw new IllegalAptitudeLevelIsLessThenMinLevelForAthlete();	
	}


	

}
