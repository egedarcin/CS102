/**
 * Lab 07 b
 * Author @EgeDarcin
 * Version 1.1
 */
import java.util.*;import java.util.*;
public class Lab07b {
  public static void main(String[] args){
    Scanner scan=new Scanner(System.in);
    SimpleStack stack1=new SimpleStack();
    String str;
    int result=0;
    
    System.out.println("Enter a string to calculate");
    str=scan.next();//taking string from user
    String operators="";
    for(int i=0; i<str.length();i++){
      if(str.charAt(i)=='+' || str.charAt(i)=='-')//taking operators from string
        operators=operators+str.charAt(i);
      
      if(str.charAt(i)!='+' && str.charAt(i)!='-')
        stack1.push(Character.getNumericValue((str.charAt(i))));//taking operands and pushing into stack    
    }
    for(int j=operators.length()-1;j>=0;j--){
      if(operators.charAt(j)=='-')
        result=result-stack1.pop();//if it sees minus pops and substracts it
      else if (operators.charAt(j)=='+')
        result=result+stack1.pop();  //if it sees plus pops and adds it
    }
    result=result+stack1.pop();// if anything remains adds it
    System.out.println(result);
    
    
    
  }
}
