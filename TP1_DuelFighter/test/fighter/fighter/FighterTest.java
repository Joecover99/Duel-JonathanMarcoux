package fighter;

import static org.junit.Assert.*;

import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.fighter.ISkill;
import exception.fighter.IllegalAptitudeIsOverMaxTotal;
import exception.fighter.IllegalAptitudeLevelIsLessThenMinLevelForAthlete;
import exception.fighter.IllegalAptitudeValueIsLessThenMinGap;
import exception.fighter.IllegalAptitudeValueIsLessThenTheGap;
import exception.fighter.IllegalConcentrationValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalConcentrationValueIsEqualOrUnderZero;
import exception.fighter.IllegalDexterityValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalDexterityValueIsEqualOrUnderZero;
import exception.fighter.IllegalIntelligenceValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalIntelligenceValueIsEqualOrUnderZero;
import exception.fighter.IllegalStrenghtValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalStrenghtValueIsEqualOrUnderZero;
import implementation.fighter.Athlete;
import implementation.fighter.Fighter;
import implementation.fighter.Mage;
import implementation.fighter.Warrior;

public class FighterTest {

	private final int INITIAL_NUMBER_OF_HP = 200;
	private final String ANY_NAME = "joe";
	private final int ANY_NBOFHP = 200;
	
	private final int ANY_WARRIOR_STRENGHT = 31;
	private final int ANY_WARRIOR_DEXTERITY = 21;
	private final int ANY_WARRIOR_INTELLIGENCE = 11;
	private final int ANY_WARRIOR_CONCENTRATION = 1;
	
	private final int ANY_ATHLETE_STRENGHT = 21;
	private final int ANY_ATHLETE_DEXTERITY = 21;
	private final int ANY_ATHLETE_INTELLIGENCE = 21;
	private final int ANY_ATHLETE_CONCENTRATION = 21;
	final private int MIN_LEVEL_ATHLETE = 20;
	
	private final int ANY_MAGE_STRENGHT = 1;
	private final int ANY_MAGE_DEXTERITY = 1;
	private final int ANY_MAGE_INTELLIGENCE = 16;
	private final int ANY_MAGE_CONCENTRATION = 16;
	
	final private ISkill skill1 = null;
	final private ISkill skill2 = null;

	//final private int MAX_WARRIOR_STRENGHT = 31;
	

	//WARRIOR
	
	@Test
	public void When_FighterIsCreated_Then_NameIsInitialize() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrOverMaxTotal {

		//Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill2);
		//arrenge
		fighter.getName();
        //Assert
        String EXPECTED_NAME = ANY_NAME;
        assertEquals(EXPECTED_NAME,fighter.getName());  
	}
	
