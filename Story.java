
import java.util.*;
import java.io.*;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.*;

public class Story{
		
		public boolean cont = true;
		
		public String location;
		
		public String player;
		
		public Character you;
	
	public Story(){
		cont = true;
		location = "home";
		player = null;
		you = new Character(1);
		
	}
	
	public void rules(){
		System.out.println("Heres what to enter to get information on the following:");
		System.out.println("\tr  -  for this page of how to get information (dont forget this one)");
		System.out.println("\ta  -  for guide to attributes and what they do");
		System.out.println("\ts  -  for your characters statistics (eg. Health, EXP, Strength...)");
		System.out.println("\ti  -  for your inventory");
		System.out.println("\tw  -  for current equipped weapon and its stats");
		System.out.println("\tg  -  general guide of how to play");
	}
	
	public void attributes(){
		System.out.println("There are four attributes you can choose to put points in:");
		System.out.println("\tStrength - increases character health and melee damage.");
		System.out.println("\tIntelligence - increases a characters mana and spell damage");
		System.out.println("\tAgility - increases how fast your character attacks and moves");
		System.out.println("\tRanged - how far you can be from an opponent to do damage and more ranged damage");
	}

	public void intro(){
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");	
		System.out.print("Welcome to...\n\n\n\n\n");
		System.out.print("\t\t\t\tText Adventure V1.0\n\n");
		System.out.println("\t\t\t\tCreated by: Tyson Bulmer");
		System.out.print("\n\nThis game is a text based RPG adventure game.\n");
		System.out.println("You will venture through many lands and encounter a variety of enemies.");
		System.out.println("You will be able to customize how your character evolves and specializes,");
		System.out.println("whether you're a mana flowing mage, or a brute strength warrior or any other class.");
		System.out.println("You will be given choices of how to proceed in certain situations,");
		System.out.println("No two play throughs will be the same!");
		System.out.println("");
		System.out.println("");
		boolean ansd = false;
		while(ansd==false){
		System.out.println("\tReady to begin your adventure? (y/n)");
		System.out.println("\t(Enter 'y' for yes, or 'n' for no)");
		Scanner keyboard = new Scanner(System.in);
		String choice = keyboard.nextLine().trim();
		if(choice.equals("y") || choice.equals("Y")){
			System.out.println("Then lets begin!");
			ansd = true;
		}else if(choice.equals("n") || choice.equals("N")){
			System.out.println("Fine! I didn't want to play anyways...");
			ansd=true;
			System.exit(0);
			cont = false;
			
			
		}else{
			System.out.println("Please enter correct input.");
			ansd= false;
		}}
	}
	
