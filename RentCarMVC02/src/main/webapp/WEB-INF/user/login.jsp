<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<h2 class="my-5">로그인</h2>
<form action="${ctx}/login.do" method="post">
	<table class="table table-bordered w-50 mx-auto">
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
			<td colspan="2"><input type="button" value="로그인" class="btn btn-dark" onclick="sendForm(form)"></td>
		</tr>
	</table>
</form>
<script>
	function sendForm(form){
		let idMsg = document.querySelector('.id');
		let pwMsg = document.querySelector('.pw');
		
		idMsg.textContent = '';
		pwMsg.textContent = '';
		
		let id = form.id.value;
		let pw = form.pw.value;
		if(id.length==0){
			idMsg.textContent = '아이디를 입력해주세요';
			form.id.focus();
			return;
		}
		if(pw.length==0){
			pwMsg.textContent = '비밀번호를 입력해주세요';
			form.pw.focus();
			return;
		}
		
		form.submit();
	}
</script>