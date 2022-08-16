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
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
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
    <h2 class="mb-4 text-center">Votre panier <small>Liste Bio</small></h2>

    <div class="row">
        <div class="col-lg-4"></div>
        <ul class="list-group col col-lg-4">
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <div>
                    <form action="" method="get" id="form1">
                        <label class="custom-control custom-checkbox">
                            <input type="hidden" name="id" value="1"/>
                            <input type="hidden" name="id_article" value="3"/>
                            <input type="checkbox" name="coche" class="custom-control-input"
                                   onclick="document.getElementById('form1').submit();">
                            <span class="custom-control-indicator"></span>
                            <span class="custom-control-description">Article A</span>
                        </label>
                    </form>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <div>
                    <label class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input">
                        <span class="custom-control-indicator"></span>
                        <span class="custom-control-description">Article B</span>
                    </label>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <div>
                    <label class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input">
                        <span class="custom-control-indicator"></span>
                        <span class="custom-control-description">Article C</span>
                    </label>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <div>
                    <label class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input">
                        <span class="custom-control-indicator"></span>
                        <span class="custom-control-description">Article D</span>
                    </label>
                </div>
            </li>
        </ul>
        <div class="col-lg-4"></div>
    </div>

</div>


<div class="row mb-5">

    <div class="text-center col-2 offset-3">
        <a class="btn btn-outline-dark pt-2 pb-1" href="listes.html" title="Retour à la liste des courses"><span class="material-symbols-rounded">
arrow_back
</span></a>
        </a>
    </div>


    <div class="text-center col-2 offset-2">
        <a class="btn btn-outline-dark pt-2 pb-1" href="panier.html" title="clear"><span class="material-symbols-outlined">
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