<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-2-10
  Time: 下午4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function regist() {
                document.userform.action="${pageContext.request.contextPath}/regist.action";
                document.userform.submit();
        }
    </script>
</head>
<body>
<c:if test="${allErrors!=null}">
    <c:forEach items="${allErrors}" var="error">
        ${error.defaultMessage}

    </c:forEach>
</c:if>
<form name="userform" method="post">
    <input type="text" name="userphone" value="${user.userphone}">用户注册的手机号<br>
    <input type="password" name="password" value="${user.password}">密码<br>
    <input type="text" name="username" value="${user.username}">用户名<br>
    <input type="text" name="email" value="${user.email}">email<br>
    <a href="javascript:void(0)" onclick="regist()">注册</a>
    <%--#跳转至页面的上端，JavaScript：void（0）表示死链接--%>
</form>

</body>
</html>
