package bank;

import domain.Account;
import domain.Accounts;
import java.util.NoSuchElementException;

public class BankService {

  private final Accounts accounts = new Accounts();

  public Account createAccount(String name) {
    Account account = new Account(name);
    accounts.add(account);

    return account;
  }

  public void deposit(String accountNumber, long money) {
    Account account = accounts.get(accountNumber);
    account.deposit(money);
  }


  public void withdraw(String accountNumber, long money) {
    Account account = accounts.get(accountNumber);
    account.withdraw(money);
  }
}
