package Skill.fighter;

import abstracts.fighter.IAttack;
import abstracts.fighter.IFighter;
import abstracts.fighter.ISkill;

public class OffensiveSpell extends Skill implements ISkill, IAttack {

	final int SPELL_MULTIPLIER = 3;
	
	public OffensiveSpell(int spellEfficiency, String name) {
		super(spellEfficiency, name);
	}
	
	public int getAttackPower(IFighter fighter) {
		return ((this.getSkillValue() * fighter.getIntelligence() / 100) * SPELL_MULTIPLIER);

	}
	
	public int getPower(IFighter fighter) {
		return getAttackPower(fighter);
	}

}
