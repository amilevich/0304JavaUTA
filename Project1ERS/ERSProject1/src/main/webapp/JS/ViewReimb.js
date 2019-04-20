/**
 * 
 */
window.onload = function() {
	
	//var uid = getParameterByName("id");
	//console.log("uid=" + uid);
	getUserInfo();

	// alert(sessionStorage.getItem("userId"));
}



function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}


function getUserInfo() {
	//var userID = sessionStorage.getItem("userId");
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log("responseText = " + xhttp.responseText);
			// alert("responseText = "+ xhttp.responseText);
			var userReimb = JSON.parse(xhttp.responseText);
			setValues(userReimb);
		}
	}
	
	//if (userID == null) {
		xhttp.open("GET", 'http://localhost:8080/ERSProject1/HTML/UserJSON.do', true);
	//}
	//else {
	//	xhttp.open("GET", 'http://localhost:8080/ERSProject1/HTML/UserJSON.do?id=' + userID, true);
	//}
		
	xhttp.send();
}

function setValues(userReimb) {
	document.getElementById("FirstName").innerHTML = "First Name: "
			+ userReimb.userFirstname;
	document.getElementById("LastName").innerHTML = "Last Name: "
			+ userReimb.userLastname;
	document.getElementById("Email").innerHTML = "Email: "
			+ userReimb.userEmail;

	localStorage.setItem("isManager", "FALSE");
	var x = document.getElementById("approveReimb");
	if (userReimb.userRoleId == 1) {
		x.style.display = "none";
		// localStorage.setItem("isManager", "FALSE");
	} else {
		x.style.display = "block";
		localStorage.setItem("isManager", "TRUE");
	}

	var reimbList = userReimb.reimbList;
	let status = "";
	let type = "";
	let resolver = "-";

	sessionStorage.setItem("userId", userReimb.ersUsersId);
	sessionStorage.setItem("userRole", userReimb.userRoleId);

	$.each(reimbList, function(key, valueObj) {
		if (valueObj.reimb_author == userReimb.ersUsersId) {

			switch (valueObj.reimb_status_Id) {
			case 1:
				status = "Approved";
				break;
			case 2:
				status = "Pending";
				break;
			default:
				status = "Denied";
				break;
			}
			switch (valueObj.reimb_type_Id) {
			case 1:
				type = "Lodging";
				break;
			case 2:
				type = "Travel";
				break;
			case 3:
				type = "Food";
				break;
			default:
				type = "Other";
				break;
			}

			if (valueObj.reimb_resolver != 0)
				resolver = valueObj.reimb_resolver_name;
			else {
				resolver = "-";
			}

			// console.log(valueObj.reimb_description);
			$("#myTable").find('tbody').append(
					"<tr>" + "<td>" + valueObj.reimb_submitted + "</td>"
							+ "<td>" + type + "</td>"
							+ "<td style='text-align: right;'>"
							+ formatCurrency(parseFloat(valueObj.reimb_amount))
							+ "</td>" + "<td style='text-align: left;'>"
							+ valueObj.reimb_description + "</td>" + "<td>"
							+ status + "</td>" + "<td>" + resolver + "</td>"
							+ "</tr>");
		}
	});

	function formatCurrency(total) {
		var neg = false;
		if (total < 0) {
			neg = true;
			total = Math.abs(total);
		}
		return (neg ? "-$" : '$')
				+ parseFloat(total, 10).toFixed(2).replace(
						/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
	}
}
