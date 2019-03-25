/**
 * 
 */

//1.
function fib(n){
	var ar = [];
 for (var i = 0; i < n; i++)
 		if(i == 0)
    {
    	ar.push(0);
    }
    else if(i == 1)
    {
    	ar.push(1);
    }
    else
    {
    	ar.push(ar[ar.length-1] + ar[ar.length-2]);
    }
    return ar[ar.length - 1];
}

console.log(fib(6));



//2.
function bubbleSort(numArray){
	var n = numArray.length; 
	for (var i = 0; i < n-1; i++) 
  {
		for (var j = 0; j < n-i-1; j++) 
    {
			if (numArray[j] > numArray[j+1]) 
			{ 
				var temp = numArray[j]; 
				numArray[j] = numArray[j+1]; 
				numArray[j+1] = temp; 
			} 
    }
  }
  return numArray;
}

var numArray = [64, 34, 25, 12, 22, 11, 90]; 
numArray = bubbleSort(numArray); 
console.log(numArray);



//3.
function reverseStr(someStr){
	var reverse = "";
  for(var i = someStr.length - 1; i > -1; i--)
  {
  	reverse += someStr.charAt(i);
  }
  return reverse;
}

var reverse = "reverse";
console.log(reverseStr(reverse));



//4
function factorial(someNum){
	if(someNum == 1)
  {
  	return someNum;
  }
  return someNum * factorial(someNum -1);
}

console.log(factorial(7));


//5
function substring(someStr, length, offset){
	if(offset < 0)
  {
		alert("Cannot start a substring from negative");
	}
  else if(length < 0)
  {
  	alert("Cannot have a negative length");
  }
	else if(offset + length > someStr.length)
  {
  	alert("The substring extends past the string length");
  }
	return someStr.substring(offset, offset + length);
}

var str = "This is a string."
//console.log(substring(str, -1, 1));
//console.log(substring(str, 1, -1));
//console.log(substring(str, 200, 200));
console.log(substring(str, 8, 1));


//6

function isEven(someNum){

	while(someNum > 1)
  {
  	someNum -= 2;
  }
	
  if(someNum == 0)
  {
  	return true;
  }
  else
  {
  	return false;
  }
}

console.log(isEven(5));
console.log(isEven(6));

//7

function isPalindrome(someStr){
	var split = someStr.split("");
  var reverseArray = split.reverse();
  var reverseStr = reverseArray.join("");
  if(someStr == reverseStr)
  {
  	return true;
  }
  else
  {
  	return false;
  }
}

console.log(isPalindrome("racecar"));
console.log(isPalindrome("notracecar"));

//8

function printShape(shape, height, character){
	var result = "";
	switch(shape)
  {
  	case "Square":
    	for(var i = 0; i < height; i++)
      {
      	for(var j = 0; j < height; j++)
      	{
      		result += character;
        }
        result += '\n';
      }
    	break;
    case "Triangle":
    	for(var i = 0; i < height; i++)
      {
      	for(var j = 0; j < height; j++)
      	{
        	if(i >= j)
          {
          	result += character;
          }
          else
          {
          	result += ' ';
          }
        }
        result += '\n';
      }
    	break;
    case "Diamond":
    	var numDiamonds = 1;
    	for(var i = 0; i < height; i++)
      {
      	for(var j = 0; j < height; j++)
      	{
        	var k = (height - numDiamonds)/2;
          
        	if(j < k || j >= height - k)
          {
          	result += ' ';
          }
          else
          {
          	result += character;
          }
        }
        if((i + 1) <= height/2)
        {
        	numDiamonds += 2;
				}
      	else
        {
        	numDiamonds -= 2;
        }
        result += '\n';
      }
    	break;
    default:
    	break;
  }
  return result;
}

console.log(printShape("Square", 3, "%"));
console.log(printShape("Triangle", 3, "$"));
console.log(printShape("Diamond", 21, "*"));

//9

function  traverseObject(someObj)
{
	for (var key in someObj) {
    console.log(someObj[key]);
	}
}

var obj = {
    'foo': 1,
    'bar': 2,
    'blah': 'blah'
};

traverseObject(obj);



//10

function deleteElement(someArr)
{
	console.log(someArr.length);
  delete someArr[1];
  console.log(someArr.length);
}

var arr = [3,3,4,5,6,4,2,1];

deleteElement(arr);

//11

function spliceElement(someArr)
{
	console.log(someArr.length);
  someArr.splice(2, 1);
  console.log(someArr.length);
}

var arr = [3,3,4,5,6,4,2,1];

spliceElement(arr);


//12


function Person(name, age) {
	this.name = name;
  this.age = age;
}

var john = new Person("John", 30);

console.log(john);


//13


function getPerson(name, age){
	var p = {
    name: name,
    age: age
	};
  return p;
}

var john = getPerson("John", 30);

console.log(john);

