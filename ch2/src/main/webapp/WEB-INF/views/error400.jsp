<%@ page contentType="text/html;charset=utf-8" isErrorPage="false"%><!--isErrorPage="true": 이 페이지는 에러가 났을 때 보여주는 페이지라는 뜻  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>error400.jsp</title>
</head>
<body>
<h1>예외가 발생했습니다.</h1>
발생한 예외 : ${pageContext.exception}<br><!-- -isErrorPage="true"를 해야 exception객체 사용이 가능 -->
<!-- ex객체를 받음 (isErrorPage="true"를 설정하면 ex를 줄 필요가 없다.)-->
예외 메시지 : ${pageContext.exception.message}<br>
<ol>
<c:forEach items="${pageContext.exception.stackTrace}" var="i">
	<li>${i.toString()}</li>
</c:forEach>
</ol>
</body>
</html>
