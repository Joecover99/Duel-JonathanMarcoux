package simulator;

import java.util.Scanner;

import Skill.fighter.SkillFactory;
import abstracts.fighter.IFighter;
import duel.fighter.Duel;
import implementation.fighter.FighterFactory;

public class Simulator {
    static Scanner scan = new Scanner(System.in);
	
	 public static void main(String[] args) {
	    	System.out.println("First figther");
	        System.out.println("What is the name of the fighter? ");
	        String fighter1Name = scan.next();
	        System.out.println("What is the strength of the fighter? ");
	        int strength1 = scan.nextInt();
	        System.out.println("What is the dexterity of the fighter? ");
	        int dexterity1 = scan.nextInt();
	        System.out.println("What is the intelligence of the fighter? ");
	        int intelligence1 = scan.nextInt();
	        System.out.println("What is the concentration of the fighter? ");
	        int concentration1 = scan.nextInt();
	        System.out.println("What is the value of the first skill? ");
	        int skillValue1 = scan.nextInt();
	        System.out.println("What is the name of the first skill? ");
	        String skillName1 = scan.next();
	        System.out.println("What is the value of the second skill? ");
	        int skillValue2 = scan.nextInt();
	        System.out.println("What is the name of the first skill? ");
	        String skillName2 = scan.next();
	        IFighter fighter = FighterFactory.FighterCreator(FighterFactory.FighterType.Warrior,fighter1Name,strength1,dexterity1,intelligence1,concentration1,SkillFactory.SkillCreator(SkillFactory.SkillType.Sword, skillValue1, skillName1),SkillFactory.SkillCreator(SkillFactory.SkillType.HealingSpell, skillValue2, skillName2));
	        System.out.println(" The Fighter name is :" + fighter.getName()+ ", is strength is : " + fighter.getStrength()+ ", is dexterity is : " + fighter.getStrength() + ", is intelligence is :" + fighter.getIntelligence() + ", is concentration is : " + fighter.getConcentration() + ", is mighty weapon of choice is: " + fighter.getSkillName(fighter.getSkill(0)) + ", is efficacite is :" + fighter.getSkillValue(fighter.getSkill(0)));
	       
	        System.out.println("Second figther");
	        System.out.println("What is the name of the fighter? ");
	        String fighter2Name = scan.next();
	        System.out.println("What is the strength of the fighter? ");
	        int strength2 = scan.nextInt();
	        System.out.println("What is the dexterity of the fighter? ");
	        int dexterity2 = scan.nextInt();
	        System.out.println("What is the intelligence of the fighter? ");
	        int intelligence2 = scan.nextInt();
	        System.out.println("What is the concentration of the fighter? ");
	        int concentration2 = scan.nextInt();
	        System.out.println("What is the value of the first skill? ");
	        int skillValue3 = scan.nextInt();
	        System.out.println("What is the name of the first skill? ");
	        String skillName3 = scan.next();
	        System.out.println("What is the value of the second skill? ");
	        int skillValue4 = scan.nextInt();
	        System.out.println("What is the name of the first skill? ");
	        String skillName4 = scan.next();
	        IFighter fighter2 =  FighterFactory.FighterCreator(FighterFactory.FighterType.Athlete,fighter2Name,strength2,dexterity2,intelligence2,concentration2,SkillFactory.SkillCreator(SkillFactory.SkillType.Sword, skillValue3, skillName3),SkillFactory.SkillCreator(SkillFactory.SkillType.HealingSpell, skillValue4, skillName4));
	        Duel duel = new Duel(fighter, fighter2, fighter.getSkill(0));
	        System.out.println(" The Fighter name is :" + fighter2.getName()+ ", is strength is : " + fighter2.getStrength()+ ", is dexterity is : " + fighter2.getStrength() + ", is intelligence is :" + fighter2.getIntelligence() + ", is concentration is : " + fighter2.getConcentration() + ", is mighty weapon of choice is: " + fighter2.getSkillName(fighter2.getSkill(0)) + ", is efficacite is :" + fighter2.getSkillValue(fighter2.getSkill(0)));
	        System.out.println("What is the ability that the second fighter must use? : (entre 0 et 1) ");
	        int index = scan.nextInt();
	        System.out.println("Will the second fighter surrender? ");
	        boolean surrender = scan.hasNextInt();
	        duel.fight(fighter2.getSkill(index), surrender);
	        System.out.println(" The Winner is : " + duel.fightWinner.getName());
	        System.out.println(" The loser is : " + duel.fightLoser.getName());
	        System.out.println(" The winner aquire this capacite : " + duel.fightWinner.getSkillName(duel.fightWinner.getSkill(2)));
	        System.out.println(" The Fighter name is :" + fighter.getName()+ ", is strength is : " + fighter.getStrength()+ ", is dexterity is : " + fighter.getDexterity() + ", is intelligence is :" + fighter.getIntelligence() + ", is concentration is : " + fighter.getConcentration() + ", is mighty wepeon of choice is: " + fighter.getSkillName(fighter.getSkill(0)) + ", is efficacite is :" + fighter.getSkillValue(fighter.getSkill(0)));
	        System.out.println(" The Fighter name is :" + fighter2.getName()+ ", is strength is : " + fighter2.getStrength()+ ", is dexterity is : " + fighter2.getDexterity() + ", is intelligence is :" + fighter2.getIntelligence() + ", is concentration is : " + fighter2.getConcentration() + ", is mighty wepeon of choice is: " + fighter2.getSkillName(fighter2.getSkill(0)) + ", is efficacite is :" + fighter2.getSkillValue(fighter2.getSkill(0)));
	    }
}
