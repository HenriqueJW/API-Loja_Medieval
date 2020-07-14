$(document).ready(function () {
$.ajaxSetup({
        headers:{
           'Authorization': window.localStorage.getItem("Authorization")
        }
     });
     
    getCategorias();
    getRelatorios();
    getProdutos();
    getEncomendas()


})

function getCategorias(){

    
    $.get("http://localhost:8080/categorias", function (resp, status){
        

        
        if(status == 'success'){
            var categorias  = resp
            menuCategorias(categorias) 
        }
            
    })
}

function getRelatorios(){

    if(localStorage.getItem("usuarioAtual") == 7){
        var li = $('<li class="nav-item">')
        li.append($('<a class="nav-link" href="relatorio.html" style="color: black;">Relatórios</a>'))
        $('#menus').append(li)
    }

}


function getEncomendas(){
    if(localStorage.getItem("usuarioAtual") == 7){
        $('#listaEncomendas')[0].innerHTML = "Ver todas as Encomendas"
    }
}

function menuCategorias(categorias){
    
    var categoria = $('#Categorias')
    var ul = $('<ul class="w3-dropdown-content" style="z-index: 5">')
    for(var i = 0; i < categorias.length ; i++){
        var li = $(' <li class="w3-bar-item w3-button">')
        var a = $('<a  href="categoria.html#'+categorias[i].idCategoria+'" style="color: black">'+categorias[i].nome+'</a>')
        li.append(a)                 
        ul.append(li)
    }
    categoria.append(ul)
}

function getProdutos(){
    $.get("http://localhost:8080/produtos", function (resp, status) {

        if(status == 'success'){
            var produtos  = resp
            gridProdutos(produtos) 
        }
    })
}

function gridProdutos(produtos){

    var grid = $('#GridProdutos')
    
    for(var i = 0; i < produtos.length; i++){
        var div1 = $('<div class="col-md-3 col-sm-6">')
        var div2 = $('<div class="product-grid">')
        var div3 = $('<div class="product-image" style="width: 250px;height: 250px;">')
        var a = $('<a href="#">')
        var img1 = $('<img class="pic-1" src="'+produtos[i].fotoProduto+'" style="width: 250px;height: 250px;">')
        var img2 = $('<img class="pic-2" src="'+produtos[i].fotoProduto+'" style="width: 250px;height: 250px;">')
        var div4 = $('<div class="product-content">')
        var h3 = $('<h3 class="title"><a href="produto.html#'+produtos[i].idProduto+'">'+produtos[i].nome+'</a></h3>')
        var div5 = $('<div class="price">R$'+produtos[i].preco+'</div>')

        div1.append(div2)
        div2.append(div3)
        div3.append(a)
        a.append(img1)
        a.append(img2)
        div2.append(div4)
        div4.append(h3)
        div4.append(div5)

        grid.append(div1)
    }
}

