<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<h2 class="my-5">회원가입</h2>
<form action="${ctx}/join.do" method="post">
	<table class="table table-bordered w-75 mx-auto">
		<tr>
			<th class="p-3 table-dark" style="width:25%">아이디</th>
			<td class="p-3">
			<input type="text" name="id" required 
			class="form-control text-start" style="width:50%;display:inline-block" id="id">
			<input type="button" class="btn btn-secondary checkBtn" value="중복체크" onclick="idCheck(form)">
			<label class="id text-danger"></label>
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
			<td class="p-3">
			<input type="email" name="email" required class="form-control text-start">
			<label class="email text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">전화번호</th>
			<td class="p-3">
			<input type="tel" name="tel" required class="form-control text-start" oninput="autoHyphen(form)">
			<label class="tel text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">취미</th>
			<td class="p-3">
			<input type="checkbox" name="hobby" value="스포츠" class="form-check-input hobbyCheck"> 스포츠&nbsp;&nbsp;
			<input type="checkbox" name="hobby" value="게임" class="form-check-input hobbyCheck"> 게임&nbsp;&nbsp;
			<input type="checkbox" name="hobby" value="영화감상" class="form-check-input hobbyCheck"> 영화감상&nbsp;&nbsp;
			<input type="checkbox" name="hobby" value="독서" class="form-check-input hobbyCheck"> 독서&nbsp;&nbsp;
			<input type="checkbox" name="hobby" value="음악감상" class="form-check-input hobbyCheck"> 음악감상<br>
			<label class="hobby text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">직업</th>
			<td class="p-3">
			<input type="radio" name="job" value="개발자" class="form-check-input jobCheck">개발자&nbsp;&nbsp;
			<input type="radio" name="job" value="사무직" class="form-check-input jobCheck">사무직&nbsp;&nbsp;
			<input type="radio" name="job" value="생산직" class="form-check-input jobCheck">생산직&nbsp;&nbsp;
			<input type="radio" name="job" value="기타" class="form-check-input jobCheck">기타&nbsp;&nbsp;
			<input type="radio" name="job" value="무직" class="form-check-input jobCheck">무직<br>
			<label class="job text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">나이</th>
			<td class="p-3">
			<input type="number" name="age" required class="form-control text-start">
			<label class="age text-danger"></label>
			</td>
		</tr>
		<tr>
			<th class="p-3 table-dark">자기소개</th>
			<td class="p-3">
			<textarea name="info" required class="form-control text-start" cols="100" >반갑습니다</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="회원가입" class="btn btn-dark" onclick="sendForm(form)"></td>
		</tr>
	</table>
</form>
<script type="text/javascript" src="${ctx }/script/Userjoin.js"></script>