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


//Falsey Values

// numbers are all inherently true, 0 is false
// strings are inherently true, empty string is false
// false is false, true is true
// null is false
// undefined is false
// NaN is false

// you can use any value in a boolean
// context and it will be assigned
// a truthy or falsy value

function checkTruthy(input) {
	console.log(`
	input = ${input}, and is typeof: ${typeof(input)}
	and input is ${!!input}`)
}

//checkTruthy(-1);
//checkTruthy(0);
//checkTruthy('');
//checkTruthy([]);
//checkTruthy(false);
//checkTruthy('false');
//checkTruthy(NaN);

//let x = 10;
//let y = 30;
//function mult(){
//	return x*y
//}

//errors
//throw new Error('invalid statement');

//loops
//course=['exam1', 'exam2', 'exam3'];
//for(let exam in course){
//	console.log(exam, course[exam]);
//}
//for(let exam of course){
//	console.log(exam);
//} //TomasTM

// ES6, arrow notation

//ES5
//var x = function(x,y) {
//	return x*y;
//}
//ES6
//const x = (x,y) => x*y;

// isNaN - method returns true if
// variable is not a type of number
// NaN is not a keyword (unlike true,
// false, null, etc...),
// it is a property of the global
// object.
// The value of NaN is the same as 
// the value of Number.Nan;

//There are several in which NaN can happen:

/*
 * 1) Division of zero by zero
 * 2) Division of infinity by infinity 
 * 3) Multiplication of infinity by zero
 * 4) Converting a non-numeric string
 * 		or undefined into a number
 */

// Anonymous functions
// - is a function without a name
let anoFunc = function(){
	console.log("in anoFunc")
}
//anoFunc(); 

// Self Invoking Functions
// invoked automatically, without 
// being called
// IIFE - immediately invokable function expression
// function expression will execute
// automatically if the expression
// is followed by ()

let funcTwo = function() {
	let someVariable = "inside self invoking function";
	console.log(someVariable);
}();

//Callback function
//Simply put: function that is to be
// executed after another function
// has finished executing

// any function that is passed as 
// an argument is called a callback
// function

//function doHomework(subject, callback) {
//	alert(`Starting my ${subject} homework.`);
//	callback();
//}
//
//doHomework('math', function(){
//	alert('Finished my hnomework');
//});

//best practice for callback functions
// we don't always have to define
// our callback functions in our
// function call

function doHomework(subject, callback){
	alert(`Starting my ${subject} homework.`);
	callback();
}
function alertFinished(){
	alert('Finished my hnomework');
}
doHomework('math', alertFinished);

// different strokes for different folks YousefTM

// closure 
// simply put, JavaScript's encapsulation

//A closure is an inner function
// that has access to the
// outer (enclosing) function's
// variables. 
// The closure has 3 scope chains:
// 1) it has access to its own scope
// 2) it has access to the outer function's variables
// 3) it has access to global variables

let foo = (function() {
	let bar = 0;
	return function() {
		return bar += 1
	};
})();

//console.log(bar);
// bar is not global, cannot directly call it
//console.log(foo());

// Inheritance
// Prototypical inheritance
/*
 * JavaScript, when it comes to inheritance,
 * only has one construct: objects.
 * Each object has a private property
 * which holds a link to another object
 * called its prototype.
 * The prototype has a prototype of its own,
 * and so on until an object is reached
 * with null as its prototype.
 * 
 * 
 *Let us create an object o from function f
 *with its own properties
 */

let f = function () {
	this.a = 1;
	this.b =2;
}

//let o = new f(); 
// add properties
f.prototype.b = 3;
f.prototype.c = 4;
//
// o.[[Prototype]]; properties b and c
// o.[[Prototype]].[[Prototype]] is Object.prototype
// o.[[Prototype]].[[Prototype]].[[Prototype]] is null
// this is the end of the prototype chain
// as null, by definition, has no 
// [[Prototype]].

//console.log(o.a); // this returned 1
//console.log(o.b);  
// property shadowing
// is there a own 'b' property on o?
// yes, its value is 2
// the prototype also has a 'b' property
// but it's not visited.
//console.log(o.c);
// is there a c property on? no
// is there a c property on o's prototype?
// yes, its value is 4
//console.log(o.e);
// no property found, return undefined

// is there a e property for o object? no
// o.[[Prototype]], again nada
// o.[[Prototype]].[[Prototype]]. nothing
// o.[[Prototype]].[[Prototype]].[[Prototype]]
// null, so we stop searching

//In JS, any function can be added to an 
//object in the form of a property.
// An inherited function acts just as any
// other property, including property
// shadowing as shown above.
// (in this case, form of method overriding)

/*
when an inherited function is executed,
the value points to the inheriting object,
not the prototype object where the function
is its own property.
*/

var o = {
		a : 2,
		m : function() {
			return this.a +1;
		}
};

console.log(o.m()); //3

var p = Object.create(o);
// p is an object that inherits from o
//p.a = 4; 
//creates a property 'a' on p and the value is 4
console.log(p.m()); //5
// when p.m is called,
// 'this' refers to p
// so when p inherits the function m of o,
// 'this.a' mean p.a, the property
// 'a' of p

