public class N6 {

  private static double annualInterestRate = 0.0;
  private double savingsBalance;

  public N6(double savingsBalance) {
    this.savingsBalance = savingsBalance;
  }

  public void calculateMonthlyInterest() {
    double monthlyInterest = (this.savingsBalance * annualInterestRate) / 12;
    this.savingsBalance += monthlyInterest;
  }

  public static void modifyInterestRate(double newInterestRate) {
    annualInterestRate = newInterestRate / 100;
  }

  public double getSavingsBalance() {
    return this.savingsBalance;
  }
}
