/**
 * 
 */

// Javascript Homework Week 3

//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.

//This returns the nth (in this case, 8th number in the fibonacci sequence)
// 0 1 1 2 3 5 8 13
// 1 2 3 4 5 6 7 8 

function fib(n){
	let arr = [0,1];
	for (let i = 1; i <= n; i++) {
		arr.push(arr[i - 1] + arr[i])
	}
	return arr[n-1]
}

console.log(fib(8));


//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.

// pretty standard 
numArray = [5,2,8,9,1,6,3,2,7,9,9,1,1]
function bubbleSort(numArray){
	let temp;
	for (let y = 0; y < numArray.length; y++){
		for (let x = 1; x < numArray.length - y; x++){
			if (numArray[x-1] > numArray[x]) {
				temp = numArray[x];
				numArray[x] = numArray[x-1];
				numArray[x-1] = temp;
			}
		}
	}
	return numArray;
}
console.log(bubbleSort(numArray));

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.

// Pretty standard
someStr = "reversing this string";
function reverseStr(someStr){
	arr = [];
	for (let x = someStr.length-1; x >= 0; x--){
		arr.push(someStr[x]);
	}
	return arr.join("");
}
console.log(reverseStr(someStr));

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.

// pretty standard
function factorial(someNum){
	if (someNum == 0 || someNum == 1){
		return 1;
	}else{
		return (someNum * factorial(someNum - 1));
	}
}
console.log(factorial(10));

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.

someStr = "1234567890";

function substring(someStr, length, offset){
	if (typeof(someStr) != "string"){
		alert("must enter a String")
	}
	else if (offset + length > someStr.length){
		alert("offset + length is longer than string")
	}else{
		return someStr.slice(offset, (offset + length));
	}
};
console.log(substring(someStr, 7, 3));


//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.

function isEven(someNum){
	let x = someNum/2;
	if (Number.isInteger(x)){
		return true;
	}else{
		return false;
	}
	
}
console.log(isEven(100));

//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false

aString = "ahanaha"
function isPalindrome(someStr){
	arr2 = [];
	arr = someStr.split('');
	for (let x = someStr.length-1; x >= 0; x--){
		arr2.push(arr[x]);
	}
	if (arr.join("") == arr2.join("")){
		return true;
	}else{
		return false;
	}
}
console.log(isPalindrome(aString))


//8. Shapes
//Define function: printShape(shape, height, character)
//shape is a String and is either "Square", "Triangle", "Diamond".
//height is a Number and is the height of the shape. Assume the number is odd.
//character is a String that represents the contents of the shape. Assume this 
//String contains just one character.
//Use a switch statement to determine which shape was passed in.
//Use the console.log function to print the desired shape.
//Example for printShape("Square", 3, "%");
//%%%
//%%%
//%%%
//Example for printShape("Triangle", 3, "$");
//$
//$$
//$$$
//Example for printShape("Diamond", 5, "*");
//  *
// ***
//*****
// ***
//  *


function printShape(shape, height, character){
	switch(shape){
	case "Square": case "square":
		for (let x = 0; x < height; x++){
			console.log(character.repeat(height))
		}
		break;
	case "Triangle": case "triangle":
		for (let x = 1; x <= height; x++){
			console.log(character.repeat(x));
		}
		break;
	case "Diamond": case "diamond":
		for(let i = 1; i <= height; i++){
            txt = "";
            for(let j = i; j < 10; j++){
              txt += " ";
            }
            for(let k = 0; k < (i*2) - 1; k++){
              txt += character;
            }
            console.log(txt);
          }
          var txt = "";
          for(let i = height - 1; i >= 1; i--){
            txt = "";
            for(let j = i; j < 10; j++){
              txt += " ";
            }
            for(let k = 0; k < (i*2) - 1; k++){
              txt += character;
            }
            console.log(txt);
          }
      break;
      
      default: console.log("Must enter square, triangle, or diamond");

	}
}
printShape("Diamond", 4, "@");
printShape("square", 4, "@");
printShape("triangle", 5, "@");


//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.

let obj = {
		name : "bobby",
		title : "boss",
		height : 60,
		weight : 120
}

function traverseObject(someObj){
	let value;
	for (let x in someObj) {
		value = someObj[x]	
		console.log(x, value);
	}
}
traverseObject(obj);


//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.

let arrr = [1,5,7,3,4];
function deleteElement(someArr) {
	console.log(someArr.length)
	
	someArr[3] = "";
	console.log(someArr.length)
}

deleteElement(arrr);

//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.

arr = [1,4,3,2,5,6,6];
function spliceElement(someArr){
	console.log(someArr.length);
	someArr.splice(3,1);
	console.log(someArr.length);
	console.log(someArr);
}
spliceElement(arr);

//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//	var john = new Person("John", 30);

var Person = function(name, age){
	this.name = name;
	this.age = age;
}

var john = new Person("John", 30);
console.log(john);

//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//	var john = getPerson("John", 30);

function getPerson(name, age) {
		personName: name;
		personAge: age;
		return new Person(name, age);	
};
var john1 = getPerson("Johnny", 39);
console.log(john1);


