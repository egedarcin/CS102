import java.util.ArrayList;
/**
 * Cardgame creates the game, adds users etc.
 * @author Ege Darcin
 * @version 1.1
 */
public class CardGame
{
 // properties
 Cards    fullPack;
 ArrayList<Player> players;
 ScoreCard   scoreCard;
 Cards[]    cardsOnTable;
 int     roundNo, turnOfPlayer;

 // constructors
 public CardGame( Player p1, Player p2, Player p3, Player p4)
 { 
  
  //1)create new player list with 4 player
  players = new ArrayList<Player>();
  players.add(p1);
  players.add(p2);
  players.add(p3);
  players.add(p4);
  
  //2)create score cards
  scoreCard = new ScoreCard(players.size());
  
  //3)initialize other properties
  roundNo = 0;
  turnOfPlayer = 0;
  
  //4)create a fullPack of cards and shuffle it
  fullPack = new Cards(true);
  fullPack.shuffle();
  
  Cards c1 = new Cards(false);
  Cards c2 = new Cards(false);
  Cards c3 = new Cards(false);
  Cards c4 = new Cards(false);
  cardsOnTable = new Cards[players.size()];
  cardsOnTable[0] = c1;
  cardsOnTable[1] = c2;
  cardsOnTable[2] = c3;
  cardsOnTable[3] = c4;
  
  for (int i = 0; i < players.size(); i++){  
   for (int j = 0; j < 13; j++){
    players.get(i).add(fullPack.getTopCard());   
   }
  } 
 }

 // methods
 public boolean playTurn( Player p)
 {
  int noOfThePlayer = players.indexOf(p);
  
  //game over
  if(isGameOver())
   return false;
  else if (isTurnOf(p) == false)
   return false;    
  
  //playTurn
  else{  
   cardsOnTable[noOfThePlayer].addTopCard(p.playCard());
   if(getTurnOfPlayerNo() != 3)
    turnOfPlayer++; //nextPlayer
   
   else{    
    updateScores();   
    
     if(isGameOver() == false){
      roundNo++; //end of the round
      turnOfPlayer++; // next player
     }
   } 
   return true;
  }
 }

 public boolean isTurnOf( Player p)
 {
  int noOfThePlayer = players.indexOf(p);
  
  if( noOfThePlayer == this.turnOfPlayer)
   return true;
  
  else
   return false;
 }

 public boolean isGameOver()
 {
  if(getRoundNo() == 13)
   return true;
  else
   return false;
 }

 public int getScore( int playerNumber)
 {
  if((playerNumber < players.size()) && (playerNumber > 0))
   return scoreCard.getScore(playerNumber); 
  else
   return -1;
 }

 public String getName( int playerNumber)
 {
  if (players != null)
   return players.get(playerNumber).getName();
  
  else
   return "Not yet implemented";
 }

 public int getRoundNo()
 {
  return this.roundNo;  
 }

 public int getTurnOfPlayerNo()
 {  
  return this.turnOfPlayer;
 }

 public Player[] getWinners()
 {
  //winner list
  Player[] winners = new Player[scoreCard.getWinners().length];
  for (int i = 0; i < winners.length; i++){
   winners[i] = players.get(scoreCard.getWinners()[i]);
  }
  return winners;
 }
 
 private void updateScores(){
  int max = 0;
  
  for (int i = 0; i < players.size(); i++){
   if (cardsOnTable[i].getTopCard().getFaceValue() > max)
    max = cardsOnTable[i].getTopCard().getFaceValue();
  }
  
  for (int i = 0; i < players.size(); i++){
   if (cardsOnTable[i].getTopCard().getFaceValue() == max)   
    scoreCard.update(i,1);  
  }   
 }
}