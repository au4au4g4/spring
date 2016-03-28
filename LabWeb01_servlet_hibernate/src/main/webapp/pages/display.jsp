<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>Display</title>
</head>
<body>
	<h3>Select Product Table Result : XXX row(s) selected</h3>

	
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>name</th>
					<th>price</th>
					<th>make</th>
					<th>expire</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${requestScope.result}">
					<tr>
						<c:url var="path" value="/pages/product.jsp">
							<c:param name="id" value="${vo.id}" />
							<c:param name="name" value="${vo.name}" />
							<c:param name="price" value="${vo.price}" />
							<c:param name="make" value="${vo.make}" />
							<c:param name="expire" value="${vo.expire}" />
						</c:url>
						<td><a href="${path}">${vo.id}</a></td>
						<td>${vo.name}</td>
						<td>${vo.price}</td>
						<td>${vo.make}</td>
						<td>${vo.expire}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	<h3>
		<a href="<c:url value="/pages/product.jsp"/>">Product Table</a>
		
	</h3>
</body>
</html>