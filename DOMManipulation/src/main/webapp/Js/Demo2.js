/**
 * 
 */

/*
 * DOM - Document Object Model
 * it defines the logical structure
 * of documents and the way a document
 * is accessed and manipulated
 * HTML document - a series of elements,
 * all of which can be manipulated
 */

//////////GET ELEMENT BY ID
let paraTwo = document.getElementById('para2');
paraTwo.innerText = 'Jay has two legs'
//console.log(paraTwo.innerText);

paraTwo.innerHTML = '<i> Well, today was not as bad as I thought it would be. <i>'

/////////GET ELEMENT BY CLASS NAME
	let hders = document.getElementsByClassName('headers');
hders[1].textContent = "The third day";

// you can also change style of your elements
// hders[].style.backgroundColor = ...


/////////GET ELEMENT BY TAGNAME
// getElementsByTagName('');


	
	
