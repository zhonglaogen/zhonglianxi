<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-2-9
  Time: 下午3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">
      function userlogin() {
          document.login.action="${pageContext.request.contextPath}/login.action";
          document.login.submit();

      }
    </script>
  </head>
  <body>
<form name="login" method="get" >
  <input name="userphone" ><br>
  <input name="password"><br>
  <a href="#" onclick="userlogin()">登录</a><br>
  <a href="/regist.jsp">注册</a>

</form>
  </body>
</html>
