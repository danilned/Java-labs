class Date {

  private int month;
  private int day;
  private int year;

  public Date(int month, int day, int year) {
    if (month <= 0 || month > 12) {
      throw new IllegalArgumentException("month must be 1-12");
    }
    if (day <= 0 || day > 31) {
      throw new IllegalArgumentException("day must be 1-31");
    }
    if (year < 1900 || year > 2100) {
      throw new IllegalArgumentException("year must be 1900-2100");
    }

    this.month = month;
    this.day = day;
    this.year = year;
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

  public int getYear() {
    return year;
  }

  public String toString() {
    return String.format("%d/%d/%d", month, day, year);
  }
}

abstract class Employee {

  private final String firstName;
  private final String lastName;
  private final String socialSecurityNumber;
  private final Date birthDate;

  public Employee(
    String firstName,
    String lastName,
    String socialSecurityNumber,
    Date birthDate
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;
    this.birthDate = birthDate;
  }

  public abstract double earnings();

  public Date getBirthDate() {
    return birthDate;
  }

  public String toString() {
    return String.format(
      "%s %s\nSocial Security Number: %s\nBirth Date: %s",
      firstName,
      lastName,
      socialSecurityNumber,
      birthDate
    );
  }
}

class SalariedEmployee extends Employee {

  private double weeklySalary;

  public SalariedEmployee(
    String firstName,
    String lastName,
    String socialSecurityNumber,
    double salary,
    Date birthDate
  ) {
    super(firstName, lastName, socialSecurityNumber, birthDate);
    this.weeklySalary = salary;
  }

  @Override
  public double earnings() {
    return weeklySalary;
  }
}

class PayrollSystemTest {

  public static void main(String[] args) {
    Employee[] employees = new Employee[2];
    employees[0] =
      new SalariedEmployee(
        "John",
        "Doe",
        "111-11-1111",
        800.00,
        new Date(6, 15, 1980)
      );

    int currentMonth = 6;

    for (Employee currentEmployee : employees) {
      double earnings = currentEmployee.earnings();
      if (currentMonth == currentEmployee.getBirthDate().getMonth()) {
        earnings += 100.00;
        System.out.printf(
          "Happy Birthday! Added a $100 bonus to your payroll.\n"
        );
      }

      System.out.printf("Paid to %s $%,.2f\n", currentEmployee, earnings);
    }
  }
}
