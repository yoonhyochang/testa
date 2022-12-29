<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
					<!-- 40.EL 문법 문시하겠다  isELIgnored="false" -> login.jsp -->
	<!-- 38. 복붙 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	// getParameter -> url파라미터(get) / 패킷파라미터(post)
	
	
	//33일때 사용 성공여부확인할때
	// String result = request.getParameter("result");

	
	//35.
	// request 영역
	String result = (String) request.getAttribute("result");
	
	//33일때 사용 성공여부확인할때 
	// out.print(result);
	%>
							<!-- 11. 회원가입,로그인 버튼 만들기 -->
	<a href="join.jsp"><button>회원가입</button></a>

	<%
	//36.-> pom.xml
	if (result != null) {
		if (result.equals("success")) {
			out.print("<h3>회원가입에 성공했습니다~</h3>");
		} else {
			out.print("<h3>회원가입에 실패했습니다~</h3>");
		}
	}
	%>
	<!--39.  -->
	<!-- JSTL -->
	<c:if test="${!empty result}">
		<!-- if~else문 -->
		<c:choose>
			<c:when test="${result eq 'success'}">
				<h3>회원가입에 성공했습니다!</h3>
			</c:when>
			<c:otherwise>
				<h3>회원가입에 실패했습니다!</h3>
			</c:otherwise>
		</c:choose>
	</c:if>
						<!-- 11. 회원가입,로그인 버튼 만들기 ->webapp에 join.jsp만들기 -->
	<a href="login.jsp"><button>로그인</button></a>
	
	<%
	/* 47 ->   */ 
		String name = (String)session.getAttribute("name");
		if(name == null){
			out.print("<P>로그인해주세요</p>");
		}else{
			out.print("<P>"+ name +"님 환영합니다 </p>");
		}
	%>


</body>
</html>