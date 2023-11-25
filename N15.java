import java.util.Scanner;

public class N15 {

  public static double hypotenuse(double side1, double side2) {
    return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the length of side1: ");
    double side1 = scanner.nextDouble();

    System.out.print("Enter the length of side2: ");
    double side2 = scanner.nextDouble();

    double hypotenuse = hypotenuse(side1, side2);

    System.out.printf(
      "The hypotenuse of the right triangle is: %.2f\n",
      hypotenuse
    );

    scanner.close();
  }
}
