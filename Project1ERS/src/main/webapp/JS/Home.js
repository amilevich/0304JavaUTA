/**
 * 
 */

window.onload = function(){
	var options = document.getElementsByClassName("dropdown-option");
	for(let i = 0; i < options.length; i++){
		options[i].addEventListener("click", updateFilters, true);
	}
	console.log("in window.onload")
	console.log("ddl options: "+ options.length)
}

function updateFilters(){
	console.log("In Update Filters")
	let statusDropdown = document.getElementById("StatusFilter")
	var statusFilter = statusDropdown.options[statusDropdown.selectedIndex].value; //get the selected value of statusDropdown using JavaScript
	
	let typeDropdown = document.getElementById("TypeFilter")
	var typeFilter = typeDropdown.options[typeDropdown.selectedIndex].value;
	console.log(statusFilter);
	console.log(typeFilter);
	debugger;
	//getTickets();
}

/*
function getTickets(){
	console.log("In Get Tickets")
	let ticketTable = document.getElementById("HomeTicketTable");
	let tableBodyHeader = "<tbody id='HomeTicketTable'>";
	
	// this object allows us to make requests and get data back
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){

		if (xhttp.readyState == 4 && xhttp.status == 200){
			debugger;
			let tickets= JSON.parse(xhttp.responseText);
			//JSON parse turns it into an object
			
			console.log(tickets)
			ticketTable.innerHTML = tableBodyHeader +
									buildTable(tickets) +
									"</table>";
			debugger;
			return false;
		}
	}
	console.log("Building request")
	// create a connection (method, url, boolean (asynchronous or not))
	debugger;
	xhttp.setRequestHeader("Content-Type", "application/json");
	xhttp.open("GET", "localhost:8080", true);
	
	// send it
	console.log("Sending request")
	debugger;
	xhttp.send(null);
	
	console.log("Leaving Get Tickets")
}
*/

function buildTable(tickets){
	console.log("Building Table")
	let tableData = "";
	
	for (let ticket in tickets)
	{
		tableData +=
		`<tr>
			<td>${ticket.username}</td>
			<td>${ticket.amount}</td>
			<td>${ticket.type}</td>
			<td>${ticket.status}</td>
			<td><a href="/Review.html">Review Ticket</a></td>
		</tr>`
	}
	return tableData;
}

/*
let ticketTable = document.getElementById("HomeTicketTable");
let tableBodyHeader = "<tbody id='HomeTicketTable'>";
buildTable(JSON response);
*/