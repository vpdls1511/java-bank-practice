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

  /**
   * 입금
   */
  public void deposit(long money) {
    deposit(BigDecimal.valueOf(money));
  }

  public void deposit(String money) {
    deposit(new BigDecimal(money));
  }

  public void deposit(BigDecimal money) {
    this.money = this.money.add(money);
  }

  /**
   * 출금
   */
  public void withdrawn(long money) {
    this.withdrawn(BigDecimal.valueOf(money));
  }

  public void withdrawn(BigDecimal money) {
    if (this.money.compareTo(money) < 0) {
      throw new ArithmeticException("출금 한도가 부족합니다.");
    }
    this.money = this.money.subtract(money);
  }

  @Override
  public String toString() {
    return "이름 : " + this.name
            + "\n계좌번호 : " + this.accountNumber
            + "\n잔액 : " + this.money.toString();
  }

  private String generateAccountNumber() {
    return String.valueOf(System.currentTimeMillis() % 1000000);
  }
}
