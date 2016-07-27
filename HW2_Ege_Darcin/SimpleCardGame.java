/**
 * Simple card game class
 * @author Ege Darcin
 * @version 1.1
 */
public class SimpleCardGame{
  
  //properties
  CardGame game;
  Player p1, p2, p3, p4;
  ScoreCard scores;
  
  //constructor
  public SimpleCardGame(){
    game = new CardGame(p1, p2, p3, p4);
  }
  //methods
  
  public void playGame(){
    System.out.println("Welcome to the Card Game!");
  }
  
  public int getScore (int playerNo){
    return 0;
  }
  
}