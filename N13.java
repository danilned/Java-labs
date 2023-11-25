abstract class Shape {

  public abstract String getName();
}

abstract class TwoDimensionalShape extends Shape {

  public abstract double getArea();
}

abstract class ThreeDimensionalShape extends Shape {

  public abstract double getArea();

  public abstract double getVolume();
}

class Circle extends TwoDimensionalShape {

  private final double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public double getArea() {
    return Math.PI * radius * radius;
  }

  public String getName() {
    return "Circle";
  }
}

class Square extends TwoDimensionalShape {

  private final double side;

  public Square(double side) {
    this.side = side;
  }

  public double getArea() {
    return side * side;
  }

  public String getName() {
    return "Square";
  }
}

class Sphere extends ThreeDimensionalShape {

  private final double radius;

  public Sphere(double radius) {
    this.radius = radius;
  }

  public double getArea() {
    return 4 * Math.PI * radius * radius;
  }

  public double getVolume() {
    return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
  }

  public String getName() {
    return "Sphere";
  }
}

class Cube extends ThreeDimensionalShape {

  private final double side;

  public Cube(double side) {
    this.side = side;
  }

  public double getArea() {
    return 6 * side * side;
  }

  public double getVolume() {
    return Math.pow(side, 3);
  }

  public String getName() {
    return "Cube";
  }
}

class ShapesTest {

  public static void main(String[] args) {
    Shape[] shapes = new Shape[4];
    shapes[0] = new Circle(2.0);
    shapes[1] = new Square(3.0);
    shapes[2] = new Sphere(1.0);
    shapes[3] = new Cube(2.0);

    for (Shape shape : shapes) {
      System.out.println("Shape: " + shape.getName());

      if (shape instanceof TwoDimensionalShape) {
        TwoDimensionalShape twoDShape = (TwoDimensionalShape) shape;
        System.out.printf("Area: %.2f\n", twoDShape.getArea());
      }

      if (shape instanceof ThreeDimensionalShape) {
        ThreeDimensionalShape threeDShape = (ThreeDimensionalShape) shape;
        System.out.printf("Area: %.2f\n", threeDShape.getArea());
        System.out.printf("Volume: %.2f\n", threeDShape.getVolume());
      }

      System.out.println();
    }
  }
}
