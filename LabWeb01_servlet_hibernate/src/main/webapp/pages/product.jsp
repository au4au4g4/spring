<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>Product</title>
<script type="text/javascript" src="../js/json2.js"></script>
<script type="text/javascript" src="../js/product.js"></script>
<script type="text/javascript">
	var path = "${pageContext.request.contextPath}";
	function doBlur() {
		document.getElementsByTagName("img")[0].style.display = "inline";
		var url = path + "/pages/product.view";
		var id = document.getElementsByTagName("input")[0].value;
		// 	sendGetRequest(url, id, "textText");
		// 	sendPostRequest(url, id, "textXml");
		// 	sendPostRequest(url, id, "textJson");
		sendPostRequestJSON(url, id);
	}
	function clearForm() {
		var inputs = document.getElementsByTagName("input");
		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].type == "text") {
				inputs[i].value = "";
			}
		}
		var spanElement = document.getElementsByTagName("span")[0];
		spanElement.removeChild(spanElement.firstChild);
	}
</script>
</head>
<body>

	<h3>Welcome ${sessionScope.customer.email}</h3>
	<h3>Product Table</h3>

	<form action="productaction.action" method="post">
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="id" value="${param.id}"/></td>
				<td>
					<span class="error">${requestScope.error.id}</span> 
					<img src="../img/ajax-loader.gif" style="display: none" />
				</td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" value="${param.name}"/></td>
				<td><span class="error">${requestScope.error.name}</span></td>
			</tr>

			<tr>
				<td>Price :</td>
				<td><input type="text" name="price"  value="${param.price}"/></td>
				<td><span class="error">${requestScope.error.price}</span></td>
			</tr>
			<tr>
				<td>Make :</td>
				<td><input type="text" name="make"  value="${param.make}"/></td>
				<td><span class="error">${requestScope.error.make}</span></td>
			</tr>
			<tr>
				<td>Expire :</td>
				<td><input type="text" name="expire"  value="${param.expire}"/></td>
				<td><span class="error">${requestScope.error.expire}</span></td>
			</tr>
			<tr>
				<td>
					<input type="submit" name="button" value="Insert"/> 
					<input type="submit" name="button" value="Update"/>
				</td>
				<td>
					<input type="submit" name="button" value="Delete"/>
					<input type="submit" name="button" value="Select"/>  
					<input type="button" value="Clear" onclick="clearForm()">
				</td>
			</tr>
		</table>

	</form>

	<h3>
		<span class="error">${requestScope.success}</span>
	</h3>

	表格

</body>
</html>