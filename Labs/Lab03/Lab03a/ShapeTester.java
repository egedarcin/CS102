/* @author Ege Darcin
 * Version 1.1
 * 21302460
 * Lab03a
 */     
import java.util.*;
public class ShapeTester {
  
  public static void main( String[] args) 
  {
    Scanner scan = new Scanner( System.in);
    
    // Variables
    
    ShapeContainer container = null;
    Rectangle rectangle;
    Circle circle;
    Square square;
    Ellipse ellipse;
    int option, shapeSelect, side, side1, x, y;
    x = 0;
    y = 0;
    int i;
    
    do {
      option = 0;
      // menu
      System.out.println("Welcome to the shape tester!");
      System.out.println("Press 1 to create new sheet");
      System.out.println("Press 2 to add a shape");
      System.out.println("Press 3 to look to the total area so far");
      System.out.println("Press 4 to get information about shape container");
      System.out.println("Press 5 to select a coordination ");
      System.out.println("Press 6 to delete a specific shape"); 
      System.out.println("Press 7 to exit"); 
      option = scan.nextInt();
      
      if(option == 1) {
      container = new ShapeContainer();
      }
      // Adds a shape to the container
      if(option == 2) {
        
        do {
          System.out.println("1 Rectangle");
          System.out.println("2 Circle");
          System.out.println("3 Square");
          System.out.println("4 Ellipse");
          System.out.println("5 Menu");
          shapeSelect = scan.nextInt();
          
          if(shapeSelect == 1) {
            System.out.println("Enter height");
            side = scan.nextInt();
            System.out.println("Enter width");
            side1 = scan.nextInt();
            System.out.println("Enter x axis");
            x = scan.nextInt();
            System.out.println("Enter y axis");
            y = scan.nextInt();
            if (x>=0 && y>=0){
              rectangle = new Rectangle(side, side1, x, y);
              container.add(rectangle); 
            }
            else
              System.out.println("Please type only positive containers!");
              
          }
          if(shapeSelect == 2) {
            System.out.println("Enter radius");
            side = scan.nextInt();
            System.out.println("Enter x axis:");
            x = scan.nextInt();
            System.out.println("Enter y axis:");
            y = scan.nextInt();
            if (x>=0 && y>=0){
            circle = new Circle(side, x, y);
            container.add(circle);
            }
            else
              System.out.println("Please type only positive containers!");
          }
          if(shapeSelect == 3) 
          {
            System.out.println("Enter side length");
            side = scan.nextInt();
            System.out.println("Enter x axis:");
            x = scan.nextInt();
            System.out.println("Enter y axis:");
            y = scan.nextInt();
            if (x>=0 && y>=0){
            square = new Square(side, x, y);
            container.add(square);
            }
            else
              System.out.println("Please type only positive containers!");
  
          }
          if(shapeSelect == 4) {
            System.out.println("Enter major axis");
            side = scan.nextInt();
            System.out.println("Enter minor axis");
            side1 = scan.nextInt();
            System.out.println("Enter x axis:");
            x = scan.nextInt();
            System.out.println("Enter y axis:");
            y = scan.nextInt();
            if (x>=0 && y>=0){
            ellipse = new Ellipse(side, side1, x, y);
            container.add(ellipse);
            }
            else
              System.out.println("Please type only positive containers!");
           
          }
        } while (shapeSelect != 5);  
      }
      
      // Prints the total surface area of the shapes
      if(option == 3) 
      {
        if (container.getArea() != 0.0)
          System.out.println("Total surfaces area " + container.getArea() );
        else 
          System.out.println("There is no surface to calculate!");
      }
      
      // Prints the information of the shapes in the container
      if(option == 4) {
        
        System.out.println(container.toString());
      }
      
      // Finds the first shape with given location and selects it
      if(option == 5) 
      {
        System.out.println("Enter x axis:");
        x = scan.nextInt();
        System.out.println("Enter y axis:");
        y = scan.nextInt();
        if(container.firstShape(x, y) == null) {
          System.out.println("Try another location");
        }
        else
          System.out.println((container.firstShape(x, y)).getInfo());
      }
      // Removes the shape which user selects..
      if(option == 6) {
        container.delete();
        System.out.println("Selected item is deleted");
      }
      
      
    } while (option != 7);
  }
}