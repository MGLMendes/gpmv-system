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

var msg = document.getElementById("mensagem")

function programarAfastamento() {
  const inicio = document.getElementById("date-inicio");
  const fim = document.getElementById("date-fim");
  const motivo = document.getElementById("id-motivo")
  const descricao = document.getElementById("id-descricao")

  const dataInicio = inicio.value.split('-').reverse().join('/');
  const dataFim = fim.value.split('-').reverse().join('/');

  

  const afastamento = JSON.stringify({
    "motivo":motivo.value,
    "descricao":descricao.value,
    "inicio":dataInicio,
    "fim":dataFim
  })

  console.log(afastamento)

    $.ajax({
      url: "http://localhost:8888/afastamento/"+matricula,
      type: "post",
      data: afastamento,
      contentType: "application/json",

      success: function(response) {
        msg.textContent =  "Você programou seu atestado com sucesso!"
        window.href.location = "../afastamento/index.html"
      },

      error: function(error) {
        console.log(error.responseJSON)
          msg.textContent = error.responseJSON.message
      }
  });
}

