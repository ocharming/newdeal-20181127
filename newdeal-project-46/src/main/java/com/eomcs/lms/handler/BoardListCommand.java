package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {
  
  Scanner keyboard;
  List<Board> list;
  BoardDao boardDao;
  
  public BoardListCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }
  
  public void execute() {
    
    try {

      BoardDao boardDao = new BoardDao();
      List<Board> list = boardDao.findAll();
      // dbms에서 1개의 레코드를 가져온다.
      for (Board board : list) {
        System.out.printf("%3d, %-20s, %s, %d\n", 
        board.getNo(),
        board.getContents(),
        board.getCreatedDate(),
        board.getViewCount());
      
      }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
//      try {rs.close();} catch (Exception e) {}
//      try {stmt.close();} catch (Exception e) {}
//      try {con.close();} catch (Exception e) {}
      
    }
  }
}