	public void combat(Character name, Character enemy, int espaces, Location here)
	{
		boolean mainDef = false;
		boolean enemyDef = false;
		boolean loseTurn = false;
		int mageBuff= 0;
		boolean magePassiveBuff = false;
		int assassinBuff=0;
		int rangerBuff=0;
		boolean specialEff= false;
		Random r = new Random();
		int val = r.nextInt(espaces);
		System.out.println("You enter battle with a "+enemy.name);
		while(mainDef == false && enemyDef == false )
		{
			System.out.println("You are "+ val +" spaces from the enemy ");
			int chance = name.agility + (name.intelligence/2) + enemy.agility+(enemy.intelligence/2);
			Random l = new Random();
			int hit = l.nextInt(chance);
				if(hit>=name.agility+(name.intelligence/2))
				{
				if(loseTurn==true){
				loseTurn = false;
				System.out.println("Enemy lost a turn!");
				ent();
				continue;
				}
					System.out.println("Enemy gets to move");
					ent();
			
					if(enemy.melee.equals("melee"))
					{
						if(val>0)
						{
							System.out.println("Enemy moves forward");
							val--;
						}//end of enemy moves forward if
						else
						{
							System.out.println("Enemy swings");
							name.chealth = name.chealth - enemy.strength;
							System.out.println("hits you for "+ enemy.strength+".");
							System.out.println("Your health is now "+ name.chealth);
								if(name.chealth <= 0)
								{
									mainDef = true;
									System.out.println("You have been killed");
								}//end of check to see if main is dead if
						}//end of enemy swings and val = 0 else
						
					}//end of enemy melee equals "melee" if
					else if(enemy.melee.equals("ranged"))
					{
						System.out.println("Enemy shoots projectile");
						name.chealth = name.chealth - enemy.ranged;
						System.out.println("hits you for "+ enemy.ranged+".");
						System.out.println("Your health is now "+ name.chealth);
							if(name.chealth <= 0)
							{
								mainDef = true;
								System.out.println("You have been killed");
							}//end of check if main still alive if
			
					}//end of enemy attack equals "ranged" else if
					else
					{ 
						if (val>0)
						{
							Random pick = new Random();
							int gul = pick.nextInt(101);
							if(gul>50)
							{
								System.out.println(enemy.name + " moves forward");
								val--;
							}//end of enemy moves forward if
							else
							{
								System.out.println(enemy.name + " Shoots projectile");
								name.chealth = name.chealth - enemy.ranged;
								System.out.println("hits you for "+ enemy.ranged+".");
								System.out.println("Your health is now "+ name.chealth);
									if(name.chealth <= 0)
									{
										mainDef = true;
										System.out.println("You have been killed");
									}//end of check to see if main defeated if
							}//end of enemy shoots projectile else
						}//end of either move or shoot projectile enemy greater then 0 spaces away if 
						else
						{
							System.out.println(enemy.name + " swings weapon");
							name.chealth = name.chealth - enemy.strength;
							System.out.println("hits you for "+ enemy.strength+".");
							System.out.println("Your health is now "+ name.chealth);
								if(name.chealth <= 0)
								{
									mainDef = true;
									System.out.println("You have been killed");
								}//end of check to see if you survive hit if
						}//end of enemy melee attack
					}//end of enemy melee "both" else
				}//end of enemy moves if	
				else
				{
					 System.out.println("You get to move");
						if(name.melee.equals("melee"))
						{
							if(val > 0 )
							{
								System.out.println("you must be 0 spaces from the enemy before attacking");
								System.out.println("You must move forward, press 'm' to move.");
								Scanner keyboard = new Scanner(System.in);
								String choice = keyboard.nextLine();
								if(choice.equals("m"))
								{
									val--;
								}//end of choice equals "m" if
								else
								{
									System.out.println("loss of turn for wrong input.");
									continue;
								}//end of loss of turn for wrong input
		
							}//end of being more than 0 spaces from enemy if
							else
							{
								System.out.println("You can swing your weapon, enter 's' to swing");
								if(name.hasActSpecial == true&&name.chealth>1)
								{
									System.out.println("or enter 'e' to use "+name.actSpecial+".");
								
								}
								Scanner keyboard = new Scanner(System.in);
								String choice = keyboard.nextLine();
								if(choice.equals("s"))
								{
									Random meow = new Random();
									int pil = meow.nextInt(101);
									if(name.type.equals("warrior") && pil<=name.specialChance)
									{
										System.out.println("Special! Enemy is stunned.");
										enemy.chealth = enemy.chealth - (name.strength + (name.intelligence/4));
										System.out.println("You hit for "+ (name.strength + (name.intelligence/4))+".");
										System.out.println("Enemy health is now "+ enemy.chealth);
										loseTurn = true;
									}//end of special hit else
									else
									{
										enemy.chealth = enemy.chealth - name.strength;
										System.out.println("You hit for "+ name.strength+".");
										System.out.println("Enemy health is now "+ enemy.chealth);
									}//end of normal hit else
									if(enemy.chealth <= 0)
									{
										enemyDef = true;
										System.out.println("You have slain it");
										name.gaingold(enemy.gold);
										name.defeat();
										System.out.println("You gained "+enemy.gold+" gold.");
										System.out.println("You gained "+enemy.experience+" experience.");
										name.gainExp(enemy.experience);
										ent();
										findWep(here, enemy, name);
										ent();
						
									}//end of check to see if enemy is dead if
								}
								else if(choice.equals("e") && name.hasActSpecial==true && name.chealth>1)
								{
									int khl = useSpecial(name, enemy);
									if(enemy.chealth <= 0)
									{
										enemyDef = true;
										System.out.println("You have slain it");
										name.gaingold(enemy.gold);
										name.defeat();
										System.out.println("You gained "+enemy.gold+" gold.");
										System.out.println("You gained "+enemy.experience+" experience.");
										name.gainExp(enemy.experience);
										ent();
										findWep(here, enemy, name);
										ent();
						
									}//end of check to see if enemy is dead if
								
								}//end of choice equals "s" if 
								else
								{
									System.out.println("loss of turn for wrong input.");
									continue;
								}//end of wrong input else
			//
							}//end of being 0 spaces from enemy choices else
						}//end of melee "melee" if 
						else if(name.melee.equals("ranged"))
						{
							System.out.println("You have ranged attack to use a ranged attack enter '1' ");
							if(name.hasActSpecial==true&&name.cmana>=10 && name.type.equals("ranger")){
									System.out.println("or enter 'n' for "+name.actSpecial+".");
								
								}
							if(name.hasActSpecial==true&&name.cmana>=10 && name.type.equals("mage")){
									System.out.println("or enter 'f' for "+name.actSpecial+".");
								
							}
							Scanner keyboard = new Scanner(System.in);
							String choice = keyboard.nextLine();
							if(choice.equals("1"))
							{
				
								Random meow = new Random();
								int pil = meow.nextInt(101);
								
								if(name.type.equals("mage") && pil <=name.specialChance)
								{	
									if(specialEff==true)name.cmana += mageBuff;
									if(name.cmana>name.mana) name.cmana=name.mana; 
									System.out.println("Special! Barrier activated");
									magePassiveBuff= true;
									enemy.chealth = enemy.chealth - (name.ranged + (name.intelligence/4));
									System.out.println("You hit for "+ (name.ranged + (name.intelligence/4))+".");
									System.out.println("Enemy health is now "+ enemy.chealth);
									specialEff =false;
								}//end of special hit "mage" ability if
								else if(name.type.equals("ranger") && pil <=name.specialChance)
								{	
									
									System.out.println("Special! Head shot!");
									System.out.println("You hit for "+ enemy.chealth+".");
									enemy.chealth = enemy.chealth - enemy.chealth;
									System.out.println("Enemy health is now "+ enemy.chealth);
									specialEff =false;
								}//end of special hit "ranger" ability else if
								else
								{
									int hup =name.ranged/2;
									
									if(name.type.equals("ranger")&& specialEff==true){
										name.ranged +=rangerBuff;
										
									}
									if(name.type.equals("mage")&& specialEff==true){
										if(specialEff==true)name.cmana += mageBuff;
									if(name.cmana>name.mana) name.cmana=name.mana;
										
									}
									if(magePassiveBuff == true){
										
										name.ranged +=hup;
									}
									enemy.chealth = enemy.chealth - name.ranged;
									System.out.println("You hit for "+ name.ranged+".");
									System.out.println("Enemy health is now "+ enemy.chealth);
									if(name.type.equals("ranger")&& specialEff==true){
										name.ranged -=rangerBuff;
										
										
									} 
									if(magePassiveBuff == true){
										name.ranged -= hup;
										magePassiveBuff = false;
									}
									specialEff =false;
									
								}//end of normal hit else
								if(enemy.chealth <= 0)
								{
									enemyDef = true;
									System.out.println("You have slain it");
									name.gaingold(enemy.gold);
									name.defeat();
									System.out.println("You gained "+enemy.gold+" gold.");
										System.out.println("You gained "+enemy.experience+" experience.");
									name.gainExp(enemy.experience);
									ent();
									findWep(here, enemy, name);
									ent();
						
								}//end of check to see if enemy is dead if
							}//end of choice equals "1" if
							else if(choice.equals("n") && name.hasActSpecial == true && name.cmana>=10)
								{
									
									int kjl = useSpecial(name, enemy);
									rangerBuff = kjl;
									val += kjl;
									specialEff = true;
									
									if(enemy.chealth <= 0)
									{
										enemyDef = true;
										System.out.println("You have slain it");
										name.gaingold(enemy.gold);
										name.defeat();
										System.out.println("You gained "+enemy.gold+" gold.");
										System.out.println("You gained "+enemy.experience+" experience.");
										name.gainExp(enemy.experience);
										ent();
										findWep(here, enemy, name);
										ent();
						
									}//end of check to see if enemy is dead if
								
								}
								else if(choice.equals("f") && name.hasActSpecial == true && name.cmana>=10)
								{	int jup = name.intelligence/2;
										if(magePassiveBuff == true){
										
										name.intelligence +=jup;
										}
									mageBuff = useSpecial(name, enemy);
									specialEff = true;
									if(magePassiveBuff == true){
										magePassiveBuff = false;
										name.intelligence -=jup;
									}
									if(enemy.chealth <= 0)
									{
										enemyDef = true;
										System.out.println("You have slain it");
										name.gaingold(enemy.gold);
										System.out.println("You gained "+enemy.gold+" gold.");
										System.out.println("You gained "+enemy.experience+" experience.");
										name.defeat();
										name.gainExp(enemy.experience);
										ent();
										findWep(here, enemy, name);
										ent();
						
									}//end of check to see if enemy is dead if
								
								}
							else
							{
								System.out.println("loss of turn for wrong input.");
								continue;
							}//end of wrong input else
				
						}//end of melee "ranged" else if
						else
						{
							if(val>0)
							{
								System.out.println("You can move forward or use a ranged attack. enter 'm' to move,or '1' to range attack.");
								if(name.hasActSpecial==true&&name.cmana>=10){
									System.out.println("or enter 'p' for "+name.actSpecial+".");
								
								}
								Scanner keyboard = new Scanner(System.in);
								String choice = keyboard.nextLine();
								if(choice.equals("m"))
								{
									val--;
								}//end of choice equals "m" if
								else if(choice.equals("p") && name.hasActSpecial == true && name.cmana>=10)
								{
									assassinBuff = useSpecial(name, enemy);
									specialEff = true; 
									if(enemy.chealth <= 0)
									{
										enemyDef = true;
										System.out.println("You have slain it");
										name.gaingold(enemy.gold);
										name.defeat();
										System.out.println("You gained "+enemy.gold+" gold.");
										System.out.println("You gained "+enemy.experience+" experience.");
										name.gainExp(enemy.experience);
										ent();
										findWep(here, enemy, name);
										ent();
						
									}//end of check to see if enemy is dead if
								
								}
								else if(choice.equals("1"))
								{
									if(specialEff == true){
										name.ranged *= assassinBuff;
									}
									enemy.chealth = enemy.chealth - name.ranged;
									System.out.println("You hit for "+ name.ranged+".");
									System.out.println("Enemy health is now "+ enemy.chealth);
									if(specialEff == true){
										name.ranged /= assassinBuff;
									}specialEff = false;
									if(enemy.chealth <= 0)
									{
										enemyDef = true;
										System.out.println("You have slain it");
										name.gaingold(enemy.gold);
										name.defeat();
										System.out.println("You gained "+enemy.gold+" gold.");
										System.out.println("You gained "+enemy.experience+" experience.");
										name.gainExp(enemy.experience);
										ent();
										findWep(here, enemy, name);
										ent();
						
									}//end of check to see if enemy is dead if
								}//end of choice equals "1" else if
								else
								{
									System.out.println("loss of turn for wrong input.");
									continue;
								}//end of loss of turn input else
							}//end of x many spaces away if
							else
							{
								System.out.println("You can melee attack or use ranged attack. enter 's' for melee or '1' for ranged");
								if(name.hasActSpecial==true&&name.cmana>=10){
									System.out.println("or enter 'p' for "+name.actSpecial+".");
								
								}
								Scanner keyboard = new Scanner(System.in);
								String choice = keyboard.nextLine();
								if(choice.equals("s"))
								{
									if(specialEff == true){
										name.strength *= assassinBuff;
									}
									Random j = new Random();
									int k = j.nextInt(60);
									if(name.type.equals("assassin") && k <= name.specialChance)
									{
									System.out.println("Special! You strike 3 times!");
									enemy.chealth = enemy.chealth - (3*(name.strength + (name.intelligence/4)));
									System.out.println("You hit for "+ (3*(name.strength + (name.intelligence/4)))+".");
									System.out.println("Enemy health is now "+ enemy.chealth);
						
									}//end of special hit for assassin if
									else
									{
										enemy.chealth = enemy.chealth - name.strength;
										System.out.println("You hit for "+ name.strength+".");
										System.out.println("Enemy health is now "+ enemy.chealth);
										if(specialEff == true){
										name.strength /= assassinBuff;
									} specialEff=false;
									}//end of hit enemy with "melee" normal else
									if(enemy.chealth <= 0)
									{
										enemyDef = true;
										System.out.println("You have slain it");
										name.gaingold(enemy.gold);
										name.defeat();
										System.out.println("You gained "+enemy.gold+" gold.");
										System.out.println("You gained "+enemy.experience+" experience.");
										name.gainExp(enemy.experience);
										ent();
										findWep(here, enemy, name);
										ent();
						
									}//end of check to see if enemy dead if
								}//end of choice is "s" if 
								else if(choice.equals("1"))
								{
								if(specialEff == true){
										name.ranged *= assassinBuff;
										name.strength*=assassinBuff;
									}
									enemy.chealth = enemy.chealth - name.ranged;
									System.out.println("You hit for "+ name.ranged+".");
									System.out.println("Enemy health is now "+ enemy.chealth);
									if(specialEff == true){
										name.ranged /= assassinBuff;
										name.strength /= assassinBuff;
									}
									specialEff=false;
									if(enemy.chealth <= 0)
									{
										enemyDef = true;
										System.out.println("You have slain it");
										name.gaingold(enemy.gold);
										name.defeat();
										System.out.println("You gained "+enemy.gold+" gold.");
										System.out.println("You gained "+enemy.experience+" experience.");
										name.gainExp(enemy.experience);
										ent();
										findWep(here, enemy, name);
										ent();
						
									}//end of check to see if enemy dead if
								}//end of choice "1" else if
								else if(choice.equals("p") && name.hasActSpecial == true && name.cmana>=10)
								{
									assassinBuff = useSpecial(name, enemy);
									specialEff = true;
									
									if(enemy.chealth <= 0)
									{
										enemyDef = true;
										System.out.println("You have slain it");
										name.gaingold(enemy.gold);
										name.defeat();
										System.out.println("You gained "+enemy.gold+" gold.");
										System.out.println("You gained "+enemy.experience+" experience.");
										name.gainExp(enemy.experience);
										ent();
										findWep(here, enemy, name);
										ent();
						
									}//end of check to see if enemy is dead if
								
								}
								else
								{
									System.out.println("loss of turn for wrong input.");
									ent();
									continue;
								}//end of loss wrong input else		
							}//end of 0 spaces away else
						}//end of melee "both" else
				}//end of your turn else
		}//end of while loop
	}//end of combat function
	
