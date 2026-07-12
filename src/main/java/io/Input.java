package io;

import java.util.Scanner;

public class Input {

  private static final Scanner scanner = new Scanner(System.in);

  public static String readString() {
    return scanner.nextLine();
  }

}
