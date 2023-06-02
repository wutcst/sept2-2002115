var baseurl="http://localhost:8080";
$(document).ready(function () {
    var text_aera=$("#text-aera");
    var text='';
    $('#go').bind('click',go);
    text='<p>'+'Welcome to the World of Zuul!' +'</p>'
        +'<p>'+'World of Zuul is a new, incredibly boring adventure game.' +'</p>'
        +'<p>'+'Type \'help\' if you need help.' +'</p>';
    text_aera.append(text);
    function clear_text_aera() {
        text_aera.innerHTML="";
    }
    function go() {
        var direction=$("#direction").val();
        if (isNull(direction)){
            var message='<p>'+'Go Where?'+'</p>';
            text_aera.append(message);
            $('#direction').text='';
        }else{
            $.ajax({
                url:baseurl+"/GO",
                data:{direction:direction},
                type:"post",
                dataType:"json",
                async:false,
                success:function (result) {
                    if (result.status==1){
                        text_aera.empty();
                        text='<p>'+result.discription+'</p>';
                        text_aera.append(text);
                    }else{
                        var warn='<p>'+result.discription+'</p>';
                        text_aera.append(warn);
                    }

                },
                error:function (e) {

                }
            });
        }
    }
    function isNull( str ){
        if ( str == "" ) return true;
        var regu = "^[ ]+$";
        var re = new RegExp(regu);
        return re.test(str);
    }
});
