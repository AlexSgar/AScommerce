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
    		<div>Nome: <h:inputText value="#{aScommerceController.name }" 
                     required="true"
                     requiredMessage="Il nome e' obbligatorio"
                     id="name"/> <h:message for="name" />
			</div>
    		<div>Cognome: <h:inputText value="#{aScommerceController.surname}" 
                     required="true"
                     requiredMessage="Il cognome e' obbligatorio"
                     id="surname"/> <h:message for="surname" />
			</div>
			<div>Password: <h:inputSecret value="#{aScommerceController.password}" 
                     required="true"
                     requiredMessage="La password e' obbligatoria"
                     id="pass"/> <h:message for="pass" />
			</div>
			<div>Email: <h:inputText value="#{aScommerceController.email}" 
    				required="true"
    				requiredMessage="L'email e' obbligatoria"
                    id="email"/> <h:message for="email" />            
			</div>
    		<div>Data di Nascita: <h:inputText value="#{aScommerceController.dateOfBirth}" 
                     required="true"
                     requiredMessage="La data di nascita e' obbligatoria"
                     id="date"/> <h:message for="date" />
			</div>
			
			
			<p>Indirizzo</p>
			<div>Via: <h:inputText value="#{aScommerceController.street}" 
    				required="true"
    				requiredMessage="L'indirizzo e' obbligatorio"
                    id="street"/> <h:message for="street" />            
			
			 Cap: <h:inputText value="#{aScommerceController.zipcode}" 
    				required="true"
    				requiredMessage="Il cap e' obbligatori"
                    id="zipcode"/> <h:message for="zipcode" />  
             </div>                 
			<div>Citta': <h:inputText value="#{aScommerceController.city}" 
    				required="true"
    				requiredMessage="La citta' e' obbligatoria"
                    id="city"/> <h:message for="city" />            
			
				Provincia: <h:inputText value="#{aScommerceController.state}" 
    				required="true"
    				requiredMessage="La provincia e' obbligatoria"
                    id="state"/> <h:message for="state" />            
			
				Nazione: <h:inputText value="#{aScommerceController.country}" 
    				required="true"
    				requiredMessage="La nazione e' obbligatoria"
                    id="country"/> <h:message for="country" />            
			</div>
    		
			<div>
				<h:commandButton value="Submit"  action="#{aScommerceController.signUp}"/>
			</div>
		</h:form>
	</f:view> 
</body>
</html>