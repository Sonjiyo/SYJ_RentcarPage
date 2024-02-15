<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<ul class="nav nav-tabs my-5">
	<li class="nav-item">
		<a class="nav-link" href="${ctx}/adminUserList.do">회원 목록</a>	
	</li>
	<li class="nav-item">
		<a class="nav-link active" href="${ctx}/adminCarList.do">렌트카 목록</a>	
	</li>
</ul>
<button class="btn btn-success mb-3" onclick="location.href='${ctx}/insertCar.do'">차량 추가</button>
<table class="table table-bordered">
	<tr class="table-dark">
		<td>번호</td>
		<td>이름</td>
		<td>차량 이미지</td>
		<td>차량 회사</td>
		<td>차량 종류</td>
		<td>렌트 가격</td>
		<td>승차 인원</td>
		<td>렌트 가능 수량</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
<c:forEach var="vo" items="${list}">
	<tr>
		<td>${vo.no }</td>
		<td>${vo.name }</td>
		<td><img src="${ctx}/img/${vo.img}" style="width:100px;height:50px;object-fit:cover"></td>
		<td>${vo.company }</td>
		<td>
		<c:if test="${vo.category==1}">소형</c:if>
		<c:if test="${vo.category==2}">중형</c:if>
		<c:if test="${vo.category==3}">대형</c:if>
		</td>
		<td>${vo.price }</td>
		<td>${vo.usepeople }명</td>
		<td>${vo.total_qty }</td>
		<td><button class="btn btn-primary" onclick="location.href='${ctx}/updateRentcarInfo.do?no=${vo.no}'">수정</button></td>
		<td><button class="btn btn-danger" onclick="location.href='${ctx}/deleteRentcar.do?no=${vo.no}'">삭제</button></td>
	</tr>
	</c:forEach>
</table>