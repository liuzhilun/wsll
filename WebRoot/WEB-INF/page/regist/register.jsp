<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>注册</title>
    <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery.validate.js"></script>
    <!--Loading bootstrap css-->
    <link type="text/css" rel="stylesheet" href="resources/css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="resources/css/all.css">
    <link type="text/css" rel="stylesheet" href="resources/css/main.css">
<style type="text/css">

span.error{color:#C00; padding:0 6px;}

button {
  cursor:pointer;
  padding: 0 18px;
  height: 29px;
  font-size: 12px;
  font-weight: bold;
  color: #527881;
  text-shadow: 0 1px #e3f1f1;
  background: #cde5ef;
  border: 1px solid;
  border-color: #b4ccce #b3c0c8 #9eb9c2;
  border-radius: 16px;
  outline: 0;
  -webkit-box-sizing: content-box;
  -moz-box-sizing: content-box;
  box-sizing: content-box;
  background-image: -webkit-linear-gradient(top, #edf5f8, #cde5ef);
  background-image: -moz-linear-gradient(top, #edf5f8, #cde5ef);
  background-image: -o-linear-gradient(top, #edf5f8, #cde5ef);
  background-image: linear-gradient(to bottom, #edf5f8, #cde5ef);
  -webkit-box-shadow: inset 0 1px white, 0 1px 2px rgba(0, 0, 0, 0.15);
  box-shadow: inset 0 1px white, 0 1px 2px rgba(0, 0, 0, 0.15);
}
button:active {
  background: #cde5ef;
  border-color: #9eb9c2 #b3c0c8 #b4ccce;
  -webkit-box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.2);
  box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.2);
}
</style>
</head>
<body>
	<div class="row" style="background-color:#0ca3d2;">
		<div class="col-lg-4"></div>
        <div class="col-lg-4" style="background-color: #F2F8F8;">
	    	<div  >
            	<div class="panel-heading"><h2>用户注册</h2></div>
                <div class="panel-body pan">
                	<form id="form_regist">
                	<div class="form-body pal">
                    	<div class="form-group">
                                <lable>登录名</lable><input id="userLoginName" name="userLoginName" type="text" placeholder="登录名" class="form-control" required data-msg-required="请输入登录名" data-rule-checkUser="true"/>
                        </div>
                        <div class="form-group">
                            <div>
                            <span>密码</span>
                                 <input id="userLoginPwd" name="userLoginPwd" type="password" placeholder="密码" class="form-control" required data-msg-required="请输入密码"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div>
                             <span>确认密码</span>
                                <input id="confirmPassword" type="password" placeholder="确认密码" class="form-control" required equalTo="#userLoginPwd" />
                            </div>
                        </div>
                        <hr />
                       
                        <div class="form-group">
                            <div>
                             <span>姓名</span>
                                 <input id="userName" name="userName" type="text" placeholder="姓名" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                         <span>性别</span>
                            <select class="form-control" name="userSex" id="userSex">
                                <option value="">性别</option>
                                <option value="019001">男</option>
                                <option value="019002">女</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <div>
                             <span>手机号码</span>
                                 <input id="userPhoneNum" name="userPhoneNum" type="text" placeholder="手机号码" class="form-control" required data-msg-required="请输入手机号" data-rule-mobileCheck="true" data-rule-mobile="true" data-msg-mobile="请输入正确格式"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <div>
                             <span>邮箱</span>
                                 <input id="userEmail" name="userEmail" type="email" placeholder="Email" class="form-control" required data-rule-email="true" data-rule-emailCheck="true" data-msg-required="请输入email地址" data-msg-email="请输入正确的email地址"/>
                            </div>
                        </div>
                        <div class="form-group">
                         <span>证件类型</span>
                            <select class="form-control" name="userCertType" id="userCertType">
                                <option value="">证件类型</option>
                                <option value="001001">二代身份证</option>
                                <option value="001002">临时身份证</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <div>
                             <span>证件号码</span>
                                 <input id="userCertNo" name="userCertNo" type="text" placeholder="证件号码" class="form-control" />
                            </div>
                        </div>
                        <hr />
                        
                        <div class="form-group">
                            <div>
                             <span>公司名称</span>
                                 <input id="userComName" name="userComName" type="text" placeholder="公司名称" class="form-control" />
                            </div>
                        </div>

                        
                        <div class="form-group">
                            <div>
                             <span>公司地址</span>
                                 <input id="userComAddr" name="userComAddr" type="text" placeholder="公司地址" class="form-control" />
                            </div>
                        </div>
                        <hr />
                        <div class="form-group" hidden="true">
                            <div>
                             <span>备注</span>
                                 <textarea id="remark" name="remark" rows="5"  placeholder="备注" class="form-control" ></textarea>
                            </div>
                        </div>
                     </div>
                     <div class="form-actions text-right pal">
                         <button id="btn_submit" class="" onclick="saveUser">提交</button>
                         <button id="btn_return" onclick="window.location.href='login.do'" >返回</button>
                     </div>
                     </form>
               </div>
            </div>
      </div>
   </div>
</body>
<script type="text/javascript">
$(function(){
	
	$("#form_regist").validate({
		submitHandler: function(){
			saveUser();
		}
	});
	
});

function saveUser(){
	$("#btn_submit").attr("disabled",true);
	$.ajax({
		url:'saveUser.do',
		data:$("#form_regist").serialize(),
		dataType: "json",
		type:"post",
		success:function(data){
			var json = eval(data);
			var result=json.info;
			if(result == "success"){
				window.location="login.do";
			}
		}
	});
}


function checkPwd(){
	return $("#userLoginPwd").val() == $("#confirmPassword").val() ? true : false;
}

$.validator.setDefaults({
	errorElement:'span'
});


//配置通用的默认提示语
$.extend($.validator.messages, {
	required: '必填',
    equalTo: "请再次输入相同密码"
});

//邮箱验证规则
jQuery.validator.addMethod("mail", function (value, element) {
	var mail = /^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$/;
	return this.optional(element) || (mail.test(value));
}, "邮箱格式不对");

//手机验证规则  
jQuery.validator.addMethod("mobile", function (value, element) {
    var mobile = /^1[3|4|5|7|8]\d{9}$/;
	return this.optional(element) || (mobile.test(value));
}, "手机格式不对");


//验证用户名重复  
jQuery.validator.addMethod("checkUser", function (value, element) {
	var rst = checkUserRepeat();
	return (rst == "true");
}, "用户名重复");

//验证用户名重复  
jQuery.validator.addMethod("mobileCheck", function (value, element) {
	var rst = checkMobileRepeat();
	return (rst == "true");
}, "手机号已被注册");

//验证用户名重复  
jQuery.validator.addMethod("emailCheck", function (value, element) {
	var rst = checkEmailRepeat();
	return (rst == "true");
}, "邮箱已被注册");

function checkEmailRepeat(){
	var result;
	$.ajax({
		url:'checkEmail.do',
		data:{"userEmail" : $("#userEmail").val()},
		async:false,
		method:"get",
		success:function(data){
			result = data;
		}
	});
	return result;
}


function checkMobileRepeat(){
	var result;
	$.ajax({
		url:'checkPhoneNo.do',
		data:{"userPhoneNum" : $("#userPhoneNum").val()},
		async:false,
		method:"get",
		success:function(data){
			result = data;
		}
	});
	return result;
}


function checkUserRepeat(){
	var result;
    $.ajax({
		url:'checkLoginName.do',
		data:{"userLoginName" : $("#userLoginName").val()},
		async:false,
		method:"get",
		success:function(data){
			result = data;
		}
	});
    return result;
}

</script>

</html>
