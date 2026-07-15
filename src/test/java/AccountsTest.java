import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.Account;
import domain.Accounts;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class AccountsTest {

  private Accounts accounts = new Accounts();

  @Test
  void addAccount() {
    String name = "Green";
    Account account = new Account(name);

    accounts.add(account);

    assertTrue(accounts.size() != 0);
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

}
