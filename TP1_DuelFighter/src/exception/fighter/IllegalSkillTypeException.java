package exception.fighter;

public class IllegalSkillTypeException extends IllegalArgumentException {
	
	public static final String WRONG_SKILL_TYPE = "There is no valid skill type selected";
	
	public IllegalSkillTypeException(String s) {
		super(s);
	}
	
}
