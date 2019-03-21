/**
 * 
 */

/*
 * AJAX - Asynchronous JavaScript and XML
 * Asynchronous - the browser doesn't need to reload the entire page when only a small bit of data on the page has changed
 * 
 * AJAX is not a programming language; it's a technique for accessing web servers from a web page
 * 
 * AJAX is a combination of:
 * - a browser built-in XMLHttpRequest object (requests data from a web server)
 * - JavaScript
 * - HTML DOM (to display or use the data)
 * 
 * XML is a data format for data being transferred between the server and the browser
 * JSON is the preferred data format for transferring data between the server and the web browser
 * 
 * AJAX is a misleading name because AJAX applications might use XML to transport data, but again, JSON is better (bomb.com, plain text)
 * HTTP - Hyper Text Transfer Protocol
 * 
 * How does AJAX work?
 * 1) An even occurs in a web page (the page is loaded, a button is clicked)
 * 2) An XMLHtttpRequest object is created by JavaScript
 * 3) The XMLHttpRequest object sends a request to a web server
 * 4) The server processes the request
 * 5) The server sends a response back to the web page
 * 6) The response is read by JavaScript
 * 7) A proper action is performed (like a page update) by JavaScript
 * 
 */

window.onload = function(){
	document.getElementById("pokemonSubmit").addEventListener("click", getPokemon);
}

function getPokemon(){
	//getting field value
	let pokemonId = document.getElementById("pokemonId").value;
	
	//this object allows us to make requests and get data back
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		/*
		 * The readystate property holds the status of the XMLHttpRequest
		 * 
		 * 0 - request not initialized
		 * 1 - server connection established
		 * 2 - request received
		 * 3 - processing request
		 * 4 - request is finished and response is ready
		 * 
		 * We want state of 4 and a status of 200
		 * 200 OK
		 * 
		 * */
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