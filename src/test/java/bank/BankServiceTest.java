package bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Account;
import domain.Accounts;
import java.io.BufferedReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.rmi.NoSuchObjectException;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class BankServiceTest {
  private final Account account = new Account("그린");

  private final BankService bankService = new BankService();

  @Test
  void noSuchAccounts() {
    assertThrows(NoSuchElementException.class,
                 () -> bankService.deposit(account.getAccountNumber(), 1000L));
  }

  @Test
  void noSuchAccountNumber() {
    assertThrows(NoSuchElementException.class,
                 () -> bankService.deposit("10a0d0", 1000L));
  }

  @Test
  void canDepositMoney() {
    long money = 10000L;

    Account myAccount = bankService.createAccount("Green");
    bankService.deposit(myAccount.getAccountNumber(), money);

    assertEquals(BigDecimal.valueOf(money), myAccount.getMoney());
  }

  @Test
  void canWithdrawnMoney() {
    long money = 10000L;
    Account myAccount = bankService.createAccount("Green");

    bankService.deposit(myAccount.getAccountNumber(), money);
    bankService.withdrawn(myAccount.getAccountNumber(), money);

    assertEquals(BigDecimal.ZERO, account.getMoney());
  }

  @Test
  void canWithdrawnMoneyByArithmeticException() {
    long money = 10000L;
    Account myAccount = bankService.createAccount("Green");

    bankService.deposit(myAccount.getAccountNumber(), money);
    bankService.withdrawn(myAccount.getAccountNumber(), money);

    assertEquals(BigDecimal.ZERO, account.getMoney());
  }
}
