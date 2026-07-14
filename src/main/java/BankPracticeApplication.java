import io.Input;
import ui.Menu;

public class BankPracticeApplication {

  public static void main(String[] args) {
    System.out.println("===============");
    System.out.println("은행 계좌 프로그램");
    System.out.println("===============");

    while(true) {
    boolean isRun = true;
    while(isRun) {
      Menu.render();
      int code = Input.readInt();
    }
  }
}
