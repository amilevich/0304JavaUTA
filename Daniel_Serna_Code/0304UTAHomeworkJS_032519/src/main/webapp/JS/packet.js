/**
 * Daniel Serna
 * 03/20/19
 * 
 * JavaScript homework Revature UTA 0304 batch
 */

/*
Javascript Packet
*/

/*
-----------------------------------------------------------------------------------
PART I

Create a single Javascript file called packet.js to answer these questions.
Please put the question itself as a comment above each answer.
-----------------------------------------------------------------------------------
*/

/*
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n) {
	if(n < 2){
		return n
	}
	return fib(n - 1) + fib(n - 2)
}

console.log(fib(12)) // UNCOMMENT THIS 

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/


numArray = [34, 21, 3, 7, 1]

for( let r = 0; r < numArray.length; r++)
	{
		console.log(numArray[r]) // UNCOMMENT THIS
	}

function bubbleSort(numArray)
{
	let x = 0
	for(let r = 0; r < numArray.length - 1; r++)
	{
		for(let c = 0; c < numArray.length - 1; c++)
		{
			if(numArray[c] > numArray[c+1])
			{
				x = numArray[c]
				numArray[c] = numArray[c+1]
				numArray[c+1] = x
			}
		}
	}
	
	for( let r = 0; r < numArray.length; r++)
	{
		console.log(numArray[r]) // UNCOMMENT THIS
	}
}

console.log(bubbleSort(numArray)); // UNCOMMENT THIS

/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/


// Reference: https://medium.freecodecamp.org/how-to-reverse-a-string-in-javascript-in-3-different-ways-75e4763c68cb
function reverseStr(someStr){
	return someStr.split("").reverse().join("");
}

var someStr = "apple"
	
alert(reverseStr(someStr)) // UNCOMMENT THIS

/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
	
// Reference: https://www.dyclassroom.com/recursion-algorithm/factorial
function factorial(someNum) {
	if(someNum == 0 || someNum == 1)
	{
		return 1;
	}
	else
	{
		return someNum * factorial(someNum - 1)
	}
}

alert(factorial(6)) // UNCOMMENT THIS

/*
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/

function substring(someStr, length, offset) {
	if(typeof someStr != "string") {
		alert("Wrong type of input"); 
	} else {
		alert(someStr.substring(length, offset));
	}
}

substring("some one buy me a burger", 3, 10); // UNCOMMENT THIS

/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

// Reference: https://stackoverflow.com/a/22312556
function isEven(someNum)
{
	if(someNum & 1)
	{
		console.log("Number is odd")
	}
	else
	{
		console.log("Number is even")
	}
}

isEven(5); // UNCOMMENT THIS

/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/

function isPalindrome(someStr) {
	if(someStr == reverseStr(someStr))
	{
		console.log("String is a palindrome")
	}
	else
	{
		console.log("String is NOT a palindrome")
	}
}

isPalindrome("apple") // UNCOMMENT THIS

/*
8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$
Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *
*/


function printShape(shape, height, character) {
	if(shape == "square")
	{
		for(let i = 0; i < height; i++)
		{
			for(let j = 0; j < height; j++)
			{
				console.log(character); 
			}
			console.log("\n")
		}
	}
	else if(shape == "triangle")
	{
		for(let r = 0; r < height; r++)
		{
			for(let c = 0; c <= r; c++)
			{
				console.log(character)
			}
			console.log("\n")
		}
	}
	else if(shape == "diamond")
	{
		
	}
}

printShape("triangle", 5, "&") // UNCOMMENT THIS

/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/

// Reference: https://stackoverflow.com/a/9354853
function traverseObject(someObj)
{
	for(var theObj in someObj)
	{
		console.log(someObj[theObj]);
	}
}

// Reference: https://www.dyn-web.com/tutorials/object-literal/
var myObject = {
	someStr : 'some string value',
	someNum : 2,
	someBool : false
}

traverseObject(myObject); // UNCOMMENT THIS

/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/

function deleteElement(someArr)
{
	console.log(someArr.length)
	
	// delete the third element of array passed in
	someArr.splice(3,1);
	
	someArr.push('');
	
	console.log(someArr.length)
}

var myArray = [6, 53, 2, 99, 10, 2]

deleteElement(myArray); // UNCOMMENT THIS

/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/

function spliceElement(someArr)
{
	console.log(someArr.length)
	
	// delete the third element of array passed in
	someArr.splice(3,1);
	
	console.log(someArr.length)
}

var myArray = [6, 53, 2, 99, 10, 2] // UNCOMMENT THIS

/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);
*/

// Reference: https://www.w3schools.com/js/js_object_constructors.asp
function Person(first, age)
{
	this.first = first; 
	this.age = age; 
}

var john = new Person("John", 30);

/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
*/

// this is my person, 'P'
function P(name, age) 
{
	var myPerson = {
			someName : name,
			someAge : age
		}
	
	return myPerson;
}

var joe = new P("Jake", 22);



