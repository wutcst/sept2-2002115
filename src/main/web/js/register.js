var baseurl="http://localhost:8080"
$(function () {
    $("#register").bind("click",register);
    $("#return").click(function () {
        window.location.href=baseurl+"/login";
    });
    function register(){
        var pattern=/^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/
        var username=$('#username').val();
        var password=$('#password').val();
        var email=$('#email').val();
        var date=$('#date').val();
        if (username==''||password=='')
        {
            alert('用户名密码不能为空!');
            return false;
        }
        if(!pattern.test(email))
        {
            alert('输入正确的邮箱!');
            return false;
        }
        $.ajax({
            url:baseurl+"/registerdo",
            data:{username:username,password:password,email:email,birthday:date},
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
                        $('#email').val('');
                        $('#date').val('');
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
})