	public int useSpecial(Character me, Character enemy/*, int dist*/){
			System.out.println("You use your "+me.actSpecial+".");
		if(me.type.equals("mage")){
			me.cmana -= 10;
			int min = GRN(me.intelligence*2);
			if(min<me.intelligence) min = min+(me.intelligence/2*3);
			
			int hit =min * GRN(me.specialChance*3/2);
			enemy.chealth -= hit;
			System.out.println("You hit for "+hit+"!");
			System.out.println("Enemy health is now "+enemy.chealth+"!");
			return (me.mana*5/100);
		}else if(me.type.equals("ranger")){
			int h = GRN(me.specialChance);
			
			System.out.println("You navigate "+h+ " spaces away from the enemy.");
			me.cmana -=10;
			return h;
		
		}else if(me.type.equals("warrior")){
			int k = GRN(me.agility/2);
			int dmg= (me.strength*3/2) * k;
			enemy.chealth -= dmg;
			System.out.println("In your rage you strike "+k+" times!");
			System.out.println("Dealing "+dmg+" damage!");
			System.out.println("Enemy health is now "+enemy.chealth+"!");
			int hpl = (me.chealth*5/100);
			me.chealth -= hpl;
			if(me.chealth<1) me.chealth=1;
			System.out.println("Due to the backlash of your enrage, your health is now "+me.chealth+"!");
			return 0;
		}else{
			int k = (me.ranged*3/2);
			enemy.chealth-=k;
			System.out.println("You hit for "+k+" damage!");
			me.mana-=10;
			System.out.println("Enemy health is now "+enemy.chealth+"!");
			return 2;
			
			
			
		}
	
	
	}
	
