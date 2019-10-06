package implementation.fighter;

import abstracts.fighter.IFighter;
import abstracts.fighter.ISkill;
import exception.fighter.IllegalFighterTypeException;

public class FighterFactory {

		public enum FighterType{
			Athlete,
			 Mage,
			Warrior,
		}
		
		public static IFighter FighterCreator(FighterType fighterType, String name, int strength, int dexterity, int intelligence, int concentration, ISkill skill1, ISkill skill2) {
			switch (fighterType) {
				case Athlete : 
					return new Athlete(name, strength, dexterity, intelligence, concentration, skill1, skill2);
					
				case  Mage : 
					return new Mage(name, strength, dexterity, intelligence, concentration, skill1, skill2);
				
				case Warrior : 
					return new Warrior(name, strength, dexterity, intelligence, concentration, skill1, skill2);
					
				default :
					throw new IllegalFighterTypeException(IllegalFighterTypeException.WRONG_FIGHTER_TYPE);
					
			}
		}
}
