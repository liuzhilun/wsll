<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String userLoginName = request.getParameter("userLoginName");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<base href="<%=basePath%>">
<title>查询</title>
<title></title>
<link rel="stylesheet" href="resources/css/queryStyle.css">
<link rel="stylesheet" href="resources/css/hitecSystem.css">
<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
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
	<div class="banner">
		<div class="logo"></div>
		<div class="sys-text">
			<span class="mainTitle">黑名单查询系统</span>
		</div>
		<div class="top-bar">
			<span class="icon-user">欢迎 :<%=userLoginName%></span> <span
				class="icon-setUp hand" onclick="changePwd()">修改密码</span> <span
				class="icon-quit hand" onclick="delCookie()">注销</span>

		</div>
	</div>
	<div class="home-main">
		<div class="home-main-left fl">
			<div class="home-box">
				<h4>菜单</h4>
				<ul>
					<li><a href='toUserUpdate.do?userLoginName=<%=userLoginName%>'>用户中心</a></li>
					<li><a href='query.do?userLoginName=<%=userLoginName%>'>黑名单查询</a></li>
				</ul>
			</div>
		</div>
		<div class="home-main-center fl ml10">
			<h2>黑名单查询</h2>
			<div style="padding: 20px">
				<table width="100%" height="100%">
					<tr height="20px;">
						<td>
							<table width="100%" border="0">
								<tr>
									<td width="620px;" class="search">
										<table>
											<tr>
												<td align="right">姓名:</td>
												<td><input type="text" id="custName" /></td>
												<td align="right" width="80px;">证件号:</td>
												<td><input type="text" id="custCertNo" /></td>
											</tr>
											<tr>
												<td align="right">手机号:</td>
												<td><input type="text" id="custMobNum" /></td>
												<td align="right" width="80px;">银行卡号:</td>
												<td><input type="text" id="bankAccount" /></td>
											</tr>
										</table>
									</td>

								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<div style="padding-top: 30px; padding-left: 40px">
								<table>
									<tr>
										<td height="20"><input type="button" name="btn_query"
											value="查询" onClick="query()" /> <input type="button"
											name="btn_reset" value="重置" onClick="reset()" /></td>
									</tr>
									<tr>


									</tr>
								</table>
							</div>
							<div style="padding-top: 30px; padding-left: 30px">
								<table>
									<tr>
										<td width="120px"><span><font size="5">查询结果:</font></span></td>
										<td><span id="result"
											style="width: 200px; font-size: 25px;"></span></td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	//修正未定义的变量
	/* function checkUnfined(value) {
		if (typeof (value) == 'undefined') {
			return "";
		}
		return value;
	} */
	function query() {
		var custName = $("#custName").val();
		var custCertNo = $("#custCertNo").val();
		var custMobNum = $("#custMobNum").val();
		var bankAccount = $("#bankAccount").val();
		if (custName == "" ||   custCertNo == ""
				|| custMobNum == "" ) {
			alert("客户姓名、证件、电话号码必须输入！");
			return;
		}
		if(custMobNum.length>11){
			alert("输入的号码长度过长！");
			return;
		}
		$("#result").html("");
		$.ajax({
			url : 'queryBlack.do',
			data : {
				custName : custName,
				custCertNo : custCertNo,
				custMobNum : custMobNum,
				bankAccount : bankAccount,
				userLoginName : userLoginName
			},
			dataType : 'json',
			method : 'GET',
			success : function(data) {
				var json = eval(data);
				var result = json.result;
				var insertCode = json.insertCode;
				if (insertCode == "error") {
					alert("保存查询记录错误！");
				}
				if (result == '0') {
					$("#result").html("客户存在");
				}
				if (result == '1') {
					$("#result").html("未查询到客户");
				}

			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert('查询数据错误！');
			}
		});
	}
	function reset() {
		$("#custName").val("");
		$("#custCertNo").val("");
		$("#custMobNum").val("");
		$("#bankAccount").val("");
	}
	function delCookie() {
	    $.cookie("rmbUser", "false", {expire : -1});
		$.cookie("username", "", {expires : -1});
		$.cookie("password", "", {expires : -1});
		window.location = "login.do";
	}
	function changePwd() {
		window.location = "changePwd.do?userLoginName="
				+ encodeURI(userLoginName);
	}
</script>
</html>
