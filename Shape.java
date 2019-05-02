import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public abstract class Shape {
  public String type = "Shape";
  private Point location;
  private Color lineColor;
  private Color fillColor;
 
  abstract double area();
  abstract void drawMe(Graphics g);
  
  public String getType() {
    return type;
  }
  
  public Point getLocation() {
    return location;
  }
  
  public Color getLineColor() {
    return lineColor;
  }
  
  public Color getFillColor() {
    return fillColor;
  }
  
  public void setLineColor(Color c) {
    lineColor = c;
  }
  
  public void setFillColor(Color c) {
    fillColor = c;
  }
  
  public void setLocation(int x, int y) {
    if (location == null) location = new Point();
    location.setLocation(x, y);
  }
  
  public void setLocation(Point p) {
    if (location == null) location = new Point();
    location.setLocation(p);
  }
}