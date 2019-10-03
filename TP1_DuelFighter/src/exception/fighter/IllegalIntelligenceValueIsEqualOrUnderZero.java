package exception.fighter;

import implementation.fighter.Fighter;

public class IllegalIntelligenceValueIsEqualOrUnderZero extends Exception {
	public static final String INTELLIGENCE_UNDER_OR_EQUAL_ZERO = "intelligence must be equal or over " + Fighter.MIN_INTELLIGENCE;
}
