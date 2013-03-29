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
	<s:form action="userGreeting">
		<s:textfield label="Nombre" name="userName"/>
		<s:textfield label="Numero de la suerte" name="luckyNumber"/>
		<s:submit value="Enviar"/>
	</s:form>
</body>
</html>