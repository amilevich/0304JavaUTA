/**
 * 
 */

/* - - - - - - - Question 1 - - - - - - - 
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

console.log('- - - - - - - Question 1 - - - - - - -');
function fib(n){
	if(n < 0)
		return -1;
	if(n == 1)
		return 0;
	if(n == 2)
		return 1;
	else
		return fib(n-1) + fib(n-2)	
}
console.log('fib(10) = ' + fib(10));
console.log('fib(20) = ' + fib(20));

/* - - - - - - - Question 2 - - - - - - - 
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

console.log('- - - - - - - Question 2 - - - - - - -');
function bubbleSort(numArray) {
	for (i = 0; i < numArray.length; i++) {
		for (j = 0; j < numArray.length - i - 1; j++) {
			if (numArray[j] > numArray[j + 1]) {
				numArray[j] = numArray[j + 1] + numArray[j];
				numArray[j + 1] = numArray[j] - numArray[j + 1];
				numArray[j] = numArray[j] - numArray[j + 1];
			}
		}
	}
	return numArray;
}
arr = [ 9, 6, 7, 8, 4, 5, 2, 3, 1];
console.log('Pre-BubbleSort: ' + arr);
arr2 = bubbleSort(arr);
console.log('Post-BubbleSort: ' + arr2);

/* - - - - - - - Question 3 - - - - - - -
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/

console.log('- - - - - - - Question 3 - - - - - - -');
function reverseStr(someStr) {
	if(someStr.length == 1)
		return someStr;
	return reverseStr(someStr.substring(1)) + someStr.charAt(0);
}
console.log('Input: ReverseMeIDareYou');
console.log('Output: ' + reverseStr('ReverseMeIDareYou'));

/* - - - - - - - Question 4 - - - - - - -
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/

console.log('- - - - - - - Question 4 - - - - - - -');
function factorial(someNum)
{
	if(someNum <= 1)
		return 1;
	return someNum * factorial(someNum-1);
}
console.log('factorial(5) = ' + factorial(5));
console.log('factorial(10) = ' + factorial(10));

/* - - - - - - - Question 5 - - - - - - -
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/

console.log('- - - - - - - Question 5 - - - - - - -');
function substring(someStr, length, offset) {
	if (offset > someStr.length) {
		alert('Offset exceeds string length!');
		return "";
	}
	if (offset + length > someStr.length) {
		alert('Specified length exceeds string boundaries.');
		return "";
	}
	if (offset < 0) {
		alert('Offset must be non-negative! Defaulting to 0.');
		return substring(someStr,length,0);
	}
	stringRes = "";
	for(i = 0; i < length; i++){
		stringRes += someStr.charAt(offset+i);
	}
	return stringRes;
}
console.log('substring("StringTest",5,1): ' + substring("StringTest",5,1));
console.log('substring("StringTest",4,7): ' + substring("StringTest",4,7));
console.log('substring("StringTest",3,-1): ' + substring("StringTest",3,-1));

/*- - - - - - - Question 6 - - - - - - - 
6. Even Number Define function:
isEven(someNum) Return true if even, false if odd. Do not use % operator.
*/

console.log('- - - - - - - Question 6 - - - - - - -');
function isEven(someNum) {
	if(someNum < 0)
		someNum *= -1;
	if(parseInt(someNum/2) == parseInt((someNum+1)/2))
		return true;
	else return false;
}
console.log('isEven(-2): ' + isEven(-2));
console.log('isEven(-1): ' + isEven(-1));
console.log('isEven(0): ' + isEven(0));
console.log('isEven(1): ' + isEven(1));
console.log('isEven(2): ' + isEven(2));

/* - - - - - - - Question 7 - - - - - - -
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/

console.log('- - - - - - - Question 7 - - - - - - -');
function isPalindrome(someStr) {
	if(someStr == reverseStr(someStr))
		return true;
	else
		return false;
}

console.log('isPalindrome(racecar) = ' + isPalindrome('racecar'));
console.log('isPalindrome(racecars) = ' + isPalindrome('racecars'));



/* - - - - - - - Question 8 - - - - - - -
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

console.log('- - - - - - - Question 8 - - - - - - -');
function printShape(shape, height, character) {
	if(shape == 'Square')
		return printSquare(height,character);
	if(shape == 'Triangle')
		return printTriangle(height,character);
	if(shape == 'Diamond')
		return printDiamond(height,character);
	return 0;
}
function printSquare(height, character) {
	for(i = 0; i < height; i++) {
		line = "";
		for(j = 0; j < height; j++) {
			line += character.charAt(0);
		}
		console.log(line);
	}
}
function printTriangle(height, character) {
	line = "";
	for(i = 0; i < height; i++) {
		for(j = 0; j <= i; j++) {
			line += character.charAt(0);
		}
		line += '\n';
	}
	console.log(line);
}
function printDiamond(height, character) {
	for(i = 0; i < height/2; i++) {	// First half of lines including middle
		line = "";
		for(j = 0; j < height; j++) {
			if(Math.abs((parseInt(height/2))-j)<=i){
				line += character.charAt(0);
			}
			else
				line+=' ';
		}
		console.log(line);
	}
	for(i = parseInt(height/2)-1; i >= 0; i--) { // remaining half
		// swapped i initial and ending conditions to reverse behavior.
		line = "";
		for(j = 0; j < height; j++) {
			if(Math.abs((parseInt(height/2))-j)<=i){
				line += character.charAt(0);
			}
			else
				line+=' ';
		}
		console.log(line);
	}
		
	
}

printShape('Square',5,'S');
printShape('Triangle',5,'T');
printShape('Diamond',5,'D');

/* - - - - - - - Question 9 - - - - - - -
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/

console.log('- - - - - - - Question 9 - - - - - - -');
function traverseObject(obj) {
	for (var property in obj)
		console.log(property + ": " + obj[property]);
}
testObject = { name: "Bob",
	age: 20,
	hobby: "none"
}	
traverseObject(testObject);

/* - - - - - - - Question 10 - - - - - - -
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/

console.log('- - - - - - - Question 10 - - - - - - -');
function deleteElement(someArr) {
	console.log(someArr);
	console.log("Length pre-delete: " + someArr.length);
	delete someArr[2]; 
	console.log(someArr);
	console.log("Length post-delete: " + someArr.length);
}
testArr = [1,2,3,4,5,6,7,8];
deleteElement(testArr);

/* - - - - - - - Question 11 - - - - - - -
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/

console.log('- - - - - - - Question 11 - - - - - - -');
function spliceElement(someArr) {
	console.log(someArr);
	console.log("Length pre-splice: " + someArr.length);
	someArr.splice(2,1); 
	console.log(someArr);
	console.log("Length post-splice: " + someArr.length);
}
testArr = [1,2,3,4,5,6,7,8];
spliceElement(testArr);

/* - - - - - - - Question 12 - - - - - - -
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);
*/

console.log('- - - - - - - Question 12 - - - - - - -');
function Person(name,age) {
	this.name = name;
	this.age = age;
}
var john = new Person("John", 30);
console.log(john);

/* - - - - - - - Question 13 - - - - - - -
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
*/

console.log('- - - - - - - Question 13 - - - - - - -');
function getPerson(name,age) {
	return new Person(name,age);
}
var jane = getPerson("Jane", 28);
console.log(jane);

