package Skill.fighter;

import abstracts.fighter.IAttack;
import abstracts.fighter.IFighter;
import abstracts.fighter.ISkill;


public class Sword extends Skill implements ISkill, IAttack{	
	
	public Sword(int impact, String name) {
		super(impact, name);
	}
	
	@Override
	public int getAttackPower(IFighter fighter) {
		return (this.getSkillValue() * fighter.getStrength() / 100);
	}
	
	public int getPower(IFighter fighter) {
		return getAttackPower(fighter);
	}

}