	//public void yourMove(Character me, Character enemy, int)
	
	public Character genEnemy(Location current){
		Random kew = new Random();
		int pil = kew.nextInt(3);
		if(current.name.equals("swamp")){
			if(pil==0){
				Character meh = new Character("swamp goblin", "warrior", "melee", 1, 10, 5, 3, 3, 0, 20, 0, 25, "none",0);
				return meh;
			}else if(pil==1){
				Character meh = new Character("killer rat", "warrior", "melee", 1, 15, 3, 7, 1, 0, 15, 0, 10, "none",0);
				return meh;
			}else{
				Character meh = new Character("needle spitter", "ranger", "ranged", 1, 20, 0, 6, 4, 6, 15, 0, 15, "none",0);
				return meh;
			}
			
		}else if(current.name.equals("cave")){
			if(pil==0){
				Character meh = new Character("Giant worm", "warrior", "melee", 2, 30, 7, 10, 4, 0, 30, 0, 15, "none",0);
				return meh;
			}else if(pil==1){
				Character meh = new Character("Killer bat", "warrior", "melee", 2, 40, 6, 12, 4, 0, 25, 0, 25, "none",0);
				return meh;
			}else{
				Character meh = new Character("thief", "assassin", "both", 2, 40, 6, 10, 10, 6, 20, 0, 40, "none",0);
				return meh;
			}
		
		
		
		}else if(current.name.equals("Gang hide out")){
			if(pil==0){
				Character meh = new Character("silent member", "ranger", "ranged", 2, 30, 0, 6, 7, 9, 35, 0, 20, "none",0);
				return meh;
			}else if(pil==1){
				Character meh = new Character("guard", "warrior", "melee", 2, 40, 10, 7, 5, 0, 45, 0, 25, "none",0);
				return meh;
			}else{
				Character meh = new Character("thief", "assassin", "both", 2, 25, 6, 10, 10, 6, 20, 0, 40, "none",0);
				return meh;
			}
		
		
		
		}else if(current.name.equals("mountain")){
			if(pil==0){
				Character meh = new Character("bear", "warrior", "melee", 2, 30, 10, 5, 1, 0, 35, 0, 25, "none",0);
				return meh;
			}else if(pil==1){
				Character meh = new Character("killer birds", "warrior", "melee", 1, 25, 5, 9, 2, 0, 20, 0, 15, "none",0);
				return meh;
			}else{
				Character meh = new Character("cougar", "warrior", "melee", 2, 30, 6, 7, 4, 0, 30, 0, 20, "none",0);
				return meh;
			}
		}else{
			if(pil==0){
				Character meh = new Character("archer goblin", "ranger", "ranged", 2, 30, 0, 7, 6, 4, 20, 0, 20, "none",0);
				return meh;
			}else if(pil==1){
				Character meh = new Character("small game hunter", "warrior", "both", 1, 10, 3, 6, 7, 3, 18, 0, 40, "none",0);
				return meh;
			}else{
				Character meh = new Character("cougar cub", "warrior", "melee", 1, 5, 2, 10, 2, 0, 10, 0, 10, "none",0);
				return meh;
			}
			
		}
		
	}
	
	public int GRN(int in){
		Random con = new Random();
		int out = con.nextInt(in);
		return (out+1);
	}
	
	
	
	public Character genBoss(Location area){
		if(area.name.equals("swamp")){
			Character boss = new Character("Swamp Witch", "mage", "ranged", 2, 100, 0, 6, 8, 12, 90, 40, 100, "none", 0);
			return boss;
		
		}else if(area.name.equals("mountain")){
				Character boss = new Character("Mountain Ogre", "warrior", "melee", 2, 100, 15, 7, 4, 0, 115, 0, 150, "none", 0);
				return boss;
		}else if(area.name.equals("Gang hide out") ){
				Character boss = new Character("Gang Leader", "warrior", "melee", 2, 125, 12, 8, 7, 0, 90, 0, 350, "none", 0);
				return boss;
		
		}else if(area.name.equals("cave") ){
				Character boss = new Character("Trickster", "assassin", "both", 2, 125, 10, 7, 11, 7, 75, 0, 350, "none", 0);
				return boss;
		
		}else{
				Character boss = new Character("Forest Bowmen", "ranger", "both", 2, 100, 8, 8, 8, 8, 80, 0, 200, "none", 0);
				return boss;
		}
	
	}

