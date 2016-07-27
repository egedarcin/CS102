import java.util.*;
/**
 * Cards, keeps the cards from the card class. 
 * creates a full pack of 52, shuffles them.
 * @author Ege Darcin
 * @version 1.1
 */
public class Cards{
  final int cardsInThePack = 52;
  
  // properties
  Card[] cards;
  int  valid;
  
  // constructors
  public Cards( boolean fullPack){
    cards = new Card[ cardsInThePack ];
    valid = 0;
    if ( fullPack)
      createFullPackOfCards();
  }
  
  // methods 
  public Card getTopCard(){
    Card temporary;
    if ( valid <= 0)
      return null;
    else{
      valid--;
      temporary = cards[valid];
      cards[valid] = null;
      return temporary;
    }
  }
  
  public boolean addTopCard( Card c){
    if ( valid < cards.length)
    {
      cards[valid] = c; 
      valid++;
      return true;
    }
    return false;
  }
  
  private void createFullPackOfCards(){
    // Creates a Full Pack
    for (int i = 0; i < cardsInThePack; i++) 
      addTopCard( new Card(i) );
  }
  
  public void shuffle(){
    int index;
    Card temp;
    Random randomIndex = new Random();
   
    for (int i = 0; i < cards.length; i++) {
      
      // picks a random number between 0 and (card length -1)
      index = randomIndex.nextInt(cards.length);
      
      // card swap algorithm
      temp = cards[i];
      cards[i] = cards[index];
      cards[index] = temp;
    }  
  }
  
  // For testing the cards, print method
  void testOnlyPrint(){
    for ( int i =0; i < valid; i++){
      System.out.println( cards[i] );
    }
  }
}