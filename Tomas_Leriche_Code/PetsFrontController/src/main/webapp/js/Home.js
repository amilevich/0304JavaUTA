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
	
	document.getElementById("id").innerHTML = pet.user_id;
	
	let x = document.querySelectorAll(".name");
	
	for (let y of x){
		y.innerHTML = pet.name;
	}
	
	console.log(pet);
	document.getElementById("type").innerHTML = pet.type;
	document.getElementById("age").innerHTML = pet.age;
	document.getElementById("first_name").innerHTML = pet.first_name;
	document.getElementById("last_name").innerHTML = pet.last_name;
	document.getElementById("email").innerHTML = pet.email;
	document.getElementById("role_id").innerHTML = pet.role_id;
	
	
	
	
}