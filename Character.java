

import java.util.*;
import java.io.*;


public class Character
{
	public String name;
	
	public String type;
	
	public String melee;
	
	public Weapon wep;
	
	public int level;
	
	public int experience;
	
	public int strength;
	
	public int agility;
	
	public int intelligence;
	
	public int ranged;
	
	public int chealth;
	
	public int health;
	
	public int cmana;
	
	public int mana;
	
	public int gold;
	
	public int enemiesDefeated;
	
	public int hpotions;
	
	public int mpotions;
	
	public String special;
	
	public int specialChance;
	
	public String actSpecial;
	
	public boolean hasActSpecial;
	
	public Inventory inventory;
	
	public String cLocation;
	
	public Character (int i){
	
		name = "";
	
	}
	
	public Character(){
		name = setName();
		type = setType();
		level = 1;
		experience = 0;
		/*strength = 5;
		agility = 5;
		intelligence = 5;
		ranged = 5;
		health = 30;
		mana = 10;
		*/gold = 100;
		hpotions = 5;
		mpotions =5;
		enemiesDefeated = 0;
		inventory = new Inventory(); 
		actSpecial = "none";
	}
	
	public Character( String nam, String typ, String mele, int lvl, int exp, int str, int agl, int intll, int rng, int hp, int mn, int gld, String sp, int spch){
		name = nam;
		type = typ;
		melee = mele;
		level = lvl;
		experience = exp;
		strength = str;
		agility = agl;
		intelligence = intll;
		ranged = rng;
		health = hp;
		chealth = hp;
		mana = mn;
		cmana = mn;
		gold = gld;
		special = sp;
		specialChance = spch;
		
		
		
	}
	public String getMelee(){
		return melee;
	}
	
	public String setName(){
		String chosen = new String("");
		System.out.println("What is your characters name?");
		Scanner keyboard = new Scanner(System.in);
		chosen = keyboard.nextLine();
		//systemin scanner stuff
		return chosen;
	}
	
	public String setType(){
		System.out.println("There are four classes to choose from.");
		System.out.println("");
		System.out.println("\tThe mage class harnesses the incredible power of magic to defeat its enemies from afar.");
		System.out.println("\tThe warrior class uses brute strength to defeat its opponents the up close and personal style.");
		System.out.println("\tThe ranger class uses quick precise ranged shots to take down its targets.");
		System.out.println("\tThe assassin class uses quick strikes and speed to take down its marks.");
		System.out.println("\tWhat class is your character? (Type in one of the following):");
		System.out.println("");
		System.out.println("\t\tmage , warrior , ranger or assassin");
		Scanner keyboard = new Scanner(System.in);
		String type = keyboard.nextLine().trim();
		//systemin scanner stuff
		setClass(type);
		System.out.println("");
		return type;
	}
	
	public void setClass( String i ){
		if(i.equals("mage")){
			defMage();
		}else if(i.equals("warrior")){
			defWarrior();
		}else if(i.equals("ranger")){
			defRanger();
		}else if(i.equals("assassin")){
			defAssassin();
		}else{
			System.out.print("Could not understand. Please use exact text as shown.\n\n");
			System.out.println("");
			setType();
		}
		
	}
	
	public void defMage(){
		name += " the Wise";
		melee = "ranged";
		setStrength(0);
		setAgility(5);
		setIntelligence(8);
		setRanged(7);
		setHealth(100);
		chealth = health;
		setMana(40);
		cmana= mana;
		special = "barrier";
		specialChance = (intelligence*3/2);
		hasActSpecial = false;
		
	}
	
	public void defWarrior(){
		name += " the Fierce";
		melee = "melee";
		setStrength(11);
		setAgility(7);
		setIntelligence(2);
		setRanged(0);
		setHealth(200);
		chealth = health;
		setMana(0);
		cmana = mana;
		special = "stun";
		specialChance = (strength);
		hasActSpecial = false;
	}
	
	public void defRanger(){
		name += " the Accurate";
		melee = "ranged";
		setStrength(2);
		setAgility(6);
		setIntelligence(4);
		setRanged(8);
		setHealth(150);
		chealth=health;
		setMana(20);
		cmana = mana;
		special = "head shot";
		specialChance = (ranged/3);
		hasActSpecial = false;
	}
	
	public void defAssassin(){
		name += " the Silent";
		melee = "both";
		setStrength(3);
		setAgility(9);
		setIntelligence(4);
		setRanged(5);
		setHealth(110);
		chealth = health;
		setMana(30);
		cmana = mana;
		special = "triple strike";
		specialChance = (agility*3/2);
		hasActSpecial = false;
	}
	
	public void setStrength(int i){
		strength = i;
	}
	
