const levelSelected = document.querySelector(".level-selected");
const courseSelected = document.querySelector(".course-selected");
const levelOptionsContainer = document.querySelector(".level-options-container");
const courseOptionsContainer = document.querySelector(".course-options-container");
const levelSearchBox = document.querySelector(".level-search-box input");
const courseSearchBox = document.querySelector(".course-search-box input");
const levelOptionsList = document.querySelectorAll("div.level-options-container > div");
const courseOptionsList = document.querySelectorAll("div.course-options-container > div");

console.log(levelOptionsList);
console.log(courseOptionsList);

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

levelOptionsList.forEach(o => {
  o.addEventListener("click", () => {
    levelSelected.innerHTML = o.querySelector("label").innerHTML;
    levelOptionsContainer.classList.remove("active");
  });
});

courseOptionsList.forEach(o => {
  o.addEventListener("click", () => {
    courseSelected.innerHTML = o.querySelector("label").innerHTML;
    courseOptionsContainer.classList.remove("active");
  });
});

levelSearchBox.addEventListener("keyup", function(e) {
  levelFilterList(e.target.value);
});

courseSearchBox.addEventListener("keyup", function(e) {
  courseFilterList(e.target.value);
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
