/*
   Author: Jack Eastman
   Date: 5/2/19
   Purpose: isoceles triangle class
*/

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public class DrawableIsocelesTriangle extends IsocelesTriangle implements DrawableShape
{

   private Point location;
   private Color lineColor;
   private Color fillColor;
   private boolean draw;
   private double speed;
   
   public DrawableIsocelesTriangle(double ab, double c, Color lineColor, Color fillColor)
   {
      super(ab, c);
      this.lineColor = lineColor;
      this.fillColor = fillColor;
      setLocation(0, 0);
   }
   
   public void drawMe(Graphics g)
   {
      double height = (getA() * getA()) - ((getC()/2) * (getC()/2));
      //Finds x and y values of the top left of the box that surrounds the triangle
      Point boxP = getLocation();
      int boxX = (int)boxP.getX();
      int boxY = (int)boxP.getY();
      //Finds x and y values of bottom left of triangle
      int startX = boxX;
      int startY = (int)(boxY - height);
      int[] xPoints = {startX, startX + (int)getC(), startX + (int)(getC()/2)};
      int[] yPoints = {startY, startY, startY + (int)height};
      
      //Draw time
      g.setColor(getLineColor());
      g.fillPolygon(xPoints, yPoints, 3);
      
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