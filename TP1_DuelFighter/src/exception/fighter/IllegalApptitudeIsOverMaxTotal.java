package exception.fighter;

import implementation.fighter.Fighter;

public class IllegalApptitudeIsOverMaxTotal extends Exception {
	public static final String APTITUDE_OVER_MAX = "aptitude must be equal or under " + Fighter.MAX_APTITUDE;
}
