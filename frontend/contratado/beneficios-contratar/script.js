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
console.log(matriculaFunc)

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

contratado = pegar()

function contratarBeneficio() {

  console.log(op1.checked)

  if(op1.checked) {
    bAlimentacao = bAlimentacao.textContent
    precoAlimentacao = precoAlimentacao.textContent
  } else {
    bAlimentacao = null
    precoAlimentacao = null
  }

  if(op2.checked) {
    bRefeicao = bRefeicao.textContent
    precoRefeicao = precoRefeicao.textContent
  } else {
    bRefeicao = null
    precoRefeicao = null
  }

  if(op3.checked) {
    bVt = bVt.textContent
    precoVt = precoVt.textContent
  } else {
    bVt = null
    precoVt = null
  }

  if(op4.checked) {
    bGp = bGp.textContent
    precoGp = precoGp.textContent
  } else {
    bGp = null
    precoGp = null
  }
  
  const beneficios = JSON.stringify([
    {
      "beneficio":bAlimentacao,
      "preco":precoAlimentacao
    },
    {
      "beneficio":bRefeicao,
      "preco":precoRefeicao
    },
    {
      "beneficio":bVt,
      "preco":precoVt
    },
    {
      "beneficio":bGp,
      "preco":precoGp
    }
  ])

  $.ajax({
    url: "http://localhost:8888/beneficios/"+matriculaFunc+"/contratar",
    type: "post",
    data: beneficios,
    contentType: "application/json",

    success: function(response) {
        alert("Contratação de benefícios efetivada!")
        setTimeout(() => {
          setContratadoNome(contratado.nome)
          setContratadoMatricula(matriculaFunc)
          window.location.href = '../beneficios-home/index.html'   
        }, 1000);
    },

    error: function(error) {
        alert("Não foi possível consultar os dados, provavelmente servidor não está de pé")
    }
});


  console.log(beneficios)

}
