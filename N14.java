public class N14 {

  public static int product(int... numbers) {
    int product = 1;
    for (int num : numbers) {
      product *= num;
    }
    return product;
  }

  public static void main(String[] args) {
    System.out.println("Product of 1, 2, 3: " + product(1, 2, 3));
    System.out.println("Product of 4, 7: " + product(4, 7));
    System.out.println("Product of 2, 2, 2, 2: " + product(2, 2, 2, 2));
    System.out.println("Product of 5: " + product(5));
    System.out.println("Product with no arguments: " + product());
  }
}
