package dunice.net.task1;

public class NumericString {

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= 100; i++) {
      sb.append(i);
      if (i < 100) {
        sb.append(", ");
      }
    }
    System.out.println(sb);
  }
}