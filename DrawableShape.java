import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public interface DrawableShape {
   static final int MIN_SPEED = 5;
   static final int MAX_SPEED = 20;

   void drawMe(Graphics g);
// Getters
   Point getLocation();   
   Color getLineColor();
   Color getFillColor();  
   boolean getDraw();   
   double getSpeed();
   double getWidth();
   double getLength();
// Setters
   void setLineColor(Color c);   
   void setFillColor(Color c);   
   void setLocation(int x, int y);  
   void setLocation(Point p);  
   void setDraw(boolean b);  
   void setSpeed(double s);
}