<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
 <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
  <title>Login Form</title>
  <link rel="stylesheet" href="resources/css/loginStyle.css">
  <script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
  <section class="container">
    <div class="login">
      <h1>用户登录</h1>
      <form method="post" action="index.html">
        <p><input type="text" id="username" value="" placeholder="用户名"></p>
        <p><input type="password"  value="" id="password"  placeholder="密码"></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="ck_rmbUser" id="ck_rmbUser">
            记住密码
          </label>
        </p>
        <p class="submit"><input type="button" id="commit" value="登录" onclick="checkLogin()"/></p>
      </form>
    </div>

    <div class="login-help">
      <p>没有账号? <a href="toRegist.do">点击注册</a>.</p>
      <p>建议使用IE10,IE11及火狐，谷歌，360浏览器进行访问</p>
    </div>
  </section>
</body>
<script type="text/javascript">
$(document).ready(function(){ 
	if ($.cookie("rmbUser") == "true") { 
	$("#ck_rmbUser").prop("checked", true); 
	$("#username").val($.cookie("username")); 
	//$("#password").remove(); 
	//$("#pass").append("<input id='password' type='password' class='txt2'/>"); 
	$("#password").val($.cookie("password")); 
	checkLogin();
	} 
	
	}); 
//记住用户名密码 
function save() { 
if ($("#ck_rmbUser").prop("checked")) { 
var username = $("#username").val(); 
var password = $("#password").val(); 
$.cookie("rmbUser", "true", { expires: 7 }); //存储一个带7天期限的cookie 
$.cookie("username", username, { expires: 7 }); 
$.cookie("password", password, { expires: 7 }); 
}else{ 
$.cookie("rmbUser", "false", { expire: -1 }); 
$.cookie("username", "", { expires: -1 }); 
$.cookie("password", "", { expires: -1 }); 
} 
}; 

function check(){ 
var username = $("#username").val(); 
var password = $("#password").val(); 
if(username == "" || username == "请输入用户名"){ 
alert("请输入用户名!"); 
$("#username").focus(); 
return false; 
} 
if(password == "" || password == "请输入密码"){ 
alert("请输入密码!"); 
$("#password").focus(); 
return false; 
} 
$("#tip").text(""); 
return true; 
} 
function checkLogin(){
	if(check()){
	
 var username=$("#username").val();
 var password=$("#password").val();
	$.ajax({
		url: 'loginCheck.do',
		data: {
			username: username,
			password: password
		},
		dataType: 'json',
		method : 'GET',
		success: function(data) {
			var json = eval(data);
			var result=json.info;
			if(result == '0'){
				save(); 
				var userLoginName=eval(json.userInfo)[0].userLoginName;
				window.location="query.do?userLoginName="+encodeURI(userLoginName);	
			}else{
				alert(result);
			}
	},
	error: function(XMLHttpRequest, textStatus, errorThrown) {
		//alert('查询数据错误,详细信息：[' + errorThrown + ']');
	}
});
}
}
</script>
</html>
