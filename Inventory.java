import java.util.*;
import java.io.*;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.*;

public class Inventory{
	
	public int hpotions;
	
	public int mpotions;
	
	public Weapon[] weps;
	
	public int wepcount;
	
	public String[] items;

	public Inventory(){
		hpotions = 5;
		mpotions = 5;
		//weps[] = {};
		//items[] = {};
		wepcount =0;
		weps = new Weapon[5];
	
	}
	
	public void addHPotions(int i){
		hpotions+=i;
	
	
	}
	
	public void minusHpotion(){
		if(hpotions>0){
		hpotions--;
	}
	else{
		System.out.println("No health potions left.");
	}
	}
	
	public void addMPotions(int i){
	
	mpotions+=i;
	
	}
	
	public void minusMPotion(){
	if(mpotions>0){
		mpotions--;
	}else{
		System.out.println("No mana potions left.");
	}
	
	}
	
	public void addWep(Weapon it){
		if(wepcount>=5){
			System.out.println("You have no room in your inventory");
			boolean an = false;
			while(an == false){
			System.out.println("Would you like to drop a weapon to make room for it?");
			System.out.println("Enter 'y' for yes, or 'n' for no.");
			Scanner q = new Scanner(System.in);
			String qi = q.nextLine();
			if(qi.equals("y")){
				System.out.println("The current weapons you have are:");
				listWeps();
				System.out.println("");
				System.out.println("Enter the slot number of the weapon you'd like to drop.");
				System.out.println("eg; to drop weapon in slot 3 enter '3'");
				Scanner drop = new Scanner(System.in);
				String dropped = drop.nextLine();
				int k = DatatypeConverter.parseInt(dropped);
				dropWep(k);
				an = true;
				weps[wepcount] = it;
		wepcount++;
			}else if(qi.equals("n")){
				System.out.println("You leave the weapon.");
				an = true;
			}else{
				System.out.println("Invalid input, please enter correct syntax.");
				an = false;
			}
		}
		}else{
		weps[wepcount] = it;
		wepcount++;
	}
	}
	
	public void unequip(Character main, Weapon her){
		
		main.strength -= her.strength;
		main.agility -= her.agility;
		main.intelligence -= her.intelligence;
		main.ranged -= her.ranged;
		main.mana -= her.manaup;
		main.health -= her.healthup;
		if(main.chealth>main.health) main.chealth=main.health;
		if(main.cmana>main.mana) main.cmana = main.mana;
		main.recalcSpecialChance();
		main.wep = null;
	
	}
	
	public void equip(Character main, Weapon her){
	
		if(main.wep!=null){
		unequip(main, main.wep);
		}
		main.wep = her;
		main.strength += her.strength;
		main.agility += her.agility;
		main.intelligence += her.intelligence;
		main.ranged += her.ranged;
		main.mana += her.manaup;
		main.health += her.healthup;
		main.recalcSpecialChance();
		
	
	}
	
	public void minusWep(Weapon it){
		boolean found = false;	
		int h = 0;
			while(found==false&&h<5){
				if(it.name.equals(weps[h].name)){
					found = true;
				}else{
					h++;
				}
				
				if(found == true){ 
					weps[h] = null;
					wepcount--;
				}
				
			}
			if(found==false){
				System.out.println("You dont have that weapon");
			}
			
	}
	
	public void dropWep(int i){
		if(wepcount>0){
		int f = i;
		weps[i] = null;
		weps[f]= weps[wepcount-1];
		weps[wepcount-1] = null;
		wepcount--;
		}else{
			System.out.println("no weapon to drop.");
		}
	
	}
	
	public void listWeps(){
		System.out.println("The current weapons you have are:");
		System.out.println("");
		for(int i = 0; i<wepcount; i++){
			System.out.println("Slot "+i+":");
			weps[i].wepStats();
			System.out.println("");
			System.out.println("");
		}
	}


}