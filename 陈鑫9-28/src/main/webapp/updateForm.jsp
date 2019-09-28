<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<input type="hidden" name="d.deptno" value="${d.deptno }">
部门名称：<input name="d.dname" value="${d.dname }"/><br>
部门地址：<input name="d.loc" value="${d.loc }"/><br>
<button>提交</button>
</form>
</body>
</html>