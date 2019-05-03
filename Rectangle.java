import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends Shape {

   private double length;
   private double width;
   
   //Constructor
   public Rectangle(double l, double w, Point p, Color line, Color fill) {
      length = l;
      width = w;
      setLocation(p);
      setLineColor(line);
      setFillColor(fill);
      setType("Rectangle");
   }
   
   //Accessor for length field
   public double getLength() {
      return length;
   }
   
   //Accessor for width field
   public double getWidth() {
      return width;
   }
   
   //Setter fpr length field
   public void setLength(double newL) {
      length = newL;
   }
   
   //Setter for width field
   public void setWidth(double newW) {
      width = newW;
   }
   
   public double getPerimeter() {
      return length * 2 + width * 2;
   }
   
   public double getArea() {
      return length * width;
   }
   
   public void drawMe(Graphics g) {
      Point topLeft = super.getLocation();
      int ul = (int) topLeft.getX();
      int ur = (int) topLeft.getY();
      int side = (int) this.getWidth();
   /*     
     g.drawLine(ul, ur, ul + side, ur);
     g.drawLine(ul, ur, ul, ur + side);
     g.drawLine(ul+side, ur+side, ul, ur+side);
     g.drawLine(ul+side, ur+side, ul + side, ur);
     */
     
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
   
   //Printing format
   public String toString() {
      return "side 1 is equal to " + length + " and side 2 is equal to " + width;
   }

}