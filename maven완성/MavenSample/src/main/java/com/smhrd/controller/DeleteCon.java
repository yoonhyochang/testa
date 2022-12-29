package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
   
import com.smhrd.model.DAO;
import com.smhrd.model.VO;

public class DeleteCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		VO vo = (VO)session.getAttribute("loginVO");
		String id = vo.getId();
		
		DAO dao = new DAO();
		int cnt = dao.delete(id);
		
		if (cnt > 0) {

			session.removeAttribute("loginVO");
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("main.jsp");
		}
	}

}
