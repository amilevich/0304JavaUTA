/**
 * 
 */

/*
 *  1. Fibonacci
 * Define function: fib(n) 
 * Return the nth number in the fibonacci sequence.
 */
console.log("1. Fibonacci");
var fibonacciArray = [0, 1, 0, 0, 0, 0, 0, 0, 0]; //declares an array
function fib(n){
	for(var i = 1; i < fibonacciArray.length-1; i++){
		fibonacciArray[i+1] = fibonacciArray[i] + fibonacciArray[i-1];
	}
	console.log("9th element in the sequence: " + fibonacciArray[n]); //prints the element at array position "n"
}
fib(8);
console.log("----------------------------------------");

/*
 * 2. Bubble Sort
 * Define function: bubbleSort(numArray)
 * Use the bubble sort algorithm to sort the array.
 * Return the sorted array.
 * */
var randomArray = [1,0,2,9,3,8,4,7,5,6];
var tempVar = [0,0,0,0,0,0,0,0,0,0];
function bubbleSort(numArray){ //function takes in a random array as a parameter
	console.log("2. Bubble Sort")
	console.log("Original array: " + numArray);
	for(var j = 0; j<numArray.length-1; j++) {
		for(var i = 0; i<numArray.length-j-1; i++) {
			if(numArray[i+1] > numArray[i]) {
				tempVar[i] = numArray[i];
				numArray[i] = numArray[i+1];
				numArray[i+1] = tempVar[i];
			}
		}
	}
	console.log("Sorted array: " + numArray);
}
bubbleSort(randomArray); //randomArray is passed as an argument to bubbleSort() function
console.log("----------------------------------------");

/*
 * 3. Reverse String
 * Define function: reverseStr(someStr)
 * Reverse and return the String.
 */
var randomString = "Fire and Blood";
function reverseStr(someString){ //function takes a random string as a parameter
	console.log("3. Reverse String");
	console.log("Original string: " + randomString);
	for(var i = 0; i<someString.length; i++) {
		someString = someString.substring(1, someString.length - i) + someString.substring(0,1) + someString.substring(someString.length-i, someString.length);
	}
	console.log("Reversed string: " + someString);
}
reverseStr(randomString); //randomString is passed as an argument to reverseStr() function
console.log("----------------------------------------");

/*
 * 4. Factorial
 * Define function: factorial(someNum)
 * Use recursion to compute and return the factorial of someNum.
 *
 */
console.log("4. Factorial");
function factorial(someNum) {
	if(someNum < 0){
		return -1;
	} else if (someNum == 0) {
		return 1;
	} else {
		return (someNum * factorial(someNum - 1));
	}
}
var randomNumber = 7; //you can change this for any other number
console.log("Factorial of " + randomNumber + " = " + factorial(randomNumber));
console.log("----------------------------------------");
/*
 * 5. Substring
 * Define function substring(someStr, length, offset)
 * Return the substring contained between offset and (offset + length) inclusively.
 * If incorrect input is entered, use the alert function and describe why the input was incorrect.
 */
console.log("5. Substring");
function substring(someStr, length, offset){
	var start = offset;
	var end = offset + length;
	console.log("Sub string: " + someStr.substring(start, end));
}

function substringFuncCall(){
	var randomString = prompt("Enter a string", "");
	var randomOffset = prompt("Enter an offset", "");
	if(randomOffset > randomString.length){
		alert("Offset must be shorter than or equal to string length");
		substringFuncCall();
	} else {
		console.log("Original string: " + randomString);
		substring(randomString, randomString.length, randomOffset);
	}
}
substringFuncCall(); //UNCOMMENT THIS AT THE END!!!
console.log("----------------------------------------");

/*
 * 6. Even Number
 * Define function: isEven(someNum)
 * Return true if even, false if odd.
 * Do not use % operator.
 */
console.log("6. Even Number");
function isEven(someNum){
	//if(someNum%2 == 0){
	if(someNum & 1){ //bit test; this checks whether the first bit is on, which is indicative of an odd number
		console.log(someNum + " is odd");
	} else {
		console.log(someNum + " is even");
	}
}
isEven(100);
console.log("----------------------------------------");

