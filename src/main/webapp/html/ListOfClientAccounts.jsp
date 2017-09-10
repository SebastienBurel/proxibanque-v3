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
<script>

  let getAccounts = function(clients){

    let url = new URL(window.location.href);
    let clientId = url.searchParams.get("id");
    let clientFound = false;
    let client = null;
    
    for(let i=0;i<clients.length; ++i){
    	
    	client = clients[i];
    	if(client.id == clientId){
    		clientFound = true;
    		clientToUse = client;
    	}
    }
  
    
    let tableBody = "";
    
    if(clientFound){
        for(i=0;i<clientToUse.accounts.length; ++i){
        	let account = clientToUse.accounts[i];

        	console.log(i + ": " + JSON.stringify(account));
        
      		tableBody += "<tr><td>" + account.numberOfAccount +
      		"</td><td>" + account.typeOfAccount +"</td><td>" + account.solde +
    		"</td></tr>";
    	}
        let elementDiv = document.getElementById("tableListOfAccountsBody");
		elementDiv.innerHTML = tableBody;

		console.log(tableBody);
    } 
    else {
    	 window.alert("Error! Client not found!")}
     }
  
  getListOfClients(getAccounts);

</script>

<title>ProxiBanque Web Static</title>
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
              <li><a href="/proxibanquev3/html/UpdateClientInformation.jsp">Update client<span class="sr-only">(current)</span></a></li>
              <li class="active"><a href="/proxibanquev3/html/ListOfClientAccounts.jsp">Client accounts<span class="sr-only">(current)</span></a></li>
              <li><a href="/proxibanquev3/html/Transfer.jsp">Transfer from one account to another</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
              <li><span onclick="history.back()">Return</span></li>
            </ul>

          </div>

        </div>
      </nav>
    </header>

<table class="table table-striped">
    		<tr>
    			<th>Number of Account</th>
    			<th>Type of Account</th>
    			<th>Solde</th>
    	    </tr>
    	    <tbody id="tableListOfAccountsBody">

    	    </tbody>
    	</table>
</body>
</html>
