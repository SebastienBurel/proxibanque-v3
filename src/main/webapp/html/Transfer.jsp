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
<script type="text/javascript" src="ListOfClients.js"></script>

<script>

var compte1 = document.getElementById("soldeCompte1");
compte1.style.display="block";
var compte2 = document.getElementById("soldeCompte2");
compte2.style.display="block";

var num1 = document.getElementById("idCompte1").value;
var num2 = document.getElementById("idCompte2").value;
var amount = document.getElementById("montant").value;


function Compte(id=0,solde=0){
	let compte = {};
	compte.id = id ;
	compte.solde = solde ;
	return compte;
}
function virement(c1,c2,amount){
	c1.solde -= amount ;
	c2.solde += amount ;
}
function transfer(){
	c1 = new Compte(num1,2000);
	c2 = new Compte(num2,4000);
	virement(c1,c2,amount);
	compte1.innerHTML = "compte numéro "+c1.id +" > solde = "+ c1.solde ;
	compte2.innerHTML = "compte numéro "+c2.id +" > solde = "+ c2.solde ;
}
</script>

<title>Proxi Banque Web Static</title>
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
              <li><a href="/proxibanquev3/html/listOfclients.jsp">List of clients</a></li>
              <li><a href="/proxibanquev3/html/UpdateClientInformation.jsp">Update client</a></li>
              <li><a href="/proxibanquev3/html/ListOfClientAccounts.jsp">Client accounts</a></li>
              <li class="active"><a href="/proxibanquev3/html/Transfer.jsp">Transfer from one account to another<span class="sr-only">(current)</span></a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
              <li><span onclick="history.back()">Return</span></li>
            </ul>

          </div>

        </div>
      </nav>
    </header>
 
			<form>
			
			  <div class="form-group">
			    <label for="idCompte1">Account number 1 :</label>
			    <input type="number" class="form-control" id="idCompte1">
			  </div>
			  
			  <div class="form-group">
			    <label for="idCompte2">Account number 2 :</label>
			    <input type="number" class="form-control" id="idCompte2">
			  </div>
			  
			  <div class="form-group">
			    <label for="amount">Amount :</label>
			    <input type="number" class="form-control" id="amount">
			  </div>
			  
			  <input type="button" onclick="transfer();" class="btn btn-success" value="Transfer">
			</form> 
			<br/>
			<br/>
			<br/>
			<div id="soldeCompte1"  class="alert alert-success" style="display:none"></div>
			<div id="soldeCompte2"  class="alert alert-success" style="display:none"></div>
			
		</div>
	
	</div>
	
</body>
</html>
