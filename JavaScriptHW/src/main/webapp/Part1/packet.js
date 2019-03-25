/**
 * 
 */

// Question 1 Fibonacci
console.log('<><><><><><><>Question 1<><><><><><><>');
function thefib(n){
	let A = 1;
	let B = 0;
	let C = 0;
	while(n>1){
		C = A; 
		A = A+B;
		B = C;
		n--;
	}
	return A;
}
console.log(thefib(10));

//Question 2 bubble sort
console.log('<><><><><><><>Question 2<><><><><><><>');
function bubbleSort(numArray){
	let s=0;
	let K=0;
	while (s<numArray.length) {
		
		// If bigger # is before the Smaller #, Swap and change key
		if(numArray[s]> numArray[s+1]) {
			let temp = numArray[s];
			numArray[s] = numArray[s+1];
			numArray[s+1] = temp;
			K = 1;
		}
		// If Key is S then restart loop
		if(K==1){
			s = -1;
			K = 0;
		}
		s++
	}
}
let P = [1,6,3,9,3,3,1,8,7];
console.log(P);
bubbleSort(P);
console.log(P);

//Question 3 Reverse String
console.log('<><><><><><><>Question 3<><><><><><><>');
function reverseStr(someStr){
	let revString='';
	let c=someStr.length;
	while(revString.length < someStr.length){
		c--;
		revString = revString + someStr.charAt(c);
	}
	return revString;
}

var word = "TheMasterOfFaster";
console.log(reverseStr(word));

//Question 4 Factorial
console.log('<><><><><><><>Question 4<><><><><><><>');
function factorial(someNum){
	let N = someNum;
	while(someNum > 1){
		someNum--;
		N = someNum * N;
	}
	return N;
}
console.log(factorial(10))

//Question 5 Substring
console.log('<><><><><><><>Question 5<><><><><><><>');
function substring(someStr, length, offset){
	let tReturn = '';
	if (length + offset > someStr.length){
		alert('Length from that offset exceeds the length of the string');
	}
	else{
		let temp = offset + length;
		while(offset < temp){
			
			tReturn = tReturn + someStr.charAt(offset);
			offset++;
		}
	}
	return tReturn;
}
console.log(substring(word, 4,8));

//Question 6 Even number
console.log('<><><><><><><>Question 6<><><><><><><>');
function isEven(someNum){
	let temp = 1
	while(someNum/2 >= temp){
		if(someNum == temp*2){
			return true;
		}
		temp ++;
	}
	return false;
}
console.log(isEven(13));
console.log(isEven(44));


//Question 7 Palindrome
console.log('<><><><><><><>Question 7<><><><><><><>');
function isPalindrome(someStr){
	let Phi = reverseStr(someStr);
	if(Phi == someStr){
		return true;
	}else{
		return false;
	}
}
console.log("Racecar is a palindrome. " + isPalindrome('racecar'));
console.log("Snow is a palindrome. " + isPalindrome('snow'));

//Question 8 Fibonacci
console.log('<><><><><><><>Question 8<><><><><><><>');
function printShape(shape, height, character){
	let form = '';
	switch(shape){
	
	case 'Square':
		for(let F = 0; F<height; F++){
			form = form + character.charAt(0);
		}
		for(let F = 0; F<height; F++){
			console.log(form);
		}
		break;
	
	case 'Triangle':
		
		for(let F = 0; F<height; F++){
			
			form = form + character.charAt(0);
			console.log(form);
		}
		break;
		
	case 'Diamond':
		let mond=1;
		let Dia;
		for(let F=0; F<height; F++){
			Dia = height - mond;
			for(let f=0; f<Dia/2; f++){
				form = form + ' ';	
			}
			for(let e=0; e<mond; e++){
				form = form + character.charAt(0);
			}			
			for(let g=0; g<Dia/2; g++){
				form = form + ' ';
			}
			
			console.log(form);
			if(F < height/2 - 1){
				mond = mond + 2;
			}
			else if(F > height/2 - 1){
				mond = mond - 2;
			}
			form = '';
		}
		
		break;
		
	default:
		console.log('Invalid shape name!')
		break;
		
		
	}
}
printShape('Square',5,'#');
printShape('Triangle',4,'^');
printShape('Diamond',7,'~');

//Question 9 Object Literal
console.log('<><><><><><><>Question 9<><><><><><><>');
function traverseObject(someObj){
	var Zeta;
	for(var Gamma in someObj){
		Zeta = someObj[Gamma];
		console.log(Gamma,Zeta);
	}
}
var Hero = {
		Name : 'Drake',
		Age : 20,
		Quirk : 'Light Assimilation'
}
traverseObject(Hero);

//Question 10 Delete Element
console.log('<><><><><><><>Question 10<><><><><><><>');
function deleteElement(someArr){
	console.log("Length is " + someArr.length);
	delete someArr[2];
	console.log("Length is " + someArr.length);
}
deleteElement(P);

//Question 11 Splice Element
console.log('<><><><><><><>Question 11<><><><><><><>');
function spliceElement(someArr){
	console.log("Length is " + someArr.length);
	someArr.splice(2,1);
	console.log("Length is " + someArr.length);	
}
spliceElement(P);

//Question 12 Defining an object using a constructor
console.log('<><><><><><><>Question 12<><><><><><><>');
function Person(name, age){
	this.Name = name;
	this.Age = age;
}
var john = new Person('John',30);
traverseObject(john);


//Question 13 Defining an object using an object literal
console.log('<><><><><><><>Question 13<><><><><><><>');
function getPerson(name, age){
	return{	Name : name, Age : age}
}
john = getPerson('John', 30);
traverseObject(john);