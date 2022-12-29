<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateCon" method="post">
<table>
	<tr>
		<td>ID : </td>
		<td><input type="text" name="id" value="${loginVO.id }" readonly></td>
	</tr>
	<tr>
		<td>PW : </td>
		<td><input type="text" name="pw"></td>
	</tr>
	<tr>
		<td>NICK : </td>
		<td><input type="text" name="nick" value="${loginVO.nick }"></td>
	</tr>
	<tr>
		<td align="right" colspan="2"><input type="submit" value="수정"> </td>
	</tr>
</table>

</form>
</body>
</html>