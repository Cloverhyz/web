<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script type="text/javascript" src="providerbook/scripts/jquery-2.1.1.js"></script>
<script type="text/javascript">
	$(function() {
		var $div_li = $("#tab_menu ul li button");
		$div_li.click(function() { //定义了tan_menu对应的单击事件，也就是类别的单击事件。
			var index = $div_li.index(this);
			$("#tab_box div").eq(index).show().siblings().hide();
		});
	});
</script>
</head>
<body>
	<h2>Login!</h2>

	<div id="tab_menu" align="right" style="margin-right: 50px;">
		<ul>
			<li><button style="margin-right: 10px;">注册</button><button>登录</button></li>
		</ul>
	</div>
	<div id = "tab_box">
		<div id="register" align="center" hidden="true" style="margin-top: 10%;">
			<form action="register">
				<table style="width: 20%;">
					<tr>
						<td style="width: 100%;" align="center" colspan="2"><input
							name="accountName" type="text" placeholder="输入账号："
							style="width: 100%; height: 34px; margin-top: 10px;"></td>
					</tr>
					<tr>
						<td style="width: 100%;" align="center" colspan="2"><input
							name="accountPassword" type="password" placeholder="输入密码："
							style="width: 100%; height: 34px; margin-top: 10px;"></td>
					</tr>
					<tr>
						<td style="width: 100%;" align="center" colspan="2"><input
							name="bindPhone" type="text" placeholder="手机号码："
							style="width: 100%; height: 34px; margin-top: 10px;"></td>
					</tr>
					<tr>
						<td style="width: 100%;" align="center" colspan="2"><input
							name="bindEmail" type="text" placeholder="邮箱账号："
							style="width: 100%; height: 34px; margin-top: 10px;"></td>
					</tr>
					<tr>
						<td style="width: 100%;" align="center" colspan="2">
							<button type="submit"
								style="width: 100%; height: 34px; margin-top: 10px;">登录</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="login" align="center" style="margin-top: 10%;">
			<form action="login">
				<table style="width: 20%;">
					<tr>
						<td style="width: 100%;" align="center" colspan="2"><input
							name="accountName" type="text" placeholder="输入账号："
							style="width: 100%; height: 34px; margin-top: 10px;"></td>
					</tr>
					<tr>
						<td style="width: 100%;" align="center" colspan="2"><input
							name="accountPassword" type="password" placeholder="输入密码："
							style="width: 100%; height: 34px; margin-top: 10px;"></td>
					</tr>
					<tr>
						<td style="width: 100%;" align="center" colspan="2">
							<button type="submit"
								style="width: 100%; height: 34px; margin-top: 10px;">登录</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
