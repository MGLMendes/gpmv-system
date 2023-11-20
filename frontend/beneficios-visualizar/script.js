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

var nomeFunc = document.getElementById("h1-beneficios")
nomeFunc.textContent = "Benefícios, " + nome;

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


function visualizar() {
  $.ajax({
      url: "http://localhost:8888/beneficios/"+matricula,
      type: "get",

      success: function(response) {
          preencherTabela(response);
      },

      error: function(error) {
          alert("Não foi possível consultar os dados, provavelmente servidor não está de pé")
      }
  });
}


function preencherTabela(beneficios) {
  console.log(beneficios)
  $("#tabela tbody tr").remove();
  $.each(beneficios, function(i, beneficio) {

    var linkAcao = $("<a href='#'> <i class='bx bx-edit-alt' id='icon-att' ></i>")
      .on('click', event => {
          event.preventDefault();
          pegarPerfil(beneficio.matricula)
          atualizar(beneficio)

          setTimeout(() => {
            window.location.href = '../atualizar-func/atualizar.html'   
          }, 1000);

      })

      var linha = $("<tr>");
      linha.append(
          $("<td>").text(beneficio.beneficio),
          $("<td>").text(beneficio.preco),
          $("<td>").text(beneficio.dataContratacao)
      );
      linha.appendTo("#tabela")
  });
}