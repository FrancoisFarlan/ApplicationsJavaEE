<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.eni.javaee.module4.bo.Repas"%>
<%@page import="fr.eni.javaee.module4.bo.Aliment"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
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

	<h1 class="display-6 m-3 text-center">HISTORIQUE</h1>

	<%
	List<Repas> listeRepas = (List<Repas>) request.getAttribute("listeRepas");
	%>
	<%
	if (listeRepas.size() > 0) {
	%>
	<div class="container">
		<table class="mb-5 mt-5 table table-striped">
			<thead>

				<tr>
					<th scope="col">#</th>
					<th scope="col">Date</th>
					<th scope="col">Heure</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Repas repas : listeRepas) {
				%>

				<tr>
					<th scope="row"><%=repas.getId_repas()%></th>
					<td><%=repas.getDate()%></td>
					<td><%=repas.getTime()%></td>
					<td><a class="link-dark"
						href="<%=request.getContextPath()%>/tps/suiviRepas/ServletVisualiserRepas?detail=<%=repas.getId_repas()%>">
							détail</a></td>

				</tr>

				<%
				if (String.valueOf(repas.getId_repas()).equals(request.getParameter("detail"))) {
				%>
				<tr>

					<td colspan="4">
						<ul>
							<%
							for (Aliment aliment : repas.getAliments()) {
							%>
							<li><%=aliment.getNomAliment()%></li>
							<%
							}
							%>
						</ul>
					</td>
				</tr>

				<%
				}
				}
				%>
			</tbody>

		</table>
	</div>
	<%
	}
	%>

	<div class="mt-4 mb-4 text-center container">
		<a
			href="<%=request.getContextPath()%>/tps/suiviRepas/ServletAjoutRepas">
			<button type="button" class="me-3 btn btn-outline-dark">Ajouter
				un nouveau repas</button></a>
				
				<a href="<%=request.getContextPath()%>/modules/module4/accueil.jsp">
			<button type="button" class="ms-3 btn btn-outline-dark">Retour
				à l'accueil</button>
		</a>
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