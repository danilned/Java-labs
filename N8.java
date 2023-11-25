public class N8 {

  private int month;
  private int day;
  private int year;

  private static final int[] daysPerMonth = {
    0,
    31,
    28,
    31,
    30,
    31,
    30,
    31,
    31,
    30,
    31,
    30,
    31,
  };

  public N8(int month, int day, int year) {
    if (month <= 0 || month > 12) {
      throw new IllegalArgumentException("month (" + month + ") must be 1-12");
    }

    if (year < 1900 || year > 2100) {
      throw new IllegalArgumentException(
        "year (" + year + ") must be 1900-2100"
      );
    }

    if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
      throw new IllegalArgumentException(
        "day (" + day + ") out-of-range for the specified month and year"
      );
    }

    if (
      month == 2 &&
      day == 29 &&
      !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
    ) {
      throw new IllegalArgumentException(
        "day (" + day + ") out-of-range for the specified month and year"
      );
    }

    this.month = month;
    this.day = day;
    this.year = year;

    System.out.printf("Date object constructor for date %s%n", this);
  }

  public void nextDay() {
    if (month == 12 && day == 31) {
      year++;
      month = 1;
      day = 1;
    } else if (day == daysPerMonth[month]) {
      month++;
      day = 1;
    } else if (month == 2 && day == 28 && isLeapYear(year)) {
      day++;
    } else if (month == 2 && day == 29 && isLeapYear(year)) {
      month++;
      day = 1;
    } else {
      day++;
    }
  }

  private boolean isLeapYear(int year) {
    return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
  }

  public String toString() {
    return String.format("%d/%d/%d", month, day, year);
  }
}
