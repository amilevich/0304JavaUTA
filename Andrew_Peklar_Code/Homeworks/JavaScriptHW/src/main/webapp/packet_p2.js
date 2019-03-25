/**
 * 
 */

/***********************************************************************************************/
// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
function getUSA() {
	console.log(document.querySelector('[data-customAttr= "USA"]'));
}
//getUSA();
/***********************************************************************************************/// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales() {
	let employeeNames = Array.from(document.getElementsByClassName('empName'));
	for (let i = 0; i < employeeNames.length; i++) {
		if (employeeNames[i].nextElementSibling.innerHTML === 'Sales') {
			console.log(employeeNames[i].innerHTML);
		}
	}
}

//getPeopleInSales();
/***********************************************************************************************/
// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren() {
	let span = document.querySelectorAll('a > span');
	for (let i = 0; i < span.length; i++) {
		console.log(span[i].innerText);
	}
}

//getAnchorChildren();
/***********************************************************************************************/
// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.

function getHobbies() {
	let eee = document.querySelector('select[name=skills');
	console.log("Value: " + eee.value);
}
//getHobbies();
/***********************************************************************************************/

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.

function getCustomAttribute() {
	let cElements = document.querySelectorAll(`[data-customAttr]`);
	cElements.forEach(function(e) { console.log(e.innerText);
									console.log(e);});
	return cElements;
}

//getCustomAttribute();
/***********************************************************************************************/
// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// <input id="num1" class="nums" type="text"/>
// <input id="num2" class="nums" type="text"/>
// <h3>Sum: <span id="sum"></span></h3>
// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element

document.getElementById("num1").onchange = function() {doSum()};
document.getElementById("num2").onchange = function() {doSum()};
document.getElementById("sum").onchange = function() {doSum()};

function doSum(){
	let num1 = document.getElementById("num1");
	let num2 = document.getElementById("num2");
	let sum = document.getElementById("sum");
	
	let summation = parseInt(num1.value) + parseInt(num2.value);
	if(summation || summation === 0) { sum.innerText = summation; }
	else{sum.innerText = 'Cannot add';}
	console.log(sum);
}

//doSum();
/***********************************************************************************************/
// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// "Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

function skillChangeAlert() {
	let sk = document.getElementsByName("skills");
	var skills = sk[0];
	skills.onchange = function() {
	var message = "Are you sure " + skills.value + " is one of your skills?"
	alert(message);
	}
}
skillChangeAlert();
/***********************************************************************************************/
// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// "So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly
// selected favoriteColor

function favoriteColorAlert() {
	let favColor;
	color = document.getElementsByName("favoriteColor");
	for (let i=0; i<color.length; i++){
		color[i].addEventListener("click",() => {
				//fav && fav takes care of case where no prev favorite
                if (favColor && favColor !== color[i].value){
                    alert("So you like " +  color[i].value + " more than " + favColor + " now?");
                } favColor = color[i].value;});}
}
//initialize alert
favoriteColorAlert();
/***********************************************************************************************/
// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// Hide the name if shown.
// Show the name if hidden.

function showOrHideEvent() {
	let empNames = document.getElementsByClassName("empName");
	for(let i = 0; i < empNames.length; i++) {
		let tmpEmp = empNames[i];
		tmpEmp.addEventListener('mouseover', () => {
			tmpEmp.style.color = (tmpEmp.style.color === "white") ? "black" : "white";
		})
	}
}
//initialize listener
showOrHideEvent();
/***********************************************************************************************/
// 10. Current Time
// Regarding this element:
// <h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.

function currentTime() {
	let h5 = document.getElementById('currentTime');
	let time = new Date();
	let amPM = (time.getHours() <= 12) ? "AM" : "PM";
	h5.innerText = time.getHours()%12 + ":" + time.getMinutes() + ":" + time.getSeconds() + " " + amPM;
	setInterval(currentTime, 1000);
}
currentTime();
/***********************************************************************************************/
// 11. Delay
// Regarding this element:
// <p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a
// random color.


/***********************************************************************************************/
// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).
