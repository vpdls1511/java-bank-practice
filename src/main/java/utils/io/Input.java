package utils.io;

import java.util.Scanner;

public class Input {

  private static final Scanner scanner = new Scanner(System.in);

  public static String readString() {
    return scanner.nextLine();
  }

  public static int readInt() {
    while (true) {
      try {
        return Integer.parseInt(scanner.nextLine().trim());
      } catch (NumberFormatException exception) {
        System.out.println("숫자만 입력해주세요.");
      }
    }
  }

}
