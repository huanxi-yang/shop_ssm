<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="cn.fzkj.pojo.User"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
			<c:if test="${empty user}">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${ pageContext.request.contextPath }/toLoginPage.action">登录</a>|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/toRegistPage.action">注册</a>|
				</li>
			</c:if>
			<c:if test="${!empty user}">
				<li id="headerUsername" class="headerUsername"></li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<c:out value="${sessionScope.user.name }"></c:out>
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/findByUid.action?page=1">我的订单</a>|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/toexit.action">退出登录</a>|
				</li>
			</c:if>
						<li>
							<a>会员中心</a>
							|
						</li>
						<li>
							<a>购物指南</a>
							|
						</li>
						<li>
							<a>关于我们</a>
							
						</li>
			</ul>
		</div>
		<div class="cart">
		<!-- 判断登录状态,如果登陆了才允许跳转-->
			<c:if test="${!empty user}">
				<a  href="${pageContext.request.contextPath }/myCart.action">购物车</a>
			</c:if>
			<c:if test="${empty user}">
				<a  href="${pageContext.request.contextPath }/toLoginPage.action">购物车</a>
			</c:if>
		</div>
			<div class="phone">
				客服热线:
				<strong>96008/53277764</strong>
			</div>
	</div>
	<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="${pageContext.request.contextPath}/toIndex.action">首页</a>
						|
					</li>
					<c:forEach var="cList" items="${sessionScope.cList}">
					<li>
						<a href="${pageContext.request.contextPath }/findBycid.action?cid=${cList.cid }&page=1"><c:out value="${cList.cname }"></c:out></a>
						|
					</li>
					</c:forEach>
		</ul>
	</div>