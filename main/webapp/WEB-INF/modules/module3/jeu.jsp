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
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/tps/shifumi/css/style.css">
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
  <h1 class="m-3 text-center display-4">Jeu du Shifumi</h1>
  <p class="m-3 text-center">Vous devez choisir une des 3 propositions : Pierre (Shi), Feuille (Fu) ou Ciseaux (Mi).
    Pour rappel, la pierre l'emporte sur les ciseaux, les ciseaux sur la feuille, et la feuille sur la pierre.</p>


    <form method="post" action="/PresentationApplis/tps/shifumi/ServletTP2">
  <div class="p-4 container-fluid">
    <div class="row justify-content-around">

      
      <div class="position-relative p-3 text-center border m-3 col-sm-6 col-md-4 col-lg-3">
        <label for ="choixSHI" ><h6 class="display-6">SHI</h6> 
        
        <img height="100" width="auto" src="<%=request.getContextPath()%>/tps/shifumi/images/gemme.png" alt="pierre" /></label>
        <input type ="radio" id = "choixSHI" name ="choix" value="PIERRE"/>
      </div>
      <div class="position-relative p-3 text-center border m-3 col-sm-6 col-md-4 col-lg-3">
        <label for ="choixFU" ><h6 class="display-6">FU</h6>
        <img height="100" width="auto" src="<%=request.getContextPath()%>/tps/shifumi/images/feuille.png" alt="feuille" /></label>
        <input type ="radio" id = "choixFU" name ="choix" value="FEUILLE"/>
      </div>
      <div class="position-relative p-3 text-center border m-3 col-sm-6 col-md-4 col-lg-3">
        <label for ="choixMI" ><h6 class="display-6">MI</h6>
        <img height="100" width="auto" src="<%=request.getContextPath()%>/tps/shifumi/images/les-ciseaux.png" alt="ciseaux" /></label>
        <input type ="radio" id = "choixMI" name ="choix" value="CISEAUX"/>
      </div>
      
    </div>
    
  </div>
  <div class="text-center">
  <input class="m-4 ps-5 pe-5 btn btn-outline-dark" type="submit" value="Valider">
  </div>
</form>



 

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