$(document).ready(function () {

    getEncomendas()

})

function relatorio1() {
    limparTabela()
    $.get("http://localhost:8080/consultas/produtosMaisVendidos", function (resp, status) {

        if (status == 'success') {
            montarTabela(resp, 1)
        }

    })
}

function relatorio2() {
    limparTabela()
    $.get("http://localhost:8080/consultas/usuariosQueMaisCompraram", function (resp, status) {

        if (status == 'success') {
            montarTabela(resp, 2)
        }

    })
}

function relatorio3() {
    limparTabela()
    $.get("http://localhost:8080/consultas/usuariosQueMaisComentaram", function (resp, status) {

        if (status == 'success') {
            montarTabela(resp, 3)
        }

    })
}

function relatorio4() {
    limparTabela()
    $.get("http://localhost:8080/consultas/produtosMaisVendidosDeCadaCategoria", function (resp, status) {

        if (status == 'success') {
            montarTabela(resp, 4)
        }

    })
}

function relatorio5() {
    limparTabela()
    $.get("http://localhost:8080/consultas/usuariosQueCompraramMaisQue10", function (resp, status) {

        if (status == 'success') {
            montarTabela(resp, 5)
        }

    })
}

function limparTabela() {
    $('#tabela').empty()
}

function montarTabela(dados, idRelatorio) {
    switch (idRelatorio) {
        case (1):
            $('#tabela').append('<tr id="cabeca"></tr>')
            $('#cabeca').append('<th class="centro">Produto</th>')
            $('#cabeca').append('<th class="centro">Quantidade</th>')
            var tabela = $('#tabela')
            var linhas = $('<tr id="linhas"></tr>')
            for (var i = 0; i < dados.length; i++) {
                linhas = $('<tr id="linhas"></tr>')
                linhas.append('<td>' + dados[i][0] + '</td>')
                linhas.append('<td class="centro">' + dados[i][1] + '</td>')

                tabela.append(linhas)
            }
            break
        case (2):
            $('#tabela').append('<tr id="cabeca"></tr>')
            $('#cabeca').append('<th class="centro">Usuario</th>')
            $('#cabeca').append('<th class="centro">Quantidade</th>')
            var tabela = $('#tabela')
            var linhas = $('<tr id="linhas"></tr>')
            for (var i = 0; i < dados.length; i++) {
                linhas = $('<tr id="linhas"></tr>')
                linhas.append('<td>' + dados[i][0] + '</td>')
                linhas.append('<td class="centro">' + dados[i][1] + '</td>')

                tabela.append(linhas)
            }
            break
        case (3):
            $('#tabela').append('<tr id="cabeca"></tr>')
            $('#cabeca').append('<th class="centro">Usuario</th>')
            $('#cabeca').append('<th class="centro">Quantidade</th>')
            var tabela = $('#tabela')
            var linhas = $('<tr id="linhas"></tr>')
            for(var i = 0; i< dados.length; i++){
                linhas = $('<tr id="linhas"></tr>')
                linhas.append('<td>'+ dados[i][0]+'</td>')
                linhas.append('<td class="centro">'+ dados[i][1]+'</td>')

                tabela.append(linhas)
            }
            break
        case (4):
            $('#tabela').append('<tr id="cabeca"></tr>')
            $('#cabeca').append('<th class="centro">Categoria</th>')
            $('#cabeca').append('<th class="centro">Produto</th>')
            $('#cabeca').append('<th class="centro">Quantidade</th>')
            var tabela = $('#tabela')
            var linhas = $('<tr id="linhas"></tr>')
            for(var i = 0; i< dados.length; i++){
                linhas = $('<tr id="linhas"></tr>')
                linhas.append('<td>'+ dados[i][0]+'</td>')
                linhas.append('<td>'+ dados[i][1]+'</td>')
                linhas.append('<td class="centro">'+ dados[i][2]+'</td>')

                tabela.append(linhas)
            }
            break
        case (5):
            $('#tabela').append('<tr id="cabeca"></tr>')
            $('#cabeca').append('<th class="centro">Usuario</th>')
            $('#cabeca').append('<th class="centro">Quantidade de Pedidos feitos</th>')
            var tabela = $('#tabela')
            var linhas = $('<tr id="linhas"></tr>')
            for(var i = 0; i< dados.length; i++){
                linhas = $('<tr id="linhas"></tr>')
                linhas.append('<td>'+ dados[i][0]+'</td>')
                linhas.append('<td>'+ dados[i][1]+'</td>')

                tabela.append(linhas)
            }
            break

    }


}

function getEncomendas(){
    if(localStorage.getItem("usuarioAtual") == 7){
        $('#listaEncomendas')[0].innerHTML = "Ver todas as Encomendas"
    }
}