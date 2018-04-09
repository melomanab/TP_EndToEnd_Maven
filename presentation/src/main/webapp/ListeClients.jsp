<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%-- Import necessaire pour introduire du code JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="domaine.Client"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<title>ListeClients.jsp</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="style.css" rel="stylesheet">

</head>
<body>

	<!------------ ### Menu de navigation ### ---------------------->
	<div
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
		<h5 class="my-0 mr-md-auto font-weight-normal">BMO</h5>
		<nav class="my-2 my-md-0 mr-md-3">
			<a class="p-2 text-dark" href="#">Accueil</a> 
			<a class="p-2 text-dark" href="formulaireInscription.html">Inscrivez-vous</a>
			<a class="p-2 text-dark" href="ServletListe">Liste clients</a>

		</nav>
	</div>



	<h1>Ceci est une page .jsp renvoyée par le serveur Tomcat qui
		utilise JSTL</h1>

	<%-- On ne peut pas importer une liste avec JSP
<%
ArrayList<Client> maListe= (ArrayList<Client>)session.getAttribute("list");
for (Client client : maListe) {
	out.println("<p>"+ client + "</p>");
}
%> 
	--%>

	<c:forEach items="${list}" var="client">

			<c:out value="${client.nom}"></c:out>
			<c:out value="${client.prenom}"></c:out>
	
	</c:forEach>
	
		<!---------------- Footer ---------------------->
		<footer class="pt-4 my-md-5 pt-md-5 border-top">
			<div class="row">
				<div class="col-12 col-md ">

					<small class="d-block mb-3 text-muted text-center"> &copy;
						Beatriz 2018</small>
				</div>

			</div>
		</footer>

</body>
</html>