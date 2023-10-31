const body = document.querySelector("body");
const darkLight = document.querySelector("#darkLight");
const sidebar = document.querySelector(".sidebar");
const submenuItems = document.querySelectorAll(".submenu_item");
const sidebarOpen = document.querySelector("#sidebarOpen");
const sidebarClose = document.querySelector(".collapse_sidebar");
const sidebarExpand = document.querySelector(".expand_sidebar");
sidebarOpen.addEventListener("click", () => sidebar.classList.toggle("close"));


sidebar.addEventListener("mouseenter", () => {
  if (sidebar.classList.contains("hoverable")) {
    sidebar.classList.remove("close");
  }
});
sidebar.addEventListener("mouseleave", () => {
  if (sidebar.classList.contains("hoverable")) {
    sidebar.classList.add("close");
  }
});

darkLight.addEventListener("click", () => {
  body.classList.toggle("dark");
  if (body.classList.contains("dark")) {
    document.setI;
    darkLight.classList.replace("bx-sun", "bx-moon");
  } else {
    darkLight.classList.replace("bx-moon", "bx-sun");
  }
});

submenuItems.forEach((item, index) => {
  item.addEventListener("click", () => {
    item.classList.toggle("show_submenu");
    submenuItems.forEach((item2, index2) => {
      if (index !== index2) {
        item2.classList.remove("show_submenu");
      }
    });
  });
});

if (window.innerWidth < 768) {
  sidebar.classList.add("close");
} else {
  sidebar.classList.remove("close");
}

funcionario = pegar()

function imagem() {
  setFuncionario(funcionario)
  window.location.href = "../home-page/index.html"
}

var nomeFunc = document.getElementById("nome-func")
nomeFunc.textContent = localStorage.getItem("nome");

function contratarBeneficio() {
  setFuncionario(funcionario)
  window.location.href = '../beneficios-contratar/index.html' 
}

function visualizarBeneficios() {
  setFuncionario(funcionario)
  window.location.href = '../beneficios-visualizar/index.html' 
}


function setFuncionario(funcionario) {
  setContratadoNome(funcionario.nome)
  setContratadoMatricula(funcionario.matricula)
}