	@Test
	public void When_FighterIsCreated_Then_HpIsInitialize() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, INITIAL_NUMBER_OF_HP, ANY_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill2);

        //Assert
        int EXPECTED_HP = 136;
        assertEquals(EXPECTED_HP,fighter.getNbOfHp());  
	}
	
	@Test
	public void When_FighterIsCreated_Then_StrenghtIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill1);

		//act
		int actualStrenght = fighter.getStrength();
        //Assert
        int EXPECTED_STRENGHT = ANY_WARRIOR_STRENGHT;
        assertEquals(EXPECTED_STRENGHT,actualStrenght);  
	}
	
	@Test
	public void When_WarriorIsCreated_Then_MaxStrenghtIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		final int MAX_WARRIOR_STRENGHT = 40;
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, MAX_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill2);

		//act
		int actualStrenght = fighter.getStrength();
        //Assert
        int EXPECTED_STRENGHT = MAX_WARRIOR_STRENGHT;
        assertEquals(EXPECTED_STRENGHT,actualStrenght);  
	}
	
	@Test (expected = IllegalStrenghtValueIsEqualOrOverMaxTotal.class)
	public void When_WarriorIsCreated_Then_TooMuchStrenghtExceptionIsThrown() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		final int TOO_MUCH_STRENGHT = Warrior.maxStrenght + 1;
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, TOO_MUCH_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill2);

		//act
		fighter.getStrength();
	}
	
	@Test (expected = IllegalAptitudeValueIsLessThenMinGap.class)
	public void When_WarriorIsCreated_Then_TooMuchDexterityExceptionIsThrown() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY + 1, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill2);

		//act
		fighter.getDexterity();
	}
	
	@Test (expected = IllegalAptitudeValueIsLessThenMinGap.class)
	public void When_WarriorIsCreated_Then_TooMuchIntelligenceExceptionIsThrown() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE + 1, ANY_WARRIOR_CONCENTRATION, skill1, skill2);

		//act
		fighter.getStrength();
	}
	
	@Test (expected = IllegalAptitudeValueIsLessThenMinGap.class)
	public void When_WarriorIsCreated_Then_TooMuchConcentrationExceptionIsThrown() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION + 1, skill1, skill2);

		//act
		fighter.getConcentration();
	}
	
	@Test (expected = IllegalAptitudeValueIsLessThenMinGap.class)
	public void When_WarriorIsCreated_Then_StrenghtIsTooLowExceptionIsThrown() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_WARRIOR_STRENGHT - 1, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill2);

		//act
		fighter.getStrength();
	}
	
	//ATHLETE
	
	@Test
	public void When_AthleteIsCreated_Then_StrenghtIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getStrength();
		//assert
        int EXPECTED_STRENGHT = ANY_ATHLETE_STRENGHT;
        assertEquals(EXPECTED_STRENGHT,fighter.getStrength());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_DexterityIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getDexterity();
		//assert
        int EXPECTED_DEXTERITY = ANY_ATHLETE_DEXTERITY;
        assertEquals(EXPECTED_DEXTERITY,fighter.getDexterity());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_IntelligenceIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getIntelligence();
		//assert
        int EXPECTED_INTELLIGENCE = ANY_ATHLETE_INTELLIGENCE;
        assertEquals(EXPECTED_INTELLIGENCE,fighter.getIntelligence());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_ConcentrationIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getConcentration();
		//assert
        int EXPECTED_CONCENTRATION = ANY_ATHLETE_CONCENTRATION;
        assertEquals(EXPECTED_CONCENTRATION,fighter.getConcentration());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_MinStrenghtIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, MIN_LEVEL_ATHLETE, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getStrength();
		//assert
        int EXPECTED_STRENGHT = MIN_LEVEL_ATHLETE;
        assertEquals(EXPECTED_STRENGHT,fighter.getStrength());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_MinDexterityIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, MIN_LEVEL_ATHLETE, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getDexterity();
		//assert
        int EXPECTED_DEXTERITY = MIN_LEVEL_ATHLETE;
        assertEquals(EXPECTED_DEXTERITY,fighter.getDexterity());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_MinIntelligenceIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, MIN_LEVEL_ATHLETE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getIntelligence();
		//assert
        int EXPECTED_INTELLIGENCE = MIN_LEVEL_ATHLETE;
        assertEquals(EXPECTED_INTELLIGENCE,fighter.getIntelligence());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_MinConcentrationIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, MIN_LEVEL_ATHLETE, skill1, skill2);

		//act
		fighter.getConcentration();
		//assert
        int EXPECTED_CONCENTRATION = MIN_LEVEL_ATHLETE;
        assertEquals(EXPECTED_CONCENTRATION,fighter.getConcentration());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_MaxAhleteIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		int strenght = 25;
		int dexterity = 25;
		int intelligence = 25;
		int concentration = 25;
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, strenght, dexterity, intelligence, concentration, skill1, skill2);

		//act
		fighter.getConcentration();
		//assert
        int EXPECTED_CONCENTRATION = concentration;
        assertEquals(EXPECTED_CONCENTRATION,fighter.getConcentration());  
	}
	
	@Test(expected = IllegalAptitudeLevelIsLessThenMinLevelForAthlete.class)
	public void When_AthleteIsCreated_Then_TooLowStrenghtIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, 19, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getStrength();
	}
	
	@Test(expected = IllegalAptitudeLevelIsLessThenMinLevelForAthlete.class)
	public void When_AthleteIsCreated_Then_TooLowDexterityIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, 19, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getDexterity();
	}
	
	@Test(expected = IllegalAptitudeLevelIsLessThenMinLevelForAthlete.class)
	public void When_AthleteIsCreated_Then_TooLowIntelligenceIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, 19, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getIntelligence();
	}
	
	@Test (expected = IllegalAptitudeLevelIsLessThenMinLevelForAthlete.class)
	public void When_AthleteIsCreated_Then_TooLowConcentrationIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, 19, skill1, skill2);

		//act
		fighter.getConcentration();
	}
	
	@Test (expected = IllegalAptitudeIsOverMaxTotal.class)
	public void When_AthleteIsCreated_Then_TooHighLevelOverallConcentrationIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		int strenght = 25;
		int dexterity = 25;
		int intelligence = 26;
		int concentration = 25;
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, strenght, dexterity, intelligence, concentration, skill1, skill2);

		//act
		fighter.getIntelligence();
	}
	
	@Test
	public void When_MageIsCreated_Then_StrenghtIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalAptitudeValueIsLessThenTheGap, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Mage(ANY_NAME, ANY_NBOFHP, ANY_MAGE_STRENGHT, ANY_MAGE_DEXTERITY, ANY_MAGE_INTELLIGENCE, ANY_MAGE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getStrength();
		//assert
        int EXPECTED_STRENGHT = ANY_MAGE_STRENGHT;
        assertEquals(EXPECTED_STRENGHT,fighter.getStrength());  
	}
	
	//MAGE
	
	@Test
	public void When_MageIsCreated_Then_DexterityIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalAptitudeValueIsLessThenTheGap, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Mage(ANY_NAME, ANY_NBOFHP, ANY_MAGE_STRENGHT, ANY_MAGE_DEXTERITY, ANY_MAGE_INTELLIGENCE, ANY_MAGE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getDexterity();
		//assert
        int EXPECTED_DEXTERITY = ANY_MAGE_DEXTERITY;
        assertEquals(EXPECTED_DEXTERITY,fighter.getDexterity());  
	}
	
	@Test
	public void When_MageIsCreated_Then_IntelligenceIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalAptitudeValueIsLessThenTheGap, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Mage(ANY_NAME, ANY_NBOFHP, ANY_MAGE_STRENGHT, ANY_MAGE_DEXTERITY, ANY_MAGE_INTELLIGENCE, ANY_MAGE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getIntelligence();
		//assert
        int EXPECTED_INTELLIGENCE = ANY_MAGE_INTELLIGENCE;
        assertEquals(EXPECTED_INTELLIGENCE,fighter.getIntelligence());  
	}
	
	@Test
	public void When_MageIsCreated_Then_ConcentrationIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalAptitudeValueIsLessThenTheGap, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Mage(ANY_NAME, ANY_NBOFHP, ANY_MAGE_STRENGHT, ANY_MAGE_DEXTERITY, ANY_MAGE_INTELLIGENCE, ANY_MAGE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getConcentration();
		//assert
        int EXPECTED_CONCENTRATION = ANY_MAGE_CONCENTRATION;
        assertEquals(EXPECTED_CONCENTRATION,fighter.getConcentration());  
	}
	
	@Test
	public void When_MageIsCreatedWith1DiffrentStrenghtAndDexterity_Then_IntelligenceIsReturnedAdjustWithMaxStrenght() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalAptitudeValueIsLessThenTheGap, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Mage(ANY_NAME, ANY_NBOFHP, ANY_MAGE_STRENGHT + 1, ANY_MAGE_DEXTERITY, ANY_MAGE_INTELLIGENCE, ANY_MAGE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getConcentration();
		//assert
        int EXPECTED_INTELLIGENCE = ANY_MAGE_INTELLIGENCE + 1;
        assertEquals(EXPECTED_INTELLIGENCE,fighter.getIntelligence());  
	}
	
	@Test
	public void When_MageIsCreatedWith1DiffrentStrenghtAndDexterity_Then_ConcentrationIsReturnedAdjustWithMaxStrenght() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalAptitudeValueIsLessThenTheGap, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Mage(ANY_NAME, ANY_NBOFHP, ANY_MAGE_STRENGHT + 1, ANY_MAGE_DEXTERITY, ANY_MAGE_INTELLIGENCE, ANY_MAGE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getConcentration();
		//assert
        int EXPECTED_CONCENTRATION = ANY_MAGE_CONCENTRATION + 1;
        assertEquals(EXPECTED_CONCENTRATION,fighter.getConcentration());  
	}
	
	@Test
	public void When_MageIsCreatedWith1DiffrentStrenghtAndDexterity_Then_IntelligenceIsReturnedAdjustWithMaxDexterity() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalAptitudeValueIsLessThenTheGap, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Mage(ANY_NAME, ANY_NBOFHP, ANY_MAGE_STRENGHT, ANY_MAGE_DEXTERITY + 1, ANY_MAGE_INTELLIGENCE, ANY_MAGE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getConcentration();
		//assert
        int EXPECTED_INTELLIGENCE = ANY_MAGE_INTELLIGENCE + 1;
        assertEquals(EXPECTED_INTELLIGENCE,fighter.getIntelligence());  
	}
	
	@Test
	public void When_MageIsCreatedWith1DiffrentStrenghtAndDexterity_Then_ConcentrationIsReturnedAdjustWithMaxDexterity() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalAptitudeValueIsLessThenTheGap, IllegalIntelligenceValueIsEqualOrOverMaxTotal {
        //Arrange
		IFighter fighter = new Mage(ANY_NAME, ANY_NBOFHP, ANY_MAGE_STRENGHT, ANY_MAGE_DEXTERITY + 1, ANY_MAGE_INTELLIGENCE, ANY_MAGE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getConcentration();
		//assert
        int EXPECTED_CONCENTRATION = ANY_MAGE_CONCENTRATION + 1;
        assertEquals(EXPECTED_CONCENTRATION,fighter.getConcentration());  
	}
	
	/*@Test (expected = IllegalAptitudeValueIsLessThenTheGap.class)
	public void When_MageIsCreatedWithTooLowGap_Then_TooLowConcentrationIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal, IllegalAptitudeValueIsLessThenTheGap {
        //Arrange
		int IntelligenceLevelTooLow = 15;
		IFighter fighter = new Mage(ANY_NAME, ANY_NBOFHP, ANY_MAGE_STRENGHT, ANY_MAGE_DEXTERITY, 15, ANY_MAGE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getIntelligence();
	}
	
	@Test (expected = IllegalAptitudeValueIsLessThenTheGap.class)
	public void When_MageIsCreatedWithHighConcentrationGap_Then_TooLowConcentrationIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete, IllegalIntelligenceValueIsEqualOrOverMaxTotal, IllegalAptitudeValueIsLessThenTheGap {
        //Arrange
		int ConcentrationLevelTooLow = 15;
		IFighter fighter = new Mage(ANY_NAME, ANY_NBOFHP, ANY_MAGE_STRENGHT, ANY_MAGE_DEXTERITY, ANY_MAGE_INTELLIGENCE, 15, skill1, skill2);

		//act
		fighter.getConcentration();
	}*/
	

	
}