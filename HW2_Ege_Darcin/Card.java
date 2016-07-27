/**
 * Card class, defines the cards and etc.
 * @author Ege Darcin
 * @version 1.1
 */
public class Card
{
  final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
  final String[] FACES = { "A", "2", "3", "4", "5",
    "6", "7", "8", "9", "10",
    "J", "Q", "K"};
  // properties
  int  cardNo;
  
  // constructors
  public Card( int cardNumber){
    cardNo = cardNumber;
  }
  public Card( int faceValue, int suit ){
    cardNo = faceValue + suit * 13;
  }
  // methods, getters, setters, equals and toStrings
  public int getFaceValue(){
    return cardNo % 13;
  }
  
  public int getSuit(){
    return cardNo / 13;
  }
  
  public boolean equals( Card c){
    //Check the cardNumbers 
    if((cardNo % 13) == c.getFaceValue())
      return true;
    else
      return false;
  }
  
  public int compareTo( Card c ){
    //1 first condition: card no's are same
    if((cardNo % 13) == c.getFaceValue())
      return 0;
    //2 first card is bigger than the other
    else if((cardNo % 13) > c.getFaceValue())
      return 1;
    //3 first card is smaller than the other
    else
      return -1; 
  }
  
  public String toString(){
    return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
  }
}