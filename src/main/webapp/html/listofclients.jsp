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

<title>List of clients</title>
</head>
<body>

	<h1>Bienvenue <em><c:out value="${Conseiller.name}"/> <c:out value="${Conseiller.surname}"/></em> !</h1>
	 <h2>Information utilisateur :</h2>
		<ul>
			<li>Login : <c:out value="${Conseiller.login}"/>
			<li>Mot de passe : <c:out value="${Conseiller.password}"/>
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

				<a class="navbar-brand" href="./ProxiBanqueHome.html"> <span
					class=" glyphicon glyphicon-home"></span> ProxiBanque
				</a>

			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="./ConseillerService.html">Conseiller service</a></li>
					<li class="active"><a href="./ListOfClients.html">List of
							clients<span class="sr-only">(current)</span>
					</a></li>
					<li><a href="./UpdateClientInformation.html">Update client</a></li>
					<li><a href="./ListOfClientAccounts.html">Client accounts</a></li>
					<li><a href="./Transfer.html">Transfer from one account to
							another</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><span onclick="history.back()">Return</span></li>
					<li>
						<form action="Logout"
							method="post">
							<input type="submit" value="Logout" />
						</form>
					</li>
				</ul>

			</div>

		</div>
		</nav> </header>

		${sessionScope.conseillerLogin}
		<c:out value="${sessionScope.conseillerLogin}" />
		
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
		
		${sessionScope.conseillerLogin}
</body>

</html>