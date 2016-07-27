import cs1.SimpleURLReader;
/*
 * UrlTester
 * @author Ege Darcin
 * @version 1.1
 */

public class UrlTester{
  public static void main(String[] args){
    
    //properties
    String url;
    String newUrl;
    String newestUrl;
    
    url = "http://www.cs.bilkent.edu.tr/~ozturk/cs102/assignments/lab02/docs/housman.txt";
    newUrl = "http://www.cs.bilkent.edu.tr/~ozturk/cs102/assignments/lab02/docs/housman.htm";
    newestUrl = "http://www.cs.bilkent.edu.tr/~ozturk/cs102/assignments/lab02/docs/Frida.html";
    String text;
    int line = 0;
    
    //constructor
    
    SimpleURLReader reader= new SimpleURLReader(url);
    MySimpleURLReader reader2 = new MySimpleURLReader(url);
    HTMLFilteredReader reader3 = new HTMLFilteredReader (newUrl);
    SuperHTMLFilteredReader reader4 = new SuperHTMLFilteredReader( newestUrl);
    
    //testing the url's.
    System.out.println("1");
    System.out.println( "The text is" + "\n" + reader.getPageContents());
    System.out.println ( "It has " + reader.getLineCount() + " lines.");
    System.out.println ("");
    
    System.out.println("2.1");
    System.out.println( " The text is" + "\n" + reader2.getName() );
    System.out.println ( "It has " + reader2.getLineCount() + " lines.");
    System.out.println ("");
    
    System.out.println("2.2");
    System.out.println( " Filtered page content" );
    System.out.println ( reader3.getPageContents() );
    System.out.println ( reader3.getUnfilteredPageContents() );
    
    System.out.println("3");
    System.out.println( "The Links are" );
    System.out.println ( reader4.getLinks() );
    System.out.println ( reader4.getImages("src") );
    System.out.println ( reader4.getImages("alt") );
    
  }
}