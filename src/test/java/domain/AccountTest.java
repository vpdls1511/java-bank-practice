package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class AccountTest {

  @Test
  void createAccount() {
    String name = "Green";
    Account account = new Account(name);

    assertEquals(name, account.getName());
    assertEquals(BigDecimal.ZERO, account.getMoney());
  }

  @Test
  void depositMoneyToString() {
    String money = "10000";
    String name = "Green";
    Account account = new Account(name);

    account.deposit(money);

    assertEquals(BigDecimal.valueOf(10000), account.getMoney());
  }

  @Test
  void depositMoneyToLong() {
    long  money = 10000L;
    String name = "Green";
    Account account = new Account(name);

    account.deposit(money);

    assertEquals(BigDecimal.valueOf(10000L), account.getMoney());
  }

  @Test
  void withdrawnMoney() {
    long  money = 10000L;
    String name = "Green";
    Account account = new Account(name);

    account.deposit(money);
    account.withdrawn(money);

    assertEquals(BigDecimal.valueOf(0L), account.getMoney());
  }

  @Test
  void withdrawnMoneyByIllegalArgumentException() {
    long  money = 10000L;
    String name = "Green";
    Account account = new Account(name);

    assertThrows(IllegalArgumentException.class,
                 () -> account.withdrawn(money));
  }
}
