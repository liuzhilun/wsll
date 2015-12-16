<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String userLoginName = request.getParameter("userLoginName");
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<title>用户修改</title>
<style>
body,a{ font-size:12px; color:#666;}
ul,li{ margin:0; padding:0; list-style:none}
.fn-vhid{ visibility:hidden;}
.fn-tinput{ width:340px; height:30px; line-height:30px\9; border:#ddd solid 1px; background-color:transparent; padding:0 6px;}
textarea {border:#ddd solid 1px; background-color:transparent; width:60%}
.fn-tinput:focus,textarea:focus{ border-color:#c00;}
.bl-form label{ float:left; width:100px; text-align:right; padding-top:6px;}
.bl-form .controls label{ width:auto;}
.bl-form li{ margin-top:20px; overflow:hidden;}
em{ color:#C00;}
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
<link rel="stylesheet" href="resources/css/hitecSystem.css">
<link rel="stylesheet" href="resources/css/queryStyle.css">
<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>
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

<body style="background-color: #F2F8F8;">
<div class="banner">
		<div class="logo"></div>
		<div class="sys-text">
			<span class="mainTitle">黑名单查询系统</span>
		</div>
		<div class="top-bar">
			<span class="icon-user" style="font-size:12px">欢迎 :<%=userLoginName%></span> <span
				class="icon-setUp hand" onclick="changePwd()" style="font-size:12px">修改密码  </span>  <span
				class="icon-quit hand" onclick="delCookie()" style="font-size:12px">注销</span>

		</div>
	</div>

	<div class="home-main">
		<div class="home-main-left fl">
			<div class="home-box mb10">
				<h4>菜单</h4>
				<ul>
					<li><a href='toUserUpdate.do?userLoginName=<%=userLoginName%>'>用户中心</a></li>
					<li><a href='query.do?userLoginName=<%=userLoginName%>'>黑名单查询</a></li>
				</ul>
			</div>
		</div>
<div class="home-main-center fl ml10">
			<h2>用户中心</h2>
	<form action="" class="bl-form bl-formhor" id="userForm">
        <ul>
        	<li hidden="true">
                <label>主键：</label>
                <div class="controls">
                   <input id="tableKey" class="fn-tinput" type="text" name="tableKey" />
                </div>
            </li>
            <li hidden="true">
                <label>密码：</label>
                <div class="controls">
                   <input id="userLoginPwd" class="fn-tinput" type="text" name="userLoginPwd" />
                </div>
            </li>
        	<li class="bl-form-group">
                <label>登录名：</label>
                <div class="controls">
                   <input id="userLoginName" class="fn-tinput" type="text" name="userLoginName"  readonly="readonly"/>
                </div>
            </li>
        	<li class="bl-form-group">
                <label>手机：</label>
                <div class="controls">
                    <input id="userPhoneNum" type="text" value="" name="userPhoneNum" class="fn-tinput" required data-rule-mobileCheck="true" data-rule-mobile="true" data-msg-required="请输入手机号" data-msg-mobile="请输入正确格式" />
                </div>
            </li>
            <li class="bl-form-group">
                <label>Email：</label>
                <div class="controls">
                    <input id="userEmail" type="text" value="" name="userEmail" class="fn-tinput" required data-rule-email="true" data-rule-checkEmail="true" data-msg-required="请输入email地址" data-msg-email="请输入正确的email地址" />
                </div>
            </li>
            <li class="bl-form-group">
                <label>姓名：</label>
                <div class="controls">
                    <input id="userName" type="text" value="" name="userName" class="fn-tinput" />
                </div>
            </li>
            <li class="bl-form-group">
                <label>证件类型：</label>
                <div class="controls">
                    <select name="userCertType" id="userCertType">
                    	<option value="">--------</option>
                        <option value="001001">二代身份证</option>
                        <option value="001002">临时身份证</option>
                    </select>
                </div>
            </li>
            <li class="bl-form-group">
                <label>证件号码：</label>
                <div class="controls">
                    <input id="userCertNo" type="text" value="" name="userCertNo" class="fn-tinput" />
                </div>
            </li>
            <li class="bl-form-group bl-form-text">
                <label>性别：</label>
                <div class="controls">
                    <label><input name="userSex" type="radio" value="019001">男</label>
                    <label><input name="userSex" type="radio" value="019002">女</label>
                </div>
            </li>
            
            <li class="bl-form-group">
                <label>公司名称：</label>
                <div class="controls">
                    <input id="userComName" type="text" value="" name="userComName" class="fn-tinput"/>
                </div>
            </li>
            <li class="bl-form-group">
                <label>公司性质：</label>
                <div class="controls">
                    <select name="userComType" id="userComType">
                    	<option value="">--------</option>
                        <option value="008001">民营</option>
                        <option value="008002">个体</option>
                        <option value="008003">事业单位</option>
                        <option value="008004">国企</option>
                        <option value="008005">外企</option>
                    </select>
                </div>
            </li>
            <li class="bl-form-group">
                <label>公司地址：</label>
                <div class="controls">
                    <input id="userComAddr" class="fn-tinput" type="text" name="userComAddr" value="" >
                </div>
            </li>
            
            <li class="bl-form-group">
                <label>备注：</label>
                <div class="controls editor">
                    <textarea id="remark" name="remark" cols="" rows="" style="background: white;"></textarea>
                </div>
            </li>
            <li class="bl-form-group bl-form-btns">
                <label class="fn-vhid">提交：</label>
                <div class="controls">
                    <button class="fn-btn btn-primary btn-submit submitBtn" type="submit" id="btn_submit">提交</button>
            		<button type="reset" class="fn-btn">重置</button>
                </div>
            </li>
        </ul>
    </form>
</div>
</div>
<script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
<script type="text/javascript">
function delCookie() {
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
$(function(){
	var userLoginName = getParameter();
	initForm(userLoginName);
	$("#userForm").validate({
		submitHandler: function() {
				//验证通过后 的js代码写在这里
// 			console.log($("#userForm").serialize());	
			saveUser();
		}
	});

});

function saveUser(){
	$("#btn_submit").attr("disabled",true);
	 $.post("saveUser.do",$("#userForm").serialize(),
			  function(data){
		 var json = eval(data);
			$("#btn_submit").attr("disabled",false);
			if(json.info=="success"){
				alert("保存成功");
			}
			if(json.info=="failed"){
				alert("保存失败");
			}
		  },
		  "json");//这里返回的类型有：json,html,xml,text
		}
	/* $.ajax({
		url:'saveUser.do',
		method:"post",
		data:$("#userForm").serialize(),
		dataType:'json',
		success:function(data){
			var json = eval(data);
			$("#btn_submit").attr("disabled",false);
			if(json.info=="success"){
				alert("保存成功");
			}
			if(json.info=="failed"){
				alert("保存失败");
			}
		}
	}); 
}*/

function getParameter(){
	var src = window.location.href;
	var srcArray = src.split("?");
	var key = srcArray[1].split("=");
	return decodeURI(key[1]);
}

function initForm(userLoginName){
	$.ajax({
		url : 'getUserByLoginName.do',
		method:'get',
		data:{"userLoginName" : userLoginName},
		dataType: "json",
		success:function(data){
			$("#userLoginName").val(data.userLoginName);
			$("#tableKey").val(data.tableKey);
			$("#userLoginPwd").val(data.userLoginPwd);
			$("#userPhoneNum").val(data.userPhoneNum);
			$("#userEmail").val(data.userEmail);
			$("#userCertNo").val(data.userCertNo);
			$("#userComName").val(data.userComName);
			$("#userComAddr").val(data.userComAddr);
			$("#userName").val(data.userName);
			$("#remark").val(data.remark);
			$("input[name='userSex'][value='"+data.userSex+"']").attr("checked",true);
			$("#userComType > option[value='"+data.userComType+"']").attr("selected","selected");
			$("#userCertType > option[value='"+data.userCertType+"']").attr("selected","selected");
		}
	});
}
//配置错误提示的节点，默认为label，这里配置成 span （errorElement:'span'）
$.validator.setDefaults({
	errorElement:'span'
});

//配置通用的默认提示语
$.extend($.validator.messages, {
	required: '必填',
    equalTo: "请再次输入相同的值"
});

//邮箱 
jQuery.validator.addMethod("mail", function (value, element) {
	var mail = /^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$/;
	return this.optional(element) || (mail.test(value));
}, "邮箱格式不对");

//手机验证规则  
jQuery.validator.addMethod("checkEmail", function (value, element) {
    var rst = checkEmailRepeat();
    return (rst == "true");
}, "邮箱已被注册");

function checkEmailRepeat(){
	var result;
	$.ajax({
		url:'checkUpdateEmail.do',
		data:{"userEmail" : $("#userEmail").val(),"tableKey" : $("#tableKey").val()},
		async:false,
		method:"get",
		success:function(data){
			result = data;
		}
	});
	return result;
}

//手机验证规则  
jQuery.validator.addMethod("mobile", function (value, element) {
    var mobile = /^1[3|4|5|7|8]\d{9}$/;
	return this.optional(element) || (mobile.test(value));
}, "手机格式不对");

//手机验证规则  
jQuery.validator.addMethod("mobileCheck", function (value, element) {
    var rst = checkMobileRepeat();
    return (rst == "true");
}, "手机号码已被注册");

function checkMobileRepeat(){
	var result;
	$.ajax({
		url:'checkUpdatePhoneNo.do',
		data:{"userPhoneNum" : $("#userPhoneNum").val(),"tableKey" : $("#tableKey").val()},
		async:false,
		method:"get",
		success:function(data){
			result = data;
		}
	});
	return result;
}

//汉字
jQuery.validator.addMethod("chinese", function (value, element) {
    var chinese = /^[\u4E00-\u9FFF]+$/;
    return this.optional(element) || (chinese.test(value));
}, "格式不对");

function changePwd() {
	window.location = "changePwd.do?userLoginName="
			+ encodeURI(userLoginName);
}
</script>
</body>
</html>
