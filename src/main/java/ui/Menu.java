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
}
