/*
TypeScript - is an open source programming language
that was developed by Microsoft.
It is a strict syntactical superset of JavaScript,
and adds optional static typing to the language.

TypeScript is designed for development of large
applications and it transpiles to JavaScript.
(Transcompiles)
*/

let message: string = "Hello World";
console.log(message);

// we got classes, interfaces, objects, methods

class Greeting {
    greet(): void {
        console.log("Hello World, again!!!")
    }
}

var obj = new Greeting();
obj.greet();

interface Human {
    name: string;
    ability: string;
    powerlevel: number;

    useAbility();
}

class MetaHuman implements Human {

    // access modifiers
    // public, protected, private
    // default is public
    public name: string;
    public ability: string;
    public powerlevel: number;

    constructor(name: string, ability: string, powerlevel: number) {
        this.name = name;
        this.ability = ability;
        this.powerlevel = powerlevel;
    }

    useAbility(): void {
        console.log(this.ability);
        //put some implementation here
    }
}

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

let s1; // type of any, hover over s1 to see
let s2: string; // type of string
let s3 = 'hover over'; //type of string

/*
The any data type is the super type of all types
in TypeScript. It denotes a dynamic type.
Using it is the same as opting out of type checking
for a variable.
*/

var variableOne: String = "Puppy";
var variableTwo: Number; // undefined
var variableThree = 5; // type will be number
var variableFour; // data type is any, value is undefined

// void
let v1: void = null;
v1 = undefined;
let varFive: null = undefined;
let varSix: undefined = null;

// arrays
let arry1: string[];
arry1 = ['one', 'two', 'three'];
let arry2: Array<number>;
arry2 = [2, 3, 4];

// functions
function myFunc(first, second) {
    return 'JackJack';
}

/// new way of doing stuff
function myFuncTwo(first: string, second: any):
    string {
    return 'JackJack';
}

function myOtherFunc(): void {
    return;
}

// Type Assertion <>
var str = '1';
var str2: number = <number><any>str;
// to play around with later
console.log(str2);
console.log(typeof (str2));

// variable scopes
// global
// class - known as fields, within the class but outside
// methods, can be accessed using the object
// of the class
// local - within loops, methods, etc

var global_num = 12;         // global variable
class Numbers {
    num_val = 13;           // class variable
    static sval = 10;       // static field

    storeNum(): void {
        var local_num = 14; // local variable
    }
}
console.log("Global num: " + global_num);
console.log(Numbers.sval);


// other class stuff
interface A { }
interface B { }

class Pet implements A, B {
    // p_name: string;
    // p_age: number;
    // type: string;

    // question marks make the parameter optional
    //each parameter to the right of a question mark
    // must also have a question mark

    // by giving an access modifier in the constructor
    // declares the field AND sets it equal to the parameters
    constructor(private name: string, private _age?: number) {
         // declaring variables inside our constructor
        this.name = name;
         this.age = _age;
    }

    get age() {
        return this._age;
    }

    set age(value: number) {
        if (value < 0)
            throw new Error('less than 0 age');
        this._age = value;
    }
}