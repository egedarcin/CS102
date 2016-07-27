/**
 * Lab 07
 * Author @EgeDarcin
 * Version 1.1
 */
//import java.util.*;
public class Lab07 {
  
  public static void main(String[] args) {
    //Scanner scan = new Scanner(System.in);
    
    SimpleLinkedList list1= new SimpleLinkedList();
    list1.addToHead("aa");
    list1.addToHead("bb");
    list1.addToHead("cc");
    list1.addToHead("dd");
    list1.addToHead("ee");
    
    System.out.println(list1);
    list1.addAnywhere("abc",3);
    System.out.println(list1);
    
    System.out.println(list1.get(3));
    System.out.println("");
    list1.removeFromHead();
    System.out.println(list1);
    
  }  
}
