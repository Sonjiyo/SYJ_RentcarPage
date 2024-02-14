<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<h2 class="my-5">${vo.name}</h2>
<ul class="row row-cols-2 g-3">
	<li class="col">
		<img src="${ctx}/img/${vo.img}" style="width:100%;height:100%;object-fit:cover">
	</li>
	<li class="col border rounded-3" style="padding:0;">
		<table class="table rounded-3" style="width:100%;height:100%;">
			<tr>
				<th class="table-dark" style="width:35%">차량이름</th>
				<td>${vo.name }</td>
			</tr>	
			<tr>
				<th class="table-dark">총 승차인원</th>
				<td>${vo.usepeople }</td>
			</tr>	
			<tr>
				<th class="table-dark">남은 차량 수량</th>
				<td>${vo.total_qty }대</td>
			</tr>	
			<tr>
				<th class="table-dark">차량분류</th>
				<td>
				<c:if test="${vo.category==1}">소형</c:if>
				<c:if test="${vo.category==2}">중형</c:if>
				<c:if test="${vo.category==3}">대형</c:if>
				</td>
			</tr>	
			<tr>
				<th class="table-dark">대여가격</th>
				<td>${vo.price }원</td>
			</tr>	
			<tr>
				<th class="table-dark">제조회사</th>
				<td>${vo.company}</td>
			</tr>	
		</table>
	</li>
</ul>
<c:if test="${vo.total_qty==0}">
	<h3 class="my-4 text-end">현재 대여 가능한 차량이 없습니다</h3>
</c:if>
<c:if test="${log==null}">
	<h3 class="my-4 text-end">로그인 후 이용가능합니다</h3>
</c:if>
<c:if test="${vo.total_qty!=0 && log!=null}">
<form action="${ctx }/carOption.do" method="post">
<ul class="my-4" style="display:flex;justify-content:flex-end;">
<li class="me-5" style="display:flex;align-items:center;">
	<span class="mx-3 fs-4 fw-medium">대여할 차량 수</span>
	<div class="btn btn-outline-secondary fw-bold" onclick="decrease()">-</div>
	<span class="mx-3 fs-4 fw-medium" id="itemCnt"></span>
	<input type="hidden" name="cnt" id="itemInput" value="0">
	<div class="btn btn-outline-secondary fw-bold" onclick="increase()">+</div>
</li>
<li>
	<button class="btn btn-warning">예약하기</button>
</li>
</ul>
</form>
</c:if>
<div class="border p-3 rounded-3">
	<h3 class="text-start">차량 설명</h3><hr>
	<p class="text-start mt-3">${vo.info}</p>
</div>
<script>
	let num = 1;
	let itemCnt = document.querySelector("#itemCnt");
	let itemInput = document.querySelector("#itemInput");
	
	itemCnt.textContent=num;
	itemInput.value=num;
	
	
	function increase() {
		if(num==${vo.total_qty}){
			alert('최대수량입니다.');
			return;
		}
		num+=1;
		itemCnt.textContent=num;
		itemInput.value=num;
		console.log(num);
		console.log(${vo.total_qty});
	}
	function decrease() {
		if(num==1 || num==0){
			alert('최소수량입니다.');
			return;
		}
		num-=1;
		itemCnt.textContent=num;
		itemInput.value=num;
	}
</script>