$(document).ready(function () {
    $.ajaxSetup({
        headers: {
            'Authorization': window.localStorage.getItem("Authorization")
        }
    });
    if(window.location.hash.substring(1) != ""){
        carregarEncomenda(window.location.hash.substring(1))
    }

    getEncomendas()

})


function enviarEncomenda(){

    if(window.location.hash.substring(1) != ""){
        encomenda = {
            "nomeProduto": $('#NomeEncomenda')[0].value,
            "descricao": $('#DescricaoEncomenda')[0].value,
            "fotoProduto": $('#fotoEncomenda')[0].value
        }
        $.ajax({
            url: "http://localhost:8080/encomendas/"+ window.location.hash.substring(1), type: "PUT", data:
                JSON.stringify(encomenda)
            , success: function (result) {
                alert("encomenda atualizada com sucesso!")
            }
            , contentType: "application/json"
        });
    }else{
        var nome = $('#NomeEncomenda')[0].value
        var descricao = $('#DescricaoEncomenda')[0].value
        var foto = $('#fotoEncomenda')[0].value
    
        var encomenda = {}
    
        $.get("http://localhost:8080/usuarios/"+localStorage.getItem("usuarioAtual"), function (resp, status) {
    
            if(status == 'success'){
                encomenda = {
                    "nomeProduto": $('#NomeEncomenda')[0].value,
                    "descricao": $('#DescricaoEncomenda')[0].value,
                    "fotoProduto": $('#fotoEncomenda')[0].value,
                    "usuario": resp
                }
                enviarServidor(encomenda)
            }
        })
    }

}

function enviarServidor(encomenda){
    $.ajax({
        url: "http://localhost:8080/encomendas", type: "POST", data:
            JSON.stringify(encomenda), success: function (result) {
                alert("Sua encomenda foi feita com sucesso!")
            }, contentType: "application/json"
    });
}


function carregarEncomenda(idEncomenda){

    $.get("http://localhost:8080/encomendas/"+idEncomenda, function (resp, status) {
    
        if(status == 'success'){
            $('#NomeEncomenda').val(resp.nomeProduto) 
            $('#DescricaoEncomenda').val(resp.descricao)
        }
    })

}


function getEncomendas(){
    if(localStorage.getItem("usuarioAtual") == 7){
        $('#listaEncomendas')[0].innerHTML = "Ver todas as Encomendas"
    }
}