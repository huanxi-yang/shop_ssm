<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>莫冉工作室支付保障中</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/dom.js"></script>
<script type="text/javascript">
	function changeColor(){
		var color="#f00|#0f0|#00f|#880|#808|#088|#FFC0CB|yellow|green|blue|gray|red"; 
		color=color.split("|");
		document.getElementById("bling").style.color=color[parseInt(Math.random() * color.length)]; 
	}
	setInterval("changeColor()",200);
	
	function readypay(){
		alert("没有写了");
		window.location.href="/ssmshop/toIndex.action";
	}
	
</script>

</head>
<body>

	<!-- 定义时钟区域 -->
		<div>
			<canvas id="dom" width="120" height="120">时钟canvas</canvas> 
		</div>
		
		<div align="center">
			<tr>
				<td>
					<img alt="网速不好?链接WIFI试试" src="${pageContext.request.contextPath }/images/wechatpay.png" width="400" height="600">
				</td>
			</tr>
			<tr>
				<td>
					<a id="bling" href="javascript:;" onclick="readypay()"><font size="10">我已经完成付款</font></a>
				</td>
			</tr>
		</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/clock.js"></script>
</html>