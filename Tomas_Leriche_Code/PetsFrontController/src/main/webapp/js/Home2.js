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
			
			let reimb = JSON.parse(xhttp.responseText);
			console.log(reimb);
			document.getElementById("loading").innerHTML = '';
			document.getElementById("removeit").hidden = true;
			setValues(reimb);
		}
	}
	
	
	xhttp.open("GET", 'http://localhost:8080/PetsFrontController/html/ManJSON.do', true);
	xhttp.send();
	
}

function setValues(reimb){
	console.log(reimb);
	document.getElementById("select").innerHTML = `
		<p>
			<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
				Click To Edit a Reimbursement
				</a>
			<a class="btn btn-primary" data-toggle="collapse" href="#multiCollapseExample2" role="button" aria-expanded="false" aria-controls="multiCollapseExample2">
			Cancel a Pending Reimbursement Request</a>
	 </p>

	 <div class="row">
	 <div class = "col">
	 
	 <div class="collapse multi-collapse" id="collapseExample">
	 <div class="card card-body">
			<form id="register-form" class="form" action="ReimbUpdate.do" method="POST" role="form">
				<div id="login-column" class="col-md-12">
				<div id="login-box" class="col-md-12">
				<div class="form-group">
						<label for="username" class="text-info">To update a reimbursement, enter its ID below:</label><br>
						<input type="number" name="reimb_id" id="username"
											class="form-control" placeholder="Reimbursement ID goes here" required>
						<input type="number" step="0.01" name="reimb_amount" id="username"
											class="form-control" placeholder= "Enter new amount here" required>
						<input type="text" name="reimb_description" id="username"
											class="form-control" placeholder="Enter new description here" required>
						<input id= "sub-but" type="submit" name="submit" class="btn btn-info btn-md" 
													value="Update Information">
				</div>
				</div>
				</div>
				</form>
				 </div>
	</div>

	</div>
	<div class="col">

	<div class="collapse multi-collapse" id="multiCollapseExample2">
	 <div class="card card-body">
			<form id="register-form2" class="form" action="DeleteReimb.do" method="POST" role="form">
				<div id="login-column" class="col-md-12">
				<div id="login-box" class="col-md-12">
				<div class="form-group">
						<label for="username" class="text-info">To Delete a pending reimbursement, enter its ID below:</label><br>
						<input type="number" name="reimb_id" id="username"
											class="form-control" placeholder="Reimbursement ID goes here" required>

						<input id= "sub-but" type="submit" name="submit" class="btn btn-info btn-md" 
													value="Delete Request">
				</div>
				</div>
				</div>
				</form>
				 </div>
	</div>


	</div>
	</div>

			</form>
			`

		document.getElementById("insert").innerHTML = `<thead>
				<tr>
				<th scope="col">ID</th>
				<th scope="col">Amount</th>
				<th scope="col">User ID</th>
				<th scope="col">Submitted</th>
				<th scope="col">Resolved</th>
				<th scope="col">Description</th>
				<th scope="col">User First Name</td>
				<th scope="col">User Last Name</td>
				<th scope="col">Status</td>
				</tr>
				</thead>`
		for (let reim of reimb){
			document.getElementById("insert").innerHTML += `
				<tbody>
				<tr>
				<th scope="row" id ="reimb_id"><a href="http://localhost:8080/PetsFrontController/html/ReimbProfile.html">${reim.reimb_id}</a></th>
				<td class="reimb_amount">${reim.reimb_amount}</td>
				<td id="reimb_author">${reim.reimb_author}</td>
				<td id="reimb_submitted">${reim.reimb_submitted}</td>
				<td id="reimb_resolved">${reim.reimb_resolved}</td>
				<td id="reimb_description">${reim.reimb_description}</td>
				<td id="first_name">${reim.first_name}</td>
				<td id="last_name">${reim.last_name}</td>
				<td id="reimb_status">${reim.reimb_status_id}</td>
				</tr>
				</tbody>`			
		}
	
	
}