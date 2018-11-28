package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  

  public static void main(String[] args) {

    Date registeredDate = new Date(System.currentTimeMillis());

    final int DEFAULT_SIZE = 20;

    int[] no = new int[DEFAULT_SIZE];
    String[] name = new String[DEFAULT_SIZE];
    String[] email = new String[DEFAULT_SIZE];
    String[] pass = new String[DEFAULT_SIZE];
    String[] photo = new String[DEFAULT_SIZE];
    String[] tell = new String[DEFAULT_SIZE];
    
    int len = 0;

    Scanner keyIn = new Scanner(System.in);

    for(int i = 0; i < DEFAULT_SIZE; i++) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyIn.nextLine());

      System.out.print("name? ");
      name[i] = keyIn.nextLine();

      System.out.print("email? ");
      email[i] = keyIn.nextLine();

      System.out.print("pass? ");
      pass[i] = keyIn.nextLine();

      System.out.print("photo? ");
      photo[i] = keyIn.nextLine();

      System.out.print("tell? ");
      tell[i] = keyIn.nextLine();

      
      
      len++;

      System.out.print("계속하시겠습니까?(Y/n) ");
      String input = keyIn.nextLine();
      if(input.equals("") || input.equalsIgnoreCase("y")) {
        continue;
      }
      break;
    }
    keyIn.close();


    for (int i = 0; i < len; i++) {
      System.out.printf("%s, %s, %s, %s, %s\n ",
          no[i], name[i], email[i], tell[i], registeredDate);
      
    }

  }
}
