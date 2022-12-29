<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 12.복붙 ->  src/main/java 폴더에 contnroller 패키지 만들기 
	-> contnroller 패키지에 JoinCon.selvlet만들기-->
	<form action="JoinCon" method="post">
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
				<td>NAME :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="회원가입"></td>
			</tr>
		</table>

	</form>

</body>
</html>