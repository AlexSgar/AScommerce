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
		<h:form>
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
		</h:form>
		<br/>
		<h:form>
		<h:commandLink  value="Torna alla home" action="/home.jsp" >
			</h:commandLink>
		</h:form>
	</f:view>
</body>
</html>