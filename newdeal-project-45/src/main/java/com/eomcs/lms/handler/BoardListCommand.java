package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {
  
  Scanner keyboard;
  List<Board> list;
  
  public BoardListCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void execute() {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      // mariadb jdbc 드라이버 구현체를 로딩
     DriverManager.registerDriver(new Driver());
     
     //DBMS에 연결하기
     con = DriverManager.getConnection(
         "jdbc:mariadb://localhost:3306/studydb",
         "study", "1111");
     
     //SQL 전송을 담당할 객체를 준비
     stmt = con.createStatement();
     
     //SQL을 서버에 전송 => 서버에서 결고를 가져올 일을 할 객체를 리턴
     rs = stmt.executeQuery(
         "select bno, cont, cdt, view from board");
     
     // dbms에서 1개의 레코드를 가져온다.
      while (rs.next()) {
        System.out.printf("%3d, %-20s, %s, %d\n", 
            rs.getInt("bno"), 
            rs.getString("cont"),
            rs.getDate("cdt"),
            rs.getInt("view"));
      }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
      
    }
  }
}
