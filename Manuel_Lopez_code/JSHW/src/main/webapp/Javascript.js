/**
 * 
 */


/*console.log("hooray");
console.log("hey, guys 0_0 -_-");
console.log("hello");
console.log("Javascript is working!!  YEAH! YEAH!!");*/

//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.
function fib(num) {
  if (num <= 1) return 1;

  return fib(num - 1) + fib(num - 2);
}
console.log(fib(4));

function fibonacci(num){
	  var a = 1, b = 0, temp;

	  while (num >= 0){
	    temp = a;
	    a = a + b;
	    b = temp;
	    num--;
	  }

	  return b;
	}
console.log(fibonacci(6));

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
var list =[12, 345, 4, 546, 122, 84, 98, 64, 9, 1];
console.log(list);
console.log(list.toString());
function bubbleSort(list) {
    var length = list.length;
    //Number of passes
    for (var i = 0; i < length; i++) { 
        //Notice that j < (length - i)
        for (var j = 0; j < (length - i - 1); j++) { 
            //Compare the adjacent positions
            if(list[j] > list[j+1]) {
                //Swap the numbers
                var tmp = list[j];  //Temporary variable to hold the current number
                list[j] = list[j+1]; //Replace current number with adjacent number
                list[j+1] = tmp; //Replace adjacent number with current number
            }
        }        
    }
    console.log(list.toString());
}
bubbleSort(list);

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.
function reverseStr(someStr) {
    return someStr.split("").reverse().join("");
}
console.log(reverseStr("hello"));

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
	  if (someNum < 0) 
	        return -1;
	  else if (someNum == 0) 
	      return 1;
	  else {
	      return (someNum * factorial(someNum - 1));
	  }
}
console.log(factorial(5));
	
//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset){
	if((offset+length) > someStr.length){
		alert("Offset+length was longer than string length");
	}
	var res = someStr.substring(offset, offset+length);
	return res;
}
console.log(substring("Helloworld", 5, 2));

//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.
function isEven(someNum){
	if((someNum & 1) == 0){
		return true;
	}
	return false;
}
console.log(isEven(16));

//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false
function isPalindrome (someStr) {
	  return someStr == someStr.split('').reverse().join('');
	}
console.log(isPalindrome('racecar'));

//8. Shapes
//Define function: printShape(shape, height, character)
//shape is a String and is either "Square", "Triangle", "Diamond".
//height is a Number and is the height of the shape. Assume the number is odd.
//character is a String that represents the contents of the shape. Assume this String contains just one character.
//Use a switch statement to determine which shape was passed in.
//Use the console.log function to print the desired shape.

/*function printShape(shape, height, character){
	switch(shape) {
	  case "Square":
	    for(var  i=0; i<height; i++){
	    	for(var j=0; j<height; j++){
	    		console.log(character);
	    	}
	    }
	    break;
	  case "Triangle":
	    text = "I am not a fan of orange.";
	    break;
	  case "Diamond":
	    text = "How you like them apples?";
	    break;
	  default:
	    text = "I have never heard of that fruit...";
	}
}
console.log(printShape("Square", 3, "%"));*/

function printShape(shape, height, character){
    if (height%2 == 1){
    switch(shape) {
      case "Triangle":
          for (let i = 0; i < height; i++){
                for(j = 0; j <= i; j++){
                    console.log(character);
                }
                
                console.log("\n");
            }
          break;
        
      case "Square":
          for(i = 0; i < height; i++){
                for(j= 0; j < height; j++){
                    console.log(character);
                }
                
                console.log("\n");
            }
        break;
        
        default: console.log("Enter either a square, triangle, or diamond");

    }
}else{console.log("You must enter an odd number");
}
}

printShape("Triangle", 4, "*");

//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.
function traverseObject(someObj){
	var val;
	for(var x in someObj){
		val = someObj[x]
		console.log(x , val);
	}
}
var Person = {
		name: 'Batmans',
		superpower: 'Rich',
		cars: 'All the cars'
};
traverseObject(Person);

//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.
var ar =[1, 2, 3, 4, 5, 6];
console.log(ar.toString());
console.log(ar.length);
function deleteElement(someArr){
	delete someArr[3];
}
deleteElement(ar);
console.log(ar.toString());
console.log(ar.length);

//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.
var list1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
console.log(list1.toString());
console.log(list1.length);
function spliceElement(someArr){
	someArr.splice(3, 1);
}
spliceElement(list1);
console.log(list1.toString());
console.log(list1.length);

//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//	var john = new Person("John", 30);
function Person(name, age){
	this.personName = name;
	this.personAge = age;
}
//var John = new Person("John", 30);
//console.log(John);


//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//	var john = getPerson("John", 30);
function getPerson(name, age){
	personName : name;
	personAge : age;
	return new Person(name, age);
};
/*var john2 = getPerson("John", 40);
console.log(john2);*/











