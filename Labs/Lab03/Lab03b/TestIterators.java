/* @author Ege Darcin
 * Version 1.1
 * 21302460
 * Lab03b
 */   
import java.util.*;
public class TestIterators 
{
  public static void main( String[] args) 
  { 
    // Variables
    Iterator i, j;
    IntBag bag = new IntBag();

    //fills up the intbag
    for(int l = 1; l<15;l++){
      bag.add(l);

    }
    //i is in the form of IntBagIterator
    i = bag.iterator(3);
    
    while ( i.hasNext() ) {
      System.out.println( i.next() );
      //j is in the form of IntBagStepIterator, the integer inside shows the step value
      j =  bag.iterator(3);
  
      while ( j.hasNext() ) 
      {
        System.out.println( "--" + j.next());
      } 
    }
  }
}
