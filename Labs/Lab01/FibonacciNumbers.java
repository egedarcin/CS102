/* Author: Ege Darcin
 * 21302460
 * Lab 01
 * Version: 1.0
 * This class is for printing the first 40 Fibonacci numbers
 */

public class FibonacciNumbers {
  public static void main (String [] args) {
    IntBag fibonacciNumbers = new IntBag(); //creates a new int bag
    System.out.println("First 40 Fibonacci numbers are:");
    fibonacciNumbers.add(0); //adds the first two integers to the bag
    fibonacciNumbers.add(1);
    for (int i = 2; i<40; i++){    //computes the remaining fibonacci numbers
      fibonacciNumbers.add(fibonacciNumbers.get(i-2) + fibonacciNumbers.get(i-1));
    } 
    // prints out the content
    System.out.println(fibonacciNumbers);
  }
}