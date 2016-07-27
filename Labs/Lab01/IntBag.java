/* Author: Ege Darcin
 * 21302460
 * Lab 01
 * Version: 1.5
 * This class is the intbag class which holds integers in a bag
 */
public class IntBag {
  private int[] bag;
  
  //Constructors 
  public IntBag() {
    bag  = new int [100];
    bag[0] = -1;
  }
  public IntBag(int MaxNumb){
    bag  = new int [MaxNumb];
    bag[0] = -1;
  }
  
  // remove method by looking index
  public void remove(int index) {
    /*
     for (int i = index; i < size() - 1; i++) {
     bag[i] = bag[i + 1];
     }
     bag[size() - 1] = -1;
     */
    bag[index] = bag[size()-1];
    bag[size()-1] = -1;
    
  }
  
  //add a value to last index
  public void add(int elem) {
    int size = size();
    //case if bag is not full
    if (size < bag.length - 1) { 
      bag[size] = elem;
      bag[size + 1] = -1;
    }
    //case if bag is almost full
    else if (size == bag.length - 1) {
      bag[size] = elem;
    }
    //case if bag is full, extends the bag
    else {
      int increaser [] = new int[size * 2];
      for (int i = 0; i<bag.length; i++){
        increaser[i] = bag[i];
      }
      bag = increaser;
      bag[size] = elem;
      bag[size + 1] = -1;
      
    }
  }
  
  // add a value to the end of the collection and to add a value at a particular index location i
  public boolean add(int value, int index) {
    if (index < size()) {
      int last = bag[bag.length-1];
      
      for (int i = bag.length - 2; i >= index; i--) {
        bag[i + 1] = bag[i];
      }
      bag[index] = value;
      return true;
    } 
    else 
      return false;
  }
  
  //get method
  
  public int getIt(int k){
    return bag[k];
  }
  // to String Method
  public String toString() {
    String str = "";
    boolean continueIteration = true;
    for(int i = 0; i <= bag.length - 1 && continueIteration; i++) {
      if (get(i) != -1)
        str = str + bag[i] + " ";
      else
        continueIteration = false;
    }
    return str;
  }
  
  // Size Method
  public int size() {
    int count = 0;
    boolean continueIteration = true;
    while (count < bag.length && continueIteration) {
      if (get(count) != -1) 
        count++;
      else
        continueIteration = false;
    } 
    return count;
  }
  // get the value at location i within the collection.
  public int get(int index) {
    return bag[index];
  }
  //remove a specific value from the bag.
  public void removeAll (int singleValue){
    int count = 0;
    for(int j = 0; j<size();){
      if (bag[j] == singleValue){
        remove(j);
        count ++;
      }
      else
        j++;
    }
    if (count == 0);
    System.out.println("This number is not in the bag!");
  }
} 