import java.util.Scanner;

public class N8 {

  private static double calculateCharges(double hoursParked) {
    double charge = hoursParked <= 3
      ? 2.00
      : hoursParked < 24 ? 2.00 + 0.50 * Math.ceil(hoursParked - 3) : 10.00;

    return Math.min(charge, 10.00);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double totalReceipts = 0;
    double hoursParked;
    double currentCharge;

    while (true) {
      System.out.print("Enter the number of hours parked (negative to quit): ");
      hoursParked = scanner.nextDouble();

      if (hoursParked < 0) {
        break;
      }

      currentCharge = calculateCharges(hoursParked);
      totalReceipts += currentCharge;

      System.out.printf("Current charge: $%.2f\n", currentCharge);
      System.out.printf("Total receipts: $%.2f\n", totalReceipts);
    }

    System.out.println("Exiting the parking charge calculator.");
    scanner.close();
  }
}
