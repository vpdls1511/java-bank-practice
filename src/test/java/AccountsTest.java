import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.Account;
import domain.Accounts;
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
  void getAccount() {
    String name = "Green";
    Account account = new Account(name);

    accounts.add(account);
    Account getAccount = accounts.get(0);

    assertEquals(getAccount, account);
    assertNotNull(getAccount.getAccountNumber());
  }

}
