
// 校验用户名是否存在、非空判断
function checkusername() {
	$(document).ready(function() {
		if ($("#username").val() != "") {
			$.get("checkUserName.action", {
				username : $("#username").val()
			}, function(data) {
				$("#pusername").text(data);
			});
		} else {
			$("#pusername").text("输入用户名");
			
		}$("#username").focus(function(){
			$("#pusername").text("");
		});
	});
}

// 校验密码是否为空
function checkpw() {
	$(document).ready(function(){
		if ($("#password").val() == "") {
			$("#ppw").text("输入密码");
			// $("#password").focus();
		} else {
			return;
		}
		$("#password").focus(function(){
			$("#ppw").text("");
		});
	});
	
}

// 校验确认密码
function checkrepw() {
	$(document).ready(function(){
		if ($("#repassword").val() == "") {
			$("#prepw").text("确认密码");
		}
		if ($("#repassword").val() != $("#password").val()) {
			alert("密码不一致,请修改");
//			$("#repassword").focus();	//加这句就死循环了？就一直跳出提示？？？
		}
		$("#repassword").focus(function(){
			$("#prepw").text("");
		});
	});
}

// 校验姓名是否为空
function checkname() {
	$(document).ready(function() {
		if ($("#name").val() == "") {
			$("#pname").text("输入真实姓名");
			// $("#name").focus();
		} else {
			return;
		}$("#name").focus(function(){
			$("#pname").text("");
		});
	});
}

// 校验email是否为空
function checkemail() {
	$(document).ready(function() {
		if ($("#email").val() == "") {
			$("#pemail").text("输入email");
			// $("#email").focus();
		} else {
			return;
		}$("#email").focus(function(){
			$("#pemail").text("");
		});
	});
}

// 校验电话是否为空
function checkphone() {
	$(document).ready(function() {
		if ($("#phone").val() == "") {
			$("#pphone").text("输入电话");
			// $("#phone").focus();
		} else {
			return;
		}$("#phone").focus(function(){
			$("#pphone").text("");
		});
	});
}

// 校验地址是否为空
function checkaddr() {
	$(document).ready(function() {
		if ($("#addr").val() == "") {
			$("#paddr").text("输入地址");
			// $("#addr").focus();
		} else {
			return;
		}$("#addr").focus(function(){
			$("#paddr").text("");
		});
	});
}


//更换验证码图片
//function changeimg(){
//	var img = document.getElementById("checkimg");
//	img.src="${pageContext.request.contextPath}/checkImg.action?"+new Date().getTime();
//}

// // 获得文件框值:
// var username = document.getElementById("username").value;
// // 1.创建异步交互对象
// var xhr = createXmlHttp();
// // 2.设置监听
// xhr.onreadystatechange = function() {
// if (xhr.readyState == 4) {
// if (xhr.status == 200) {
// document.getElementById("pusername").innerHTML = xhr.responseText;
// }
// }
// }
// // 3.打开连接
// xhr.open("GET","checkUserName.action?time="
// + new Date().getTime() + "&username=" + username, true);
// // 4.发送
// xhr.send(null);
// }
//
// function createXmlHttp() {
// var xmlHttp;
// try { // Firefox, Opera 8.0+, Safari
// xmlHttp = new XMLHttpRequest();
// } catch (e) {
// try {// Internet Explorer
// xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
// } catch (e) {
// try {
// xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
// } catch (e) {
// }
// }
// }
//
// return xmlHttp;
// }
// function change() {
// var img1 = document.getElementById("checkImg");
// img1.src = "${pageContext.request.contextPath}/checkImg.action?"
// + new Date().getTime();
// }

