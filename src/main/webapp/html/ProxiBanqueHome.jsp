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
              <li style="display: none" id="cache1"><a href="/proxibanquev3/html/ConseillerService.html">Conseiller service</a></li>
              <li style="display: none" id="cache2"><a href="/proxibanquev3/html/listofclients.jsp">List of clients</a></li>
              <li style="display: none" id="cache3"><a href="/proxibanquev3/html/UpdateClientInformation.html">Update client</a></li>
              <li style="display: none" id="cache4"><a href="/proxibanquev3/html/ListOfClientAccounts.html">Client accounts</a></li>
              <li style="display: none" id="cache5"><a href="/proxibanquev3/html/Transfer.html">Transfer from one account to another</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
              <li><span onclick="history.back()">Return</span></li>
            </ul>

          </div>

        </div>
     </nav>
   </header>
   
 <article>
 <div class="jumbotron">
  <h1 class="display-3" align="center">Welcome to ProxiBanque!</h1>
</div>

  <table style="width:55%" align="right">
	<tr>
		<td><h4><a href="/proxibanquev3/Authentification.jsp">Authentification Conseiller</a></h4></td>
	</tr>
		
</table>
</article>
   
        

</body>
</html>
