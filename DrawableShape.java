import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public interface DrawableShape {
  static final int MIN_SPEED = 5;
  static final int MAX_SPEED = 20;
 
/*
  private Point location;
  private Color lineColor;
  private Color fillColor;


  private boolean draw;
  private double speed;

*/
    void drawMe(Graphics g);

   Point getLocation();
   
  Color getLineColor();

  Color getFillColor();
 
  void setLineColor(Color c);
  
  void setFillColor(Color c);
  
  void setLocation(int x, int y);
  
  void setLocation(Point p);
  
  boolean getDraw();
  
  double getSpeed();
  
  void setDraw(boolean b);
  
  void setSpeed(double s);
    }