<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<h2 class="my-5">자동차 리스트</h2>
<c:forEach var="vo" items="${list}">
<ul>
	<li>
		<div class="image"><img src="../img/${vo.img}"></div>
		<p>${vo.name }</p>
	</li>

</ul>
</c:forEach>