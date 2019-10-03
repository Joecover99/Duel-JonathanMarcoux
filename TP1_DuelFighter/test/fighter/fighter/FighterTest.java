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
	final private String ANY_NAME = "joe";
	final private int ANY_ID = 1;
	final private int ANY_NBOFHP = 200;
	final private int ANY_STRENGHT = 25;
	final private int MAX_WARRIOR_STRENGHT = 31;
	final private int TOO_MUCH_STRENGHT = Warrior.maxStrenght; 

	@Test
	public void When_FighterIsCreated_Then_NameIsInitialize(){
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP);

        //Assert
        String EXPECTED_NAME = ANY_NAME;
        assertEquals(EXPECTED_NAME,fighter.getName());  
	}
	
	@Test
	public void When_FighterIsCreated_Then_IdIsInitialize(){
        //Arrange
		IFighter fighter = new Warrior(ANY_NAME, ANY_NBOFHP);

        //Assert
        int EXPECTED_ID = ANY_ID;
        assertEquals(EXPECTED_ID,fighter.getFighterId());  
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
	

}
