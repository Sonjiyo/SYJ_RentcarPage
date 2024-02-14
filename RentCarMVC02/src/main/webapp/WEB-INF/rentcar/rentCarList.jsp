<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<h2 class="my-5">자동차 리스트</h2>
<form action="${ctx}/rentcarList.do" class="mb-5">
<input type="radio" name="category" class="btn-check" id="all" value="all" autocomplete="off" 
	<c:if test="${category==null}">checked="checked"</c:if>>
<label for="all" class="btn btn-outline-dark">전체보기</label>

<input type="radio" name="category" class="btn-check" id="small" value="1" autocomplete="off"
	<c:if test="${category == 1 }">checked="checked"</c:if>>
	
<label for="small" class="btn btn-outline-secondary">소형</label>
<input type="radio" name="category" class="btn-check" id="middle" value="2" autocomplete="off"
	<c:if test="${category == 2 }">checked="checked"</c:if>>
	
<label for="middle" class="btn btn-outline-secondary">중형</label>
<input type="radio" name="category" class="btn-check" id="big" value="3" autocomplete="off"
	<c:if test="${category == 3 }">checked="checked"</c:if>>
	
<label for="big" class="btn btn-outline-secondary">대형</label>
<button class="btn btn-warning ms-3">검색</button>
</form>
<c:if test="${size==0}">
<h1 class="my-5 mx-5">등록된 차량이 없습니다.</h1>
</c:if>
<ul class="row row-cols-3 g-3">
<c:forEach var="vo" items="${list}">
	<li class="col p-2">
		<div class="shadow-sm p-3 btn btn-outline-light rounded-3" onclick="location.href='${ctx}/rentcarInfo.do?no=${vo.no}'">
		<div class="image" style="width:100%;height:200px;overflow:hidden">
		<img src="${ctx}/img/${vo.img}" style="width:100%;height:100%;object-fit:cover">
		</div>
		<p class="fw-bold mt-3" style="color:#222">${vo.name }</p>
		</div>
	</li>
</c:forEach>
</ul>