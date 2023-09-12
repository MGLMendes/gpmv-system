const form = document.getElementById("form");
const username = document.getElementById("username");
const mae = document.getElementById("mae");
const pai = document.getElementById("pai");
const email = document.getElementById("email");
const cpf = document.getElementById("cpf");
const rg = document.getElementById("rg");
const data = document.getElementById("data");
const cargo = document.getElementById("cargo");

form.addEventListener("submit", (e) => {
  e.preventDefault();

  checkInputs();
});

function checkInputs() {
  const usernameValue = username.value;
  const maeValue = mae.value;
  const paiValue = pai.value;
  const emailValue = email.value;
  const cpfValue = cpf.value;
  const rgValue = rg.value;
  const dataValue = data.value;
  const cargoValue = cargo.value;

  if (usernameValue === "") {
    setErrorFor(username, "O nome completo é obrigatório.");
  } else {
    setSuccessFor(username);
  }

  if (maeValue === "") {
    setErrorFor(mae, "O nome completo é obrigatório.");
  } else {
    setSuccessFor(mae);
  }

  if (paiValue === "") {
    setErrorFor(pai, "O nome completo é obrigatório.");
  } else {
    setSuccessFor(pai);
  }

  if (emailValue === "") {
    setErrorFor(email, "O email é obrigatório.");
  } else if (!checkEmail(emailValue)) {
    setErrorFor(email, "Por favor, insira um email válido.");
  } else {
    setSuccessFor(email);
  }

  if (cpfValue === "") {
    setErrorFor(cpf, "O CPF é obrigatório.");
  } else if (!checkCpf(cpfValue)) {
    setErrorFor(cpf, "Por favor, insira um CPF válido.");
  } else {
    setSuccessFor(cpf);
  }

  if (rgValue === "") {
    setErrorFor(rg, "O RG é obrigatório.");
  } else if (!checkRg(rgValue)) {
    setErrorFor(rg, "Por favor, insira um RG válido.");
  } else {
    setSuccessFor(rg);
  }

  if (dataValue === "") {
    setErrorFor(data, "A data de nasicimento é obrigatória.");
  } else if (!checkCpf(dataValue)) {
    setErrorFor(data, "Por favor, insira uma Data válida.");
  } else {
    setSuccessFor(data);
  }

  if (cargoValue === "") {
    setErrorFor(cargo, "O seu cargo é obrigatório.");
  } else {
    setSuccessFor(cargo);
  }

  const formControls = form.querySelectorAll(".form-control");

  const formIsValid = [...formControls].every((formControl) => {
    return formControl.className === "form-control success";
  });

  if (formIsValid) {
    console.log("O formulário está 100% válido!");
  }
}

function setErrorFor(input, message) {
  const formControl = input.parentElement;
  const small = formControl.querySelector("small");

  // Adiciona a mensagem de erro
  small.innerText = message;

  // Adiciona a classe de erro
  formControl.className = "form-control error";
}

function setSuccessFor(input) {
  const formControl = input.parentElement;

  // Adicionar a classe de sucesso
  formControl.className = "form-control success";
}

function checkEmail(email) {
  return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(
    email
  );
}