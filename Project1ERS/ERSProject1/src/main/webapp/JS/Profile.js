/**
 * 
 */
window.onload = function() {
	getUserInfo();
	
	$(':text').on('input', function() {
        if( $(':text').filter(function() { return !!this.value; }).length > 0 ) {
             $('#btnSubmit').prop('disabled', false);
        } else {
             $('#btnSubmit').prop('disabled', true);
        }
    });
}

function getUserInfo() {

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log("responseText = " + xhttp.responseText);
			var userReimb = JSON.parse(xhttp.responseText);
			setValues(userReimb);
		}
	}

	xhttp.open("GET", 'http://localhost:8080/ERSProject1/HTML/UserJSON.do',
			true);
	xhttp.send();
}

function setValues(userReimb) {
	
	var x = document.getElementById("approveReimb");
	if (sessionStorage.getItem("userRole") == "1") {
		x.style.display = "none";
	}
	
	document.getElementById("UserId").value = userReimb.ersUsersId;
	document.getElementById("FirstName").value = userReimb.userFirstname;
	document.getElementById("LastName").value = userReimb.userLastname;
	document.getElementById("Email").value = userReimb.userEmail;
	document.getElementById("Username").value = userReimb.ersUsername;
	document.getElementById("Password").value = userReimb.ersPassword;
}