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
	<h1> Benvenuti in AScommerce </h1>
	<f:view>
		<div><h2>${aScommerceController.getCurrentCustomer().name}
				${aScommerceController.getCurrentCustomer().surname}</h2>
		
		</div>
		<h:form>
			<h:commandLink value = "Lista Prodotti" action="#{productController.showProducts}"></h:commandLink>
		</h:form>
	</f:view>
</body>
</html>