package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.DAO;
import com.smhrd.model.VO;

public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//13. 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//14. 값받기-> src/main 폴더에 model 패키지 만들기->vo클래스 만들기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		// System.out.println(id + ", " + pw + ", " + name);
		//18. 만든후 임폴트
		VO vo = new VO(id, pw, name);
		
		//32.DAO import 가능해짐 
		//19. ->model패키지안에 DAO 클래스 생성
		DAO dao = new DAO();
		
		
		
		int cnt = dao.join(vo);
		//32 if문작성
		// System.out.println(cnt);
		if(cnt > 0) { // 회원가입 성공
			System.out.println("회원가입 성공!");
			// 리다이렉팅, 쿼리스트링
			
			//32 ->main.jsp로 이동 
			// response.sendRedirect("main.jsp?result=success"); 32일떄 만듬 ->34 데이터가 노출위험이있어 사용않함
			
			//33.
			//노출위험 상대적으로 적음(한번전송이여서)
			// 포워딩방식
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			request.setAttribute("result", "success");
			rd.forward(request, response);
			
		}else { // 회원가입 실패
			System.out.println("회원가입 실패!");
			
			
			// response.sendRedirect("main.jsp?result=fail");32일떄 만듬
			
			
			//34.33 복붙 단 success를 fail로 수정 -> main
			// 포워딩방식
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			request.setAttribute("result", "fail");
			rd.forward(request, response);
		}
		
	
	}

}
