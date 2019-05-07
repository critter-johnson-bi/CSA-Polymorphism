/*
*  Author: Critter Johnson
*/

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public class DrawableRightTriangle extends RightTriangle implements DrawableShape
{
   private Point location;
   private Color lineColor;
   private Color fillColor;
   private boolean draw;
   private double speed;
   
   public DrawableRightTriangle(double a, double b, double c, Color lineColor, Color fillColor)
   {
      super(a, b, c);
      this.lineColor = lineColor;
      this.fillColor = fillColor;
   }
   
   public DrawableRightTriangle(double a, double b, Color lineColor, Color fillColor)
   {
      super(a, b);
      this.lineColor = lineColor;
      this.fillColor = fillColor;
   }
   
   public void drawMe(Graphics g)
   {
      Point topLeft = getLocation();
      int x = (int) topLeft.getX();
      int y = (int) topLeft.getY();
      int newX = (int) (x + getB());
      int newY = (int) (y + getA());
      g.setColor(getLineColor());
      g.drawLine(x, y, x, newY);
      g.drawLine(x, newY, newX, newY);
      g.drawLine(newX, newY, x, y);
   }
   
   public Point getLocation()
   {
      return location;
   }
    
   public Color getLineColor()
   {
      return lineColor;
   }

   public Color getFillColor()
   {
      return fillColor;
   }
  
   public void setLineColor(Color c)
   {
      this.lineColor = c;
   }
   
   public void setFillColor(Color c)
   {
      this.fillColor = c;
   }
   
   public void setLocation(int x, int y)
   {
      this.location = new Point(x, y);
   }
   
   public void setLocation(Point p)
   {
      this.location = p;
   }
   
   public boolean getDraw()
   {
      return draw;
   }
   
   public double getSpeed()
   {
      return speed;
   }
   
   public void setDraw(boolean b)
   {
      this.draw = b;
   }
   
   public void setSpeed(double s)
   {
      this.speed = s;
   }
}