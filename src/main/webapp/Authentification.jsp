<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--<link rel="stylesheet" type="text/css" href="Proxibanque.css">-->

<title>Proxibanquev3</title>
</head>
<body>
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

<!--             <a class="navbar-brand" href="/proxibanquev3/html/ProxiBanqueHome.jsp">PROXIBANQUE -->
<!--               <span class=" glyphicon glyphicon-home"></span> -->
<!--               ProxiBanque -->
<!--             </a> -->

          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li class="active"><a href="/proxibanquev3/Authentification.jsp">Authentification</a></li>
                        
            
            <%
						if (session.getAttribute("conseillerLogin") != null) {
					%>
					<li><a href="/proxibanquev3/html/ConseillerService.jsp">Conseiller service</a></li>
					<li><a href="/proxibanquev3/html/listofclients.jsp">List of clients</a></li>
					<li><a href="/proxibanquev3/html/UpdateClientInformation.jsp">Update client</a></li>
					<li><a href="/proxibanquev3/html/ListOfClientAccounts.jsp">Client accounts</a></li>
					<li><a href="/proxibanquev3/html/Transfer.jsp">Transfer from one account to
							another</a></li>
					<%
						}
					%>
             </ul>

            <ul class="nav navbar-nav navbar-right">
              <li><span onclick="history.back()">Return</span></li>
            </ul>

          </div>

        </div>
      </nav>
    </header>

		<div class="container-fluid">
			<h1>Authentification Conseiller</h1>
			<form class="form-horizontal" method="POST" action="ValidAuthentification">
			  <div class="form-group">
				<label for="inputLogin" class="col-sm-2 control-label">Login</label>
				<div class="col-sm-10">
				  <input type="text" class="form-control" id="inputLogin" placeholder="Login" name="login">
				</div>
			  </div>
			  <div class="form-group">
				<label for="inputPassword" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
				  <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="pwd">
				</div>
			</div>

			  <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				  <!--<button type="submit" onclick="verification();" class="btn btn-default">Sign in</button> -->

				  <input type="submit" class="btn btn-primary" value="Verification">

				</div>
			  </div>
			</form>
			
			<%
				if (session.getAttribute("errorLogin") != null) {
			%>
			<div id="test" class="alert alert-warning">
				${sessionScope.errorLogin}
			</div>
			<%
				}
			%>

			<div id="test" class="alert alert-warning" style="display:none"></div>
			<script>

			//*****************************************
			var elt = document.getElementById("test");
			elt.innerHTML="";
			elt.style.display="block";
			//*****************************************
			let authentification = function(response){
				console.log("call of autentification()");
				let login = new String(document.getElementById("inputLogin").value);
				let password = new String(document.getElementById("inputPassword").value);

				let listeConseillers = JSON.parse(response.responseText);

				let bool = false ;
				for(let i=0;i<listeConseillers.length;i++){
					let conseiller = listeConseillers[i];
					if(conseiller.inputLogin == login && conseiller.inputPassword == password){
						window.location.href = "ListOfClients.html";
					} // if
				}// for

				if(bool === false){
					window.alert("Echec authentification Conseiller. Essayer à nouveau");
					elt.innerHTML = "Echec authentification Conseiller. Essayer à nouveau";
				}

			}
			//*****************************************************************
			//*****************************************************************
			//*****************************************************************
			let verification = function(){
				console.log("call of verification()");
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function(){
					if(this.readyState==4 && this.status == 200){
						authentification(this);
					}//if
				}//function
				xhttp.open("GET","../json/listeConseillers.json",true);
				xhttp.send();
			}

			</script>
		</div>

    
</body>
</html>
