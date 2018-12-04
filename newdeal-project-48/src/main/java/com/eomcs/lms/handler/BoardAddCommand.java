package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardAddCommand implements Command {

  Scanner keyboard;
  List<Board> list;
  BoardDao boardDao;

  public BoardAddCommand(Scanner keyboard, BoardDao boardDao) {

    this.keyboard = keyboard;
    this.boardDao = boardDao;

  }

  public void execute() {

    try {

      Board board = new Board();
      
      System.out.print("내용? ");
      board.setContents(keyboard.nextLine());

      System.out.print("작성자번호? ");
      board.setWriterNo(Integer.parseInt(keyboard.nextLine()));

      System.out.println("수업번호? ");
      board.setLessonNo(Integer.parseInt(keyboard.nextLine()));

      System.out.println("입력했습니다!");
      
      boardDao.insert(board);

    } catch (Exception e) {
      e.printStackTrace();

    }
  }

}
