import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class DrawableShapeTesterTK extends ArrayList<DrawableShape>{

   public final static int MINSIZE = 10;        // smallest shape size
   public final static int MAXSIZE = 20;       // largest shape size, also size of the arraylist of shapes

   DrawableShapeTesterTK() {                            // instantiates and fills array with random shapes
       for (int i = 0; i < MAXSIZE; i++) addRandomShape();
  }
   
   private static double randNum() {
      return Math.random() * (MAXSIZE - MINSIZE) + MINSIZE; // Helper method to return a random number between the min and max sizes
   }      
   
  public static DrawableShape getRandomTriangle() {                    // Adds a random type of triangle, with random dimensions
      int rand = (int) (Math.random() * 4);
      DrawableShape triangle = null;
   
      switch (rand) {
         case 0: triangle = new DrawableEquilateralTriangle(randNum(), Color.GREEN, Color.DARK_GRAY); 
            break;
      case 1: triangle = new DrawableScaleneTriangle(randNum(), randNum(), randNum(), Color.GREEN, Color.DARK_GRAY); break;
       case 2: triangle = new DrawableIsocelesTriangle(randNum(), randNum(), Color.GREEN, Color.DARK_GRAY); break;
         default: triangle = new DrawableRightTriangle(randNum(), randNum(), Color.GREEN, Color.DARK_GRAY);           
      } 
      return triangle;
   }
  
   public static DrawableShape getRandomShape() {                        // Add a random shape to the list
      int rand = (int) (Math.random() * 7);
      switch (rand) {
 //       case 0: return new DrawableCircle(randNum()); 
         case 1: return new DrawableSquare(randNum()); 
         case 2: return new DrawableRectangle(randNum(), randNum());    
         case 3: 
         case 4:         
         case 5: 
         case 6: return getRandomTriangle(); 
         default: return new DrawableSquare(randNum());
                 }
 //      return null;
   }
   
   public void addRandomShape() {
     DrawableShape s = getRandomShape();
     while (s == null) s = getRandomShape();
     add(s);
   }

   public String toString() {          // Print each shape, using its toString on a separate line
      String result = "";
      for (DrawableShape s : this) 
         result += s + "\n";
      return result;
   }  

  public void legalExamples() {        // We will add legal method calls to this method
//    switch (s.getType()) {
//    }
    
    for (DrawableShape s : this) {
//      if (s instanceof DrawableCircle) {
//        System.out.printf("Circumference: %s\n", ((Circle)s).getCircumference());
 //       }
       }       
  }
  
  public static void compilerErrorExamples() { // We will add commented method calls that will not compile to this method
 /*
      for (Shape s : shapes) {
      if (s instanceof Circle) {
        System.out.printf("Circumference: %s\n", s.getCircum());
        }
       }
       */
  }
  
  public static void runtimeErrorExamples() {   // We will add methods that will cause a runtime error here.  These will sometiems be commented
  
  }

   public static void main(String[] args) {
   
      DrawableShapeTesterTK st = new DrawableShapeTesterTK();         // Create the tester
   
      System.out.println(st);
      
      st.legalExamples();                             // Run the tests
      st.compilerErrorExamples();
      st.runtimeErrorExamples();
   }
}