
let contratado = {
    "nome": localStorage.getItem("nome"),
    "nomeMae": localStorage.getItem("nomeMae"),
    "nomePai": localStorage.getItem("nomePai"),
    "email": localStorage.getItem("email"),
    "cargo": localStorage.getItem("cargo")
}

function atualizar(contratadoInput) {
    localStorage.setItem("nome", contratadoInput.nome)
    localStorage.setItem("nomeMae", contratadoInput.nomeMae)
    localStorage.setItem("nomePai", contratadoInput.nomePai)
    localStorage.setItem("email", contratadoInput.email)
    localStorage.setItem("cargo", contratadoInput.cargo)
}

function pegar() {;
    return contratado
}