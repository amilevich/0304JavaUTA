/**
 * 
 */

console.log($('h1:contains("USA")').text());

var tableRow = $("td").filter(function() {
	if ($(this).next().text() == "Sales") {
		console.log($(this).text());
	}

}).closest("tr");

console.log($("a").has("span").text());

$('*[name="skills"]').change(function() {
	alert("Are you sure that " + $(this).val() + " is one of your skills");
});

console.log(($('*[data-customAttr]').text()));

$("#num1").change(function() {

	a = parseFloat($(this).val()) + parseFloat($("#num2").val());
	if (typeof (a) == "number" && !isNaN(a)) {
		$("#sum").text(a);
	} else {
		alert("input is not reconized");
	}

});

$("#num2").change(function() {
	a = parseFloat($(this).val()) + parseFloat($("#num1").val());
	if (typeof (a) == "number" && !isNaN(a)) {
		$("#sum").text(a);
	} else {
		alert("input is not reconized");
	}
});

let globalVar = "";

$('*[name="favoriteColor"]').click(
		function() {
			alert("so you like " + $(this).val() + " more than " + globalVar
					+ " now?");
			globalVar = $(this).val();
			document.body.style.backgroundColor = $(this).val();
		});

$('td:even').mouseover(function() {
	x = $(this).css('backgroundColor');

	if ($(this).css('color') == x) {
		$(this).css('color', "Black");
	} else {
		$(this).css('color', x);
	}
});

function startTime() {
	let clock = document.getElementById("currentTime");
	var today = new Date();
	var h = today.getHours();
	var m = today.getMinutes();
	var s = today.getSeconds();
	m = checkTime(m);
	s = checkTime(s);
	clock.innerHTML = h + ":" + m + ":" + s;
	var t = setTimeout(startTime, 500);
}
function checkTime(i) {
	if (i < 10) {
		i = "0" + i
	}
	; // add zero in front of numbers < 10
	return i;
}

alert("MADE IT HERE")
$("#currentTime").text(startTime());

$("#helloWorld").click(function() {
	let c = "";
	
	setTimeout(function() {
		c = changeColor();
		$("#helloWorld").css('color',c);
	}, 3000);
	
});

function changeColor() {
	colors = [ "red", "yellow", "blue" ];
	return colors[Math.floor(Math.random() * 3)];
}

//walk the dom
console.log($("*").text());
