package exception.fighter;

import implementation.fighter.Fighter;

public class IllegalConcentrationValueIsEqualOrUnderZero extends Exception {
	public static final String CONCENTRATION_UNDER_OR_EQUAL_ZERO = "Concentration must be equal or over " + Fighter.MIN_CONCENTRATION;
}
