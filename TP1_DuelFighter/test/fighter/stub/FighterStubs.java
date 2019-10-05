package stub;

import abstracts.fighter.ISkill;
import implementation.fighter.Fighter;

public class FighterStubs extends Fighter {
		
		public static int healthPoints;

		public FighterStubs(String name, int strength, int dexterity, int intelligence, int concentration, ISkill skill1, ISkill skill2) {
			super(name, strength, dexterity, intelligence, concentration, skill1, skill2);
			
		}
		
		public int healthPointsCalcul(int strength, int dexterity, int intelligence, int concentration) {
			int healthPoints;
			healthPoints = 200 - (strength + dexterity + intelligence + concentration);
			
			return healthPoints;
		}
		
		@Override
		public int getStrength() {
			return 10;
		}
		
		@Override
		public void heal(ISkill healingSkill) {
			int healingEffects = getSkillPower(healingSkill);
			healthPoints = healthPointsCalcul(this.getStrength(), this.getDexterity(), this.getIntelligence(), this.getConcentration());
			healthPoints += healingEffects;
			this.getSkillList().remove(healingSkill);
		}
		
}
