package utils.ui;

public enum MenuItem {

  CREATE_ACCOUNT(1, "계좌 생성"),
  DEPOSIT(2, "입금"),
  WITHDRAW(3, "출금"),
  SHOW_ACCOUNT(4, "계좌 목록 조회"),
  EXIT_PROGRAM(99, "프로그램 종료"),
  ;

  private final int code;
  private final String label;

  MenuItem(int code, String label) {
    this.code = code;
    this.label = label;
  }

  public int getCode() {
    return this.code;
  }

  public String getLabel() {
    return this.label;
  }

  public static MenuItem fromCode(int code) {
    for (MenuItem item : MenuItem.values()) {
      if (item.code == code) {
        return item;
      }
    }

    return null;
  }
}
