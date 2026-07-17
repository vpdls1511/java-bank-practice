package bank;

import domain.Account;
import java.util.NoSuchElementException;
import utils.io.Input;
import utils.ui.Log;
import utils.ui.Menu;
import utils.ui.MenuItem;

public class BankController {

  private boolean isRun = true;
  private final BankService bankService = new BankService();

  public void run() {
    while (isRun) {
      Menu.render();
      int code = Input.readInt();
      MenuItem selectMenu = MenuItem.fromCode(code);

      if (selectMenu == null) {
        Menu.retry();
        continue;
      }

      switch (selectMenu) {
        case CREATE_ACCOUNT -> this.createAccount();
        case DEPOSIT -> this.deposit();
        case WITHDRAW -> this.withdraw();
        case SHOW_ACCOUNT -> this.showAccounts();
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
    int retryCount = 0;

    while (true) {
      try {
        if (retryCount == 3) {
          Log.stopProcess();
          return;
        }

        Menu.inputAccount();
        String accountNumber = Input.readString();
        Menu.deposit();
        long money = Input.readInt();
        bankService.deposit(accountNumber, money);
        Menu.depositComplete();

        return;
      } catch (IllegalArgumentException | NoSuchElementException e) {
        retryCount++;
        Log.retry(e);
      }
    }
  }

  private void withdraw() {
    int retryCount = 0;

    while (true) {
      try {
        if (retryCount == 3) {
          Log.stopProcess();
          return;
        }

        Menu.inputAccount();
        String accountNumber = Input.readString();
        Menu.withdraw();
        long money = Input.readInt();
        bankService.withdraw(accountNumber, money);
        Menu.withdrawComplete();

        return;
      } catch (IllegalArgumentException | NoSuchElementException e) {
        retryCount++;
        Log.retry(e);
      }
    }

  }

  private void showAccounts() {
    Account[] accounts = bankService.getAllAccounts();
    Menu.showAccounts(accounts);
  }

  private void exitProgram() {
    Menu.exitProgram();
    isRun = false;
  }

}
