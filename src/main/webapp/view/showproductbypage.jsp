<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
 <h1>商品列表</h1>

 
 <table>
 <tr>
   <th>商品id</th>
   <th>商品名称</th>
   <th>商品价格</th>
   <th>商品图片</th>
   <th>商品规格</th>
   <th>商品库存</th>
   <th>商品描述</th>
   <th>商品操作</th>
 </tr>
 
 <c:forEach items="${pageModel.data}" var="product">
   
   <tr>
       <td>${product.id}</td>
	   <td>${product.name}</td>
	   <td>${product.price}</td>
	   <td>${product.image}</td>
	   <td>${product.rule}</td>
	   <td>${product.stock}</td>
	   <td>${product.desc}</td>
	    <td><a href="product?operation=4&id=${product.id}">删除</a>  
	    <a href="product?operation=5&id=${product.id}">修改</a> </td>
   </tr>
   
 </c:forEach>
   

 </table>
 
 <c:forEach begin="1" end="${pageModel.totalPage}" step="1" var="current">
  
     <%--  <c:if test="${pageModel.currentPage==current}">
     
      </c:if> --%>
      
      <c:choose>
       <c:when test="${pageModel.currentPage==current}">
          <a  style="color:red"  href="product?operation=2&pageNo=${current}&pageSize=2">${current}</a>
       </c:when>
       <c:when test="${pageModel.currentPage!=current}">
          <a   href="product?operation=2&pageNo=${current}&pageSize=3">${current}</a>
       </c:when>
      </c:choose>
      
   </c:forEach>
   
       <form action="cart" methed="post">
	<input type="hidden" name = "operation"  value="1" />
	<table>	
	<tr>
			<td>输入这个商品id</td>
			<td><input type="text" name="id" /></td>		
		</tr>
		<tr>
			<td>输入要购买的商品数量</td>
			<td><input type="text" name="num" /></td>		
		</tr>					
		<tr>
			<td><input type="submit" value="提交"/></td>
		</tr>
	
	</table>
	</form>
   
 
  

  

</body>
</html>