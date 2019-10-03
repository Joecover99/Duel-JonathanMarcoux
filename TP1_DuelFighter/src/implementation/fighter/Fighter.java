package implementation.fighter;


import abstracts.fighter.IAptitude;

//import java.util.ArrayList;

import abstracts.fighter.IFighter;
import exception.fighter.IllegalApptitudeIsOverMaxTotal;
import exception.fighter.IllegalConcentrationValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalConcentrationValueIsEqualOrUnderZero;
import exception.fighter.IllegalDexterityValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalDexterityValueIsEqualOrUnderZero;
import exception.fighter.IllegalIntelligenceValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalIntelligenceValueIsEqualOrUnderZero;
import exception.fighter.IllegalStrenghtValueIsEqualOrOverMaxTotal;
import exception.fighter.IllegalStrenghtValueIsEqualOrUnderZero;

public abstract class Fighter implements IFighter {
	
	public static int INITIAL_NUMBER_OF_HP = 200;
	private String name;
	protected int numberOfHp = 200;
	protected IAptitude aptitude; 
	int strenght;
	int dexterity;
	int intelligence;
	int concentration;
	//public int TOO_MUCH_STRENGHT = 40;

	
	public static int MIN_STRENGHT = 1;
	public static int MIN_DEXTERITY = 1;
	public static int MIN_INTELLIGENCE = 1;
	public static int MIN_CONCENTRATION = 1;

	
	public static int MAX_STRENGHT = 40;
	public static int MAX_DEXTERITY = 40;
	public static int MAX_INTELLIGENCE = 40;
	public static int MAX_CONCENTRATION = 40;
	public static int MAX_APTITUDE = 100;
	

	public Fighter(String name, int numberOfHp, int strenght, int dexterity, int intelligence, int concentration) {
		this.name = name;
		this.numberOfHp = numberOfHp;
		this.strenght = strenght;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.concentration = concentration;
	}

	public String getName() {
		return name;
	}
	
	public int getNumberOfHp() {
		return this.numberOfHp;
	}
	
	public void CalculateInitialNbOfHp(){
		this.numberOfHp = INITIAL_NUMBER_OF_HP - (aptitude.getStrength() + aptitude.getDexterity() + aptitude.getIntelligence() + aptitude.getConcentration());
	}
	
	public int getStrength() {
		return this.strenght;
	}
	
	public int getDexterity() {
		return this.dexterity;
	}
	
	public int getIntelligence() {
		return this.intelligence;
	}
	
	public int getConcentration() {
		return this.concentration;
	}
	
	private void validateStrenghtIsAboveZero() throws IllegalStrenghtValueIsEqualOrUnderZero {
		if(aptitude.getStrength() <= MIN_STRENGHT - 1) throw new IllegalStrenghtValueIsEqualOrUnderZero();
		}
		
		
	private void  validatedDexterityIsAboveZero() throws IllegalDexterityValueIsEqualOrUnderZero {
		if(aptitude.getStrength() <= MIN_DEXTERITY - 1)throw new IllegalDexterityValueIsEqualOrUnderZero();	
		}
	
	private void  validateIntelligenceIsAboveZero() throws IllegalIntelligenceValueIsEqualOrUnderZero {
		if(aptitude.getStrength() <= MIN_INTELLIGENCE - 1) throw new IllegalIntelligenceValueIsEqualOrUnderZero();
		}
	
	private void validateConcentrationtIsAboveZero() throws IllegalConcentrationValueIsEqualOrUnderZero {
		if(aptitude.getStrength() <= MIN_CONCENTRATION - 1) throw new IllegalConcentrationValueIsEqualOrUnderZero();
	}
	
	private void validateStrenghtEqualOrAboveMaxTotal() throws IllegalStrenghtValueIsEqualOrOverMaxTotal{
		if(aptitude.getStrength() <= MAX_STRENGHT - 1) throw new IllegalStrenghtValueIsEqualOrOverMaxTotal();
		}
		
		
	private void validateDexterityEqualOrAboveMaxTotal() throws IllegalDexterityValueIsEqualOrOverMaxTotal {
		if(aptitude.getStrength() <= MAX_DEXTERITY - 1)throw new IllegalDexterityValueIsEqualOrOverMaxTotal();	
		}
	
	private void validateIntelligenceEqualOrAboveMaxTotal() throws IllegalIntelligenceValueIsEqualOrOverMaxTotal {
		if(aptitude.getStrength() <= MAX_INTELLIGENCE - 1) throw new IllegalIntelligenceValueIsEqualOrOverMaxTotal();
		}
	
	private void validateConcentrationEqualOrAboveMaxTotal() throws IllegalConcentrationValueIsEqualOrOverMaxTotal{
		if(aptitude.getStrength() <= MAX_CONCENTRATION - 1) throw new IllegalConcentrationValueIsEqualOrOverMaxTotal();
	}

	private void ValidateAptitudeIsOverTheMaxCapacity() throws IllegalApptitudeIsOverMaxTotal{
		if(aptitude.getStrength() + aptitude.getDexterity() + aptitude.getIntelligence() + aptitude.getConcentration() <= 100) throw new IllegalApptitudeIsOverMaxTotal();
	}
}
	
/*
Pour tous les combattants :
		force + dext�rit� + intelligence + concentration <= 100
2. Pour un guerrier :
		force >= dext�rit� + 10 >= intelligence + 10 >= concentration
3. Pour un athl�te :
		force >= 20
		dext�rit� >= 20
		intelligence >= 20
		concentration >= 20
4. Pour un magicien :
		intelligence >= max(force, dext�rit�) + 15
		concentration >= max(force, dext�rit�) + 15
		
5. sPoint de vie
	Nombre de points de vie = 200 � (force + dext�rit� + intelligence + concentration)
*/
/*
package implementation.fighter;

//import java.util.ArrayList;

import abstracts.fighter.IFighter;

public class Fighter implements IFighter {
	private String name;
	private int id;
	/*private int strenght;
	private int dexterity;
	private int intelligence;
	private int concentration;
	Aptitude aptitude; 

	
	//il va falloir faire un objet avec le nom au complet
	//Il doit avoir un nom et des aptitude
	public Fighter(String name, int id, Aptitude aptitude ) {
		this.name = name;
		this.id = id;
		this.aptitude = aptitude;
	}

	public String getName() {
		return name;
	}

	public int getFighterId() {
		return this.id;
	}
	
	public Aptitude getAptitude() {
		return this.aptitude;
	}

	public int getStrength() {
		return this.strenght;
	}
	
	public int getDexterity() {
		return this.dexterity;
	}
	
	public int getIntelligence() {
		return this.intelligence;
	}
	
	public int getConcentration() {
		return this.concentration;
	}
}

/*
Pour tous les combattants :

		force + dext�rit� + intelligence + concentration <= 100

2. Pour un guerrier :

		force >= dext�rit� + 10 >= intelligence + 10 >= concentration

3. Pour un athl�te :

		force >= 20
		dext�rit� >= 20
		intelligence >= 20
		concentration >= 20

4. Pour un magicien :

		intelligence >= max(force, dext�rit�) + 15
		concentration >= max(force, dext�rit�) + 15
		
5. sPoint de vie

	Nombre de points de vie = 200 � (force + dext�rit� + intelligence + concentration)
*/