package com.eomcs.lms.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

@Component("/board/detail")
public class BoardDetailController implements PageController {

  BoardDao boardDao;
  
  public BoardDetailController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @Override
  public String execute(
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
    try {
      int no = Integer.parseInt(request.getParameter("no"));
      Board board = boardDao.findByNo(no);
      request.setAttribute("board", board);
      
      response.setContentType("text/html;charset=UTF-8");
      /*
      RequestDispatcher rd = request.getRequestDispatcher(
          "/board/detail.jsp");
      rd.include(request, response);
    */
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
    return "/board/detail.jsp";
  }
}




