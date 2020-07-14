$(document).ready(function () {

    pegarEncomendas()
    getEncomendas()

})


function pegarEncomendas() {

    if(localStorage.getItem("usuarioAtual") == 7){
        $.get("http://localhost:8080/encomendas", function (resp, status) {

            if (status == 'success') {
                listarEncomendas(resp)
            } else {
                nenhumaEncomenda()
            }

        })

    }else{
        $.get("http://localhost:8080/encomendas/usuario/" + localStorage.getItem("usuarioAtual"), function (resp, status) {

            if (status == 'success') {
                listarEncomendas(resp)
            } else {
                nenhumaEncomenda()
            }
    
        })
    }

}

function getEncomendas(){
    if(localStorage.getItem("usuarioAtual") == 7){
        $('#listaEncomendas')[0].innerText = "Ver todas as Encomendas"
        $('#titulo2')[0].innerText = "Todas as Encomendas"
    }
}

function nenhumaEncomenda() {
    var lista = $('#lista')
    var h1 = $('<h1>Você não possui nenhuma encomenda!')
    var h2 = $('<h1>Faça uma agora mesmo!')
    var a = $('<h1>Faça uma agora mesmo!')

}


function listarEncomendas(dados) {
    debugger
    var lista = $('#lista')

    for (var i = 0; i < dados.length; i++) {

        var div = $('<div class="prod-info-main prod-wrap clearfix">')
        var row = $('<div class="row">')
        lista.append(div)
        div.append(row)

        var div2 = $('<div class="col-md-5 col-sm-12 col-xs-12">')
        var div3 = $('<div class="product-image">')
        var img = $('<img src="' + dados[i].fotoProduto + '" class="img-responsive">')

        row.append(div2)
        div2.append(div3)
        div3.append(img)

        var divText = $('<div class="col-md-7 col-sm-12 col-xs-12">')
        var divNome = $(' <div class="product-deatil">')
        var h2 = $(' <h2 class="name" id="nomeEncomenda">')
        var aTitulo = $('<a href="#">' + dados[i].nomeProduto + '</a>')

        row.append(divText)
        divText.append(divNome)
        divNome.append(h2)
        h2.append(aTitulo)


        var divDescricao = $('<div class="description" id="descricaoEncomenda">')
        var h4Desc = $('<h4>' + dados[i].descricao + '</h4>')

        divText.append(divDescricao)
        divDescricao.append(h4Desc)

        var divBotao = $('<div class="product-info smart-form">')
        var divRow = $('<div class="row">')
        var div4 = $('<div class="col-md-12">')
        var aBtnExcluir = $('<a class="btn btn-danger" onclick="excluirEncomenda(' + dados[i].idEncomenda + ')">Excluir encomenda</a>')
        var aBtnEditar = $('<a href="encomenda.html#'+dados[i].idEncomenda+'" class="btn btn-info">Ver / Editar Encomenda</a>')


        divText.append(divBotao)
        divBotao.append(divRow)
        divRow.append(div4)
        div4.append(aBtnExcluir)
        div4.append(aBtnEditar)


        lista.append(div)

    }

}

function excluirEncomenda(idEncomenda) {
    $.ajax({
        url: "http://localhost:8080/encomendas/" + idEncomenda, type: "DELETE"
        , success: function (result) {
            location.reload(true)
        }
        , contentType: "application/json"
    });

}

