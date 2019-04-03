/**
 * 
 */
window.onload = function() {
	getTables();
}

function getTables() {
	let xhttp = new XMLHttpRequest();
	xhttp.open("GET", '/ChrisJarodProject1/html/Data.do', true);
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let Dat = JSON.parse(xhttp.responseText);
			addTable(Dat);

			return;

		}
	}
	xhttp.send(null);
}

function Display(Tick) {
	console.log(Tick);
}

function addTable(Dat) {
    var table, row, cell;
    table = document.createElement('table');
    table.className += "table";
    row = table.insertRow(0);
    cell = row.insertCell(0);
    cell.innerHTML = "Id";
    cell = row.insertCell(1);
    cell.innerHTML = "Amount";
    cell = row.insertCell(2);
    cell.innerHTML = "Type";
    cell = row.insertCell(3);
    cell.innerHTML = "Status";
    cell = row.insertCell(4);
    cell.innerHTML = "Author";
    cell = row.insertCell(5);
    cell.innerHTML = "Resolver";
    cell = row.insertCell(6);
    cell.innerHTML = "Description";
    if(Dat.length == 0) {
    	row = table.insertRow(1);
    	cell = row.insertCell(0);
    	cell.innerHTML = "No reimbursements found";
    	cell = row.insertCell(1);
    	cell = row.insertCell(1);
    	cell = row.insertCell(1);
    	cell = row.insertCell(1);
    	cell = row.insertCell(1);
    	cell = row.insertCell(1);
    }
	for (i = 0; i < Dat.length; i++) {
    row = table.insertRow(1); 
    cell = row.insertCell(0);
    cell.innerHTML = Dat[i].reimbursementId;
    cell = row.insertCell(1);
    cell.innerHTML = ("$" + Dat[i].reimbursementAmount);
    cell = row.insertCell(2);
    cell.innerHTML = typeConv(Dat[i].reimbursementTypeId);
    cell = row.insertCell(3);
    cell.innerHTML = statConv(Dat[i].reimbursementStatusId);
    cell = row.insertCell(4);
    cell.innerHTML = Dat[i].author;
    cell = row.insertCell(5);
    cell.innerHTML = Dat[i].resolver;
    cell = row.insertCell(6);
    cell.innerHTML = Dat[i].reimbursementDescription;
	}
    document.getElementById("reimbTable").appendChild(table);
}

function typeConv(input) {	
	switch(input){
	case 0: return 'Lodging';
	case 1: return 'Travel';
	case 2: return 'Food';
	default: return 'Other';
	}
}

function statConv(input) {	
	switch(input){
	case 0: return 'Unresolved';
	default: return 'Resolved';
	}
}
