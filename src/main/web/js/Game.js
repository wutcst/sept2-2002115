var baseurl="http://localhost:8080";
$(document).ready(function () {
    var text_aera=$("#text-aera");
    var text='';
    var mes=$("#message");
    var screen=$("#screen")
    //设置小方块每次移动的距离
    let distance = 10;
    //获取小方块suqare元素
    const square = document.getElementById('player');
    //给document对象添加键盘事件监听以及触发回调函数
    document.addEventListener('keydown', movesquare);
    //为按钮进行事件绑定
    $('#go').bind('click',go);
    $('#help').bind('click',help);
    $('#quit').bind('click',quit);
    //添加开始时的说明文本
    text='<p>'+'Welcome to the World of Zuul!' +'</p>'
        +'<p>'+'World of Zuul is a new, incredibly boring adventure game.' +'</p>'
        +'<p>'+'Type \'help\' if you need help.' +'</p>';
    $.ajax({
        url:baseurl+"/GetCurrentRoom",
        type:"get",
        dataType:"json",
        async:false,
        success:function (result) {
            text+='<pre>'+result.discription+'</pre>';
            display_DIR(result);
        },
        error:function (e) {
            alert("初始化失败，请检查控制台！");
            console.log(e);
        }
    });
    text_aera.append(text);
    //go命令实现
    // function go() {
    //     var direction=$("#direction").val();
    //     if (isNull(direction)){
    //         var message='<p>'+'Go Where?'+'</p>';
    //         text_aera.append(message);
    //     }else{
    //         $.ajax({
    //             url:baseurl+"/GO",
    //             data:{direction:direction},
    //             type:"post",
    //             dataType:"json",
    //             async:false,
    //             success:function (result) {
    //                 //根据返回情况更改文本域
    //                 if (result.status===1){
    //                     text_aera.empty();
    //                     text='<p>'+result.discription+'</p>';
    //                     text_aera.append(text);
    //                 }else{
    //                     var warn='<p>'+result.discription+'</p>';
    //                     text_aera.append(warn);
    //                 }
    //
    //             },
    //             error:function (e) {
    //
    //             }
    //         });
    //     }
    // }

    //根据玩家移动执行go命令的方法
    function go(direction) {
        //由于用移动控制不存在方向错误的情况，相较于初始的方法删除了验证
            $.ajax({
                url:baseurl+"/GO",
                data:{direction:direction},
                type:"post",
                dataType:"json",
                async:false,
                success:function (result) {
                    //根据返回情况更改文本域
                    if (result.status===1){
                        text_aera.empty();
                        text='<pre>'+result.discription+'</pre>';
                        text_aera.append(text);
                        //根据移动方向调整方块位置
                        if(result.direct==='west'){
                            square.style.left = 600 + 'px';
                            square.style.top = 150 + 'px';
                        }
                        else if(result.direct==='east'){
                            square.style.left = 0 + 'px';
                            square.style.top = 150 + 'px';
                        }
                        else if(result.direct==='south'){
                            square.style.left = 300 + 'px';
                            square.style.top = 0 + 'px';
                        }
                        else if(result.direct==='north'){
                            square.style.left = 300 + 'px';
                            square.style.top = 300 + 'px';
                        }
                        //根据当前房间添加箭头
                        display_DIR(result);
                        //更改背景
                        change_BGI(result.name)
                    }else{
                        var warn='<p>'+result.discription+'</p>';
                        mes.append(warn);
                        //提示语停留1.5秒
                        setTimeout(function () {
                            mes.empty();
                        },1500);
                    }

                },
                error:function (e) {

                }
            });
    }
    //更改背景图片
    function change_BGI(image) {
        screen.css("background-image","url(/images/"+image+".png)")
    }
    //加载方向指示
    function display_DIR(result) {
        var east=$("#east");
        var west=$("#west");
        var south=$("#south");
        var north=$("#north");
        if(result.east===1){
            east.show();
        }else{
            east.hide();
        }
        if(result.west===1){
            west.show();
        }else{
            west.hide();
        }
        if(result.south===1){
            south.show();
        }else{
            south.hide();
        }
        if(result.north===1){
            north.show();
        }else{
            north.hide();
        }
    }
    //help弹出窗口
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

    //look命令
    function look(){
        $.ajax({
            url:baseurl+"/LOOK",
            type:"get",
            dataType:"json",
            async:false,
            success:function (result) {
                text='<pre>'+result.message+'</pre>';
                text_aera.empty();
                text_aera.append(text);
            },
            error:function (e) {
                alert("初始化失败，请检查控制台！");
                console.log(e);
            }
        });
    }
    function movesquare(e) {
        //判断键盘输入是否为 ← 键
        //offsetLeft属性代表元素相对父元素的左偏移量
        //offsetTop属性代表元素相对父元素的上偏移量
        if (e.keyCode === 37) {
            //设置要往左边移动的偏移量
            let left = square.offsetLeft - distance;
            //小方块碰壁检测 如果此时已经到边界则设置style.left为0
            if (left < 0) {
                //执行go命令
                go("west");
                //切换换背景

                //切换音乐

                return;
            }
            //设置小方块的left值为left + 'px'
            square.style.left = left + 'px';
        }
        //判断键盘输入是否为 ↑ 键
        else if (e.keyCode === 38) {
        //设置要往上边移动的偏移量
            let top = square.offsetTop - distance;
            if (top < 0) {
                //执行go命令
                go("north");
                //切换换背景

                //切换音乐

                return;
            }
            //设置小方块的top值为top + 'px'
            square.style.top = top + 'px'
        }
        //判断键盘输入是否为 → 键
        else if (e.keyCode === 39) {
        //设置要往左边移动的偏移量
            let left = square.offsetLeft + distance;
            if (left > 600) {
                //执行go命令
                go("east");
                //切换换背景

                //切换音乐

                return
            }
            //设置小方块的left值为left + 'px'
            square.style.left = left + 'px';
        }
        //判断键盘输入是否为 ↓ 键
        else if (e.keyCode === 40) {
        //设置要往上边移动的偏移量
            let top = square.offsetTop + distance;
            if (top > 300) {
                //执行go命令
                go("south");
                //切换换背景

                //切换音乐

                return;
            }
        //设置小方块的top值为top + 'px'
            square.style.top = top + 'px';
        }
        //按键左Ctrl控制速度
        else if (e.keyCode === 17) {
            if(distance===10){
                distance=50;
            }else{
                distance=10;
            }
        }
        //按键H调出帮助窗口
        else if (e.keyCode === 72) {
            help();
        }
        //按键左Q触发LOOK命令
        else if (e.keyCode === 81) {
            look();
        }
    }

});


