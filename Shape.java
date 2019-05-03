public abstract class Shape {
  private String type = "Shape";
  abstract double getArea();
  abstract double getPerimeter();
  
  public String getType() {
    return type;
  }
  
  public void setType(String t) {
    type = t;
  }
}