package exception.fighter;

import implementation.fighter.Fighter;

public class IllegalConcentrationValueIsEqualOrOverMaxTotal extends Exception {
	public static final String CONCENTRATION_OVER_MAX = "Concentration must be equal or under " + Fighter.MAX_CONCENTRATION;
}
