package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
      
      Scanner keyIn = new Scanner(System.in);
      
      System.out.print("번호 ? ");
      int no = Integer.parseInt(keyIn.nextLine());

      System.out.print("내용 ? ");
      String contents = keyIn.nextLine();
      
      int count = 0;
      Date registeredDate = new Date(System.currentTimeMillis()); 
      
      keyIn.close();
      
      System.out.println("번호: " + no);
      System.out.printf("이름 : %s\n", contents);
      System.out.printf("조회수 : %s\n", count);
      System.out.printf("가입일 : %s\n", registeredDate);
      
    }
}
