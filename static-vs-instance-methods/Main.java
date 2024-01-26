
class Main {
  public static void main(String[] args) {
    // using static methods to work with circles
    System.out.println(Circle.PI());
    System.out.println("The area of a circle with radius 1 is " + Circle.areaFromRadius(1));
    System.out.println("The area of a circle with diameter 1 is " + Circle.areaFromDiameter(1));
    System.out.println("The circunference of a circle with radius 1 is " + Circle.circumferenceFromRadius(1));
    System.out.println();
    // using instance and instance methods to work with a circle
    Circle c = new Circle(5);
    System.out.println("The raidius of this circle is " + c.getRadius());
    c.setRadius(6);
    System.out.println("The raidius of this circle is " + c.getRadius());
    System.out.println("The diameter of this circle is " + c.getDiameter());
    System.out.println("The area of this circle is " + c.getArea());
    System.out.println("The circumfrence of this circle is " + c.getCircumference());

  }
}