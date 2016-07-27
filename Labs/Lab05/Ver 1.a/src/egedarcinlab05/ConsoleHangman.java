package egedarcinlab05;

import java.util.Scanner;
import cs102.*;

/**
 * ConsoleHangman
 *
 * @author
 * @version 1.00 2013/4/7
 */
public class ConsoleHangman {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        char currentLetter;

        System.out.println("Start of ConsoleHangman\n");

        // VARIABLES
        Hangman hangman;

        // PROGRAM CODE
        hangman = new Hangman(new BasicSetup());
        do{
        System.out.println(hangman.getKnownSoFar());
        System.out.println( "You have " + ( hangman.getMaxAllowedIncorrectTries()
                - hangman.getNumOfIncorrectTries() ) + " tries left." );
         currentLetter = scan.nextLine().charAt(0);
         hangman.tryThis( currentLetter );
        }
        while (!hangman.isGameOver());
        
        if ( hangman.hasLost())
            System.out.println("You Lost!");
        else 
            System.out.println("You Won!"+  "\n" + "The word was: " + hangman.getKnownSoFar());
        
        // ToDo - allow user to repeatedly enter a letter and tryThis letter
        //		  then show game status, until gameover. Finally report win/lose.
        System.out.println("\nEnd of ConsoleHangman\n");
    }

} // end of class ConsoleHangman
