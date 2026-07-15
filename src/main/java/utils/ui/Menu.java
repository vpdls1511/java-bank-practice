package utils.ui;

import domain.Account;

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
    System.out.print("이름을 입력해 주세요. : ");
  }

  public static void createAccountComplete(Account account) {
    System.out.println("생성이 완료되었습니다.");
    System.out.println(account.toString());
  }

  public static void inputAccount() {
    System.out.print("계좌번호를 입력해주세요 : ");
  }

  public static void deposit() {
    System.out.print("입금하실 금액을 입력 해 주세요 : ");
  }

  public static void depositComplete() {
    System.out.println("입금이 완료되었습니다.");
  }

  public static void withdraw() {
    System.out.print("출금하실 금액을 입력 해 주세요 : ");
  }

  public static void withdrawComplete() {
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
