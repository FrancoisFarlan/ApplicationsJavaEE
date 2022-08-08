<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Mes applications</title>
</head>
<body>

	<%
	
	String resultat = (String) request.getAttribute("resultat");
	String message = (String) request.getAttribute("message");
	String choix = (String) request.getAttribute("choix");
	String choixOpp = (String) request.getAttribute("choixOpp"); 
	%>
    
    <!--Barre de navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
          <a class="navbar-brand" href="../../index.html">Programmes Java EE</a>
          
        </div>
      </nav>

      <!--Titre principal-->
    <h1 class="m-3 text-center display-2">RESULTAT</h1>
    
    <h6 class ="m-3 text-center display-6"><%=resultat%></h6>
    <p class = "m-3 text-center">Vous avez choisi : <%=choix %></p>
    <p class = "m-3 text-center">L'ordinateur a choisi : <%=choixOpp %></p>
    <p class= "mt-5 m-3 text-center"><%=message %></p>
    
    <p class="text-center">
      <a href="<%=request.getContextPath()%>/modules/module3/jeu.jsp" class = "m-3 link-dark">Rejouer</a>
    </p>
    <!--Footer-->
    <footer class="p-3 bg-dark">

        <p class="text-white text-center">Francois Farlan - 2022</p>
    
    </footer>
  

  <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>