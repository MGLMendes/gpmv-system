
let contratado = {
    "nome": localStorage.getItem("nome"),
    "nomeMae": localStorage.getItem("nomeMae"),
    "nomePai": localStorage.getItem("nomePai"),
    "email": localStorage.getItem("email"),
    "cargo": localStorage.getItem("cargo"),
    "matricula": localStorage.getItem("matricula")
}

function atualizar(contratadoInput) {
    localStorage.setItem("nome", contratadoInput.nome)
    localStorage.setItem("nomeMae", contratadoInput.nomeMae)
    localStorage.setItem("nomePai", contratadoInput.nomePai)
    localStorage.setItem("email", contratadoInput.email)
    localStorage.setItem("cargo", contratadoInput.cargo)
    localStorage.setItem("matricula", contratadoInput.matricula)
}

function pegar() {;
    return contratado
}