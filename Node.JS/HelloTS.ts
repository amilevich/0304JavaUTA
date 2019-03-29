/*
Is an open source programming language that was developed by Microsoft
*/

let message: string = "Hello World";
console.log(message);

//we got classes, interfaces, objects, methods

class Greeting{

    greet(): void {
        console.log("Hello World, again!!!")
    }
}

var obj = new Greeting();
obj.greet();

var str = '1';
var str2:number = <number><any>str;
console.log(str2);
console.log(typeof(str2));