	public void run(Character main, Location field){
		System.out.println("You enter the " + field.name);
		System.out.println("There are "+field.spaces+" spaces to advance through this terrain.");
		System.out.println("You begin you're adventure!");
		ent();
		boolean survived =true;
				for(int k=0; k<field.spaces; k++){
					System.out.println("In space " +(k+1)+", you...");
				if((k+1)==field.spaces && field.boss == true){
					System.out.println("You've encountered this runs boss!");
					ent();
					Character boss = genBoss(field);
			combat(main, boss, field.encounterSpaces,field);
					if(main.chealth<0) survived = false;
				}else{
					
					if(field.encounter(main)){
						Character boo = genEnemy(field);
			combat(main, boo, field.encounterSpaces,field);
			if(main.chealth <= 0){
				System.out.println("You have slain "+main.enemiesDefeated+" enemies this run through and achieved level "+main.level+".");
				survived = false;
				break;
			}
					}else{
							continue;
						}
					System.out.println("You proceed a space forward.");
					ent();
					System.out.println("Now you can look at the game menu by entering 'gm',");
					System.out.println("or enter anything else to continue. ");
				
					Scanner nm = new Scanner(System.in);
					String mn = nm.nextLine();
					if(mn.equals("gm")){
						gameMenu(main);
					}else{
						System.out.println("*");
						System.out.println("*");
						System.out.println("*");
						System.out.println("*");
					}
					
				
				}}
				if(survived==true){
					System.out.println("Congratulations you reached the end of the "+field.name+". You have now slain a total of "+main.enemiesDefeated+" enemies have and achieved level "+main.level+".");
				}else{
					System.out.println("You have been defeated.");
					System.exit(0);
				}
		
	
	
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
	
	public String genWeapon(Character main){
	
		if(main.type.equals("mage")){
			return "Staff";
		}
		if(main.type.equals("warrior")){
			return "Sword";
		}
		if(main.type.equals("ranger")){
			return "Bow";
		}
		if(main.type.equals("assassin")){
			return "Daggers";
		}
		return "";
	
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
	
	public void classExpl(Character name){
		
		if(name.type.equals("mage")){
			System.out.println("Your chosen class is the 'Mage'. The mage is a range attack only character. ");
			System.out.println("The mage uses the intelligence attribute for his spells and abilities. ");
			System.out.println("The higher your intelligence attribute, the more often your special ability will occur.");
			System.out.println("Your special ability is a 'barrier'. Which prevents 50% of the next damage you take and increases the damage you do. ");
		
		}else if(name.type.equals("warrior")){
			
			System.out.println("Your chosen class is the 'Warrior'. The warrior is a melee attack only character.");
			System.out.println("The warrior uses the strength attribute for his abilities.");
			System.out.println("The higher your strength attribute, the more often his special ability will occur.");
			System.out.println("Your special ability is 'stun'. Which stuns the enemy stopping them from there next turn and deals extra damage.");
		
		}else if(name.type.equals("ranger")){
			System.out.println("Your chosen class is the 'Ranger'. The ranger is a range attack only character.");
			System.out.println("The ranger uses the ranged attribute, for his special abilities.");
			System.out.println("The higher you ranged attribute the more often your special abilities will occur.");
			System.out.println("Your special ability is 'head shot'. Which is an instant kill on any common enemy (Not bosses though).");
		
		}else{
		
			System.out.println("Your chosen class is the 'Assassin'. The assassin has both ranged and melee attacks.");
			System.out.println("The assassin uses the agility attribute for his special ability.");
			System.out.println("The higher your agility attribute, the more often your special ability will occur. ");
			System.out.println("Your special ability is 'triple strike'. When you use your melee, the triple strike will hit for three times the damage.");
		
		}
	
	
	}
	
	public void ExplLand(){
	
		System.out.println("When you enter a 'adventure terrain' this is when you will encounter enemies and even possibly a boss.");
		System.out.println("There are a set amount of spaces you must move to reach the end of each terrain.");
		System.out.println("Everytime you move a space you will either; encounter an enemy and engage in combat,");
		System.out.println("or have a turn to look for treasure or use a potion to heal.");
		System.out.println("Careful what you input though, if you enter an invalid choice you lose that turn entirely.");
		
	}

	public void fallenManOption1(Character me) throws IOException{
		System.out.println("You approach the fallen man.");
		ent();
		System.out.println("Fallen man: 'Please don't hurt me, I have nothing left too take.'");
		ent();
		System.out.println(me.name+": 'I'm not here to hurt you, what has happened?'");
		ent();
		System.out.println("Fallen man: 'I was just heading home with my materials I had bought from the market, ");
		System.out.println("when out of no where a gang of bandits attacked me and took everything I had. I need ");
		System.out.println("those materials, if you help get them back I would surely reward you.'");
		ent();
		boolean ansd = false;
		while(ansd==false){
		System.out.println("Do you accept the quest?");
		System.out.println("Enter 'y' for yes, or 'n' for no.");
		Scanner in = new Scanner(System.in);
		String ch = in.nextLine();
		if(ch.equals("y")){
			System.out.println(me.name+": 'Yes, I will help you get your materials back.'");
			ent();
			System.out.println("Fallen man: 'Thank you young traveller, there hide out is just south of here. Be careful though,'");
			System.out.println("their gang leader is very dangerous. ");
			ent();
			Location gang = new Location("Gang hide out",2,55,true,15,15,4);
			run(me, gang);
			ent();
			System.out.println("After defeating the 'Gang Leader' you acquire the stolen materials and head back.");
			ent();
			System.out.println("Fallen man: 'Thank you so much for returning my materials..'");
			ent();
			System.out.println("Fallen man: 'You must be tired and its getting dark out, you may rest at my house for the night.'");
			ent();
			me.chealth=me.health;
			me.cmana = me.mana;
			System.out.println("You rest for the night.");
			ent();
			
			System.out.println("You awake to the sound of the man rummaging through a chest.");
			ent();
			System.out.println("Fallen man: 'To repay you, I would like you to have this weapon I made.");
			System.out.println("It is of no use to an old man like me anymore.'");
			ent();
			String fall2 = genWeapon(me);
			String fall1 = fall2 + " of the Righteous";
			System.out.println("You've acquired the "+fall1);
			ent();
			Weapon falman = new Weapon(fall1, fall2, 2, 5,5,5,5,10,10);
			me.inventory.addWep(falman);
			me.inventory.listWeps();
			saveGame ghjk = new saveGame();
			ghjk.save(me);
			ent();
			ansd= true;
		}else if(ch.equals("n")){
			System.out.println(me.name+": 'I do not have time for this, sorry.'");
			ent();
			System.out.println("You walk away from the fallen man. ");
			
			ansd=true;
		}else{
			System.out.println("Invalid option please enter correct input");
			ansd=false;
		}
		}
		
	}
	
	public void fallenManOption2(Character me){
			System.out.println("You approach the fallen man.");
			ent();
			System.out.println("Oh no! You are jumped by a gang of bandits.");
			System.out.println("The fallen man and the bandits take off with all of your gold.");
			int k = me.gold;
			me.gold = 0;
			ent();
			boolean ansd = false;
			while(ansd==false){
			System.out.println("Do you chase after them?");
			System.out.println("Enter 'y' for yes, or 'n' for no.");
			Scanner in = new Scanner(System.in);
			String jr = in.nextLine();
			if(jr.equals("y")){
			System.out.println("You follow them into a cave!");
			ent();
			Location cave = new Location("cave",2,60,true,5,17,3);
			run(me, cave);
			me.gold += k;
			System.out.println("After you defeated the 'Trickster' you take your gold back. ");
			
				ansd = true;		
			}else if(jr.equals("n")){
				System.out.println("You let them get away, but pick up a note one of them must have dropped.");
				ent();
				System.out.println("\t'The Plan'");
				System.out.println("");
				System.out.println("\t\t'Get as much gold as you can and meet just south of Prilos.");
				System.out.println("\tThere we'll put all the gold we've stolen together and split it up evenly.'");
				ent();
				
			ansd = true;
			}else{
				System.out.println("Invalid options please enter correct syntax.");
			}
			
			}
			
	
	}
	
	public void shortcut(Character me, Location here){
		ent();
		System.out.println("As you travel further into to the "+here.name+" you feel a strong dark presence.");
		ent();
		run(me,here);
		ent();
		System.out.println("The dark presence in the "+here.name+" is lifted.");
	
	
	
	}
	
	
	public void longWay(Character me, Location here){
		ent();
		System.out.println("You take the long way around the "+here.name+".");
		ent();
		run(me,here);
		ent();
	
	}
	
	public Character genRandomEnemy(Character me){
		String nme = "";
		String tpe = "";
		String mle = "";
		switch(GRN(7)){
			case 1 : nme = "Goblin";
					 tpe = "ranger";
					 mle = "ranged";
					break;
			case 2 : nme = "Ogre";
					 tpe = "warrior";
					 mle = "melee";
					break;
			case 3 : nme = "Archer";
					 tpe = "ranger";
					 mle = "ranged";
					break;
			case 4 : nme = "Thief";
					 tpe = "assassin";
					 mle = "both";
					break;
			case 5 : nme = "Bandit";
					 tpe = "assassin";
					 mle = "both";
					break;		
			case 6 : nme = "Dragon";
					 tpe = "mage";
					 mle = "both";
					break;
			case 7 : nme = "God";
					 tpe = "mage";
					 mle = "ranged";
					break;
			default: nme = "cat";
					 tpe = "assassin";
					 mle = "melee";
                     break;	
		
		}
		
		
		int str = GRN(me.strength+3);
		int agl = GRN(me.agility+3);
		int intel = GRN(me.intelligence +3);
		int rng = GRN(me.ranged+3);
		int gld = GRN(me.level*10+10);
		int exp = GRN(me.level*10+10);
		int hp = GRN(me.health/3)+10;
		int mna = GRN(me.mana/3)+10;
		String spc = "none";
		int sch = 0;
		
		Character him = new Character(nme,tpe,mle,me.level, exp,str,agl,intel,rng,hp,mna,gld,spc,sch);
		return him;
	
	}
	
	public void hide(){
		System.out.println("You quickly sneak into a bush on the side of the road.");
		ent();
	}
	
	public void keepWalking(){
	
	
	}
	
	public boolean YorN(){
		boolean o = false;
		boolean a =false;
		while(a = false){
		System.out.println("Enter 'y' for yes, or 'n' for no.");
		Scanner inp = new Scanner(System.in);
		String in = inp.nextLine();
		if(in.equals("y")){
			o =  true;;
			a = true;
		}else if(in.equals("n")){
			o = false;
			a = true;
		}else{
			System.out.println("Invalid input, please enter correct syntax.");
			a = false;
			
		}
		}
		return o;
	}
	
	public Character chapteronep1(Character he) throws IOException{
				System.out.println("We'll begin with making your character!");
				Character game = new Character();
				game.getStats();
				
			//	saveGame ghjk = new saveGame();
			//	ghjk.save(game);
				
				ent();
				classExpl(game);
				ent();
				System.out.println("");
				System.out.println("Welcome "+ game.type + ". You will be known as "+ game.name + ".");
				ent();
				System.out.println("Your adventure begins in your home town of Sherant.");
				ent();
				System.out.println("Sherant is a peaceful and isolated town in the land of Dantella.");
				System.out.println("Most of the lands are being taken over by the dark ruler known as 'Lord Draxdes'.");
				ent();
				System.out.println("Your father is a great "+game.type+", who has fought in many wars.");
				System.out.println("You follow closely in your fathers foot steps, for one day you will be a champion like him.");
				ent();
				System.out.println("You wake up to the sound of your father closing the door... ");
				ent();
				System.out.println("You see a note on your dresser:");	
				ent();
				System.out.println("\t'Dear "+game.name+",");
				System.out.println("\t\tOur ally city in the south has been invaded, and they have called all Champions to arms.");
				System.out.println("\tI must fulfil my oath and act upon this for we face a great threat in these dark times.");
		
				System.out.println("\tYou have come to the age now where you must become a true soldier, and fight for what you believe.");
	
				System.out.println("\tI have sent word to your uncle, in the east, that you will require training from him.");
				System.out.println("\tHe will show you the true ways of the "+game.type+".");
				System.out.println("");
				System.out.println("\t\tI have left you with weapons and supplies, so you can make it to your uncles safely.");
				System.out.println("\tBe careful, the world is filled with liars and threats around every corner. Trust your instincts.");
				System.out.println("");
				System.out.println("\t\tSincerely, your Father.' ");
		
				ent();
		
				String wep = genWeapon(game);
				System.out.println("You grab the "+wep+" your father left you and head out the door.");
				String basic = "Basic " + wep;
				Weapon first = new Weapon(basic, wep, 1, 2,3,1,2, 5, 5);
				equip(game,first);
				game.inventory.addWep(first);
				game.inventory.listWeps();
	
				ent();
				System.out.println("With your "+first.name+ " equipped, your new stats are...");
				game.getStats();
		

				ent();
				String ke = new String("");
				int firstRun = GRN(3);
		
				if(firstRun==1){
					ke += "forest";
		
				}else if(firstRun==2){
					ke += "swamp";
			
				}else{
					ke += "mountain";
				}
				game.cLocation = ke;
				System.out.println("You head out the door towards the east.");
				System.out.println("You must travel through the 'quiet "+ke+"'.");
				ent();
				System.out.println("Now is time to explain how these 'runs' work.");
				ent();
				ExplLand();
				ent();
					Location here = new Location(ke,1,45,false,10,15,5);
			
				//	System.out.println("Level one run through");
					run(game,here);
					ent();
					System.out.println("You step out of the "+here.name+" to see a fallen man on the ground.");
					ent();
					System.out.println("Fallen man: 'Is someone there? Please help me.'");
					ent();
					boolean good = true;
					boolean ansd = false;
					int man = GRN(2);
					if(man==1){
						good = true;
					}else{
						good = false;
					}
			
					while(ansd == false){
					System.out.println("Do you help the man?");
					System.out.println("Enter 'y' for yes, or 'n' for no");
					Scanner in = new Scanner(System.in);
					String je = in.nextLine();
					if(je.equals("y")&& good==true){
						fallenManOption1(game);
						ansd=true;
				
				
					}else if(je.equals("y")&& good == false){
						fallenManOption2(game);
						ansd=true;
					}else if(je.equals("n")){
						System.out.println("You ignore the mans call for help. ");
						ansd=true;
					}else{
						System.out.println("Couldn't understand input");
						ansd=false;
					}
				}
				ent();
				
				
				
				return game;
	
	}
	
	public Character chapteronep2(Character game) throws IOException{
	
				String ke = game.cLocation;
				System.out.println("... and so you continue to your uncles in the east. ");
				ent();
				System.out.println("You continue through the "+ke+", but something doesn't feel right... ");
				ent();
				System.out.println("You see animals running away from the direction you are heading.");
				ent();
		
				boolean anw = false;
				while(anw==false){
					System.out.println("Do you continue the way your going to your uncles instead of the longer route around?");
					System.out.println("Enter 'y' for yes, or 'n' for no");
					Scanner kj = new Scanner(System.in);
					String lk = kj.nextLine();
					if(lk.equals("y") || lk.equals("Y")){
						Location qwe = new Location(ke,2,55,true,20,10,4);
						shortcut(game, qwe);
						anw = true;
			
					}else if(lk.equals("n") || lk.equals("N")){
						Location qwe = new Location(ke,2,45,false,10,17,5);
						longWay(game, qwe);
						anw = true;
			
					}else{
						System.out.println("Invalid choice please enter correct syntax.");
						anw = false;
					}
		
		
				}
				ent();
				System.out.println("You finally arrive at your uncles house.");
				ent();
				System.out.println("Uncle Dres: 'Ahh "+game.name+", I have been waiting for you.");
				System.out.println("Your father has sent word to me of what is happening, and it");
				System.out.println("is time you learned the ways of the "+game.type+".");
				ent();
				System.out.println("But it is late and you have traveled far. Rest for now. We ");
				System.out.println("will begin training in the morning...'");
				game.chealth = game.health;
				game.cmana = game.mana;
				ent();
				System.out.println("The next morning you begin training with your uncle.");
				ent();
				if(game.type.equals("assassin")){
					System.out.println("Uncle Dres: 'A true assassin always knows his targets weak spots.");
					System.out.println("Use a throwing knife to hit it and your target will take extra damage");
					System.out.println("every time you strike. For a quick and clean kill... well it's not that clean.'");
					game.actSpecial = "Precise Strike";
					game.hasActSpecial = true;
					ent();
		
				}else if(game.type.equals("warrior")){
					System.out.println("Uncle Dres: 'A true warrior is not afraid to take extra damage.");
					System.out.println("Use your rage to move faster and do more damage. It may hurt afterwards, ");
					System.out.println("but it's worth it every time.'");
					game.actSpecial = "Enrage";
					game.hasActSpecial = true;
					ent();
		
				}else if(game.type.equals("ranger")){
					System.out.println("Uncle Dres: 'A true ranger knows distance is always a close ally.");
					System.out.println("Use your keen navigation skills to move away from enemies, to take them out from afar.");
					System.out.println("This will give you an overall advantage... not that you'll need it.' ");
					game.actSpecial = "Navigation";
					game.hasActSpecial = true;
					ent();
			
		
				}else{
					System.out.println("Uncle Dres: 'A true mage harnesses the powers of the elements.");
					System.out.println("Use your powerful magic to cast elemental spells which do additional damage every turn.");
					System.out.println("Master this and your mana could seem limitless.");
					game.actSpecial = "Fire Blast";
					game.hasActSpecial = true;
					ent();
		
				}
				String cat = genWeapon(game);
				cat+=" of the Righteous";
				if(game.wep.name.equals(cat)){
		
				System.out.println("Uncle Dres: 'Ahh I see you already have found quite a powerful weapon.' ");
				ent();
				}else{
					System.out.println("Uncle Dres: 'Now that you are one step closer to being a master "+game.type+",");
					System.out.println("you will need a better weapon then the one you've got.'");
					ent();
					String family = genWeapon(game);
					String family2 = family + " of Fate";
					Weapon second = new Weapon(family2, family, 3, 4,6,6,3, 10, 10);
					System.out.println("Uncle Dres hands you the "+family2+".");
					ent();
					
					game.inventory.addWep(second);
					game.inventory.listWeps();
					ent();
			
				}
				
				saveGame ghjk = new saveGame();
				ghjk.save(game);
				
				System.out.println("Uncle Dres: 'Now you are prepared enough to travel to the city of Prilos.");
				System.out.println("I have taught you every thing I can, with your new skill you are much stronger,");
				System.out.println("but be careful for the foes you have faced are nothing compared to what lies ahead...");
				System.out.println("Here take these potions you will need them.'");
				ent();
				System.out.println("Uncle Dres: 'In Prilos is a man who can take you where you need to go,"); 
				System.out.println("but only if he sees you worthy of it. His name is Torend. He is an old family friend, but times are changing...  ");
				System.out.println("Just remember to keep your eyes open. Good luck.'");
				ent();
				
				return game;
	}
	
	public Character chaptertwop1(Character game){
				System.out.println("You set off to the city of Prilos");
				ent();
				System.out.println("As you make your way down the road you see ahead in the distance what looks to be a ");
				System.out.println("brigade of soldiers and a carriage. They are heading in your direction.");
				ent();
				boolean a = false;
				while (a == false){
				System.out.println("Do you hide in the bushes?");
				System.out.println("Enter 'y' for yes, or 'n' for no");
				Scanner q = new Scanner(System.in);
				String c = q.nextLine();
				if(c.equals("y") || c.equals("Y")){
					hide();
					a = true;
				
				}else if(c.equals("n") || c.equals("N")){
					keepWalking();
					a = true;
				
				}else{
					System.out.println("Invalid input please enter correct syntax");
					a=false;
				}
				}
				
				
				return game;
	}
	
	public Character loadCharacter(String fileName, Character game) throws FileNotFoundException{
		
		try{
		
		
		Scanner in = new Scanner(new File(fileName));
		
		game.name = in.nextLine();
		game.type = in.nextLine();
		game.melee = in.nextLine();
		game.level = in.nextInt();
		in.nextLine();
		game.experience = in.nextInt();
		in.nextLine();
		game.strength = in.nextInt();
		in.nextLine();
		game.agility = in.nextInt();
		in.nextLine();
		game.intelligence = in.nextInt();
		in.nextLine();
		game.ranged = in.nextInt();
		in.nextLine();
		game.health = in.nextInt();
		in.nextLine();
		game.chealth = in.nextInt();
		in.nextLine();
		game.mana = in.nextInt();
		in.nextLine();
		game.cmana = in.nextInt();
		in.nextLine();
		game.gold = in.nextInt();
		in.nextLine();
		game.enemiesDefeated = in.nextInt();
		in.nextLine();
		game.hpotions = in.nextInt();
		in.nextLine();
		game.mpotions = in.nextInt();
		in.nextLine();
		game.hasActSpecial = in.nextBoolean();
		in.nextLine();
		game.special = in.nextLine();
		game.actSpecial = in.nextLine();
		Inventory ju = new Inventory();
		game.inventory = ju; 
		if(in.hasNextLine()){
		while(in.hasNextLine()){
		Weapon it = new Weapon();
		
		it.name = in.nextLine();
	
		
		it.type = in.nextLine();
		
		it.level = in.nextInt();
		in.nextLine();
		it.strength = in.nextInt();
		in.nextLine();
		it.agility = in.nextInt();
		in.nextLine();
		it.intelligence = in.nextInt();
		in.nextLine();
		it.ranged = in.nextInt();
		in.nextLine();
		it.healthup = in.nextInt();
		in.nextLine();
		it.manaup = in.nextInt();
		in.nextLine();
		game.inventory.addWep(it);
		
		
		
		} 
		}
		
		
		
		in.close();
		return game;
		}
		catch(FileNotFoundException e){
			System.out.println("\t\t\t***File not found***");
			System.out.println("\t\t\tPlease enter correct file name.");
			System.out.println("\t\t\teg, 'file.txt'");
			System.out.println("Back to start menu...");
			start(game);
		}return game;
	
		
	}
	
	public Character start(Character game) throws FileNotFoundException{
			boolean ansd= false;
			
			while(ansd == false){
			System.out.println("To start a new game enter '1'");
			System.out.println("or,");
			System.out.println("To continue a previous game enter '2'");
			
			Scanner opt = new Scanner(System.in);
			String opti = opt.nextLine();
			if(opti.equals("1")){
				game = new Character(1);
				ansd = true;
				
			}else if(opti.equals("2")){
				System.out.println("Please enter saved text file name.");
				Scanner in = new Scanner(System.in);
				String txt = in.nextLine();
				game = loadCharacter(txt, game);
				game.recalcSpecialChance();
				
				ansd = true;
				
				
				
			}else{
				System.out.println("Invalid input, please enter valid Syntax.");
				ansd = false;
			}
			
			}
	return game;
	}
	
	public void findWep(Location here, Character enemy, Character main){
		
		int k = GRN(100);
		int j = (enemy.health/3) + (here.trseChnce);
		if( k <= j){
			Weapon ran = new Weapon();
			ran = ran.generateRanWep(enemy);
			System.out.println("Enemy dropped a weapon!");
			System.out.println("You found:");
			ran.wepStats();
			
			boolean ansd = false;
			while (ansd==false){
				System.out.println("Do you take the weapon?");
				System.out.println("Enter 'y' for yes, or 'n' for no.");
				Scanner in = new Scanner(System.in);
				String inp = in.nextLine();
				if(inp.equals("y")){
					main.inventory.addWep(ran);
					
					main.inventory.listWeps();
				
				ansd = true;
				}else if(inp.equals("n")){
				
				ansd = true;
				}else{
					System.out.println("Invalid option, please enter correct syntax.");
					ansd = false;
				
				}
			
			
			
			
			
			}
			
		}else{
				
			}
	
	
	}
	
	public void gameMenu(Character main){
		System.out.println("\tTo display Character stats enter: \t'ds'");
		System.out.println("\tTo view your inventory enter: \t\t'vi'");
		System.out.println("\tTo go to main menu enter:\t\t'mm'");
		System.out.println("\tTo return to game enter:\t\t 'q'");
		boolean ansd = false;
		while(ansd==false){
			Scanner in = new Scanner(System.in);
			String inp = in.nextLine();
			if(inp.equals("ds")){
				main.getStats();
				ansd = true;
				gameMenu(main);
			}else if(inp.equals("vi")){
				inventoryMenu(main);
				ansd = true;
				gameMenu(main);
		
			}else if(inp.equals("mm")){
				boolean fgh = false;
				while(fgh==false){
				System.out.println("Warning going to main menu will exit current game and lose all unsaved progress.");
				System.out.println("Are you sure you want to exit?");
				System.out.println("Enter 'y' for yes, or 'n' for no.");
				
					Scanner ing = new Scanner(System.in);
					String inpg = in.nextLine();
					if(inpg.equals("y")){
						mainMenu(main);
						ansd = true;
						System.exit(0);
					}else if(inpg.equals("n")){
						gameMenu(main);
						ansd = true;
					}else{
						System.out.println("Invalid input, please enter correct syntax.");
					}
				
				
				}
			}else if(inp.equals("q")){
	   			ansd = true;
			}else{
				System.out.println("Invalid option, please enter correct syntax.");
			}
		
	}
	}
	
	public void inventoryMenu(Character main){
		System.out.println("To view/ equip/ unequip weapons enter: \t\t'w'");
		System.out.println("To view potions enter:\t\t\t\t'p'");
		System.out.println("To return to previous menu enter:\t\t'q'");
		boolean ansd = false;
		while(ansd == false){
			Scanner in = new Scanner(System.in);
			String inp = in.nextLine();
		if(inp.equals("w")){
			main.inventory.listWeps();
			System.out.println("To equip a certain weapon enter its slot number.");
			System.out.println("\teg: to equip weapon in slot 2 you would enter: '2' ");
			System.out.println("");
			System.out.println("To drop a weapon enter its slot number spelt out.");
			System.out.println("\teg: 'zero', 'one', 'two', 'three' or 'four'.");
			System.out.println("\teg: to drop weapon in slot 2 you enter: 'two'");
			System.out.println("");
			System.out.println("To return to previous menu enter: 'q'");
			boolean ans = false;
			while(ans==false){
				Scanner onp = new Scanner(System.in);
				String on = onp.nextLine();
				if(on.equals("0")||on.equals("1")||on.equals("2")||on.equals("3")||on.equals("4")){
					int k = DatatypeConverter.parseInt(on);
					equip(main, main.inventory.weps[k]);
					ans = true;
					ansd=true;
				}else if(on.equals("zero")){
					main.inventory.dropWep(0);
					ans= true;
					ansd=true;
				}else if(on.equals("one")){
					main.inventory.dropWep(1);
					ans=true;
					ansd= true;
				}else if(on.equals("two")){
					main.inventory.dropWep(2);
					ans=true;
					ansd=true;
				}else if(on.equals("three")){
					main.inventory.dropWep(3);
					ans=true;
					ansd = true;
				}else if(on.equals("four")){
					main.inventory.dropWep(4);
					ans=true;
					ansd=true;
					}else if(on.equals("q")){
					ans=true;
					ansd= true;
					}else{
						System.out.println("Invalid input, please enter correct syntax.");
						ans = false;
						
					}
				}
				}
				 else if(inp.equals("p")){
					System.out.println("Health potions: "+main.hpotions);
					System.out.println("Mana potions: "+main.mpotions);
					ansd = true;
				}else if(inp.equals("q")){
					ansd = true;
				}else{
					System.out.println("Invalid input, please enter correct syntax.");
					ansd = false;
			} 
		}
	
	
	}
	
	public void mainMenu(Character main){
		System.out.println("\t\tText Adventure V1.0");
		System.out.println("");
		System.out.println("\t\t\tWelcome to the main menu");
		System.out.println("\tHere you can:");
		System.out.println("\t\t-Start a new game:\t\t'ng'");
		System.out.println("\t\t-Load a different Character:\t'lc'");
		System.out.println("\t\t-Continue your story from your last save:\t'cont'");
		System.out.println("\t\t-Enter 'Horde' mode:\t\t'hm'");
	
	}
			
	public void hordeMode(Character main){
		System.out.println("Welcome to 'Horde mode'");
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("Here you will face waves of enemies and be rewarded a random item");
		System.out.println("every 10 waves. ");
		
	}	
	

public static void main(String [] args) throws IOException{
			Story the = new Story();
			
			System.out.println("*");
			System.out.println("*");
			System.out.println("*");	
			System.out.print("Welcome to...\n\n\n\n\n");
			System.out.print("\t\t\t\tText Adventure V1.0\n\n");
			System.out.println("\t\t\t\tCreated by: Tyson Bulmer");
			the.ent();
			the.you = the.start(the.you);
			if(the.you.experience > 0){
				the.ent();
				System.out.println("You've successfully loaded your character.");
				the.ent();
				the.you.getStats();
				the.gameMenu(the.you);
				the.fallenManOption1(the.you);
				the.fallenManOption2(the.you);
			
			}else{
			
				the.intro();
				the.you = the.chapteronep1(the.you);
				the.you = the.chapteronep2(the.you);
				the.you = the.chaptertwop1(the.you);
			
			
			}
				
				
	



}//end of main


/*
			Switch function:
			
			
			 int month = 8;
        String monthString;
        switch (month) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        System.out.println(monthString);
    }
}



*/





}