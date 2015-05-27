<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Lista di Prodotti</title>
</head>
<body>
	<f:view>
		<h1>Ecco i prodotti nel catalogo </h1>
		<h:form>
			<table>
			<tr><th>Nome</th><th>Codice</th><th>Prezzo</th><th>Descrizione</th><th>Quantita' Disponibile</th> </tr>
			<c:forEach var="product" items="#{productController.products}">
			<tr> <td><h:commandLink action= "#{productController.findProduct}" value="#{product.name}">
					<f:param name="id" value="#{product.id}" />
					</h:commandLink>
				</td>
				<td>${product.code}</td>
				<td>${product.price}</td>
				<td>${product.description}</td>
				<td>${product.quantityAvaiable}</td>
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