import cs1.SimpleURLReader;
/*
 * word search algorithm
 * @author Ege Darcin
 * @version 1.1
 */
public class wordSearch extends HTMLFilteredReader {
  public wordSearch (String url){
    super( url );
  }
  
  //word check method
  public void wordCheck(String input){
    String temp = super.getPageContents ();
    int count = 0;
    //scans the entire filtered content of the word
    for (int i = 0; i<temp.length(); i++){
      if (input.charAt(0) == temp.charAt(i)){
        //first finds a matching first letter, then checks the rest with substring
        if( temp.substring(i,i+input.length()).equals(input)){
          System.out.println("the word " + input + " occurs in the indice " + (i-6) + "-" + (i+input.length()-7) );
          count ++;        
        }
      }
    }
    //checking for search
    if (count == 0)
      System.out.println("This word is not on the text");
    else
      System.out.println(input + " has occured " + count + "times");
  }
}