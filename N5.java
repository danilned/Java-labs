public class N5 {

  private int secondsSinceMidnight;

  public void setTime(int hour, int minute, int second) {
    if (
      hour < 0 ||
      hour >= 24 ||
      minute < 0 ||
      minute >= 60 ||
      second < 0 ||
      second >= 60
    ) {
      throw new IllegalArgumentException(
        "hour, minute and/or second was out of range"
      );
    }

    this.secondsSinceMidnight = hour * 3600 + minute * 60 + second;
  }

  public void setHour(int hour) {
    if (hour < 0 || hour >= 24) {
      throw new IllegalArgumentException("hour must be 0-23");
    }
    this.secondsSinceMidnight = this.secondsSinceMidnight % 3600 + hour * 3600;
  }

  public void setMinute(int minute) {
    if (minute < 0 || minute >= 60) {
      throw new IllegalArgumentException("minute must be 0-59");
    }
    this.secondsSinceMidnight = getHour() * 3600 + minute * 60 + getSecond();
  }

  public void setSecond(int second) {
    if (second < 0 || second >= 60) {
      throw new IllegalArgumentException("second must be 0-59");
    }
    this.secondsSinceMidnight = getHour() * 3600 + getMinute() * 60 + second;
  }

  public int getHour() {
    return secondsSinceMidnight / 3600;
  }

  public int getMinute() {
    return (secondsSinceMidnight % 3600) / 60;
  }

  public int getSecond() {
    return secondsSinceMidnight % 60;
  }

  public String toUniversalString() {
    return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
  }

  public String toString() {
    return String.format(
      "%d:%02d:%02d %s",
      ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
      getMinute(),
      getSecond(),
      (getHour() < 12 ? "AM" : "PM")
    );
  }
}
