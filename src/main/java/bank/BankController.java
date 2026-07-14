package bank;

import utils.io.Input;
import utils.ui.Menu;
import utils.ui.MenuItem;

public class BankController {

  public void run() {
    System.out.println("===============");
    System.out.println("은행 계좌 프로그램");
    System.out.println("===============");
    boolean isRun = true;
    while(isRun) {
      Menu.render();
      int code = Input.readInt();
      MenuItem selectMenu = MenuItem.fromCode(code);

      if(selectMenu == null) {
        Menu.retry();
        continue;
      }

      switch (selectMenu) {
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
        case EXIT_PROGRAM -> {
          Menu.exitProgram();
          isRun = false;
        }
      }
    }
  }
}
