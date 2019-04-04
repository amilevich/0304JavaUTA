/*
TypeScript - is an open source programming language
that was developed by Microsoft.
It is a strict syntactical superset of JavaScript, and adds
optional static typing to the language.

TypeScript is designed for development of large applications
and it transpiles to JavaScript.
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


interface Human{
    name: string;
    ability: string;
    powerlevel: number;

    useAbility();
}

class MetaHuman implements Human {
     public name: string;
     public ability: string;
     public powerlevel: number;
     // access modifiers
     // public, private, protected
     // default is public

     constructor(name: string, ability: string, powerlevel: number){
         this.name = name;
         this.ability = ability;
         this.powerlevel = powerlevel;
     }

     useAbility(): void {
         console.log(this.ability);
         // put some code here
     }
}


/*
DATA TYPES
number
boolean
string
undefined
null
object
array
function
void
any
enum
tuple - similar to arrays, where the type of a fixed number
of elements is known but need not be the same
*/

/*
The any data type is the super type of all types in TypeScript.
It denotes a dynamic type.
Using it is the same as opting out of type checking for
a variable.
*/

let variableOne: String = "Pupper";
let variableTwo: Number; // undefined
let variableThree = 5; // type will be number
let variableFour; // data type is any, value is undefined

// arrays 
let arry1: string[];
arry1=['one', 'two', 'three'];
let arry2: Array<number>;
arry2 = [1,2,3,4];

//functions 
function myFunc(first, second){
    return 'JackJack';
} 

// new way of doing stuff
function myOtherFunc(first: string, second: any):
    string{
        return 'JackJack';
    }

function myFuncTwo(): void {
    return;
}

// variable scopes
// global
// class - known as fields, within the class but outside
//          of the methods, can be accessed using the object 
            //of the class
// local - within loops, methods, etc

var global_num = 12;        //global variable
class Numbers {
    num_val = 13;           //class variable
    static sval = 10;       //static field

    storeNum(): void{
        var local_num = 14;     //local variable
    }
}
console.log("Global num: " + global_num);
console.log(Numbers.sval);
 

// other class stuff
interface A {}
interface B {}

class Pet implements A, B {
    // p_name: string;
    // p_age: number;
    p_type: string;

    // by giving an access modifier in the constructor
    // declares the field AND sets it equal to the parameters

    /* question marks make the parameter optional
    each parameter to the right of the question mark
    must also have a question mark
    */

    constructor(private p_name: string, private _age?: number){
    }

    get age() {
        return this._age;
    }

    set age(value: number) {
        if(value<0)
            throw new Error('less than 0 age');
        this._age = value;
    }
}
