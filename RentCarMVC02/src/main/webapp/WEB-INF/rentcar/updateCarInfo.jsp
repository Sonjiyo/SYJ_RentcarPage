<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<h2 class="my-5">차량 수정하기</h2>
<form action="${ctx}/updateRentcar.do" method="post">
	<input type="hidden" value="${vo.no}" name="no">
	<table class="table table-bordered w-75 mx-auto">
		<tr>
			<th class="p-3 table-dark" style="width:25%">차량 이름</th>
			<td class="p-3">${vo.name }</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">차량 이미지</th>
			<td class="p-3">
			<img src="${ctx}/img/${vo.img}" style="width:100%;height:100%;object-fit:cover">
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">차량 회사</th>
			<td class="p-3">
			${vo.company }
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">차량 종류</th>
			<td class="p-3">
			<c:if test="${vo.category==1}">소형</c:if>
			<c:if test="${vo.category==2}">중형</c:if>
			<c:if test="${vo.category==3}">대형</c:if>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">렌트 가격</th>
			<td class="p-3">
			<input type="number" name="price" class="form-control text-start" value="${vo.price }">
			<label class="price text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">승차 인원</th>
			<td class="p-3">
			${vo.usepeople }
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">렌트 가능 수량</th>
			<td class="p-3">
			<input type="number" name="total_qty" class="form-control text-start" value="${vo.total_qty }">
			<label class="total_qty text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">차량 정보</th>
			<td class="p-3">
			<textarea name="info" required class="form-control text-start" cols="100" >${vo.info }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="차량 정보 수정" class="btn btn-dark" onclick="sendForm(form)"></td>
		</tr>
	</table>
</form>
<script type="text/javascript" src="${ctx }/script/insertCar.js"></script>