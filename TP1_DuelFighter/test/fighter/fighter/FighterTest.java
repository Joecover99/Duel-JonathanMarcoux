package fighter;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Skill.fighter.SkillFactory;
import Skill.fighter.SkillFactory.SkillType;
import abstracts.fighter.IFighter;
import abstracts.fighter.ISkill;
import duel.fighter.Duel;
import dummy.SkillDummy;
import exception.fighter.IllegalAbilityValueException;
import exception.fighter.IllegalAttackSkillException;
import exception.fighter.IllegalSkillValueException;
import exception.fighter.illegalHealSkillExeption;
import implementation.fighter.FighterFactory;
import implementation.fighter.FighterFactory.FighterType;
import spy.FighterSpy;
import stub.FighterStubs;


public class FighterTest {
	
//Fighter
	public static final String ANY_WARRIOR_NAME = "joecover99";
	public static final int ANY_WARRIOR_STRENGTH = 40;
	public static final int ANY_WARRIOR_DEXTERITY = 30;
	public static final int ANY_WARRIOR_INTELLIGENCE = 20;
	public static final int ANY_WARRIOR_CONCENTRATION = 10;
	
	
	public static final String ANY_ATHLETE_NAME = "joecover";
	public static final int ANY_ATHLETE_STRENGTH = 30;
	public static final int ANY_ATHLETE_DEXTERITY = 23;
	public static final int ANY_ATHLETE_INTELLIGENCE = 22;
	public static final int ANY_ATHLETE_CONCENTRATION = 25;
	
	public static final String ANY_MAGE_NAME = "joe";
	public static final int ANY_MAGE_STRENGTH = 10;
	public static final int ANY_MAGE_DEXTERITY = 12;
	public static final int ANY_MAGE_INTELLIGENCE = 38;
	public static final int ANY_MAGE_CONCENTRATION = 40;
	
	public static final int WRONG_STRENGTH_VALUE = 115;
	public static final int WRONG_WARRIOR_VALUE = 25;
	public static final int WRONG_ATHLETE_VALUE = 19;
	public static final int WRONG_MAGE_VALUE = 15;
	
	public static final int WRONG_BASE_SKILL_VALUE = -2;
	
	public static final int ANY_SKILL_VALUE = 45;
	public static final String ANY_SKILL_NAME = "run";
	
//Skill
	public static final String SWORD_SKILL_NAME = "Sword";
	public static final String SHIELD_SKILL_NAME = "Shield";
	public static final String OFFENSIVE_SPELL_SKILL_NAME = "OffensiveSpell";
	public static final String DEFENSIVE_SPELL_SKILL_NAME = "DefensiveSpell";
	public static final String HEALING_SPELL_SKILL_NAME = "HealingSpell";
	public static final String REMEDY_SKILL_NAME = "Remedy";
	
	public static final int SPELL_MULTIPLIER = 3;
	
	public static final int TOO_LOW_SKILL_VALUE = 15;
	public static final int TOO_HIGH_SKILL_VALUE = 115;
	
	public static final String FIGHTER_STUBS_NAME = "JoCauveur";
	public static final int FIGHTER_STUBS_STRENGTH = 10;
	public static final int FIGHTER_STUBS_DEXTERITY = 12;
	public static final int FIGHTER_STUBS_INTELLIGENCE = 38;
	public static final int FIGHTER_STUBS_CONCENTRATION = 40;
	
	
//Duel
    public static final FighterType fighterType = FighterType.Athlete;
    public static final String DUMMY_FIGHTER_NAME = "JoCauveur";
    public static final int DUMMY_FIGHTER_FORCE = 20;
    public static final int DUMMY_FIGHTER_DEXTERITE = 20;
    public static final int DUMMY_FIGHTER_INTELLIGENCE = 20;
    public static final int DUMMY_FIGHTER_CONCENTRATION = 20;

    public static final SkillType skillType = SkillFactory.SkillType.Sword;
    public static final int SKILL_EFFICIENCY = 45;
    public static final int STRONGER_SKILL_VALUE = 65;
    public static final int EQUAL_SKILL_VALUE = 45;
    public static final String SKILL_NAME = "noob";

