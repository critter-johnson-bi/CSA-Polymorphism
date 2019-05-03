import java.util.ArrayList;
import java.util.List;

public class DrawingObjectTester extends ArrayList<DrawingObject>{

   public final static int MINSIZE = 10;       // smallest shape size
   public final static int MAXSIZE = 70;       // largest shape size, also size of the arraylist of shapes

   DrawingObjectTester() {                     // instantiates and fills array with random shapes
       for (int i = 0; i < MAXSIZE; i++) 
         add(new DrawingObject());
  }
  
   public String toString() {                  // Print each shape, using its toString on a separate line
      String result = "";
      for (DrawingObject d : this) 
         result += d + "\n";
      return result;
   }  

   public static void main(String[] args) {
   
      DrawingObjectTester objs = new DrawingObjectTester();         // Create the tester
      System.out.println(objs);
      }
}