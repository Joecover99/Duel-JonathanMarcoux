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
import dummy.SkillDummy;
import exception.fighter.IllegalAbilityValueException;
import exception.fighter.IllegalAttackSkillException;
import exception.fighter.IllegalSkillValueException;
import implementation.fighter.FighterFactory;
import implementation.fighter.FighterFactory.FighterType;
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
	
	private IFighter newWarriorFighter;
	private IFighter newAthleteFighter;
	private IFighter newMageFighter;
	private ISkill capacityDummy1;
	private ISkill capacityDummy2;
	private ISkill capacityDummy3;
	private ArrayList<ISkill> expectedCapacityList = new ArrayList<ISkill>();
	
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
	
	public static final String FIGHTER_STUBS_NAME = "bertrand";
	public static final int FIGHTER_STUBS_STRENGTH = 10;
	public static final int FIGHTER_STUBS_DEXTERITY = 12;
	public static final int FIGHTER_STUBS_INTELLIGENCE = 38;
	public static final int FIGHTER_STUBS_CONCENTRATION = 40;
	
	private ISkill newSword;
	private ISkill newShield;
	private ISkill newOffensiveSpell;
	private ISkill newDefensiveSpell;
	private ISkill newHealingSpell;
	private ISkill newRemedy;
	private IFighter fighterStubs;
	
	
	@Before
	public void setUpFighter() {
		capacityDummy1 = new SkillDummy(ANY_SKILL_VALUE, ANY_SKILL_NAME);
		capacityDummy2 = new SkillDummy(ANY_SKILL_VALUE, ANY_SKILL_NAME);
		capacityDummy3 = new SkillDummy(ANY_SKILL_VALUE, ANY_SKILL_NAME);
		newWarriorFighter = FighterFactory.FighterCreator(FighterType.Warrior, ANY_WARRIOR_NAME, ANY_WARRIOR_STRENGTH, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, capacityDummy1, capacityDummy2);
		newAthleteFighter = FighterFactory.FighterCreator(FighterType.Athlete, ANY_ATHLETE_NAME, ANY_ATHLETE_STRENGTH, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, capacityDummy1, capacityDummy2);
		newMageFighter = FighterFactory.FighterCreator(FighterType.Magicien, ANY_MAGE_NAME, ANY_MAGE_STRENGTH, ANY_MAGE_DEXTERITY, ANY_MAGE_INTELLIGENCE, ANY_MAGE_CONCENTRATION, capacityDummy1, capacityDummy2);
		expectedCapacityList.add(capacityDummy1);
		expectedCapacityList.add(capacityDummy2);
	}
	
	@Before
	public void setUpCapacity(){
		newSword = SkillFactory.SkillCreator(SkillType.Sword, ANY_SKILL_VALUE, SWORD_SKILL_NAME);
		newShield = SkillFactory.SkillCreator(SkillType.Shield, ANY_SKILL_VALUE, SHIELD_SKILL_NAME);
		newOffensiveSpell = SkillFactory.SkillCreator(SkillType.OffensiveSpell, ANY_SKILL_VALUE, OFFENSIVE_SPELL_SKILL_NAME);
		newDefensiveSpell = SkillFactory.SkillCreator(SkillType.DefensiveSpell, ANY_SKILL_VALUE, DEFENSIVE_SPELL_SKILL_NAME);
		newHealingSpell = SkillFactory.SkillCreator(SkillType.HealingSpell, ANY_SKILL_VALUE, HEALING_SPELL_SKILL_NAME);
		newRemedy = SkillFactory.SkillCreator(SkillType.Remedy, ANY_SKILL_VALUE, REMEDY_SKILL_NAME);
		fighterStubs = new FighterStubs(FIGHTER_STUBS_NAME, FIGHTER_STUBS_STRENGTH, FIGHTER_STUBS_DEXTERITY, FIGHTER_STUBS_INTELLIGENCE, FIGHTER_STUBS_CONCENTRATION, newSword, newShield);
	}

	
	@Test
	public void createWarriorFighter_shoudInitializeWarriorFighter() {
		assertEquals(ANY_WARRIOR_NAME, newWarriorFighter.getName());
	}
	
	@Test
	public void createAthleteFighter_shoudInitializeAthleteFighter() {
		assertEquals(ANY_ATHLETE_NAME, newAthleteFighter.getName());
	}
	
	@Test
	public void createMagicienFighter_shoudInitializeMagicienFighter() {
		assertEquals(ANY_MAGE_NAME, newMageFighter.getName());
	}
	
	@Test
	public void whenFighterIsAskHisStrength_thenShouldReturnHisStrength() {
		assertEquals(ANY_WARRIOR_STRENGTH, newWarriorFighter.getStrength());
	}
	
	@Test
	public void whenFighterIsAskHisDexterity_thenShouldReturnHisDexterity() {
		assertEquals(ANY_WARRIOR_DEXTERITY, newWarriorFighter.getDexterity());
	}
	
	@Test
	public void whenFighterIsAskHisIntelligence_thenShouldReturnHisIntelligence() {
		assertEquals(ANY_WARRIOR_INTELLIGENCE, newWarriorFighter.getIntelligence());
	}
	
	@Test
	public void whenFighterIsAskHisConcentration_thenShouldReturnHisConcentration() {
		assertEquals(ANY_WARRIOR_CONCENTRATION, newWarriorFighter.getConcentration());
	}
	
	@Test
	public void whenFighterIsAskHisHealthPoints_thenShouldReturnHisHealthPoints() {
		assertEquals((200 - (ANY_WARRIOR_STRENGTH + ANY_WARRIOR_DEXTERITY + ANY_WARRIOR_INTELLIGENCE+ ANY_WARRIOR_CONCENTRATION)), newWarriorFighter.getNumberOfHp());
	}
	
	@Test
	public void whenFighterIsAskHisFirstCapacity_thenShouldReturnHisFirstCapacity() {
		int index = 0;
		assertEquals(capacityDummy1, newWarriorFighter.getSkill(index));
	}
	
	@Test
	public void whenFighterIsAskHisSecondCapacity_thenShouldReturnHisSecondCapacity() {
		int index = 1;
		assertEquals(capacityDummy2, newWarriorFighter.getSkill(index));
	}
	
	@Test
	public void whenFighterIsAskToAddACapacity_thenShouldAddACapacity() {
		newWarriorFighter.addSkill(capacityDummy3);
		int index = 2;
		assertEquals(capacityDummy3, newWarriorFighter.getSkill(index));
	}
	
	@Test
	public void whenFighterIsAskForACapacityName_thenShouldReturnACapacityName() {
		newWarriorFighter.addSkill(capacityDummy3);
		assertEquals(ANY_SKILL_NAME, newWarriorFighter.getSkillName(capacityDummy3));
	}
	
	@Test
	public void whenFighterIsAskForACapacityValue_thenShouldReturnACapacityValue() {
		assertEquals(ANY_SKILL_VALUE, newWarriorFighter.getSkillValue(capacityDummy2));
	}
	
	@Test
	public void whenFighterIsAskForACapacityList_thenShouldReturnACapacityList() {
		assertEquals(expectedCapacityList.size(), (newWarriorFighter.getSkillList()).size());
	}
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void whenWrongWarriorValueIsEnterred_thenIllegalArgumentExceptionIsRaised() {
		thrown.expect(IllegalAbilityValueException.class);
		thrown.expectMessage(IllegalAbilityValueException.WRONG_WARRIOR_STATS);
		
		FighterFactory.FighterCreator(FighterType.Warrior, ANY_WARRIOR_NAME, WRONG_WARRIOR_VALUE, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, capacityDummy1, capacityDummy2);
	}
	
	@Test
	public void whenWrongMagicienValueIsEnterred_thenIllegalArgumentExceptionIsRaised() {
		thrown.expect(IllegalAbilityValueException.class);
		thrown.expectMessage(IllegalAbilityValueException.WRONG_MAGICIEN_STATS);
		
		FighterFactory.FighterCreator(FighterType.Magicien, ANY_MAGE_NAME, ANY_MAGE_STRENGTH, ANY_MAGE_DEXTERITY, WRONG_MAGE_VALUE, ANY_MAGE_CONCENTRATION, capacityDummy1, capacityDummy2);
	}
	
	@Test
	public void whenWrongAthleteValueIsEnterred_thenIllegalArgumentExceptionIsRaised() {
		thrown.expect(IllegalAbilityValueException.class);
		thrown.expectMessage(IllegalAbilityValueException.WRONG_ATHLETE_STATS);
		
		FighterFactory.FighterCreator(FighterType.Athlete, ANY_ATHLETE_NAME, WRONG_ATHLETE_VALUE, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, capacityDummy1, capacityDummy2);
	}
	
	@Test
	public void whenAttackCapacityIsRequested_thenAttackCapacityIsReturned() {
		thrown.expect(IllegalAttackSkillException.class);
		thrown.expectMessage(IllegalAttackSkillException.WRONG_SKILL_TYPE);
		
		newWarriorFighter.getAttackSkill(0);
	}
	
