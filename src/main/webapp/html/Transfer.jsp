<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="fr.gtm.projetwebservice.domaine.Conseiller" %>
<%@ page import="fr.gtm.projetwebservice.domaine.Compte" %>
<%@ page import="fr.gtm.projetwebservice.service.ConseillerService" %>
<%@ page import="fr.gtm.projetwebservice.domaine.ResultatVirement" %>

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

function TransferMoney() {
	
	
	let table="<tr><th>Numero de compte</th><th>Solde avant operation</th><th>solde apres operation</th></tr>";

	table += "<tr><td>" +				   
	idNumberCredit + "</td><td>" +
	r.balanceCredit + "</td><td>" +
	r.newBalanceCredit + "</td><td>" ;
						

	table += "<tr><td>" +				   
	idNumberDebit + "</td><td>" +
	r.balanceDebit + "</td><td>" +
	r.newBalanceDebit + "</td><td>" ;
							

	let elementDiv = document.getElementById("divResultat2");
	elementDiv.innerHTML = table;
	elementDiv.style.display = "block";
	
	
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
 
			<form method = "POST" action="/presentation/ServletMoneyTransfert">
			
			  <div class="form-group">
			    <label for="idCompte1">Account to Credit :</label>
			    <input type="number" class="form-control" id="idCompte1" name="idCredit">
			  </div>
			  
			  <div class="form-group">
			    <label for="idCompte2">Account to Debit :</label>
			    <input type="number" class="form-control" id="idCompte2" name="idDebit">
			  </div>
			  
			  <div class="form-group">
			    <label for="amount">Amount :</label>
			    <input type="number" class="form-control" id="amount" name="amount">
			  </div>
			  
			  <input type="submit" class="btn btn-success" value="Transfer">
			</form> 
			<br/>
			<br/>
			<br/>
			<div id="soldeCompte1"  class="alert alert-success" style="display:none">
			<%
			Compte compteC = (Compte) session.getAttribute("CompteCredit");
			Compte compteD = (Compte) session.getAttribute("CompteDebit");
			
			ConseillerService conseillerService = new ConseillerService();
			int idNumberCredit = compteC.getIdNumber();
			int idNumberDebit = compteD.getIdNumber();
			double amount =  compteC.getAmount();
			//ResultatVirement r = conseillerService.moneyTransfer(idNumberCredit, idNumberDebit, (float) amount);
			
			
		
			%>
			
			</div>
			<div id="divResultat2" class="alert alert-success"
				style="display: none"></div>
			<div id="soldeCompte2"  class="alert alert-success" style="display:none"></div>
			
		</div>
	
	</div>
	
</body>
</html>
