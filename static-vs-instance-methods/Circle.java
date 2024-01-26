public class Circle {
  // static data
  static private double PI = 3.14159265359;

  // static mehods
  static double PI() {
    return PI;
  }

  static double areaFromRadius(double radius) {
    return PI * radius * radius;
  }

  static double areaFromDiameter(double diameter) {
    return areaFromRadius(diameter / 2);
  }

  static double areFromCircumference(double circumference) {
    return areaFromRadius(circumference / (2 * PI));
  }

  static double circumferenceFromRadius(double radius) {
    return 2 * PI * radius;
  }

  static double circumferenceFromDiameter(double diameter) {
    return circumferenceFromRadius(diameter / 2);
  }

  static double circumferenceFromArea(double area) {
    return circumferenceFromRadius(Math.sqrt(area / PI));
  }

  // instance data
  private double pi;
  private double radius;

  // constructor
  public Circle(double radius) {
    this.pi = PI;
    this.radius = radius;
  }

  // isntance methods
  public double getRadius() {
    return radius;
  }

  public double getArea() {
    return pi * radius * radius;
  }

  public double getCircumference() {
    return 2 * pi * radius;
  }

  public double getDiameter() {
    return 2 * radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }
}