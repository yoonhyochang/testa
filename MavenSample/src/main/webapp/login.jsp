<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<!-- 42 . 로그인 폼 완성 -> controller 패키지에 loginCon 
		서블릿 만들기 (web.xml에 만들어진거 확인가능)-->
		
		<form action="LoginCon" method="post">
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>PW :</td>
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="로그인"></td>
			</tr>
		</table>

	</form>

</body>
</html>