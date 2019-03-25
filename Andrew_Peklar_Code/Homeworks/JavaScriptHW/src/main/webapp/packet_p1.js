/**
 *
 */

/***********************************************************************************************/

// 1. Fibonacci
// Define function: fib(n)
// Return the nth number in the fibonacci sequence.
var fib = function(n) {
	if (n <= 1) {
		return n;
	}
	return fib(n - 1) + fib(n - 2);
}

console.log("5th fibonacci number is: " + fib(5));
/***********************************************************************************************/

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
var bubbleSort = function(numArray) {
	numArray: [];
	length = numArray.length;

	do {
		swap = false;
		for (var i = 0; i != length - 1; i++) {
			if (numArray[i - 1] > numArray[i]) {
				tmp = numArray[i];
				numArray[i] = numArray[i - 1];
				numArray[i - 1] = tmp;
				swap = true;
			}
		}
	} while (swap == true);
	return numArray;
}

console.log("Sort: [5, 7, 3, 4, 2, 8, 9, 1, 6] ==> " + bubbleSort([5, 7, 3, 4, 2, 8, 9, 1, 6]));
/***********************************************************************************************/

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
var reverseStr = function(someStr) {
	return someStr.split("").reverse().join("");
}

console.log("javascript <==> " + reverseStr("javascript"));
/***********************************************************************************************/

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
var factorial = function(someNum) {
	if (someNum == 1) {
		return 1;
	}
	return factorial(someNum - 1) * someNum;
}

console.log("4*3*2*1 = " + factorial(4));
/***********************************************************************************************/

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length)
// inclusively.
// If incorrect input is entered, use the alert function and describe why the
// input was incorrect.
var substring = function(someStr, length, offset) {
	if (length > someStr.length) {
		alert("Input length is larger than String length");
	} else if (offset < 0) {
		alert("Input")
	}
}

/***********************************************************************************************/

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
var isEven = function(someNum) {
	return ((someNum & 1) ? false : true);
}

console.log("The number 4 is even: " + isEven(4));
console.log("The number 5 is even: " + isEven(5));
/***********************************************************************************************/

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
var isPalindrome = function(someStr) {
	someStr = someStr.toLowerCase();
	var rev = someStr.split("").reverse().join("");
	return (rev == someStr);
}

console.log("Kayak is a palindrome: " + isPalindrome("Kayak"));
console.log("Coding is a palindrome: " + isPalindrome("Coding"));
/***********************************************************************************************/

// 8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
var printShape = function(shape, height, character) {
	var result = "";
	switch (shape) {
	case "Square":
		for (var i = 0; i < height; i++) {
			for (var j = 0; j < height; j++) {
				result += character;
			}
			result += '\n';
		}
		break;
	case "Triangle":
		for (var i = 0; i < height; i++) {
			for (var j = 0; j < height; j++) {
				if (i >= j) {
					result += character;
				} else {
					result += ' ';
				}
			}
			result += '\n';
		}
		break;
	case "Diamond":
		var numDiamonds = 1;
		for (var i = 0; i < height; i++) {
			for (var j = 0; j < height; j++) {
				var k = (height - numDiamonds) / 2;
				if (j < k || j >= height - k) {
					result += ' ';
				} else {
					result += character;
				}
			}
			if ((i + 1) <= height / 2) {
				numDiamonds += 2;
			} else {
				numDiamonds -= 2;
			}
			result += '\n';
		}
		break;
	default:
		alert("Invalid Shape!");
		break;
	}
	return result;
}

console.log(printShape("Square", 3, "%"));
console.log(printShape("Triangle", 3, "$"));
console.log(printShape("Diamond", 5, "*"));
/***********************************************************************************************/

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
var traverseObject = function(someObj) {
	console.log(someObj);
}

var cat = {
	type : "tabby",
	color : "orange",
	name : "Garfield"
}
traverseObject(cat);
/***********************************************************************************************/

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
var deleteElement = function(someArr) {
	console.log(someArr.length);
	delete someArr[2];
	console.log(someArr.length);
}

console.log(deleteElement[8, 6, 7, 5, 3, 0, 9]);
/***********************************************************************************************/

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
var spliceElement = function(someArr) {
	console.log(someArr.length);
	someArr.splice(2, 1);
	console.log(someArr.length);
}

console.log(spliceElement[8, 6, 7, 5, 3, 0, 9]);
/***********************************************************************************************/
// 12. Defining an object using a constructor
// Define a function Person(name, age)
var Person = function(name, age) {
	this.name = name;
	this.age = age;
}

var John = new Person("John", 30);
console.log(John);
/***********************************************************************************************/
// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// var john = getPerson("John", 30);
var getPerson = function(name, age) {
	person = {
		firstName : name,
		age : age
	}
	return person;
}

var John = getPerson("John", 30);
