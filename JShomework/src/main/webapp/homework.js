/**
 * 
 */

// Question 1

 function fib(n){
 let a = 1;
 let b = 1;
 for (let i = 3; i < n; i++){
 let c = a + b
 a = b
 b = c
 }
 return b;
 }	
 alert ( fib(13) );
// Question 2
 
	
 function bubble_Sort([]){
 var swap;
 var n = a.length-1;
 var x=a;
 do {
 swap = false;
 for (var i=0; i < n; i++)
 {
 if (x[i] < x[i+1])
 {
 var temp = x[i];
 x[i] = x[i+1];
 x[i+1] = temp;
 swap = true;
 }
 }
 n--;
 } while (swap);
 return x;
 }

// Question 3
 
 function reverseString(str) {
 if (str === "") // This is the terminal case that will end the recursion
 return "";
  
 else
 return reverseString(str.substr(1)) + str.charAt(0);
 }
 reverseString('francesca');
 //console.log(reverseString('francesca')) type this in to browser console.

// Question 4
 
 function factorial(n) {
 return n ? n * factorial(n - 1) : 1;
 }
 alert( factorial(5) );
// put number in ^ here

// Question 5
 
 function substring(someStr, length, offset){
 if(offset < 0){
 alert("Offset is less than zero");
 }
 else if(offset+length > someStr.length){
 alert("Offset is greater than length of the string");
 }
 else{
 return someStr.substr(offset, offset+length);
 }
 }
