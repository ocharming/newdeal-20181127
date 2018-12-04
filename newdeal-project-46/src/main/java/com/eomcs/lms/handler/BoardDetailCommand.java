package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import org.mariadb.jdbc.Driver;

import com.eomcs.lms.domain.Board;

public class BoardDetailCommand implements Command {
  
  Scanner keyboard;
  
  public BoardDetailCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void execute() {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
      // mariadb jdbc 드라이버 구현체를 로딩
//     DriverManager.registerDriver(new Driver());
     
     //DBMS에 연결하기
     con = DriverManager.getConnection(
         "jdbc:mariadb://localhost:3306/studydb",
         "study", "1111");
     
     stmt = con.createStatement();
     
     rs = stmt.executeQuery("select bno,cont, cdt, view, mno, lno "
     		+ " from board"
    		+ " where bno=" + no);
     
       if(rs.next()) {
        System.out.printf("번호: %d\n",rs.getInt("bno")); 
        System.out.printf("내용: %s\n",rs.getString("cont"));
        System.out.printf("작성일: %s\n",rs.getDate("cdt"));
        System.out.printf("조회수: %d\n",rs.getInt("view"));
        System.out.printf("작성자: %d\n",rs.getInt("mno"));
        System.out.printf("수업: %d\n",rs.getInt("lno"));
        
      }
    } catch (Exception e) {
    	e.printStackTrace();
    } finally {
      try{rs.close();} catch(Exception e) {}
      try{stmt.close();} catch(Exception e) {}
      try{con.close();} catch(Exception e) {}
    }
  }
}

    
    
 