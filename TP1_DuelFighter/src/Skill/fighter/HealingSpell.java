package Skill.fighter;

import abstracts.fighter.IFighter;
import abstracts.fighter.IHeal;
import abstracts.fighter.ISkill;

public class HealingSpell extends Skill implements ISkill, IHeal {

	public HealingSpell(int spellEfficiency, String name){
		super(spellEfficiency, name);
	}
	
	public int getHealingPower(IFighter fighter ) {
		return (this.getSkillValue() * fighter.getConcentration() / 100);

	}
	
	public int getPower(IFighter fighter) {
		return getHealingPower(fighter);
	}
}
