/**
 * 
 */

/*1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
  */
function getUSA()
{
	let doc = document.getElementsByTagName("span");
	for(let i = 0; i < doc.length; i++)
	{
	    let currValue = doc[i].innerHTML;
	    
		if(currValue === "USA")
		{
			return doc[i].innerHTML;
		}
	}
}

console.log(getUSA());
/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
  */

function getPeopleInSales()
{
	let doc = document.getElementsByTagName("td");
	
	for (var i = 0; i < doc.length; i++)
	{
		if(doc[i].innerHTML === "Sales")
		console.log(doc[i-1].innerHTML);
	}
}

getPeopleInSales();
/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
  */
function getAnchorChildren()
{
	 let doc = document.getElementsByTagName("a")
	    
	   for(let i = 0;i < doc.length;i++)
	    {
	        if(doc[i].children.length > 0)
	        {
	            if(doc[i].children[0].tagName == 'SPAN')
	            {
	                console.log(doc[i].children[0].innerHTML)
	            }
	        }
	    }
}
getAnchorChildren();
/*
4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
  */
function getHobbies()
{
    let doc = document.getElementsByName("skills")[0];
    let skills=doc.children;
   for(let i=0;i<skills.length;i++)
   {
        if(skills[i].hasAttribute("selected"))
        {
          console.log(skills[i].innerHTML);
        }
    }
    
}
getHobbies();
/*
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/
function getCustomAttribute()
{
	let doc = document.querySelectorAll("[data-customAttr]");
	
	for (var i = 0; i < doc.length; i++) 
	{
		console.log("Value: "+ doc[i].getAttribute("data-customAttr")+"\n Element: "+doc[i].tagName);
	}
	
}
getCustomAttribute();

/*
6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
	<h3>Sum: <span id="sum"></span></h3>


Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element
*/

function onChange()
{
	
	let x = parseInt(document.getElementById("num1").value);
	let y = parseInt(document.getElementById("num2").value);
	
	if (typeof x !== "number" || typeof y !== "number" || isNaN(x) || isNaN(y))
	{
		document.getElementById("sum").textContent = "Can't Add";
	}
	else
		document.getElementById("sum").textContent = x+y;
	
	console.log(document.getElementById("sum").innerHTML);
}
let numOne = document.getElementById("num1");
let numTwo = document.getElementById("num2");
numOne.addEventListener("change",onChange);
numTwo.addEventListener("mouseover",onChange);
/*
7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/

function skillSelect()
{
	alert("Are you sure "+doc[2].value+" is one of your skills?");
}
let doc = document.getElementsByTagName("select");
doc[2].addEventListener("input",skillSelect);

/*
8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/
let oldColor = null;
let newColor = null;
function update(color)
{
	newColor = color;
	//console.log(color.value);
	alert("So you like "+newColor.value+" more than "+oldColor.value+" now?",true)
	oldColor = color;
	
}
let favColor = document.getElementsByName("favoriteColor");
oldColor = favColor[0];
//oldColor.value = "white";
for (var i = 0; i < favColor.length; i++) 
{	
	favColor[i].addEventListener('click',colorSelect);
}
 function colorSelect()
 {
	let favColor = document.getElementsByName("favoriteColor");
	for (var i = 0; i < favColor.length; i++) 
	{	
		if(favColor[i].checked)
		{
			update(favColor[i]);
			document.body.style.backgroundColor = newColor.value;
		}
	}
 }
colorSelect();
/*
9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
	Hide the name if shown.
	Show the name if hidden.
*/
doc = document.getElementsByClassName("empName");
document.body.style.background = "white";

for (var i = 0; i < doc.length; i++) 
{
	doc[i].addEventListener("mouseenter",function(){hideTxt(this);},true);
}
function hideTxt(inElem)
{
	
	if (inElem.style.color != document.body.style.background)
	{
		inElem.style.color = document.body.style.background;
	}
	else 
	{
		inElem.style.color = "Black";
	}
}
/*
10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/
function startTime() 
{
	let clock = document.getElementById("currentTime");
	var today = new Date();
	var h = today.getHours();
	var min = today.getMinutes();
	var sec = today.getSeconds();
	min = addZero(min);
	sec = addZero(sec);
	clock.innerHTML = h + ":" + min + ":" + sec;
	var t = setTimeout(startTime, 500);
}
function addZero(i) 
{
	if (i < 10)
		i = "0" + i
	 
	return i;
}
startTime();


/*
11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/
let changeTxt = document.getElementById('helloWorld');
changeTxt.addEventListener("click",function(){colorText(this)},true);

function colorText(inTxt)
{
	setTimeout(function()
				{
					colors = ["red","green","yellow","blue","orange"];
					inTxt.style.color = colors[Math.floor(Math.random()*colors.length)];
				},3000);
}

/*
12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).
*/
function walkTheDOM(node, func)
{
    func(node);

    for (let child of node.children) 
    {
        walkTheDOM(child, func);
    }
    
}
walkTheDOM(document, (node) => {console.log('Node:', node);})












