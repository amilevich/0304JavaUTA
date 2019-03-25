/**
 * 
 */

// 1. Fibonacci
// Define function: fib(n)
// Return the nth number in the fibonacci sequence.

function fib(n){
	let x=0;
	let y=1;
	let sum;
	let fArr=[];
	let i;
	
	for(i=0;i<n;i++){
		fArr[i]=x;
		sum=x+y;
		x=y;
		y=sum;
	}
	return fArr[n-1];
}
//console.log(fib(5));

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray){
	let c=numArray.length;
	for(let i=0;i<c-1;i++){
		for(let j=0;j<c-i-1;j++){
			if(numArray[j] > numArray[j+1]){
				let temp=numArray[j];
				numArray[j]=numArray[j+1];
				numArray[j+1]=temp;
			}
		}
	}
	return numArray;
}
//let arr=[3,2,5,6]
//console.log(bubbleSort(arr));

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr){
	let rStr='';
	for(let i=someStr.length-1; i>=0; i--){
		rStr+=someStr[i];
	}
	return rStr;
}
//let s='yolo';
//console.log(reverseStr(s));

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum){
	if(someNum==0){
		return 1;
	}
	return someNum*factorial(someNum-1);
}
//console.log(factorial(5));

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length)
// inclusively.
// If incorrect input is entered, use the alert function and describe why the
// input was incorrect.
function substring(someStr, length, offset){
	let sStr='';
	if(someStr.length<offset+length){
		alert('The offset and length are over the length of the string');
	} else if(someStr.length<offset){
		alert('The offset is over the length of the string');
	} else {
		for(let i=offset;i<=length+offset;i++){
			sStr+=someStr[i];
		}
	}
	return sStr;
}
//console.log(substring('helloworld',3,4));

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum){
	let b=true;
	for(let i=1;i<=someNum;i++){
		b = !b;
	}
	return b;
}
//console.log(isEven(9));

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr){
	let rStr='';
	for(let i=someStr.length-1; i>=0; i--){
		rStr+=someStr[i];
	}
	if(someStr==rStr){
		return true;
	} else{
		return false;
	}
}
//console.log(isPalindrome('radar'));

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
function printShape(shape, height, character){
	switch(shape){
	case "Square":
		let line= "";
		for(let i=0;i<height;i++){
			line+= character + " ";
		}
		let newLine="";
		for(let j=0;j<height;j++){
			newLine+= line+"\n";
		}
		console.log(newLine);
		break;
	case "Triangle":
		var s = "";
		for(let j=0;j<height;j++){
			s+= character;
			console.log(s);
		}
		break;
	case "Diamond":
		for(i=1;i<=5;i++){
			  txt = "";
			  for(j=i;j<10;j++){
			    txt += " ";
			  }
			  for(k=0;k<(i*2)-1;k++){
			    txt += character;
			  }
			  console.log(txt);
			}
			var txt = "";
			for(i=5-1;i>=1;i--){
			  txt = "";
			  for(j=i;j<10;j++){
			    txt += " ";
			  }
			  for(k=0;k<(i*2)-1;k++){
			    txt += character;
			  }
			  console.log(txt);
			}
		break;
	default:
		console.log("Try again!");
	}
}
printShape("Diamond", 3,'#');

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj){
	for(let someProp in someObj){
		if(someObj.hasOwnProperty(someProp)){
		console.log(someProp +" -> "+someObj[someProp]);
		}
	}
}

let superHero={
		name:'PizzaMannh',
		ability:'Delivering pizza to the legged ones',
		'Andrew':"wait, is Andrew a thing?"
}
//traverseObject(superHero);

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(someArr){
	console.log(someArr.length);
	someArr[2]='';
	console.log(someArr.length);
}
//let someArr=[1,2,3,4];
//deleteElement(someArr);

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
function spliceElement(someArr){
	console.log(someArr.length);
	someArr.splice(2,1);
	console.log(someArr.length);
}
//let someArr=[1,2,3,4];
//spliceElement(someArr);

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
 
function Person(name, age){
	this.name = name;
	this.age = age;
}
//var john = new Person("John", 30);
//console.log(john);


// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:

function getPerson(name, age){
	pName: name;
	pAge: age;
}
var john = getPerson("John", 30);

