package Skill.fighter;

import abstracts.fighter.ISkill;
import exception.fighter.IllegalSkillValueException;

public abstract class Skill implements ISkill{
	public final int MAX_CAPACITY_VALUE = 100;
	public final int MIN_CAPACITY_VALUE = 20;
	
	private int skillValue;
	private String name;
	
	public Skill(int skillValue, String name) {
		validateSkillValue(skillValue);
		this.skillValue = skillValue;
		this.name = name;
	}

	private void validateSkillValue(int skillValue) {
		if(skillValue < MIN_CAPACITY_VALUE) throw new IllegalSkillValueException(IllegalSkillValueException.TOO_LOW_SKILL_VALUE);
		if(skillValue > MAX_CAPACITY_VALUE) throw new IllegalSkillValueException(IllegalSkillValueException.TOO_HIGH_SKILL_VALUE);
	}
	
	public int getSkillValue() {
		return this.skillValue;
	}
	
	public String getName() {
		return this.name;
	}
}