/*
 * 7. Palindrome
 * Define function isPalindrome(someStr)
 * Return true if someStr is a palindrome, otherwise return false
 */
console.log("7. Palindrome")
function isPalindrome(someStr){
	
	var lowerCaseSomeStr = someStr.toLowerCase(); //this turns someStr into lowercase letters
	var charArray1 = lowerCaseSomeStr.split(""); //splits someStr into a character array of the form [firstLetter, secondLetter, ...]
	
	var j = 1;
	for(var i = 0; i<charArray1.length - 1; i++){
		charArray1[i] = charArray1[charArray1.length - j];
		j++;
	}
	
	var charArray2 = charArray1.join("");
	//console.log("lowerCaseSomeStr: " + lowerCaseSomeStr);
	//console.log("charArray2: "+ charArray2);
	if(charArray2 == lowerCaseSomeStr){
		console.log(someStr + " is a palindrome");
	} else {
		console.log(someStr + " is not a palindrome");
	}
}
isPalindrome("Hannah"); //You can change "Hannah" for anything else here
console.log("----------------------------------------");

/*
 * 8. Shapes
 * Define function: printShape(shape, height, character)
 */
console.log("8. Shapes");

console.log("----------------------------------------");


/*
 * 9. Object literal
 * Define function traverseObject(someObj)
 * Print every property and it's value.
 */
console.log("9. Object literal");
function traverseObject(someObj){
	var propertiesArray = Object.getOwnPropertyNames(someObj).forEach(
			function(propertyValue) {
				console.log(propertyValue + " = " + someObj[propertyValue]);
				}
			);
	/*
	for(var i = 0; i<propertiesArray.length; i++){
		console.log(propertiesArray[i]);
	}
	*/
	//console.log(propertiesArray);
	//console.log(Object.getOwnPropertyNames(someObj));
}
var person = {firstName:"Alex", lastName:"Mason", age:35, occupation:"student"};
traverseObject(person);
console.log("----------------------------------------");
/*
 * 10. Delete Element
 * Define function deleteElement(someArr)
 * Print length
 * Delete the third element in the array.
 * Print length
 * The lengths should be the same.
 * */
console.log("10. Delete Element");
function deleteElement(someArr){
	console.log(someArr);
	console.log("Array length: " + someArr.length);
	someArr[2] = null; //delete element (?); am I supposed to set it to null or undefined?
	console.log(someArr);
	console.log("Array length: " + someArr.length);
}

var randomArray = ["red", "blue", "yellow", "green"];
deleteElement(randomArray);
console.log("----------------------------------------");

/*
 * 11. Splice Element
 * Define function spliceElement(someArr)
 * Print length
 * Splice the third element in the array.
 * Print length
 * The lengths should be one less than the original length.
 */
console.log("11. Splice element");
function spliceElement(someArr){
	console.log(someArr);
	console.log("Array length: " + someArr.length);
	someArr.splice(2, 1); //removes third element of array (which lies at index position 2), and it only removes 1 element
	console.log(someArr);
	console.log("Array length: " + someArr.length);
}
var randomArray2 = ["gold", "silver", "copper", "osmium", "tungsten"];
spliceElement(randomArray2);
console.log("----------------------------------------");

/*
 * 12. Defining an object using a constructor
 * Define a function Person(name, age)
 * The following line should set a Person object to the variable john:
 *  	var john = new Person("John", 30);
 */
console.log("12. Defining an object using a constructor");
function Person(name, age){
	this.name = name;
	this.age = age;
}
var john = new Person("John", 30);
console.log(john);
console.log("----------------------------------------");

/*
 * 13. Defining an object using an object literal
 * Define function getPerson(name, age)
 * The following line should set a Person object to the variable john:
 *  	var john = getPerson("John", 30);

 */
console.log("13. Defining an object using an object literal")
function getPerson(name, age){
	return {name : name, age : age};
}
var john = getPerson("John", 30);
console.log(john);
console.log("----------------------------------------");
