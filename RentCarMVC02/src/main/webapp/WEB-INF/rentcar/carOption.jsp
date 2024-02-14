<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<h2 class="my-5">옵션 선택</h2>
<ul class="row row-cols-2 g-3">
	<li class="col">
		<img src="${ctx}/img/${vo.img}" style="width:100%;height:100%;object-fit:cover">
	</li>
	<li class="col" style="padding:0;">
	<form action="${ctx }/reserveView.do" class="form-switch">
		<table class="table rounded-3" style="width:100%;">
			<tr>
				<th style="width:35%">대여기간</th>
				<td>
					<input type="range" min="1" max="7" name="dday">
				</td>
			</tr>	
			<tr>
				<th>대여일</th>
				<td>
					<input type="date" name="rday" class="border p-2" id="date">
				</td>
			</tr>	
			<tr>
				<th>보험적용 <p class="fw-normal" style="color:red">1일 1만원</p></th>
				<td>
					<input type="checkbox" class="form-check-input" role="switch" 
					name="usein" style="transform:scale(1.5);margin-left:10px;margin-top:20px">
				</td>
			</tr>	
			<tr>
				<th>Wifi 적용 <p class="fw-normal" style="color:red">1일 1만원</p></th>
				<td>
					<input type="checkbox" class="form-check-input" role="switch" 
					name="usewifi" style="transform:scale(1.5);margin-left:10px;margin-top:20px">
				</td>
			</tr>	
			<tr>
				<th>네비게이션 적용 <p class="fw-normal" style="color:red">무료</p></th>
				<td>
					<input type="checkbox" class="form-check-input" role="switch" 
					name="usenavi" style="transform:scale(1.5);margin-left:10px;margin-top:20px">
				</td>
			</tr>	
			<tr>
				<th>베이비시트 적용 <p class="fw-normal" style="color:red">1일 1만원</p></th>
				<td>
					<input type="checkbox" class="form-check-input" role="switch" 
					name="useseat" style="transform:scale(1.5);margin-left:10px;margin-top:20px">
				</td>
			</tr>	
		</table>
		<input type="hidden" value="${cnt}" name="cnt">
		<button class="btn btn-warning">예약하기</button>
		</form>
	</li>
</ul>
<div class="alert alert-warning p-3" id="reserveForm" style="position:absolute;width:500px;height:450px;top:50%;left:50%;transform:translate(-50%, -50%);display:none" >
	<h3 class="mt-3 mb-5">예약확인</h3>
	<form>
		<table class="table table-light mt-5 table-bordered border-danger fs-5">
			<tr>
				<td style="width:40%">차량 예약일</td>
				<td colspan="2">1</td>
			</tr>
			<tr>
				<td>차량 개수</td>
				<td colspan="2">1</td>
			</tr>
			<tr>
				<td>예약 금액</td>
				<td>1</td>
				<td>1</td>
			</tr>
			<tr>
				<td>유료 옵션 금액</td>
				<td>1</td>
				<td>1</td>
			</tr>
			<tr>
				<td>총 예약 금액</td>
				<td colspan="2">1</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="button" class="btn btn-success" value="예약확정">
					<input type="button" class="btn btn-danger" value="예약취소">
				</td>
			</tr>
		</table>
	</form>
</div>
<script>
	let now = Date.now();
	let timeOff = new Date().getTimezoneOffset()*60000;
	let today = new Date(now-timeOff).toISOString().split("T")[0];
	document.querySelector("#date").setAttribute("min", today);

	function reservationForm(form){
		let inputs= 
			"qty="+form.cnt.value+
			"&dday="+form.dday.value+
			"&rday="+form.rday.value+
			"&usein="+form.usein.value+
			"&usewifi="+form.usenavi.value+
			"&usenavi="+form.usenavi.value+
			"&useseat="+form.usenavi.value;
		
		fetch("reserveView.do", {
			method : "POST",
			headers : {"Content-Type" : "application/x-www-form-urlencoded; charset=UTF-8"},
			body : inputs,
		})
		.then(response => response.text())
		.then(getResult)
		.catch(()=>alert('error'));
	}	
</script>