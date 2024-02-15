<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<ul class="nav nav-tabs my-5">
	<li class="nav-item">
		<a class="nav-link active" href="${ctx}/adminUserList.do">회원 목록</a>	
	</li>
	<li class="nav-item">
		<a class="nav-link" href="${ctx}/adminCarList.do">렌트카 목록</a>	
	</li>
</ul>
<table class="table table-bordered">
	<tr class="table-dark">
		<td>번호</td>
		<td>아이디</td>
		<td>패스워드</td>
		<td>이메일</td>
		<td>전화번호</td>
		<td>취미</td>
		<td>직업</td>
		<td>나이</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
<c:forEach var="vo" items="${list}">
	<tr>
		<td>${vo.no }</td>
		<td>${vo.id }</td>
		<td>${vo.pw }</td>
		<td>${vo.email }</td>
		<td>${vo.tel }</td>
		<td>${vo.hobby }</td>
		<td>${vo.job }</td>
		<td>${vo.age }</td>
		<td><button class="btn btn-primary" onclick="location.href='${ctx}/userInfo.do?id=${vo.id}'">수정</button></td>
		<td><button class="btn btn-danger" onclick="location.href='${ctx}/deleteUser.do?id=${vo.id}'">삭제</button></td>
	</tr>
	</c:forEach>
</table>