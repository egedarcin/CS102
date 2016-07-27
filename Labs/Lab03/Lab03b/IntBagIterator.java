/* @author Ege Darcin
 * Version 1.1
 * 21302460
 * Lab03b
 */   
import java.util.*;
public class IntBagIterator implements Iterator {
  
  // Variables
  private IntBag aBag;
  private int index;
  private int value;
  
  // Constructor
  public IntBagIterator(IntBag aBag) {
    this.aBag = aBag;
    index = 0; 
  }
  
  // hasnext method
  public boolean hasNext() 
  {
    if(index < aBag.size() - 1) 
    {
      return true;
    }
    else
      return false;
  }
  
  // remove again
  public void remove() {
    aBag.remove(index);
  }

  // find value 
  public Integer next() {
    if(hasNext()){

      index ++;
      return aBag.get(index-1);
    }
    else
      return null;
  }
}