<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'footer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	*{margin:0px; padding:0px;} /*这行是为了清除代码默认的样式，不用拷贝*/
	.botCenter{width:100%; height:35px; line-height:35px; position:fixed; bottom:0px; left:0px; font-size:14px; color:#000; text-align:center;}
	</style>
	
  </head>
  
  <body>
     	<h5 class = "botCenter">©2016 版本所有 盗版必究</h5>
  </body>
</html>
