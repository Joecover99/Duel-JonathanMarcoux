package abstracts.fighter;

import abstracts.fighter.IFighter;

public interface ISkill {

	public int getSkillValue();
	
	public int getPower(IFighter fighter);
	
	public String getName();

}
