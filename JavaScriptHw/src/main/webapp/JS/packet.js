/**
 * 
 */


/*
 *  1. Fibonacci
 *  Define function: fib(n) 
 *  Return the nth number in the fibonacci sequence.   
 */

function fib(n){
	
	var numOne = 0;
	var numTwo = 1;
	
	while(n >= 0){
		var sumOfNumbers = numOne + numTwo;
		numOne = numTwo;
		numTwo = sumOfNumbers;
		n--;
	}
	return numOne; 
}

console.log(fib(6));

/*
 * 2. Bubble Sort
 * Define function: bubbleSort(numArray)
 * Use the bubble sort algorithm to sort the array.
 * Return the sorted array.
 */

function bubbleSort(numArray){
	
	for(var i = 0; i < numArray.length -1; i++)
		for(var j = 0; j < numArray.length - i - 1; j++)
			
			if(numArray[j] > numArray[j + 1]){
				
				var temp = numArray[j];
				numArray[j] = numArray[j + 1];
				numArray[j + 1] = temp;
			}
	return numArray; 
}

var numArray = [1,5,2,4,6,3];
console.log(bubbleSort(numArray));

/*
 * 3. Reverse String
 * Define function: reverseStr(someStr)
 * Reverse and return the String.
 */

function reverseStr(someStr){
	
	return someStr.split("").reverse().join("");
}

console.log(reverseStr("Yay JavaScript"));

/*
 * 4. Factorial
 * Define function: factorial(someNum)
 * Use recursion to compute and return the factorial of someNum.
 */

function factorial(someNum){
	
	var fact = 1;
	
	for(var i = 1; i <= someNum; i++){
		fact *= i;
	}
	return(fact);
}

console.log(factorial(4));

/*
 * 5. Substring
 * Define function substring(someStr, length, offset)
 * Return the substring contained between offset and (offset + length) inclusively.
 * If incorrect input is entered, use the alert function and describe why the input was incorrect.
 */

function substring(someStr, length, offset){
	
	if(typeof someStr != "string"){
			alert("Please enter a string")
	}else{
		return someStr.substring(length, offset);
	} 
}

console.log(substring("Hello World", 1, 5));

/*
 * 6. Even Number
 * Define function: isEven(someNum)
 * Return true if even, false if odd.
 * Do not use % operator.
 */

function isEven(someNum){
	
	if(someNum & 1){
		console.log("odd")
	}else{
		console.log("even")
	}
		
}

isEven(4);

/*
 * 7. Palindrome
 * Define function isPalindrome(someStr)
 * Return true if someStr is a palindrome, otherwise return false
 */

function isPalindrome(someStr){
	
	if(someStr == someStr.split("").reverse().join("")){
		console.log("is a Palindrome")
	}else{
		console.log("is not a Palindrome")
	}
}

isPalindrome("kayak");

/*
 * 8. Shapes
 * Define function: printShape(shape, height, character)
 * shape is a String and is either "Square", "Triangle", "Diamond".
 * height is a Number and is the height of the shape. Assume the number is odd.
 * character is a String that represents the contents of the shape. Assume this String contains just one character.
 * Use a switch statement to determine which shape was passed in.
 * Use the console.log function to print the desired shape.
 */

function printShape(shape, height, character){
	
	switch(shape){
	case "square":
		for(var i = 0; i < height; i++){
			for(var j = 0; i < height; j++){
				console.log(character);
			}
		}
		break;
	case "triangle": 
		for(var i = 0; i < height; i++){
			for(var j = 0; j <=i; j++){
				console.log(character);
			}
		}
		break;
	}
}

printShape("square", 3, '*');

/*
 * 9. Object literal
 * Define function traverseObject(someObj)
 * Print every property and it's value.
 */

var pizza = {
	    'crust': "thin",
	    'sauce': "tomato",
	    'topping': "pepperoni"
	};

function traverseObject(someObj){
	for (var key in pizza) {
	    console.log(pizza[key]);
	}
}

traverseObject(pizza);

/*
 * 10. Delete Element
 * Define function deleteElement(someArr)
 * Print length
 * Delete the third element in the array.
 * Print length
 * The lengths should be the same.
 */

function deleteElement(someArr){
	
	
	console.log(someArr.length); 
	delete someArr[2];
	console.log(someArr.length);
	
}

var someArr = [1, 2, 3, 4, 5];
deleteElement(someArr); 

/*
 * 11. Splice Element
 * Define function spliceElement(someArr)
 * Print length
 * Splice the third element in the array.
 * Print length
 * The lengths should be one less than the original length.
 */

function spliceElement(someArr){
	
	console.log(someArr.length); 
	someArr.splice(2,1);
	console.log(someArr.length);
}

var someArr = [1, 2, 3, 4, 5];
spliceElement(someArr); 

/*
 * 12. Defining an object using a constructor
 * Define a function Person(name, age)
 * The following line should set a Person object to the variable john:
 * var john = new Person("John", 30);
 */

function Person(name, age){
	
	this.name = name;
	this.age = age;
	
}

var john = new Person("John", 30);

/*
 * 13. Defining an object using an object literal
 * Define function getPerson(name, age)
 */

function getPerson(name, age){
	
	return person = {name: name, age: age};
	
}

var john = getPerson("John", 30);
console.log(john);

/*
 * <script type="text/javascript" src="JS/packet.js"></script>
 */







