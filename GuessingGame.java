//Jakob Karhinen
//CS 145
//Lab 1

import java.util.*;

public class GuessingGame {
    public static final int MAX = 100;
    
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        intro();
        int best = 0;
        int games = 0;
        int guesses = 0;
        String response;

        do {
            int lastGame = playGame(console);
            
            if (lastGame < best || best == 0) {
                best = lastGame;
            }
            
            guesses += lastGame;
            games++;
            
            System.out.print("Do you want to play again? ");
            response = console.next();
            
            while (Character.toLowerCase(response.charAt(0)) != 'y' && Character.toLowerCase(response.charAt(0)) != 'n') {
                System.out.print("Please enter yes or no. ");
                response = console.next();
            }
            
        } while (Character.toLowerCase(response.charAt(0)) != 'n');
        
        results(games, guesses, best);
    } 
    
    public static void intro() {
        // Gives the intro to the player
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and " + MAX + " and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you whether the right answer is higher or lower than your guess.");
    }

    public static int playGame(Scanner console) {
        // Prompts player to enter number and tells them whether their number is higher or lower. Returns number of guesses
        Random r = new Random();
        int randomNumber = r.nextInt(MAX) + 1;
        System.out.println();
        System.out.print("I'm thinking of a number between 1 and " + MAX + "...\nYour guess? ");
        int response = console.nextInt();
        int guesses = 1;
        
        while (response != randomNumber) {
            if (response < randomNumber) {
                guesses++;
                System.out.println("It's higher.");
                
            } else {
                guesses++;
                System.out.println("It's lower.");
                
            }
            System.out.print("Your guess? ");
            response = console.nextInt();
        }
        
        if (guesses == 1) {
            System.out.println("You got it right in " + guesses + " guess.");
        } else {
            System.out.println("You got it right in " + guesses + " guesses.");
        }
        
        return guesses;
    }
    
    public static void results(int games, int guesses, int best) {
        // Takes in the number of games and total number of guesses and gives the results to the player.
        double guessesPerGame = (double)guesses / games;
        System.out.println();
        System.out.println("Overall results:");
        System.out.println("\ttotal games = " + games);
        System.out.println("\ttotal guesses = " + guesses);
        System.out.println("\tguesses/game = " + guessesPerGame);
        System.out.println("\tbest game = " + best);
    }
}
