package abstracts.fighter;

public interface IDuel {

	public void fight(ISkill defendingFighterSkill, boolean surrender);
	
	public void duelEnd(IFighter fightWinner, IFighter fightLoser, ISkill defendingFighterSkill);
}
