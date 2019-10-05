package implementation.fighter;


import java.util.ArrayList;
import abstracts.fighter.IAttack;

import abstracts.fighter.IFighter;
import abstracts.fighter.ISkill;
import exception.fighter.IllegalAbilityValueException;
import exception.fighter.IllegalAttackSkillException;

public abstract class Fighter implements IFighter {
	
	public static int INITIAL_NUMBER_OF_HP = 200;
	private String name;
	protected int numberOfHp = 200;
	public int strenght = 1;
	public int dexterity = 1;
	public int intelligence = 1;
	int concentration = 1;
	private ArrayList<ISkill> skillList;

	public Fighter(String name, int strenght, int dexterity, int intelligence, int concentration, ISkill skill1, ISkill skill2) {
		this.name = name;
		this.strenght = strenght;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.concentration = concentration;
		
		this.numberOfHp = CalculateInitialNbOfHp(strenght, dexterity, intelligence, concentration);
		
		this.skillList = new ArrayList<ISkill>();
		this.skillList.add(skill1);
		this.skillList.add(skill2);
	}

	public void validateAbility(int strength, int dexterity, int intelligence, int concentration) {
		if((strength + dexterity + intelligence + concentration) > 100) throw new IllegalAbilityValueException(IllegalAbilityValueException.WRONG_BASE_STATS);
		if(strength < 0 || dexterity < 0 || intelligence < 0 || concentration < 0) throw new IllegalAbilityValueException(IllegalAbilityValueException.TOO_LOW_ABILITY_STATS);
	}
	
//Fighter
	
	public String getName() {
		return name;
	}
	
	public int getNumberOfHp() {
		return this.numberOfHp;
	}
	
	public int CalculateInitialNbOfHp(int strenght, int dexterity, int intelligence, int concentration){
		this.numberOfHp = INITIAL_NUMBER_OF_HP - (strenght + dexterity + intelligence + concentration);
		
		return numberOfHp;
	}
	
	public int getStrength() {
		return this.strenght;
	}
	
	public int getDexterity() {
		return this.dexterity;
	}
	
	public int getIntelligence() {
		return this.intelligence;
	}
	
	public int getConcentration() {
		return this.concentration;
	}
	
	//Skill
	
	public ArrayList<ISkill> getSkillList(){
		return this.skillList;
	}
	
	public void addSkill(ISkill skill){
		skillList.add(skill);
	}
	
	public void removeSkill(ISkill skill){
		skillList.remove(skill);
	}
	
	public ISkill getSkill(int index) {
		return this.skillList.get(index);
	}
	
	public int getSkillValue(ISkill skill) {
		return skill.getSkillValue();
	}
	
	public int getSkillPower(ISkill skill) {
		return skill.getPower(this);
	}
	
	public String getSkillName(ISkill skill) {
		return skill.getName();
	}
	
	public ISkill getAttackSkill(int index){
		if(!(this.skillList.get(index) instanceof IAttack)) throw new IllegalAttackSkillException(IllegalAttackSkillException.WRONG_SKILL_TYPE);
		ISkill attackCapacity = this.skillList.get(index);
		return attackCapacity;
	}
	
	public void heal(ISkill healingSkill) {
		int healingEffects = getSkillPower(healingSkill);
		this.numberOfHp += healingEffects;
		this.skillList.remove(healingSkill);
	}
}
