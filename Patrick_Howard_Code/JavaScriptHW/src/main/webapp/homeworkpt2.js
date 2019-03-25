/**
 * 
 */

// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
// Filter Function
function filterElements(element) {
	return element.textContent === "USA";
}

function getUSA() {
	var span = Array.prototype.slice.call(document.querySelectorAll("span"));
	var matches = span.filter(filterElements);
	console.log(matches[0]);
	console.log(matches[0].innerText);
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.

function getPeopleInSales() {
	var table = document.getElementsByTagName("table")[0];
	for (var i = 1; i < table.rows.length; i++) {
		if (table.rows[i].cells.length) {
			var name = (table.rows[i].cells[0].textContent.trim());
			var dept = (table.rows[i].cells[1].textContent.trim());
			if (dept == "Sales") {
				console.log(name);
			}
		}
	}
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>

function getAnchorChildren() {
	var a = document.getElementsByTagName('a');

	for (var idx = 0; idx < a.length; ++idx) {
		if (a[idx].innerHTML.includes("span")) {
			console.log(a[idx].innerHTML);
		}
	}
}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.

function getHobbies() {
	var selectTag = document.getElementsByName("skills");

	for (var i = 0; i < selectTag[0].options.length; i++) {
		if (selectTag[0].options[i].selected) {
			console.log(selectTag[0].options[i].value);
			console.log(selectTag[0].options[i].innerText);
		}
	}

}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.

function getCustomAttributes() {
	var a = document.querySelectorAll('[data-customAttr]');
	for (var idx = 0; idx < a.length; ++idx) {
		console.log("CustomAttributeElement = " + a[idx]);
		console.log("CustomAttributeValue = "
				+ a[idx].attributes["data-customAttr"].value);
	}
}

// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// <input id="num1" class="nums" type="text"/>
// <input id="num2" class="nums" type="text"/>
// <h3>Sum: <span id="sum"></span></h3>
//
// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element

// Wait for DOM to load
document.addEventListener("DOMContentLoaded", function(event) {
	var numberOne = document.getElementById("num1");
	var numberTwo = document.getElementById("num2");
	// Wait for user input
	numberOne.addEventListener("change", function() {
		var value1 = Number(numberOne.value);
		var value2 = Number(numberTwo.value);
		var sumTotal = value1 + value2;
		document.getElementById('sum').innerHTML = sumTotal;
	}, false);
	numberTwo.addEventListener("change", function() {
		var value1 = Number(numberOne.value);
		var value2 = Number(numberTwo.value);
		var sumTotal = value1 + value2;
		document.getElementById('sum').innerHTML = sumTotal;
	}, false);
});

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// "Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

document.addEventListener("DOMContentLoaded", function(event) {
	var getSkill = document.getElementsByName("skills");
	// Wait for user input
	getSkill[0].addEventListener("change", function() {
		if (getSkill[0].options[getSkill[0].selectedIndex].value == "css") {
			alert("Are you sure CSS is one of your skills?");
		}
	}, false);
});

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// "So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly
// selected favoriteColor

document.addEventListener("DOMContentLoaded", function(event) {
	var colors = document.getElementsByName("favoriteColor");
	// var newColor =
	// document.querySelector('input[name="favoriteColor"]:checked').value;
	// Wait for user input
	var prev = null;
	for (var i = 0; i < colors.length; i++) {
		colors[i].addEventListener('change', function() {
			if (prev != null) {
				alert("So you like " + this.value + " more than " + prev.value
						+ " now?");
				for (var j = 0; j < colors.length; j++) {
					colors[j].style.backgroundColor = this.value;
				}
			}
			if (this !== prev) {
				prev = this;
			}
		});
	}
});

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// Hide the name if shown.
// Show the name if hidden.

document.addEventListener("DOMContentLoaded", function(event) {
	var empName = document.getElementsByClassName("empName");

	for (var i = 0; i < empName.length; i++) {
		empName[i].addEventListener('mouseover', function() {
			this.style.color = "white"
		});
		empName[i].addEventListener('mouseout', function() {
			this.style.color = "black"
		});
	}
});

// 10. Current Time
// Regarding this element:
// <h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.

document.addEventListener("DOMContentLoaded", function(event) {
	var date = Date.now(), second = 1000;

	function pad(num) {
		return ('0' + num).slice(-2);
	}

	function updateClock() {
		var clockEl = document.getElementById('currentTime'), dateObj;
		date += second;
		dateObj = new Date(date);
		clockEl.innerHTML = pad(dateObj.getHours()) + ':'
				+ pad(dateObj.getMinutes()) + ':' + pad(dateObj.getSeconds());
	}

	setInterval(updateClock, second);
});

// 11. Delay
// Regarding this element:
// <p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a
// random color.

document.addEventListener("DOMContentLoaded", function(event) {
	var helloColor = document.getElementById('helloWorld');

	helloColor.addEventListener('click', function() {
		setTimeout(func, 3000);
		function func() {
			var color = Math.floor(Math.random() * Math.pow(256, 3)).toString(
					16);
			while (color.length < 6) {
				color = "0" + color;
			}
			helloColor.style.color = "#" + color;
		}
	});

});

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).

function walkTheDOM(node, func) {
	func(node);
	node = node.firstChild;
	while (node) {
		walkTheDOM(node, func);
		node = node.nextSibling;
	}
}
function showwalkTheDOM() {
	walkTheDOM(document.body, function(node) {
		console.log(node);
	});
}
