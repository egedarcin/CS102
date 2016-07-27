import cs102.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/* @Class Discription: This is a view class for HangmanModel. It displays a stick human with a gallow
 * as in the traditional hangman game.
 */

public class GallowsHangmanView extends JPanel implements IHangmanView
{
  //variables
  private Rectangle2D.Double[] rec;
  private Line2D.Double[] manLines;
  private Ellipse2D.Double manHead;
  private Hangman hangman;
  private Shape[] man;
  private String secretWord;
  private String tries;
  private String usedWords;
  
  //constants
  private static final int PANEL_HEIGHT = 300, WIDTH = 300, X = 0, Y = 50;
  private static final Font font = new Font("Times New Roman", Font.BOLD, 50);
  
  public GallowsHangmanView(Hangman hangman)
  {
    super();
    this.hangman = hangman;//we keep a Hangman reference in paintComponent
    this.setBackground(Color.orange);
    
    //intializing the arrays for drawing
    rec = new Rectangle2D.Double[4];
    manLines = new Line2D.Double[5];
    man = new Shape[6];
    
    //initializng Strings for later use
    secretWord = "";
    tries = "";
    usedWords = "";
    
    //making the initial gallow - storing them in rectangles
    rec[0] = (new Rectangle2D.Double(20 + X, 400 + Y, 300, 50));//bottom rectangle
    rec[1] = (new Rectangle2D.Double(60 + X, 40 + Y, 20, 360));//from bottom vertical
    rec[2] = (new Rectangle2D.Double(80 + X, 40 + Y, 120, 20));//top horizontal
    rec[3] = (new Rectangle2D.Double(194 + X, 60 + Y, 6, 30));//top vertical
    
    //making the stick human
    //making the head
    manHead = new Ellipse2D.Double(167 + X, 90 + Y, 60, 60);
    
    //rest of the body is based on the initial circle
    //the body
    manLines[0] = new Line2D.Double(manHead.getX() + (manHead.getWidth() / 2), 
                                    manHead.getY() + manHead.getHeight(), 
                                    manHead.getX() + (manHead.getWidth() / 2)
                                      ,manHead.getY() + manHead.getHeight() + 70);
    //leftLeg
    manLines[1] = new Line2D.Double(manLines[0].getX2(), manLines[0].getY2(), manLines[0].getX2() - 30, 
                                    manLines[0].getY2() + 60);
    //right leg
    manLines[2] = new Line2D.Double(manLines[0].getX2(), manLines[0].getY2(), manLines[0].getX2() + 30, 
                                    manLines[1].getY2()); 
    //left arm
    manLines[3] = new Line2D.Double(manLines[0].getX2(), 
                                    ((manLines[0].getY2() - manLines[0].getY1()) / 5) + manLines[0].getY1()
                                      , manLines[0].getX1() - 28, 
                                    ((manLines[0].getY2() - manLines[0].getY1()) / 4) + manLines[0].getY1() + 40);
    //right arm
    manLines[4] = new Line2D.Double(manLines[0].getX2(), manLines[3].getY1(), manLines[0].getX1() + 28, 
                                    manLines[3].getY2());
    
    //adding the stick human shapes to an array for easy use in paintComponent
    man[0] = manHead;
    for (int i = 1; i < man.length; i++)
    {
      man[i] = manLines[i - 1];
    }
  }
  
  //implementation of IHangmanView
  public void updateView(Hangman hangman)
  {
    //if the game is being played
    if ( !hangman.isGameOver() ) 
    {
      secretWord = hangman.getKnownSoFar();//to display the secret word
      tries = "Tries: " + hangman.getNumOfIncorrectTries(); //to display the number of incorrect tries
      usedWords = "Used letters: " + hangman.getUsedLetters();//to display the words used so far
    }
    
    //if the game is over then
    else
    {
      //Lost message
      if ( hangman.hasLost() ){
        secretWord = "Oops";
        tries = "You lost!";
        usedWords = "You used: " + hangman.getUsedLetters();
      }
      
      //Won message
      else{
        secretWord = "In " + hangman.getNumOfIncorrectTries();
        tries = "Congratulations, you won!!";
        usedWords = "You used: " + hangman.getUsedLetters();
      }
    }
    repaint();//calling repaint to update the changes in the JPanel
  }
  
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;//we're using this to draw shapes
    
    //drawing the gallow using rectangles
    g2.setPaint(Color.black);
    for(int i = 0; i < rec.length; i++)
    {
      g2.fill(rec[i]);
    }
    
    //drawing the man based on the game state
    for(int i = 0; i < hangman.getNumOfIncorrectTries(); i++)
    {
      g2.draw(man[i]);
    }
    
    //changing the style to draw the text
    g2.setFont(font);
    g2.setPaint(Color.blue);
    
    //drawing the strings. x,y cordinates are based on the rectangles drawn earlier
    g2.drawString(secretWord, (int)rec[0].getX() + 20, (int)(rec[0].getY() + rec[0].getHeight()) + 60);
    g2.drawString(usedWords, (int)rec[0].getX() + 20, (int)(rec[0].getY() + rec[0].getHeight()) + 120);
    g2.drawString(tries, (int)(rec[1].getX() + rec[1].getWidth()) + 15, (int)rec[0].getY() - 50);

  }
  
}