/**
 * 
 */

/**
 * 
 */
let comicId = 0;
let maxComicId = 493;

window.onload = function(){
	document.getElementById("comicSubmit").addEventListener("click", getComic);
	document.getElementById("firstComic").addEventListener("click", getPreviousComic);
	document.getElementById("randomComic").addEventListener("click", getRandomComic);
	document.getElementById("lastComic").addEventListener("click", getNextComic);	
}

function getPreviousComic(){
	if (comicId > 1){
		comicId -= 1
		getComic();
	}
}

function getNextComic(){
	if (comicId < maxComicId){
		comicId += 1
		getComic();
	}
}

function getRandomComic(){
	comicId = Math.floor(Math.random()*maxComicId) + 1; 
	getComic();
}

function getComic(){
	//getting field value
	if (comicId == 0)
		comicId = document.getElementById("comicId").value;
	
	//this object allows us to make requests and get data back
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		
		if (xhttp.readyState == 4 && xhttp.status == 200){
			let comic = JSON.parse(xhttp.responseText);
			//let comic = xhttp.responseText;
			//JSON parse turns it into an object
			setValues(comic);
		}
	}
	//create a connection (method, url, boolean (asynchronous or not))
//	xhttp.open("POST", "http://xkcd.com/info.0.json", true);
	//xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
//	xhttp.setRequestHeader("Access-Control-Allow-Headers", xhttp.getRequestHeader("Access-Control-Request-Headers"));	
	xhttp.open("GET", "https://rickandmortyapi.com/api/character/" + comicId, true);
	
	//send it
	xhttp.send(); //this sends the request to the API
}

function setValues(comic){
	console.log(comic);
	
	let comicImgElement = document.getElementById("comicImg");
	comicImgElement.setAttribute("src", comic.image);
	comicImgElement.setAttribute("alt", comic.name);

//	let comicAltText = document.getElementById("alttext");
//	document.getElementById("comicDate") = comic.year + "-" + comic.month + "-" + comic.day;
	//
}