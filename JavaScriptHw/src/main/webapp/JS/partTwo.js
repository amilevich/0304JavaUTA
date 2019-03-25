/**
 * 
 */


/*
 * 1. USA
 * Define function getUSA()
 * Find the html element that contains "USA".
 * Print that element's contents.
*/

function getUSA(){
	let elem1 = document.getElementsByTagName("h1");
	document.getElementById("demo").innerHTML = elem1[0].innerHTML;	
}
getUSA();

/*
 * 2. Sales
 * Define function getPeopleInSales()
 * Print the names of all the people in the sales department.
*/

function getPeopleInSales(){
	
	let table = document.getElementsByTagName("td");
	
	for(i = 0; i < table.length; i++){
		if(table[i].textContent == "Sales"){
			console.log(table[i-1].textContent);
		}
	}
}

getPeopleInSales();

/*
 * 3. Click Here
 * Define function getAnchorChildren()
 * Find all anchor elements with a <span> child.
 * Print the contents of <span>
 */

function getAnchorChildren(){
	
	let a = document.getElementsByTagName("a");
	let span = document.getElementsByTagName("span");
	
	for(i = 0; i < a.length; i++){
		for(j = 0; j < span.length; j++){
			if(a[i].contains(span[j])){
				console.log(span[j].textContent);
			}
		}
	}	
}

getAnchorChildren();

/*
 * 4. Hobbies
 * Define function getHobbies()
 * Find all checked options in the 'skills' select element.
 * Print the value and the contents.
 */

function getHobbies(){
	
	let select = document.getElementsByTagName("select");
	
	for(var i=0; i< select.length; i++){
		if(select[i].selected=="selected")
			console.log(select[i].value);
	}
	
}

getHobbies();

/*
 * 5. Custom Attribute
 * Define function getCustomAttribute()
 * Find all elements with "data-customAttr" attribute
 * Print the value of the attribute.
 * Print the element that has the attribute.
 */

function getCustomAttribute(){
	
	let custAttribute = document.getElementsByTagName("*");
	
	for(var i = 0; i < custAttribute.length; i++){
		if(custAttribute[i].getAttribute("data-customAttr")){
			console.log(custAttribute[i].getAttribute("data-customAttr"));
			console.log(custAttribute[i].textContent);
		}
	}
}

getCustomAttribute();

/*
 * 6. Sum Event
 * NOTE: Write unobtrusive Javascript
 * Regarding these elements:
 * 	<input id="num1" class="nums" type="text"/>
 * 	<input id="num2" class="nums" type="text"/>
 * 	<h3>Sum: <span id="sum"></span></h3>
 * Define onchange event handler.
 * Add <input> element values.
 * Put the sum in the <span> element.
 * If values cannot be added, put "Cannot add" in the <span> element
 */

/*let num1 = document.getElementById("num1");
let num2 = document.getElementById("num2"); 

num1.addEventListener('change', function(){
	
	
});

num2.addEventListener('change', function(){
	
});*/

/*
 * 7. Skills Event
 * NOTE: Write unobtrusive Javascript
 * When user selects a skill, create an alert with a message similar to:
 * 		"Are you sure CSS is one of your skills?"
 * NOTE: no alert should appear when user deselects a skill.
 */

let skills = document.getElementsByTagName("select");

if(skills[2].addEventListener){
	skills[2].addEventListener("input", function(){
		alertSkill(skills[2])
	}, true);
}

function alertSkill(skill){
	
	alert("Are you sure " + skill.value + " is one of your skills?");
}

/*
 * 8. Favorite Color Event
 * NOTE: Write unobtrusive Javascript
 * NOTE: This is regarding the favoriteColor radio buttons.
 * When a user selects a color, create an alert with a message similar to:
 * 		"So you like green more than blue now?"
 * In this example, green is the new value and blue is the old value.
 * Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
 */

let favoriteColor = document.getElementsByName("favoriteColor");

if(favoriteColor[0].addEventListener){
	favoriteColor[0].addEventListener("click", function(){
		changeColors(favoriteColor[0])}, true);
}
if(favoriteColor[1].addEventListener){
	favoriteColor[1].addEventListener("click", function(){
		changeColors(favoriteColor[1])}, true);
}
if(favoriteColor[2].addEventListener){
	favoriteColor[2].addEventListener("click", function(){
		changeColors(favoriteColor[2])}, true);
}
if(favoriteColor[3].addEventListener){
	favoriteColor[3].addEventListener("click", function(){
		changeColors(favoriteColor[3])}, true);
}

let previous = "";

function changeColors(color){
	alert("So you like " + color.value + " more than " + previous + " now?")
	document.body.style.background = color.value;
	previous = color.value;
}

/*
 * 9. Show/Hide Event
 * NOTE: Write unobtrusive Javascript
 * When user hovers over an employees name:
 * 		Hide the name if shown.
 * 		Show the name if hidden.
 */

/*let table = document.getElementsByTagName("td");

for(i = 0; i < table.length; i++){
	
	table[i].addEventListener("mouseenter", function textVisibility(){
		
		if (table[i].style.visibility === 'hidden') {
		    table[i].style.visibility = 'visible';
		  } else {
		    table[i].style.visibility = 'hidden';
		  }
	});*/


/*
 * 10. Current Time
 * Regarding this element:
 * 	<h5 id="currentTime"></h5>
 * Show the current time in this element in this format: 9:05:23 AM
 * The time should be accurate to the second without having to reload the page.
 */

function currentTime(){
	
	let currentT = document.getElementById("currentTime");
	
	var time = new Date();
	var hours = time.getHours();
	var minutes = time.getMinutes();
	var seconds = time.getSeconds();
	
	currentT.innerHTML = hours + ":" + minutes + ":" + seconds;
	
	var timer = setTimeout(currentTime, 600);
}
currentTime();

/*
 * 11. Delay
 * Regarding this element:
 * 		<p id="helloWorld">Hello, World!</p>
 * Three seconds after a user clicks on this element, change the text to a random color.
 */

let elem2 = document.getElementById('helloWorld');

elem2.addEventListener('click', function(){changeColor(this)}, true);

function changeColor(colors){

	setTimeout(function(){
		getColor = ["red", "blue", "green"];
		colors.style.color = getColor[Math.floor(Math.random()*2)];}, 3000);
}

/*
 * 12. Walk the DOM
 * Define function walkTheDOM(node, func)
 * This function should traverse every node in the DOM. Use recursion.
 * On each node, call func(node).
 */

function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }} 
