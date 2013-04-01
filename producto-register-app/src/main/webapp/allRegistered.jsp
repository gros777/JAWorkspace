<?xml version="1.0" encoding="US-ASCII" ?>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Product Name</th>
			<th>Mark</th>
			<th>Shelve</th>
			<th>Avaliable</th>
			<th>Goog Through</th>
		</tr>
		<s:iterator status="stat" value="products">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="productName" /></td>
				<td><s:property value="mark" /></td>
				<td><s:property value="shelve" /></td>
				<td><s:property value="availables" /></td>
				<td><s:property value="goodThough" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>