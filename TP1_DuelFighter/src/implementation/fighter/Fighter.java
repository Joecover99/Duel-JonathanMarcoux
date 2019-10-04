package implementation.fighter;


import java.util.ArrayList;

import abstracts.fighter.IAptitude;

import java.util.ArrayList;

import abstracts.fighter.IFighter;
import abstracts.fighter.ISkill;
import exception.fighter.IllegalAptitudeIsOverMaxTotal;
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
	private ArrayList<ISkill> skillList = new ArrayList<ISkill>();
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
	

	public Fighter(String name, int numberOfHp, int strenght, int dexterity, int intelligence, int concentration, ISkill skill1, ISkill skill2) {
		this.name = name;
		this.numberOfHp = numberOfHp;
		this.strenght = strenght;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.concentration = concentration;
		
		this.skillList.add(skill1);
		this.skillList.add(skill2);
		
		CalculateInitialNbOfHp();
	}

	protected void validateAttribute(int strenght, int dexterity, int intelligence, int concentration) throws IllegalStrenghtValueIsEqualOrUnderZero, IllegalIntelligenceValueIsEqualOrUnderZero, IllegalConcentrationValueIsEqualOrUnderZero, IllegalStrenghtValueIsEqualOrOverMaxTotal, IllegalDexterityValueIsEqualOrOverMaxTotal, IllegalConcentrationValueIsEqualOrOverMaxTotal, IllegalAptitudeIsOverMaxTotal, IllegalDexterityValueIsEqualOrUnderZero{
		validateStrenghtIsAboveZero(strenght);
		validatedDexterityIsAboveZero(dexterity);
		validateIntelligenceIsAboveZero(intelligence);
		validateConcentrationtIsAboveZero(concentration);
		
		validateStrenghtEqualOrAboveMaxTotal(strenght);
		validateDexterityEqualOrAboveMaxTotal(dexterity);
		validateIntelligenceIsAboveZero(intelligence);
		validateConcentrationEqualOrAboveMaxTotal(concentration);
		
		ValidateAptitudeIsOverTheMaxCapacity();

	}
	
	public String getName() {
		return name;
	}
	
	public int getNumberOfHp() {
		return this.numberOfHp;
	}
	
	public void CalculateInitialNbOfHp(){
		this.numberOfHp = INITIAL_NUMBER_OF_HP - (this.getStrength() + this.getDexterity() + this.getIntelligence() + this.getConcentration());
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
	
	public void addSkill(ISkill skill){
		skillList.add(skill);
	}
	
	public void removeSkill(ISkill skill){
		skillList.remove(skill);
	}
	
	private void validateStrenghtIsAboveZero(int strenght) throws IllegalStrenghtValueIsEqualOrUnderZero {
		if(this.getStrength() < MIN_STRENGHT) {
			throw new IllegalStrenghtValueIsEqualOrUnderZero();
		}
		}
		
		
	private void  validatedDexterityIsAboveZero(int dexterity) throws IllegalDexterityValueIsEqualOrUnderZero {
		if(this.getDexterity() < MIN_DEXTERITY){
			throw new IllegalDexterityValueIsEqualOrUnderZero();	
		}
		}
	
	private void  validateIntelligenceIsAboveZero(int intelligence) throws IllegalIntelligenceValueIsEqualOrUnderZero {
		if(this.getIntelligence() < MIN_INTELLIGENCE) {
			throw new IllegalIntelligenceValueIsEqualOrUnderZero();
		}
		}
	
	private void validateConcentrationtIsAboveZero(int concentration) throws IllegalConcentrationValueIsEqualOrUnderZero  {
		if(this.getConcentration() < MIN_CONCENTRATION) {
			throw new IllegalConcentrationValueIsEqualOrUnderZero();
		}
	}
	
	private void validateStrenghtEqualOrAboveMaxTotal(int strenght) throws IllegalStrenghtValueIsEqualOrOverMaxTotal{
		if(this.getStrength() > MAX_STRENGHT) {
			throw new IllegalStrenghtValueIsEqualOrOverMaxTotal();
		}
		}
		
		
	private void validateDexterityEqualOrAboveMaxTotal(int dexterity) throws IllegalDexterityValueIsEqualOrOverMaxTotal{
		if(this.getDexterity() > MAX_DEXTERITY){
			throw new IllegalDexterityValueIsEqualOrOverMaxTotal();	
		}
		}
	
	private void validateIntelligenceEqualOrAboveMaxTotal(int intelligence) throws IllegalIntelligenceValueIsEqualOrOverMaxTotal {
		if(this.getIntelligence() > MAX_INTELLIGENCE) {
			throw new IllegalIntelligenceValueIsEqualOrOverMaxTotal();
		}
		}
	
	private void validateConcentrationEqualOrAboveMaxTotal(int concentration) throws IllegalConcentrationValueIsEqualOrOverMaxTotal{
		if(this.getConcentration() > MAX_CONCENTRATION) {
			throw new IllegalConcentrationValueIsEqualOrOverMaxTotal();
		}
	}

	private void ValidateAptitudeIsOverTheMaxCapacity() throws IllegalAptitudeIsOverMaxTotal{
		if(this.getStrength() + this.getDexterity() + this.getIntelligence() + this.getConcentration() > MAX_APTITUDE) {
			throw new IllegalAptitudeIsOverMaxTotal();
		}
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