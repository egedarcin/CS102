/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102;

import cs102.Hangman;

/**
 *
 * @author egedarcho
 */
public class ConsoleHangmanView implements IHangmanView {

    @Override
    public void updateView(Hangman hangman) {
        if (!hangman.isGameOver()) {
            System.out.println("HANGMAN SAYS: " + hangman.getKnownSoFar());
            System.out.println("HANGMAN SAYS: " +"You have " + (hangman.getMaxAllowedIncorrectTries()
                    - hangman.getNumOfIncorrectTries()) + " tries left.");
        } else if (hangman.hasLost()) {
            System.out.println("HANGMAN SAYS: " +"You lost! The word was : " + hangman.secretWord.toString().toUpperCase());
            

        } else if (hangman.isGameOver()) {
            System.out.print("HANGMAN SAYS: " +"You won!");

        }

    }
}
