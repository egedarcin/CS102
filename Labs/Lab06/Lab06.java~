/**
 *@Author Ege Darcin
 * Lab06
 * Version 1.1
 */
import java.util.*;
import java.io.File;


public class Lab06 {
  
  public static void main(String[] args) {
    
    String s;
    int d,e;
    int choice;
    int occurA;
    int n1,n2;
    File file = new File("/Users/egedarcho/Documents/Deutschland");
    
    String word;
    int littleChoice;
    ArrayList<String> list= new ArrayList<String>();
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome!");
    
    do{//menu
      System.out.println("Lab06 Test Menu, Choose an Option to test the methods");
      System.out.println(" 1.Part a \n 2.Part b \n 3.Part c \n 4.Part d \n 5.Part e \n 6.Part f \n 7.Part g \n 8.Exit");
      choice=scan.nextInt(); 
      if(choice==1){
        System.out.println("Enter a text to see how many a's on your string");
        s=scan.next();
        System.out.println(s + " : "+countA(s));
      }
      //2 int arrays checked
      else if (choice == 2){
        int[] arrL1 = {1,2,3,3,4,5,6,8,9};
        int[] arrL2 = {1,3,5,3,4,5,9,11,1};
        
        System.out.println(itisSorted(arrL1, 9));
        System.out.println(itisSorted(arrL2, 9));
        
      }
      //2 positive integers is typed, checked 
      else if (choice == 3){
        System.out.println("Enter two positive integers to see their greatest common diviser");
        d = scan.nextInt();
        e = scan.nextInt();
        if (d>0 && e>0)
          System.out.println(gcd(d,e));
        else
          System.out.println("Integers must be bigger than zero!");
      }
      
      else if (choice == 4){
        //prints out the folder data and size.
        System.out.println(file.getPath() +": "+ getSize(file) + " bytes");
      }
      
      else if(choice==5){
        //binary representation
        System.out.println("Enter an integer to see its binary representation");
        d=scan.nextInt();
        decimalToBinary(d);
        System.out.println("");
        
      }
      else if(choice==6){
        list.add("aab");
        list.add("bac");
        list.add("bbb");
        list.add("ccc");
        System.out.println("Is this Array List lexographic?: " + lexOrder(list));
        
      }
      else if(choice==7){
        System.out.println("Enter the N to see the integers:");
        n1=scan.nextInt();
        System.out.println("----");
        n2=(int)Math.pow(10,n1);
        nDigit(n2,n1);
        
      }
    }while(choice!=8);
  }
  
  
  //a counter method
  public static int countA(String str) {
    int result=0;
    if(str.length()==0) {//best case scenario
      return result;
    }
    if ((str.substring(0,1).equalsIgnoreCase("a"))) {
      //checking a's
      result= 1 + countA(str.substring(1));
      return result;
    }
    //case if there is no a
    result= countA(str.substring(1));
    return result;
  }
  //decimal to binary method 
  public static void decimalToBinary(int decimal) {
    String str="";
    if (decimal>0) {
      decimalToBinary(decimal/2);//recursion
      System.out.print(decimal%2 + str);
    }
  }
  //lexicographic order method
  public static Boolean lexOrder(ArrayList<String> list){
    boolean lexo=false;
    if(list.size()==1)
      return true;
    //checking lexographic order
    else if(list.get(0).compareTo(list.get(1))==1) {
      lexo=false;
    }
    else {
      list.remove(0);
      lexo=lexOrder(list); 
    } 
    return lexo;
  }
  public static void nDigit(int n1, int n2){// n digits with rules in d part
    if(n1>0){
      
      if(n1-1<=99&&n1-1>=10){
        nDigit(n1-1,n2);//recursion 
        if(n1%2==0&&(n1%10>n1/10)&&(n1/10!=0)) 
          System.out.print(""+n1+"\n");
      }   
      else if(n1-1<=999&&n1-1>=100){
        if(n1==101) n1=0;
        nDigit(n1-1,n2); //recursion
        if(n1%2==0&&n1/100<(n1%100)/10&&(n1%100)/10<n1%10&&n1/100!=0) 
          System.out.print(""+n1+"\n");
      } 
    }   
  }
  public static int gcd(int x, int y) {
    if (y == 0) 
      return x; //best case scenario
    else if (x >= y && y > 0) 
      return gcd(y, (x % y));
    else 
      return gcd ( y , x ); 
  }
  public static boolean itisSorted(int[] data, int n) {
    // Null or less then 2 elements is sorted.
    if (data == null || n < 2) 
      return true;
    else if (data[n - 2] > data[n - 1]) {
      // If the element before (n-2) this one (n-1) is greater,
      return false;
    }
    // recurse.
    return itisSorted(data, n - 1);
  }
  
  public static long getSize(File file) {
    long size;
    if (file.isDirectory()) {
        size = 0;
        for (File child : file.listFiles()) {
            size += getSize(child);
        }
    } else {
        size = file.length();
    }
    return size;
  } 
}