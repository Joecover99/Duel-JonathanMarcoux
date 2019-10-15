package implementation.fighter;


import java.util.ArrayList;
import abstracts.fighter.IAttack;

import abstracts.fighter.IFighter;
import abstracts.fighter.ISkill;
import exception.fighter.IllegalAbilityValueException;
import exception.fighter.IllegalAttackSkillException;

public abstract class Fighter implements IFighter {//MS Attention la classe est abstraite, mais elle se retrouve dans le package "implementation"...
	
	public static int INITIAL_NUMBER_OF_HP = 200;
	private String name;
	protected int numberOfHp = 200;
	public int strength = 1;//MS POO1: On ne doit JAMAIS mettre une propriété public!
	public int dexterity = 1;
	public int intelligence = 1;
	int concentration = 1;//MS bien que la sécurité par défaut est "private", la bonne pratique est de le spécifier.
	private ArrayList<ISkill> skillList;

	public Fighter(String name, int strenght, int dexterity, int intelligence, int concentration, ISkill skill1, ISkill skill2) {
		this.name = name;
		this.strength = strenght;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.concentration = concentration;
		
		this.numberOfHp = CalculateInitialNbOfHp(strenght, dexterity, intelligence, concentration);
		
		this.skillList = new ArrayList<ISkill>();
		this.skillList.add(skill1);
		this.skillList.add(skill2);
	}

	public void validateAbility(int strength, int dexterity, int intelligence, int concentration) {//MS La validation doit être private et appelée dans le constructeur.
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
		return this.strength;
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
	
	public int getSkillPower(ISkill skill) {//MS Très bien.
		return skill.getPower(this);
	}
	
	public String getSkillName(ISkill skill) {
		return skill.getName();
	}
	//MS La classe utilisatrice ne doit pas utiliser les index de la liste. On lui passe une capacité et elle appelle une méthode pour valider qu'elle est présente.
	public ISkill getAttackSkill(int index){//MS Non, on doit utiliser le IAttack dans les paramètres de la méthode appelante.
		if(!(this.skillList.get(index) instanceof IAttack)) throw new IllegalAttackSkillException(IllegalAttackSkillException.WRONG_SKILL_TYPE);
		ISkill attackSkill = this.skillList.get(index);
		return attackSkill;
	}
	
	public void heal(ISkill healingSkill) {//MS Doit utiliser IHeal pour s'assurer d'avoir une capacité de soin.
		int healingEffects = getSkillPower(healingSkill);
		this.numberOfHp += healingEffects;
		this.skillList.remove(healingSkill);
	}
	
//Duel
	
	public void duelWin() {//MS Le duel doit indiquer l'incrément et appeler le fighter pour qu'il augmente chaque proprité par l'incrément.
		this.strength++;
		this.dexterity++;
		this.intelligence++;
		this.concentration++;
		this.numberOfHp++;
	}
	
	public void duelLost() {
		this.strength--;
		this.dexterity--;
		this.intelligence--;
		this.concentration--;
		this.numberOfHp--;
	}
	
	public void fightPenalty(int healthPenalty) {//MS La méthode devrait plutôt s'appeler increaseHealthPoints(int).
		this.numberOfHp = this.numberOfHp - healthPenalty;
	}
}
