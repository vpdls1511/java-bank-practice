package domain;

import java.math.BigDecimal;

public class Account {
  private final String name;
  private String accountNumber;
  private BigDecimal money;

  public Account(String name) {
    this.name = name;
    this.accountNumber = generateAccountNumber();
    this.money = BigDecimal.ZERO;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  private String generateAccountNumber() {
    return String.valueOf(System.currentTimeMillis() % 1000000);
  }
}
