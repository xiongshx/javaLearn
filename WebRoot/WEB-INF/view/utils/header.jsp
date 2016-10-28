<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <nav class="navbar navbar-default" role="navigation">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand">导航</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">待定</a></li>
	        <li><a href="#">待定</a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown">直播网站导航 <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="https://www.douyu.com/">斗鱼</a></li>
	            <li><a href="http://www.longzhu.com/">龙珠</a></li>
	            <li><a href="http://www.huya.com/">虎牙</a></li>
	            <li class="divider"></li>
	            <li><a href="#">Separated link</a></li>
	            <li class="divider"></li>
	            <li><a href="#">One more separated link</a></li>
	          </ul>
	        </li>
	      </ul>
	      <form class="navbar-form navbar-left" role="search">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Search">
	        </div>
	        <button type="submit" class="btn btn-default">提交</button>
	      </form>
	      <ul class="nav navbar-nav navbar-right">
	      	<li><span class="glyphicon glyphicon-user" style = "font-size:25px;padding-top:8px;"></span></li>
	      	
	        <li><a href="ss/welcome">登录</a></li>
	        <li style = "font-size:25px;padding-top:3px;">|</li>
	        <li><a href="">注册</a></li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
  </body>
</html>
