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
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
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
<h1 class="m-3 mb-5 text-center display-4">LISTE DE COURSES</h1>

<div class="container mb-5">
    <h2 class="mb-4 text-center">Listes prédéfinies</h2>

    <div class="row ms-3 me-1">
        <ul class="list-group col-12">
            <li class="list-group-item d-flex justify-content-between align-items-center">Liste bio
                <div>
                    <a href="panier.html" class="badge text-primary" title="Commencer ses courses"><i class="material-icons">shopping_cart</i></a>
                    <a href="#supprimer" class="badge text-danger" title="Supprimer"><i class="material-icons">delete</i></a>
                </div>

            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">Liste grande surface
                <div>
                    <a href="panier.html" class="badge text-primary" title="Commencer ses courses"><i class="material-icons">shopping_cart</i></a>
                    <a href="#supprimer" class="badge text-danger" title="Supprimer"><i class="material-icons">delete</i></a>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">Liste surgelés
                <div>
                    <a href="panier.html" class="badge text-primary" title="Commencer ses courses"><i class="material-icons">shopping_cart</i></a>
                    <a href="#supprimer" class="badge text-danger" title="Supprimer"><i class="material-icons">delete</i></a>
                </div>
            </li>
        </ul>
    </div>
</div>

<div class="col-lg-4 offset-lg-4 text-center mb-5">
    <a class="btn btn-outline-dark pt-2 pb-1" href="nouvelle_liste.html" title="Créer une nouvelle liste"><span class="material-symbols-outlined">
add
</span></a>
</div>

    <!--Footer-->
    <footer class="p-3 bg-dark">

        <p class="text-white text-center">Francois Farlan - 2022</p>

    </footer>
</body>
</html>