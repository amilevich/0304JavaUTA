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
			console.log(xhttp.responseText);
			let reimb = JSON.parse(xhttp.responseText);

			setValues(reimb);
		}
	}
	
	console.log("before get");
	xhttp.open("GET", 'http://localhost:8080/PetsFrontController/html/reimbJSON.do', true);
	xhttp.send();
}


function setValues(reimb){
	console.log("hi");
}



