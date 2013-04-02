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
			ID:<s:property value="product.id" /><br />
			Product Name:<s:property value="product.productName" /><br />
			Mark:<s:property value="product.mark" /><br />
			Shelve:<s:property value="product.shelve" /><br />
			Avaliable:<s:property value="product.availables" /><br />
			Goog Through:<s:property value="product.goodThough" /><br />
		</div>
		<div id="footer">
		</div>
	</div>
</body>
</html>
