function passwordVisibility(){
	var visibility = document.getElementById("passwordfield")
	var checkvisible = document.getElementById("passwordcheckfield");
	
	if(visibility.type === "password"){
		visibility.type = "text";
		checkvisible.type = "text";
	}
	else{
		visibility.type ="password";
		checkvisible.type ="password";
	}
	
}