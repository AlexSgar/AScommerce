<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home</title>
</head>
<body>
	<f:view>
		<h1>AScommerce</h1>
			<h:form>
				<h:commandLink  action="/newProduct.jsp" value="Inserisci un nuovo prodotto"> </h:commandLink>
			</h:form>
	</f:view>
</body>
</html>

