package exception.fighter;

public class IllegalAttackingSkillException extends IllegalArgumentException {

	public static final String OTHER_SKILL_DUEL = "You must use an attack skill to provoque someone in duel";
	
	public IllegalAttackingSkillException(String s) {
		super(s);
	}
}
