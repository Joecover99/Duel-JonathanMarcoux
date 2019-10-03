package fighter;

import static org.junit.Assert.*;

import org.junit.Test;

import abstracts.fighter.IFighter;
import implementation.fighter.Aptitude;
import implementation.fighter.Athlete;
import implementation.fighter.Fighter;
import implementation.fighter.Mage;
import implementation.fighter.Warrior;

public class FighterTest {
	private static final String TOO_MUCH_STRENGHT = null;
	final private String ANY_NAME = "joe";
	final private int ANY_NBOFHP = 200;
	final private int ANY_STRENGHT = 25;
	final private int MAX_WARRIOR_STRENGHT = 31;

	@Test
	public void When_FighterIsCreated_Then_NameIsInitialize(){
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP);

        //Assert
        String EXPECTED_NAME = ANY_NAME;
        assertEquals(EXPECTED_NAME,fighter.getName());  
	}
	
	@Test
	public void When_FighterIsCreated_Then_HpIsInitialize(){
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP);

        //Assert
        int EXPECTED_HP = ANY_NBOFHP;
        assertEquals(EXPECTED_HP,fighter.getNbOfHp());  
	}
	
	@Test
	public void When_FighterIsCreated_Then_StrenghtisReturned(){
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP);

		//act
		int actualStrenght = fighter.getStrength();
        //Assert
        int EXPECTED_STRENGHT = ANY_STRENGHT;
        assertEquals(EXPECTED_STRENGHT,actualStrenght);  
	}
	
	@Test
	public void When_FighterIsCreated_Then_MaxStrenghtisReturned(){
        //Arrange
		final int TOO_MUCH_STRENGHT = Warrior.maxStrenght + 1;
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP);

		//act
		int actualStrenght = fighter.getStrength();
        //Assert
        int EXPECTED_STRENGHT = MAX_WARRIOR_STRENGHT;
        assertEquals(EXPECTED_STRENGHT,actualStrenght);  
	}
	
	@Test (expected = IllegalArgumentException.class)
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
	
	

}
