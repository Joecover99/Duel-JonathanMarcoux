package fighter;

import static org.junit.Assert.*;

import org.junit.Test;

import abstracts.fighter.IFighter;
import exception.fighter.IllegalAptitudeValueIsLessThenMinGap;
import implementation.fighter.Athlete;
import implementation.fighter.Fighter;
import implementation.fighter.Mage;
import implementation.fighter.Warrior;

public class FighterTest {
	private static final String TOO_MUCH_STRENGHT = null;
<<<<<<< HEAD
	private static final int MAX_WARRIOR_STRENGHT = 40;
	private final int INITIAL_NUMBER_OF_HP = 200;
=======
>>>>>>> branch 'devop' of https://github.com/Joecover99/Duel-JonathanMarcoux.git
	final private String ANY_NAME = "joe";
	final private int ANY_NBOFHP = 200;
<<<<<<< HEAD
	final private int ANY_STRENGHT = 31;
	final private int ANY_DEXTERITY = 21;
	final private int ANY_INTELLIGENCE = 11;
	final private int ANY_CONCENTRATION = 1;
	//final private int MAX_WARRIOR_STRENGHT = 31;
=======
	final private int ANY_STRENGHT = 25;
	final private int MAX_WARRIOR_STRENGHT = 31;
>>>>>>> branch 'devop' of https://github.com/Joecover99/Duel-JonathanMarcoux.git

	@Test
	public void When_FighterIsCreated_Then_NameIsInitialize() throws IllegalAptitudeValueIsLessThenMinGap{
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_STRENGHT, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_CONCENTRATION);

        //Assert
        String EXPECTED_NAME = ANY_NAME;
        assertEquals(EXPECTED_NAME,fighter.getName());  
	}
	
	@Test
<<<<<<< HEAD
	public void When_FighterIsCreated_Then_HpIsInitialize() throws IllegalAptitudeValueIsLessThenMinGap{
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, INITIAL_NUMBER_OF_HP, ANY_STRENGHT, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_CONCENTRATION);

        //Assert
        int EXPECTED_HP = 200;
=======
	public void When_FighterIsCreated_Then_HpIsInitialize(){
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP);

        //Assert
        int EXPECTED_HP = ANY_NBOFHP;
>>>>>>> branch 'devop' of https://github.com/Joecover99/Duel-JonathanMarcoux.git
        assertEquals(EXPECTED_HP,fighter.getNbOfHp());  
	}
	
	@Test
	public void When_FighterIsCreated_Then_StrenghtisReturned() throws IllegalAptitudeValueIsLessThenMinGap{
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_STRENGHT, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_CONCENTRATION);

		//act
		int actualStrenght = fighter.getStrength();
        //Assert
        int EXPECTED_STRENGHT = ANY_STRENGHT;
        assertEquals(EXPECTED_STRENGHT,actualStrenght);  
	}
	
	@Test
	public void When_FighterIsCreated_Then_MaxStrenghtisReturned() throws IllegalAptitudeValueIsLessThenMinGap{
        //Arrange
		final int TOO_MUCH_STRENGHT = Warrior.maxStrenght + 1;
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, ANY_STRENGHT, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_CONCENTRATION);

		//act
		int actualStrenght = fighter.getStrength();
        //Assert
        int EXPECTED_STRENGHT = MAX_WARRIOR_STRENGHT;
        assertEquals(EXPECTED_STRENGHT,actualStrenght);  
	}
	
	@Test (expected = IllegalArgumentException.class)
<<<<<<< HEAD
	public void When_FighterIsCreated_Then_TooMuchStrenghtisReturned() throws IllegalAptitudeValueIsLessThenMinGap{
        //Arrange
		final int TOO_MUCH_STRENGHT = Warrior.maxStrenght + 1;
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP, TOO_MUCH_STRENGHT, ANY_DEXTERITY, ANY_INTELLIGENCE, ANY_CONCENTRATION);

		//act
		fighter.getStrength();
	}

=======
	public void When_FighterIsCreated_Then_TooMuchStrenghtisReturned(){
        //Arrange
		//final int TOO_MUCH_STRENGHT = Warrior.maxStrenght + 1;
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP);

		//act
		fighter.getStrength();
	}
	/*@Test (expected = RuntimeException.class)
	public void startEngineWhenEngineAlreadyStarted_ShouldThrowRuntimeException() {
		MotorStub motorStub = new MotorStub();
		motorStub.started = true;
		Car car = new Car(motorStub);
		
		car.startEngine();
		
		//car.startEngine(); //Pas besoin de démarrer la voiture une seconde fois car on utilise le MotorStub.
	}*/
	
>>>>>>> branch 'devop' of https://github.com/Joecover99/Duel-JonathanMarcoux.git
	

}
