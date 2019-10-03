package exception.fighter;

import implementation.fighter.Fighter;

public class IllegalStrenghtValueIsEqualOrOverMaxTotal extends Exception {
	public static final String STRENGHT_OVER_MAX = "Strenght must be equal or under " + Fighter.MAX_STRENGHT;
}
