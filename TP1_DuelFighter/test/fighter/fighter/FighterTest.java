package fighter;

import static org.junit.Assert.*;

import org.junit.Test;

import abstracts.fighter.IFighter;
import abstracts.fighter.ISkill;
import exception.fighter.IllegalAptitudeIsOverMaxTotal;
import exception.fighter.IllegalAptitudeLevelIsLessThenMinLevelForAthlete;
import exception.fighter.IllegalAptitudeValueIsLessThenMinGap;
import exception.fighter.IllegalConcentrationValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalConcentrationValueIsEqualOrUnderZero;
import exception.fighter.IllegalDexterityValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalDexterityValueIsEqualOrUnderZero;
import exception.fighter.IllegalIntelligenceValueIsEqualOrUnderZero;
import exception.fighter.IllegalStrenghtValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalStrenghtValueIsEqualOrUnderZero;
import implementation.fighter.Athlete;
import implementation.fighter.Fighter;
import implementation.fighter.Mage;
import implementation.fighter.Warrior;

public class FighterTest {
	private static final String TOO_MUCH_STRENGHT = null;
	private static final int MAX_WARRIOR_STRENGHT = 40;
	private final int INITIAL_NUMBER_OF_HP = 200;
	final private String ANY_NAME = "joe";
	final private int ANY_NBOFHP = 200;
	final private int ANY_WARRIOR_STRENGHT = 31;
	final private int ANY_WARRIOR_DEXTERITY = 21;
	final private int ANY_WARRIOR_INTELLIGENCE = 11;
	final private int ANY_WARRIOR_CONCENTRATION = 1;
	final private int ANY_ATHLETE_STRENGHT = 21;
	final private int ANY_ATHLETE_DEXTERITY = 21;
	final private int ANY_ATHLETE_INTELLIGENCE = 21;
	final private int ANY_ATHLETE_CONCENTRATION = 21;
	final private ISkill skill1 = null;
	final private ISkill skill2 = null;
	final private int MIN_LEVEL_ATHLETE = 20;
	//final private int MAX_WARRIOR_STRENGHT = 31;

	@Test
	public void When_FighterIsCreated_Then_NameIsInitialize() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero {

		//Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill2);

        //Assert
        String EXPECTED_NAME = ANY_NAME;
        assertEquals(EXPECTED_NAME,fighter.getName());  
	}
	
	@Test
	public void When_FighterIsCreated_Then_HpIsInitialize() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero {
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, INITIAL_NUMBER_OF_HP, ANY_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill2);

