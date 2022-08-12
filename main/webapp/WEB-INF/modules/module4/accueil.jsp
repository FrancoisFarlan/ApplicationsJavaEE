<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<!--Titre principal-->
<h1 class="m-3 text-center display-4">SUIVI DES REPAS</h1>

<div class="mt-4 mb-4 text-center container">
<a href="<%=request.getContextPath()%>/tps/suiviRepas/ServletAjoutRepas"> <button type="button" class="btn btn-outline-dark">Ajouter un nouveau repas</button> </a>
</div>

<div class="mt-4 mb-4 text-center container">
  <a href="<%=request.getContextPath()%>/tps/suiviRepas/ServletVisualiserRepas"> <button type="button" class="btn btn-outline-dark">Visualiser les repas</button> </a>
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