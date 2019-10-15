package Skill.fighter;

import abstracts.fighter.IFighter;
import abstracts.fighter.IParry;
import abstracts.fighter.ISkill;

public class DefensiveSpell extends Skill implements ISkill, IParry {//MS Pas besoin d'implémenter ISkill puisqu'elle hérite déjà de Skill.

	final int SPELL_MULTIPLIER = 3;
	
	public DefensiveSpell(int spellEfficiency, String name){
		super(spellEfficiency, name);
	}
	
	public int getParryPower(IFighter fighter) {//MS Pas utile ici, on aurait pu mettre le code dans getPower(). Sinon, il faut que ce soit private.
		return ((this.getSkillValue() * fighter.getIntelligence() / 100) * SPELL_MULTIPLIER);
	}
	
	public int getPower(IFighter fighter) {
		return getParryPower(fighter);
	}


}
