<?xml version="1.0" encoding="US-ASCII" ?>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<div id="contenedor-mains">
		<div id="header">
			<div id="logo"></div>
			<div id="searchForm">
				<s:form action="searchProducts">
				<s:textfield name="productName" label="Nombre de Producto"/>
				<s:submit value="Buscar"/>
				</s:form>
			</div>
		</div>
		<div id="menu">
			<a href="/producto-register-app/allProducts.action" >All Products</a>
			<a href="/producto-register-app/newProduct.jsp" >Add new Products</a>
			<a href="/producto-register-app/searchBy.action" >Search Product By: </a>
		</div>
		<div id="content">
		</div>
		<div id="footer">
		</div>
	</div>
</body>
</html>