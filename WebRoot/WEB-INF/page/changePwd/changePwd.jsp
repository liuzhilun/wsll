<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String userLoginName = request.getParameter("userLoginName");
%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Login Form</title>
<link rel="stylesheet" href="resources/css/loginStyle.css">
<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>
 <script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
<!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<script type="text/javascript">
 var userLoginName='<%=userLoginName%>';
 var username = '<%=session.getAttribute("username")%>';
	if (username == "" || username == null) {
		alert("非法访问，请登录！");
		window.location = "login.do";
	} else if (username != userLoginName) {
		window.location = "login.do";
		alert("非法访问，请登录！");
	}
</script>
</head>
<body>
	<section class="container">
		<div class="login">
			<h1>修改密码</h1>
			<form method="post" action="index.html">
				<p>
					<input type="password" id="oldPassword" value="" placeholder="原密码">
				</p>
				<p>
					<input type="password" value="" id="newPassword" placeholder="新密码">
				</p>
				<p>
					<input type="password" value="" id="confirmNewPassword"
						placeholder="确认新密码">
				</p>
				<p class="submit">
					<input type="button" id="commit" value="确定" onclick="checkLogin()" /><input
						type="button" id="chancel" value="取消" onclick="chancelChange()"/>
				</p>
			</form>
		</div>
	</section>
</body>
<script type="text/javascript">
	function check() {
		var newPassword = $("#newPassword").val();
		var confirmNewPassword = $("#confirmNewPassword").val();
		var oldPassword = $("#oldPassword").val();
		if (newPassword == "" || newPassword == "请输入密码") {
			alert("请输入新密码！");
			$("#newPassword").focus();
			return false;
		}
		if (confirmNewPassword == "" || confirmNewPassword == "请输入密码") {
			alert("请输入确认新密码!");
			$("#confirmNewPassword").focus();
			return false;
		}
		if (oldPassword == "" || oldPassword == "请输入密码") {
			alert("请输入旧密码!");
			$("#oldPassword").focus();
			return false;
		}
		if (confirmNewPassword != newPassword) {
			alert("两次输入密码不一致!");
			$("#newPassword").focus();
			return false;
		}
		if(newPassword.length<6){
		    alert("密码至少需要6位!");
			$("#newPassword").focus();
			return false;
		}
		return true;
	}
	function checkLogin() {
		if (check()) {

			var newPassword = $("#newPassword").val();
			var oldPassword = $("#oldPassword").val();
			$.ajax({
				url : 'changeUserPwd.do',
				data : {
					newPassword : newPassword,
					oldPassword : oldPassword,
					userLoginName : userLoginName
				},
				dataType : 'json',
				method : 'GET',
				success : function(data) {
					var json = eval(data);
					var result = json.info;
					//code 0:用户不存在！ 1：密码错误！ 2：修改成功！3：系统错误！
					if (result == "0") {
						alert("用户不存在!");
					}
					if (result == "1") {
						alert("密码错误!");
					}
					if (result == "2") {
						alert("修改成功,需要重新登陆!");
						$.cookie("rmbUser", "false", {
							expire : -1
						});
						$.cookie("username", "", {
							expires : -1
						});
						$.cookie("password", "", {
							expires : -1
						});
						window.location = "login.do";
					}
					if (result == "3") {
						alert("系统错误!");
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					//alert('查询数据错误,详细信息：[' + errorThrown + ']');
				}
			});
		}
	}
	function chancelChange(){
	window.location = "query.do?userLoginName="+encodeURI(userLoginName);
	}
</script>
</html>
