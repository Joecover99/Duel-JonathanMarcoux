package exception.fighter;

import implementation.fighter.*;

public class IllegalAptitudeLevelException extends IllegalArguementException {
	//public class IllegalInitialSalaryException extends IllegalArgumentException { 
	
		public static final String APTITUDE_LEVEL_TOO_LOW = "Initial aptitude Level must be equal or over " + Athlete.MINIMAL_LEVEL;
		//public static final String TOO_HIGH_SALARY_AUGMENTATION_MESSAGE = "Salary augmentation must be <= " + Employee.MAX_SALARY_AUGMENTATION;
		
		public IllegalAptitudeLevelException(String s) {
			super(s);
		}
}
