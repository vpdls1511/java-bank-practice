package utils.ui;

public class Log {

  public static void stopProcess() {
    System.out.print("\n재시도 횟수를 모두 사용했습니다. 처음부터 다시 진행해 주세요.\n");
  }

  public static void retry(Exception e) {
    System.out.println(e.getMessage());
  }
}
