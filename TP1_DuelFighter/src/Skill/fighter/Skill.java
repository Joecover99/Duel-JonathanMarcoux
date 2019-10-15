package Skill.fighter;

import abstracts.fighter.ISkill;
import exception.fighter.IllegalSkillValueException;

public abstract class Skill implements ISkill{//MS Attention la classe est abstraite, mais elle se retrouve dans le package "implementation"…
	public final int MAX_SKILL_VALUE = 100;
	public final int MIN_SKILL_VALUE = 20;
	
	private int skillValue; //MS La caractéristique est différente selon la capacité créée.
	private String name;//MS Pourquoi le name?
	
	public Skill(int skillValue, String name) {
		validateSkillValue(skillValue);
		this.skillValue = skillValue;
		this.name = name;
	}

	private void validateSkillValue(int skillValue) {
		if(skillValue < MIN_SKILL_VALUE) throw new IllegalSkillValueException(IllegalSkillValueException.TOO_LOW_SKILL_VALUE);
		if(skillValue > MAX_SKILL_VALUE) throw new IllegalSkillValueException(IllegalSkillValueException.TOO_HIGH_SKILL_VALUE);
	}
	
	public int getSkillValue() {
		return this.skillValue;
	}
	
	public String getName() {
		return this.name;
	}
}
