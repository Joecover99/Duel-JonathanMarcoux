package abstracts.fighter;

import Skill.fighter.SkillFactory.SkillType;

public interface ISkillFactory {

	public ISkill SkillCreator(SkillType skillType, int skillValue);
}
