import java.util.*;
import java.io.*;

import java.util.Random;

public class Location{
	
	public String name;
	
	public int lvl;
	
	public int enmyChnce;
	
	public boolean boss;
	
	public int trseChnce;
	
	public int spaces;
	
	public int encounterSpaces;
	
	public Location(){
		name= "";
		lvl = 1;
		enmyChnce = 60;
		boss = false;
		trseChnce = 1;
		spaces = 15;
		encounterSpaces = 4;
	}
	
	public Location( String nme, int ll, int enemyChance, boolean bos, int treasureChance, int spaes,int  encounterspaces){
	
		name = nme;
		lvl = ll;
		enmyChnce=enemyChance;
		boss = bos;
		trseChnce = treasureChance;
		spaces = spaes;
		encounterSpaces = encounterspaces;
		
	}
	
	public boolean encounter(Character me){
		Random r = new Random();
		int val = r.nextInt(101);
		if (val <= enmyChnce){
			System.out.println("You encounter an enemy!");
			return true;
		}else{
			System.out.println("You do not encounter an enemy.");
			System.out.println("Now is the time to use a potion to heal or look for treasure.");
			System.out.println("Enter 'hp' to use a health potion or 'mp' to use a mana potion or 't' to look for treasure.");
			
				Scanner keyboard = new Scanner(System.in);
				String choice = keyboard.nextLine();
				if(choice.equals("hp")){
					System.out.println("You use a potion to heal..");
					hpotion(me);
				}
				else if(choice.equals("mp")){
					System.out.println("You use a potion to regenerate mana..");
					mpotion(me);
				}else if(choice.equals("t")){
					System.out.println("You look for treasure!");
					System.out.println("You...");
					Random l = new Random();
					int get = l.nextInt(101);
						if(get<= trseChnce){
							System.out.println("You find Treasure!");
							me.gold +=100;
							System.out.println("You now have "+me.gold +"gold!");
							ent();
						}else{
							System.out.println("You do not find treasure anywhere! Darn!");
							ent();
						}
					
				}else{
				System.out.println("Couldn't understand input so loss of option.");
					
				}
				
				
				
				
			return false;
		}
		//System.out.println(val+"% encounter chance");
	
	}
	
		public void ent(){
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("Press enter to continue");
		Scanner keyboard = new Scanner(System.in);
		String ent = keyboard.nextLine();
		if(ent.equals("")){
			
		}
	}
	
		public void hpotion(Character me){
		if(me.hpotions>0){
		me.hpotions--;
		me.chealth += 10;
		if(me.chealth>me.health) me.chealth = me.health;
		System.out.println("Your health is now "+me.chealth+".");
		System.out.println("You have "+me.hpotions+" left.");
		ent();
		}else{
			System.out.println("no potions left!");
			ent();
		}
	}
	
	public void mpotion(Character me){
		if(me.mpotions>0){
		me.mpotions--;
		me.cmana += 10;
		if(me.cmana>me.mana) me.cmana = me.mana;
		System.out.println("Your mana is now "+me.cmana+".");
		System.out.println("You have "+me.mpotions+" left.");
		ent();
		}else{
			System.out.println("no potions left!");
			ent();
		}
	}
	
	public static void main(String [] args){
		Location the = new Location("swamp",1,75,true,10,20,4);
		//the.encounter();
	}


}