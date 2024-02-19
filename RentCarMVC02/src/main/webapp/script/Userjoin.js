let check =0;
let idMsg = document.querySelector('.id');
let pwMsg = document.querySelector('.pw');
let emailMsg = document.querySelector('.email');
let telMsg = document.querySelector('.tel');
let hobbyMsg = document.querySelector('.hobby');
let jobMsg = document.querySelector('.job');
let ageMsg = document.querySelector('.age');

function sendForm(form){
let id = form.id.value;
let pw = form.pw.value;
let email = form.email.value;
let tel = form.tel.value;
let age = form.age.value;
		
	idMsg.textContent = '';
	pwMsg.textContent = '';
	emailMsg.textContent = '';
	telMsg.textContent = '';
	hobbyMsg.textContent = '';
	jobMsg.textContent = '';
	ageMsg.textContent = '';
		
	
	let hobby = document.querySelectorAll('.hobbyCheck');
	let job = document.querySelectorAll('.jobCheck');
	
	let hobbyChecked = false;
	let jobChecked = false;
	
	for(let i=0; i<hobby.length; i++){
		if(hobby[i].checked) hobbyChecked = true;
	}
	for(let i=0; i<job.length; i++){
		if(job[i].checked) jobChecked = true;
	}
	
	
	if(id.length==0){
		idMsg.textContent = '아이디를 입력해주세요';
		form.id.focus();
		return;
	}else{
		if(id.length<4){
			idMsg.textContent = '아이디는 4글자이상 입력해주세요';
			form.id.focus();
			return;
		}
	}
	
	if(pw.length==0){
		pwMsg.textContent = '비밀번호를 입력해주세요';
		form.pw.focus();
		return;
	}else{
		if(pw.length<4){
			pwMsg.textContent = '비밀번호는 4글자이상 입력해주세요';
			form.pw.focus();
			return;
		}
	}
	
	if(email.length==0){
		emailMsg.textContent = '이메일을 입력해주세요';
		form.email.focus();
		return;
	}else{
		if(!email.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/)){
			emailMsg.textContent = '올바른 이메일 형식이 아닙니다';
			return;
		}
	}
	
	if(tel.length==0){
		telMsg.textContent = '전화번호를 입력해주세요';
		form.tel.focus();
		return;
	}else{
		if(!tel.includes('-')){
			telMsg.textContent = '올바른 전화번호 형식이 아닙니다';
			return;
		}
	}
	

	if(!hobbyChecked){
		hobbyMsg.textContent = '취미를 한 개 이상 선택해주세요';
		return;
	}
	
	
	if(!jobChecked){
		jobMsg.textContent = '직업을 선택해주세요';
		return;
	}
	
	
	if(age.length==0){
		ageMsg.textContent = '나이를 입력해주세요';
		form.age.focus();
		return;
	}else{
		if(age<18 || age>100){
			ageMsg.textContent = '18세 이상 100세 이하 가입 가능합니다';
			form.age.value='';
			form.age.focus();
			return;
		}
	}
	
	if(check ===0 || check===-1){
		idMsg.textContent = '아이디 중복체크 해주세요';
		form.id.focus();
		return;
	}
	
	form.submit();
}
function autoHyphen(form){
 	form.tel.value = form.tel.value
   	.replace(/[^0-9]/g, '')
   	.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}

function idCheck(form){
	idMsg.textContent = '';
	let id = form.id.value;
	
	if(id.length==0){
		alert('id 값을 입력해주세요');
		form.id.focus();
		return;
	}else{
		if(id.length<4){
			idMsg.textContent = '아이디는 4글자이상 입력해주세요';
			form.id.focus();
			return;
		}
	}
	
	fetch("idCheck.do", {
		method : "POST",
		headers : {"Content-Type" : "application/x-www-form-urlencoded; charset=UTF-8"},
		body : "id="+id,
	})
	.then(response => response.text())
	.then(getResult)
	.catch(()=>alert('error'));

}

function getResult(data){
	let checkBtn =  document.querySelector(".checkBtn");
	if(data == "valid"){
		checkBtn.value="확인완료";
		checkBtn.classList.remove("btn-secondary");
		checkBtn.classList.add("btn-success");
		check = 1;
	}else if(data == "notValid"){
		idMsg.textContent = '이미 사용중인 아이디입니다';
		checkBtn.value="중복체크";
		checkBtn.classList.remove("btn-success");
		checkBtn.classList.add("btn-secondary");
		check= -1;
	}
}
document.querySelector("#id").addEventListener("keyup", (e)=> {
	idMsg.textContent = '';
    if (e.keyCode === 8) {
      check = 0;
    }
    let checkBtn =  document.querySelector(".checkBtn");
	checkBtn.value="중복체크";
	checkBtn.classList.remove("btn-success");
	checkBtn.classList.add("btn-secondary");
});