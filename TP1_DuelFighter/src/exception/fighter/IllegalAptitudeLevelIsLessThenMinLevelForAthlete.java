package exception.fighter;

import implementation.fighter.Athlete;
import implementation.fighter.Warrior;

public class IllegalAptitudeLevelIsLessThenMinLevelForAthlete extends Exception {
	public static final String ATHLETE_LEVEL_IS_TOO_LOW = "Athlete Level must be equal or over " + Athlete.MINIMAL_LEVEL;
}
