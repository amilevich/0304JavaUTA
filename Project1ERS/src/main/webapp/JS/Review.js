/**
 * 
 */

console.log(JSON.parse(localStorage.getItem("currentTicket")));
console.log(localStorage.getItem("currUser"));

let ticketObj = JSON.parse(localStorage.getItem("currentTicket"));
let approveButton = document.getElementById("TicketApprove");
let denyButton = document.getElementById("TicketDeny");

window.onload = function() {
	writeData();
	approveButton.addEventListener("click", updateTicket);
	denyButton.addEventListener("click", updateTicket);
}

window.onbeforeunload = hideButtons();

function writeData() {
	document.getElementById("TicketId").innerText = ticketObj.id;
	document.getElementById("TicketUsername").innerText = ticketObj.username;
	document.getElementById("TicketType").innerText = ticketObj.type;
	document.getElementById("TicketAmount").innerText = ticketObj.amount;
	document.getElementById("TicketDescription").innerText = ticketObj.description;

	let ticketStatus = ticketObj.state;
	if (ticketStatus == "PENDING") {
		if (localStorage.getItem("userType") == "Manager")
			showButtons();
	}
	

	document.getElementById("TicketStatus").innerText = ticketObj.state;
}

function updateTicket() {
	let params = "?id="+ticketObj.id+"&newStatus="+this.id;
	let targetButton = this
	
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
		}
		// debugger;
		let response = xhttp.response;
//		if (response != "")
//		{
			document.getElementById("TicketStatus").innerText = (targetButton == approveButton) ? "APPROVED" : "DENIED";
			hideButtons();
//		}
	}
	
	xhttp.open("GET", "UpdateStatus.do" + params, true);
	xhttp.send()
//	debugger;
}

function showButtons(){
	approveButton.style.display='block'
	approveButton.setAttribute("pointer-events", "auto");
	denyButton.style.display='block'
	denyButton.setAttribute("pointer-events", "auto");
}

function hideButtons() {
	approveButton.style.display='none'
	approveButton.setAttribute("pointer-events", "none");
	denyButton.style.display='none'
	denyButton.setAttribute("pointer-events", "none");
}