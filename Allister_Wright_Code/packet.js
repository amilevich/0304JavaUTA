// PART 1
// 1) return the nth fibonacci number
function fib(n) {
  if (n < 0) {
    alert("Fibonacci index must be non-negative");
    return;
  }
  if (n < 2) return n;
  else return fib(n - 1) + fib(n - 2);
}
// console.log(fib(13));

// 2) bubble sort an array
function bubbleSort(numArray) {
  for (let i = numArray.length; i > 0; i--) {
    for (let j = 0; j < i; j++) {
      if (numArray[j] > numArray[j + 1]) {
        let k = numArray[j + 1];
        numArray[j + 1] = numArray[j];
        numArray[j] = k;
      }
    }
  }
  return numArray;
}
// let test = [5, 9, 8, 3, 4, 1, 2, 8, 0, 6];
// console.log(bubbleSort(test));

// 3) reverse a string
function reverseStr(someStr) {
  let buf = "";
  for (let i = someStr.length; i > 0; i--) {
    buf += someStr[i - 1];
  }
  return buf;
}
// console.log(reverseStr("This is a test string!"));

// 4) Recursive Factorial
function factorial(someNum) {
  if (someNum < 0) {
    alert("Factorial argument must be non-negative");
    return;
  }
  if (someNum < 3) return someNum;
  else return someNum * factorial(someNum - 1);
}
// console.log(factorial(7));

// 5) Substring
function substring(someStr, length, offset) {
  if (someStr.length < offset + length)
    alert(`index ${length + offset} cannot be accessed in string ${someStr}`);
  else {
    let buf = "";
    for (let i = offset; i < offset + length; i++) {
      buf += someStr[i];
    }
    return buf;
  }
}
// console.log(substring("TestString!", 0, 0));

// 6) Even test without mod operator
function isEven(someNum) {
  return (someNum & 0x01) == 0 ? true : false;
}
// console.log(isEven(7));

// 7) return true if someStr is a palidrome, otherwise return false
function isPalindrome(someStr) {
  return someStr == reverseStr(someStr);
}
// console.log(isPalindrome("kayaak"));

// 8) draw a specified shape on the console
function printShape(shape, height, character) {
  let drawing = "";
  switch (shape) {
    case "Square":
      for (let i = 0; i < height; i++) {
        drawing += character.repeat(height) + "\n";
      }
      break;
    case "Triangle":
      for (let i = 0; i <= height; i++) {
        drawing += character.repeat(i) + "\n";
      }
      break;
    case "Diamond":
      for (let row = 0; row < 2 * height - 1; row++) {
        let whitespaceCount = Math.abs(1 + row - height);
        drawing += " ".repeat(whitespaceCount);
        drawing += character.repeat(height - whitespaceCount - 1);
        drawing += character;
        drawing += character.repeat(height - whitespaceCount - 1);
        drawing += " ".repeat(whitespaceCount) + "\n";
      }
      break;
  }
  console.log(drawing);
}
// printShape("Diamond", 3, "*");

// 9) Print an object literal
function traverseObject(ob) {
  for (let prop in ob) console.log(`${prop}: ${ob[prop]}`);
}
// let test = {'name': 'Jim', 'phone': '555-555-5555'}
// traverseObject(test);

// 10) Delete element from array
function deleteElement(someArr) {
  console.log(someArr.length);
  someArr[2] = null;
  console.log(someArr.length);
}
// deleteElement([,,,1])

// 11) Splice element
function spliceElement(someArr) {
  console.log(someArr.length);
  someArr.splice(2, 1);
  console.log(someArr.length);
}
// spliceElement([,,,1])

// 12) Object Constructor
function Person(name, age) {
  this.name = name;
  this.age = age;
}
// traverseObject(new Person("John", 30))

// 13) Object literal constructor
function getPerson(name, age) {
  return { name: name, age: age };
}
// traverseObject(getPerson("Jane", 28))

