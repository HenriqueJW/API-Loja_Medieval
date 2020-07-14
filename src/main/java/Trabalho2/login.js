function login(){

    var nick = $('#nickname').val()
    var senha = $('#senha').val()
    var user = {
        "nickname": nick,
        "senha": senha
    }
    
    //BEN SHAPIRO
    //BEN SHAPIRO

    $.ajax({
        url: "http://localhost:8080/login", type: "POST", data:
            JSON.stringify(user, null, 2),contentType: "application/json"  
        }).done
            (function (XMLHttpRequest, status, req) { 
                debugger
                window.localStorage.setItem("Authorization", req.getResponseHeader("authorization"))
                $.ajaxSetup({
                    headers:{
                       'Authorization': window.localStorage.getItem("Authorization")
                    }
                 });
            $.get("http://localhost:8080/usuarios/nick/"+user.nickname, function (resp, status) {
                    debugger
                    if(status == 'success'){
                        window.localStorage.setItem("usuarioAtual", resp.idUsuario)        
                        mainPage()
                    }
                })
            });
}


function mainPage(){
    window.location.href = 'main.html'
}