	public void setAgility(int i){
		agility = i;
	}
	
	public void setIntelligence(int i){
		intelligence = i;
	}
	
	public void setRanged(int i){
		ranged = i;
	}
	
	public void setHealth(int i){
		health = i;
	}
	
	public void setMana(int i){
		mana = i;
	}
	
	public void gainLevel(){
		level++;
		health += 10;
		mana += 5;
		
		System.out.println("Congratulations you are now level " + getLevel() + "!");
		if(level == 2){
			System.out.println("Now that you have leveled up it's time to explain your attribute points.");
			attributes();
			
		}
		System.out.println("You have three new attribute points to spend!");
		distributePoints();
		
	}
	
	public void gainExp(int i){
		for(int k = 0; k < i; k++){
		experience += 1;
		checkExp(experience);
		}
		//experience += i;
		
	}
	
	public void checkExp(int exp){
		if(exp >= mathExp(getLevel()+1)){
			gainLevel();
			
		} 
	}
	
	public int getLevel(){
		return level;
	}
	
	public void getStats(){
		System.out.println("Name = " + name);
		System.out.println("level = " + level);
		System.out.println("class = " + type);
		System.out.println("strength = " + strength);
		System.out.println("agility = " + agility);
		System.out.println("intelligence = " + intelligence);
		System.out.println("ranged = " + ranged);
		System.out.println("current health = " + chealth);
		System.out.println("current mana = " + cmana);
		System.out.println("max health = " + health);
		System.out.println("max mana = " + mana);
		System.out.println("experience = " + experience);
		System.out.println("gold = " + gold);
		System.out.println("enemies defeated = "+enemiesDefeated);
		System.out.println("Active special = "+actSpecial);
		System.out.println("special = "+special);
		
		
	}
	
	public int mathExp(int i){
		int needed = 5;
		for(int k = 0; k<i-1; k++){
			needed = needed * 5;
		}
		return needed;
	}
	
	public void distributePoints(){
		
		int points = 3;
		System.out.println("You will spend points one at a time.");
		System.out.println("To increase strength by 1 enter 's'");
		System.out.println("To increase agility by 1 enter 'a'");
		System.out.println("To increase intelligence by 1 enter 'i'");
		System.out.println("To increase range by 1 enter 'r'");
		
		while(points > 0) {
		System.out.println("You have " + points + " to spend");
		Scanner keyboard = new Scanner(System.in);
		String choice = keyboard.nextLine().trim();
		//system in scanner stuff
		
		if(choice.equals("s")){
			strength++;
			health = health + 2;
			points--;
		}else if(choice.equals("a")){
			agility++;
			points--;
		}else if(choice.equals("i")){
			intelligence++;
			mana = mana + 2;
			points--;
		}else if(choice.equals("r")){
			ranged++;
			points--;
		}else{
			System.out.println("Invalid option. Please enter one of the given letters.");
		}
		
		}
		chealth = health;
		cmana = mana;
		recalcSpecialChance();
		System.out.println("Your new stats are: ");
		getStats();
		
	}
	
	public void recalcSpecialChance(){
		if(type.equals("mage")){
			specialChance = (intelligence/2);
			
		}
		if(type.equals("warrior")){
			specialChance = (strength/2);
			
		}
		if(type.equals("ranger")){
			specialChance = (ranged/2);
			
		}
		if(type.equals("assassin")){
			specialChance = (agility/2);
			
		}
	
	}
	
	public void increaseStrength(int i){
			strength += i;
	}
	public void increaseAgility(int i){
			agility += i;
	}
	public void increaseIntelligence(int i){
			intelligence += i;
	}
	public void increaseRanged(int i){
			ranged += i;
	}
	public void increaseHealth(int i){
			health += i;
	}
	public void increaseMana(int i){
			mana += i;
	}
	public void heal(int i){
		chealth += i;
	}
	public void regen(int i){
		cmana += i;
	}
	public void gaingold(int i){
		gold +=i;
	}
	public void defeat(){
		enemiesDefeated++;
	}
	
	public void attributes(){
		System.out.println("There are four attributes you can choose to put points in:");
		System.out.println("");
		System.out.println("\t\tStrength - increases character health and melee damage.");
		System.out.println("\t\tIntelligence - increases a characters mana and spell damage");
		System.out.println("\t\tAgility - increases how fast your character attacks and moves");
		System.out.println("\t\tRanged - how far you can be from an opponent to do damage and more ranged damage");
		System.out.println("");
	}
	
	/*public static void main (String [] args){
	
	Character blah = new Character();
	blah.getStats();
	blah.gainExp(125);
	
	
	
	
	
	}*/
	
	
	
	
	
	
	
	
	
}