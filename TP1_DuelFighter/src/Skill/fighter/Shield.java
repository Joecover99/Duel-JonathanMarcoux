package Skill.fighter;

import abstracts.fighter.IFighter;
import abstracts.fighter.IParry;
import abstracts.fighter.ISkill;

public class Shield extends Skill implements ISkill, IParry{

	public Shield(int protection, String name){
		super(protection, name);
	}
	
	public int getParryPower(IFighter fighter) {
		return (this.getSkillValue() * fighter.getStrength() / 100);
	}
	
	public int getPower(IFighter fighter) {
		return getParryPower(fighter);
	}

}
