/**
 * 
 * 
 */
console.log();
// 1. Fibonacci
// Define function: fib(n)
// Return the nth number in the fibonacci sequence.

function fib(n) {
	var a = 1, b = 0, temp;

	while (n >= 0) {
		temp = a;
		a = a + b;
		b = temp;
		n--;
	}

	return b;
}

function showfib() {
	console.log(fib(8));
}
// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.

function bubbleSort(a) {
	var swapp;
	var n = a.length - 1;
	var x = a;
	do {
		swapp = false;
		for (var i = 0; i < n; i++) {
			if (x[i] < x[i + 1]) {
				var temp = x[i];
				x[i] = x[i + 1];
				x[i + 1] = temp;
				swapp = true;
			}
		}
		n--;
	} while (swapp);
	return x;
}
function showbubbleSort() {
	console.log(bubbleSort([ 12, 345, 4, 546, 122, 84, 98, 64, 9, 1, 3223, 455,
			23, 234, 213 ]));
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.

function reverseString(str) {
	var splitString = str.split("");
	var reverseArray = splitString.reverse();
	var joinArray = reverseArray.join("");
	return joinArray;
}
function showreverseString() {
	console.log(reverseString("Hello, World!"));
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.

function factorial(x) {
	if (x === 0) {
		return 1;
	}
	return x * factorial(x - 1);
}
function showfactorial() {
	console.log(factorial(5));
}
// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length)
// inclusively.
// If incorrect input is entered, use the alert function and describe why the
// input was incorrect.

function substring(someStr, length, offset) {
	var strLength = someStr.length;
	var lengthNum = Number(length);
	var offsetNum = Number(offset);
	if (lengthNum < 0 || lengthNum + offsetNum > strLength) {
		alert("Invalid Length");
		return;
	}
	if (offsetNum < 0 || offsetNum > strLength) {
		alert("Invalid offset");
		return;
	}
	return someStr.substring(offsetNum, offsetNum + lengthNum);
}
function showsubString() {
	var someString = document.getElementById('SomeString').value;
	var offset = document.getElementById('offset').value;
	var subStringLength = document.getElementById('subStringLength').value;
	console.log(substring(someString, subStringLength, offset));
}

// 6. Even Number Define function: isEven(someNum) Return true if
// even, false if odd. Do not use % operator.

function isEven(someNum) {
	if (someNum < 0) {
		someNum = -someNum;
	}
	let b = Math.floor(someNum / 2)
	for (var i = 1; i <= b; i++) {
		someNum = someNum - 2;
		if (someNum == 1) {
			return false;
		}
	}
	return true;
}

function showisEven() {
	console.log(isEven(11));
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false

function isPalindrome(someStr) {
	var re = /[^A-Za-z0-9]/g;
	someStr = someStr.toLowerCase().replace(re, '');
	var len = someStr.length;
	for (var i = 0; i < len / 2; i++) {
		if (someStr[i] !== someStr[len - 1 - i]) {
			return false;
		}
	}
	return true;
}

function showisPalindrome() {
	console.log(isPalindrome("racecar"));
}

// 8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape. Assume this
// String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
// Example for printShape("Diamond", 5, "*");
// *
// ***
// *****
// ***
// *

function printShape(shape, height, character) {
	let heightNum = Number(height);
	let str = '';
	if (shape == 'square') {
		for (let i = 0; i < heightNum; i++) {
			for (let j = 0; j < heightNum; j++) {
				str += character;
			}
			str += '\n';
		}
		console.log(str);
	}
	if (shape == 'triangle') {
		for (let i = 0; i < heightNum; i++) {
			for (let j = 0; j < i + 1; j++) {
				str += character;
			}
			str += '\n';
		}
		console.log(str);
	}
	if (shape == 'diamond') {
		let limit = heightNum;
		let space = limit;
		for (i = 1; i <= limit; i++) {
			for (j = 1; j <= space; j++) {
				str += " ";
			}
			space--;
			for (j = 1; j <= 2 * i - 1; j++) {
				str += character;
			}
			str += "\n";
		}
		space = 2;
		for (i = 1; i <= limit; i++) {
			for (j = 1; j <= space; j++) {
				str += " ";
			}
			space++;
			for (j = 1; j <= 2 * (limit - i) - 1; j++) {
				str += character;
			}
			str += "\n";
		}
		console.log(str);
	}
}

function showprintShape() {
	printShape('square', 5, '@');
	printShape('triangle', 7, '%');
	printShape('diamond', 9, '$');
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.

function traverseObject() {
	let someObj = {
		a : 'value1',
		b : 'value2',
		c : 'value3',
		d : 'value4'
	};
	for ( let property1 in someObj) {
		console.log('property= ' + property1);
		console.log('value= ' + someObj[property1]);
	}
}

function showtraverseObject() {
	traverseObject();
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.

function deleteElement() {
	someArray = [ 'a', 'b', 'c', 'd', 'e', 'f' ];
	console.log('before delete: ' + someArray);
	delete someArray[3];
	console.log('after delete: ' + someArray);
}

function showdeleteElement() {
	deleteElement();
}

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.

function spliceElement() {
	someArray = [ 'a', 'b', 'c', 'd', 'e', 'f' ];
	console.log('before splice: ' + someArray);
	console.log('before splice length: ' + someArray.length);
	someArray.splice(3, 1);
	console.log('after splice: ' + someArray);
	console.log('after splice length: ' + someArray.length);
}

function showspliceElement() {
	spliceElement();
}

// 12. Defining an object using a constructor Define a function
// Person(name, age) The following line should set a Person object to the
// variable john: var john = new Person("John", 30);

function Person(name, age) {
	this.firstName = name;
	this.year = age;
}

function showPerson() {
	let john = new Person("John", 30);
	console.log(john);
}

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// var john = getPerson("John", 30);

function getPerson(name, age) {
	firstName: name;
	year: age;
	return new Person(name, age);
}

function showgetPerson() {
	let john = getPerson("John", 30);
	console.log(john);
}

