let nameMsg = document.querySelector('.name');
let companyMsg = document.querySelector('.company');
let categoryMsg = document.querySelector('.category');
let priceMsg = document.querySelector('.price');
let usepeopleMsg = document.querySelector('.usepeople');
let total_qtyMsg = document.querySelector('.total_qty');

function sendForm(form){
	let name = form.name.value;
	let company = form.company.value;
	let price = form.price.value;
	let usepeople = form.usepeople.value;
	let total_qty = form.total_qty.value;
		
	nameMsg.textContent = '';
	companyMsg.textContent = '';
	categoryMsg.textContent = '';
	priceMsg.textContent = '';
	usepeopleMsg.textContent = '';
	total_qtyMsg.textContent = '';
		
	let category = document.querySelectorAll('.categoryCheck');
	
	let categoryChecked = false;
	
	for(let i=0; i<category.length; i++){
		if(category[i].checked) categoryChecked = true;
	}
	
	if(name.length==0){
		nameMsg.textContent = '이름을 입력해주세요';
		form.name.focus();
		return;
	}
	if(company.length==0){
		companyMsg.textContent = '차량 회사를 입력해주세요';
		form.company.focus();
		return;
	}
	
	if(!categoryChecked){
		categoryMsg.textContent = '차량 종류를 선택해주세요';
		return;
	}	
	
	if(price.length==0){
		priceMsg.textContent = '렌트 가격을 입력해주세요';
		form.price.focus();
		return;
	}else{
		if(price<1000){
			priceMsg.textContent = '렌트 가격은 1000원부터 가능합니다';
			form.price.focus();
			return;
		}
	}
	if(usepeople.length==0){
		usepeopleMsg.textContent = '승차 인원을 입력해주세요';
		form.usepeople.focus();
		return;
	}
	
	if(total_qty.length==0){
		total_qtyMsg.textContent = '렌트 가격을 입력해주세요';
		form.total_qty.focus();
		return;
	}else{
		if(total_qty>10){
			total_qtyMsg.textContent = '렌트 가능한 최대 수량은 10대입니다';
			form.total_qty.focus();
			return;
		}
	}

	form.submit();
}