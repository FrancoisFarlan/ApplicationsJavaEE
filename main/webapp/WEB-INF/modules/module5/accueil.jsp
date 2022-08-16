<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<%
	String couleur="noir";
	if(session.getAttribute("couleurPreferee")!=null)
	{
		couleur=(String)session.getAttribute("couleurPreferee");
	}
%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/<%=couleur%>.css">
<title>Mes applications</title>
</head>

<body>

	<!--Barre de navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="<%=request.getContextPath()%>/index.html">Programmes Java
				EE</a>

		</div>
	</nav>

	<!--Titre principal-->
	<h1 class="m-3 text-center display-4">PREFERENCES D'USAGE</h1>

	<div class="container mt-5 mb-5">
		<form action="<%=request.getContextPath()%>/tps/preferencesUsage/ServletGestionPreference"
			method="post">
			<%
			List<String> couleurs = (List<String>) application.getAttribute("couleurs");
			%>
			<div class="mb-3">
				<label class="form-label mb-3" for="couleur-police"> &nbsp;
					Quelle couleur de police préférez-vous ?</label> <select
					class="form-select" id="couleur-police" name="couleurChoisie">
					<%
					for (String couleurDisponible : couleurs) {
					%>
					<option value="<%=couleurDisponible%>"
						<%=couleurDisponible.equalsIgnoreCase(couleur) ? "selected" : ""%>><%=couleurDisponible%></option>
					<%
					}
					%>
				</select>

			</div>
			<div class="mt-5 mb-4 text-center container">
				<button type="submit" class="btn btn-outline-dark">Valider
					les préférences</button>
			</div>

		</form>
	</div>

<%
		Cookie cookieNbAcCookie = (Cookie)request.getAttribute("cookieNbAcces");
	%>
	
	<div class="container mt-5 mb-5 text-center">
		<p>
		Depuis que vous avez démarré cette application, vous êtes venu <%=cookieNbAcCookie.getValue()%> fois sur cette page.
	</p>
	</div>

	<!--Footer-->
	<footer class="p-3 bg-dark">

		<p class="text-white text-center">Francois Farlan - 2022</p>

	</footer>


	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>

</html>