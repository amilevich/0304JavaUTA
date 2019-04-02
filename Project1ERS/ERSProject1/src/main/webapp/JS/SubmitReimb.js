/**
 * 
 */

window.onload = function() {
	var x = document.getElementById("approveReimb");
	
	if (sessionStorage.getItem("userRole") == "1") {
		x.style.display = "none";
	}
}
