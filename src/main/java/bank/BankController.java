package bank;

import utils.io.Input;
import utils.ui.Menu;
import utils.ui.MenuItem;

public class BankController {

  private static boolean isRun = true;

  public void run() {
    while(isRun) {
      Menu.render();
      int code = Input.readInt();
      MenuItem selectMenu = MenuItem.fromCode(code);

      if(selectMenu == null) {
        Menu.retry();
        continue;
      }

      switch (selectMenu) {
        case CREATE_ACCOUNT -> this.createAccount();
        case DEPOSIT -> this.deposit();
        case WITHDRAW -> this.withdraw();
        case SHOW_ACCOUNT -> Menu.showAccounts();
        case EXIT_PROGRAM -> this.exitProgram();
      }
    }
  }

  private void createAccount() {
    Menu.createAccount();
  }

  private void deposit() {
    Menu.inputAccount();
    String accountNumber = Input.readString();
    Menu.deposit(accountNumber);
  }

  private void withdraw() {
    Menu.inputAccount();
    String accountNumber = Input.readString();
    Menu.withdraw(accountNumber);
  }

  private void exitProgram() {
    Menu.exitProgram();
    isRun = false;
  }

}
