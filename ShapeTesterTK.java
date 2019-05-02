import java.util.ArrayList;
import java.util.List;

public class ShapeTesterTK extends ArrayList<Shape>{

   public final static int MINSIZE = 10;        // smallest shape size
   public final static int MAXSIZE = 20;       // largest shape size, also size of the arraylist of shapes

   ShapeTesterTK() {                            // instantiates and fills array with random shapes
       for (int i = 0; i < MAXSIZE; i++) addRandomShape();
  }
   
   private static double randNum() {
      return Math.random() * (MAXSIZE - MINSIZE) + MINSIZE; // Helper method to return a random number between the min and max sizes
   }      
   
  public static Shape getRandomTriangle() {                    // Adds a random type of triangle, with random dimensions
      int rand = (int) (Math.random() * 4);
      Shape triangle = null;
   
      switch (rand) {
         case 0: triangle = new EquilateralTriangle(randNum()); 
            break;
      // case 1: triangle = new Scalene(randNum(), randNum(), randNum()); break;
      // case 2: triangle = new Isoceles(randNum(), randNum()); break;
         default: triangle = new RightTriangle(randNum(), randNum()); 
            break;           
      } 
      return triangle;
   }
  
   public static Shape getRandomShape() {                        // Add a random shape to the list
      int rand = (int) (Math.random() * 7);
      switch (rand) {
         case 0: return new Circle(randNum()); 
         case 1: return new Square(randNum()); 
         case 2: return new Rectangle(randNum(), randNum());    
         case 3: 
         case 4:         
         case 5: 
         case 6: return getRandomTriangle(); 
                 }
       return null;
   }
   
   public void addRandomShape() {
     add(getRandomShape());
   }

   public String toString() {          // Print each shape, using its toString on a separate line
      String result = "";
      for (Shape s : this) 
         result += s + "\n";
      return result;
   }  

  public void legalExamples() {        // We will add legal method calls to this method
//    switch (s.getType()) {
//    }
    
    for (Shape s : this) {
      if (s instanceof Circle) {
        System.out.printf("Circumference: %s\n", ((Circle)s).getCircumference());
        }
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
   
      ShapeTesterTK st = new ShapeTesterTK();         // Create the tester
   
      //System.out.println(st);
      
      st.legalExamples();                             // Run the tests
      st.compilerErrorExamples();
      st.runtimeErrorExamples();
   }
}