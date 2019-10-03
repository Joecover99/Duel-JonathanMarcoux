package exception.fighter;

import implementation.fighter.Mage;

public class IllegalAptitudeValueIsLessThenTheGap extends Exception {
	public static final String INTELLIGENCE_AND_CONCENTRATION_GAP_TOO_LOW = "Gap must be equal or over max streght or max dexterity " + Mage.GAP;
}
