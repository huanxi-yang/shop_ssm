<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>莫冉工作室</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/dom.js"></script>
</head>
<body>

<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="http://localhost:8080/mango/">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="传智播客">
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障">
</div>	</div>
<%@ include file="menu.jsp" %>
</div>	
<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
					<c:forEach var="cList" items="${sessionScope.cList }">
						<dl>
							<dt>
								<a href="#">${cList.cname }</a>
							</dt>
								<c:forEach var="cs" items="${cList.categorySecondList }">
									<dd>
									<!-- 点击这个链接查询二级分类下的商品,并显示在productList.jsp页面中 
										先放弃
									-->
										<a href="${pageContext.request.contextPath }/findProByCsid.action?csid=${cs.csid}&page=1"><c:out value="${cs.csname }"></c:out></a>
									</dd>
								</c:forEach>
						</dl>
					</c:forEach>
			</div>
		</div>
		<div class="span18 last">
			
			<form id="productForm" action="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm" method="get">
				<input type="hidden" id="brandId" name="brandId" value="">
				<input type="hidden" id="promotionId" name="promotionId" value="">
				<input type="hidden" id="orderType" name="orderType" value="">
				<input type="hidden" id="pageNumber" name="pageNumber" value="1">
				<input type="hidden" id="pageSize" name="pageSize" value="20">
					
				<div id="result" class="result table clearfix">
					<ul>
						<c:forEach var="productList" items="${productList.list }">
									<li>
									<!-- 进入商品详情页面 -->
										<a href="${pageContext.request.contextPath }/findBypid.action?pid=${productList.pid}">
											<img src="${pageContext.request.contextPath}/${productList.image}" width="170" height="170"  style="display: inline-block;">
											   
											<span style='color:green'>
											 ${productList.pname }
											</span>
											 
											<span class="price">
												商城价:${productList.shop_price }￥
												
											</span>
											 
										</a>
									</li>
						</c:forEach>		
					</ul>
				</div>
	<div class="pagination">
		<span><strong>第 ${productList.page }/${productList.totalpage }页</strong></span>
		<c:if test="${productList.page != 1 }">
			<!-- 首页 -->
			<a class="firstPage" href="${pageContext.request.contextPath }/findBycid.action?cid=${sessionScope.cList[0].cid }&page=1">&nbsp;</a>
			<!-- 上一页 -->
			<a class="previousPage" href="${pageContext.request.contextPath }/findBycid.action?cid=${sessionScope.cid }&page=${productList.page-1}">&nbsp;</a>
		</c:if>
		<c:if test="${productList.page != productList.totalpage }">
			<a class="nextPage" href="${pageContext.request.contextPath }/findBycid.action?cid=${sessionScope.cid }&page=${productList.page+1}">&nbsp;</a>
			<!-- 尾页 -->
			<a class="lastPage" href="${pageContext.request.contextPath }/findBycid.action?cid=${sessionScope.cid }&page=${productList.totalpage}">&nbsp;</a>
		</c:if>
	</div>
			</form>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a >诚聘英才</a>
						|
					</li>
					<li>
						<a >法律声明</a>
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
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >官网</a>
						|
					</li>
					<li>
						<a >论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright©2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body></html>