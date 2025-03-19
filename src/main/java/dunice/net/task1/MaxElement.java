package dunice.net.task1;

import java.util.List;

public class MaxElement {

  public static int findMax(List<Integer> numbers) {
    int max = numbers.getFirst();
    for (int number : numbers) {
      if (number > max) {
        max = number;
      }
    }
    return max;
  }

  public static void main(String[] args) {

  }
}
