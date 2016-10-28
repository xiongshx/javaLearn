<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%-- <%@page import="com.jspsmart.upload.*" %>   

<%
	//新建一个SmartUpload对象
	SmartUpload su = new SmartUpload();

	//上传初始化
	su.initialize(pageContext);

	// 设定上传限制
	//1.限制每个上传文件的最大长度。
	su.setMaxFileSize(10000000);

	//2.限制总上传数据的长度。
	su.setTotalMaxFileSize(20000000);

	//3.设定允许上传的文件（通过扩展名限制）,仅允许doc,txt文件。
	su.setAllowedFilesList("doc,txt,jpg,rar,mid,waw,mp3,gif");
	
	boolean sign = true;
	
	//4.设定禁止上传的文件（通过扩展名限制）,禁止上传带有exe,bat,jsp,htm,html扩展名的文件和没有扩展名的文件。
	try {
		su.setDeniedFilesList("exe,bat,jsp,htm,html");

		//上传文件
		su.upload();
		//将上传文件保存到指定目录
		String imgPath = request.getSession().getServletContext()
					.getRealPath("/WEB-INF/upload/");
		su.save(imgPath);

	} catch (Exception e) {
		e.printStackTrace();
		sign = false;
	}
	if(sign==true)
	{
		out.println("<script>parent.callback('upload file success')</script>");
	}else
	{
		out.println("<script>parent.callback('upload file error')</script>");
	}
%> --%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="static/js/jquery-2.1.3.min.js"></script>
<title>无标题文档</title>
<script type="text/javascript">
	$(document).ready(function(){ 
		 //传递字符串格式json对象到后台（一个json对象）  
            $("#submit").click(function(){  
                var zhuBoName =$("#zhuBoName").val();  
				var zhuBoRealName = $("#zhuBoRealName").val();
				var gender = $("#gender").val();
				/*var birth =   */ //获取生日待做
				//var imgdir = $("#imgdir").val();
				//alert(imgdir);
				var zhuBoGroup = $("#zhuBoGroup").val();
				var url = $("#url").val();
				var keyWord = $("#keyWord").val();
				var introduce = $("#introduce").val();
				
                var user = {zhuBoName:zhuBoName,zhuBoRealName:zhuBoRealName,gender:gender,
                            zhuBoGroup:zhuBoGroup,url:url,keyWord:keyWord,
                            introduce:introduce}; 
                var aMenu  = encodeURI(JSON.stringify(user));  
      			alert(aMenu); 
                $.ajax({  
                     url:"ZhuBoController/addZhuBo" ,  
                     type : "POST",
                     data:"orderJson=" + aMenu,    
                     success:function(data){  
                    }  
                });  
            });
	});
	
	//表单提交新增失败后,返回回调函数,传回错误信息
	function uploadSucced(msg){
		$("#firstUploadSuccessdMsg").html(msg);
		$("#firstUploadFailed").show();
		$("#firstUploadFailed").hide();
	}
	
	//表单提交修改失败后,传回提示信息
	function uploadFailed(msg){
		$("#firstUploadSuccessdMsg").html(msg);
		$("#firstUploadFailed").show();
		$("#firstUploadFailed").hide();
	}
	
	function callback(msg)
	{
		document.getElementById("file").outerHTML = document.getElementById("file").outerHTML;
		document.getElementById("msg").innerHTML = "<font color=red>"+msg+"</font>";
	}
	
</script>
</head>

<body>
	<form id="form1" name="form1" method="post"
		action="">
		<p>主播姓名: <label for="zhuBoName"></label> <input type="text" name="zhuBoName" id="zhuBoName" /></p>
		<p>真实姓名: <label for="zhuBoRealName"></label> <input type="text" name="zhuBoRealName" id="zhuBoRealName" /></p>
		<p>主播性别: <label for="gender"></label> 
			<select name="gender" size="1" id="gender">
				   <option value="1">男</option>
			   	   <option value="2">女</option>
			</select>
		</p>
		<p>主播生日: <label for="birth"></label> <input type="text" name="birth" id="birth" /></p>
		<!-- <p>图片上传:<input type="file" name="file" id = "imgdir"/></p> -->
		<!-- <p>图片上传:<label for="imgdir"></label> <input type="file" name="imgdir" id="imgdir" /></p> -->
		<p>主播组别:<label for="zhuBoGroup"></label> 
			<select name="zhuBoGroup" size="1"
				id="zhuBoGroup">
				<option value="1">LOL</option>
				<option value="2">娱乐</option>
				<option value="3">户外</option>
				<option value="4">地下城</option>
				<option value="5">其他</option>
			</select>
		</p>
		<p>直播地址: <label for="url"></label> <input type="text" name="url" id="url" /></p>
		<p>关键字:&#12288<label for="keyWord"></label> <input type="text" name="keyWord" id="keyWord" /></p>
		<p> 主播介绍: <label for="introduce"></label><textarea name="introduce" id = "introduce" cols=40 rows=4 ></textarea></p>
		<p></p>
		<input name="button"  id = "submit" type="button"  value="提交" />
	</form>
	<!-- <div class="panel-body">
	    <form id ="firstUpdateForm" action="uploadController/upload" method="post"
	        enctype="multipart/form-data" class="form-horizontal" role="form" target="hidden_frame">
	        <div class="modal-body">
	            <div class="form-group">
	            <label class="col-sm-3 control-label">上传文件</label>
	            <div class="col-sm-5">
	                <input type="file" id="firstDemoImgFile" name="file">
	            </div>
	            </div>
	        </div>
	        <div class="modal-footer">
	            <div id="firstUploadSucceed" style="display: none;">
	                <strong>新增成功！</strong><span id="firstUploadSucceedMsg"></span>
	            </div>
	            <div id="firstUploadFailed" style="display: none;">
	                <strong>对不起！新增失败</strong><span id="firstUploadFailedMsg"></span>
	            </div>
	            <button id="createPeriadBtn" type="submit" class="btn btn-default">确定 </button>
	        </div>
	    </form> 
    <iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
	</div>  -->
	
