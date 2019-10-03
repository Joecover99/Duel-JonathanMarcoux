package exception.fighter;

import implementation.fighter.Fighter;

public class IllegalDexterityValueIsEqualOrUnderZero extends Exception {
	public static final String DEXTERITY_UNDER_OR_EQUAL_ZERO = "Dexterity must be equal or over " + Fighter.MIN_DEXTERITY;
}
