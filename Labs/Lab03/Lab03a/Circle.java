/* @author Ege Darcin
 * Version 1.1
 * 21302460
 * Lab03a
 */   
public class Circle extends Shape implements Selectable {
  // Variables 
  private int radius;
  public boolean selected;
  
  // Constant
  private final double Pi = 3.14;
  
  // Constructor
  public Circle(int radius, int x, int y) {
    this.radius = radius;
    setLocation(x, y);
  }
  
  // Returns the area of the circle
  public double getArea() {
    double area = 2 * Pi * radius * radius;
    return area; 
  }
  
  // Returns the properties of the circle in a string form.
  public String getInfo() {
    String str = "not selected";
    if(selected) {
      str = "selected";
    }
    return "Circle(" + x + ", " + y + ") has a radius length of " + radius + " cm and has area of " + getArea()+ " and is "+str;
  }
  
  // Getter Method
  public boolean getSelected() 
  {
    return selected;
  }
  
  // Setter Method
  public void setSelected(boolean selected) 
  {
    this.selected = selected;
  }
  
  // Checks if the circle contains the given location. Returns true if it does, otherwise returns false.
  public boolean contains(int x, int y) 
  {
    double num1 = getX();
    double num2 = getY();
    if(Math.pow(num1 - x , 2) + Math.pow(num2 - y, 2) < Math.pow (radius, 2)) {
      return true;
    }
    return false;  
  }
}