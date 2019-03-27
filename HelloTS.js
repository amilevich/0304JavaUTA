/*
TypeScript - is an open source programming language
that was developed by Microsoft.
It is a strict syntactical superset of JavaScript,
and adds optional static typing to the language.

TypeScript is designed for development of large
applications and it transpiles to JavaScript.
(Transcompiles)
*/
var message = "Hello World";
console.log(message);
// we got classes, interfaces, objects, methods
var Greeting = /** @class */ (function () {
    function Greeting() {
    }
    Greeting.prototype.greet = function () {
        console.log("Hello World, again!!!");
    };
    return Greeting;
}());
var obj = new Greeting();
obj.greet();
var MetaHuman = /** @class */ (function () {
    function MetaHuman(name, ability, powerlevel) {
        this.name = name;
        this.ability = ability;
        this.powerlevel = powerlevel;
    }
    MetaHuman.prototype.useAbility = function () {
        console.log(this.ability);
        //put some implementation here
    };
    return MetaHuman;
}());
/*
DATA TYPES
number
boolean
string
null
undefined
any
array
object
function
void
enum
tuple - similar to arrays, where the type of a fixed
        number of elements is known but need not be
        the same
*/
var s1; // type of any, hover over s1 to see
var s2; // type of string
var s3 = 'hover over'; //type of string
/*
The any data type is the super type of all types
in TypeScript. It denotes a dynamic type.
Using it is the same as opting out of type checking
for a variable.
*/
var variableOne = "Puppy";
var variableTwo; // undefined
var variableThree = 5; // type will be number
var variableFour; // data type is any, value is undefined
// void
var v1 = null;
v1 = undefined;
var varFive = undefined;
var varSix = null;
// arrays
var arry1;
arry1 = ['one', 'two', 'three'];
var arry2;
arry2 = [2, 3, 4];
// functions
function myFunc(first, second) {
    return 'JackJack';
}
/// new way of doing stuff
function myFuncTwo(first, second) {
    return 'JackJack';
}
function myOtherFunc() {
    return;
}
// Type Assertion <>
var str = '1';
var str2 = str;
// to play around with later
console.log(str2);
console.log(typeof (str2));
// variable scopes
// global
// class - known as fields, within the class but outside
// methods, can be accessed using the object
// of the class
// local - within loops, methods, etc
var global_num = 12; // global variable
var Numbers = /** @class */ (function () {
    function Numbers() {
        this.num_val = 13; // class variable
    }
    Numbers.prototype.storeNum = function () {
        var local_num = 14; // local variable
    };
    Numbers.sval = 10; // static field
    return Numbers;
}());
console.log("Global num: " + global_num);
console.log(Numbers.sval);
