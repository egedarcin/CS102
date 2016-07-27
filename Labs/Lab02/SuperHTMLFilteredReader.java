import cs1.SimpleURLReader;
import java.util.ArrayList;
/*
 * SuperHTMLFilteredReader
 *  @author Ege Darcin
 * @version 1.1
 */

public class SuperHTMLFilteredReader extends HTMLFilteredReader{
  
  //constructor
  public SuperHTMLFilteredReader(String url){
    super( url);
  }
  
  //methods
  //method for scanning the href by substrings
  public ArrayList<String> getLinks(){
    String temp = super.getUnfilteredPageContents();
    ArrayList<String> myLinks = new ArrayList<String>();
    int i =  -2;
    int j = 0;
    while (i != -1){
      i = temp.indexOf("href", j);
      if (i != -1){
        j = temp.indexOf("\"", i+6);
        myLinks.add(temp.substring(i+6,j));
      }
    }
    return myLinks;
  }  
  //method for finding src and alt by substrings
  public ArrayList<String> getImages(String type){
    String orary = super.getUnfilteredPageContents();
    ArrayList<String> myImages = new ArrayList<String>();
    int i =  -2;
    int j = 0;
    while (i != -1){
      i = orary.indexOf(type, j);
      if (i != -1){
        j = orary.indexOf("\"", i+5);
        myImages.add(orary.substring(i+5,j));
      }
    }
    return myImages;
  }  
}