package com.smhrd.controller;

import java.io.IOException;
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

		
		//	42.post 방식이여서 인코딩 필요	-> VO
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
				//43 VO 에서 빨간줄 뜨면 오른쪽클릭해서 vo(str,str create하기)	
		VO vo = new VO(id, pw);
		
		DAO dao = new DAO();
		String name = dao.login(vo);
		// 세션객체 사용해서 main.jsp 만들어보기!!
		System.out.println("......??");
		if(name != null) {//로그인 성공
			
			//44.서블릿에서는 세션객체 생성
			System.out.println("로그인 성공");
			HttpSession session =request.getSession();
			session.setAttribute("name", name);
			response.sendRedirect("main.jsp");
			
		}else {//45.로그인 실패 -> main
			System.out.println("로그인 실패");
			response.sendRedirect("main.jsp");
			
		}
		
		
		
		
	}

}
