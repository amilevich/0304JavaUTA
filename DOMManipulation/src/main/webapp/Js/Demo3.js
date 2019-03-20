/**
 * 
 */

// Events - any action an end user performs
/*
 * click
 * mouseup
 * mousedown
 * mouseenter
 * mouseleave
 * mousemove
 * altkey
 */

let buttonOne = document.getElementById('button');
buttonOne.addEventListener('click', myFuncTwo);

function myFuncTwo(eve) {
	console.log(eve.altKey);
	//console.log(eve.target); display target element
	//console.log(eve.clientX); mouse position
	//console.log(eve.offsetX); mouse position in respect to the element
}

buttonOne.addEventListener('mouseenter', myFuncThree);
function myFuncThree(eveThree){
	console.log(eveThree.type);
}

