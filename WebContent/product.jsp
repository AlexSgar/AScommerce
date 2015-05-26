<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Prodotto Inserito</title>
</head>
<body>
	<f:view>
		<h1>${productController.product.name}</h1>
		<h2>Dettagli</h2>
		<div>Codice: ${productController.product.code}</div>
		<div>Prezzo: ${productController.product.price}</div>
		<div>Descrizione: ${productController.product.description}</div>
		<div>Quantita' disponibile: ${productController.product.quantityAvaiable}</div>
	</f:view>
</body>
</html>