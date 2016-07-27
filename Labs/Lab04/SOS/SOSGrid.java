import javax.swing.*;
import java.awt.*;
import cs101.sosgame.SOS;

/**
 * uses a lot of the uml methods to set up teh grids as well
 * as setting up the size (to be changed in the main frame)
 */

public class SOSGrid extends JPanel
{
  //constants
  private final int MAX = 250; 
  // Properties
  SOS game;
  
  // Constructors
  //using the game provided in the package
  public SOSGrid( SOS game )
  {
    this.game = game;    
    setPreferredSize( new Dimension ( 350, 350));
  }
  
  // Methods
  // overriding paint component method
  //have to use it to use the drawable interface method draw
  //drawRect method
  public void paintComponent( Graphics g)
  {
    super.paintComponent(g); 
    
    // Variables
    int      size = game.getDimension(); // UML method to return grid size 
    String[] letters = new String[size * size];
    int      x = 0;
    int      y = 0;
    char     ch;
    
    
    // Method Code
    // Using the provided method from an array to set up the grid
    for ( int i = 0; i < size; i++ )
    {
      for ( int j = 0; j < size; j++ )
      {
        ch =  game.getCellContents( i, j);// included in the cs101.sosgame.SOS UML
        letters[x] = String.valueOf( ch);
        x++;
      }
    }    
    
    // Drawing and filling the grid
    for ( int i = 50; i <= MAX; i = i + (MAX / size) )
    {
      for ( int j = 50; j <= MAX; j = j + (MAX / size) )
      {
        g.drawRect( i, j, (MAX / size), (MAX / size)); // drawing rectangle
        g.drawString( letters[y], i + ((MAX / size) / 2), j + ((MAX / size) / 2));
        y++;
      }
    }      
  }
}

