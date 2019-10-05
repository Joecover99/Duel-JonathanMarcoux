package Skill.fighter;

import abstracts.fighter.IFighter;
import abstracts.fighter.IHeal;
import abstracts.fighter.ISkill;

public class Remedy extends Skill implements ISkill, IHeal {

	public Remedy(int remedyEfficiency, String name){
		super(remedyEfficiency, name);
	}
	
	public int getHealingPower(IFighter fighter) {
		return (this.getSkillValue() * fighter.getDexterity() / 100);
	}
	
	public int getPower(IFighter fighter) {
		return getHealingPower(fighter);
	}


}
