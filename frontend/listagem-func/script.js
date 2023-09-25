function consultar() {
    $.ajax({
        url: "http://localhost:8888/contratados/resumo",
        type: "get",

        success: function(response) {
            console.log("Funcionou")
            preencherTabela(response);
        },

        error: function(error) {
            alert("Não foi possível consultar os dados, provavelmente servidor não está de pé")
        }
    });
}


function preencherTabela(contratados) {
    console.log($("#tabela tbody tr"))
    console.log(contratados)
    $("#tabela tbody tr").remove();
    $.each(contratados, function(i, contratado) {
        var linha = $("<tr>");
        linha.append(
            $("<td>").text(contratado.matricula),
            $("<td>").text(contratado.nome),
            $("<td>").text(contratado.email),
            $("<td>").text(contratado.cpf),
            $("<td>").text(contratado.cargo),
            $("<td>").text(contratado.dataAdmissao)
        );
        linha.appendTo("#tabela")
    });
}


$("#btn-consultar").click(consultar);

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


