<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width:100%; height:763px ; background-image: url(img/52p58PICNd6_1024.jpg);position: absolute;">

    <h1 style="color: orange;position: absolute;left:55%;top: 10%;">请登录</h1>
    <div style="width: 500px;height: 600px; position: absolute;left:50%; top: 20%;opacity: 0.6;">
  <form action="login.do" method="post">
   <table >
     <tr>
      <td style="color: aliceblue;">用户名</td>
      <td><input type="text" name="username" style="width:250px;height: 30px;"/></td>
     </tr>
      <tr>
        <td style="color: aliceblue;">密码</td>
      <td><input type="password" name="password" style="width:250px;height: 30px;"/></td>
      </tr>

      <div style="width: 500px;height: 600px; position: absolute;left: 60px;top: 120px;">  <input type="submit" value="登录" style="background-color: cornflowerblue;width: 200px; height:30px; "/> </div>

  </table>
  </form>
    </div>
</div>



</body>
</html>