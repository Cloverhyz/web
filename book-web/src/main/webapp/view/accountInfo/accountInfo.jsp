<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="/book-web/providerbook/scripts/jquery-2.1.1.js"></script>
<script type="text/javascript">
	function deleteaccount(account) {
		var tr = account.parentElement.parentElement;
		var accountId = tr.firstElementChild.innerText;
		$.ajax({
			url : 'delete',
			data : {
				accountId : accountId
			},
			type : 'post',
			async : false,
			success : function(data) {
				var table = tr.parentElement;
				table.removeChild(tr);
			},
			error : function(data) {
				alert(data);
			}
		});
	}
	function update(account) {
		var tr = account.parentElement.parentElement;
		var accountId = tr.firstElementChild.innerText;
		if (accountId != null && accountId != "") {
			window.location = "toUpdate?accountId=" + accountId;
		}
	}
</script>
<title>所有账户信息</title>
</head>
<body>
	<div align="center">
		<c:choose>
			<c:when test="${accountInfo!=null}">
				<table border="1px;" align="center" style="margin-top: 10%;">
					<thead>
						<tr>
							<th>序号：</th>
							<th>账号：</th>
							<th>密码：</th>
							<th>手机：</th>
							<th>邮箱：</th>
							<th>操作：</th>
						</tr>
					</thead>
					<c:forEach var="account" items="${accountInfo}">
						<tr>
							<td align="center">${account.accountId}</td>
							<td align="center">${account.accountName}</td>
							<td align="center">${account.accountPassword}</td>
							<td align="center">${account.bindPhone}</td>
							<td align="center">${account.bindEmail}</td>
							<td align="center"><a href="javascript:void(0);"
								onclick="update(this)">修改</a>/<a href="javascript:void(0);"
								onclick="deleteaccount(this)">删除</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h2>无账户信息！</h2>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>