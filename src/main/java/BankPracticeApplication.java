import io.Input;
import ui.Menu;
import ui.MenuItem;

public class BankPracticeApplication {

  public static void main(String[] args) {
    System.out.println("===============");
    System.out.println("은행 계좌 프로그램");
    System.out.println("===============");
    boolean isRun = true;
    while(isRun) {
      Menu.render();
      int code = Input.readInt();

      switch (MenuItem.fromCode(code)) {
        case CREATE_ACCOUNT -> Menu.createAccount();
        case DEPOSIT -> {
          Menu.inputAccount();
          String accountNumber = Input.readString();
          Menu.deposit(accountNumber);
        }
        case WITHDRAW -> {
          Menu.inputAccount();
          String accountNumber = Input.readString();
          Menu.withdraw(accountNumber);
        }
        case SHOW_ACCOUNT -> Menu.showAccounts();
        case EXIT_PROGRAM -> isRun = false;
        default -> Menu.retry();
      }
    }
  }
}
