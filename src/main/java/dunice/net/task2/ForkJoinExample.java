package dunice.net.task2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class ForkJoinExample {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ForkJoinPool forkJoinPool = new ForkJoinPool();

    CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
      return Stream.iterate(1, n -> n + 1)
          .limit(10)
          .parallel()
          .mapToInt(Integer::intValue)
          .sum();
    }, forkJoinPool);

    CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
      return Stream.iterate(11, n -> n + 1)
          .limit(10)
          .parallel()
          .mapToInt(Integer::intValue)
          .sum();
    }, forkJoinPool);

    CompletableFuture<Integer> finalResult = task1.thenCombineAsync(task2, Integer::sum, forkJoinPool);

    System.out.println("Итоговая сумма: " + finalResult.get());

    forkJoinPool.shutdown();
  }

}
