package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class AccountsTest {

  private final Accounts accounts = new Accounts();
  private final Account existAccount = new Account("그린");

  @Test
  void addAccount() {
    String name = "Green";
    Account account = new Account(name);

    accounts.add(account);

    assertTrue(accounts.size() > 0);
  }

  @Test
  void getAccount() throws IndexOutOfBoundsException {
    String name = "Green";
    Account account = new Account(name);

    accounts.add(account);
    Account getAccount = accounts.get(0);

    assertEquals(getAccount, account);
    assertNotNull(getAccount.getAccountNumber());
  }

  @Test
  void getAccountByNumber() {
    Account account = new Account("Green");

    accounts.add(account);

    assertEquals(account, accounts.get(account.getAccountNumber()));
  }

  @Test
  void overGetAccount() throws IndexOutOfBoundsException {
    String name = "Green";
    Account account = new Account(name);

    accounts.add(account);

    assertThrows(IndexOutOfBoundsException.class,
                 () -> accounts.get(1));

    assertThrows(IndexOutOfBoundsException.class,
                 () -> accounts.get(-1));
  }

  @Test
  void getAccountByNumberNotFound() {
    assertThrows(NoSuchElementException.class,
                 () -> accounts.get("000000"));
  }

  @Test
  void canGetAccount() {
    accounts.add(existAccount);

    String accountNumber = existAccount.getAccountNumber();
    Account account = accounts.get(accountNumber);

    assertEquals(existAccount.getName(), account.getName());
  }

  @Test
  void canGetAccountDeposit() {
    accounts.add(existAccount);

    String accountNumber = existAccount.getAccountNumber();
    Account account = accounts.get(accountNumber);

    account.deposit(1000L);

    assertEquals(BigDecimal.valueOf(1000), existAccount.getMoney());
  }

}
