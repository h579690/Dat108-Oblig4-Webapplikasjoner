/**
 * 
 */
"use strict";

let inputs=document.getElementsByTagName("input");

let iFnavn;
let iEnavn;
let iMob;
let iPass;
let iPRep;

for(let i = 0; i < inputs.length-1; i++){
	let inpName = inputs[i].getAttribute("name");

	if(inpName===("fornavn")){	
		iFnavn = inputs[i];	
	}
	else if(inpName == ("etternavn")){
		iEnavn = inputs[i];
	}
	else if(inpName == ("mobil")){
		iMob = inputs[i];
	}
	else if(inpName ==("passord")){
		iPass = inputs[i];
	}
	else if(inpName === ("passordRepetert")){
		iPRep = inputs[i];
	}
}
	
iFnavn.addEventListener("input", validerFornavn);
iEnavn.addEventListener("input", validerEtternavn);
iMob.addEventListener("input", validerMobil);
iPass.addEventListener("input", validerPass);
iPRep.addEventListener("input", validerPassRep);



function validerFornavn(){
	let fornavn = iFnavn.value;
	if(fornavn.length < 2 || fornavn.length > 20){
		iFnavn.style.borderColor=("red");
	} else{
		iFnavn.style.borderColor=("green");
	}
	
}

function validerEtternavn(){
	let etternavn = iEnavn.value;
	if(etternavn.length < 2 || etternavn.length > 20){
		iEnavn.style.borderColor=("red");
	} else{
		iEnavn.style.borderColor=("green");
	}
	
}

function validerMobil(){
	let mobil = iMob.value;
	if(mobil.length === 8 && !isNaN(mobil)){
		iMob.style.borderColor=("green");
	}else{
		iMob.style.borderColor=("red");
	}
}

function validerPass(){
	let pass = iPass.value;
	if(pass.length < 4){
		iPass.style.borderColor=("red");
	}else if(pass.length > 3 && pass.length < 8) {
		iPass.style.borderColor=("orange");
	}
	else{
		iPass.style.borderColor=("green");
	}
}

function validerPassRep(){
	let pass = iPass.value;
	let passRep = iPRep.value;
	
	if (passRep=== pass) {
    	iPRep.style.borderColor=("green");
    } else {
    	iPRep.style.bordColor("red");
    }
	
}

	
	

