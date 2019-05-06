import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;


public class DrawableSquare extends Rectangle implements DrawableShape {

  private Point location;
  private Color lineColor;
  private Color fillColor;
  private boolean draw;
  private double speed;


   DrawableSquare() {
      this(1);
   }
 
   DrawableSquare(double s, Point p, Color line, Color fill) {
      super (s,s);
    int option = (int) Math.random() * 3;
    draw = option < 2;
    speed =  getRandomSpeed();
      setLocation(p);
      setLineColor(line);
      setFillColor(fill);
      setType("Square");
   }
   
   DrawableSquare(double s) {
      this(s, new Point(50, 50), Color.BLUE, Color.GREEN);      
   }
 //
 

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
  
     public double getSide() {
      return super.getLength();
   }
   
   public void setSide(double s) {
      super.setLength(s);
      super.setWidth(s);
   }
   
   public double perimeter() {
      return 4 * super.getLength();
   }
   
   public void slide (double x, double y) {
     Point oldPoint = getLocation();
     double oldX = oldPoint.getX();
     double oldY = oldPoint.getY();
     double newX = oldX + x;
     double newY = oldY + y;
     
     Point newLocation = new Point((int)newX, (int)newY);
     setLocation(newLocation);
   }
   
   public boolean contains(Point p) {      // THIS METHOD BELONGS IN RECTANGLE
     double px = p.getX();
     double py = p.getY();
 
     Point location = super.getLocation();
     double startX = location.getX();
     double startY = location.getY();
     double endX = startX + super.getWidth();
     double endY = startY + super.getLength();
     
     return px >= startX && px <= endX && py >= startY && py <= endY;    
   }
     
   
   public void drawMe(Graphics g) {
   
      Point topLeft = super.getLocation();
      int ul = (int) topLeft.getX();
      int ur = (int) topLeft.getY();
      int side = (int) super.getWidth();
      Color penColor = super.getLineColor();
      Color fillColor = super.getFillColor();
       
      if (penColor == null && fillColor == null) {
         g.setColor(Color.BLACK);        
         g.drawRect(ul, ur, side, side);
      }
      else {
         if (penColor != null) {
            g.setColor(penColor);
            g.drawRect(ul, ur, side, side);
         }
        if (fillColor != null) {
            g.setColor(fillColor);
            g.fillRect(ul, ur, side, side);
         }
      } 
   }
      
   public String toString() {
      return String.format("%s: side: %,.2f, area: %,.2f, perimeter: %,.2f", 
                              super.getType(), super.getLength(), getArea(), getPerimeter());
    
   }
 
}