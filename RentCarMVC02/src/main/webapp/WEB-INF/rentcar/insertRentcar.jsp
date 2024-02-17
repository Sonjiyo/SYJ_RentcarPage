<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<h2 class="my-5">차량 추가하기</h2>
<form action="${ctx}/insertCar.do" method="post" enctype="multipart/form-data">
	<table class="table table-bordered w-75 mx-auto">
		<tr>
			<th class="p-3 table-dark" style="width:25%">차량 이름</th>
			<td class="p-3">
			<input type="text" name="name" required class="form-control text-start" id="name">
			<label class="name text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">차량 이미지</th>
			<td class="p-3">
			<input type="file" name="img" class="form-control">
			<label class="img text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">차량 회사</th>
			<td class="p-3">
			<input type="text" name="company" required class="form-control text-start">
			<label class="company text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">차량 종류</th>
			<td class="p-3">
			<input type="checkbox" name="category" value="1" class="form-check-input categoryCheck"> 소형&nbsp;&nbsp;
			<input type="checkbox" name="category" value="2" class="form-check-input categoryCheck"> 중형&nbsp;&nbsp;
			<input type="checkbox" name="category" value="3" class="form-check-input categoryCheck"> 대형<br>
			<label class="category text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">렌트 가격</th>
			<td class="p-3">
			<input type="number" name="price" class="form-control text-start">
			<label class="price text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">승차 인원</th>
			<td class="p-3">
			<input type="number" name="usepeople" class="form-control text-start">
			<label class="usepeople text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">렌트 가능 수량</th>
			<td class="p-3">
			<input type="number" name="total_qty" class="form-control text-start">
			<label class="total_qty text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">차량 정보</th>
			<td class="p-3">
			<textarea name="info" required class="form-control text-start" cols="100" >차량의 정보</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="차량 등록" class="btn btn-dark" onclick="sendForm(form)"></td>
		</tr>
	</table>
</form>
<script type="text/javascript" src="${ctx }/script/insertCar.js"></script>