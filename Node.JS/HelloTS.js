/*
Is an open source programming language that was developed by Microsoft
*/
var message = "Hello World";
console.log(message);
//we got classes, interfaces, objects, methods
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
var str = '1';
var str2 = str;
console.log(str2);
console.log(typeof (str2));
