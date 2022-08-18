<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.javaee.module6.messages.LecteurMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

    <title>Mes applications</title>
</head>

<body>
<!--Barre de navigation-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.html">Programmes Java EE</a>

    </div>
</nav>

<!--Titre principal-->
<h1 class="m-3 mb-5 text-center display-4">LISTE DE COURSES</h1>

<div class="container mb-5">
    <h2 class="mb-4 text-center">Votre panier <small><c:out value="${listeCourse.nom}"/></small></h2>

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
		
    <div class="row">
        <div class="col-lg-4"></div>
        <c:choose>
	    		<c:when test="${listeCourse.articles.size()>0}">
			        <ul class="list-group col col-lg-4">
			        	<c:forEach var="a" items="${listeCourse.articles}">
				            <li class="list-group-item d-flex justify-content-between align-items-center">
								<div>
									<form action="${pageContext.request.contextPath}/tps/listeCourses/Panier" id="form${a.id}" method="post">
										<label class="custom-control custom-checkbox">
											<input type="hidden" name="id" value="${listeCourse.id}"/>
											<input type="hidden" name="id_article" value="${a.id}"/>
									  		<input type="checkbox" class="custom-control-input" name="coche" onclick="document.forms['form${a.id}'].submit();" ${a.coche?"checked":""}/>
									  	
											  <span class="custom-control-indicator"></span>
											  <span class="custom-control-description">${a.nom}</span>
										</label>
									</form>
								</div>
							</li>
				      	</c:forEach>
			        </ul>
		        </c:when>
		        <c:otherwise>
		        	<p>Pas d'article actuellement.<p>
		        </c:otherwise>
	        </c:choose>
        <div class="col-lg-4"></div>
    </div>

</div>


<div class="row mb-5">

    <div class="text-center col-2 offset-3">
        <a class="btn btn-outline-dark pt-2 pb-1" href="${pageContext.request.contextPath}/tps/listeCourses/AccueilListes" title="Retour à la liste des courses"><span class="material-symbols-rounded">
arrow_back
</span></a>
        </a>
    </div>


    <div class="text-center col-2 offset-2">
        <a class="btn btn-outline-dark pt-2 pb-1" href="${pageContext.request.contextPath}/tps/listeCourses/Panier?id=${listeCourse.id}&clear" title="clear"><span class="material-symbols-outlined">
clear_all
</span></a>
    </div>

</div>

<!--Footer-->
<footer class="p-3 bg-dark">

    <p class="text-white text-center">Francois Farlan - 2022</p>

</footer>c
</body>
</html>