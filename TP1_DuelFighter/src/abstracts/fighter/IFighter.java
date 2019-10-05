package abstracts.fighter;

import java.util.ArrayList;

public interface IFighter {
	public String getName();
	
	public int getStrength();
	
	public int getDexterity();
	
	public int getIntelligence();
	
	public int getConcentration();
	
	public int getNumberOfHp();
	
	public ArrayList<ISkill> getSkillList();
	
	public ISkill getSkill(int index);
	
	public ISkill getAttackSkill(int index);
	
	public int getSkillPower(ISkill skill);
	
	public void heal(ISkill healingSkill);
	
	public void addSkill(ISkill skill);
	
	public String getSkillName(ISkill skill);
	
	public int getSkillValue(ISkill skill);
}

