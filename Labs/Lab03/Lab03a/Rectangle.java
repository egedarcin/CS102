/* @author Ege Darcin
 * Version 1.1
 * 21302460
 * Lab03a
 */   
public class Rectangle extends Shape implements Selectable {
  
  // Variables
  private int height, width;
  public boolean selected;
  
  // Constructor
  public Rectangle(int height, int width, int x, int y) 
  {
    this.height = height;
    this.width = width;
    setLocation(x, y);
  }
  
  // Returns the area of the rectangle
  public double getArea() 
  {
    double area = (double) (width * height);
    return area; 
  }
  
  // Returns the properties of the rectangle in a string form.
  public String getInfo()
  {
    String str = "not selected";
    if(selected) {
      str = "selected";
    }
    return "Rectangle(" + x + ", " + y + ") is " + height + "cm high and " + width + "cm wide and has area of " + getArea()+ " and is "+str;
  }
  
  // Get method
  public boolean getSelected() 
  {
    return selected;
  }
  
  // Set method
  public void setSelected(boolean selected) 
  {
    this.selected = selected;
  }
  
  // Checks if the rectangle contains the given location. Returns true if it does, otherwise returns false.
  public boolean contains(int x, int y) 
  {
    
    if(getX() <= x && x <= getX() + width && getY() <= y && y <= getY() + height) {
      return true;
    }
    return false;
  }
}