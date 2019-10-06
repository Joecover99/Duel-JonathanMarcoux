package exception.fighter;

	public class IllegalAbilityValueException extends IllegalArgumentException{
		public static final String WRONG_WARRIOR_STATS = "The stats you asked for are not valid for a warrior class";
		public static final String WRONG_BASE_STATS = "The stats you asked for are not valid for any class";
		public static final String WRONG_ATHLETE_STATS = "The stats you asked for are not valid for an athlete class";
		public static final String WRONG_MAGE_STATS = "The stats you asked for are not valid for a mage class";
		public static final String TOO_LOW_ABILITY_STATS = "The ability value can't be lower than zero";

		
		public IllegalAbilityValueException(String s) {
			super(s);
		}
		
	}
