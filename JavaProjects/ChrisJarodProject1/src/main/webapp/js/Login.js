/**
 * 
 */
formy = document.getElementById('LoginButton')

formy.addEventListener('click',funky, true);

function funky() {
	
	var request = new XMLHttpRequest();
	Uname = document.getElementById('Uname').value;
	Pass = document.getElementById('Pass').value;
	request.open('GET', '/ChrisJarodProject1/html/Login.do?Uname=' + 
			Uname + '&Pass=' + Pass, true);
	
	request.responseType = 'text';
	request.onreadystatechange = function() {
	    if (request.readyState == 4) {
	        if (request.status == 200)
	        {
	        	resp = request.responseText;
	        	resp = resp.replace(/(\r\n|\n|\r)/gm,"");
	        	resp = resp.replace(' ', '');
	        	if(resp == "Login.html?LoginFailed") {
		        		{alert("Incorrect Username or Password!");}
		        		return;
	        	}
	        	else
	        		document.location.href = ('/ChrisJarodProject1/html/' + resp);
	        }
	        else
	        {
	            alert("Connection error: Please try again.")
	        }
	    }
	};
	 
	request.send(null);
}