import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.util.Random;
import java.applet.*;
import java.net.*;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import javax.sound.sampled.*;
/**
 * Write a description of class TEXTgame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextGmae
{
    // instance variables - replace the example below with your own
    public static void main (String[] args) {

        System.out.println("\u000c");

        // system objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        //game varibles
        String[] enemies = { "Skeleton","Zombies","Warrior","Assassin", };
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 50;

        int roomNumber = 0;
        int destination = 0;

        String[] flavourText = {".","You start walking down a dark coobled hallway,the only way foward is east","you find yourself in a badly lit stair well which leads down a couple of flights","you see a storage room with a sillouette standing there, only way to continue is going south","you see prayer room with a sillouette standing there, only way to continue is going west","you see a dark room with a sillouette standing there, you can go south or west","You finally made it to the end","you look around, its pitch black. you can only go north", "the room is very roomy looking, you room around but only if you room west.",};

        //String[] goNorth
        //String[] goSouth
        //String[] goEast
        //String[] goWest
        //String[] goUp
        //String[] goDown

        int[] goNorth = {-1,-1,-1,-1,-1,-1,3,4,5,-1,};
        int[] goEast =  {1,2,-1,4,5,-1,-1,8,-1,-1,-1,};
        int[] goSouth = {-1,-1,-1,6,7,8,-1,-1,-1,-1,-1,};
        int[] goWest =  {-1,-1,-1,-1,3,4,1,-1,7,-1,-1,};
        int[] goUp =    {-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1,};
        int[] goDown =  {-1,-1,5,-1,-1,-1,-1,-1,-1,-1,-1,};

        //player varibels 
        int health = 1000;
        int attackDamage = 50;
        int numHealthPots = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;
        int moneyHeld = 0;
        int moneyGiven = 2230;

        boolean running = false;
        slowPrint(" Welcome");
        boolean mainGame = true;
        boolean travel = true;

        boolean room3 = false;
        boolean room4 = false;
        boolean room5 = false;



        // GAME2:
        while(mainGame){
            while(travel){
                System.out.println("\n");
                String keyInput = in.nextLine().toLowerCase();
                
                switch(keyInput){
                    case "north":
                    destination = goNorth[roomNumber];
                    if(destination<0){
                        System.out.println("you cannot go that direction");
                    }else{
                        roomNumber = destination;
                    }
                    break;

                    case "south":
                    destination = goSouth[roomNumber];
                    if(destination<0){
                        System.out.println("you cannot go that direction");
                    }else{
                        roomNumber = destination;
                    }
                    break;

                    case "east":
                    destination = goEast[roomNumber];
                    if(destination<0){
                        System.out.println("you cannot go that direction");
                    }else{
                        roomNumber = destination;
                    }
                    break;

                    case "west":
                    destination = goWest[roomNumber];
                    if(destination<0){
                        System.out.println("you cannot go that direction");
                    }else{
                        roomNumber = destination;
                    }
                    break;

                    case "up":
                    destination = goUp[roomNumber];
                    if(destination<0){
                        System.out.println("you cannot go that direction");
                    }else{
                        roomNumber = destination;
                    }
                    break;

                    case "down":
                    destination = goDown[roomNumber];
                    if(destination<0){
                        System.out.println("you cannot go that direction");
                    }else{

                        roomNumber = destination;
                    }
                    break;

                    case "end game":
                    System.out.println("Game closed");
                    return;

                    case "explode":
                    System.out.println("     _.-^^---....,,--       ");
                    System.out.println(" _--                  --_  ");
                    System.out.println("<                        >)");
                    System.out.println("|                         | ");
                    System.out.println(".(                   _./  ");
                    System.out.println("    ```--. . , ; .--'''       ");
                    System.out.println("          | |   |             ");
                    System.out.println("       .-=||  | |=-.   ");
                    System.out.println("       `-=#$%&%$#=-'   ");
                    System.out.println("          | ;  :|     ");
                    System.out.println(" _____.,-#%&$@%#&#~,._____");
                    break;

                    default:
                    System.out.println("Invalid command");

                    

                }
                
                slowPrint(flavourText[roomNumber]);
                if(roomNumber == 4 && !room4){
                    running = true;
                    travel = false;
                }
                if(roomNumber==5 && !room5){
                    running = true;
                    travel = false;
                }
                if(roomNumber == 3 && !room3){
                    running = true;
                    travel = false;
                }
                if(roomNumber == 6 && moneyHeld > 100){
                    slowPrint("\nYou give the goblin the 100 gold and now you may pass");
                    return;
                }

            }

            GAME:
            while(running) {
                System.out.println("\n----------------------------------------");
                int enemyHealth = rand.nextInt(maxEnemyHealth);
                String enemy = enemies[rand.nextInt(enemies.length)];
                slowPrint("\n# " + enemy +" has appeared! #\n");

                while(enemyHealth > 0){
                    slowPrint("\nYour HP: "+ health);
                    slowPrint("\n" + enemy + "'s HP: " + enemyHealth);
                    slowPrint("\nYou have " + moneyHeld + " gold" );
                    slowPrint("\nWhat would you like to do?");
                    slowPrint("\n1. Attack");
                    slowPrint("\n2. Drink Potion");
                    slowPrint("\n3. Fight another enemy");
                    slowPrint("\n");

                    String input = in.nextLine();
                    if(input.equals("1")) {
                        int damageDealt = rand.nextInt(attackDamage);
                        int damageTaken = rand.nextInt(enemyAttackDamage);

                        enemyHealth -= damageDealt;
                        health -= damageTaken;

                        slowPrint("\n> You strike the " + enemy + " for " + damageDealt + " damage");
                        slowPrint("\n> You take " + damageTaken + " damage'");

                        if(health < 1) {
                            slowPrint("\n> You DIE bozo ");
                            break;
                        }
                    }
                    else if (input.equals("2")) {
                        if(numHealthPots > 0){
                            health += healthPotionHealAmount;
                            numHealthPots--;
                            slowPrint("\n> You heal for " + healthPotionHealAmount);
                            slowPrint("\n> You have " + health + " health points");
                            slowPrint("\n> You have " + numHealthPots + " healing potion");
                        }
                        else {
                            slowPrint("\n> You dont have any health potions left");
                        }

                    }
                    else if (input.equals("3")) { 
                        slowPrint("\n> You run away" );
                        continue GAME;

                    }
                    else {
                        slowPrint("\n IVALID COMMAND");

                    }
                }

                if(health < 1) {
                    slowPrint("\n You are not good at this");

                    return;
                }

                System.out.println("\n----------------------------------------");
                slowPrint("\n" + enemy + " was defeated!");
                System.out.println("\n You have " + health + " HP left");

                moneyHeld += rand.nextInt(moneyGiven);
                slowPrint("\n You have " + moneyHeld + " gold" );

                if(rand.nextInt(100) < healthPotionDropChance) {
                    System.out.println("\n It dropped a Health Potion, you now have " + numHealthPots + " Health Potions");
                }

                System.out.println("\n----------------------------------------");
                slowPrint("\n What should you do now?");
                slowPrint("\n1. Continue");
                slowPrint("\n2. Keep fighting");

                String input = in.nextLine();

                while(!input.equals("1") && !input.equals("2")) {
                    slowPrint("\n Invalid command");
                    input = in.nextLine();
                }
                if(roomNumber == 3){
                    room3 = true;
                }
                if(roomNumber == 4){
                    room4 = true;
                }
                if(roomNumber == 5){
                    room5 = true;
                }

                if(input.equals("1")) {
                    slowPrint("\n You continue");
                    slowPrint(flavourText[roomNumber]);

                    travel = true;
                    running = false;

                }
                else if(input.equals("2")) {
                    slowPrint("\n You give up");
                }

                ////////////
            }
        }
    }

    public static void slowPrint(String output) {
        for (int i = 0; i<output.length(); i++) {
            char c = output.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            }
            catch (Exception e) {

            }
        }

    }
}

