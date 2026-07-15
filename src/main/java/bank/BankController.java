package bank;

import domain.Account;
import utils.io.Input;
import utils.ui.Menu;
import utils.ui.MenuItem;

public class BankController {

  private boolean isRun = true;
  private final BankService bankService = new BankService();

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
    String name = Input.readString();
    Account account = bankService.createAccount(name);
    Menu.createAccountComplete(account);
  }

  private void deposit() {
    Menu.inputAccount();
    String accountNumber = Input.readString();
    Menu.deposit();
    long money = (long) Input.readInt();
    bankService.deposit(accountNumber, money);
    Menu.depositComplete();
  }

  private void withdraw() {
    Menu.inputAccount();
    String accountNumber = Input.readString();
    Menu.withdraw();
    long money = (long) Input.readInt();
    bankService.withdraw(accountNumber, money);
    Menu.withdrawComplete();
  }

  private void exitProgram() {
    Menu.exitProgram();
    isRun = false;
  }

}
