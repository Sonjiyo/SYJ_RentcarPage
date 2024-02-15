<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<h2 class="my-5">예약 확인</h2>
<c:if test="${size==0 }">
	<h3 class="my-5">예약 내역이 없습니다</h3>
</c:if>
<c:if test="${size!=0 }">
<table class="table table-bordered">
	<tr  class="table-dark">
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
<c:forEach var="i" begin="0" end="${size==1 ? 0 : size-1}">
	<tr>
		<td><img src="${ctx}/img/${carList.get(i).img }" style="width:100px;height:50px;object-fit:cover"></td>
		<td>${carList.get(i).name }</td>
		<td>${list.get(i).rday }</td>
		<td>${list.get(i).dday }</td>
		<td>${list.get(i).totalPrice }</td>
		<td>${list.get(i).qty }</td>
		<td>
		<c:if test="${list.get(i).usein ==1 }">O</c:if>
		<c:if test="${list.get(i).usein !=1 }">X</c:if>
		</td>
		<td>
		<c:if test="${list.get(i).usewifi ==1 }">O</c:if>
		<c:if test="${list.get(i).usewifi !=1 }">X</c:if>
		</td>
		<td>
		<c:if test="${list.get(i).usenavi ==1 }">O</c:if>
		<c:if test="${list.get(i).usenavi !=1 }">X</c:if>
		</td>
		<td>
		<c:if test="${list.get(i).useseat ==1 }">O</c:if>
		<c:if test="${list.get(i).useseat !=1 }">X</c:if>
		</td>
		<td>
		<form action="${ctx}/deleteRes.do" method="post">
		<input type="hidden" value="${list.get(i).no}" name="no">
		<input type="hidden" value="${list.get(i).reserve_seq}" name="reserve_seq">
		<input type="hidden" value="${list.get(i).qty}" name="qty">
		<button class="btn btn-danger">삭제</button>
		</form>
		</td>
	</tr>
</c:forEach>
</table>
</c:if>