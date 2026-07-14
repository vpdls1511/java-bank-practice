package ui;

public class Menu {

  public static void render() {
    System.out.println("=================");
    for (MenuItem item : MenuItem.values()) {
      System.out.printf("%s. %s \n",
                        item.getCode(), item.getLabel());
    }
    System.out.println("=================");
  }

  public static void createAccount() {
    System.out.println("아래 정보를 입력해 주세요.");
    System.out.print("이름 : ");

    // todo - 이름을 넘겨서 account 객체 생성

    System.out.println("생성이 완료되었습니다.");
  }

  public static void inputAccount() {
    System.out.print("계좌번호를 입력해주세요 : ");
  }

  public static void deposit(String accountNumber) {
    System.out.println("입금하실 금액을 입력 해 주세요.");
    System.out.print("금액 : ");

    // todo - 입금 금액 검증 및 계좌 찾아서 입금

    System.out.println("입금이 완료되었습니다.");
  }

  public static void withdraw(String accountNumber) {
    System.out.println("출금하실 금액을 입력 해 주세요.");
    System.out.print("금액 : ");

    // todo - 계좌 찾고, 출금 가능한지 검증

    System.out.println("출금이 완료되었습니다.");
  }

  public static void showAccounts() {
    System.out.println("보유하신 계좌 정보입니다.");

    // todo - 계좌 찾아서 정보 출력
  }

  public static void exitProgram() {
    System.out.println("프로그램을 종료합니다.");

    // todo - 시스템 종료
  }

  public static void retry() {
    System.out.println("다시 선택해주세요.");
  }
}
