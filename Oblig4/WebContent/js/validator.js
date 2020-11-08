
"use strict";

//class Validator{
	
	
//	constructor (root = null){
//		this.root = root;
//		this.run = this.run.bind(this);
//		this.color;
//		this.iFornavn;
//		this.iEtternavn;
//		this.iMobil;
//		this.iPassord;
//		this.iPassordRepetert;
//	
//	}
	
//	run(){
		  
   	console.log("Her")
		
		let inputRef = document.getElementById("root").getElementsByTagName("input");
		console.log(inputRef);
	
		let iFornavn = inputRef[0];
		console.log(this.iFornavn);
		iFornavn.addEventListener("input", validerFornavn);
		
		let iEtternavn = inputRef[1];
		iEtternavn.addEventListener("input", validerEtternavn);
		
		let iMobil = inputRef[2];
		iMobil.addEventListener("input", validerMobil);
		
		let iPassord = inputRef[3];
		iPassord.addEventListener("input", validerPassord);
		
		let iPassordRepetert = inputRef[4];
		iPassordRepetert.addEventListener("input", validerPassordRepetert);
			
		

		
	function validerFornavn(){
		let fornavn = iFornavn.value;
		if(fornavn.length < 2 || fornavn.length > 20){
			iFornavn.style.borderColor=("red");
		} else{
			iFornavn.style.borderColor=("green");
		}
	}
	
	function validerEtternavn(){
		let etternavn = iEtternavn.value;
		if(etternavn.length < 2 || etternavn.length > 20){
			iEtternavn.style.borderColor=("red");
		} else{
			iEtternavn.style.borderColor=("green");
		}
		
	}
	
	function validerMobil(){
		let mobil = iMobil.value;
		if(mobil.length === 8 && !isNaN(mobil)){
			iMobil.style.borderColor=("green");
		}else{
			iMobil.style.borderColor=("red");
		}
	}
	
	
	function validerPassord(){
		let pass = iPassord.value;
		if(pass.length < 4){
			iPassord.style.borderColor=("red");
		}else if(pass.length > 3 && pass.length < 8) {
			iPassord.style.borderColor=("orange");
		}
		else{
			iPassord.style.borderColor=("green");
		}
	}
	
	
	function validerPassordRepetert(){
		let pass = iPassord.value;
		let passRep = iPassordRepetert.value;
	
		if (passRep=== pass) {
    		iPassordRepetert.style.borderColor=("green");
   		 } else {
    		iPassordRepetert.style.borderColor=("red");
   		 }
	
	
		
}
	
	