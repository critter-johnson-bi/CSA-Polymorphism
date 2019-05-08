/*FRANKY WROTE THIS - or not if there are a lot of mistakes */

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public class DrawableCircle extends Circle implements DrawableShape
{
  private Point location;
  private Color lineColor;
  private Color fillColor;

  private boolean draw;
  private double speed;
  
  public DrawableCircle(double r)
  {
      super(r);
  }
  
  public void drawMe(Graphics g)
   {
      Point topLeft = getLocation();
      int ul = (int) topLeft.getX();
      int ur = (int) topLeft.getY();
      int radius = (int) getRadius();
      Color penColor = getLineColor();
      Color fillColor = getFillColor();
       
      if (penColor == null && fillColor == null) {
         g.setColor(Color.BLACK);        
         g.drawOval(ul, ur, radius, radius);
      }
      else {
         if (penColor != null) {
            g.setColor(penColor);
            g.drawOval(ul, ur, radius, radius);
         }
        if (fillColor != null) {
            g.setColor(fillColor);
            g.fillOval(ul, ur, radius, radius);
         }
      }
   }

  public Point getLocation() { return location; }
   
  public Color getLineColor() { return lineColor; }

  public Color getFillColor() { return fillColor; }
 
  public void setLineColor(Color c) { lineColor = c; }
  
  public void setFillColor(Color c) { fillColor = c; }
  
  public void setLocation(int x, int y) { location = new Point(x, y); }
  
  public void setLocation(Point p) { location = new Point(p); }
  
  public boolean getDraw() { return draw; }
  
  public double getSpeed() { return speed; }
  
  public void setDraw(boolean b) { draw = b; }
  
  public void setSpeed(double s) { speed = s; }
  
}