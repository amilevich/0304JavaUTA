/**
 * 
 */

let tickets = [];
let statusDropdown = document.getElementById("StatusFilter")
let statusFilter = statusDropdown.options[statusDropdown.selectedIndex].value;
let typeDropdown = document.getElementById("TypeFilter")
let typeFilter = typeDropdown.options[typeDropdown.selectedIndex].value;

window.onload = function(){
	var options = document.getElementsByClassName("dropdown-option");
	for(let i = 0; i < options.length; i++){
		options[i].addEventListener("click", updateFilters, true);
	}
	console.log("in window.onload")
	console.log("ddl options: "+ options.length)
	
	var ticketTable = document.getElementById("HomeTicketTable");
	var tableBodyHeader = '<tbody id="HomeTicketTable" style="height: 80px !important; overflow: scroll">'
	
	getTickets();
}

function updateFilters(){
	console.log("In Update Filters")
	// get the selected value of statusDropdown using JavaScript
	statusFilter = statusDropdown.options[statusDropdown.selectedIndex].value;
	typeFilter = typeDropdown.options[typeDropdown.selectedIndex].value;
	
	console.log(statusFilter);
	console.log(typeFilter);
//	debugger;
	buildTable();
}

function getTickets(){
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4 && xhttp.status == 200) {
// debugger;
			let response = JSON.parse(xhttp.response);
		// JSON parse turns it into an object
		
			console.log(response)
		
// do localstorage here
			let responseTokens = response.split("*")
			localStorage.setItem('currUser', responseTokens[0].split("\"")[1])
			localStorage.setItem('userType', responseTokens[1].split("\"")[1])
			for (let i = 2; i < responseTokens.length - 1; i++)
			{
//				console.log(responseTokens[i])
				let ob = JSON.parse(responseTokens[i])
//				console.log(ob)
				tickets.push(ob)
			}
			console.log(tickets);
			buildTable();
		}
	}
	console.log("Building request")
// create a connection (method, url, boolean (asynchronous or not))
// debugger;
	xhttp.open("GET", "Home.do", true);
	xhttp.setRequestHeader("Content-Type", "application/json");

// send it
// debugger;
	xhttp.send(null);
	console.log("Request Sent")
}


function buildTable(){
	console.log("Building Table")
	let ticketTable = document.getElementById("HomeTicketTable");
	let tableBodyHeader = '<tbody id="HomeTicketTable" style="height: 80px !important; overflow: scroll">';
			
	let tableData = "";
	
	console.log(localStorage.getItem("currUser"))
	for (let i = 0; i < tickets.length; i++)
	{
		console.log(i + " : "+ tickets[i].username)
		if (localStorage.getItem("userType") == "Employee")
			if (tickets[i].username != localStorage.getItem("currUser"))
				continue;
		// else
		console.log("Checking Filters: " + statusFilter + ", " + typeFilter)
		if (statusFilter != "StatusNull" && statusFilter != tickets[i].state)
			continue;
		if (typeFilter != "TypeNull" && typeFilter != tickets[i].type)
			continue;
		
		console.log("Adding Ticket")
		tableData +=
		`<tr id="ticketList${tickets[i].id}">
			<td>${tickets[i].username}</td>
			<td>${tickets[i].amount}</td>
			<td>${tickets[i].type}</td>
			<td>${tickets[i].state}</td>
			<td><a href="#" onclick="setReview(this);">Review Ticket</a></td>
		</tr>`
	}

	ticketTable.innerHTML = tableBodyHeader + tableData	+ "</tbody>";
}

function setReview(anchor){
	let tr = anchor.parentNode.parentNode;
	console.log(tr);
	let targetId = tr.getAttribute("id").split("ticketList")[1];
	localStorage.setItem("currentTicket", JSON.stringify(tickets[targetId]));
	
	window.location.href = "./Review.html";
}

/*
 * let ticketTable = document.getElementById("HomeTicketTable"); let
 * tableBodyHeader = "<tbody id='HomeTicketTable'>"; buildTable(JSON response);
 */