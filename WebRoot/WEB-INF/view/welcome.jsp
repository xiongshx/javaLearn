<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="static/css/bootstrap.min.css"  type="text/css" />
	<link rel="stylesheet" href="static/css/bootstrap-theme.css"  type="text/css" />
	<script type="text/javascript" src="static/js/jquery-2.1.3.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body  padding-top="170px">
  	 <jsp:include   page="../view/utils/header.jsp" flush="true"/> 
  	 <div >
	  	 <c:forEach items="${userMap.userList}" var="user" varStatus="vs">  
	
	  	 	<div class="col">
		  		<div class="col-sm-5 col-md-3">
		    		<div class="thumbnail">
			      		<a href="https://www.douyu.com/625961">
			      			<img src="static/img/${user.imgDir}" alt="${user.zhuBoName}" />
			      		</a>
			      		<div class="caption">
			        		<h3>${user.zhuBoName}</h3>
			        		<p>${user.introduce}</p>
			      		</div>
		    		</div>
		  		</div>
			</div>
	  	</c:forEach>
  	</div>
<hr style="height:5px;border:none;border-top:5px ridge green;" />
<!--  	<div class="jumbotron">
	  <h1>Hello, world!</h1>
	  <p>点点点点点,啥玩意</p>
	  <p><a class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" role="button">Learn more</a></p>
	</div>
	-->
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">逗你玩</h4>
	      </div>
	      <div class="modal-body">
	        	呵呵哒
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
	<p></p>
	<jsp:include page="../view/utils/footer.jsp" flush="true"/> 
  </body>
</html>
