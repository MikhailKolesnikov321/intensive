package dunice.net.task2;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentSet {
  public static void main(String[] args) throws InterruptedException {
    Set<String> threadNames = new ConcurrentSkipListSet<>();
    for (int i = 1; i <= 32; i++) {
      threadNames.add("Поток-" + i);
    }

    AtomicInteger counter = new AtomicInteger(0);

    ExecutorService executor = Executors.newFixedThreadPool(threadNames.size());
    CountDownLatch latch = new CountDownLatch(threadNames.size());

    for (String name : threadNames) {
      executor.execute(() -> {
        while (true) {
          counter.incrementAndGet();
          System.out.println("Работает " + name);

          if (threadNames.remove(name)) {
            System.out.println(name + " удаление выполнено");
          }

          if (threadNames.isEmpty()) {
            break;
          }

          Thread.yield();
        }
        latch.countDown();
      });
    }

    latch.await();
    executor.shutdown();

    System.out.println("Количество итераций потоков: " + counter.get());
  }
}
