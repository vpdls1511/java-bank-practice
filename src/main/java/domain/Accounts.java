package domain;

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

  public Account get(int i) {
    return accounts[i];
  }

  public Account get(String accountNumber) {
    for(Account account: accounts) {
      if (accountNumber.equals(account.getAccountNumber())) {
        return account;
      }
    }

    return null;
  }
}
