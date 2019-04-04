/**
 * 
 */

window.onload = function(){
	getEmpTableInfo();
}

function getEmpTableInfo() {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status==200){
			let data = JSON.parse(xhttp.responseText);
			setRow(data);
		}
	}
	
	xhttp.open("GET", 'http://localhost:8080/ProjectOne_ExpenseReimbursementSystem/html/empJSON.do', true);
	xhttp.send();
}

function setRow(data){
	
	var col = [];
    for (var i = 0; i < data.length; i++) {
        for (var key in data[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }
    
    let table = document.getElementById("reimbursementTable");
	for (var i = 0; i < data.length; i++) {

        var tr = table.insertRow(-1);

        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = data[i][col[j]];
            
        }
    }
}

