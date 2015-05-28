<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Log In </title>
</head>
<body>
	<f:view>
	<h:form>
		<div>Email: <h:inputText value="#{aScommerceController.email}"
		required="true"
		requiredMessage="Campo obbligatorio"
		id="email"/><h:message for="email"/>
		</div>
		<div>Password: <h:inputSecret value = "#{aScommerceController.password}"
		required="true"
		requiredMessage="Campo obbligatorio"
		id="passw"/><h:message for="passw"/>
		<h:commandButton value ="LogIn" action="#{aScommerceController.logIn}"/>
	</h:form>
	</f:view>
</body>
</html>