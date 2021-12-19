const levelSelected = document.querySelector(".level-selected");
const levelOptionsContainer = document.querySelector(".level-options-container");
const levelSearchBox = document.querySelector(".level-search-box input");
const levelOptionsList = document.querySelectorAll("div.level-options-container > div");

const courseSelected = document.querySelector(".course-selected");
const courseOptionsContainer = document.querySelector(".course-options-container");
const courseSearchBox = document.querySelector(".course-search-box input");
const courseOptionsList = document.querySelectorAll("div.course-options-container > div");

const tutorSelected = document.querySelector(".tutor-selected");
const tutorOptionsContainer = document.querySelector(".tutor-options-container");
const tutorSearchBox = document.querySelector(".tutor-search-box input");
const tutorOptionsList = document.querySelectorAll("div.tutor-options-container > div");

const typeSelected = document.querySelector(".type-selected");
const typeOptionsContainer = document.querySelector(".type-options-container");
const typeOptionsList = document.querySelectorAll("div.type-options-container > div");

const availabilitySelected = document.querySelector(".availability-selected");
const availabilityOptionsContainer = document.querySelector(".availability-options-container");
const availabilityOptionsList = document.querySelectorAll("div.availability-options-container > div");

const dateSelected = document.querySelector(".form-control");
const bookBtn = document.getElementById("bookBtn");

let currentActive = 1;

courseSelected.addEventListener("click", () => {
  courseOptionsContainer.classList.toggle("active");
  courseSearchBox.value = "";
  courseFilterList("");
  if (courseOptionsContainer.classList.contains("active")) {
    courseSearchBox.focus();
  }
});

levelSelected.addEventListener("click", () => {
  levelOptionsContainer.classList.toggle("active");
  levelSearchBox.value = "";
  levelFilterList("");
  if (levelOptionsContainer.classList.contains("active")) {
    levelSearchBox.focus();
  }
});

tutorSelected.addEventListener("click", () => {
  tutorOptionsContainer.classList.toggle("active");
  tutorSearchBox.value = "";
  tutorFilterList("");
  if (tutorOptionsContainer.classList.contains("active")) {
    tutorSearchBox.focus();
  }
});

availabilitySelected.addEventListener("click", () => {
  availabilityOptionsContainer.classList.toggle("active");
});

typeSelected.addEventListener("click", () => {
  typeOptionsContainer.classList.toggle("active");
});

levelOptionsList.forEach(o => {
  o.addEventListener("click", () => {
    currentActive = 0;
    levelSelected.innerHTML = o.querySelector("label").innerHTML;
    levelOptionsContainer.classList.remove("active");
    currentActive++;
    console.log(currentActive);
    update();
  });
});

courseOptionsList.forEach(o => {
  o.addEventListener("click", () => {
    currentActive = 1;
    courseSelected.innerHTML = o.querySelector("label").innerHTML;
    courseOptionsContainer.classList.remove("active");
    currentActive++;
    update();
  });
});

tutorOptionsList.forEach(o => {
  o.addEventListener("click", () => {
    currentActive = 3;
    tutorSelected.innerHTML = o.querySelector("label").innerHTML;
    tutorOptionsContainer.classList.remove("active");
    currentActive++;
    update();
  });
});

typeOptionsList.forEach(o => {
  o.addEventListener("click", () => {
    currentActive = 3;
    typeSelected.innerHTML = o.querySelector("label").innerHTML;
    typeOptionsContainer.classList.remove("active");
    currentActive++;
    update();
  });
});

availabilityOptionsList.forEach(o => {
  o.addEventListener("click", () => {
    currentActive = 4;
    availabilitySelected.innerHTML = o.querySelector("label").innerHTML;
    availabilityOptionsContainer.classList.remove("active");
    currentActive++;
    update();
  });
});

levelSearchBox.addEventListener("keyup", function(e) {
  levelFilterList(e.target.value);
});

courseSearchBox.addEventListener("keyup", function(e) {
  courseFilterList(e.target.value);
});

tutorSearchBox.addEventListener("keyup", function(e) {
  tutorFilterList(e.target.value);
});

const courseFilterList = searchTerm => {
  searchTerm = searchTerm.toLowerCase();
  courseOptionsList.forEach(option => {
    let label = option.firstElementChild.nextElementSibling.innerText.toLowerCase();
    if (label.indexOf(searchTerm) != -1) {
      option.style.display = "block";
    } else {
      option.style.display = "none";
    }
  });
};

const levelFilterList = searchTerm => {
  searchTerm = searchTerm.toLowerCase();
  levelOptionsList.forEach(option => {
    let label = option.firstElementChild.nextElementSibling.innerText.toLowerCase();
    if (label.indexOf(searchTerm) != -1) {
      option.style.display = "block";
    } else {
      option.style.display = "none";
    }
  });
};

const tutorFilterList = searchTerm => {
  searchTerm = searchTerm.toLowerCase();
  tutorOptionsList.forEach(option => {
    let label = option.firstElementChild.nextElementSibling.innerText.toLowerCase();
    if (label.indexOf(searchTerm) != -1) {
      option.style.display = "block";
    } else {
      option.style.display = "none";
    }
  });
};

function update() {
    console.log("in update");
    console.log(currentActive);
    if(currentActive === 1) {
      courseSelected.style.pointerEvents = "all";
      courseSelected.style.backgroundColor = "white";
    } else if(currentActive === 2) {
      tutorSelected.style.pointerEvents = "all";
      tutorSelected.style.backgroundColor = "white";
      typeSelected.style.pointerEvents = "all";
      typeSelected.style.backgroundColor = "white";
    } else if(currentActive === 4){
      availabilitySelected.style.pointerEvents = "all";
      availabilitySelected.style.backgroundColor = "white";
    }else if(currentActive === 5 && dateSelected.value) {
      bookBtn.disabled = false;
    }
}


