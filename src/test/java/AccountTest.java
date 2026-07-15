import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.Account;
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
}
