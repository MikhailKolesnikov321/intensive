package dunice.net;

public class MyApp {

  /**
   * javac -d out src/main/java/dunice/net/MyApp.java <br/>
   *
   * jar cfe myapp.jar dunice.net.MyApp -C out . <br/>
   *
   * java -Xms512m -Xmx1024m -Xss2m -XX:+UseZGC -XX:+DoEscapeAnalysis -jar myapp.jar
   **/
  public static void main(String[] args) {
    System.out.println("Запуск Java-приложения...");

    long heapSize = Runtime.getRuntime().totalMemory();
    long maxHeapSize = Runtime.getRuntime().maxMemory();
    long freeHeapSize = Runtime.getRuntime().freeMemory();

    System.out.println("Размер кучи (Heap Size): " + heapSize / (1024 * 1024) + " MB");
    System.out.println("Максимальный размер кучи (Max Heap Size): " + maxHeapSize / (1024 * 1024) + " MB");
    System.out.println("Свободная память (Free Heap Size): " + freeHeapSize / (1024 * 1024) + " MB");

    System.out.println("Приложение завершено.");
  }
}