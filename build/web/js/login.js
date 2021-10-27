const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');
let msgIn=document.getElementsByClassName("overlay-left")[0]
let msgUp=document.getElementsByClassName("overlay-right")[0]

let forrIn=document.getElementsByClassName("form-container")[0]
let forrUp=document.getElementsByClassName("form-container")[1]
signUpButton.addEventListener('click', () => {

	msgIn.style.transform="translateX(0%)";
	msgUp.style.transform="translateX(100%)";
	forrUp.style.transform="translateX(0%)";

});

signInButton.addEventListener('click', () => {
	msgIn.style.transform="translateX(-100%)";
	msgUp.style.transform="translateX(0%)";
	forrUp.style.transform="translateX(100%)";
});
