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
	function setImg() {
		var imgList = document.getElementsByTagName('img');
		for (var i = 0; i < imgList.length; i++) {
			while (imgList[i].width > 100) {
				imgList[i].width = imgList[i].width * 0.9;
				imgList[i].heigth = imgList[i].heigth * 0.9;
			}
		}
	}

	function deleteaccount(account) {
		var bookNum = $('#bookNum').val();
		$.ajax({
			url : 'delete',
			data : {
				paperBookId : paperBookId,
				bookNum : bookNum
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
	function addToCart(bookId) {
		var bookNum = $('#bookNum'+bookId).val();
		$.ajax({
			url : 'addToCart',
			data : {
				bookNum : bookNum,
				bookId : bookId
			},
			type : 'post',
			async : false,
			success : function(data) {
				alert(data);
			},
			error : function(data) {
				alert(data);
			}
		});
	}
</script>
<title>所有在售书籍</title>
</head>
<body>
	<%@include file="/view/menu/header.jsp"%>
	<div align="center">
		<c:choose>
			<c:when test="${bookMds!=null}">
				<table border="1px;" align="center"
					style="margin-top: 10%; width: 100%; height: 100%;">
					<thead>
						<tr>
							<th>书名：</th>
							<th>价格：</th>
							<th>描述：</th>
							<th>图片：</th>
							<th>数量：</th>
							<th>操作：</th>
						</tr>
					</thead>
					<c:forEach var="paperBook" items="${bookMds}">
						<tr>
							<td align="center" style="width: 10%;">${paperBook.bookName}</td>
							<td align="center">${paperBook.bookPrice}</td>
							<td align="center">${paperBook.description}</td>
							<td align="center" style="width: 100px;"><img alt="图片加载失败"
								src="http://localhost:8080/book-web/picture/bookPic?paperBookId=${paperBook.paperBookId}">
							</td>
							<td align="center"><input type="text"
								id="bookNum${paperBook.paperBookId}"></td>
							<td align="center"><a href="javascript:void(0);"
								onclick="delBook(${paperBook.paperBookId})">删除</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h2>无账户信息！</h2>
			</c:otherwise>
		</c:choose>
		<button type="button" onclick="setImg();">测试</button>
	</div>
</body>
</html>