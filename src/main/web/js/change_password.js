var baseurl="http://localhost:8080"
$(function () {
    $("#change_password").bind("click",change_password);
    $("#return").click(function () {
        window.location.href=baseurl+"/login";
    });
})
function change_password(){
    var username=$('#username').val();
    var password=$('#password').val();
    var password2=$('#password_check').val();
    if (username==''||password==''||password2=='')
    {
        alert('输入不能为空!');
        return false;
    }
    if(password!=password2)
    {
        alert('两次密码不同!');
        return false;
    }
    $.ajax({
        url:baseurl+"/change_passsword_do",
        data:{username:username,password:password},
        type:"post",
        dataType:"json",
        success:function (result){
            if (result)
            {
                alert(result.message);
                if(result.status==200)
                {
                    setTimeout(function () {window.location.href=baseurl+"/login";
                    },1000);
                }
                else
                {
                    $('#username').val('');
                    $('#password').val('');
                    $('#password_check').val('');
                }
            }
            else
            {
                alert(result.message);
            }
        },
        error:function (e){
            alert('请看控制台是否报错');
        }
    });
}