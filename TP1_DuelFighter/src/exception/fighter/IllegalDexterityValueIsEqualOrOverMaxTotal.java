package exception.fighter;

import implementation.fighter.Fighter;

public class IllegalDexterityValueIsEqualOrOverMaxTotal extends Exception {
	public static final String DEXTERITY_OVER_MAX = "Dexterity must be equal or under " + Fighter.MAX_DEXTERITY;
}
