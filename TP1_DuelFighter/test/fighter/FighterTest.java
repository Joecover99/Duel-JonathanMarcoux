package fighter;

import static org.junit.Assert.*;

import org.junit.Test;

import implementation.fighter.Fighter;

public class FighterTest {
	final private String ANY_NAME = "joe";
	final private int ANY_ID = 1;
	final private int ANY_NBOFHP = 200;

	@Test
	public void When_FighterIsCreated_Then_NameIsInitialize(){
        //Arrange
		Fighter fighter = new Fighter(ANY_NAME, ANY_ID, ANY_NBOFHP);

        //Assert
        String EXPECTED_NAME = ANY_NAME;
        assertEquals(EXPECTED_NAME,fighter.getName());  
	}
	
	@Test
	public void When_FighterIsCreated_Then_IdIsInitialize(){
        //Arrange
		Fighter fighter = new Fighter(ANY_NAME, ANY_ID, ANY_NBOFHP);

        //Assert
        int EXPECTED_ID = ANY_ID;
        assertEquals(EXPECTED_ID,fighter.getFighterId());  
	}
	
	@Test
	public void When_FighterIsCreated_Then_HpIsInitialize(){
        //Arrange
		Fighter fighter = new Fighter(ANY_NAME, ANY_ID, ANY_NBOFHP);

        //Assert
        int EXPECTED_HP = ANY_NBOFHP;
        assertEquals(EXPECTED_HP,fighter.getNbOfHp());  
	}

}
