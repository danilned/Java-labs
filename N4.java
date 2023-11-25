public class N4 {

  private double length = 1.0;
  private double width = 1.0;

  public N4(double length, double width) {
    setLength(length);
    setWidth(width);
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    if (length > 0.0 && length < 20.0) {
      this.length = length;
    } else {
      throw new IllegalArgumentException("Length must be > 0.0 and < 20.0");
    }
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    if (width > 0.0 && width < 20.0) {
      this.width = width;
    } else {
      throw new IllegalArgumentException("Width must be > 0.0 and < 20.0");
    }
  }

  public double getArea() {
    return length * width;
  }

  public double getPerimeter() {
    return 2 * (length + width);
  }
}
