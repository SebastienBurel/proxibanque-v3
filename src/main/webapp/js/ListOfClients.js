

let getListOfClients = function(callBack){
  console.log("getListOfClients");
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function(){
    if(this.readyState==4 && this.status == 200){
      let clients = JSON.parse(this.responseText);
		  console.log(clients);
		  callBack(clients);
    }//if
  }//function
  xhttp.open("GET","../json/listOfClients.json",true);
  xhttp.send();
}
