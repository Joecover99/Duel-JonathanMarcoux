package implementation.fighter;

import java.util.ArrayList;

import abstracts.fighter.ISkill;
import exception.fighter.IllegalAbilityValueException;


public class Mage extends Fighter{

	public final static int GAP = 15;
	
	public Mage(String name, int strength, int dexterity, int intelligence, int concentration, ISkill skill1, ISkill skill2) {
		super(name, strength, dexterity, intelligence, concentration, skill1, skill2);
		this.validateMageAbility(strength, dexterity, intelligence, concentration);
	}

	public void validateMageAbility(int strength, int dexterity, int intelligence, int concentration){
		if(intelligence < (Math.max(strength, dexterity) + 15) || concentration < (Math.max(strength, dexterity) + 15)) throw new IllegalAbilityValueException(IllegalAbilityValueException.WRONG_MAGICIEN_STATS);
	}
}
