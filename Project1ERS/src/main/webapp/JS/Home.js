/**
 * 
 */

window.onload = function(){
	var ticketTable = document.getElementById("HomeTicketTable");
	var tableBodyHeader = "<tbody id='HomeTicketTable'>";
	var options = document.getElementsByClass("dropdown-option");
	for(var x in options){
		x.addEventListener("click", updateFilters, true);
	}

}

function updateFilters(){
	let statusDropdown = document.getElementById("StatusFilter").options()
	var statusFilter = statusDropdown.options[statusDropdown.selectedIndex].value; //get the selected value of statusDropdown using JavaScript
	
	let typeDropdown = document.getElementById("TypeFilter").options()
	var typeFilter = typeDropdown.options[typeDropdown.selectedIndex].value;
}

function getPokemon(){
	//getting field value
	let pokemonId = document.getElementById("pokemonId").value;
	
	//this object allows us to make requests and get data back
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){

		if (xhttp.readyState == 4 && xhttp.status == 200){
			let pokemon = JSON.parse(xhttp.responseText);
			//JSON parse turns it into an object
			setValues(pokemon);
		}
	}
	//create a connection (method, url, boolean (asynchronous or not))
	xhttp.open("GET", "https://pokeapi.co/api/v2/pokemon/" + pokemonId, true);
	
	//send it
	xhttp.send(); //this sends the request to the API
}

function setValues(pokemon){
	document.getElementById("pokemonName").innerHTML = pokemon.name;
	
	let pokemonImgElement = document.getElementById("pokemonImg");
	pokemonImgElement.setAttribute("src", pokemon.sprites.front_default);
	pokemonImgElement.setAttribute("alt", pokemon.name);
}

/*
let ticketTable = document.getElementById("HomeTicketTable");
let tableBodyHeader = "<tbody id='HomeTicketTable'>";
buildTable(JSON response);
*/