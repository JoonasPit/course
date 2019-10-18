function passwordVisibility(){
	var visibility = document.getElementById("passwordfield")
	if(visibility.type === "password"){
		visibility.type = "text";
	}
	else{
		visibility.type ="password";
	}
}