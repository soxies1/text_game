import java.io.*;
import java.util.*;

public class Weapon{
		
		public String name;
		
		public String type;
		
		public int level;
		
		public int strength;
		
		public int agility;
		
		public int intelligence;
		
		public int ranged;
		
		public int healthup;
		
		public int manaup;
		
		public Weapon(){
			
		}
		
		public Weapon(String nme, String typ, int lvl, int str, int agi, int intel, int ran, int hpup, int mnup){
		
			name =nme;
			type = typ;
			level = lvl;
			strength = str;
			agility = agi;
			intelligence = intel;
			ranged = ran;
			healthup = hpup;
			manaup=mnup;
		
		
		}
		
		public void wepStats(){
			System.out.println("Name: "+name);
			System.out.println("Type: "+type);
			System.out.println("Level: "+level);
			System.out.println("Strength +"+strength);
			System.out.println("Agility +"+agility);
			System.out.println("Intelligence +"+intelligence );
			System.out.println("Ranged +"+ranged);
			System.out.println("Max Health +"+healthup);
			System.out.println("Max Mana +"+manaup);
		
		}
		
		public int GRN(int in){
		Random con = new Random();
		int out = con.nextInt(in);
		return (out+1);
	}
		
		public Weapon generateRanWep(Character enemy){
			Weapon ran = new Weapon();
			
			ran.level = enemy.level;
			ran.strength = GRN(enemy.strength+1);
			ran.intelligence = GRN(enemy.intelligence+1);
			ran.agility = GRN(enemy.agility+1);
			ran.ranged = GRN(enemy.ranged+1);
			ran.healthup = GRN((enemy.health/3)+1);
			ran.manaup = GRN((enemy.mana/4)+1);
			
			
			int d = GRN(4);
			if(ran.healthup> 20) d +=2;
			
			switch(d){
			case 1: ran.name = "Solid ";
					break;
			case 2: ran.name = "Homemade ";
					break;
			case 3: ran.name = "Old ";
					break;
			case 4: ran.name = "New ";
					break;
			default:ran.name = "Rare ";
			
			
			}
			if(enemy.melee.equals("ranged")){
				if(ran.ranged >= ran.intelligence){
					ran.type = "Bow";
				}else{
					ran.type = "Staff";
				}
			}else if(enemy.melee.equals("melee")){
				if(ran.strength >= ran.agility){
					ran.type = "Sword";
				}else{
					ran.type = "Daggers";
				} 
			}else{
				if(ran.agility >= ran.ranged){
					ran.type = "Daggers";
				}else{
					ran.type = "Bow";
				} 
			
			}
			
			ran.name +=ran.type;
			
			return ran;
			
			
			
		
		
		}


}