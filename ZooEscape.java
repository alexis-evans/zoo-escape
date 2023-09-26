//Written by Alexis Evans
//January 19, 2023
//CSA Semester 1 Final Project

import java.util.Scanner;

public class ZooEscape {

    public static void main(String[] args) {

        //scanner receives user input
        //Zoo is a class I created out of which the main segment of the game runs
        Scanner input = new Scanner(System.in);
        Zoo zoo = new Zoo();
        //intro
        
        System.out.println("WELCOME TO ZOO ESCAPE. PRESS 'ENTER' TO BEGIN.");
        String a = input.nextLine();
        
        System.out.println("You are a zookeeper at the Serpentine Zoo. However, after a long night of clubbing, you are very tired. \nYou close your eyes to sleep and doze off, just for a second… ");
        System.out.println(" ");
        System.out.println(". . . . . . ");
        System.out.println(" ");

        System.out.println("As soon as you wake up, the clock shows 1:00AM. You notice the zoo is eerily quiet… \nOh no! All the animals are gone! They’ve escaped into the city! You have to find them before your boss comes back at 7:00 AM tomorrow morning. ");
        
        //the game begins!
        System.out.println(" ");

        System.out.println("There are five types of animals mising: ELEPHANTS, MONKEYS, PENGUINS, LIONS, PANDAS. \nYou must pay attention to your MONEY and TIME.");
        System.out.println("Luckily your boss has his emergency stack of $100 in his desk. You grab it and run out. Time's a ticking!");

        
        //asks user where they'd like to go for the first time
       zoo.where2go();
        

        

        



        


    }

}
