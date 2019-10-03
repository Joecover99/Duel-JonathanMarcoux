package exception.fighter;

import implementation.fighter.Fighter;

public class IllegalIntelligenceValueIsEqualOrOverMaxTotal extends Exception {
	public static final String INTELLIGENCE_OVER_MAX = "Intelligence must be equal or under " + Fighter.MAX_INTELLIGENCE;
}