// Question 6
 
 function isEven(n) {
 n = Number(n);
 //return n === 0 || !!(n && !(n%2));
 //}else{
 function isOdd(n) {
 return isEven(Number(n) + 1);
 }
// type console.log(isEven(numberhere))

// Question 7
 
 function checkPalindrome(str) {
 return str == str.split('').reverse().join('');
 }
 console.log(checkPalindrome('cheese'))

// Question 8

function printShape(shape,height,character){
	if(shape == "Triangle"){
		for(i = 0; i < height; i++){
			for(j = 0; j <= i; j++){
				console.log(character);
			}
			
			console.log("\n");
		}
	}else if(shape == "Square"){
		for(i = 0; i < height; i++){
			for(j= 0; j < height; j++){
				console.log(character);
			}
			
			console.log("\n");
		}
	}else if(shape == "Diamond"){
		
		
		for(i = 0; i < height/2+.5; i++){
			for(j = 0; j<height/2-.5-i;j++){
				console.log("p");
			}

			for(k = 0; k < 2*i+1; k++){
				console.log(character);
			}
			
			for(j = 0; j<height/2-.5-i;j++){
				console.log("p");
			}

			console.log("\n");
		}
		
		for(i = height/2-.5; i > 0; i--){
			for(j = height/2+.5-i; j > 0; j--){
				console.log("p");
			}
			
			for(k = i; k > 0; k--){
				console.log("*");
			}
			
			for(j = height/2+.5-i; j > 0; j--){
				console.log("p");
			}
			
			console.log("\n");		
		}
	}
}
printShape("Diamond", 5, "*");





// Question 9

 let superHero = {
 name : 'PizzaMannh',
 ability : 'Delivering pizza to the legged ones',
 'Andrew' : "wait, is Andrew a thing?"
			
 }
 for(x in superHero){
 console.log(superHero, superHero.values)
 }

// Question 10
 
 let fruits = ["Banana", "Orange", "Apple", "Mango"];
 console.log(fruits, fruits.values);
 console.log(fruits.length);
 delete fruits[2];
 console.log(fruits, fruits.values);
 console.log(fruits.length);

// Question 11
 
 let fruits = ["Banana", "Orange", "Apple", "Mango"];
 console.log(fruits, fruits.values);
 console.log(fruits.length);
 fruits.splice(3,1);
 console.log(fruits, fruits.values);
 console.log(fruits.length);

// Question 12
 
 function Person(Name, Age) {
 this.personName = Name;
 this.personAge = Age;
 }

 let john = new Person("John", 30);
 console.log(john)

// Question 13
 
 function getPerson (name, age) {
 personName : name;
 personAge : age;
 return new Person(name, age);
 };

 let man = getPerson('John', 30);
 console.log(man);
// uses person object from previous question.

// Part 2

// Question1
 
 function getUSA(){
 var list = document.getElementsByTagName("SPAN");
 for(let i = 0; i < list.length - 1; i++){
 if(list[i].innerHTML == "USA"){
 console.log(list[i].innerHTML)
 }
 }
 }

 getUSA();
// Question 2
 
 function salespeople() {
 let table = document.getElementsByTagName('table')[0];
 for (let i = 0; i < table.rows.length; i++) {
 if (table.rows[i].cells.length) {
 var name = (table.rows[i].cells[0].textContent.trim());
 var dept = (table.rows[i].cells[1].textContent.trim());
 if (dept == 'Sales'){
 console.log(name);
 }
 }
 }
 }

// Question 3

 function getAnchorChildren(){

 let anch = document.getElementsByTagName("a");
 let anchLength = anch.length;
 for(let i = 0; i < anchLength; i++){
 if(anch[i].hasChildNodes()){
 let children = anch[i].children
 for(let j = 0; j < children.length; j++){
 if(children[j].tagName == "SPAN"){
 console.log(children[j].innerHTML);
 }
 }
 }
 }
 }
 getAnchorChildren(); //type this in to the console.

// Question 4
	
 function getHobbies() {
 let conceptName = document.getElementsByTagName('SELECT');
	
 alert(conceptName[2].value)
 }
 getHobbies();
// Question 5
 
 function getCustomAttribute(){

 let custAttr = document.querySelectorAll('[ data-customAttr]');
 for(let i = 0; i < custAttr.length; i++){
 console.log(custAttr[i].tagName + " : " + custAttr[i].innerHTML);
 }
 }
 getCustomAttribute();// put this in the log

// Question 6

document.getElementById("sum").textContent = 0;

let selector1 = document.getElementById("num1");
if (selector1.addEventListener) {
	selector1.addEventListener("change", function() {
		display(selector1)
	}, true);
}

let selector2 = document.getElementById("num2");
if (selector2.addEventListener) {
	selector2.addEventListener("change", function() {
		display(selector2)
	}, true);
}

function display(element) {
	
	let sum = document.getElementById("sum");
	let a = parseFloat(sum.textContent) + parseFloat(element.value);
	
	if (typeof (a) == "number" && a !== NaN) {
		sum.textContent = parseFloat(sum.textContent)
				+ parseFloat(element.value);
	}
}

// Question 7

 let skills = document.getElementsByTagName("select");
 if (skills[2].addEventListener) {
 skills[2].addEventListener("input", function() {
 alerted(skills[2])
 }, true);
 }
 function alerted(element) {
 alert("Are you sure " + element.value + " is one of your skills?");
 }

// Question 8

let radioColor = document.getElementsByName("favoriteColor");
radioColor[0].addEventListener('click', function() {
	favColorChange(radioColor[0])
}, true); // execute on the bubble. Default is true.

if (radioColor[1].addEventListener) {
	radioColor[1].addEventListener('click', function() {
		favColorChange(radioColor[1])
	}, true);
}
if (radioColor[0].addEventListener) {
	radioColor[2].addEventListener('click', function() {
		favColorChange(radioColor[2])
	}, true);
}
if (radioColor[0].addEventListener) {
	radioColor[3].addEventListener('click', function() {
		favColorChange(radioColor[3])
	}, true);
}
let preColor = '';
function favColorChange(color) {
	alert("So you like " + color.value + " more than " + preColor + " now?");
	document.body.style.backgroundColor = color.value;
	preColor = color.value;

}

// Question 9

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

// Question 10

 function startTime() {
 let clock = document.getElementById("currentTime");
 var today = new Date(); // all built in methods.
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

// Question 11

 let hello = document.getElementById("helloWorld");

 hello.addEventListener("click",function(){clicky(this)},true); //"this"
// refers to hello

 function clicky(someArg){
 setTimeout(function(){
 colors = ["red","yellow","blue"];
 someArg.style.color = colors[Math.floor(Math.random()*3)];
 },3000);
 }

// Question 12

function walkTheDOM(node, func) {
	func(node);
	node = node.firstChild;
	while (node) {
		walkTheDOM(node, func);
		node = node.nextSibling;
	}
}

/*
 * function walkTheDOM(node, func) { func(node); node = node.firstChild; while
 * (node) { function walkTheDOM(node, func) { func(node); node =
 * node.firstChild; while (node) { function walkTheDOM(node, func) { func(node);
 * node = node.firstChild; while (node) { walkTheDOM(node, func); node =
 * node.nextSibling; } }
 * 
 * node = node.nextSibling; } }
 * 
 * node = node.nextSibling; } }
 * 
 */

walkTheDOM(document, function(node) {
	console.log("in" + node.textContent);
	console.log(node.length);
});}
