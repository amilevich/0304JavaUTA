/**
 * 
 */

/*1. Fibonacci
Define function: fib(n) */
function fib(n){
	let a = 0;
	let b = 1;
	let c = 0;
	for(let i = 1; i < n; i++){
		c = a + b;
		a = b;
		b = c;
	}
	return c;
};
console.log("fib = " + fib(5));

/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.*/
function bubbleSort(numArray){
	for(let i = 0; i < numArray.length-1; i++){
		for(let j = 0; j < numArray.length-1; j++){
			if(numArray[j] > numArray[j+1]){
				let temp = numArray[j];
				numArray[j] = numArray[j + 1];
				numArray[j + 1] = temp;
			}
		}
	}
	return numArray;
};
unsortedArray = [5,2,1,6,9,3,8,4,7]
console.log(bubbleSort(unsortedArray));

/*3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.*/
function reverseStr(someStr){
	let newString = " ";
	for(let i = someStr.length - 1; i >= 0 ; i--){
		newString += someStr[i];
	}
	return newString;
};

let x = "Hello World";
console.log(reverseStr(x));

/*4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.*/
function factorial(someNum){
	let x = 1;
	for(let i = someNum; i >= 1; i--){
		x *= i;
	}
	return x;
};

let factNum = 5;
console.log(factorial(factNum));

/*5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.*/
function substring(someStr, length, offset){
	if(someStr.length < offset + length){
		alert("Invalid input, offset + length is greater than length");
	}else{
		let things = someStr.substring(offset, offset+length);
		return things;
	}
	
};

console.log(substring("Number of Legs", 3, 3));

/*6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.*/
function isEven(someNum){
	let bool = true;
	for(let i = 1; i <= someNum; i++){
		bool != bool;
	}
	return bool;
}
console.log(isEven(1));

/*7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false*/
function isPalindrome(someStr){
	for(let x = 0; x < someStr.length/2 - 1; x++){
		if(someStr[x] == someStr[someStr.length - x - 1]){
			return true;
		}else{
			return false;	
		}
	}
};

console.log(isPalindrome("racecar"));


/*8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.*/
function printShape(shape, height, character){
	if(shape == "Square"){
		for(i = 0; i < height; i++){
			for(j= 0; j < height; j++){
				console.log(character);
			}
			
			console.log("\n");
		}

	}else if(shape == "Triangle"){
		for(i = 0; i < height; i++){
			for(j = 0; j <= i; j++){
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

printShape("Triangle", 2, "%");



/*9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.*/
function traverseObject(someObj){
	var value;
	for(var x in someObj){
		value = someObj[x]
		console.log(x , value);
	}
}
var Per = {
		firstName: 'Yousef',
		lastName: 'Pizzaman',
		numLegs: 3
};
traverseObject(Per);

/*10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.*/
function deleteElement(someArr){
	console.log(someArr);
	console.log(someArr.length);
	delete someArr[2];
	console.log(someArr);
	console.log(someArr.length);
}
var anArray = [1,2,3,4,5,6,7,8,9]
deleteElement(anArray);

/*11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.*/
function spliceElement(someArr){
	console.log(someArr);
	console.log(someArr.length);
	someArr.splice(2,1);
	console.log(someArr);
	console.log(someArr.length);
}
var spliceArray = [1,2,3,4,5,6,7,8,9]
spliceElement(spliceArray);


/*12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);*/
var Person = function(name, age){
	this.name = name;
	this.age = age;
}
//var john = new Person("John", 30);
//console.log(john);

/*13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);*/
function getPerson(name, age) {
	pname: name;
	page: age;
	return new Person(name, age);
};

var john2 = getPerson("John", 50);
console.log(john2);



function factorial(someNum){
    var tempVar = someNum; //stores original value of someNum
    for(var i = 1; i<= someNum; i++){
        someNum = someNum * i;
    }
    console.log("Factorial of " + tempVar + " is " + someNum);
}
factorial(3);

