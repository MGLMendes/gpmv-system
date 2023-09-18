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
            $("<td>").text(contratado.dataAdmissao)
        );
        linha.appendTo("#tabela")
    });
}


$("#btn-consultar").click(consultar);