    public static final boolean SURRENDER = false;
	
//Fighter
	private IFighter newWarriorFighter;
	private IFighter newAthleteFighter;
	private IFighter newMageFighter;
	private ISkill skillDummy1;
	private ISkill skillDummy2;
	private ISkill skillDummy3;
	private ArrayList<ISkill> expectedSkillList = new ArrayList<ISkill>();
	
//Skill
	private ISkill newSword;
	private ISkill newShield;
	private ISkill newOffensiveSpell;
	private ISkill newDefensiveSpell;
	private ISkill newHealingSpell;
	private ISkill newRemedy;
	private IFighter fighterStubs;
	
//Duel   
    private ISkill skill1;
    private ISkill skill2;
    private ISkill strongerSkill;
    public ISkill equalSkill;
    private IFighter fighter1;
    private IFighter fighter2;
    private FighterSpy fighterSpyWinner;
    private FighterSpy fighterSpyLoser;
    
//Infirmary
	private FighterSpy fighterSpy;

//Fighter
	@Before
	public void setUpFighter() {
		skillDummy1 = new SkillDummy(ANY_SKILL_VALUE, ANY_SKILL_NAME);
		skillDummy2 = new SkillDummy(ANY_SKILL_VALUE, ANY_SKILL_NAME);
		skillDummy3 = new SkillDummy(ANY_SKILL_VALUE, ANY_SKILL_NAME); //MS il faut utiliser un Mock pour tester la classe abstraite
		newWarriorFighter = FighterFactory.FighterCreator(FighterType.Warrior, ANY_WARRIOR_NAME, ANY_WARRIOR_STRENGTH, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skillDummy1, skillDummy2);
		newAthleteFighter = FighterFactory.FighterCreator(FighterType.Athlete, ANY_ATHLETE_NAME, ANY_ATHLETE_STRENGTH, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skillDummy1, skillDummy2);
		newMageFighter = FighterFactory.FighterCreator(FighterType.Mage, ANY_MAGE_NAME, ANY_MAGE_STRENGTH, ANY_MAGE_DEXTERITY, ANY_MAGE_INTELLIGENCE, ANY_MAGE_CONCENTRATION, skillDummy1, skillDummy2);
		expectedSkillList.add(skillDummy1);//MS La classe Fighter ne doit pas connaître l'existence de ses enfants. La classe de tests n'est pas indépendante.
		expectedSkillList.add(skillDummy2);
	}
	
//Skill
	@Before
	public void setUSkill(){
		newSword = SkillFactory.SkillCreator(SkillType.Sword, ANY_SKILL_VALUE, SWORD_SKILL_NAME);
		newShield = SkillFactory.SkillCreator(SkillType.Shield, ANY_SKILL_VALUE, SHIELD_SKILL_NAME);
		newOffensiveSpell = SkillFactory.SkillCreator(SkillType.OffensiveSpell, ANY_SKILL_VALUE, OFFENSIVE_SPELL_SKILL_NAME);
		newDefensiveSpell = SkillFactory.SkillCreator(SkillType.DefensiveSpell, ANY_SKILL_VALUE, DEFENSIVE_SPELL_SKILL_NAME);
		newHealingSpell = SkillFactory.SkillCreator(SkillType.HealingSpell, ANY_SKILL_VALUE, HEALING_SPELL_SKILL_NAME);
		newRemedy = SkillFactory.SkillCreator(SkillType.Remedy, ANY_SKILL_VALUE, REMEDY_SKILL_NAME);
		fighterStubs = new FighterStubs(FIGHTER_STUBS_NAME, FIGHTER_STUBS_STRENGTH, FIGHTER_STUBS_DEXTERITY, FIGHTER_STUBS_INTELLIGENCE, FIGHTER_STUBS_CONCENTRATION, newSword, newShield);
	}

//Duel
    @Before
    public void setUpDuel() {
    	skill1 = SkillFactory.SkillCreator(skillType, SKILL_EFFICIENCY,SKILL_NAME);
    	skill2 = SkillFactory.SkillCreator(SkillFactory.SkillType.HealingSpell, 21,"Weakor");
    	strongerSkill = SkillFactory.SkillCreator(skillType, STRONGER_SKILL_VALUE, SKILL_NAME);
    	equalSkill = SkillFactory.SkillCreator(skillType, EQUAL_SKILL_VALUE, SKILL_NAME);
        fighter1 =  FighterFactory.FighterCreator(fighterType,DUMMY_FIGHTER_NAME,DUMMY_FIGHTER_FORCE,DUMMY_FIGHTER_DEXTERITE,DUMMY_FIGHTER_INTELLIGENCE,DUMMY_FIGHTER_CONCENTRATION, skill1 , skill2);
        fighter2 =  FighterFactory.FighterCreator(fighterType,DUMMY_FIGHTER_NAME,DUMMY_FIGHTER_FORCE,DUMMY_FIGHTER_DEXTERITE,DUMMY_FIGHTER_INTELLIGENCE,DUMMY_FIGHTER_CONCENTRATION, skill1 , skill2);
        fighterSpyWinner =  new FighterSpy(DUMMY_FIGHTER_NAME,DUMMY_FIGHTER_FORCE,DUMMY_FIGHTER_DEXTERITE,DUMMY_FIGHTER_INTELLIGENCE,DUMMY_FIGHTER_CONCENTRATION, skill1 , skill2);
        fighterSpyLoser =  new FighterSpy(DUMMY_FIGHTER_NAME,DUMMY_FIGHTER_FORCE,DUMMY_FIGHTER_DEXTERITE,DUMMY_FIGHTER_INTELLIGENCE,DUMMY_FIGHTER_CONCENTRATION, skill1 , skill2);
    }
	
//Infirmary
	@Before
	public void setUp() {
		skillDummy1 = new SkillDummy(ANY_SKILL_VALUE, ANY_SKILL_NAME);
		skillDummy2 = new SkillDummy(ANY_SKILL_VALUE, ANY_SKILL_NAME);
		newHealingSpell = SkillFactory.SkillCreator(SkillType.HealingSpell, ANY_SKILL_VALUE, HEALING_SPELL_SKILL_NAME);
		fighterStubs = new FighterStubs(FIGHTER_STUBS_NAME, FIGHTER_STUBS_STRENGTH, FIGHTER_STUBS_DEXTERITY, FIGHTER_STUBS_INTELLIGENCE, FIGHTER_STUBS_CONCENTRATION, newHealingSpell, skillDummy2);
		fighterSpy = new FighterSpy(DUMMY_FIGHTER_NAME,DUMMY_FIGHTER_FORCE,DUMMY_FIGHTER_DEXTERITE,DUMMY_FIGHTER_INTELLIGENCE,DUMMY_FIGHTER_CONCENTRATION, skillDummy1 , skillDummy2);
	}
	
//Fighter
    
