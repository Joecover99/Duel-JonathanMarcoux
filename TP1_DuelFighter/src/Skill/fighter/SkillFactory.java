package Skill.fighter;

import abstracts.fighter.ISkill;
import exception.fighter.IllegalSkillTypeException;

public class SkillFactory {

	public enum SkillType{
		Sword,
		Shield,
		OffensiveSpell,
		DefensiveSpell,
		HealingSpell,
		Remedy
	}

	public static ISkill SkillCreator(SkillType skillType, int skillValue, String name) {
		switch (skillType) {
			case Sword : 
				return new Sword(skillValue, name);
				
			case Shield : 
				return new Shield(skillValue, name);
				
			case OffensiveSpell :
				return new OffensiveSpell(skillValue, name);
				
			case DefensiveSpell :
				return new DefensiveSpell(skillValue, name);
				
			case HealingSpell :
				return new HealingSpell(skillValue, name);
				
			case Remedy :
				return new Remedy(skillValue, name);
				
			default :
				throw new IllegalSkillTypeException(IllegalSkillTypeException.WRONG_SKILL_TYPE);
		}
	}
}
