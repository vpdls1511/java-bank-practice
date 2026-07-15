package bank;

import domain.Account;
import domain.Accounts;

public class BankService {

  private Accounts accounts = new Accounts();

  public Account createAccount(String name) {
    Account account = new Account(name);
    accounts.add(account);

    return account;
  }

  public void deposit(String accountNumber) {

  }
}
