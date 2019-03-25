/**
 * 
 */

// 1

const getUSA =()=> {
	let value = document.querySelector("span[data-customAttr='USA']").innerHTML
	console.log(value)
}

getUSA()

//2


const getPeopleInSales =()=>{
	let tables = document.getElementsByTagName("td");
	for(let i=0; i<tables.length; i++) {
		if (tables[i].innerText == "Sales") {
			console.log(tables[i-1].innerText)
		}
	}
	
}

getPeopleInSales()


//3
const getAnchorChildren=()=>{
    let tags = document.getElementsByTagName("a")
    let spans = document.getElementsByTagName("span")

    for(let i=0; i<tags.length; i++) {
        for (let j=0; j<spans.length; j++) {
            if (tags[i].contains(spans[j])) {
                console.log(spans[j].innerText)
            }
        }
    }
    
}
getAnchorChildren()

//4
const getHobbies=()=>{
    let hob = document.getElementsByTagName('select');
	for(let i=0; i<hob.length; i++) {
        console.log(hob[i].value) //value gives value of what is selected
    }
}

getHobbies()


//5
const getCustomAttribute =()=>{
    let value = document.querySelectorAll("[data-customAttr]")
    for(let i=0; i<value.length; i++) {
        console.log(value[i].innerHTML)
    } 
}

getCustomAttribute()

//6
const getSum =() => { //I put an onChange event in the HTML file pointing to this function
    let val1 = document.getElementById("num1").value
    let val2 = document.getElementById("num2").value
    let sum = Number(val1)+ Number(val2)
    
    document.getElementById("sum").innerHTML = sum
}

//7
const alert2 =(event)=>{ //I added an onChange event on the select tag pointing to this function
	   let val = event.target.value
	   console.log(event.target.value)
	    alert(val + " is not your hobby!") 
	  }

//8
const alertColor =(event) => { //added an onchange event on the input tags pointing to this function
    let val = event.target.value
    alert(val)

  }


//10
const startTime =()=> {
	let clock = document.getElementById("currentTime");
	var today = new Date();
	var h = today.getHours();
	var m = today.getMinutes();
	var s = today.getSeconds();
	m = checkTime(m);
	s = checkTime(s);
	clock.innerHTML = h + ":" + m + ":" + s;
	var t = setTimeout(startTime, 500); }

//12

const walkTheDOM = (node, func) => {
    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}











