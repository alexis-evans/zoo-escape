import java.util.Scanner;

public class Zoo {
    //instance variables: a and random are reused as a variable to store a user-entered string or a random integer, respectfully.
    //booleans tell which locations the player has already been to; locations keeps a number tally
    //money is how much money a player has left; current is the time they have left
    private double money;
    //Time class offered a better way to manage how much time the user has left
    private Time current;
    private String a;
    private int random;
    private boolean circleBack;
    private boolean park, mall, museum, mattress, restaurant;
    private int locations = 0;
    

    Scanner keyboard = new Scanner(System.in);

    //constructor: every new game starts with $100 and 360 minutes remaining. called in the very beginning of the main method
    public Zoo() {
        money = 100.0;
        current = new Time();
    }

    //method used to let the player choose where to go next. Won't let someone do the same locations twice, except the pier and the mall
    public void where2go() {

        //locations will equal five when the user has found all the animals. this allows the program to go straight to the finale sequence
        if (locations == 5) 
           { finale(); }
        System.out.println(" ");
        System.out.println("MONEY LEFT: " + money);
        System.out.println("TIME LEFT: " + current);
        System.out.println("Where do you want to go?");
        System.out.println("PARK | MALL | MUSEUM | PIER | MATTRESS FIRM | RESTAURANT");

        //an infinite loop so the computer will continually ask where the user wants to go until they choose something. then, the case will break out of the loop
        while (1 < 2) {
        a = keyboard.nextLine();
        //switch case for where to go next. accepts user input, first checks to see if they've already been, and then proceeds to that method, incrementing locations visited and switching the boolean variable to 'true' so it can't be visited again in the future.
        switch(a) {
            case ("park"):
                if (park == true) {
                    System.out.println("You've been there before.");
                    continue;
                }
                else {
                    park = true;
                    locations++;
                    park();
                    break;
                }
            case ("mall"):
                if (circleBack == true) //special mall case. game has option to visit the mall twice and get two different outcomes
                    {mall2();
                    mall = true;}
                if (mall) {
                    System.out.println("You've been there before.");
                    continue;
                }
                else {
                    mall();
                    break;
                }
                
            case ("museum"):
                if (museum) {
                    System.out.println("You've been there before.");
                    continue;
                 }
                else {
                museum = true;
                locations++;
                museum();
                break;
                }
            case ("pier"):
                pier();
                break;
            case ("mattress firm"):
                if (mattress) {
                    System.out.println("You've been there before.");
                    continue;
                 }
                else {
                mattress = true;
                locations++;
                mattress();
                break;
                }
            case ("restaurant"):
            if (restaurant) {
                System.out.println("You've been there before.");
                continue;
                }
            else {
                restaurant = true;
                locations++;
                restaurant();
                break;
                }
            default:
                //default if the user types in something weird or misspelled
                System.out.println("What?");

        }
        }

    }


//beginning of the park interaction w/ penguins. 
    public void park() {
        //each location takes a random amount of time to get there. helps increase the unpredictability of the game and creates more opportunities to lose
        random = (int)(Math.random()*7 + 2);
        System.out.println("You walk to the park. It's not too far away, only a " + random + " minute walk.");
        //walking to every location takes time away from your time left. 
        current.minLeft -= random;
        System.out.println("Oh, what's that on the swings? Why, it's the penguins having a blast! You suppose that their little legs couldn't carry them very far. Do you wish to approach? (Y/N)");
        a = keyboard.nextLine();
        if (a.equalsIgnoreCase("Y")) {
            penguinApproach();
        }
        else if (a.equalsIgnoreCase("N")) {
            System.out.println("Uhhh, are you sure? You kinda need to get these penguins...([1]You heard what I said./[2]No, I was just kidding.)");
            a = keyboard.nextLine();
            if (a.equalsIgnoreCase("2")) {
                System.out.println("Ok perf.");
                penguinApproach();

            }
            else {
                //you must be kind to the computer or you will lose the game
                System.out.println("Okay, loser. Watch this. GAME OVER.");
                System.exit(0);
            }
        }
    }
    
//method that only runs after the player agrees to approach the penguins. Two scenarios in which this could happen, so I made a method instead of copy and pasting twice.
    public void penguinApproach() {
        System.out.println("You look toward the penguin leader, the head honcho, the PIC (penguin in charge). He squints at you in apprehension.\n\n");
        System.out.println("'What do you want, kid?' he asks. You explain that you are there to take them back home.");
        System.out.println("'No, no, I don't think so, not without a little something for us.' He gestures toward your pocket. Does this penguin really want cash just to go home? Well, you do have " + (int)money + " dollars...\n\n");
        System.out.println("'15 buckaroonies and we'll follow ya.' Do you give the penguins their cash? (Y/N)");
        a = keyboard.nextLine();
        if (a.equalsIgnoreCase("y")) {
            //various interactions in the game require you to pay money. if you don't, you usually lose the game.
            money -= 15.00;
            System.out.println("You fork over the cash and the PIC gets his men in order. They follow you back to the zoo. (PRESS 'ENTER' TO CONTINUE)");
            a = keyboard.nextLine();
            where2go();
        }
        else if (a.equalsIgnoreCase("N")) {
            System.out.println("The penguins collectively shake their heads and walk off. You watch them in shame. GAME OVER.");
            System.exit(0); //ends the program when you lose the game
        }
    }


//the first possible mall encounter. player can choose to help out the elephant or leave and come back later. uses booleans to communicate which option was chosen.
    public void mall() {
        random = (int)(Math.random()*9 + 6);
        current.minLeft -= random;
        System.out.println("The mall is a " + random + " minute walk away. You don't like cardio. You finally arrive. \n\nAs you approach you see quite the sight.. There is an elephant stuck in the entrance! He's honking in distress as his elephant friends watch on. Yikes! Do you try to help him out? (Y/N)");
        a = keyboard.nextLine();
        if (a.equalsIgnoreCase("y")) {
            current.minLeft -= 60;
            System.out.println("Oh dear, oh dear. This elephant sure is stuck! It's already been an hour, and this buddy is not going anywhere. You have another idea, but you know that it will take a long time, probably another hour at least. \n\nDo you keep trying, or abandon the elephant? Keep in mind, you have " + current + " left. (ABANDON/TRY)");
            a = keyboard.nextLine();
            if (a.equalsIgnoreCase("abandon")) {
                System.out.println("Well, you did try your best. You decide to cut your losses and quit while you're ahead. Except you're not ahead, you wasted an hour and you still don't have the elephant. You tell yourself you'll circle back. (PRESS 'ENTER' TO CONTINUE)");
                circleBack = true; //tells the computer that the player will later have to type 'mall' again into the where2go() method to complete the game
                where2go();

                
            }
            else if (a.equalsIgnoreCase("try")){
                locations++;
                System.out.println("Well aren't you a trooper! You go into the mall's Ulta and steal every container of lotion you can find. You leave a 20 on the counter. You hope the zoo will reimburse the rest. You slather the elephant's back and help him shimmy out. \n\nIt takes a minute - well, many minutes - but the extra slip was just what he needed. \n\nWhen he tumbles out, he hits a lightpost and breaks it in half. Silly fella! He honks in appreciation. \n\nYou go back to the zoo. (PRESS 'ENTER' TO CONTINUE)");
                money -= 20;
                current.minLeft -= 52;
                a = keyboard.nextLine();
                where2go();

            }
        }
        else if (a.equalsIgnoreCase("n")) {
            
            System.out.println("You are a horrible zookeeper. You leave the elephant, certainly losing your job in the morning. GAME OVER.");
            System.exit(0);
        }
    }
//the second mall interaction. only occurs if you choose to "circle back" in the first mall.
    public void mall2() {
        System.out.println("Ok, y'all. Elephant part 2. You rub your hands together, crack your knuckles, and push with all you've got. Whoa! Your newfound might popped this elephant out in a solid 1 hour and 45 minutes! Yippee! All the elephants jumped with joy, shaking the terrain violently. You all waltz back to the zoo. (PRESS 'ENTER' TO CONTINUE)");
        a = keyboard.nextLine();
        locations++;
        current.minLeft -= 105;
        where2go();

    }


//method that plays the museum interaction with the lions
    public void museum() {
        random = (int)(Math.random()*5 + 5);
        current.minLeft -= random;
        System.out.println("You arrive at the museum. " + random + " minutes have passed. Your lions are getting a nice tour from the museum's docent. He's currently informing them on the history of dinosaurs. They are very intrigued. You approach the docent.\n");
        System.out.println("'Um, excuse me,' he spits. 'I'm in the middle of a tour right now. Please do NOT bother me.' You explain that you are here to take the lions away and put them back in the zoo. \n\n'You're stealing MY paying customers?? No, no. I don't think so. Not without a fee.'\n You are confused, because the museum is free for all. I guess the rule does not apply to lions. \n\n'$7 for each of your lions. That's $35 total, genius.\n");

        System.out.println("Jeez! Quite the attitude on this guy. He looks pretty serious about his money. Do you pay the man his money? (Y/N)");
        a = keyboard.nextLine();
        if (a.equalsIgnoreCase("y")) {
            money -= 35;
            System.out.println("He pockets the money and sniffs once. 'Alright, take 'em, whatever.' You lead the lions out the door and back to the zoo. (PRESS 'ENTER' TO CONTINUE)");
            a = keyboard.nextLine();
            where2go();
        }
        else if (a.equalsIgnoreCase("n")) {
            System.out.println("Your money is safe, but your job is not. You walk out of the museum, defeated. Capitalism won this time. GAME OVER.");
            System.exit(0);
        }
    }


//pier(): a time wasting method. nothing ever comes out of it except limiting the amount of time you have left to win the game. can be called an infinite amount of times.
    public void pier() {
        random = (int)(Math.random()*7 + 2);
        current.minLeft -= random;
         System.out.println("There's nothing here. This was a waste of time, wasn't it! Hurry up!");
         where2go();
     }


//the beginning of the monkey interaction. the player must choose to go to monkey urgent care or lose the game. 
    public void mattress() {
        //it's a mattress firm because monkeys are jumping on the beds
        System.out.println("As you wander about the sleeping town, you notice the lights on in a certain Mattress Firm. Intrigued, you move closer.\n\nWhat's that? Five monkeys jumping on the bed....Oh god! In horror, you realize, those are your five monkeys, jumping on the bed!");
        System.out.println("You rush into the Mattress Firm, ready to scold those monkeys for their behavior. Your sudden crashing through the door startled the monkeys, and one of them trips and falls off the bed! \n\n'Oh no, oh no! You bumped your head!' the monkeys cry in unison.\n\nGreat. Now you have to go to Monkey Urgent Care on the other side of town.");
        System.out.println("Are you ready to get out of here? (Y/N)");
        a = keyboard.nextLine();
        if (a.equalsIgnoreCase("Y")) {
            hospital();
        }
        else {
            System.out.println("Come on dude, this is important, I'm serious! (Y/N)");
            a = keyboard.nextLine();
            if (a.equalsIgnoreCase("y")) {
                hospital();
            }
            else {
                System.out.println("Oh no, the light is flitting out of his little, baby eyes. Goodbye, little buddy. You monster. GAME OVER.");
                System.exit(0);
            }
        }
    }

//the second half of the monkey interaction. ends with a successfull capture of the monkeys
    public void hospital() {
        random = (int)(Math.random()*21 + 30);
        current.minLeft -= random;
        System.out.println("You walk to Monkey Urgent Care holding the fallen soldier. It takes a very long time, " + random + " minutes, to be exact; the other monkeys are screeching in fear and are very hard to control. \n\nOnce you get to Monkey Urgent Care, you hand out lollipops and they calm down. The room is empty. You approach the desk.\n");
        System.out.println("The receptionist looks over her magenta sparkled glasses at you.'Monkey bumped his head?' she asks, 'Yeah, I've seen that before. Go ahead and sit down, the doctor will call you when they're ready.' You sit down and wait. (PRESS 'ENTER' TO CONTINUE)");
        a = keyboard.nextLine();
        current.minLeft -= 68;
        System.out.println("TIME LEFT: " + current);
        System.out.println("Okay, this is taking a very long time. There's not even anyone ahead of you, what could they possibly be doing? You get up to ask the receptionist about the wait. \n\n'Do I look like I know?' \nYou ask her if she can go and see what the holdup is. \n'No. I don't tell you how to do your job, kid. Now don't tell me how to do mine.' You sit back down. (PRESS 'ENTER' TO CONTINUE)");
        a = keyboard.nextLine();
        current.minLeft -= 45;
        System.out.println("TIME LEFT: " + current);
        System.out.println("After what seems like years, the doctor calls out for you. You go back, and they give your monkey a bandaid. The copay is....what?! $30?! They didn't even do anything! Alright then...pay up! (hit 'P' to pay)");
        //another silly little moment. user has to hit p to pay, but if they don't computer continually tells them to hit p
        a = keyboard.nextLine();
        while (1 < 2) {
        if (a.equalsIgnoreCase("p")) {
            leaveHospital();
            break;
        }
        else {
            System.out.println("No, 'P'");
            a = keyboard.nextLine();
        }
        }
       
    }

//the method that plays the actual end of the monkey interaction. made into a method so I didn't have to place this into a loop statement
    public void leaveHospital() {
        money -= 30;
        System.out.println("You've left Monkey Urgent Care with a little less money in your pocket and a healthy set of monkeys in tow. You return to the zoo. (PRESS 'ENTER' TO CONTINUE)");
        a = keyboard.nextLine();
        where2go();
    }


//restaurant interaction with the pandas. has a mini interaction in which the user is prompted for a drink order and told multiple times that the restaurant does not serve it
    public void restaurant() {
        random = (int)(Math.random()*16 + 4);
        current.minLeft -= random;
        System.out.println("You enter the town's favorite restaurant, Big Louie's Pizzaria. It's " + random + " minutes away. They sell the best seafood in the whole city. \n\nThe name's a little misleading. \n\nAs you enter, you see the pandas, a party of five, being served in the middle of the restaurant. You approach the waitress taking their order.\n");
        System.out.println("'Well hello, sweetheart! Are you with these folks here?' \n\nYou try to explain that you're actually a zookeeper here to take the pandas back to the zoo, but before you get any words out, she shoves a menu into your hands and pushes you into a chair. Feeling embarrased, you don't move. \n\n'What would you like to drink, hon?'");

        //this loop goes between 1 and 7 times. computer does not remember what was typed each iteration.
        int drink = (int)(Math.random()*7 + 1);
        for (int i = 0; i <= drink; i++) {
        a = keyboard.nextLine();
        System.out.println("'Sorry, we don't have that. Something else?'");
        }
        //when the loop is over, the user experience looks the same but the computer will then record what they said and put it in the next print statement.
        a = keyboard.nextLine();
        System.out.println("Perfect! One " + a + " coming right up!");
        System.out.println("She goes to fetch your beverage. Seizing your opportunity, you quickly collect the pandas and exit the restaurant. Don't worry, you left a good $5 tip for her troubles. (PRESS 'ENTER' TO CONTINUE)");
        a = keyboard.nextLine();
        money -= 5;
        where2go();
    }



//end of the game. runs only when the user has gone to all other locations. tells the user how they did and gives them a message based on their performance. contains the System.exit() method to end the program
    public void finale() {
        System.out.println("You've successfully made it back to the zoo! Let's see how you did.");
        System.out.println("TIME LEFT: " + current);
        System.out.println("MONEY LEFT: " + money);
        //you win
        if (current.minLeft > 0 && money > 0) {
            System.out.println("Congratulations! You returned all the animals to the zoo on time without breaking your boss's bank! Your job is safe! For now...");
        }
        //you lose, badly
        else if (money <= 0 && current.minLeft <= 0) {
            System.out.println("Oh gosh, you just were not listening, were you? You ran out of money AND time? I told you to watch out for those. Tsk tsk tsk. \nYOU LOSE.");
        }
        //you lose. less badly, but you still lose
        else if (money <= 0 || current.minLeft <= 0) {
            System.out.println("Woof! You almost made it, but not quite. If I was in the habit of giving out participation trophies, you would get one. But I'm not. YOU LOSE.");
        }
        
        //ends the program so the rest of the where2go() method does not run
        System.exit(0);

    }


}



