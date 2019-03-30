/*
*
*/

window.onload = function(){
	getEmployeeFunc();
	}

function getEmployeeFunc(){
	let xhttp = new XMLHttpRequest(); console.log("XMLHttpRequest Object made");
	
	xhttp.onreadystatechange = function(){ console.log("Accessed object ready state");
	if(xhttp.readyState == 4 && xhttp.status==200){ 
		let user = JSON.parse(xhttp.responseText);
		setValues(user);
	}
}
	
	xhttp.open("GET", 'http://localhost:8080/Expense_Reimbursement_System/HTML/SubmitT.do', true); console.log("xhttp object is OPEN");
	xhttp.send(); console.log("xhttp object sent request to server");
}

function setValues(user){
	document.getElementById("Session-Info").innerHTML = "Hello " + user.firstName + " " + user.lastName;
}