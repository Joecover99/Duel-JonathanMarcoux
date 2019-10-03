package exception.fighter;

import implementation.fighter.Fighter;

public class IllegalStrenghtValueIsEqualOrUnderZero extends Exception {
	public static final String STRENGHT_UNDER_OR_EQUAL_ZERO = "Strenght must be equal or over " + Fighter.MIN_STRENGHT;
}
