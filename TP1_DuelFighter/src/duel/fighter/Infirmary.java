package duel.fighter;

import abstracts.fighter.IFighter;
import abstracts.fighter.IHeal;

public class Infirmary {
	private IFighter fighter;
	private IHeal healingSkill;
	
	public Infirmary(IFighter fighter, IHeal skill) {
		this.fighter = fighter;
		this.healingSkill = skill;
	}
	
	public void heal() {
		fighter.heal(healingSkill);
	}
}
