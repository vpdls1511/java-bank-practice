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
    if(accounts.size() <= 0) {
      throw new NoSuchElementException("계좌 목록이 비어있습니다.");
    }

    Account account = accounts.get(accountNumber);
    account.deposit(money);
  }


  public void withdraw(String accountNumber, long money) {
    if(accounts.size() <= 0) {
      throw new NoSuchElementException("계좌 목록이 비어있습니다.");
    }

    Account account = accounts.get(accountNumber);
    account.withdraw(money);
  }
}
