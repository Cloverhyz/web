<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/book-web/providerbook/scripts/jquery-2.1.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function() {
	while(true){
		
var url = "http://h5.9zhiad.com//h5/interaction/partyStar/vote";
var params = {
		tvId:2 || 2,
		starId: 9999983581211259
	}; 
$.post(url,params,function(data){ //点赞请求
},'json');
//alert("成功");
	}
});

</script>
</head>
<body>
你好！
</body>
</html>