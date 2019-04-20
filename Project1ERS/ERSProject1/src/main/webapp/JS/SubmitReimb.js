/**
 * 
 */

window.onload = function() {
	var x = document.getElementById("approveReimb");
	
	if (sessionStorage.getItem("userRole") == "1") {
		x.style.display = "none";
	}
	console.log(sessionStorage.getItem("userId"));
	var u = document.getElementById("UserId");
	u.value = sessionStorage.getItem("userId");
}
