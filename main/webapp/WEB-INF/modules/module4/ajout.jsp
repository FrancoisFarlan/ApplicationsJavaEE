<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.List" %>
 <%@page import="fr.eni.javaee.module4.messages.LecteurMessage"%>
    
<!DOCTYPE html>
<html lang="fr">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
  <title>Mes applications</title>
</head>
<body>
<!--Barre de navigation-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%=request.getContextPath()%>/index.html">Programmes Java EE</a>

  </div>
</nav>

<h1 class="display-6 m-3 text-center">AJOUT</h1>


<%
List<Integer> listeErreurs = (List<Integer>)request.getAttribute("listeErreurs");
if(listeErreurs!=null) {
%>

<div class="erreur container bg-danger p-3 mb-3">

<p class="text-center mb-0">Erreur, le repas n'a pas pu être ajouté :</p>
	<%
			for(int codeErreur:listeErreurs)
			{
	%>
				<p class="text-center mb-0"><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
	<%	
			}
		
	%>
</div>

<%
}
%>

<div class="container">
  <form action="<%=request.getContextPath()%>/tps/suiviRepas/ServletAjoutRepas" method="post">
    <div class="mb-3 saisie">
      <label class="form-label" for="date">Date : </label>
      <input class="form-control" id="date" type="date" name="date" type="date" value="<%=listeErreurs!=null?request.getParameter("date"):""%>"/>
    </div>
    <div class="mb-3 saisie">
      <label class="form-label" for="heure">Heure : </label>
      <input class="form-control" id="heure" type="time" name="heure" value="<%=listeErreurs!=null?request.getParameter("heure"):""%>"/>
    </div>
    <div class="mb-3 saisie">
      <label class="form-label" for="repas">Repas : </label>
      <textarea class="form-control" rows="5" cols="30" id="repas" name="repas" ><%=listeErreurs!=null?request.getParameter("repas"):""%></textarea>
    </div>

    <div class="mt-4 mb-4 text-center">
      <button class="me-3 btn btn-outline-dark" type="submit">Valider</button>
      <a href="<%=request.getContextPath()%>/modules/module4/accueil.jsp"><button class="me-3 btn btn-outline-dark" type="button">Annuler</button></a>
    </div>
  </form>

</div>
<!--Footer-->
<footer class="p-3 bg-dark">

  <p class="text-white text-center">Francois Farlan - 2022</p>

</footer>


<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>