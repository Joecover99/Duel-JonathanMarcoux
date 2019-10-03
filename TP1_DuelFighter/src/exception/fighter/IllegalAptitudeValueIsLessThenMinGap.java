package exception.fighter;

import implementation.fighter.Fighter;
import implementation.fighter.Warrior;

public class IllegalAptitudeValueIsLessThenMinGap extends Exception {
	public static final String VALUE_BETWEEN_GAP_UNDER_MIN_GAP = "Gap must be equal or over " + Warrior.MINIMAL_GAP;
}
