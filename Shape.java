import java.awt.Point;
import java.awt.Graphics;

public abstract class Shape {
  public String type = "Shape";
  private Point location;
 
  abstract double area();
  abstract void drawMe(Graphics g);
  
  public String getType() {
    return type;
  }
  
  public Point getLocation() {
    return location;
  }
  
  public void setLocation(int x, int y) {
    if (location == null) location = new Point();
    location.setLocation(x, y);
  }
}