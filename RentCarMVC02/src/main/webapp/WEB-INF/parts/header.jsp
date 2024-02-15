<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<ul class="navbar bg-body-tertiary px-3 mb-3">
	<li class="navbar-brand"><a href="${ctx}/main.do" class="logo"></a></li>
	<li>
		<ul class="nav nav-pills">
		<c:if test="${log!=null}">
			<li class="me-3 nav-item">${log}님 환영합니다</li>
			<c:if test="${log=='admin' }">
			<li class="me-3 nav-item"><button class="btn btn-outline-warning" onclick="location.href='${ctx}/userInfo.do'">관리자 메뉴</button></li>
			</c:if>
			<c:if test="${log!='admin' }">
			<li class="me-3 nav-item"><button class="btn btn-outline-warning" onclick="location.href='${ctx}/userInfo.do'">회원정보</button></li>
			</c:if>
			<li class="nav-item"><button class="btn btn-outline-danger" onclick="location.href='${ctx}/logout.do'">로그아웃</button></li>
		</c:if>
		<c:if test="${log==null}">
			<li class="nav-item"><button class="btn btn-outline-primary me-3" onclick="location.href='${ctx}/login.do'">로그인</button></li>
			<li class="nav-item"><button class="btn btn-outline-success" onclick="location.href='${ctx}/join.do'">회원가입</button></li>
		</c:if>
		</ul>
	</li>
</ul>
<ul class="navbar navbar-expand-lg bg-dark p-3 shadow-sm">
	<li class="nav-item"><a href="${ctx}/rentcarList.do" class="nav-link link-warning">예약하기</a></li>
	<li class="nav-item"><a href="${ctx}/userReserveList.do" class="nav-link <c:if test="${log==null}">disabled</c:if> link-warning" <c:if test="${log==null}">aria-disabled="true"</c:if>>예약확인</a></li>
	<li class="nav-item"><a href="" class="nav-link link-warning">자유게시판</a></li>
	<li class="nav-item"><a href="" class="nav-link link-warning">이벤트</a></li>
	<li class="nav-item"><a href="" class="nav-link link-warning">고객센터</a></li>
</ul>