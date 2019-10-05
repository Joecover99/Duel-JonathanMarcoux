package exception.fighter;

public class IllegalSkillValueException extends IllegalArgumentException {

	public static final String TOO_HIGH_SKILL_VALUE = "The value of the skill must be lower than 100";
	public static final String TOO_LOW_SKILL_VALUE = "The value of the skill must be higher than 20";

	public IllegalSkillValueException(String s) {
		super(s);
	}
}
