<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<script type="text/javascript"
	src="/book-web/providerbook/scripts/jquery-2.1.1.js"></script>
<script type="text/javascript">
	//检查表单是否为空
	function checkForm() {
		var input_cart = document.getElementsByTagName("INPUT");

		for (var i = 0; i < input_cart.length; i++) {
			if (input_cart[i].value == "" || input_cart[i].value == null) {
				alert("信息不能为空!");
				input_cart[i].focus();
				return false;
			}
		}
		return true;
	}
</script>
</head>
<body>
	<h2>大甩卖！</h2>

	<div id="tab_box" align="center">
		<form action="uploadpaperbook" onsubmit="return checkForm()"
			enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<td>书名</td>
					<td>描述</td>
					<td>价格</td>
					<td>数量</td>
					<td>图片</td>
				</tr>
				<tr>
					<td><input name="bookName" type="text" placeholder="书名："><input
						name="accountId" type="hidden" value="${accountId}"></td>
					<td><textarea name="description" rows="5" cols="20"
							placeholder="描述："></textarea></td>
					<td><input name="bookPrice" type="text" placeholder="价格：">
					</td>
					<td><input name="number" type="text" placeholder="数量:">
					</td>
					<td><input id="file" name="file" type="file" placeholder="图片：">
						<input name="bookPicPath" type="hidden" value="0"></td>
				</tr>
			</table>
			<button type="submit">提交</button>
		</form>
	</div>
</body>
</html>
