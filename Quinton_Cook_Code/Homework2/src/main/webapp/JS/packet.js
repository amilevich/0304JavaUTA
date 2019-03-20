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

alert(fibonacci(5));

function bubbleSortBasic(array) {
  for(var i = 0; i < array.length; i++) {
    for(var j = 1; j < array.length; j++) {
      if(array[j - 1] > array[j]) {
        var tmp = array[j];
		array[j] = array[j-1];
		array[j-1] = tmp;
      }
    }
  }
  return array;
}

var k = [4,7,0,6,8];

alert(bubbleSortBasic(k));

function reverseString(str) {
    
    var splitString = str.split(""); 
    
 
    
    var reverseArray = splitString.reverse();
 
    var joinArray = reverseArray.join(""); 
    
 
    return joinArray; 
}

alert(reverseString("Reverse Me"));

function factorial(someNum){
	var fac = 1;
	
	for(i = 1; i <= someNum; i++){
		fac = fac*i;
	}
	
	return fac;
}

alert(factorial(5));

function substring1(input,index){
	
	if(typeof input != "string"){
		alert("Wrong type of input");
	}else{
		return input.substring(0,index);
	}

}

alert(substring1("test of the method",1));

function isEven(number){
	if(number/2 == (number+1)/2){
		alert("number is odd");
		
	}else{
		alert("number is even");
	}
}

isEven(2);

function isPalindrome(string){
	if(string == reverseString(string)){
		alert("is a palindrome");
		
	}else{
		alert("is not a palindrome");
	}
}

isPalindrome("racecar");

function printShape(shape,height,character){
	if(shape == "Triangle"){
		for(i = 0; i < height; i++){
			for(j = 0; j <= i; j++){
				console.log(character);
			}
			
			console.log("\n");
		}
	}else if(shape == "Square"){
		for(i = 0; i < height; i++){
			for(j= 0; j < height; j++){
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

printShape("Diamond", 5, "*");

var nyc = {
    fullName: "New York City",
    mayor: "Michael Bloomberg",
    population: 8000000,
    boroughs: 5
};

function traverseObject(obj){
	var propValue;
	
	for(var propName in obj) {
		propValue = obj[propName]

		console.log(propName,propValue);
	}
}

traverseObject(nyc);

function deleteElement(array,index){
	tmp = array.splice(0,index-1);
	
	for(i = 1; i < array.length; i++){
		tmp.push(array[i]);
	}
	
	return tmp;
}

var test = [1,2,3,4,5];

alert(deleteElement(test,3));

function Person(first, last, age, eye) {
  this.firstName = first;
  this.lastName = last;
  this.age = age;
  this.eyeColor = eye;
}

var pete = new Person("Pete","The Cheat",21,"Red");

traverseObject(pete);

function getPerson(first, last, age, eye){
	var fold = new Person(first,last,age,eye);
	
	return fold;
}

var jan = getPerson("Jan","Janey",555,"zippy");

traverseObject(jan);

