import java.util.*;
/**
 * Score Card Class. gives an integer score to each player.
 * @author Ege Darcin
 * @version 1.1
 */
public class ScoreCard{
 // properties
 int[] scores;

 // constructors
 public ScoreCard( int noOfPlayers){
  scores = new int[noOfPlayers];

  // initialise all scores to zero
  for ( int i = 0; i < scores.length; i++)
   scores[i] = 0;
 }

 // methods
 public int getScore( int playerNo){
  return scores[ playerNo];
 }

 public void update( int playerNo, int amount){
  scores[playerNo] += amount;
 }
 
 public String toString(){
  String s;
  s = "\n"
   + "_____________\n"
   + "\nPlayer\tScore\n"
   + "_____________\n";

  for ( int playerNo = 0; playerNo < scores.length; playerNo++){
   s = s + playerNo + "\t" + scores[playerNo] + "\n";
  }

  s += "_____________\n";
  return s;
 }
 
 public int[] getWinners(){
  ArrayList<Integer> list = new ArrayList<Integer>();   
  int maximum = 0;  
  //get the maximum score
  for (int i = 0; i < scores.length; i++){
   if (scores[i] > maximum){   
    maximum = scores[i];    
   }
  }
  //get maximum scorers
  for (int i = 0; i < scores.length; i++){
   if (scores[i] == maximum)   
    list.add(i);  
  }
  
  //winner list
  int[] winners = new int[list.size()];
  
  for (int i = 0; i < list.size(); i++)
   winners[i] = list.get(i);
  
  return winners;
 }
}