//Skills
	
	@Test
	public void createNewSwordCapacity_shouldInitializeSwordCapacity() {
		assertEquals(SWORD_SKILL_NAME, newSword.getName());
	}
	
	@Test
	public void createNewShieldCapacity_shouldInitializeShieldCapacity() {
		assertEquals(SHIELD_SKILL_NAME, newShield.getName());
	}
	
	@Test
	public void createNewOffensiveSpellCapacity_shouldInitializeOffensiveSpellCapacity() {
		assertEquals(OFFENSIVE_SPELL_SKILL_NAME, newOffensiveSpell.getName());
	}
	
	@Test
	public void createNewDefensiveSpellCapacity_shouldInitializeDefensiveSpellCapacity() {
		assertEquals(DEFENSIVE_SPELL_SKILL_NAME, newDefensiveSpell.getName());
	}
	
	@Test
	public void createNewHealingSpellCapacity_shouldInitializeHealingSpellCapacity() {
		assertEquals(HEALING_SPELL_SKILL_NAME, newHealingSpell.getName());
	}
	
	@Test
	public void createNewRemedyCapacity_shouldInitializeRemedyCapacity() {
		assertEquals(REMEDY_SKILL_NAME, newRemedy.getName());
	}
	
	@Test
	public void createNewCapacity_shouldCreateCapacityWithCapacityValue() {
		assertEquals(ANY_SKILL_VALUE, newSword.getSkillValue());
	}
	
	@Test
	public void whenSwordCapacityIsAskedForAttackPower_thenAttackPowerIsReturn() {
		assertEquals(ANY_SKILL_VALUE * FIGHTER_STUBS_STRENGTH / 100, newSword.getPower(fighterStubs));
	}
	
	@Test
	public void whenShieldCapacityIsAskedForAttackPower_thenAttackPowerIsReturn() {
		assertEquals(ANY_SKILL_VALUE * FIGHTER_STUBS_STRENGTH / 100, newShield.getPower(fighterStubs));
	}
	
	@Test
	public void whenOffensiveSpellCapacityIsAskedForAttackPower_thenAttackPowerIsReturn() {
		assertEquals((ANY_SKILL_VALUE * FIGHTER_STUBS_INTELLIGENCE / 100) * SPELL_MULTIPLIER, newOffensiveSpell.getPower(fighterStubs));
	}
	
	@Test
	public void whenDefensiveSpellIsAskedForAttackPower_thenAttackPowerIsReturn() {
		assertEquals((ANY_SKILL_VALUE * FIGHTER_STUBS_INTELLIGENCE / 100) * SPELL_MULTIPLIER, newDefensiveSpell.getPower(fighterStubs));
	}
	
	@Test
	public void whenHealingSpellCapacityIsAskedForAttackPower_thenAttackPowerIsReturn() {
		assertEquals(ANY_SKILL_VALUE * FIGHTER_STUBS_CONCENTRATION / 100, newHealingSpell.getPower(fighterStubs));
	}
	
	@Test
	public void whenRemedyCapacityIsAskedForAttackPower_thenAttackPowerIsReturn() {
		assertEquals(ANY_SKILL_VALUE * FIGHTER_STUBS_DEXTERITY / 100, newRemedy.getPower(fighterStubs));
	}
	
	@Test
	public void whenTooLowCapacityValueIsAsked_thenIllegalArgumentExceptionIsRaised() {
		thrown.expect(IllegalSkillValueException.class);
		thrown.expectMessage(IllegalSkillValueException.TOO_LOW_SKILL_VALUE);
		
		newSword = SkillFactory.SkillCreator(SkillType.Sword, TOO_LOW_SKILL_VALUE, SWORD_SKILL_NAME);
	}
	
	@Test
	public void whenTooHighCapacityValueIsAsked_thenIllegalArgumentExceptionIsRaised() {
		thrown.expect(IllegalSkillValueException.class);
		thrown.expectMessage(IllegalSkillValueException.TOO_HIGH_SKILL_VALUE);
		
		newSword = SkillFactory.SkillCreator(SkillType.Sword, TOO_HIGH_SKILL_VALUE, SWORD_SKILL_NAME);
	}


	
}