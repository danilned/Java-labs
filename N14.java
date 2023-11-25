abstract class Employee {

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

  public abstract double earnings();

  public String toString() {
    return String.format(
      "%s %s\nSocial Security Number: %s",
      firstName,
      lastName,
      socialSecurityNumber
    );
  }
}

class SalariedEmployee extends Employee {

  private final double weeklySalary;

  public SalariedEmployee(
    String firstName,
    String lastName,
    String socialSecurityNumber,
    double weeklySalary
  ) {
    super(firstName, lastName, socialSecurityNumber);
    this.weeklySalary = weeklySalary;
  }

  public double earnings() {
    return weeklySalary;
  }

  public String toString() {
    return String.format(
      "Salaried Employee: %s\nWeekly Salary: $%,.2f",
      super.toString(),
      earnings()
    );
  }
}

class PieceWorker extends Employee {

  private double wage;
  private int pieces;

  public PieceWorker(
    String firstName,
    String lastName,
    String socialSecurityNumber,
    double wage,
    int pieces
  ) {
    super(firstName, lastName, socialSecurityNumber);
    this.wage = wage;
    this.pieces = pieces;
  }

  public double earnings() {
    return wage * pieces;
  }

  public String toString() {
    return String.format(
      "Piece Worker: %s\nWage per piece: $%,.2f; Pieces produced: %d",
      super.toString(),
      wage,
      pieces
    );
  }
}

class PayrollSystemTest {

  public static void main(String[] args) {
    Employee[] employees = new Employee[4];
    employees[0] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
    employees[3] = new PieceWorker("Bob", "Lewis", "444-44-4444", 2.5, 200);

    for (Employee currentEmployee : employees) {
      System.out.println(currentEmployee);
      System.out.printf("Earned $%,.2f\n\n", currentEmployee.earnings());
    }
  }
}
