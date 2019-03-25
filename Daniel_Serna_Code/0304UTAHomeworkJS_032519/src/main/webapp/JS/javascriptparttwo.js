/*
-----------------------------------------------------------------------------------
PART II

Part II will focus on Javascript's ability to manipulate the DOM.
Use the provided index.html
Put your Javascript in the provided <script> element at the bottom of the page.
Please put the question itself as a comment above each answer.

NOTE: Part II will be done twice: once with Javascript and once with jQuery.
	  They should be done separately.
	  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
-----------------------------------------------------------------------------------
 */

/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/

function getUSA()
{
	// findUSA stores all occurences of 'SPAN' in array
	let findUSA = document.getElementsByTagName("SPAN")
	// have the total number of spans in arrayLength
	let arrayLength = findUSA.length
	for(let r = 0; r < arrayLength; r++)
	{
		if(findUSA[r].innerText == "USA")
			console.log(findUSA[r].innerText)
	}
}

// getUSA(); 

/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/

function getPeopleInSales()
{
	let findSales = document.getElementsByTagName("TD")
	let arrayCount = findSales.length
	for(let r = 0; r < arrayCount; r++)
	{
		if(findSales[r].textContent == "Sales")
		{
			console.log(findSales[r - 1].textContent)
		}
	}
}

// getPeopleInSales();

/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/

function getAnchorChildren()
{
	let findAnchor = document.getElementsByTagName("A")
	let anchorArrayLength = findAnchor.length
	
	let findSpan = document.getElementsByTagName("SPAN")
	let spanArrayLength = findSpan.length
	
	for(let r = 0; r < anchorArrayLength; r++)
	{
		for(let c = 0; c < spanArrayLength; c++)
		{
			if(findAnchor[r].contains(findSpan[c]))
			{
				console.log(findSpan[c].innerText)
			}
		}
		
	}
}

// getAnchorChildren()

/*
4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/

function getHobbies()
{
	let findCheckedOptions = document.querySelectorAll('select[name= "skills"] > option[selected = "selected"]' )
	
	for(let myCheck of findCheckedOptions)
	{
		console.log(myCheck.innerText)
	}
}

// getHobbies()

/*
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/

function getCustomAttribute()
{
	let attr = document.querySelectorAll('[data-customAttr]')
	for(let i = 0; i < attr.length; i++)
	{
		console.log(attr[i].dataset.customattr)
	}
	
}

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

