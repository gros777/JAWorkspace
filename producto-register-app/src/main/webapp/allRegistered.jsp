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
	<s:iterator status="stat" value="allProducts">
		<s:property value="id"/>
		<s:property value="productName"/>
		<s:property value="mark"/>
		<s:property value="shelve"/>
		<s:property value="availables"/>
		<s:property value="goodThough"/>
	</s:iterator>
</body>
</html>