//-----------------------------------------------------------------------------------
//PART II
//
//Part II will focus on Javascript's ability to manipulate the DOM.
//Use the provided index.html
//Put your Javascript in the provided <script> element at the bottom of the page.
//Please put the question itself as a comment above each answer.
//
//NOTE: Part II will be done twice: once with Javascript and once with jQuery.
//	  They should be done separately.
//	  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
//-----------------------------------------------------------------------------------


//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.

// iterate over each element in document object and 
// find where text content == "usa", then returns it.

function getUSA(){
	let elements = document.all;
	for (let x of elements){
		if (x.textContent == "USA"){
			console.log(x.textContent);
		}
	}
}
getUSA();


//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.


function getPeopleInSales(){
	let table = document.getElementsByClassName('empName');
	let depts = document.getElementsByTagName('td');
	
	for (let x = 0; x < depts.length-1; x ++){
		if (depts[x+1].innerText == "Sales"){
			console.log(depts[x].innerText);
		}
	}
}
getPeopleInSales();


//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>

function getAnchorChildren(){
	
	let anchors = document.getElementsByTagName('a');
	let spans = document.getElementsByTagName('span');
	
	for (let x = 0; x < anchors.length; x++){
		
		for (let y = 0; y < spans.length; y++){
			if (anchors[x].contains(spans[y])){
				console.log(spans[y].innerText)
			}
		}
	}
}		
getAnchorChildren();


//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.

function getHobbies(){
	let inputs = document.querySelectorAll('select[name = "skills"] > option[selected="selected"]');

	for (let elem of inputs){
		console.log(elem.innerText);
	}

}
getHobbies();


//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.


function getCustomAttribute(){	
	let elements = document.querySelectorAll('[data-customAttr]');	
	for (let elem of elements){
		console.log(elem.getAttribute("data-customAttr"));
	}
}
// console logs the values of the data-customAttr attribute.
getCustomAttribute();



//6. Sum Event
//NOTE: Write unobtrusive Javascript
//Regarding these elements:
//	<input id="num1" class="nums" type="text"/>
//	<input id="num2" class="nums" type="text"/>
//	<h3>Sum: <span id="sum"></span></h3>
//
//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element


let num1 = document.querySelector('#num1');
let num2 = document.querySelector('#num2');
let sum = 0;
num1.value = 1;
num2.value = 3;

let output = document.querySelector('#sum');
let attrib1 = document.createAttribute("onmousemove");
let attrib2 = document.createAttribute("onmousemove");

attrib1.value = "addup(num1, num2)";
attrib2.value = "addup(num1, num2)";

num1.setAttributeNode(attrib1);
num2.setAttributeNode(attrib2);


function addup(x, y){
	sum = parseInt(x.value) + parseInt(y.value);
	output.innerHTML = sum;
}



//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//	"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.


let skill = document.querySelector('select[name="skills"]');

skill.addEventListener('input', function(){
	alertIt(skill)
}, true);

function alertIt(value){
	alert("Are you sure " + value.value.toUpperCase() + " is one of your skills?")
}

//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//	"So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor


let colors = document.querySelectorAll("input[name='favoriteColor']");

for (let color of colors){
	color.addEventListener("click", function(){

		changeCol(color)
	}, true);
}

let oldColor = " ";

function changeCol(x){
	document.body.style.background = x.value;
	alert(`So you like ${x.value} more than ${oldColor} now?`);
	oldColor = x.value;
	
}

//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//	Hide the name if shown.
//	Show the name if hidden.


let emps = document.querySelectorAll("td[class = 'empName']");
console.log(emps);

for (let emp of emps){
	emp.addEventListener("mouseover", () => viz(emp));
}

function viz(x){
	if (x.style.color === 'white'){
		x.style.color = 'black';
	}else{
		x.style.color = 'white';
	}
}

//10. Current Time
//Regarding this element:
//	<h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.


function time() {
	let timer = document.querySelector("#currentTime");
	let today = new Date();
	let h = today.getHours();
	let m = today.getMinutes();
	let s = today.getSeconds();
	m = check(m);
	s = check(s);
	timer.innerHTML = h + ":" + m + ":" + s;
	let t = setTimeout(time, 500);
}
function check(i) {
	if (i <= 9) {
		// this is done to add the zero before single digit numbers.
		i = "0" + i
	};
	return i;
}

time();


//11. Delay
//Regarding this element:
//	<p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.

colors = ['red','green','blue','yellow','orange','purple'];

let target = document.getElementById('helloWorld');
console.log(target);
target.addEventListener('click', function(){
	setTimeout(function() {
		target.style.color = colors[Math.floor(Math.random()*colors.length)];
	}, 3000);
});
	
//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).

function walkTheDOM(node, func){
	func(node);
	node = node.firstChild;
	while (node){
		walkTheDOM(node, func);
		node = node.nextSibling;
	}	
}
walkTheDOM(document, function(node){
	// uncomment below to console log each node.
	//console.log("current node: " + node);
});


//This also traverses each element in DOM 
//function traverseEachElement(){
//	let elements = document.all;
//	for (let x of elements){
//
//	}
//}
//traverseEachElement();



