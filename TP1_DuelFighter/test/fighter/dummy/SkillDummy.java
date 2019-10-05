package dummy;

import Skill.fighter.Skill;
import abstracts.fighter.IFighter;
import abstracts.fighter.IParry;
import abstracts.fighter.ISkill;

public class SkillDummy extends Skill implements ISkill, IParry {

		public SkillDummy(int skillValue, String name) {
			super(skillValue, name);
		}

		@Override
		public int getPower(IFighter fighter) {
			return 0;
		}

		@Override
		public int getParryPower(IFighter fighter) {
			return 0;
		}
}