	@Test
	public void WHEN_CreateWarriorFighter_THEN_InitializeWarriorFighterIsReturned() {
		assertEquals(ANY_WARRIOR_NAME, newWarriorFighter.getName());
	}
	
	@Test
	public void WHEN_CreateAthleteFighter_THEN_InitializeAthleteFighterIsReturned() {
		assertEquals(ANY_ATHLETE_NAME, newAthleteFighter.getName());
	}
	
	@Test
	public void WHEN_CreateMageFighter_THEN_InitializeMageFighterIsReturned() {
		assertEquals(ANY_MAGE_NAME, newMageFighter.getName());
	}
	
	@Test
	public void WHEN_FighterIsAskHisStrength_THEN_HisStrengthIsReturned() {
		assertEquals(ANY_WARRIOR_STRENGTH, newWarriorFighter.getStrength());
	}
	
	@Test
	public void WHEN_FighterIsAskHisDexterity_THEN_HisDexterityIsReturned() {
		assertEquals(ANY_WARRIOR_DEXTERITY, newWarriorFighter.getDexterity());
	}
	
	@Test
	public void WHEN_FighterIsAskHisIntelligence_THEN_HisIntelligenceIsReturned() {
		assertEquals(ANY_WARRIOR_INTELLIGENCE, newWarriorFighter.getIntelligence());
	}
	
	@Test
	public void WHEN_FighterIsAskHisConcentration_THEN_HisConcentrationIsReturned() {
		assertEquals(ANY_WARRIOR_CONCENTRATION, newWarriorFighter.getConcentration());
	}
	
	@Test
	public void WHEN_FighterIsAskHisHealthPoints_THEN_HisHealthPointsIsReturned() {
		assertEquals((200 - (ANY_WARRIOR_STRENGTH + ANY_WARRIOR_DEXTERITY + ANY_WARRIOR_INTELLIGENCE+ ANY_WARRIOR_CONCENTRATION)), newWarriorFighter.getNumberOfHp());
	}
	
	@Test
	public void WHEN_FighterIsAskHisFirstSkill_THEN_HisFirstSkillIsReturned() {
		int index = 0;
		assertEquals(skillDummy1, newWarriorFighter.getSkill(index));
	}
	
	@Test
	public void WHEN_FighterIsAskHisSecondSkill_THEN_HisSecondSkillIsReturned() {
		int index = 1;
		assertEquals(skillDummy2, newWarriorFighter.getSkill(index));
	}
	
