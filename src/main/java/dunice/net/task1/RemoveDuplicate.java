package dunice.net.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicate {

  public static List<Integer> removeDuplicates(List<Integer> numbers) {
    Set<Integer> unique = new LinkedHashSet<>(numbers);
    return new ArrayList<>(unique);
  }

  public static void main(String[] args) {

    List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 1);
    List<Integer> uniqueNumbers = removeDuplicates(numbers);

    System.out.println(uniqueNumbers);
  }
}
