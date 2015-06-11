<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Tuoi Ordini</title>
</head>
<body>
	<f:view>
		<h1>Ecco i tuoi ordini effettuati</h1>
		<h:form>
			<table>
				<c:forEach var="order" items="#{orderController.getAllOrders()}">
					<tr>
						<th>Data Creazione</th>
						<th>Data Evasione</th>
					</tr>
					<tr>
						<td><h:commandLink value="#{order.creationTime}"
								action="#{orderController.findOrder}">
								<f:param name="id" value="#{order.id}"></f:param>
							</h:commandLink></td>
						<td>${order.fulfilTime}</td>
					</tr>

				</c:forEach>
			</table>

		</h:form>
		<br />
		<h:form>
			<h:commandLink value="Torna alla home" action="/home.jsp">
			</h:commandLink>
		</h:form>
	</f:view>
</body>
</html>