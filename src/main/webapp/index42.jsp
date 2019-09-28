<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-09-28
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Index 42 JSP</title>
</head>
<body>
<form>
    <c:forEach var="number" begin="2" end="10" step="2" varStatus="loopStatus">
            <p> <c:out value="${number}"/> </p>
    </c:forEach>
</form>

</body>
</html>
