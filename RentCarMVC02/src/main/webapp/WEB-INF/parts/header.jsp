<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<ul class="header">
	<li><img src="${ctx}/img/rent_logo.jpg"></li>
	<li>
		<ul>
		<c:if test="${log!=null}">
			<li class="me-2">${log}님 환영합니다</li>
			<li><button class="btn btn-outline-danger">로그아웃</button></li>
		</c:if>
		<c:if test="${log==null}">
			<li><button class="btn btn-outline-primary me-2">로그인</button></li>
			<li><button class="btn btn-outline-success">회원가입</button></li>
		</c:if>
		</ul>
	</li>
</ul>