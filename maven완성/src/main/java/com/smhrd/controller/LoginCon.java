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

public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		VO vo = new VO(id,pw);
		
		DAO dao = new DAO();
		String name = dao.login(vo);
		// VO loginVo = new VO(id, pw, nick);

		if (name!=null) { // 로그인 성공
			System.out.println("로그인성공");
			// 서블릿에서는 세션객체 생성
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			response.sendRedirect("main.jsp");
		} else { // 로그인 실패
			System.out.println("로그인실패");
			response.sendRedirect("main.jsp");
		}
	}

}