        //Assert
        int EXPECTED_HP = 136;
        assertEquals(EXPECTED_HP,fighter.getNbOfHp());  
	}
	
	@Test
	public void When_FighterIsCreated_Then_StrenghtisReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero {
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill1);

		//act
		int actualStrenght = fighter.getStrength();
        //Assert
        int EXPECTED_STRENGHT = ANY_WARRIOR_STRENGHT;
        assertEquals(EXPECTED_STRENGHT,actualStrenght);  
	}
	
	@Test
	public void When_WarriorIsCreated_Then_MaxStrenghtisReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero {
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, MAX_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill2);

		//act
		int actualStrenght = fighter.getStrength();
        //Assert
        int EXPECTED_STRENGHT = MAX_WARRIOR_STRENGHT;
        assertEquals(EXPECTED_STRENGHT,actualStrenght);  
	}
	
	@Test (expected = IllegalStrenghtValueIsEqualOrOverMaxTotal.class)
	public void When_WarriorIsCreated_Then_TooMuchStrenghtExceptionisThrown() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero {
        //Arrange
		final int TOO_MUCH_STRENGHT = Warrior.maxStrenght + 1;
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, TOO_MUCH_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill2);

		//act
		fighter.getStrength();
	}
	
	@Test (expected = IllegalAptitudeValueIsLessThenMinGap.class)
	public void When_WarriorIsCreated_Then_TooMuchDexterityExceptionisThrown() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero {
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY + 1, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill2);

		//act
		fighter.getDexterity();
	}
	
	@Test (expected = IllegalAptitudeValueIsLessThenMinGap.class)
	public void When_WarriorIsCreated_Then_TooMuchIntelligenceExceptionisThrown() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero {
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE + 1, ANY_WARRIOR_CONCENTRATION, skill1, skill2);

		//act
		fighter.getStrength();
	}
	
	@Test (expected = IllegalAptitudeValueIsLessThenMinGap.class)
	public void When_WarriorIsCreated_Then_TooMuchConcentrationExceptionisThrown() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero {
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_WARRIOR_STRENGHT, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION + 1, skill1, skill2);

		//act
		fighter.getConcentration();
	}
	
	@Test (expected = IllegalAptitudeValueIsLessThenMinGap.class)
	public void When_WarriorIsCreated_Then_StrenghtIsTooLowExceptionisThrown() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero {
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_WARRIOR_STRENGHT - 1, ANY_WARRIOR_DEXTERITY, ANY_WARRIOR_INTELLIGENCE, ANY_WARRIOR_CONCENTRATION, skill1, skill2);

		//act
		fighter.getStrength();
	}
	
	@Test
	public void When_AthleteIsCreated_Then_StrenghtIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getStrength();
		//assert
        int EXPECTED_STRENGHT = ANY_ATHLETE_STRENGHT;
        assertEquals(EXPECTED_STRENGHT,fighter.getStrength());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_DexterityisReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getDexterity();
		//assert
        int EXPECTED_DEXTERITY = ANY_ATHLETE_DEXTERITY;
        assertEquals(EXPECTED_DEXTERITY,fighter.getDexterity());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_IntelligenceisReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getIntelligence();
		//assert
        int EXPECTED_INTELLIGENCE = ANY_ATHLETE_INTELLIGENCE;
        assertEquals(EXPECTED_INTELLIGENCE,fighter.getIntelligence());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_ConcentrationisReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getConcentration();
		//assert
        int EXPECTED_CONCENTRATION = ANY_ATHLETE_INTELLIGENCE;
        assertEquals(EXPECTED_CONCENTRATION,fighter.getConcentration());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_MinStrenghtIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, MIN_LEVEL_ATHLETE, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getStrength();
		//assert
        int EXPECTED_STRENGHT = MIN_LEVEL_ATHLETE;
        assertEquals(EXPECTED_STRENGHT,fighter.getStrength());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_MinDexterityisReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, MIN_LEVEL_ATHLETE, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getDexterity();
		//assert
        int EXPECTED_DEXTERITY = MIN_LEVEL_ATHLETE;
        assertEquals(EXPECTED_DEXTERITY,fighter.getDexterity());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_MinIntelligenceisReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, MIN_LEVEL_ATHLETE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getIntelligence();
		//assert
        int EXPECTED_INTELLIGENCE = MIN_LEVEL_ATHLETE;
        assertEquals(EXPECTED_INTELLIGENCE,fighter.getIntelligence());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_MinConcentrationisReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, MIN_LEVEL_ATHLETE, skill1, skill2);

		//act
		fighter.getConcentration();
		//assert
        int EXPECTED_CONCENTRATION = MIN_LEVEL_ATHLETE;
        assertEquals(EXPECTED_CONCENTRATION,fighter.getConcentration());  
	}
	
	@Test
	public void When_AthleteIsCreated_Then_MaxAhleteisReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
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
	public void When_AthleteIsCreated_Then_TooLowStrenghtIsReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, 19, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getStrength();
	}
	
	@Test(expected = IllegalAptitudeLevelIsLessThenMinLevelForAthlete.class)
	public void When_AthleteIsCreated_Then_TooLowDexterityisReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, 19, ANY_ATHLETE_INTELLIGENCE, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getDexterity();
	}
	
	@Test(expected = IllegalAptitudeLevelIsLessThenMinLevelForAthlete.class)
	public void When_AthleteIsCreated_Then_TooLowIntelligenceisReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, 19, ANY_ATHLETE_CONCENTRATION, skill1, skill2);

		//act
		fighter.getIntelligence();
	}
	
	@Test (expected = IllegalAptitudeLevelIsLessThenMinLevelForAthlete.class)
	public void When_AthleteIsCreated_Then_TooLowConcentrationisReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
        //Arrange
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, ANY_ATHLETE_STRENGHT, ANY_ATHLETE_DEXTERITY, ANY_ATHLETE_INTELLIGENCE, 19, skill1, skill2);

		//act
		fighter.getConcentration();
	}
	
	@Test (expected = IllegalAptitudeIsOverMaxTotal.class)
	public void When_AthleteIsCreated_Then_TooHighLevelOverallConcentrationisReturned() throws IllegalAptitudeValueIsLessThenMinGap, IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero, IllegalAptitudeLevelIsLessThenMinLevelForAthlete {
        //Arrange
		int strenght = 25;
		int dexterity = 25;
		int intelligence = 26;
		int concentration = 25;
		IFighter fighter = new Athlete(ANY_NAME, ANY_NBOFHP, strenght, dexterity, intelligence, concentration, skill1, skill2);

		//act
		fighter.getIntelligence();
	}
	
	
	
}