public class N15 {

  public static void main(String[] args) {
    int arraySize;

    if (args.length > 0) {
      try {
        arraySize = Integer.parseInt(args[0]);
      } catch (NumberFormatException e) {
        System.out.println(
          "Invalid integer command-line argument. Using default size 10."
        );
        arraySize = 10;
      }
    } else {
      arraySize = 10;
    }

    int[] array = new int[arraySize];

    for (int i = 0; i < array.length; i++) {
      array[i] = i + 1;
      System.out.print(array[i] + " ");
    }
  }
}
