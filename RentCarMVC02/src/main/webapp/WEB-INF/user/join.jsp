<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<h2 class="my-5">회원가입</h2>
<form action="${ctx}/join.do" method="post">
	<table class="table table-bordered w-75 mx-auto">
		<tr>
			<th class="p-3">아이디</th>
			<td class="p-3">
			<input type="text" name="id" required class="form-control text-start">
			<label class="id text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3">패스워드</th>
			<td class="p-3">
			<input type="password" name="pw" required class="form-control text-start">
			<label class="pw text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3">이메일</th>
			<td class="p-3">
			<input type="email" name="email" required class="form-control text-start">
			<label class="email text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3">전화번호</th>
			<td class="p-3">
			<input type="tel" name="tel" required class="form-control text-start">
			<label class="tel text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3">취미</th>
			<td class="p-3">
			<input type="password" name="hobby" required class="form-control text-start">
			</td>
		</tr>
		<tr>
			<th class="p-3">직업</th>
			<td class="p-3">
			<input type="text" name="job" required class="form-control text-start">
			<label class="job text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3">나이</th>
			<td class="p-3">
			<input type="number" name="age" required class="form-control text-start">
			<label class="age text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3">자기소개</th>
			<td class="p-3">
			<textarea name="info" required class="form-control text-start" cols="100" >반갑습니다</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="회원가입" class="btn btn-dark" onclick="sendForm(form)"></td>
		</tr>
	</table>
</form>
