let pwMsg = document.querySelector('.pw');
let hobbyMsg = document.querySelector('.hobby');
let ageMsg = document.querySelector('.age');

function sendForm(form, Userpw){
	let pw = form.pw.value;
	let age = form.age.value;
	
	pwMsg.textContent='';
	hobbyMsg.textContent = '';
	ageMsg.textContent = '';
		
	let hobby = document.querySelectorAll('.hobbyCheck');
	
	let hobbyChecked = false;
	
	for(let i=0; i<hobby.length; i++){
		if(hobby[i].checked) hobbyChecked = true;
	}
	
	if(pw.length==0){
		pwMsg.textContent = '비밀번호를 입력해주세요';
		form.pw.focus();
		return;
	}else{
		if(pw != Userpw){
			pwMsg.textContent = '비밀번호가 올바르지 않습니다';
			form.pw.focus();
			return;
		}
	}

	if(!hobbyChecked){
		hobbyMsg.textContent = '취미를 한 개 이상 선택해주세요';
		return;
	}
	
	if(age.length==0){
		ageMsg.textContent = '나이를 입력해주세요';
		form.age.focus();
		return;
	}else{
		if(age<18 || age>100){
			ageMsg.textContent = '18세 이상 100세 미만 가입 가능합니다';
			form.age.value='';
			form.age.focus();
			return;
		}
	}
	
	form.submit();
}
function deleteUser(form, Userpw, ctx, id){
	let pw = form.pw.value;
	
	pwMsg.textContent='';
	if(pw.length==0){
		pwMsg.textContent = '비밀번호를 입력해주세요';
		form.pw.focus();
		return;
	}else{
		if(pw != Userpw){
			pwMsg.textContent = '비밀번호가 올바르지 않습니다';
			form.pw.focus();
			return;
		}
	}
	
	location.href= ctx+'/deleteUser.do?id='+id;
}