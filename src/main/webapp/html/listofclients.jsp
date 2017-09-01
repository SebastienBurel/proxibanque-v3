<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="fr.gtm.projetwebservice.domaine.Conseiller" %>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="../js/ListOfClients.js"></script>
<script>
  let buildList = function(clients){

		let tableBody = "";

		for(let i=0; i < clients.length; i++){
			let client = clients[i];
			tableBody += "<tr><td>" + client.nom +
			"</td><td>" + client.prenom + "</td><td>" +
			client.email + "</td><td>" + client.adresse +
			"</td>" +
      "<td><a href=\"UpdateClientInformation.jsp?id="+client.id+"\"><span class=\"glyphicon glyphicon-edit\"> Update </span></a>"+
      " | <a href=\"listOfClientAccounts.jsp?id="+client.id+"\"><span class=\"glyphicon glyphicon-euro\"> Comptes</span></a>"+
      "</td></tr>";
		}
		let elementDiv = document.getElementById("tableListOfClientsBody");
		elementDiv.innerHTML = tableBody;

		console.log(tableBody);
}
  getListOfClients(buildList);
</script>

<title>List of clients</title>
</head>
<body>

	<h1>Bienvenue <em><c:out value="${Conseiller.name}"/> <c:out value="${Conseiller.surname}"/></em> !</h1>
	 <h2>Votre information :</h2>
		<ul>
			<li>Numero Identifiant : <c:out value="${Conseiller.idConseiller}"/>
			
		</ul>
	<div class="container-fluid">
		<header> <nav class="navbar navbar-inverse bg-primary">
		<div class="container-fluid">

			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="/proxibanquev3/index.jsp"> <span
					class=" glyphicon glyphicon-home"></span> ProxiBanque
				</a>

			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="/proxibanquev3/html/ConseillerService.jsp">Conseiller service</a></li>
					<li class="active"><a href="/proxibanquev3/html/listOfclients.jsp">List of
							clients<span class="sr-only">(current)</span>
					</a></li>
					<li><a href="/proxibanquev3/html/UpdateClientInformation.jsp">Update client</a></li>
					<li><a href="/proxibanquev3/html/ListOfClientAccounts.jsp">Client accounts</a></li>
					<li><a href="/proxibanquev3/html/Transfer.jsp">Transfer from one account to
							another</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><span onclick="history.back()">Return</span></li>
					<li>
						<form class="nav navbar-nav navbar"action="Logout"
							method="post">
							<input type="submit" value="Logout" />
						</form>
					</li>
				</ul>

			</div>

		</div>
		</nav> </header>

		
		
		<table class="table table-striped">
			<tr>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Email</th>
				<th>Adresse</th>
				<th>Actions</th>
			</tr>
			<tbody id="tableListOfClientsBody">

			</tbody>
		</table>
		
		
</body>

</html>