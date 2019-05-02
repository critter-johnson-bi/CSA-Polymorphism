public class DrawingObject {
  private final int MIN_SPEED = 5;
  private final int MAX_SPEED = 20;
  
  private Shape shape;
  private boolean draw;
  private double speed;
  
  DrawingObject() {
    shape = ShapeTesterTK.getRandomShape();
    int option = (int) Math.random() * 3;
    draw = option < 2;
    speed = Math.random() * (MAX_SPEED - MIN_SPEED) + MIN_SPEED;
  }
  
  public Shape getShape () {
    return shape;
  }
  
  public boolean getDraw() {
    return draw;
  }
  
  public double getSpeed() {
    return speed;
  } 
  
  public void setShape() {
    shape = ShapeTesterTK.getRandomShape();
  }
  
  public void setDraw(boolean b) {
    draw = b;
  }
  
  public void setSpeed(double s) {
    speed = s;
  }
  
  public String toString() {
    String result = shape.toString();
    result += String.format(" draw: %b, speed: %,.2f", draw, speed); 
    return result;
  }
  }