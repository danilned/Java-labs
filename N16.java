public class N16 {

  public static void main(String[] args) {
    double sum = 0.0;

    for (String arg : args) {
      try {
        sum += Double.parseDouble(arg);
      } catch (NumberFormatException e) {
        System.out.println(
          "Invalid input: \"" + arg + "\" is not a double. Ignoring."
        );
      }
    }

    System.out.println("Sum of the double values: " + sum);
  }
}
