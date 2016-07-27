import java.util.Scanner;
/**
 * Card Game Tester, Main Method etc.
 * @author Ege Darcin
 * @version 1.1
 */
public class CardGameTest{
  public static void main( String[] args){
    Scanner scan = new Scanner( System.in);
    
    System.out.println( "Start of CardGameTest\n");
//variables
    Card  c1,c2;
    Cards  cards;
    ScoreCard scores;
    Player  p0, p1, p2, p3, p4;
    CardGame game;
    
    
    // test Card class
    c1 = new Card( 1);
    c2 = new Card( 2);
    
    System.out.println( c1);
    System.out.println();
    
    // test Cards class
    cards = new Cards( true);
    cards.addTopCard( c1);
    cards.shuffle();
    cards.testOnlyPrint();
    
    // test ScoreCard class
    scores = new ScoreCard( 4);
    scores.update( 3, 1);
    scores.update( 1, 2);  
    System.out.println( "\n" + scores );
    
    // test Player class
    p0 = new Player("Test");
    p0.add(c1);
    p0.add(c2);
    p0.playCard();   
    
    // test CardGame class
    p1 = new Player("Ozcan");
    p2 = new Player("David");
    p3 = new Player("Hakan");
    p4 = new Player("Sitar");
    game = new CardGame(p1, p2, p3, p4); 
    System.out.println(game.getName(2) + "is the winner!");
    System.out.println( "End of CardGameTest" );
  }
} 
