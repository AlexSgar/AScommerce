<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Prodotto</title>
</head>
<body>
	<f:view>
		<h1>Prodotto Inserito</h1>
		<h2>${productController.product.name}</h2>
		<h3>Dettagli</h3>
		<div>Codice: ${productController.product.code}</div>
		<div>Prezzo: ${productController.product.price}</div>
		<div>Descrizione: ${productController.product.description}</div>
		<div>Quantita' disponibile: ${productController.product.quantityAvaiable}</div>
		
		<br/>
			<h:form>
			<div>Quantita' : <h:inputText value="#{orderController.quantity}"></h:inputText>
			<h:commandButton value ="Acquista" action="#{orderController.addProduct}"></h:commandButton></div>
			</h:form>
		
		<h:form>
			<h:commandLink  value="Torna al catalogo prodotti" action="#{productController.showProducts}" >
			</h:commandLink> 
			
		</h:form>
	</f:view>
</body>
</html>