/**
 * 
 */

window.onload = function(){
	getPetInfo();
}

function getPetInfo() {
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		
		if(xhttp.readyState == 4 && xhttp.status == 200){
			
			let pet = JSON.parse(xhttp.responseText);
			setValues(pet);
		}
	}
	
	
	xhttp.open("GET", 'http://localhost:8080/PetsFrontController/html/PetJSON.do', true);
	xhttp.send();
}

function setValues(pet){
	let x = document.querySelectorAll(".name");
	
	for (let y of x){
		y.innerHTML = pet.name;
	}
	
	document.getElementById("type").innerHTML = pet.type;
	document.getElementById("age").innerHTML = pet.age;
}