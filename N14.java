class Employee {

  private final String firstName;
  private final String lastName;
  private final String socialSecurityNumber;

  public Employee(
    String firstName,
    String lastName,
    String socialSecurityNumber
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;
  }

  public String toString() {
    return String.format(
      "%s %s\nsocial security number: %s",
      firstName,
      lastName,
      socialSecurityNumber
    );
  }
}

class CommissionEmployee extends Employee {

  private double grossSales;
  private double commissionRate;

  public CommissionEmployee(
    String firstName,
    String lastName,
    String socialSecurityNumber,
    double grossSales,
    double commissionRate
  ) {
    super(firstName, lastName, socialSecurityNumber);
    this.grossSales = grossSales;
    this.commissionRate = commissionRate;
  }

  public double earnings() {
    return commissionRate * grossSales;
  }

  public String toString() {
    return String.format(
      "Commission Employee: %s\nGross Sales: %.2f\nCommission Rate: %.2f",
      super.toString(),
      grossSales,
      commissionRate
    );
  }
}

class BasePlusCommissionEmployee extends CommissionEmployee {

  private double baseSalary;

  public BasePlusCommissionEmployee(
    String firstName,
    String lastName,
    String socialSecurityNumber,
    double grossSales,
    double commissionRate,
    double baseSalary
  ) {
    super(
      firstName,
      lastName,
      socialSecurityNumber,
      grossSales,
      commissionRate
    );
    this.baseSalary = baseSalary;
  }

  public double earnings() {
    return baseSalary + super.earnings();
  }

  public String toString() {
    return String.format(
      "Base-Salaried %s\nBase Salary: %.2f",
      super.toString(),
      baseSalary
    );
  }
}

class EmployeeTest {

  public static void main(String[] args) {
    CommissionEmployee commissionEmployee = new CommissionEmployee(
      "Sue",
      "Jones",
      "333-33-3333",
      10000.0,
      0.06
    );
    BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(
      "Bob",
      "Lewis",
      "444-44-4444",
      5000.0,
      0.04,
      300.0
    );

    System.out.println("Employees processed individually:\n");

    System.out.printf(
      "%s\n%s: $%,.2f\n\n",
      commissionEmployee.toString(),
      "Earned",
      commissionEmployee.earnings()
    );

    System.out.printf(
      "%s\n%s: $%,.2f\n\n",
      basePlusCommissionEmployee.toString(),
      "Earned",
      basePlusCommissionEmployee.earnings()
    );
  }
}
