<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<table border="1"> 
 <caption><h2>部门管理</h2></caption>
 <tr>
  <th>编号</th>
  <th>部门名称</th>
  <th>部门地址</th>
  <th>编辑</th>
  <th>删除</th>
 </tr>
 
<c:forEach items="${depts}" var="d" varStatus="num">
 <tr>
   <td>${num.index+1}</td>
   <td>${d.dname}</td>
   <td>${d.loc}</td>
   <td><button onclick="location.href='findOne?d.deptno=${d.deptno}'">编辑</button></td>
   <td><button onclick="location.href='delete?d.deptno=${d.deptno}'">删除</button></td>
 </tr>
 </c:forEach>
 <button onclick="location.href='addDept.jsp'">添加部门</button>
</table>
</body>
</html>