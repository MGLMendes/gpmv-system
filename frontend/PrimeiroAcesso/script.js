
const emailInput = document.getElementById("email");
const senhaInput = document.getElementById("senha");
const senhaValhaInput = document.getElementById("senhaVelha");
const senhaNovaInput = document.getElementById("senhaNova");
const confirmaSenhaNovaInput = document.getElementById("confirmaSenhaNova");

const classEmail = document.querySelector('.textfield-email');
const classSenha = document.querySelector('.textfield-senha');
const classNovaSenha1= document.querySelector('.textfield-nova-senha1');
const classNovaSenha2= document.querySelector('.textfield-nova-senha2');

const emailInvalido =  document.querySelector(".email-invalido")
const senhaInvalida =  document.querySelector(".senha-invalida")

const senhaInvalida1 =  document.querySelector(".senha-invalida1")
const senhaInvalida2 =  document.querySelector(".senha-invalida2")


function changeClassName() {
    const classRedEmail = document.querySelector('.red-email');
    const classRedSenha = document.querySelector('.red-senha');
    
    if (classRedEmail) {
        classRedEmail.classList.remove('red-email');
        classRedEmail.classList.add('textfield-email');
        emailInvalido.style.display = "none"
    } else if (classRedSenha)  {
        classRedSenha.classList.remove('red-senha');
        classRedSenha.classList.add('textfield-senha');
        senhaInvalida.style.display = "none"
    }
}


function login() {
    const email = emailInput.value
    const senha = senhaInput.value

    const usuario = JSON.stringify({
        "email": email,
        "senha": senha
    });

    $.ajax({
        url:"http://localhost:8888/usuarios/login",
        type:"post",
        data: usuario,
        contentType: "application/json",
    
        success: function(response) {
            window.location.href = '../HomePage/index.html'            
        },

        error: function(response) {
            validaResponse(response.responseJSON.causa);
        }
      })
}

function trocaSenha() {
    const email = emailInput.value
    const senhaVelha = senhaValhaInput.value
    const senhaNova = senhaNovaInput.value
    const confirmaSenhaNova = confirmaSenhaNovaInput.value

    const usuario = JSON.stringify({
        "email": email,
        "senhaVelha": senhaVelha,
        "senhaNova":senhaNova,
        "confirmaNovaSenha":confirmaSenhaNova
    });

    console.log(usuario)

    $.ajax({
        url:"http://localhost:8888/usuarios/primeiro-acesso",
        type:"post",
        data: usuario,
        contentType: "application/json",
    
        success: function(response) {
            window.location.href = '../HomePage/index.html'
            
        },
        error: function(response) {
            validaResponse(response.responseJSON.causa);
        }
      })

}

function validaResponse(causa) {
    if (causa === "Email inválido") {
        classEmail.classList.remove('textfield-email');
        classEmail.classList.add('red-email');
        emailInvalido.style.display = "inline"
    }
    if (causa === "Senha inválida") {
        classSenha.classList.remove('textfield-senha');
        classSenha.classList.add('red-senha');
        senhaInvalida.style.display = "inline"
    } else if (causa === "Não use a mesma senha"){
        classNovaSenha1.classList.remove('textfield-nova-senha1');
        classNovaSenha2.classList.remove('textfield-nova-senha2');
        classNovaSenha1.classList.add('red-senha');
        classNovaSenha2.classList.add('red-senha');
        senhaInvalida1.style.display = "inline"
        senhaInvalida2.style.display = "inline"

        $(".senha-invalida1").text(`${causa}`)
        $(".senha-invalida2").text(`${causa}`)
    
        
    } else {
        classNovaSenha1.classList.remove('textfield-nova-senha1');
        classNovaSenha2.classList.remove('textfield-nova-senha2');
        classNovaSenha1.classList.add('red-senha');
        classNovaSenha2.classList.add('red-senha');
        senhaInvalida1.style.display = "inline"
        senhaInvalida2.style.display = "inline"
    }
}


$("#bnt-nova-senha").click(trocaSenha);
$("#email").click(changeClassName);
$("#senhaVelha").click(changeClassName);
$("#senhaNova").click(changeClassName);
$("#confirmaSenhaNova").click(changeClassName);
