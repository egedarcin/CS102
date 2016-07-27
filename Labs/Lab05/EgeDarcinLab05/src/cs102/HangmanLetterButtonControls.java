import cs102.*;
import java.awt.*;

/*Class Discription: This is a view class for HangmanModel that displays a virtual keyboard. 
 */

public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView
{
  
  //constants
  private static final Font FONT = new Font("Calibri", Font.BOLD, 25);
  
  //constructor
  public HangmanLetterButtonControls(Hangman hangman, int rows, int coloumns)
  {
    super(hangman.getAllLetters(), rows, coloumns);
    this.setPreferredSize(new Dimension(300, 250));
    this.setFont(FONT);
  }
  
  //implementing IHangmanView
  @Override
  public void updateView(Hangman hangman)
  {
    //if the game is not over, we disable these buttons
    if (!hangman.getUsedLetters().equals(""))
      this.setDisabled(hangman.getUsedLetters());
    
    //if it is a new game, we enable all the buttons
    if (hangman.isGameOver())
      setEnabledAll(true);
  }
  
} // end of class HangmanLetterButtonControls