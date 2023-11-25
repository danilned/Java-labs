import java.util.Scanner;

public class N19 {

  public static void displaySquare(int side, char fillCharacter) {
    for (int row = 0; row < side; row++) {
      for (int col = 0; col < side; col++) {
        System.out.print(fillCharacter);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter the size of the square: ");
    int size = input.nextInt();

    System.out.print("Enter the character to fill the square with: ");
    char fill = input.next().charAt(0);

    displaySquare(size, fill);

    input.close();
  }
}
