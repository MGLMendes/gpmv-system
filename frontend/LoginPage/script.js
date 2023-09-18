
const emailInput = document.getElementById("email");
const senhaInput = document.getElementById("senha");

function changeClassName() {

    const classRedEmail = document.querySelector('.red-email');
    const classRedSenha = document.querySelector('.red-senha');
    
    if (classRedEmail) {
        classRedEmail.classList.remove('red-email');
        classRedEmail.classList.add('textfield-email');
    } else if (classRedSenha)  {
        classRedSenha.classList.remove('red-senha');
        classRedSenha.classList.add('textfield-senha');
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
          console.log(response)
        },

        error: function(response) {
            const causa = response.responseJSON.causa;
            

            console.log(response.responseJSON.causa);

            if (causa === "Email inválido") {
                const elemento = document.querySelector('.textfield-email');
                elemento.classList.remove('textfield-email');
                elemento.classList.add('red-email');
                
                console.log(elemento)
            }

            if (causa === "Senha inválida") {
                const elemento = document.querySelector('.textfield-senha');
                elemento.classList.remove('textfield-senha');
                elemento.classList.add('red-senha');
                console.log(elemento)
            }
        }
      })
}


$("#bnt-login").click(login);
$("#email").click(changeClassName)
$("#senha").click(changeClassName)
