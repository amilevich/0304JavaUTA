/**
 * 
 */

console.log("In Load.js")
//let ticketTable = document.getElementById("HomeTicketTable");
//let tableBodyHeader = "<tbody id='HomeTicketTable'>";

// this object allows us to make requests and get data back
let xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function() {

	if (xhttp.readyState == 4 && xhttp.status == 200) {
//		debugger;
		let response = JSON.parse(xhttp.response);
		// JSON parse turns it into an object
		
		console.log(response)
//		ticketTable.innerHTML = tableBodyHeader + buildTable(tickets)
//				+ "</table>";
		
//		do localstorage here
		let responseTokens = response.split("*")
		localStorage.setItem('currUser', responseTokens[0].split("\"")[1])
		let ticketList = []
		for (let i = 1; i < responseTokens.length - 1; i++)
		{
			console.log(responseTokens[i])
			let ob = JSON.parse(responseTokens[i])
			console.log(ob)
			ticketList.push(ob)
//			ticketList.push(responseTokens[i])
		}
		console.log(ticketList)
		localStorage.setItem('ticketList', ticketList)
		
		console.log(localStorage)
		console.log(localStorage.ticketList)
		console.log(localStorage.ticketList[0].amount)
		console.log(localStorage.ticketList[1].type)
		console.log(localStorage.ticketList[2].state)
		
	}
}
console.log("Building request")
// create a connection (method, url, boolean (asynchronous or not))
//debugger;
xhttp.open("GET", "TicketJSON.do", true);
xhttp.setRequestHeader("Content-Type", "application/json");

// send it
//debugger;
xhttp.send(null);
console.log("Request Sent")