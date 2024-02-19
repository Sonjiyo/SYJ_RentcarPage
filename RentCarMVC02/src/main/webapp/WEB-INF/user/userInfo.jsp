<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<h2 class="my-5">회원정보</h2>
<form action="${ctx}/updateUser.do" method="post">
	<table class="table table-bordered w-75 mx-auto">
		<tr>
			<th class="p-3 table-dark" style="width:25%">아이디</th>
			<td class="p-3">
			${vo.id}
			<input type="hidden" name="id" value="${ vo.id}">
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">패스워드</th>
			<td class="p-3">
			<input type="password" name="pw" required class="form-control text-start">
			<label class="pw text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">이메일</th>
			<td class="p-3">${vo.email }</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">전화번호</th>
			<td class="p-3">${vo.tel }</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">취미</th>
			<td class="p-3">
			<input type="checkbox" name="hobby" value="스포츠" class="form-check-input hobbyCheck" <c:if test="${fn:contains(vo.hobby, '스포츠')}">checked</c:if>> 스포츠&nbsp;&nbsp;
			<input type="checkbox" name="hobby" value="게임" class="form-check-input hobbyCheck" <c:if test="${fn:contains(vo.hobby, '게임')}">checked</c:if>> 게임&nbsp;&nbsp;
			<input type="checkbox" name="hobby" value="영화감상" class="form-check-input hobbyCheck" <c:if test="${fn:contains(vo.hobby, '영화감상')}">checked</c:if>> 영화감상&nbsp;&nbsp;
			<input type="checkbox" name="hobby" value="독서" class="form-check-input hobbyCheck" <c:if test="${fn:contains(vo.hobby, '독서')}">checked</c:if>> 독서&nbsp;&nbsp;
			<input type="checkbox" name="hobby" value="음악감상" class="form-check-input hobbyCheck" <c:if test="${fn:contains(vo.hobby, '음악감상')}">checked</c:if>> 음악감상<br>
			<label class="hobby text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">직업</th>
			<td class="p-3">
			<input type="radio" name="job" value="개발자" class="form-check-input jobCheck" <c:if test="${vo.job == '개발자'}">checked</c:if>>개발자&nbsp;&nbsp;
			<input type="radio" name="job" value="사무직" class="form-check-input jobCheck" <c:if test="${vo.job == '사무직'}">checked</c:if>>사무직&nbsp;&nbsp;
			<input type="radio" name="job" value="생산직" class="form-check-input jobCheck" <c:if test="${vo.job == '생산직'}">checked</c:if>>생산직&nbsp;&nbsp;
			<input type="radio" name="job" value="기타" class="form-check-input jobCheck" <c:if test="${vo.job == '기타'}">checked</c:if>>기타&nbsp;&nbsp;
			<input type="radio" name="job" value="무직" class="form-check-input jobCheck" <c:if test="${vo.job == '무직'}">checked</c:if>>무직<br>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">나이</th>
			<td class="p-3">
			<input type="number" name="age" required class="form-control text-start" value="${vo.age }">
			<label class="age text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">자기소개</th>
			<td class="p-3">
			<textarea name="info" required class="form-control text-start" cols="100" >${vo.info }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="정보수정" class="btn btn-dark" onclick="sendForm(form, ${vo.pw})">
			<input type="button" value="회원탈퇴" id="delete" class="btn btn-danger" onclick="deleteUser(form, ${vo.pw}, '${ctx }', '${vo.id}')"></td>
		</tr>
	</table>
</form>
<script type="text/javascript" src="${ctx }/script/updateUser.js"></script>