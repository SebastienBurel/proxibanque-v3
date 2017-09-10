<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="fr.gtm.projetwebservice.domaine.Conseiller" %>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="../js/ListOfClients.js"></script>

<title>ProxiBanque Web Static</title>

<script>

  let findClientById = function(clients){

    let url = new URL(window.location.href);
    let userId = url.searchParams.get("id");
    let userFound = false;
    let i = 0;
    let client = null;

    while (userFound === false && i < clients.length) {

      client = clients[i];
      if(client.id == userId){
        userFound = true;
      }
      i++;
    }

    if(userFound == true){
      let firstNameInput = document.getElementById("firstnameId").value = client.prenom;
      let lastNameInput = document.getElementById("lastnameId").value = client.nom;
      let emailInput = document.getElementById("email").value = client.email;
      let adresseInput = document.getElementById("adresse").value = client.adresse;
    }
    else{
      window.alert("User with id:" + userId + " not found.");
    }


    console.log(client);

  }
  getListOfClients(findClientById);

</script>
</head>
<body>
	<h1>Bienvenue <em><c:out value="${Conseiller.name}"/> <c:out value="${Conseiller.surname}"/></em> !</h1>
	 <h2>Votre information :</h2>
		<ul>
			<li>Numero Identifiant : <c:out value="${Conseiller.idConseiller}"/>
			
		</ul>
  <div class="container-fluid">
    <header>

      <nav class="navbar navbar-inverse bg-primary">
        <div class="container-fluid">

          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>

            <a class="navbar-brand" href="/proxibanquev3/index.jsp">
              <span class=" glyphicon glyphicon-home"></span>
              ProxiBanque
            </a>

          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li><a href="/proxibanquev3/html/ConseillerService.jsp">Conseiller service</a></li>
              <li><a href="/proxibanquev3/html/listofclients.jsp">List of clients</a></li>
              <li class="active"><a href="/proxibanquev3/html/UpdateClientInformation.jsp">Update client<span class="sr-only">(current)</span></a></li>
              <li><a href="/proxibanquev3/html/ListOfClientAccounts.jsp">Client accounts</a></li>
              <li><a href="/proxibanquev3/html/Transfer.jsp">Transfer from one account to another</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
              <li><span onclick="history.back()">Return</span></li>
            </ul>

          </div>

        </div>
      </nav>
    </header>
    <form>
    
      <h3>Update client's information</h3>
		<div class="form-group row">
		  <label for="example-text-input" class="col-sm-1 col-form-label">Nom</label>
		  <div class="col-sm-4">
		    <input class="form-control" type="text" value="Last Name" id="lastnameId">
		  </div>
		</div>
		<div class="form-group row">
		  <label for="example-text-input" class="col-sm-1 col-form-label">Prenom</label>
		  <div class="col-sm-4">
		    <input class="form-control" type="search" value="First Name" id="firstnameId">
		  </div>
		</div>
		<div class="form-group row">
		  <label for="example-email-input" class="col-sm-1 col-form-label">Email</label>
		  <div class="col-sm-4">
		    <input class="form-control" type="email" value="username@example.com" id="email">
		  </div>
		</div>
		<div class="form-group row">
		  <label for="example-text-input" class="col-sm-1 col-form-label">Adresse</label>
		  <div class="col-sm-4">
		    <input class="form-control" type="adresse" value="Adresse" id="adresse">
		  </div>
		</div>

        	
      	<input type="submit" value="Submit">
      </form>

</body>
</html>
