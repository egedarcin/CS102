import java.awt.*;
import cs102.*;



public class GUIHangman
{
  public static void main( String[] args)
  {
    GUIHangman hangy = new GUIHangman();
  }
  
  public GUIHangman()
  {
    System.out.println( "Start of GUIHangman\n");
    

    HangmanModel  hangman;
    IHangmanSetup  EgeSetup;
    

    ConsoleHangmanView consoleView;
    LabelsHangmanView labelView;
    GallowsHangmanView gallowView;
    HangmanLetterButtonControls buttonsViewControls;
    

    TextFieldControlPanel textPanelControl;
    NewGameButtonControl newGame;
    

    EgeSetup = new EgeSetup();
    hangman = new HangmanModel( EgeSetup);
    

    consoleView = new ConsoleHangmanView();
    gallowView = new GallowsHangmanView(hangman);
    labelView = new LabelsHangmanView();
    buttonsViewControls = new HangmanLetterButtonControls(hangman,13,2);
    buttonsViewControls.addActionListener(new HangmanLetterButtonsController(hangman));

    textPanelControl = new TextFieldControlPanel(hangman);
    newGame = new NewGameButtonControl(hangman);

    hangman.addView( consoleView);
    hangman.addView( labelView );
    hangman.addView( buttonsViewControls );
    hangman.addView( gallowView );
    hangman.addView( newGame );
    
    SimpleJFrame frame = new SimpleJFrame( "GUIHangman", 
                     gallowView,   
                     textPanelControl, newGame, 
                     buttonsViewControls, labelView );
    frame.pack();
    ConsoleControl.controlFor( hangman);
  }
  
  
  
} 
