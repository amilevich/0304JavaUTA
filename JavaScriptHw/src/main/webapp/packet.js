/**
 * 
 */

//JavaScript Homework Part 1


//Number 1
function fib(n) {
    if (n <= 1) {
        return n
    }
    else {
        return fib(n-1) + fib(n-2)
    }
}
//console.log(fib(10))


//number 2
const bubbleSort = (arr) => {
    let sort =0
    for (i=0; i<arr.length; i++) {
        for (j=0; j<arr.length-i; j++) {
            if (arr[j-1]> arr[j]) {
                sort = arr[j-1]
                arr[j-1] = arr[j]
                arr[j] = sort
            }
        }
    }
    return arr
}

//console.log(bubbleSort([5,7,2,6,2,1]))

//Number 3
const reverStr = (str) => {
    let newStr= ''

    for(i=str.length -1; i >=0; i--) {
        newStr += str.charAt(i)
    }
    return newStr
}

//console.log(reverStr("hello"))

//Number 4
const factorial =(num) => {
    if (num ===0) {
       return 1 //because if its multiplied by zero, the whole thing will turn zero
    }
    
   else{
       return num * factorial(num-1)
   }
}
console.log(factorial(5)) //test


//Number 5

const subString = (str, len, offset) => {
    
    if(typeof str != 'string') {
       // alert("Not a string")  //needs to be commented out if not connected to an HTML file
        return
    }
    
    let newStr=''
    for (let i=offset; i<=len; i++ ) {
        newStr +=str.charAt(i)
    }

    return newStr
}

console.log(subString("Hello", 4, 1)) //test

//Number 6

const isEven= (num) => {
    let strNum= num.toString()
    let lastDigit= Number(strNum[strNum.length-1])
    
    if(lastDigit === 0 || lastDigit === 2 || lastDigit === 4 || lastDigit === 6 || lastDigit === 8 ) {
        return true
    } else {
        return false
    }
}

console.log(isEven(36)) //test

//Number 7

const isPalindrome = (str) => {
    return str.split('').reverse().join('') === str

}

console.log(isPalindrome("madam")) //test

//Number 8


//Number 9 

const traverseObject =(obj) => {
    return Object.entries(obj)
}

const fruits = { //test
    apple: 28,
    orange: 17,
    pear: 54,
  }

console.log(traverseObject(fruits))


//Number 10
const deleteElement = (someArr) => {
    console.log(someArr.length)
    someArr.splice(2,1)
    console.log(someArr.length)
    return someArr
}

let testArr= [3,5,1,2,4,1,2,3]

console.log(deleteElement(testArr)) // test case

//Number 11
const spliceElement = (someArr) => {
    console.log(someArr.length)
    someArr.splice(2,1)
    console.log(someArr.length)
    return someArr
}

//Number 12

function Person(name, age) {
    this.name = name,
    this.age= age
}

var john=new Person("John", 30)
//console.log(john)

//Number 13


function getPerson(name, age) {
    return obj = {name: name, age:age}
}

var john= getPerson("John",30)
console.log(john)





