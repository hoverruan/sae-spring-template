<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head><title>Book created</title></head>
<body>
<h3>Book created</h3>
<div>
	Book id: ${book.id}, Name: ${book.name}
</div>
<h3>Book list</h3>
<div>
	<c:forEach items="${bookList}" var="book" varStatus="i">
		<div>${i.index}: ${book.id}, ${book.name}</div>
	</c:forEach>
</div>
</body>
</html>
