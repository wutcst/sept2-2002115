var baseurl="http://localhost:8080";
$(document).ready(function () {
    var text_aera=$("#text-aera");
    var text='';
    //设置小方块每次移动的距离
    let distance = 10;
    //获取小方块suqare元素
    const square = document.getElementById('player');
    //给document对象添加键盘事件监听以及触发回调函数
    document.addEventListener('keydown', movesquare);
    $('#go').bind('click',go);
    $('#help').bind('click',help);
    $('#quit').bind('click',quit);
    text='<p>'+'Welcome to the World of Zuul!' +'</p>'
        +'<p>'+'World of Zuul is a new, incredibly boring adventure game.' +'</p>'
        +'<p>'+'Type \'help\' if you need help.' +'</p>'
        +'<p>&nbsp</p>';
    $.ajax({
        url:baseurl+"/GetCurrentRoom",
        type:"get",
        dataType:"json",
        async:false,
        success:function (result) {
            text+='<p>'+result.discription+'</p>';
        },
        error:function (e) {
            alert("初始化失败，请检查控制台！");
            console.log(e);
        }
    });
    text_aera.append(text);
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
                    if (result.status===1){
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
        if ( str === "" ) return true;
        var regu = "^[ ]+$";
        var re = new RegExp(regu);
        return re.test(str);
    }
    function help() {
        alert("You are lost. You are alone. You wander\n" +
              "around at the university.\n\n"+
              "You can play this game by using those buttons:\n"+
              "\"移动\">>input right direction and move\n"+
              "\"退出\">>exit this game\n"+
              "\"帮助\">>you will see this window again~\n"
        );
    }
    function quit(){
        $.ajax({
            url:baseurl+"/Test",
            type:"get",
            dataType:"json",
            async:false,
            success:function (result) {
                    var warn='<p>'+result.sentence1+'</p>';
                    text_aera.append(warn);
                },
            error:function (e) {

            }
        });
    }
    // $(window).keydown(function(e){
    //     var curKey = e.which;
    //     if(curKey == 13){
    //         go();
    //     }
    // });
        //编写处理小方块移动的方法
    function movesquare(e) {
        //判断键盘输入是否为 ← 键
        //offsetLeft属性代表元素相对父元素的左偏移量
        //offsetTop属性代表元素相对父元素的上偏移量
        if (e.keyCode === 37) {
            //设置要往左边移动的偏移量
            let left = square.offsetLeft - distance
            //小方块碰壁检测 如果此时已经到边界则设置style.left为0
            if (left <= 0) {
                square.style.left = 0 + 'px'
                return
            }
            //设置小方块的left值为left + 'px'
            square.style.left = left + 'px'
        }
        //判断键盘输入是否为 ↑ 键
        else if (e.keyCode === 38) {
        //设置要往上边移动的偏移量
            let top = square.offsetTop - distance
            if (top <= 0) {
                //小方块碰壁检测 如果此时已经到边界则设置style.top为0
                square.style.top = 0 + 'px'
                return
            }
            //设置小方块的top值为top + 'px'
            square.style.top = top + 'px'
        }
        //判断键盘输入是否为 → 键
        else if (e.keyCode === 39) {
        //设置要往左边移动的偏移量
            let left = square.offsetLeft + distance
            if (left >= 550) {
            //小方块碰壁检测 如果此时已经到边界则设置style.left为420
            //420由外层盒子宽度减去小方块宽度得出
            square.style.left = 550 + 'px'
            return
            }
            //设置小方块的left值为top + 'px'
            square.style.left = left + 'px'
        }
        //判断键盘输入是否为 ↓ 键
        else if (e.keyCode === 40) {
        //设置要往上边移动的偏移量
            let top = square.offsetTop + distance
            if (top >= 250) {
            //小方块碰壁检测 如果此时已经到边界则设置style.top为420
            //420由外层盒子高度减去小方块高度得出
            square.style.top = 250 + 'px'
            return
            }
        //设置小方块的left值为top + 'px'
            square.style.top = top + 'px'
        }
        else if (e.keyCode === 17) {
            if(distance===10){
                distance=50;
            }else{
                distance=10;
            }
        }
        else if (e.keyCode === 13) {
            go();
        }
    }

});


