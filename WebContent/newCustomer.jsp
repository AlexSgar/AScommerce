<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Registrazione</title>
</head>
<body>
	<f:view>
		<h:form>
    		<div>Nome: <h:inputText value="#{customerController.name}" 
                     required="true"
                     requiredMessage="Il nome e' obbligatorio"
                     id="name"/> <h:message for="name" />
			</div>
    		<div>Cognome: <h:inputText value="#{customerController.surname}" 
                     required="true"
                     requiredMessage="Il cognome e' obbligatorio"
                     id="surname"/> <h:message for="surname" />
			</div>
    		<div>Data di Nascita: <h:inputText value="#{customerController.dateOfBirth}" 
                     required="true"
                     requiredMessage="La data di nascita e' obbligatoria"
                     id="date"/> <h:message for="date" />
			</div>
    		<div>Email: <h:inputTextarea value="#{customerController.email}" 
    				required="true"
    				requiredMessage="L'email e' obbligatoria"
                    id="email"/> <h:message for="email" />            
			</div>
			<div>
				<h:commandButton value="Submit"  action="#{customerController.signUp}"/>
			</div>
			
		</h:form>
	</f:view>
</body>
</html>