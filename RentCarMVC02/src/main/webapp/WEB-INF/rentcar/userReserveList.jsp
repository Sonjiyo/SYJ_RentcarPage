<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<h2 class="my-5">예약 확인</h2>
<c:forEach var="vo" items="${list}">
<table class="table table-bordered">
	<tr>
		<td>이미지</td>
		<td>이름</td>
		<td>대여일</td>
		<td>대여기간</td>
		<td>금액</td>
		<td>수량</td>
		<td>보험</td>
		<td>wifi</td>
		<td>베이비시트</td>
		<td>네비게이션</td>
		<td>삭제</td>
	</tr>
	<tr>
		<td></td>
		<td>${vo.no }</td>
		<td>${vo.rday }</td>
		<td>${vo.dday }</td>
		<td>${vo.totalPrice }</td>
		<td>${vo.qty }</td>
		<td>
		<c:if test="${vo.usein ==1 }">O</c:if>
		<c:if test="${vo.usein !=1 }">X</c:if>
		</td>
		<td>
		<c:if test="${vo.usewifi ==1 }">O</c:if>
		<c:if test="${vo.usewifi !=1 }">X</c:if>
		</td>
		<td>
		<c:if test="${vo.usenavi ==1 }">O</c:if>
		<c:if test="${vo.usenavi !=1 }">X</c:if>
		</td>
		<td>
		<c:if test="${vo.useseat ==1 }">O</c:if>
		<c:if test="${vo.useseat !=1 }">X</c:if>
		</td>
		<td><button class="btn btn-danger">삭제</button></td>
	</tr>
</table>
</c:forEach>