import java.io.*;
import java.util.*;
import javax.xml.bind.*;

public class saveGame{

public saveGame(){

}

public void save(Character main) throws IOException{
	System.out.println("Do you want to save your game?");
	System.out.println("Warning: saving will overwrite your last save.");
	System.out.println("Enter 'y' for yes, or 'n' for no");
	Scanner ans = new Scanner(System.in);
	String sdf = ans.nextLine();
	if(sdf.equals("y")){
		Weapon temp = main.wep;
		main.inventory.unequip(main, main.wep);
		saveGame(main);
		main.inventory.equip(main, temp);
		String same = main.name;
		int k = main.name.indexOf(' ');
	String saveName = main.name.substring(0,k);
		main.name = same;
		System.out.println("Game saved in text file '"+saveName+".txt'");
	}else{
	
	}
}

public void saveGame(Character main) throws IOException{
	
	String same = main.name;
	int k = main.name.indexOf(' ');
	String saveName = main.name.substring(0,k);
	 File out = new File(saveName+".txt");
	 FileWriter go = new FileWriter(out);
	 	go.write(same);
	 	go.write("\n");
	 	go.write(main.type);
	  	go.write("\n");
	  	go.write(main.melee);
	  	go.write("\n");
	 	go.write(DatatypeConverter.printInt(main.level));
	  	go.write("\n");
	 	go.write(DatatypeConverter.printInt(main.experience));
	  	go.write("\n");
	 	go.write(DatatypeConverter.printInt(main.strength));
		go.write("\n");
		go.write(DatatypeConverter.printInt(main.agility));
	  	go.write("\n");
	  	go.write(DatatypeConverter.printInt(main.intelligence));
	  	go.write("\n");
	   	go.write(DatatypeConverter.printInt(main.ranged));
	  	go.write("\n");
	   	go.write(DatatypeConverter.printInt(main.health));
	  	go.write("\n");
	   	go.write(DatatypeConverter.printInt(main.chealth));
	  	go.write("\n");
	   	go.write(DatatypeConverter.printInt(main.mana));
	  	go.write("\n");
	   	go.write(DatatypeConverter.printInt(main.cmana));
	  	go.write("\n");
	   	go.write(DatatypeConverter.printInt(main.gold));
		go.write("\n");
		go.write(DatatypeConverter.printInt(main.enemiesDefeated));
		go.write("\n");
	   	go.write(DatatypeConverter.printInt(main.hpotions));
	  	go.write("\n");
	   	go.write(DatatypeConverter.printInt(main.mpotions));
	  	go.write("\n");
	   	go.write(DatatypeConverter.printBoolean(main.hasActSpecial));
	   	go.write("\n");
		go.write(main.special);
		go.write("\n");
	  	go.write(main.actSpecial);
	  	go.write("\n");
	  for(int i = 0; i<main.inventory.wepcount; i++){
	  		go.write(main.inventory.weps[i].name);
	  		go.write("\n");
	  		go.write(main.inventory.weps[i].type);
	  		go.write("\n");
	  		go.write(DatatypeConverter.printInt(main.inventory.weps[i].level));
	  		go.write("\n");
	  		go.write(DatatypeConverter.printInt(main.inventory.weps[i].strength));
	  		go.write("\n");
	  		go.write(DatatypeConverter.printInt(main.inventory.weps[i].agility));
	  		go.write("\n");
	  		go.write(DatatypeConverter.printInt(main.inventory.weps[i].intelligence));
	  		go.write("\n");
	  		go.write(DatatypeConverter.printInt(main.inventory.weps[i].ranged));
	  		go.write("\n");
	  		go.write(DatatypeConverter.printInt(main.inventory.weps[i].healthup));
	  		go.write("\n");
	  		go.write(DatatypeConverter.printInt(main.inventory.weps[i].manaup));
	  		go.write("\n");
	  
	  }
	  
	
	
	  
	  
	 
	 go.close();
	 main.name = same;
	
}


}