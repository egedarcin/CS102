public class Ellipse extends Shape implements Selectable {
  // Variables 
  private int radiusX;
  private int radiusY;
  public boolean selected;
  
  // Constant
  private final double Pi = 3.14;
  
  // Constructor
  public Ellipse(int radiusX, int radiusY, int x, int y) {
    this.radiusX = radiusX;
    this.radiusY = radiusY;
    setLocation(x, y);
  }
  public double getArea() {
    double area = Pi * radiusX * radiusY;
    return area; 
  }
  
  // Returns the properties of the circle in a string form.
  public String getInfo() {
    String str = "not selected";
    if(selected) {
      str = "selected";
    }
    return "Ellipse(" + x + ", " + y + ") has a major axis length of " + radiusX + " and a minor axis " + radiusY+ 
      " cm and has area of " + getArea()+ " and is "+str;
  }
  
  // Getter Method
  public boolean getSelected() {
    return selected;
  }
  
  // Setter Method
  public void setSelected(boolean selected) {
    this.selected = selected;
  }
  public boolean contains(int x, int y) 
  {
    double num1 = getX();
    double num2 = getY();
  
    if((Math.pow(((num1-x)/radiusX) , 2) + Math.pow(((num2-y)/radiusY), 2))<= 1) 
      return true;
    return false;  
  }
  
  
}