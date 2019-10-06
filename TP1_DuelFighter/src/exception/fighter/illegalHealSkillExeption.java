package exception.fighter;

public class illegalHealSkillExeption extends IllegalArgumentException {

    public static final String HEAL_SKILL_DUEL = "You can not use a healing skill in the duel";
	
	public illegalHealSkillExeption(String s) {
		super(s);
	}
}
