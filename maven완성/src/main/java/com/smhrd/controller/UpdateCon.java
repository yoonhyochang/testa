package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.DAO;
import com.smhrd.model.VO;


public class UpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		
		VO vo = new VO(id,pw,nick);
		
		DAO dao = new DAO();
		int cnt = dao.update(vo);
		
		VO new_vo = new VO(id,pw,nick);
		
		if (cnt > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", new_vo);
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("update.jsp");
		}
	}

}
