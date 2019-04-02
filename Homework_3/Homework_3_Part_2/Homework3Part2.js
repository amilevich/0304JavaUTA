/**
 * 
 */

/*
 * 1. USA
 * Define function getUSA()
 * Find the html element that contains "USA".
 * Print that element's contents.
console.log("1. USA");
function getUSA(){
	var america = document.querySelector("span[data-customAttr='USA']")
	return america;
}
console.log(getUSA());
console.log("----------------------------------------");

/* 1. USA
 * Define function getUSA()
 * Find the html element that contains "USA".
 * Print that element's contents.
 * */
console.log("1. USA");
function getUSA(){
	var x = document.getElementsByTagName("span"); //this creates array "x", which contains all elements inside a "<span>" tag
	for(var i = 0; i<x.length; i++){
		if(x[i].innerHTML == "USA"){
			console.log(x[i].innerHTML);
		}
	}
}
getUSA();
console.log("----------------------------------------");

/* 2. Sales
 * Define function getPeopleInSales()
 * Print the names of all the people in the sales department.
 * */
console.log("2. Sales");
function getPeopleInSales(){
	var employeePeople = document.querySelectorAll("td[class='empName']"); //this create an array object of type "NodeList"
	console.log(employeePeople[0].innerHTML);
	console.log(employeePeople[2].innerHTML);
	console.log(employeePeople[4].innerHTML);
	console.log(employeePeople[5].innerHTML);
	
	//return employeePeople;
}
getPeopleInSales();
console.log("----------------------------------------");

/*
 * 3. Click Here
 * Define function getAnchorChildren()
 * Find all anchor elements with a <span> child.
 * Print the contents of <span>
 */
console.log("3. Click here");
function getAnchorChildren(){
	var childrenVar = document.getElementsByTagName("A"); //gets all elements with an "<a>" tag
	for(var i = 0; i<childrenVar.length; i++){
		if(childrenVar[i].hasChildNodes()){ //.hasChildNodes() returns "true" if the array index position contains child nodes
			var allChildren = childrenVar[i].children;
			for(var j = 0; j<allChildren.length; j++){
				if(allChildren[j].tagName == "SPAN"){
					console.log(allChildren[j].innerHTML);
				}
			}
		}
	}
}
getAnchorChildren();
console.log("----------------------------------------");

/*
 * 4. Hobbies
 * Define function getHobbies()
 * Find all checked options in the 'skills' select element.
 * Print the value and the contents.
 */
console.log("4. Hobbies");
function getHobbies(){
	var skillsVar = document.getElementsByName("skills")[0];
	var childrenSkills = skillsVar.children;
	for(var i=0;i<childrenSkills.length;i++){
		if(childrenSkills[i].hasAttribute("selected")){
			console.log(childrenSkills[i].innerText);
		}
	}
}
getHobbies();
console.log("----------------------------------------");

/*
 * 5. Custom Attribute
 * Define function getCustomAttribute()
 * Find all elements with "data-customAttr" attribute
 * Print the value of the attribute.
 * Print the element that has the attribute.
 */
console.log("5. Custom Attribute");
function getCustomAttribute(){
	var spanArray = document.getElementsByTagName("SPAN");
	var tdArray = document.getElementsByTagName("TD");
	var inputArray = document.getElementsByTagName("INPUT");
	
	for(var a = 0; a<spanArray.length; a++){ //inputArray has the greatest length
		console.log(spanArray[i]);
		//if(a == spanArray.length-1){console.log("end of spanArray");}
		if(spanArray[a].innerHTML == "USA"){ //} || spanArray[a].innerHTML == "500"){
			console.log(spanArray[a].innerHTML);
		} else if (spanArray[a].innerHTML == "500"){
			console.log(spanArray[a].innerHTML);
		}
	}
	
	for(var b = 0; b<tdArray.length; b++){ 
		console.log(tdArray[i]);
		//if(b == tdArray.length-1){console.log("end of tdArray");}
		if(tdArray[b].innerHTML == "COURT"){
			console.log(tdArray[b].innerHTML);
		}
	}
	
	for(var c = 0; c<inputArray.length; c++){ 
		console.log(inputArray[i]);
		//if(c == inputArray.length-1){console.log("end of inputArray");}
		if(inputArray[c].innerHTML == "7"){ //} || inputArray[c].innerHTML == "24"){
			console.log(inputArray[c].innerHTML);
		} else if(inputArray[c].innerHTML == "24"){
			console.log(inputArray[c].innerHTML);
		}
	}
	
	var argent = document.querySelectorAll("[data-customAttr]");
	//console.log("Elements that have the attribute:")
	for(var i = 0; i<argent.length; i++){
		console.log(argent[i].innerHTML);
	}
}
getCustomAttribute();
console.log("----------------------------------------");

/*6. Sum Event
 * NOTE: Write unobtrusive Javascript
 * Regarding these elements:
 * <input id="num1" class="nums" type="text"/>
 * <input id="num2" class="nums" type="text"/>
 * <h3>Sum: <span id="sum"></span></h3>
 * 
 * Define onchange event handler.
 * Add <input> element values.
 * Put the sum in the <span> element.
 * If values cannot be added, put "Cannot add" in the <span> element
 * */
