/**
 * SimpleLinkedList
 * Author @EgeDarcin
 * Version 1.1
 */
//import java.util.*;
public class SimpleLinkedList {
  private SimpleNode list;
  private class SimpleNode{
    public String str;
    public SimpleNode next;
    public SimpleNode(String str1){
      str=str1;
      //next=null;
    }
    public String printNode(){
      return str;
    }
  }
  public SimpleLinkedList(){
    list=null;
  }
  public boolean isEmpty(){
    return (list==null);
  }
  
  public void addToHead(String item){
    SimpleNode Node1 =new SimpleNode(item);
    Node1.next=list;
    list=Node1; 
  }
  public SimpleNode removeFromHead(){
    SimpleNode temp=list;
    if(temp==null)
      return null;
    list=list.next;
    return temp;
  }
  public String get(int index){
    SimpleNode current = list;
    int count=0;
    while(current != null)
    {
      if(count== index)
        return current.printNode();// prints to wished index
      else
        current = current.next;
      count++;    
    }
    return null;
  }
  
  public String toString(){
    String result="";
    SimpleNode current=list;
    
    while(current!=null){
      result=result+current.str + "\n";
      current=current.next;
    }
    return result;
  }
  public void addAnywhere(String s, int index){//add anywhere method
    SimpleNode addedNode=new SimpleNode(s);
    SimpleNode current = list;
    int count=0;
    while(current != null)
    {
      if(count== index){
        addedNode.next=current;
        current=addedNode;
        list.next.next.next=addedNode; 
      }
      
      else
        current = current.next;
      count++;    
    }
    
  }
}


