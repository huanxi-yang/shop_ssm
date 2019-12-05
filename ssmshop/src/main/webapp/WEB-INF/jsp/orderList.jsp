<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<title>莫冉工作室</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/dom.js"></script>
</head>
<body>
<!-- 我的订单页面 -->
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="./网上商城/index.htm">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="传智播客"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
	<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
</div>	

</div>

	<%@ include file="menu.jsp" %>

</div>	

<div class="container cart">

		<div class="span24">
		
			<div class="step step1">
				<ul>
					
					<li  class="current"></li>
					<li  ><strong>生成订单成功！！</strong></li>
				</ul>
			</div>
	
		
				<table>
					<tbody>
					<c:forEach var="order" items="${requestScope.pageBean.list }">
					<tr>
						<th colspan="5">订单编号:${order.oid }&nbsp;&nbsp;
						订单状态:
						<c:if test="${order.state==1 }">
							等待付款
						</c:if>
						<c:if test="${order.state==2 }">
							以付款
						</c:if>
						<c:if test="${order.state==3 }">
							<a href=""><font color="red"><strong>确认收货</strong></font></a>
						</c:if>
						<c:if test="${order.state==4 }">
							交易完成
						</c:if>
						</th>
						<td>
							<c:if test="${order.state==1 }">
								<a href="${pageContext.request.contextPath }/findByOid.action?oid=${order.oid }"><font color="red"><strong>付款</strong></font></a>
							</c:if>
							<c:if test="${order.state==3 }">
							<a href=""><font color="red"><strong>确认收货</strong></font></a>
						</c:if>
						</td>
					</tr>
					<c:forEach var="orderItems" items="${order.orderItems }">
						<tr>
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
							<th>操作</th>
						</tr>
							<tr>
								<td width="60">
									<input type="hidden" name="id" value="22"/>
									<img src="${orderItems.pro.image }"/>
								</td>
								<td>
									<a target="_blank">${orderItems.pro.pname }</a>
								</td>
								<td>
									${orderItems.pro.shop_price }
								</td>
								<td class="quantity" width="60">
									<input type="text" name="count" value="${orderItems.count }" maxlength="4" onpaste="return false;"/>
									<div>
										<span class="increase">&nbsp;</span>
										<span class="decrease">&nbsp;</span>
									</div>
								</td>
								<td width="140">
									<span class="subtotal">￥${orderItems.subtotal }</span>
								</td>
								<td>
									<a href="${pageContext.request.contextPath }/removeOrder.action?pid=${orderItems.pro.pid}" class="delete"><font>删除</font></a>
								</td>
							</tr>
						</c:forEach>
					</c:forEach>
					<div class="pagination">
		<span><strong>第 ${pageBean.page }/${pageBean.totalpage }页</strong></span>
		<c:if test="${pageBean.page != 1 }">
			<!-- 首页 -->
			<a class="firstPage" href="${pageContext.request.contextPath }/findByUid.action?page=1">&nbsp;</a>
			<!-- 上一页 -->
			<a class="previousPage" href="${pageContext.request.contextPath }/findByUid.action?page=${pageBean.page-1}">&nbsp;</a>
		</c:if>
		<c:if test="${pageBean.page != pageBean.totalpage }">
			<a class="nextPage" href="${pageContext.request.contextPath }/findByUid.action?page=${pageBean.page+1}">&nbsp;</a>
			<!-- 尾页 -->
			<a class="lastPage" href="${pageContext.request.contextPath }/findByUid.action?page=${pageBean.totalpage}">&nbsp;</a>
		</c:if>
	</div>
				</tbody>
			</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
<!-- 			<form id="orderForm" action="./order_payOrder.action" method="post"> -->
<!-- 				<input type="hidden" name="order.oid" value=""/> -->
<!-- 				<div class="span24"> -->
				
<!-- 						<hr /> -->
<!-- 						<p style="text-align:right"> -->
<!-- 							<a href="javascript:document.getElementById('orderForm').submit();"> -->
<%-- 								<img src="${pageContext.request.contextPath}/images/finalbutton.gif" width="204" height="51" border="0" /> --%>
<!-- 							</a> -->
<!-- 						</p> -->
<!-- 				</div> -->
<!-- 			</form> -->
		</div>
		
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950">
</div>
</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a href="#">关于我们</a>
						|
					</li>
					<li>
						<a href="#">联系我们</a>
						|
					</li>
					<li>
						<a href="#">诚聘英才</a>
						|
					</li>
					<li>
						<a href="#">法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >SHOP++官网</a>
						|
					</li>
					<li>
						<a>SHOP++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body>
</html>