<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Inserimento Prodotto</title>
</head>
<body>
	<f:view>
		<h1>Ecco i prodotti acquistati </h1>
		
			<table>
			<tr><th>Nome</th><th>Prezzo</th><th>Quantita'</th> </tr>
			<c:forEach var="orderLine" items="#{orderController.getOrderLines()}">
			<tr> <td> ${orderLine.product.name}
				</td>
				<td>${orderLine.unitPrice}</td>
				<td>${orderLine.quantity}</td>
			</tr>
			</c:forEach>
			</table>
		<br/>
		
		<h:form>
			<div><h:commandLink value="Visualizza i tuoi Ordini" action="#{orderController.showOrders}" > </h:commandLink></div>
			<div><h:commandLink  value="Torna alla Home" action="/home.jsp" ></h:commandLink></div>
		</h:form>
	</f:view>
</body>
</html>