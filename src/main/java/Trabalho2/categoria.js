$(document).ready(function () {
    $.ajaxSetup({
        headers: {
            'Authorization': window.localStorage.getItem("Authorization")
        }
    });
    getCategorias();
    getEncomendas();
    getProdutos(window.location.hash.substring(1));

});

function getCategorias() {
    $.get("http://localhost:8080/categorias", function (resp, status) {

        if (status == 'success') {
            var categorias = resp;
            menuCategorias(categorias);
        }

    });
}



function menuCategorias(categorias) {

    var categoria = $('#Categorias');
    var ul = $('<ul class="w3-dropdown-content" style="z-index: 5">');
    for (var i = 0; i < categorias.length; i++) {
        if (categorias[i].idCategoria == window.location.hash.substring(1)) {
            var li = $(' <li class="w3-bar-item w3-button" style="background-color: black">');
            var a = $('<a  href="categoria.html#' + categorias[i].idCategoria + '" style="color: white" id="cat' + categorias[i].idCategoria + '">' + categorias[i].nome + '</a>');
            li.append(a);
            ul.append(li);
            var titulo = $('#titulo');
            titulo.append(' <h2>' + categorias[i].nome + '</h2>');
        } else {
            var li = $(' <li class="w3-bar-item w3-button">');
            var a = $('<a  href="categoria.html#' + categorias[i].idCategoria + '" style="color: black" id="cat' + categorias[i].idCategoria + '">' + categorias[i].nome + '</a>');
            a.click(function () {
                window.location.href = $(this).attr('href');
                location.reload(true)
            });
            li.append(a);
            ul.append(li);
        }

    }

    categoria.append(ul);

}

function getProdutos(idCategoria) {
    $.get("http://localhost:8080/produtos/categorias/" + idCategoria, function (resp, status) {

        if (status == 'success') {
            var produtos = resp;
            gridProdutos(produtos);
        }

    })

}

function gridProdutos(produtos) {

    var grid = $('#GridProdutos');

    for (var i = 0; i < produtos.length; i++) {
        var div1 = $('<div class="col-md-3 col-sm-6">');
        var div2 = $('<div class="product-grid">');
        var div3 = $('<div class="product-image" style="width: 250px;height: 250px;">');
        var a = $('<a href="#">');
        var img1 = $('<img class="pic-1" src="' + produtos[i].fotoProduto + '" style="width: 250px;height: 250px;">');
        var img2 = $('<img class="pic-2" src="' + produtos[i].fotoProduto + '" style="width: 250px;height: 250px;">');
        var h3 = $('<h3 class="title"><a href="produto.html#' + produtos[i].idProduto + '">' + produtos[i].nome + '</a></h3>');
        var div4 = $('<div class="product-content">');
        var h3 = $('<h3 class="title"><a href="produto.html#' + produtos[i].idProduto + '">' + produtos[i].nome + '</a></h3>');
        var div5 = $('<div class="price">R$' + produtos[i].preco + '</div>');

        div1.append(div2);
        div2.append(div3);
        div3.append(a);
        a.append(img1);
        a.append(img2);
        div2.append(div4);
        div4.append(h3);
        div4.append(div5);

        grid.append(div1);
    }


}

function getEncomendas() {
    if (localStorage.getItem("usuarioAtual") == 7) {
        $('#listaEncomendas')[0].innerHTML = "Ver todas as Encomendas"
    }
}

