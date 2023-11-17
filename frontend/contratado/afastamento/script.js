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

var olaNomeFunc = document.getElementById("ola")

var nomeFuncionario = localStorage.getItem("nome")

olaNomeFunc.textContent = "Bem vindo, " + nomeFuncionario
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

var textoResponse = document.getElementById("texto")
var botao = document.getElementById("programarAfastamento")

$.ajax({
  url:"http://localhost:8888/afastamento/"+matricula,
  type:"get",
  contentType: "application/json",

  success: function(response) {
    console.log(response)
      setContratadoNome(response.nome)
      setContratadoMatricula(response.matricula)
      textoResponse.textContent = nomeFuncionario + ", você programou seu afastamento para começar dia "
      + response.inicio + " e acabar dia " + response.fim + ". O motivo do seu afastamento é de " + response.motivo + 
      " por conta de " + response.descricao
  },

  error: function(response) {
    console.log(response)
    textoResponse.textContent = response.responseJSON.message
    botao.style.display = "inline-block"
  }
})

function ferias() {
  window.location.href = "../ferias-home/index.html"
}

function afastamento() {
  window.location.href = "../afastamento/index.html"
}


function programarAfastamento() {
  window.location.href = "../afastamento-programar/index.html"
}