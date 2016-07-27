/**
 * Player Class, creates a player and gives a hand to him.
 * @author Ege Darcin
 * @version 1.1
 */
public class Player{
  // properties
  String name;
  Cards hand;
  
  // constructors
  public Player( String name){ 
    this.name = name;
    hand = new Cards (false);  
  }
  
  // methods
  public String getName(){
    return name;
  }
  
  public void add( Card c){
    hand.addTopCard(c);
  }
  
  public Card playCard(){   
    return hand.getTopCard();
  }
}