	@Test
	public void WHEN_FighterIsAskToAddASkill_THEN_ANAddASkillIsReturned() {
		newWarriorFighter.addSkill(skillDummy3);
		int index = 2;
		assertEquals(skillDummy3, newWarriorFighter.getSkill(index));
	}
	
	@Test
	public void WHEN_FighterIsAskForASkillName_THEN_ASkillNameIsReturned() {
		newWarriorFighter.addSkill(skillDummy3);
		assertEquals(ANY_SKILL_NAME, newWarriorFighter.getSkillName(skillDummy3));
	}
	
	@Test
	public void WHEN_FighterIsAskForASkillValue_THEN_ASkillValueIsReturned() {
		assertEquals(ANY_SKILL_VALUE, newWarriorFighter.getSkillValue(skillDummy2));
	}
	
	@Test
	public void WHEN_FighterIsAskForASkillList_THEN_ASkillListIsReturned() {
		assertEquals(expectedSkillList.size(), (newWarriorFighter.getSkillList()).size());
	}
	
//Rule Exception    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    

	@Test
	public void WHEN_WrongWarriorValueIsEnterred_THEN_IllegalArgumentExceptionIsRaised() {
		thrown.expect(IllegalAbilityValueException.class);
		thrown.expectMessage(IllegalAbilityValueException.WRONG_WARRIOR_STATS);
		
		FighterFactory.FighterCreator(FighterType.Warrior, ANY_WARRIOR_NAME, WRONG_WARRIOR_VALUE, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skillDummy1, skillDummy2);
	}
	
	@Test
	public void WHEN_WrongMageValueIsEnterred_THEN_IllegalArgumentExceptionIsRaised() {
		thrown.expect(IllegalAbilityValueException.class);
		thrown.expectMessage(IllegalAbilityValueException.WRONG_MAGE_STATS);
		
		FighterFactory.FighterCreator(FighterType.Mage, ANY_MAGE_NAME, ANY_MAGE_STRENGTH, ANY_MAGE_DEXTERITY, WRONG_MAGE_VALUE, ANY_MAGE_CONCENTRATION, skillDummy1, skillDummy2);
	}
	
	@Test
	public void WHEN_WrongAthleteValueIsEnterred_THEN_IllegalArgumentExceptionIsRaised() {
		thrown.expect(IllegalAbilityValueException.class);
		thrown.expectMessage(IllegalAbilityValueException.WRONG_ATHLETE_STATS);
		
		FighterFactory.FighterCreator(FighterType.Athlete, ANY_ATHLETE_NAME, WRONG_ATHLETE_VALUE, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skillDummy1, skillDummy2);
	}
	
	@Test
	public void WHEN_AttackSkillIsRequested_THEN_AttackSkillIsReturned() {
		thrown.expect(IllegalAttackSkillException.class);
		thrown.expectMessage(IllegalAttackSkillException.WRONG_SKILL_TYPE);
		
		newWarriorFighter.getAttackSkill(0);
	}
	
//Skills
	
	@Test
	public void WHEN_CreateNewSwordSkill_THEN_InitializeSwordSkillIsReturned() {
		assertEquals(SWORD_SKILL_NAME, newSword.getName());
	}
	
	@Test
	public void WHEN_CreateNewShieldSkill_THEN_InitializeShieldSkillIsReturned() {
		assertEquals(SHIELD_SKILL_NAME, newShield.getName());
	}
	
	@Test
	public void WHEN_CreateNewOffensiveSpellSkill_THEN_InitializeOffensiveSpellSkillIsReturned() {
		assertEquals(OFFENSIVE_SPELL_SKILL_NAME, newOffensiveSpell.getName());
	}
	
	@Test
	public void WHEN_CreateNewDefensiveSpellSkill_THEN_InitializeDefensiveSpellSkillIsReturned() {
		assertEquals(DEFENSIVE_SPELL_SKILL_NAME, newDefensiveSpell.getName());
	}
	
	@Test
	public void WHEN_CreateNewHealingSpellSkill_THEN_InitializeHealingSpellSkillIsReturned() {
		assertEquals(HEALING_SPELL_SKILL_NAME, newHealingSpell.getName());
	}
	
	@Test
	public void WHEN_CreateNewRemedySkill_THEN_InitializeRemedySkillIsReturned() {
		assertEquals(REMEDY_SKILL_NAME, newRemedy.getName());
	}
	