console.log("6. Sum Event");
document.getElementById("sum").textContent = 0;
var sumSelect = document.getElementById("num1");
if (sumSelect.addEventListener) {
	sumSelect.addEventListener("mouseout", function() {displayFunc(sumSelect)}, true);
}

var num2Select = document.getElementById("num2");
if (num2Select.addEventListener) {
	num2Select.addEventListener("mouseout", function() {displayFunc(num2Select)}, true);
}

function displayFunc(elementName) {
	var sumBlue = document.getElementById("sum");
	sumBlue.textContent = parseFloat(sumBlue.textContent) + parseFloat(elementName.value);
}
console.log("----------------------------------------");

/*7. Skills Event
 * NOTE: Write unobtrusive Javascript
 * When user selects a skill, create an alert with a message similar to:
 * "Are you sure CSS is one of your skills?"
 * NOTE: no alert should appear when user deselects a skill.
 * */
console.log("7. Skills Event")
let skills = document.getElementsByTagName("select");
if (skills[2].addEventListener) {
	skills[2].addEventListener("input", function() {alertFunc(skills[2])}, true);
}

function alertFunc(element) {
	alert("Are you sure " + element.value + " is one of your skills?");
}
console.log("----------------------------------------");

/*8. Favorite Color Event
 * NOTE: Write unobtrusive Javascript
 * NOTE: This is regarding the favoriteColor radio buttons.
 * When a user selects a color, create an alert with a message similar to:
 * "So you like green more than blue now?"
 * In this example, green is the new value and blue is the old value.
 * Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
 * */
console.log("8. Favorite Color Event")
var favColorArray = document.getElementsByName("favoriteColor");

if (favColorArray[0].addEventListener) {
	favColorArray[0].addEventListener("click", function(){changeColorFunc(favColorArray[0])}, true);
}
if (favColorArray[1].addEventListener) {
	favColorArray[1].addEventListener("click", function(){changeColorFunc(favColorArray[1])}, true);
}
if (favColorArray[2].addEventListener) {
	favColorArray[2].addEventListener("click", function(){changeColorFunc(favColorArray[2])}, true);
}
if (favColorArray[3].addEventListener) {
	favColorArray[3].addEventListener("click", function(){changeColorFunc(favColorArray[3])}, true);
}

var previous = "white";
function changeColorFunc(test) {
	alert("So you like " + test.value + " more than " + previous + " now?");
	document.body.style.background = test.value;
	previous = test.value;
}
console.log("----------------------------------------");

/*9. Show/Hide Event
 * NOTE: Write unobtrusive Javascript
 * When user hovers over an employees name:
 *  	Hide the name if shown.
 *  	Show the name if hidden.
 * */
console.log("9. Show/Hide Event")
document.body.style.background = "white";
var tableCells = document.getElementsByTagName("TD");

for (var i = 0; i < tableCells.length; i += 2) {
	tableCells[i].addEventListener("mouseenter", function() {showHideText(this);}, true);
}

function showHideText(randomElement) {
	if (randomElement.style.color != "white") {
		randomElement.style.color = document.body.style.background;
	} else {
		randomElement.style.color = "black";
	}
}
console.log("----------------------------------------");

/* 10. Current Time
 * Regarding this element:
 * <h5 id="currentTime"></h5>
 * Show the current time in this element in this format: 9:05:23 AM
 * The time should be accurate to the second without having to reload the page.
 * */
console.log("10. Current time");
function currentTimeFunc() {
	var dateTimeRecorder = document.getElementById("currentTime");
	
	var day = new Date();
	var hour = day.getHours();
	var minute = day.getMinutes();
	var second = day.getSeconds();
	
	hour = timeFormatFunc(hour);
	minute = timeFormatFunc(minute);
	second = timeFormatFunc(second);
	dateTimeRecorder.innerHTML = hour + ":" + minute + ":" + second;
	
	var timeoutVar = setTimeout(currentTimeFunc, 900); //900 milliseconds
}

function timeFormatFunc(i) {
	if (i < 10) {
		i = "0" + i;
	}
	return i;
}
currentTimeFunc();
console.log("----------------------------------------");

/*
 * 11. Delay
 * Regarding this element:
 * <p id="helloWorld">Hello, World!</p>
 * Three seconds after a user clicks on this element, change the text to a random color.
 * */
console.log("11. Delay");
var helloWorldElement = document.getElementById("helloWorld");
helloWorldElement.addEventListener("click",function(){eventFunc(this)},true);

function eventFunc(randomArg){
	setTimeout(function(){
		colors = ["red","blue","yellow", "green"];
		randomArg.style.color = colors[Math.floor(Math.random()*4)];
	},3000);
}
console.log("----------------------------------------");

/*
 * 12. Walk the DOM
 * Define function walkTheDOM(node, func)
 * This function should traverse every node in the DOM. Use recursion.
 * On each node, call func(node).
 */
console.log("12. Walk the DOM");
function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild;
    
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}

function walkFunc(childNode){
	if(childNode != null){
		for(i = 0; i < childNode.children.length; i++){
			console.log("in"+childNode.children[i].textContent);
			console.log(childNode.children.length);
		}
	}
}
walkTheDOM(document, function(node){console.log(node);});
console.log("----------------------------------------");