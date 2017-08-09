<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>

<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resource/style.css" />">
</head>
<body>
<h1>Welcome to Spittr</h1>
<a href="<c:url value="/spittles" />">Spittles</a>
<a href="<c:url value="/spittler/register" />">Register</a>
</body>
</html>