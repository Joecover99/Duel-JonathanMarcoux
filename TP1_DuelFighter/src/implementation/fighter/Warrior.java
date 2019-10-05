package implementation.fighter;

import abstracts.fighter.ISkill;
import exception.fighter.IllegalAbilityValueException;


public class Warrior extends Fighter{
	public final int WARRIOR_STATS_STEP = 10;
	
	public Warrior(String name, int strength, int dexterity, int intelligence, int concentration, ISkill skill1, ISkill skill2) {
		super(name, strength, dexterity, intelligence, concentration, skill1, skill2);
		validateWarriorAbility(strength, dexterity, intelligence, concentration);
	}
	
	public void validateWarriorAbility(int strength, int dexterity, int intelligence, int concentration){
		if(strength < (dexterity + WARRIOR_STATS_STEP) || (dexterity + WARRIOR_STATS_STEP) < (intelligence + WARRIOR_STATS_STEP) || (intelligence + WARRIOR_STATS_STEP) < concentration) throw new IllegalAbilityValueException(IllegalAbilityValueException.WRONG_WARRIOR_STATS);
	}
}