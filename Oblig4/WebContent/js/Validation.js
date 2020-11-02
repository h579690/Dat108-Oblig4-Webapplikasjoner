/**
 * 
 */
let inputs=document.getElementsByTagName("input");


function validerFornavn(){
	if(fornavn.length < 2 || fornavn.length > 20){
		fornavn.setAttribute("style", "border-color: red");
		console.log(inputs[i].getTextContext);
	} else{
		fornavn.setAttribute("style", "border-color: green");
	}
	
}

for(i = 0; i < inputs.length-1; i++){

	if(inputs[i].constructor.name===("fornavn")){	
		inputs[i].addEventListener("input", validerFornavn);
		fornavn = inputs[i].getTextContext;
		console.log(fornavn);
	}
	
	
}
