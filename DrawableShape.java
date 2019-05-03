import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public abstract class DrawableShape extends Shape {
  private static final int MIN_SPEED = 5;
  private static final int MAX_SPEED = 20;
 
  private Point location;
  private Color lineColor;
  private Color fillColor;
 

  private boolean draw;
  private double speed;
    abstract void drawMe(Graphics g);

 DrawableShape() {
    int option = (int) Math.random() * 3;
    draw = option < 2;
    speed =  getRandomSpeed();
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
  
  
  public boolean getDraw() {
    return draw;
  }
  
  public double getSpeed() {
    return speed;
  } 
  
  public static double getRandomSpeed() {
    return Math.random() * (MAX_SPEED - MIN_SPEED) + MIN_SPEED;
  }  
 
  public void setDraw(boolean b) {
    draw = b;
  }
  
  public void setSpeed(double s) {
    speed = s;
  }
  
  public String toString() {
    String result = super.toString();
    result += String.format(" draw: %b, speed: %,.2f", draw, speed); 
    return result;
  }
  }