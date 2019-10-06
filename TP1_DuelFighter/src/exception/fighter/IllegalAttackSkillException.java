package exception.fighter;

public class IllegalAttackSkillException extends IllegalArgumentException {

	public static final String WRONG_SKILL_TYPE = "You must use an attack skill to provoque someone in duel";
	
	public IllegalAttackSkillException(String s) {
		super(s);
	}
}
