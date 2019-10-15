package implementation.fighter;

import abstracts.fighter.ISkill;
import exception.fighter.IllegalAbilityValueException;

public class Athlete extends Fighter{
	public final int ATHLETE_STATS_STEP = 20;
	
	public Athlete(String name, int strength, int dexterity, int intelligence, int concentration, ISkill skill1, ISkill skill2) {
		super(name, strength, dexterity, intelligence, concentration, skill1, skill2);
		validateAthleteAbility(strength, dexterity, intelligence, concentration);
	}
	
	public void validateAthleteAbility(int strength, int dexterity, int intelligence, int concentration) {//MS La validation doit être private et appelée dans le constructeur.
		if(strength < ATHLETE_STATS_STEP || dexterity < ATHLETE_STATS_STEP || intelligence < ATHLETE_STATS_STEP || concentration < ATHLETE_STATS_STEP) throw new IllegalAbilityValueException(IllegalAbilityValueException.WRONG_ATHLETE_STATS);
	}



	

}
