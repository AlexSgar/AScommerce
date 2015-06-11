<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>AScommerce</title>
</head>
<body>
		<h1>Benvenuti in AScommerce</h1>
	<f:view>
		<h:form>
			<div><h:commandLink value="LogIn" action="#{aScommerceController.logIn}"></h:commandLink></div>
			<div><h:commandLink value="SignUp" action="#{aScommerceController.signUp}"></h:commandLink></div>
			<br/>
			<div><h:commandLink value="Catalogo Prodotti" actions="#{productController.showProducts}"></h:commandLink>
			</div>
		</h:form>
	</f:view>
</body>
</html>