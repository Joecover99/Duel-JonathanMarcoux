package spy;

import abstracts.fighter.ISkill;
import implementation.fighter.Fighter;

public class FighterSpy extends Fighter {
	
	public static boolean duelWinIsCalled = false;
	public static boolean duelLostIsCalled = false;
	public static boolean healIsCalled = false;
	
	public FighterSpy(String name, int strength, int dexterity, int intelligence, int concentration, ISkill skill1, ISkill skill2) {
		super(name, strength, dexterity, intelligence, concentration, skill1, skill2);
	}
	
	
	@Override
	public void duelWin() {
		duelWinIsCalled = true;
		
	}
	
	@Override
	public void duelLost() {
		duelLostIsCalled = true;
	}
	
	@Override
	public void heal(ISkill healingSkill) {
		healIsCalled = true;
	}

}