	@Test
	public void WHEN_CreateNewSkill_THEN_SkillWithSkillValueIsReturned() {
		assertEquals(ANY_SKILL_VALUE, newSword.getSkillValue());
	}
	
	@Test
	public void WHEN_SwordSkillIsAskedForAttackPower_THEN_AttackPowerIsReturn() {
		assertEquals(ANY_SKILL_VALUE * FIGHTER_STUBS_STRENGTH / 100, newSword.getPower(fighterStubs));
	}
	
	@Test
	public void WHEN_ShieldSkillIsAskedForAttackPower_THEN_AttackPowerIsReturn() {
		assertEquals(ANY_SKILL_VALUE * FIGHTER_STUBS_STRENGTH / 100, newShield.getPower(fighterStubs));
	}
	
	@Test
	public void WHEN_OffensiveSpellSkillIsAskedForAttackPower_THEN_AttackPowerIsReturn() {
		assertEquals((ANY_SKILL_VALUE * FIGHTER_STUBS_INTELLIGENCE / 100) * SPELL_MULTIPLIER, newOffensiveSpell.getPower(fighterStubs));
	}
	
	@Test
	public void WHEN_DefensiveSpellIsAskedForAttackPower_THEN_AttackPowerIsReturn() {
		assertEquals((ANY_SKILL_VALUE * FIGHTER_STUBS_INTELLIGENCE / 100) * SPELL_MULTIPLIER, newDefensiveSpell.getPower(fighterStubs));
	}
	
	@Test
	public void WHEN_HealingSpellSkillIsAskedForAttackPower_THEN_AttackPowerIsReturn() {
		assertEquals(ANY_SKILL_VALUE * FIGHTER_STUBS_CONCENTRATION / 100, newHealingSpell.getPower(fighterStubs));
	}
	
	@Test
	public void WHEN_RemedySkillIsAskedForAttackPower_THEN_AttackPowerIsReturn() {
		assertEquals(ANY_SKILL_VALUE * FIGHTER_STUBS_DEXTERITY / 100, newRemedy.getPower(fighterStubs));
	}
	
	@Test
	public void WHEN_TooLowSkillValueIsAsked_THEN_IllegalArgumentExceptionIsRaised() {
		thrown.expect(IllegalSkillValueException.class);
		thrown.expectMessage(IllegalSkillValueException.TOO_LOW_SKILL_VALUE);
		
		newSword = SkillFactory.SkillCreator(SkillType.Sword, TOO_LOW_SKILL_VALUE, SWORD_SKILL_NAME);
	}
	
	@Test
	public void WHEN_TooHighSkillValueIsAsked_THEN_IllegalArgumentExceptionIsRaised() {
		thrown.expect(IllegalSkillValueException.class);
		thrown.expectMessage(IllegalSkillValueException.TOO_HIGH_SKILL_VALUE);
		
		newSword = SkillFactory.SkillCreator(SkillType.Sword, TOO_HIGH_SKILL_VALUE, SWORD_SKILL_NAME);
	}
	
//Duel

    @Test
    public void WHEN_FightStartWithHealSkill_THEN_ThrowIllegalHealCapaciteException() {
        thrown.expect(illegalHealSkillExeption.class);
        thrown.expectMessage(illegalHealSkillExeption.HEAL_SKILL_DUEL);

        Duel duel = new Duel(fighter1, fighter2, fighter1.getSkill(0));
        duel.fight(fighter2.getSkill(1), SURRENDER);
    }

    @Test
    public void WHEN_DefenderSurrender_THEN_AttackerWin(){
        Duel duel = new Duel(fighter1, fighter2, fighter1.getSkill(0));
        boolean surrender = true;
        duel.fight(fighter2.getSkill(0), surrender);
        assertEquals(fighter1, duel.fightWinner);
    }
    
    @Test
    public void WHEN_DefenderFightBackWithEqualSkill_THEN_AttackerWin(){
        Duel duel = new Duel(fighter1, fighter2, fighter1.getSkill(0));
        boolean surrender = true;
        duel.fight(equalSkill, surrender);
        assertEquals(fighter1, duel.fightWinner);
    }
    
    @Test
    public void WHEN_DefenserFightBackWithWeakerSkill_THEN_DefenserLoseButDontLoseHealthPoints(){
        Duel duel = new Duel(fighter1, fighter2, fighter1.getSkill(0));
        boolean surrender = false;
        int newHealthValue = fighter2.getNumberOfHp() - 1 /*because he lost*/;
        duel.fight(equalSkill, surrender);
        assertEquals(newHealthValue, duel.fightLoser.getNumberOfHp());
    }
    
