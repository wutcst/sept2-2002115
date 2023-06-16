var baseUrl="http://localhost:8080"
$(function () {
    $(document).on("click",'#btn',login)
    // $("btn").bind("click",login);
})
//登陆函数
function login() {
    var username=$('#username').val();
    var password=$('#password').val();
    $.ajax({

        url:baseUrl+"/logindo",
        data: {username:username,password: password},
        type:"post",
        dataType:"json",
        success:function (result) {
            console.log(result);
            if (result){
                alert(result.message);
                if (result.status==200){
                    setTimeout(function () {
                        window.location.href=baseUrl+"/Game";
                    },1000)
                }else{
                    $('#password').val('');
                    $('#username').val('');
                }
            }else{
                alert(result.message);
            }

        },
        error:function (e) {
            console.log(e,e.message);
            alert("请查看控制台是否报错");
        }
    });
}