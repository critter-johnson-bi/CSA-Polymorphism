import java.util.ArrayList;
import java.util.List;

public class ShapeTesterTK extends ArrayList<Shape>{

   public final static int MINSIZE = 10;        // smallest shape size
   public final static int MAXSIZE = 100;       // largest shape size, also size of the arraylist of shapes

  // private List<Shape> shapes;                  // list of shapes
 
   ShapeTesterTK() {                            // instantiates and fills array with random shapes
 //     shapes = new ArrayList<Shape>(MAXSIZE);
 //       this = new ArrayList<Shape>(MAXSIZE);
       for (int i = 0; i < MAXSIZE; i++) addRandomShape();
  }
   
 //  public List<Shape> getShapes() { return shapes; }  // allows other classes to grab the array list.  I don't like this, because they can modify it.
                                                      // Perhaps it would be better to give them a clone of the array list??
   
   private double randNum() {
      return Math.random() * (MAXSIZE - MINSIZE) + MINSIZE; // Helper method to return a random number between the min and max sizes
   }
  
   private void addCircle() {
      add(new Circle(randNum()));           // Adds a new Circle with a random size
   }
  
   private void addRectangle() {
      add(new Rectangle(randNum(), randNum()));   // Adds a new Rectangle with random dimensions
   }
  
   private void addSquare() {                      // Adds a new Square with a random side size
      add(new Square(randNum()));
   }

   private void addTriangle() {                    // Adds a random type of triangle, with random dimensions
      int rand = (int) (Math.random() * 4);
      Shape triangle = null;
   
      switch (rand) {
         case 0: triangle = new EquilateralTriangle(randNum()); 
            break;
      // case 1: triangle = new Scalene(randNum(), randNum(), randNum()); break;
      // case 2: triangle = new Isoceles(randNum(), randNum()); break;
         case 3: triangle = new RightTriangle(randNum(), randNum()); 
            break;
      } 
      if (! (triangle == null)) add(triangle);    // Ensure that a triangel was actually created
   }
  
   public void addRandomShape() {                        // Add a random shape to the list
      int rand = (int) (Math.random() * 7);
      switch (rand) {
         case 0: addCircle(); 
            break;
         case 1: addSquare(); 
            break;
         case 2: addRectangle(); 
            break;
         case 3: addTriangle(); 
            break;
         case 4: addTriangle(); 
            break;
         case 5: addTriangle(); 
            break;
         case 6: addTriangle(); 
            break;
      }
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
        System.out.printf("Circumference: %s\n", ((Circle)s).getCircum());
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