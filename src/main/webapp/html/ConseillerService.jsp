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

      <nav class="navbar navbar-inverse bg-primary bg-faded">
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
              <li class="active"><a href="/proxibanquev3/html/ConseillerService.jsp">Conseiller service<span class="sr-only">(current)</span></a></li>
              <li><a href="/proxibanquev3/html/ListOfClients.jsp">List of clients</a></li>
              <li><a href="/proxibanquev3/html/UpdateClientInformation.jsp">Update Client</a></li>
              <li><a href="/proxibanquev3/html/ListOfClientAccounts.jsp">Client Accounts</a></li>
              <li><a href="/proxibanquev3/html/Transfer.jsp">Transfer from one account to another</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
              <li><span onclick="history.back()">Return</span></li>
            </ul>

          </div>

        </div>
      </nav>
    </header>
<nav>
  <ul>
    <li><h4><a href="/proxibanquev3/html/ListOfClients.jsp">List of Clients</a></h4></li>
    <li><h4><a href="/proxibanquev3/html/UpdateClientInformation.jsp">Update Client</a></h4></li>
    <li><h4><a href="/proxibanquev3/html/ListOfClientAccounts.jsp">Client Accounts</a></h4></li>
    <li><h4><a href="/proxibanquev3/html/Transfer.jsp">Transfer from one account to another</a></h4></li>
  </ul>
</nav>

</body>
</html>
