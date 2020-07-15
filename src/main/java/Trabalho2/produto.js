$(document).ready(function() {
$.ajaxSetup({
        headers:{
           'Authorization': window.localStorage.getItem("Authorization")
        }
     });
    getCategorias()

    carregarProduto(window.location.hash.substring(1))


});

function carregarProduto(idProduto){

    $.get("http://localhost:8080/produtos/"+idProduto, function (resp, status) {

        if(status == 'success'){
            var produto  = resp
            
            showProduto(produto) 
        }
            
    })


}


function showProduto(produto){

    var foto = $('#fotoProduto')
    var divProduto = $('#divProduto')
    var divPreco = $('#divPreco')
    
    var fotoProduto = $('<img class="active" src="'+produto.fotoProduto+'" alt=""></img>')
    
    foto.append(fotoProduto)

    var nomeCategoria = $('<span>'+produto.categoria.nome+'</span>')
    var nomeProduto = $('<h1>'+produto.nome+'</h1>')
    var descricaoProduto = $('<p>'+produto.descricao+'</p>')


    divProduto.append(nomeCategoria)
    divProduto.append(nomeProduto)
    divProduto.append(descricaoProduto)

    var precoProduto = $('<span>R$'+produto.preco+'</span>')
    var addCarrinho = $('<a href="#" class="cart-btn">Add to cart</a>')
   
    divPreco.append(precoProduto)
    divPreco.append(addCarrinho)

}

function getCategorias(){
    $.get("http://localhost:8080/categorias", function (resp, status) {

        if(status == 'success'){
            var categorias  = resp
            menuCategorias(categorias) 
        }
            
    })
}

function menuCategorias(categorias){
    
    var categoria = $('#Categorias')
    var ul = $('<ul class="w3-dropdown-content">')
    for(var i = 0; i < categorias.length ; i++){
        var li = $(' <li class="w3-bar-item w3-button">')
        var a = $('<a  href="categoria.html#'+categorias[i].idCategoria+'" style="color: black">'+categorias[i].nome+'</a>')
        li.append(a)                 
        ul.append(li)
    }
    
    categoria.append(ul)


}