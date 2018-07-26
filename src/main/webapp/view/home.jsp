<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>欢迎登录${acc.username}!</h1>

 <a href="view/addproduct.jsp">添加商品</a>
 <br/>
 <a href="view/product?operation=2">查看商品</a>
 <br/>
 <a href="view/cart?operation=2">查看购物车   </a>
 <br/>
 <a href="view/OrderServlet?operation=2">查看我的订单</a>
 <br/>
 <a href="view/addCategory.jsp">添加类别</a>
 <br/>
 <a href="view/findCategory.jsp">查看类别</a>
			
		
			
</body>
</html>