    @Test
    public void WHEN_DefenserFightBackWithWeakerSkill_THEN_AttackerWin(){
        Duel duel = new Duel(fighter1, fighter2, fighter1.getSkill(0));
        boolean surrender = false;
        duel.fight(fighter2.getSkill(0), surrender);
        assertEquals(fighter1, duel.fightWinner);
    }
    
    @Test
    public void WHEN_DefenserFightBackWithSkill_THEN_DefenserLoseAndLoseHealthPoints(){
        Duel duel = new Duel(fighter1, fighter2, fighter1.getSkill(0));
        boolean surrender = false;
        int newHealthValue = fighter2.getNumberOfHp() - (fighter1.getSkillPower(fighter1.getSkill(0)) - fighter2.getSkillPower(fighter2.getSkill(0))) - 1 /*because he lost*/;
        duel.fight(fighter2.getSkill(0), surrender);
        assertEquals(newHealthValue, duel.fightLoser.getNumberOfHp());
    }
    
    
    @Test
    public void WHEN_DefenserFightsBackAndWithFighterSkill_THEN_DefenderWin(){
        Duel duel = new Duel(fighter1, fighter2, fighter1.getSkill(0));
        boolean surrender = false;
        duel.fight(strongerSkill, surrender);
        assertEquals(fighter2, duel.fightWinner);
    }
    
    
    @Test
    public void WHEN_DefenserFightBackWithStrongerSkill_THEN_AttackerLoseAndLoseHealthPoints(){
        Duel duel = new Duel(fighter1, fighter2, fighter1.getSkill(0));
        boolean surrender = false;
        int newHealthValue = fighter1.getNumberOfHp() - (fighter2.getSkillPower(strongerSkill) - fighter1.getSkillPower(fighter1.getSkill(0))) - 1 /*because he lost*/;
        duel.fight(strongerSkill, surrender);
        assertEquals(newHealthValue, duel.fightLoser.getNumberOfHp());
    }
    
    @Test
    public void WHEN_DefenserFightBackWithAWeakerSkill_THEN_WinnerReceiveWinDuelBonus(){
        Duel duel = new Duel(fighterSpyWinner, fighter2, fighter1.getSkill(0));
        boolean surrender = false;
        boolean isCalled = true;
        duel.fight(fighter2.getSkill(0), surrender);
        assertEquals(isCalled, FighterSpy.duelWinIsCalled);
    }
    
    @Test
    public void WHEN_DefenserFightBackWithAWeakerSkill_THEN_LoserReceiveLostDuelBonus(){
        Duel duel = new Duel(fighter1, fighterSpyLoser, fighter1.getSkill(0));
        boolean surrender = false;
        boolean isCalled = true;
        duel.fight(fighterSpyLoser.getSkill(0), surrender);
        assertEquals(isCalled, FighterSpy.duelLostIsCalled);
    }
    
    @Test
    public void WHEN_DefenderFightBackWithWeakerSkill_THEN_AttackingFighterWinASkill() {
    	Duel duel = new Duel(fighter1, fighter2, fighter1.getSkill(0));
        boolean surrender = false;
        int newSkillCount = 3;
        duel.fight(fighter2.getSkill(0), surrender);
        assertEquals(newSkillCount, (duel.fightWinner.getSkillList()).size());
    }
    
//Infirmary

	@Test
	public void WHEN_HealIsCalled_THEN_HealFunctionIsCalled() {
		fighterSpy.heal(newHealingSpell);
		boolean isCalled = true;
		assertEquals(isCalled, spy.FighterSpy.healIsCalled);
	}
	
	@Test
	public void WHEN_HealIsCalled_THEN_FighterIsHeal() {
		fighterStubs.heal(newHealingSpell);
		int ExpectedHealPoints = 200 - FIGHTER_STUBS_STRENGTH - FIGHTER_STUBS_DEXTERITY - FIGHTER_STUBS_INTELLIGENCE - FIGHTER_STUBS_CONCENTRATION + newHealingSpell.getPower(fighterStubs);
		assertEquals(ExpectedHealPoints, FighterStubs.healthPoints);
	}
	
	@Test
	public void WHEN_HealIsCalled_THEN_HealingSkillIsRemovedFromSkillList() {
		fighterStubs.heal(newHealingSpell);
		int ExpectedArraySize = 1;
		assertEquals(ExpectedArraySize, (fighterStubs.getSkillList()).size());
	}
	
    
	
}