<%--
1.Pobierz wartość parametru GET o nazwie author.
2.Sprawdź czy parametr istnieje oraz czy nie jest pusty.
3.Wyświetl informacje w postaci:
<p>Wybrany autor <Pobrana wartość></p>

np: http://localhost:8080/index41.jsp?author=Jan+Brzechwa
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index 41 JSP</title>
</head>
<body>
<p>Author: ${not empty param.author ? param.author : "Nie wybrano"}</p>
<p>Author: ${param.author != null ? param.author : "Brak"}</p>
<br/><br/>
</body>
</html>
