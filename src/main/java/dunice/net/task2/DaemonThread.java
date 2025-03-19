package dunice.net.task2;

import java.util.Scanner;
import java.util.concurrent.Exchanger;

public class DaemonThread {
  public static void main(String[] args) {
    Exchanger<String> exchanger = new Exchanger<>();

    Thread daemonThread = new Thread(() -> {
      try {
        while (true) {
          String command = exchanger.exchange(null);
          if ("ПОДЪЕМ".equals(command)) {
            exchanger.exchange("ОТБОЙ");
          }
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    });

    daemonThread.setDaemon(true);
    daemonThread.start();

    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите 'ПОДЪЕМ', чтобы разблокировать демон-поток:");

    while (true) {
      String input = scanner.nextLine();
      if ("ПОДЪЕМ".equals(input)) {
        try {
          exchanger.exchange("ПОДЪЕМ");
          String response = exchanger.exchange(null);
          System.out.println(response);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
}
