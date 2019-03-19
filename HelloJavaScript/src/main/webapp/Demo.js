/**
 * 
 */

// console.log("hey, guyz 0_0 :3 -_-");
// JavaScript - cross-platform, object-oriented
// scripting language used to make webpages
// interactive/functional.

// There are many more advanced server side
// versions of JS such as Node.JS which
// allows you to add more functionality to
// a website

// primitive data types
// number
// string
// boolean
// null
// undefined
// symbol - ECMAScript 6, is a unique and 
// immutable primitive value, it may be used
// as the key of an Object

// reference types
// object
// arrays
// functions 

var x =5;  //can declare global and local variables
let y;	//can declare all scopes
// JS6 -> scope -> block scope
const z = 3; // cannot change

//scopes
//local
//block
//global

// generally, you want to stay away from
// using var

// stay away from global variables if you can
// because you don't want them changing
// value or type

var a = 1;
function four() {
	if (true) {
		var a = 4;
	}
	alert(a); // alerts '4', not the global value of '1'
}

var a = 1;
function one(){
	if(true) {
		let a=4;
	}
	alert(a); // alerts '1' because the 'let'
	// keyword uses block scoping
}
//one();

let name = 'Andrew';
let numberOne = 5;
let isApproved = false;
let whyVariable = undefined;
let noObj = null;

console.log(name);

let numOne; //undefined variable 
// - those that are declared but have not
// yet been given a value
// if you try to reference an undefined
// variable
// JS will return "undefined"

//numTwo; //undeclared variables
// - those that do not exist in the program
// and are not declared
// if you try to reference an undeclared
// variable, runtime error

var numFive = 5;
// == just value, === type AND value (strictly equals)
// 5=="5" is true, 5==="5" is false

let exObj = {}; //object

let superHero = {
		name : 'PizzaMannh',
		ability : 'Delivering pizza to the legged ones',
		'Andrew' : "wait, is Andrew a thing?"
}

console.log(superHero.name);
console.log(superHero.Andrew);

superHero.secretIdentity = "Joseph Jim";
console.log(superHero.secretIdentity);

delete superHero.Andrew;
// you can also dynamically delete fields
// in an object

// JavaScript is a dynamic language
// because you can switch data types
// immediately (loose typing), at runtime
// you can add/delete new fields into your
// object

var num1 = 10;
var num2 = num1;
num1 = 25;
console.log(num1);
console.log(num2);
// our variables are pass by value,
// so num1 = 25 and num2 = 10

var num3 = {
		value : 10
};
var num4 = num3.value;
num3.value = 50;
console.log(num3);
console.log(num4);
// objects are still passed by value

var arrayOfDoggos=['doggo', 'pupper', 'bowwow', 'goodestboi'];
console.log(arrayOfDoggos[2]);

arrayOfDoggos[10] = 'woofer';


arrayOfDoggos[0] = 0;
console.log(arrayOfDoggos);

//ECMAScript 6: (ES6)
// let, const
// symbol
// template literals (backticks) ``

var tempNum = 15;
//var longString = 'Print longString: ' +
//tempNum + 'and now we have more stuff....';

var longString = `Print longString: ${tempNum}

and now that we have that, there's more
and more



and many many more

and random Andrew

and Kevin 
and ....

asdfghjkl.`;

console.log(longString);

// hoisting - moving all declarations to the
// top of the scope

printStuff();

function printStuff(){
	console.log("stuff");
}






