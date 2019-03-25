/**
 * 
 */


/**
 * 1. USA
 * Define function getUSA()
 * Find the html element that contains "USA".
 * Print that element's contents.
 */

//function getUSA()
//{
//	var str = "USA";
//	var a = document.evaluate('//*[text()="' + str + '"]', document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE).snapshotItem(0);
//	
//	console.log(a.innerHTML);
//}
//
//getUSA();


/**
 * 2. Sales
 * Define function getPeopleInSales()
 * Print the names of all the people in the sales department.
 */

//function getPeopleInSales(){
//	var x = document.getElementsByClassName("empName");
//	Array.from(x).forEach((a) => {
//		if(a.nextElementSibling.innerHTML == 'Sales')
//		{
//			console.log(a.innerHTML);
//		}
//	});
//}
//
//getPeopleInSales();



/**
 * 3. Click Here
 * Define function getAnchorChildren()
 * Find all anchor elements with a <span> child.
 * Print the contents of <span>
 */

//function getAnchorChildren()
//{
//	var alist = document.querySelectorAll("a");
//	
//	for (let i = 0; i < alist.length; i++) {
//		var spans = alist[i].querySelectorAll("span");
//		for (let j = 0; j < spans.length; j++) {
//			console.log(spans[j].innerHTML);
//		}
//	}
//}
//
//getAnchorChildren();


/**
 * 4. Hobbies
 * Define function getHobbies()
 * Find all checked options in the 'skills' select element.
 * Print the value and the contents
 */

//function getHobbies()
//{
//	var x = document.getElementsByName("skills")[0];
//	
//	for (var i = 0; i < x.length; i++){
//	    var option = x.options[i];
//	    if(option.selected)
//	    {
//	    	console.log("value: " + option.value);
//	    	console.log("text: " + option.text);
//	    }
//	}
//}
//
//getHobbies();


/**
 * 5. Custom Attribute
 * Define function getCustomAttribute()
 * Find all elements with "data-customAttr" attribute
 * Print the value of the attribute.
 * Print the element that has the attribute.
 */

//function getCustomAttribute(){
//	var x = document.querySelectorAll('[data-customAttr]');
//	for(var i = 0; i < x.length; i++)
//	{
//		console.log("element: " + x[i]);
//		console.log("value: " + x[i].getAttribute('data-customAttr'));
//	}
//}
//
//getCustomAttribute();


/**
 * 6. Sum Event
 * NOTE: Write unobtrusive Javascript
 * Regarding these elements:
 * <input id="num1" class="nums" type="text"/>
 * <input id="num2" class="nums" type="text"/>
 * <h3>Sum: <span id="sum"></span></h3>
 * Define onchange event handler.
 * Add <input> element values.
 * Put the sum in the <span> element.
 * If values cannot be added, put "Cannot add" in the <span> element
 */

//function updateSum(){
//	var x = parseInt(document.getElementById("num1").value);
//	var y = parseInt(document.getElementById("num2").value);
//	var sum = x + y;
//	if(isNaN(sum))
//	{
//		document.getElementById("sum").innerHTML = "Cannot add";
//	}
//	else
//	{
//		document.getElementById("sum").innerHTML = sum;
//	}
//}
//
//document.getElementById("num1").addEventListener('input', function (evt) {
//	updateSum();
//});
//
//document.getElementById("num2").addEventListener('input', function (evt) {
//	updateSum();
//});

/**
 * 7. Skills Event
 * NOTE: Write unobtrusive Javascript
 * When user selects a skill, create an alert with a message similar to:
 * "Are you sure CSS is one of your skills?"
 * NOTE: no alert should appear when user deselects a skill.
 */

//var skills = document.getElementsByName("skills")[0];
//
//skills.addEventListener("change", function() {
//	alert("Are you sure " + skills.options[skills.selectedIndex].textContent + " is one of your skills?");
//});


/**
 * 8. Favorite Color Event
 * NOTE: Write unobtrusive Javascript
 * NOTE: This is regarding the favoriteColor radio buttons.
 * When a user selects a color, create an alert with a message similar to:
 * "So you like green more than blue now?"
 * In this example, green is the new value and blue is the old value.
 * Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
 */

//var color = document.getElementsByName("favoriteColor");
//let oldColor = "";
//for(var i = 0; i < color.length; i++)
//{
//	if(color[i].checked)
//	{
//		oldColor = color[i].value;
//	}
//	color[i].addEventListener("change", function() {
//		var newColor = this.value;
//		alert("So you like " + newColor + " more than " + oldColor + " now?");
//		oldColor = newColor;
//		changeAllColors(newColor);
//	});
//}
//
//function changeAllColors(col)
//{
//	for(var i = 0; i < color.length; i++)
//	{
//		color[i].setAttribute("style", "background-color: " + col + ";");
//	}
//}

/**
 * 9. Show/Hide Event
 * NOTE: Write unobtrusive Javascript
 * When user hovers over an employees name:
 * Hide the name if shown.
 * Show the name if hidden.
 */

//var employees = document.getElementsByClassName("empName");
//
//for (var i = 0; i < employees.length; i++) {
//	employees[i].addEventListener("mouseover", function() {
//		if (this.style.opacity < 1) {
//			this.style.opacity = "1";
//		} 
//		else {
//			this.style.opacity = "0";
//		 }
//	});
//}

/**
 * 10. Current Time
 * Regarding this element:
 * <h5 id="currentTime"></h5>
 * Show the current time in this element in this format: 9:05:23 AM
 * The time should be accurate to the second without having to reload the page.
 */

//function startTime() {
//	var d = new Date();
//	var n = d.toLocaleTimeString();
//
//  document.getElementById('currentTime').innerHTML = n;
//  t = setTimeout(function() {
//    startTime()
//  }, 500);
//}
//
//startTime();


/**
 * 11. Delay
 * Regarding this element:
 * <p id="helloWorld">Hello, World!</p>
 * Three seconds after a user clicks on this element, change the text to a random color.
 */

//let p = document.getElementById('helloWorld');
//p.addEventListener("click", function() {
//	 t = setTimeout(function() {
//		 p.style.color = "#"+((1<<24)*Math.random()|0).toString(16);
//	  }, 3000);
//});


/**
 * 12. Walk the DOM
 * Define function walkTheDOM(node, func)
 * This function should traverse every node in the DOM. Use recursion.
 * On each node, call func(node).
 */

//function walkTheDOM(node, func)
//{
//	func(node);
//	node = node.firstChild;
//	while (node) {
//		walkTheDOM(node, func);
//		node = node.nextSibling;
//	}
//}
//
//walkTheDOM(document.body, function (node) {
//	console.log(node.nodeName);
//});
