package implementation.fighter;

<<<<<<< HEAD
import abstracts.fighter.IAptitude;
import exception.fighter.IllegalAptitudeValueIsLessThenMinGap;
=======
import exception.fighter.IllegalAptitudeLevelException;
import exception.fighter.IllegalArguementException;
>>>>>>> branch 'devop' of https://github.com/Joecover99/Duel-JonathanMarcoux.git

public class Warrior extends Fighter{
	public static int maxStrenght = 40;
	public static int maxConcentrationWarrior = 10;
<<<<<<< HEAD
	public final static int MINIMAL_GAP = 10;
=======
>>>>>>> branch 'devop' of https://github.com/Joecover99/Duel-JonathanMarcoux.git
	
	public Warrior(String name, int numberOfHp, int strenght, int dexterity, int intelligence, int concentration) throws IllegalAptitudeValueIsLessThenMinGap {
		super(name, numberOfHp, strenght, dexterity, intelligence, concentration);
		this.validateWarriorAptitude();
	}
	
	@Override
	public int getStrength() {
<<<<<<< HEAD
=======
		if(strenght >= maxStrenght) //throw new IllegalAptitudeLevelException(IllegalAptitudeLevelException.APTITUDE_LEVEL_TOO_LOW);
			{
			//throw new IllegalAptitudeLevelException(IllegalAptitudeLevelException.APTITUDE_LEVEL_TOO_LOW);
		}
>>>>>>> branch 'devop' of https://github.com/Joecover99/Duel-JonathanMarcoux.git
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
<<<<<<< HEAD
	private void validateDexterityValueIsAtLeastTheGapValueWithIntelligence()  throws IllegalAptitudeValueIsLessThenMinGap {
		if(aptitude.getDexterity() < aptitude.getIntelligence() + MINIMAL_GAP) throw new IllegalAptitudeValueIsLessThenMinGap();
		
=======
	
	public int getConcentration() {
		if(concentration >= maxConcentrationWarrior){
		return this.concentration;
		}
		return this.concentration;
>>>>>>> branch 'devop' of https://github.com/Joecover99/Duel-JonathanMarcoux.git
	}
	private void validateStrenghtValueIsAtLeastTheGapValueWithDexterity() throws IllegalAptitudeValueIsLessThenMinGap {
		if(aptitude.getStrength() < aptitude.getDexterity() + MINIMAL_GAP) throw new IllegalAptitudeValueIsLessThenMinGap(); 
	}


}
