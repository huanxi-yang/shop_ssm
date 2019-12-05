
//第一种，点击之后出现的随机，大部分情况下是default

 onload = function() {
    var click_cnt = 0;
    var $html = document.getElementsByTagName("html")[0];
    var $body = document.getElementsByTagName("body")[0];
    $html.onclick = function(e) {
        var $elem = document.createElement("b");
        $elem.style.color = "#E94F06";
        $elem.style.zIndex = 9999;
        $elem.style.position = "absolute";
        $elem.style.select = "none";
        var x = e.pageX;
        var y = e.pageY;
        $elem.style.left = (x - 10) + "px";
        $elem.style.top = (y - 20) + "px";
        clearInterval(anim);
        switch (++click_cnt) {
            case 10:
            case 20:
            	$elem.innerText = "文明";
                break;
            case 30:
            case 40:
            	$elem.innerText = "自由";
                break;
            case 50:
                $elem.innerText = "爱国";
                break;
            case 60:
            case 70:
                $elem.innerText = "文明";
                break;
            case 80:
            case 90:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
                $elem.innerText = "自由";
                break;
            default:
                $elem.innerText = "❤爱你❤";
                break;
        }
        $elem.style.fontSize = Math.random() * 10 + 8 + "px";
        var increase = 0;
        var anim;
        setTimeout(function() {
            anim = setInterval(function() {
                if (++increase == 150) {
                    clearInterval(anim);
                    $body.removeChild($elem);
                }
                $elem.style.top = y - 20 - increase + "px";
                $elem.style.opacity = (150 - increase) / 120;
            }, 8);
        }, 70);
        $body.appendChild($elem);
    };
};

/* 鼠标特效 */
//var a_idx = 0;
//jQuery(document).ready(function($) {
//    $("body").click(function(e) {
//        var a = new Array("❤富强❤","❤民主❤","❤文明❤","❤和谐❤","❤自由❤","❤平等❤","❤公正❤","❤法治❤","❤爱国❤","❤敬业❤","❤诚信❤","❤友善❤");
//        var $i = $("<span></span>").text(a[a_idx]);
//        a_idx = (a_idx + 1) % a.length;
//        var x = e.pageX,
//        y = e.pageY;
//        $i.css({
//            "z-index": 999999999999999999999999999999999999999999999999999999999999999999999,
//            "top": y - 20,
//            "left": x,
//            "position": "absolute",
//            "font-weight": "bold",
//            "color": "rgb("+~~(255*Math.random())+","+~~(255*Math.random())+","+~~(255*Math.random())+")"
//        });
//        $("body").append($i);
//        $i.animate({
//            "top": y - 180,
//            "opacity": 0
//        },
//        1500,
//        function() {
//            $i.remove();
//        });
//    });
//});


/**
 *第二种,字体大小固定了，上一种字体大小可变 
 */
/* 鼠标点击特效 */
//var a_idx = 0;
//$(document).ready(function($) {
//    $("body").click(function(e) {
//var a = new Array("爱国", "敬业", "诚信", "友善","自由", "平等", "公正", "法制","富强", "民主", "文明", "和谐","❤爱你");
//var $i = $("<span></tagObj>").text(a[a_idx]);
//        a_idx = (a_idx + 1) % a.length;
//var x = e.pageX,
//        y = e.pageY;
//        $i.css({
//				"z-index": 999999999999999999999999999999999999999999999999999999999999999999999,
//				"top": y - 20,
//				"left": x,
//				"position": "absolute",
//				"font-weight": "bold",
//				"color": "#ff6651"
//        });
//        $("body").append($i);
//        $i.animate({
//			"top": y - 180,
//			"opacity": 0
//        },
//        1500,
//function() {
//            $i.remove();
//        });
//    });
//});
