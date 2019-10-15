package duel.fighter;

import abstracts.fighter.IDuel;
import abstracts.fighter.IFighter;
import abstracts.fighter.IHeal;
import abstracts.fighter.IParry;
import abstracts.fighter.ISkill;
import exception.fighter.IllegalAttackingSkillException;
import exception.fighter.illegalHealSkillExeption;

public class Duel implements IDuel{
	
	private IFighter attackingFighter;
	private IFighter defendingFighter;
	private ISkill attackingFighterSkill;//MS devrait être un IAttack.
	public IFighter fightWinner;
	public IFighter fightLoser;
	
	public Duel(IFighter fighter1, IFighter fighter2, ISkill attackingFighterSkill) {//MS devrait être un IAttack.
		this.attackingFighter = fighter1;
		this.defendingFighter = fighter2;
		this.attackingFighterSkill = attackingFighterSkill;
		validateAttackingFighterSkill(attackingFighterSkill);
	}
	
	public void validateAttackingFighterSkill(ISkill attackingFighterSkill) {//MS Pas besoin si on demande un IAttack.
		if(attackingFighterSkill instanceof IParry || attackingFighterSkill instanceof IHeal) throw new IllegalAttackingSkillException(IllegalAttackingSkillException.OTHER_SKILL_DUEL);
	}
	
	public void fight(ISkill defendingFighterSkill, boolean surrender) {//MS beaucoup de code, on aurait pu séparer en plus petites méthodes.
		if(defendingFighterSkill instanceof IHeal) throw new illegalHealSkillExeption(illegalHealSkillExeption.HEAL_SKILL_DUEL);
    
		if(surrender) {
			fightWinner = attackingFighter;
			fightLoser = defendingFighter;
		} 
		else {
			int attackingFighterSkillPower = attackingFighter.getSkillPower(attackingFighterSkill);
			int defendingFighterSkillPower = defendingFighter.getSkillPower(defendingFighterSkill);
			if(attackingFighterSkillPower >= defendingFighterSkillPower) {
				fightWinner = attackingFighter;
				fightLoser = defendingFighter;
				defendingFighter.fightPenalty(attackingFighterSkillPower - defendingFighterSkillPower);
			}
			else {
				fightWinner = defendingFighter;
				fightLoser = attackingFighter;
				attackingFighter.fightPenalty(defendingFighterSkillPower - attackingFighterSkillPower);
			}
		}
		duelEnd(fightWinner, fightLoser, defendingFighterSkill);
		
	}
	
	public void duelEnd(IFighter fightWinner, IFighter fightLoser, ISkill defendingFighterSkill) {//MS le nom du ISkill porte à confusion.
		fightWinner.duelWin();
		fightWinner.addSkill(defendingFighterSkill);
		fightLoser.duelLost();//MS C'est Duel qui doit gérer la logique de la victoire/défaite et non le fighter.
	}

}
