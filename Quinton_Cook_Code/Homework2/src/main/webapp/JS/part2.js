/**
 * 
 */

function getUSA() {
	let test = document.getElementsByTagName("H1");
	var p = document.createElement('p');
	p.innerHTML = test[0].innerHTML;
	document.body.appendChild(p);
}

function sales() {
	let tables = document.getElementsByTagName("TD");

	for (i = 0; i < tables.length; i++) {
		if (tables[i].textContent == "Sales") {
			alert(tables[i - 1].textContent);
		}
	}
}

function getAnchorChildren() {
	let anchors = document.getElementsByTagName("A");
	let tests = document.getElementsByTagName("SPAN");

	for (i = 0; i < anchors.length; i++) {
		for (k = 0; k < tests.length; k++) {
			if (anchors[i].contains(tests[k])) {
				alert(tests[k].textContent);
			}
		}
	}
}

function getHobbies() {
	let conceptName = document.getElementsByTagName('select');
	alert(conceptName[2].value)
}

function getCustomAttribute() {
	let attr = document.getElementsByTagName("*");
	alert("atr get");
	for (j = 0; j < attr.length; j++) {

		if (attr[j].getAttribute("data-customAttr") != null) {
			alert(attr[j].getAttribute("data-customAttr"));
			alert(attr[j].textContent);
		}
	}
}

document.getElementById("sum").textContent = 0;

let selector1 = document.getElementById("num1");
if (selector1.addEventListener) {
	selector1.addEventListener("mouseout", function() {
		display(selector1)
	}, true);
}

let selector2 = document.getElementById("num2");
if (selector2.addEventListener) {
	selector2.addEventListener("mouseout", function() {
		display(selector2)
	}, true);
}

function display(element) {
	let sum = document.getElementById("sum");
	sum.textContent = parseFloat(sum.textContent) + parseFloat(element.value);
}

let skills = document.getElementsByTagName("select");
if (skills[2].addEventListener) {
	skills[2].addEventListener("input", function() {
		alerted(skills[2])
	}, true);
}

function alerted(element) {
	alert("Are you sure " + element.value + " is one of your skills?");
}

let favColor = document.getElementsByName("favoriteColor");

if (favColor[0].addEventListener) {
	favColor[0].addEventListener("click", function() {
		colorChange(favColor[0])
	}, true);
}

if (favColor[1].addEventListener) {
	favColor[1].addEventListener("click", function() {
		colorChange(favColor[1])
	}, true);
}

if (favColor[2].addEventListener) {
	favColor[2].addEventListener("click", function() {
		colorChange(favColor[2])
	}, true);
}

if (favColor[3].addEventListener) {
	favColor[3].addEventListener("click", function() {
		colorChange(favColor[3])
	}, true);
}

let previous = "";

function colorChange(test) {
	alert("so you like " + test.value + " more than " + previous + " now");
	document.body.style.background = test.value;
	previous = test.value;

}

let tables = document.getElementsByTagName("TD");

document.body.style.background = "white";

for (var i = 0; i < tables.length; i += 2) {
	tables[i].addEventListener("mouseenter", function() {
		showHideText(this);
	}, true);
}

function showHideText(someElement) {

	if (someElement.style.color != "white") {
		someElement.style.color = document.body.style.background;
	} else {
		someElement.style.color = "Black";
	}
}

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

startTime();

let hello = document.getElementById("helloWorld");

hello.addEventListener("click",function(){clicky(this)},true);

function clicky(someArg){
	setTimeout(function(){
		colors = ["red","yellow","blue"];
		someArg.style.color = colors[Math.floor(Math.random()*3)];
	},3000);
}

function walk(childNode){
	if(childNode != null){
		
		for(i = 0; i < childNode.children.length; i++){
			//walk(childNode.children[i]);
			console.log("in"+childNode.children[i].textContent);
			console.log(childNode.children.length);
			//walk(childNode.children[i]);
		}
	}
}

function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}

// Example usage: Process all Text nodes on the page
walkTheDOM(document, function (node){console.log("function on: "+node);});


//walk(document);
/*
 * let parent = document.getElementById('Murca'); let p =
 * document.createElement('p'); p.innerHTML; parent.appendChild(p);
 * 
 * function PrintElem(elem) { alert(elem.innerHTML); }
 */
