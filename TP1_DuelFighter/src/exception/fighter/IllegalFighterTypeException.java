package exception.fighter;

public class IllegalFighterTypeException extends IllegalArgumentException {

	public static final String WRONG_FIGHTER_TYPE = "There is no valid fighter type selected";
	
	public IllegalFighterTypeException(String s) {
		super(s);
	}
}
