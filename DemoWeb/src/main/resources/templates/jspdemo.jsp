<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP - Demo</title>
</head>
<body>
	<%@ page import="tw.com.skl.demo.model.service.DemoService"%>
	<%@ page import="tw.com.skl.demo.model.service.impl.DemoServiceImpl"%>
	<%@ page import="tw.com.skl.demo.model.entity.Demo"%>
	<%
	DemoService demoService = new DemoServiceImpl();
	Demo usr = demoService.selectById("EU3218");
	String name = request.getParameter("name");
	String account = request.getParameter("account");
	request.setAttribute("usr", usr);
	%>
	<h1>JSP - Demo</h1>
	<table border="1">
		<tr>
			<td>員編</td>
			<td><%=usr.getAccount()%></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><%=usr.getName()%></td>
		</tr>
	</table>
</body>
</html>