import java.sql.Date;
import java.util.Scanner;

public class BoardHandler {

  // 이 클래스는 키보드 객체가 있어야 한다.
  // 따라서 이 클래스의 메서드를 사용하기 전에 반드시 키보드
  // 객체를 꼽아줘야 한다. 
  static Scanner keyboard;
  static final int LENGTH = 10;
  
  static Board[] boards = new Board[LENGTH];
  static int boardIdx = 0;
  
  public static void listBoard() {
    for (int j = 0; j < boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boards[j].no, boards[j].contents, boards[j].createdDate, boards[j].viewCount);
    }
  }
  
  public static void addBoard() {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.no = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("내용? ");
    board.contents = keyboard.nextLine();
    
    board.createdDate = new Date(System.currentTimeMillis()); 
    
    board.viewCount = 0;
    
    boards[boardIdx] = board;
    boardIdx++;
    
    System.out.println("저장하였습니다.");
  }
  

}
