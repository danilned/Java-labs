public class N7 {

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
    secondsSinceMidnight = hour * 3600 + minute * 60 + second;
  }

  public void setHour(int hour) {
    if (hour < 0 || hour >= 24) {
      throw new IllegalArgumentException("hour must be 0-23");
    }
    secondsSinceMidnight =
      secondsSinceMidnight % 86400 - getHour() * 3600 + hour * 3600;
  }

  public void setMinute(int minute) {
    if (minute < 0 || minute >= 60) {
      throw new IllegalArgumentException("minute must be 0-59");
    }
    secondsSinceMidnight =
      secondsSinceMidnight - getMinute() * 60 + minute * 60;
  }

  public void setSecond(int second) {
    if (second < 0 || second >= 60) {
      throw new IllegalArgumentException("second must be 0-59");
    }
    secondsSinceMidnight = secondsSinceMidnight - getSecond() + second;
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

  @Override
  public String toString() {
    return String.format(
      "%d:%02d:%02d %s",
      ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
      getMinute(),
      getSecond(),
      (getHour() < 12 ? "AM" : "PM")
    );
  }

  public void tick() {
    secondsSinceMidnight = (secondsSinceMidnight + 1) % 86400;
  }

  public void incrementMinute() {
    secondsSinceMidnight = (secondsSinceMidnight + 60) % 86400;
    if (getSecond() > 0) {
      secondsSinceMidnight -= getSecond();
    }
  }

  public void incrementHour() {
    secondsSinceMidnight = (secondsSinceMidnight + 3600) % 86400;
    if (getMinute() > 0 || getSecond() > 0) {
      secondsSinceMidnight -= getMinute() * 60 + getSecond();
    }
  }
}
