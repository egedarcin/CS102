import cs1.SimpleURLReader;
import java.util.Scanner;
import java.util.ArrayList;
/*
 * @author Ege Darcin
 * @version 1.1
 */
public class Menu{
  
  private static ArrayList<MySimpleURLReader> poemCollection = new ArrayList<MySimpleURLReader>();
  
  public static void main (String [] args){
    
    Scanner scan = new Scanner(System.in);
    boolean yesno;
    boolean noyes;
    int input;
    input = 0;
    String url
    yesno = true;
    
    System.out.println("Welcome!");
    //first menu
    do{
      System.out.println("Please choose one of the options below:");
      System.out.println("Option (1) : Literature");
      System.out.println("Option (2) : Art");
      System.out.println("Option (3) : Play word search game");
      System.out.println("Option (4) : Quit");
      
      input = scan.nextInt();
      
      if(input == 1){
        do{
          //second menu, literature.
          System.out.println("Please choose one of the options below:");
          System.out.println("Option (1) : Enter the url of poem to add to collection");
          System.out.println("Option (2) : List all poems in the collection");
          System.out.println("Option (3) : Quit");
          input = scan.nextInt();
          if (input == 1){
            //url adder
            System.out.println("Enter the URL of the poem, please.");
            url = scan.next();
            MySimpleURLReader poem;
            //url checker
            if(url.contains(".htm") || url.contains (".html") || url.contains (".xml")){
              poem = new HTMLFilteredReader(url);
            }
            else{
              poem = new MySimpleURLReader(url);
            }
            poemCollection.add(poem);
            System.out.println("Your URL has added to the collection, please choose an option");
          }
          else if ( input == 2){
            if ( poemCollection.size() != 0){
              //printing the url's , choosing the url to paint
              for ( int i = 0; i < poemCollection.size(); i++){
                System.out.println ( "(" + i + ")" + poemCollection.get(i).getName() );
              }
              System.out.println("Please choose one of the options to read or " + poemCollection.size() + " to go back to menu");
              
              input = scan.nextInt();
              
              if(input >= 0 && input < poemCollection.size() ){
                System.out.println(poemCollection.get(input).getPageContents());
              }
              else if( input == poemCollection.size()){
                noyes = false;
              }
              else{
                System.out.println("Wrong imput");
              }
            }
          }
          
        }while(input !=3);
      }
      //art option, scans a website and gets href, alt and src details.
      else if ( input == 2 ){
        System.out.println("Please type the website that you want to search:");
        url = scan.next();
        SuperHTMLFilteredReader reader = new SuperHTMLFilteredReader(url);
        System.out.println(reader.getLinks());
        for (int u = 0; u<reader.getImages("alt").size(); u++){
          System.out.println(reader.getImages("src").get(u) +" "+ reader.getImages("alt").get(u));
        } 
      }
      //  website word searcher
      else if( input == 3){
        System.out.println("Please type the website that you want to search:");
        url = scan.next();
        System.out.println("Please type the word you want to search:");
        String searched = scan.next();
        wordSearch wordSite = new wordSearch(url);
        wordSite.wordCheck(searched);
        
      }
      //program ender
      else if( input == 4){
        System.out.println("See you later!");
        yesno = false; 
      }
    }while (yesno);
  }
}