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

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  public String toString() {
    return String.format(
      "%s %s\nSocial Security Number: %s",
      getFirstName(),
      getLastName(),
      getSocialSecurityNumber()
    );
  }
}

class HourlyEmployee extends Employee {

  private double hours;
  private double wage;

  public HourlyEmployee(
    String firstName,
    String lastName,
    String socialSecurityNumber,
    double wage,
    double hours
  ) {
    super(firstName, lastName, socialSecurityNumber);
    if (wage < 0.0) {
      throw new IllegalArgumentException("Hourly wage must be >= 0.0");
    }
    if (hours < 0.0 || hours > 168.0) {
      throw new IllegalArgumentException(
        "Hours worked must be >= 0.0 and <= 168.0"
      );
    }
    this.wage = wage;
    this.hours = hours;
  }

  public void setWage(double wage) {
    if (wage < 0.0) {
      throw new IllegalArgumentException("Hourly wage must be >= 0.0");
    }
    this.wage = wage;
  }

  public double getWage() {
    return wage;
  }

  public void setHours(double hours) {
    if ((hours < 0.0) || (hours > 168.0)) {
      throw new IllegalArgumentException(
        "Hours worked must be >= 0.0 and <= 168.0"
      );
    }
    this.hours = hours;
  }

  public double getHours() {
    return hours;
  }

  public double earnings() {
    if (getHours() <= 40) { // No overtime
      return getWage() * getHours();
    } else {
      return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
    }
  }

  public String toString() {
    return String.format(
      "Hourly Employee: %s\nHourly Wage: $%,.2f; Hours Worked: %,.2f",
      super.toString(),
      getWage(),
      getHours()
    );
  }
}

class EmployeeTest {

  public static void main(String[] args) {
    HourlyEmployee hourlyEmployee = new HourlyEmployee(
      "John",
      "Smith",
      "111-11-1111",
      25.0,
      50
    );
    System.out.println("Employee information obtained by toString method:");
    System.out.println(hourlyEmployee);

    System.out.printf("Earnings: $%,.2f\n", hourlyEmployee.earnings());
  }
}
