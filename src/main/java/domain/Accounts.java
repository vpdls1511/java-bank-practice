package domain;

import java.util.NoSuchElementException;

public class Accounts {
  private Account[] accounts = {};

  public Accounts() {}

  public void add(Account account) {
    Account[] newAccounts = new Account[accounts.length + 1];

    for (int i = 0 ; i < accounts.length ; i++) {
      newAccounts[i] = accounts[i];
    }

    newAccounts[newAccounts.length - 1] = account;

    accounts = newAccounts;
  }

  public Account get(int i) throws IndexOutOfBoundsException {
    if (accounts.length - 1 < i || i < 0) throw new IndexOutOfBoundsException("조회를 할 수 없습니다.");
    return accounts[i];
  }

  public Account get(String accountNumber) {
    for(Account account: accounts) {
      if (accountNumber.equals(account.getAccountNumber())) {
        return account;
      }
    }

    throw new NoSuchElementException("계좌 정보를 조회하지 못했습니다.");
  }

  public int size() {
    return accounts.length;
  }

  public Account[] getAll() {
    return this.accounts;
  }
}
