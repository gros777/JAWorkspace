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
					<s:textfield name="productName" label="Nombre de Producto" />
					<s:submit value="Buscar" />
				</s:form>
			</div>
		</div>
		<div id="menu">
			<a href="/producto-register-app/allProducts.action">All Products</a>|
			<a href="/producto-register-app/newProduct.jsp">Add new Products</a>|
			<a href="/producto-register-app/searchBy.action">Search Product
				By: </a>
		</div>
		<div id="content">
			<s:fielderror />
			<s:form >
				<s:hidden name="id" />
				<s:textfield name="productName" label="Product Name" required="true"
					value="%{product.productName}" />
				<br />
				<s:textfield name="mark" label="Mark" value="%{product.mark}" />
				<br />
				<s:textfield name="shelve" label="Shelve" value="%{product.shelve}" />
				<br />
				<s:textfield name="availables" label="Avaliable"
					value="%{product.availables}" />
				<br />
				<s:textfield name="goodThough" label="Goog Through"
					value="%{product.goodThough}" />
				<br />
				<s:if test="id == 0">
					<s:submit value="Add" action="addNewProduct"/>
				</s:if>
				<s:else>
					<s:submit value="Modify" action="saveModifiedProduct"/>
				</s:else>
			</s:form>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>
