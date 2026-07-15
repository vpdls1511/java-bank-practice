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

  public String getName() {
    return this.name;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public BigDecimal getMoney() {
    return this.money;
  }

  public String toString() {
    return "이름 : " + this.name
            + "\n계좌번호 : " + this.accountNumber
            + "\n잔액 : " + this.money.toString();
  }

  private String generateAccountNumber() {
    return String.valueOf(System.currentTimeMillis() % 1000000);
  }
}
