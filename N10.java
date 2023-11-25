public enum N10 {
  RED(30),
  GREEN(45),
  YELLOW(5);

  private final int duration;

  N10(int duration) {
    this.duration = duration;
  }

  public int getDuration() {
    return duration;
  }

  public class TrafficLightTest {

    public static void main(String[] args) {
      for (N10 light : N10.values()) {
        System.out.printf("%s: %d seconds\n", light, light.getDuration());
      }
    }
  }
}
