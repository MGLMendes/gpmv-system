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

var nomeFunc = document.getElementById("nome-func")
nomeFunc.textContent = localStorage.getItem("nome");

funcionario = pegar()

function imagem() {
  setContratado(funcionario)
  window.location.href = "../home-page/index.html"
}

function cadastrar() {
  setContratado(funcionario)
  window.location.href = "../cadastro-func/index.html"
}

function listagem() {
  setContratado(funcionario)
  window.location.href = "../listagem-func/index.html"
}

function beneficios() {
  setContratado(funcionario)
  window.location.href = "../beneficios-home/index.html"
}

function contratarBeneficio() {
  setContratado(funcionario)
  window.location.href = '../beneficios-contratar/index.html' 
}

function visualizarBeneficios() {
  setContratado(funcionario)
  window.location.href = '../beneficios-visualizar/index.html' 
}


function setContratado(funcionario) {
  setContratadoNome(funcionario.nome)
  setContratadoMatricula(funcionario.matricula)
}