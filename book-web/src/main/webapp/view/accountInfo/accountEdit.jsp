<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<script type="text/javascript"
	src="/book-web/providerbook/scripts/jquery-2.1.1.js"></script>
<script type="text/javascript">
	function uploadPic() {
		var formData = new FormData();
		formData.append('accountId', $('#accountId').val());
		formData.append('file', $('#file')[0].files[0]);
		$.ajax({
			url : 'uploadPic',
			type : 'post',
			async : false,
			cache : false,
			data : formData,
			processData : false,
			contentType : false,
			success : function(data) {
				$('#picPath').val(data);
				return true;
			},
			error : function() {
				alert("图片上传错误");
				return false;
			}
		});
	}
</script>
</head>
<body>
	<h2>Login!</h2>

	<div id="tab_menu" align="right" style="margin-right: 50px;">
		<ul>
			<li><button style="margin-right: 10px;">注册</button>
				<button>登录</button></li>
		</ul>
	</div>
	<div id="tab_box">
		<div id="register" align="center" style="margin-top: 10%;">
		<img alt="头像加载失败" style="width: 10%;height: 10%;" src="http://localhost:8080/book-web/picture/headPic?accountId=${accountInfo.accountId }"><br>
			<input id="file" type="file"
				style="width: 20%; height: 34px; margin-top: 10px;">
			<form action="update" onsubmit="return uploadPic()">
				<table style="width: 20%;">
					<tr>
						<td style="width: 100%;" align="center" colspan="2"><input
							type="hidden" id="picPath" name="picPath"></td>
					</tr>
					<tr>
						<td style="width: 100%;" align="center" colspan="2"><input
							id="accountId" readonly="readonly" name="accountId" type="text"
							placeholder="输入Id：" value="${accountInfo.accountId }"
							style="width: 100%; height: 34px; margin-top: 10px;"></td>
					</tr>
					<tr>
						<td style="width: 100%;" align="center" colspan="2"><input
							name="accountName" type="text" placeholder="输入账号："
							value="${accountInfo.accountName }"
							style="width: 100%; height: 34px; margin-top: 10px;"></td>
					</tr>
					<tr>
						<td style="width: 100%;" align="center" colspan="2"><input
							name="accountPassword" type="password" placeholder="输入密码："
							value="${accountInfo.accountPassword }"
							style="width: 100%; height: 34px; margin-top: 10px;"></td>
					</tr>
					<tr>
						<td style="width: 100%;" align="center" colspan="2"><input
							name="bindPhone" type="text" placeholder="手机号码："
							value="${accountInfo.bindPhone }"
							style="width: 100%; height: 34px; margin-top: 10px;"></td>
					</tr>
					<tr>
						<td style="width: 100%;" align="center" colspan="2"><input
							name="bindEmail" type="text" placeholder="邮箱账号："
							value="${accountInfo.bindEmail }"
							style="width: 100%; height: 34px; margin-top: 10px;"></td>
					</tr>
					<tr>
						<td style="width: 100%;" align="center" colspan="2">
							<button type="submit"
								style="width: 100%; height: 34px; margin-top: 10px;">修改</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
