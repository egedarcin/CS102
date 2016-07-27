/* @author Ege Darcin
 * Version 1.1
 * 21302460
 * Lab03b
 */   
import java.util.*;
public class IntBagStepIterator extends IntBagIterator {
  //variables
  private int m ;
  private IntBag intbag;
  private int index = 0;
  //constructors
  public IntBagStepIterator (int m, IntBag aBag){
    super(aBag);
    this.m = m;
    intbag = aBag;
  }
  //methods
  //has next method
 public boolean hasNext() 
  {
    if(index < intbag.size() ) 
    {
      return true;
    }
    else
      return false;
  }
  //next method
  public Integer next() {
    if(hasNext()){
      index += m;
      return intbag.get(index-m);
    }
    else
      return null;
  }
  
}