<!--  	<form method="post" action="uploadController/upload" enctype="multipart/form-data">
     	<input type="file" name="file" id = "imgdir"/>
    	<input type="submit" />
	</form>  -->
<!-- 	<form action="" id="form1" name="form1" encType="multipart/form-data"  method="post" target="hidden_frame" >
		<input type="file" id="file" name="file" style="width:450">
		<INPUT type="submit" value="上传文件"><span id="msg"></span>
		<br>
		<font color="red">支持JPG,JPEG,GIF,BMP,SWF,RMVB,RM,AVI文件的上传</font>              
		<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
	</form> -->
</body>
</html>



<!-- <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>简单的Ajax请求</title>
<script type="text/javascript" src="static/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript">
	/* var xmlHttp; // 创建XMLHttpRequest对象   
	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}
	// 整合url参数   
	function createQueryString() {
		var name = document.getElementById("txtName").value;
		var sex = document.getElementById("txtSex").value;
		var birthday = document.getElementById("txtBirthday").value;
 		var queryString = "Name=" + encodeURIComponent(name) + "&Sex="
				+ encodeURIComponent(sex) + "&Birthday="
				+ encodeURIComponent(birthday); 
		 var data = {
             name: name,
             sex:sex
     }
		return data;
	}
	// 按照Get方式传递参数   
 	function doRequestUsingGET() {
		createXMLHttpRequest();
		var queryString = "AjaxServer.ashx?";
		queryString = queryString + createQueryString() + "&timeStamp="
				+ new Date().getTime();
		xmlHttp.onreadystatechange = handleStateChange;
		xmlHttp.open("GET", queryString, true);
		xmlHttp.send(null);
	} 
	// 按POST方式传递参数   
	function doRequestUsingPOST() {
		createXMLHttpRequest();
		var url = "addZhuBo";
		var queryString = createQueryString();
		xmlHttp.open("POST", url, true);
		xmlHttp.onreadystatechange = handleStateChange;
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;");
		alert(queryString);
		xmlHttp.send(queryString);
	}
	// 回调函数   
	function handleStateChange() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				parseResults();
			}
		}
	}
	// 处理服务器响应内容   
	function parseResults() {
		var responseDiv = document.getElementById("serverResponse");
		if (responseDiv.hasChildNodes()) {
			responseDiv.removeChild(responseDiv.childNodes[0]);
		}
		var responseText = document.createTextNode(xmlHttp.responseText);
		responseDiv.appendChild(responseText);
	} */
	
/* 	 var data = {
             txtName: txtName,
             txtSex:txtSex
     } */
	var data = {
             userAccount: lock_username,
             userPasswd:hex_md5(lock_password).toUpperCase()
     }

     $.ajax({
            url : ctx + "/unlock.do",
            type : "POST",
            data : data, //直接用JSON对象
            dataType: 'json',
            success : function(result) {
                console.log(result);
            }
     });
</script>
</head>
<body>
	<form action="#" id = "formID">
		<h2>输入你的名字,性别,生日：</h2>
		<table>
			<tr>
				<td>名字：</td>
				<td><input type="text" id="txtName" />
				</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="text" id="txtSex" />
				</td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input type="text" id="txtBirthday" />
				</td>
			</tr>
		</table>
		<input type="button" value="用Get方式传参数" onclick="doRequestUsingGET();" />
		<br /> <br /> <input type="button" value="用POST方式传参数"
			onclick="doRequestUsingPOST();" />
	</form>
	<br />
	<h3>服务器响应内容：</h3>
	<div id="serverResponse"></div>
</body>
</html>
 -->