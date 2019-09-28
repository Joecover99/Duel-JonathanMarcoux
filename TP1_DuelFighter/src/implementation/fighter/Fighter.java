package implementation.fighter;

//import java.util.ArrayList;

import abstracts.fighter.IFighter;

public class Fighter implements IFighter {
	private String name;
	private int id;
	/*private int strenght;
	private int dexterity;
	private int intelligence;
	private int concentration;*/
	Aptitude aptitude; 

	
	//il va falloir faire un objet avec le nom au complet
	//Il doit avoir un nom et des aptitude
	public Fighter(String name, int id ) {
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
	
/*	public int getStrength() {
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
	}*/
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