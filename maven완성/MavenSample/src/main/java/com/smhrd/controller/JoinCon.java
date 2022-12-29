package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.DAO;
import com.smhrd.model.VO;

// URL 매핑값이 없음(다른방법으로 매핑가능) - webapp-web.xml
public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		
		// System.out.println(id+" , "+pw+" , "+nick);
		VO vo = new VO(id,pw,nick);
		
		DAO dao = new DAO();
		int cnt = dao.join(vo);
		
		System.out.println(cnt);
		
		if (cnt > 0) { // 회원가입 성공
			System.out.println("회원가입 성공");
			// response.sendRedirect("main.jsp");
			// 리다이렉팅, 쿼리스트링
			//response.sendRedirect("main.jsp?result=success");
			
			// 포워딩방식
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			request.setAttribute("result", "success");
			rd.forward(request, response);
		} else { // 회원가입 실패
			System.out.println("회원가입 실패");
			// response.sendRedirect("main.jsp");
//			response.sendRedirect("main.jsp?result=fail");
			
			// 포워딩방식
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			request.setAttribute("result", "fail");
			rd.forward(request, response);
		}
	}

}
