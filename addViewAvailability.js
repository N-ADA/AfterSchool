const time = document.querySelector(".time-control");
const date = document.querySelector(".date-control");
const addBtn = document.getElementById("addBtn");

time.addEventListener("change", () =>{
	updateAddBtn();
});
date.addEventListener("change", () =>{
	updateAddBtn();
});

function updateAddBtn(){
	console.log("here");
	if(time.value && date.value){
		addBtn.disabled = false;
	}
}