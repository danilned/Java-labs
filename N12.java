import java.util.Scanner;

public class N12 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] uniqueNumbers = new int[5];
    int numCount = 0;

    System.out.println("Enter five numbers between 10 and 100:");

    for (int i = 0; i < 5; i++) {
      System.out.print("Enter number " + (i + 1) + ": ");
      int number = scanner.nextInt();

      if (number < 10 || number > 100) {
        System.out.println(
          "The number must be between 10 and 100. Please try again."
        );
        i--;
        continue;
      }

      boolean isDuplicate = false;
      for (int j = 0; j < numCount; j++) {
        if (uniqueNumbers[j] == number) {
          isDuplicate = true;
          break;
        }
      }

      if (!isDuplicate) {
        uniqueNumbers[numCount] = number;
        numCount++;
      }

      System.out.print("Unique values: ");
      for (int j = 0; j < numCount; j++) {
        System.out.print(uniqueNumbers[j] + " ");
      }
      System.out.println();
    }

    scanner.close();
  }
}
