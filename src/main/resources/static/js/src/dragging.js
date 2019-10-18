function drop(event){
	event.preventDefault();
	var data = event.dataTransfer("Text");
	event.target.appendChild(document.getElementById(data));
}

function startDrag(event) {
	  event.dataTransfer.setData("Text", event.target.id);
	}
function allowDrop(event) {
	  event.preventDefault();
	}