package implementation.fighter;

//import exception.fighter.IllegalAptitudeLevelException;

//import Employee.src.implementation.employee.IllegalInitialSalaryException;

public class Athlete extends Fighter{
	public final static int MINIMAL_LEVEL = 20;
	
	public Athlete(String name, int numberOfHp) {
		super(name, numberOfHp);
		// TODO Auto-generated constructor stub
	}
	//force >= 20 dextérité >= 20 intelligence >= 20 concentration >= 20 
	public int getStrength() {
		//if(strenght < 20) throw new IllegalAptitudeLevelException(IllegalAptitudeLevelException.APTITUDE_LEVEL_TOO_LOW);
		return this.aptitude.strenght;
	}
	
	public int getDexterity() {
		return this.aptitude.dexterity;
	}
	
	public int getIntelligence() {
		return this.aptitude.intelligence;
	}
	
	public int getConcentration() {
		return this.aptitude.concentration;
	}
}
