package utils.ui;

public class Log {

  public static void stopProcess() {
    System.out.print("\n다시 시도해주세요\n");
  }

  public static void retry(Exception e) {
    System.out.println(e.getMessage());
  }
}
