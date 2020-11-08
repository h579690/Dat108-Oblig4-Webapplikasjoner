
"use strict";

class Validator{
	
	
	constructor (root = null){
		this.root = root;
		this.run = this.run.bind(this);
		this.color;
		this.iFornavn;
		this.iEtternavn;
		this.iMobil;
		this.iPassord;
		this.iPassordRepetert;
	
	}
	
	run(){
		  
   	console.log("Her")
		
		const inputRef = document.getElementById(this.root).getElementsByTagName("input");
	
		this.iFornavn = inputRef[0];
		console.log(this.iFornavn);
		this.iFornavn.addEventListener("change", this.validerFornavn);
		
		this.iEtternavn = inputRef[1];
		this.iEtternavn.addEventListener("change", this.validerEtternavn);
		
		this.iMobil = inputRef[2];
		this.iMobil.addEventListener("change", this.validerMobil);
		
		this.iPassord = inputRef[3];
		this.iPassord.addEventListener("change", this.validerPassord);
		
		this.iPassordRepetert = inputRef[4];
		this.iPassordRepetert.addEventListener("change", this.validerPassorRepetert);
			
		}

		
	validerFornavn(){
		let fornavn = this.iFornavn.value;
		if(fornavn.length < 2 || fornavn.length > 20){
			this.iFornavn.style.borderColor=("red");
		} else{
			this.iFornavn.style.borderColor=("green");
		}
	}
	
	validerEtternavn(){
			let etternavn = this.iEtternavn.value;
		if(etternavn.length < 2 || etternavn.length > 20){
			this.iEnavn.style.borderColor=("red");
		} else{
			this.iEttenavn.style.borderColor=("green");
		}
		
	}
	
	validerMobil(){
		let mobil = this.iMob.value;
		if(mobil.length === 8 && !isNaN(mobil)){
			this.iMob.style.borderColor=("green");
		}else{
			this.iMob.style.borderColor=("red");
		}
	}
	
	
	validerPassord(){
		let pass = this.Pass.value;
		if(pass.length < 4){
			this.iPass.style.borderColor=("red");
		}else if(pass.length > 3 && pass.length < 8) {
			this.iPass.style.borderColor=("orange");
		}
		else{
			this.iPass.style.borderColor=("green");
		}
	}
	
	
	validerPassordRepetert(){
		let pass = this.iPass.value;
		let passRep = this.iPRep.value;
	
		if (passRep=== pass) {
    		this.iPRep.style.borderColor=("green");
   		 } else {
    		this.iPRep.style.borderColor("red");
   		 }
	
	}
		
}
	
	