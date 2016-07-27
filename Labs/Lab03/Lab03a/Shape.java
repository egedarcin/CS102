/* @author Ege Darcin
 * Version 1.1
 * 21302460
 * Lab03a
 */   
public abstract class Shape implements Locatable {
  
  // Variables
  int x = 0;
  int y = 0;
  
  // Abstract Methods
  public abstract double getArea();
  public abstract String getInfo();
  
  // x
  public int getX() {
    return x;
  }
  
  // y
  public int getY() {
    return y;
  }
  
  //location method
  public void setLocation(int x, int y) {
    this.x = x;
    this.y = y;
  } 
  
}