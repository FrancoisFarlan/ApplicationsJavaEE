<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.eni.javaee.module6.messages.LecteurMessage"%>
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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/default.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<title>Mes applications</title>
</head>
<body>

	<!--Barre de navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/index.html">Programmes Java
				EE</a>

		</div>
	</nav>

	<!--Titre principal-->
	<h1 class="m-3 mb-5 text-center display-4">LISTE DE COURSES</h1>

	<div class="container mb-5">
		<h2 class="mb-4 text-center">Nouvelle liste</h2>

		<c:if test="${!empty listeCodesErreur}">
			<div class="alert alert-danger" role="alert">
				<strong>Erreur!</strong>
				<ul>
					<c:forEach var="code" items="${listeCodesErreur}">
						<li>${LecteurMessage.getMessageErreur(code)}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/nouvelle"
			method="post" class="row justify-content-center mb-2">
			<label for="nom_liste" class="col-2 col-form-label">Nom :</label>
			<div class="col-10">
				<c:if test="${ empty listeCourse}">
					<input class="form-control" type="text" id="nom_liste"
						name="nom_liste" value="${param.nom_liste}">
				</c:if>
				<c:if test="${ !empty listeCourse}">
					<p>${listeCourse.nom}</p>
				</c:if>
			</div>



			<div class="row">
				<ul class="list-group col-12">
					<c:if test="${ !empty listeCourse}">
						<input type="hidden" value="${listeCourse.id}" name="id" />
					</c:if>
					<c:choose>
						<c:when test="${listeCourse.articles.size()>0}">

							<c:forEach var="a" items="${listeCourse.articles}">
								<li
									class="list-group-item d-flex justify-content-between align-items-center"><c:out
										value="${a.nom }" />
									<div>
										<a
											href="${pageContext.request.contextPath}/supprimer?id=${listeCourse.id}&id_article=${a.id}"
											class="badge text-danger" title="Supprimer"><i
											class="material-icons">delete</i></a>
									</div></li>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<p class="mt-4">Pas d'article actuellement.
							<p>
						</c:otherwise>
					</c:choose>
					<li
						class="mt-3 d-flex justify-content-between align-items-center">
						<input class="form-control me-3" type="text" id="nom_article"
						name="nom_article"
						value="${!empty listeCodesErreur?param.nom_article:''}">
						<div>
							<input type="submit" class="btn btn-primary"></input> <a
								href="#add" class="badge text-success" title="Ajouter"></a>
						</div>
					</li>
				</ul>
			</div>
		</form>
	</div>

	<div class="col-lg-4 offset-lg-4 text-center mb-5">
		<a class="btn btn-outline-dark pt-2 pb-1" href="${pageContext.request.contextPath}/tps/listeCourses/AccueilListes"
			title="Retour à la liste des courses"><span
			class="material-symbols-rounded"> arrow_back </span></a>
	</div>

	<!--Footer-->
	<footer class="p-3 bg-dark">

		<p class="text-white text-center">Francois Farlan - 2022</p>

	</footer>
</body>
</html>