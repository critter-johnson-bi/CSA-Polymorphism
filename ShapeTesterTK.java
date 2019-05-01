import java.util.ArrayList;
import java.util.List;

public class ShapeTesterTK {
   private final static int MINSIZE = 10;
   private final static int MAXSIZE = 100;

   private List<Shape> shapes;
 
   ShapeTesterTK() {
      shapes = new ArrayList<Shape>(MAXSIZE);
   }
   
   private double randNum() {
      return Math.random() * (MAXSIZE - MINSIZE) + MINSIZE;
   }
  
   private void addCircle() {
      shapes.add(new Circle(randNum()));
   }
  
   private void addRectangle() {
      shapes.add(new Rectangle(randNum(), randNum()));
   }
  
   private void addSquare() {
      shapes.add(new Square(randNum()));
   }

   private void addTriangle() {
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
      if (! (triangle == null)) shapes.add(triangle);
   }
  
   private void addRandomShape() {
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

   public String toString() {
      String result = "";
      for (Shape s : shapes) 
         result += s + "\n";
      return result;
   }  

  public void legalExamples() {
    for (Shape s : shapes) {
      if (s instanceof Circle) {
        System.out.printf("Circumference: %s\n", ((Circle)s).circumference());
        }
       }
       
        
  }
  
  public static void compilerErrorExamples() {
  
  }
  
  public static void runtimeErrorExamples() {
  
  }


   public static void main(String[] args) {
   
      ShapeTesterTK st = new ShapeTesterTK();
   
      for (int i = 0; i < MAXSIZE; i++) st.addRandomShape();
      System.out.println(st);
      
      st.legalExamples();
      st.compilerErrorExamples();
      st.runtimeErrorExamples();
   }
}