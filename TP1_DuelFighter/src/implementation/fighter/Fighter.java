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
	
	private String name;
	private int numberOfHp = 200;
	private int strenght;
	private int dexterity;
	private int intelligence;
	private int concentration;
	protected IAptitude aptitude; 
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
	

	public Fighter(String name, int numberOfHp, IAptitude aptitude) {
		this.name = name;
		this.numberOfHp = numberOfHp;
		this.aptitude = aptitude;
		//this.aptitude = aptitude;
	}

	public String getName() {
		return name;
	}
	
	public int getNbOfHp(){
		numberOfHp = numberOfHp - (strenght + dexterity + intelligence + concentration);
		return numberOfHp;
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
		force + dextérité + intelligence + concentration <= 100
2. Pour un guerrier :
		force >= dextérité + 10 >= intelligence + 10 >= concentration
3. Pour un athlète :
		force >= 20
		dextérité >= 20
		intelligence >= 20
		concentration >= 20
4. Pour un magicien :
		intelligence >= max(force, dextérité) + 15
		concentration >= max(force, dextérité) + 15
		
5. sPoint de vie
	Nombre de points de vie = 200 – (force + dextérité + intelligence + concentration)
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

		force + dextérité + intelligence + concentration <= 100

2. Pour un guerrier :

		force >= dextérité + 10 >= intelligence + 10 >= concentration

3. Pour un athlète :

		force >= 20
		dextérité >= 20
		intelligence >= 20
		concentration >= 20

4. Pour un magicien :

		intelligence >= max(force, dextérité) + 15
		concentration >= max(force, dextérité) + 15
		
5. sPoint de vie

	Nombre de points de vie = 200 – (force + dextérité + intelligence + concentration)
*/