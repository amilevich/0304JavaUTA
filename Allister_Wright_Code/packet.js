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
function printShape(shape, height, character) {}

