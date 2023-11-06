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


var matricula = getContratadoMatricula();

$.ajax({
  url:"http://localhost:8888/contratados/"+matricula,
  type:"get",
  contentType: "application/json",

  success: function(response) {
    console.log(response)
      setContratadoNome(response.nome)
      setContratadoMatricula(response.matricula)
      
  },

  error: function(response) {
      validaResponse(response.responseJSON.causa);
  }
})

var nome = localStorage.getItem("nome")

var nomeFunc = document.getElementById("h1-ferias")
nomeFunc.textContent = "Férias, " + nome;

var dataInicio = "";
var dataFim = "";

var h2Ferias = document.getElementById("h2-ferias")

function imagem() {
  window.location.href = "../home-page/index.html"
}

function cadastrar() {
  window.location.href = "../cadastro-func/index.html"
}

function listagem() {
  window.location.href = "../listagem-func/index.html"
}

function beneficios() {
  window.location.href = "../beneficios-home/index.html"
}

function ferias() {
  window.location.href = "../ferias-home/index.html"
}

$.ajax({
  url: "http://localhost:8888/ferias/"+matricula,
  type: "get",

  success: function(response) {
      dataInicio = response.dataInicio;
      dataFim = response.dataFim;
  },

  error: function(error) {
      alert("Não foi possível consultar os dados, provavelmente servidor não está de pé")
  }
});


h2Ferias.textContent = "Parabéns " + nome + ", suas férias estão marcadas para começar \n" + dataInicio + " e terminar dia " + dataFim