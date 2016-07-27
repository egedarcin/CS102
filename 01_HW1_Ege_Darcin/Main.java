/*
 * Author: Ege Darcin
 * CS102-1 HW
 * Program: Hangman Game
 * Here is the Hangman game!
 */
import java.io.*; 
import java.util.*; 
public class Main {
  public static void main( String[] args) {
    
    // Variables
    int gameState;
    boolean isGameOver;
    char currentLetter;
    char playAgain;
    Hangman hangman;
    
    Scanner scan = new Scanner( System.in);
    
    // Program code
    System.out.println( "Hello and welcome! Let's play some hangman.");
    //plays the game until user decides to finish
    do {
      hangman = new Hangman();
      isGameOver = false;
      // main menu, game screen
      do {
        System.out.println( "You have " + ( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries() ) + " tries left." );
        System.out.println( "Here is the word: " + hangman.getKnownSoFar());
        System.out.print( "Enter a letter from the English alphabet: " + hangman.getAllLetters() + ": " );
        currentLetter = scan.nextLine().charAt(0);
        gameState = hangman.tryThis( currentLetter );
        
        //if user types a wrong letter
        if (gameState == -1){
          System.out.println( "The letter you entered is invalid" );
        }
        else if (gameState == -2){
          System.out.println( "The letter was already used. Try another one!" );
        }
        else if (gameState == -3) {
          if ( ( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries()) == 0 ) 
            System.out.println( "Game over!" );
          isGameOver = true;
        }
      } while (isGameOver == false);
      System.out.println( "Do you want to play again? (Y/N): " );
      playAgain = scan.nextLine().charAt(0);
    } while (playAgain == 'Y' || playAgain == 'y' ? true : false);
    
    System.out.println( "Bye!" );
    scan.close();
  }
}