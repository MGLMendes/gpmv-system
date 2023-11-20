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

var matriculaFunc = localStorage.getItem("matricula")

var bAlimentacao = document.getElementById("alimentacao")
var precoAlimentacao = document.getElementById("preco-alimentacao")

var bRefeicao = document.getElementById("refeicao")
var precoRefeicao = document.getElementById("preco-refeicao")

var bVt = document.getElementById("vt")
var precoVt = document.getElementById("preco-vt")

var bGp = document.getElementById("gym")
var precoGp = document.getElementById("preco-gym")

var op1 =document.getElementById("opcao1")
var op2 =document.getElementById("opcao2")
var op3 =document.getElementById("opcao3")
var op4 =document.getElementById("opcao4")

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
      alert("ERROR")
  }
})

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

function afastamento() {
  window.location.href = "../afastamento/index.html"
}

var msg = document.getElementById("mensagem")

function programarFerias() {
  const inicio = document.getElementById("date-inicio");
  const fim = document.getElementById("date-fim");

  const dataInicio = inicio.value.split('-').reverse().join('/');
  const dataFim = fim.value.split('-').reverse().join('/');

  console.log(dataInicio, dataFim)

  const ferias = JSON.stringify({
    "inicio":dataInicio,
    "fim":dataFim
  })

  console.log(ferias)

    $.ajax({
      url: "http://localhost:8888/ferias/programar/"+matricula,
      type: "post",
      data: ferias,
      contentType: "application/json",

      success: function(response) {
        msg.textContent = "Férias programada com sucesso, você pode visualiza-lás em Actions -> Férias -> Visualizar Férias"
      },

      error: function(error) {
        console.log(error.responseJSON)
          msg.textContent = error.responseJSON.message
      }
  });
}

