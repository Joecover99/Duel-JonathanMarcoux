package duel.fighter;

import abstracts.fighter.IFighter;
import abstracts.fighter.IHeal;

public class Infirmary {
	private IFighter fighter;
	private IHeal healingSkill;
	
	public Infirmary(IFighter fighter, IHeal skill) {//MS On crée l'infirmerie et ensuite on appelle heal(Ifighter, IHeal)
		this.fighter = fighter;
		this.healingSkill = skill;
	}
	
	public void heal() {
		fighter.heal(healingSkill);
	}
}
