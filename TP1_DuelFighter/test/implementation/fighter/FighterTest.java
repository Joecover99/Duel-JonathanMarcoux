package implementation.fighter;

import static org.junit.Assert.*;

import org.junit.Test;

public class FighterTest {
	final private String ANY_NAME = "joe";
	final private int ANY_ID = 1;

	@Test
	public void When_FighterIsCreated_Then_NameIsInitialize(){
        //Arrange
		Fighter fighter = new Fighter(ANY_NAME, ANY_ID);

        //Assert
        String EXPECTED_NAME = ANY_NAME;
        assertEquals(EXPECTED_NAME,fighter.getName());  
	}
	
	@Test
	public void When_FighterIsCreated_Then_IdIsInitialize(){
        //Arrange
		Fighter fighter = new Fighter(ANY_NAME, ANY_ID);

        //Assert
        int EXPECTED_ID = ANY_ID;
        assertEquals(EXPECTED_ID,fighter.getFighterId());  
	}

}
