/**
 * 
 */
window.onload = function() {

	getUserInfo();
}

function getUserInfo() {

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log("responseText = " + xhttp.responseText);
			// alert("responseText = "+ xhttp.responseText);
			var userReimb = JSON.parse(xhttp.responseText);
			setValues(userReimb);
		}
	}

	xhttp.open("GET", 'http://localhost:8080/ERSProject1/HTML/UserJSON.do',
			true);
	xhttp.send();
}

function setValues(userReimb) {
	document.getElementById("FirstName").innerHTML = "First Name: "
			+ userReimb.userFirstname;
	document.getElementById("LastName").innerHTML = "Last Name: "
			+ userReimb.userLastname;
	document.getElementById("Email").innerHTML = "Email: "
			+ userReimb.userEmail;

	var reimbList = userReimb.reimbList;

	$.each(reimbList, function(key, valueObj) {
		// console.log(valueObj.reimb_description);
		$("#myTable").find('tbody').append(
				"<tr>" + "<td>" + valueObj.reimb_submitted + "</td>" + "<td>"
						+ valueObj.reimbType + "</td>" + "<td>"
						+ valueObj.reimb_amount + "</td>" + "<td>"
						+ valueObj.reimb_description + "</td>" + "<td>"
						+ valueObj.reimbStatus + "</td>" + "<td>"
						+ valueObj.reimb_resolved + "</td>" +

						"</tr>");
	});

}