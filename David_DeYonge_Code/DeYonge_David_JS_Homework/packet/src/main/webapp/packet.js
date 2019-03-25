/**
 * David DeYonge
 */

/*
 * 
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n)
{
	let sum;
	let prevNum = 0,currNum=1;
	for (var i = 1; i < n; i++)
	{
		sum = prevNum+currNum;
		prevNum = currNum;
		currNum = sum;
	}
	return sum;
}

///console.log(fib(7));

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.*/
let numArray = [1,2,4,5,6,2,59];
//for(let i = 0;i<numArray.length;i++)
	//console.log(numArray[i]);
function bubbleSort(numArray)
{
	for (var i = 0; i < numArray.length; i++) 
	{
		for (var j = 0; j < numArray.length; j++) 
		{
			if ( numArray[j] > numArray[i]) 
			{
				let temp = numArray[i];
				numArray[i] = numArray[j];
				numArray[j] = temp;
			}
		}
	}
	return numArray;
}
//numArray = bubbleSort(numArray);
//for(let i = 0;i<numArray.length;i++)
	//console.log(numArray[i]);
/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/

function reverseString(s)
{
	let ret='';
	for (let i = s.length; i >= 0; i--) 
	{
		ret+=s.charAt(i);
	}
	return ret;	
}

let asdf = "Leroy Jenkins";

//console.log(reverseString(asdf));


/*
 * 4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
 */

function factorial(intIn)
{
	let ret = intIn;
	for (var i = intIn-1; i > 0; i--) 
	{
		ret *= i; 
	}
	return ret;
}

//console.log(factorial(5));


/*
 * 5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and
 (offset + length) inclusively.
If incorrect input is entered, use the alert function 
and describe why the input was incorrect.
 */

function mySubString(inString,length,offset)
{
	if(typeof inString ==! "string")
		{
			alert("Not a string");
			return;
		}
	
	let ret='';
	console.log(inString);
	for (let i = offset; i < length; i++) 
	{
		ret+=inString.charAt(i);
	}
	return ret;	
	
}

//console.log(mySubString(asdf,asdf.length,5))


/*
 * 6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
 */

function evenCheck(inNumber)
{
	if((inNumber & 1) === 1)
	return false;
		
	return true;
}

let i = [7,8,5,74,9,6,3,1,7,2,8,69,420];

for (let j = 0; j < i.length; j++) 
{
	//console.log(evenCheck(i[j]));
}


/*
 * 7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
 */

function palindromeCheck( inString)
{
	for (let i = 0; i < inString.length*.5; i++)
	{
		if(inString.charAt(i) ==! inString.charAt((inString.length - 1) - i))
		{
			return false;
		}
	}
	return true;
}

let p1 = "not palindrome";
let p2 = "tacocat";
//console.log(palindromeCheck(p1));
//console.log(palindromeCheck(p2));


/*8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
*/

function printShape(shape,height,character)
{
	if (shape.toLowerCase() === "square") 
	{
		let line='';
		for (let j = 0; j < height; j++) 
		{
			line += character+"  ";
    }
    let tempLine = '';
		for (let i = 0; i < height; i++) 
		{
      tempLine += line+"\n";
    }
    console.log(tempLine);
	}

	if (shape.toLowerCase() === "triangle") 
	{
    let tempLine = '';
    let line = "";
		for (var i = 0; i <= height; i++) 
		{
			
        line += character+" ";
        tempLine += line+"\n";
        
			
		}
    console.log(tempLine);
	}
}



//do diamond 
//printShape("square"  ,2,'#');
//printShape("triangle",9,'#');

  


/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/
let gurps =
{
	potato : "mershed",
	person : "baked",
	fbi : "open up",
	time : 420
}

function traverseObject(someObj)
{
	//enhanced for loop
	for (let thangs in someObj) 
	{
		if (someObj.hasOwnProperty(thangs))
			console.log(thangs+" = "+someObj[thangs]);
	}
}

traverseObject(gurps);


/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/

let anothaOne = [8,6,7,5,3,0,9,1,1,7];
console.log(anothaOne.length);
console.log(anothaOne[2]);
function deleteElement(inArray,index)
{
	if (index <= inArray.length && index >=0)
	 {
	 	inArray[index] = null;
	 }
}
deleteElement(anothaOne,2);
console.log(anothaOne.length);
console.log(anothaOne[2]);

/*11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/
let stringsBoiiii = ["Look","at","dat","Boi","Oh","stuff","what","up"];
function spliceElement(someOtherArray,index)
{	
  
  return someOtherArray.filter(function(elements)
  {
    return  elements !== someOtherArray[index];
  } );
}
for (let index = 0; index < stringsBoiiii.length; index++) 
{
  //console.log(stringsBoiiii[index]);
}
//console.log(stringsBoiiii.length);
stringsBoiiii = spliceElement(stringsBoiiii,2);
//console.log(stringsBoiiii.length);
for (let index = 0; index < stringsBoiiii.length; index++) 
{
  //console.log(stringsBoiiii[index]);
}


/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);
*/
function Person(name,age)
{
  this.name = name;
  this.age = age;
}


var john = new Person("John",30);

for (let thangs in john) 
	{
		if (john.hasOwnProperty(thangs))
			console.log(thangs+" = "+john[thangs]);
  }

/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
*/

function getPerson(nameIn,ageIn)
{
  let person =
  {
    name : nameIn,
    age : ageIn
  }
  return person;
}
var john2 = new getPerson("John2",30);
console.log(john2);
for (let thangs in john2) 
{
	if (john2.hasOwnProperty(thangs))
		console.log(thangs+" = "+john2[thangs]);
}



