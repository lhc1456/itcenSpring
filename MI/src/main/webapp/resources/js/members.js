/**
 * 
 */

function infoConfirm() {
	if(document.reg_frm.mId.value.length == 0 || document.reg_frm.mId.value.trim().length == 0) {
		alert("아이디는 필수사항입니다..");
		reg_frm.mId.focus();
		return;
	}
	
	if(document.reg_frm.mId.value.length < 4) {
		alert("아이디는 4자 이상 입력하세요.");
		reg_frm.mId.focus();
		return;
	}
	
	if(document.reg_frm.mPw.value.length == 0 || document.reg_frm.mPw.value.trim().length == 0) {
		alert("패스워드는 필수사항입니다..");
		reg_frm.mPw.focus();
		return;
	}
	
	if(document.reg_frm.mPw.value.length < 4) {
		alert("패스워드는 4자 이상입니다..");
		reg_frm.mPw.focus();
		return;
	}
	
	if(document.reg_frm.mPw.value != document.reg_frm.chkPw.value) {
		alert("패스워드가 일치하지 않습니다..");
		reg_frm.mPw.focus();
		return;
	}
	
	if(document.reg_frm.mName.value.length == 0) {
		alert("이름은 필수사항입니다..");
		reg_frm.mName.focus();
		return;
	}
	
	if(document.reg_frm.rrn01.value.length == 0) {
		alert("주민등록번호는 필수사항입니다..");
		reg_frm.rrn01.focus();
		return;
	}
	
	if(document.reg_frm.rrn01.value.length < 6 || document.reg_frm.rrn01.value.length > 6 ) {
		alert("주민등록번호 앞자리는 6자리입니다..");
		reg_frm.rrn01.focus();
		return;
	}
	
	if(isNaN(document.reg_frm.rrn01.value) || isNaN(document.reg_frm.rrn02.value) ) {
		alert("주민등록번호는 숫자만 입력 가능합니다.");
		reg_frm.rrn01.focus();
		return;
	}
	
	if(document.reg_frm.rrn02.value.length == 0) {
		alert("주민등록번호는 필수사항입니다..");
		reg_frm.rrn02.focus();
		return;
	}
	
	if(document.reg_frm.rrn02.value.length < 7 || document.reg_frm.rrn02.value.length > 7) {
		alert("주민등록번호 뒷자리는 7자리입니다..");
		reg_frm.rrn02.focus();
		return;
	}
	
	if(document.reg_frm.addr.value.length == 0) {
		alert("주소는 필수사항입니다..");
		reg_frm.addr.focus();
		return;
	}
	
	if(document.reg_frm.email01.value.length == 0) {
		alert("이메일은 필수사항입니다..");
		reg_frm.email01.focus();
		return;
	}
	if(document.reg_frm.email02.value.length == 0) {
		alert("메일은 필수사항입니다..");
		reg_frm.email02.focus();
		return;
	}
	
	if(checkEmail(document.reg_frm.email02.value)) {
		alert("메일 형식이 잘못되었습니다.")
		reg_frm.email02.focus();
		return;
	}
	
	if(document.reg_frm.phone02.value.length == 0) {
		alert("핸드폰은 필수사항입니다..");
		reg_frm.phone02.focus();
		return;
	}
	
	if(document.reg_frm.phone03.value.length == 0) {
		alert("핸드폰은 필수사항입니다..");
		reg_frm.phone03.focus();
		return;
	}
	
	if(isNaN(document.reg_frm.phone02.value) || isNaN(document.reg_frm.phone03.value)) {
		alert("핸드폰 번호는 숫자만 입력 가능합니다.");
		reg_frm.phone02.focus();
		return;
	}
	
	document.reg_frm.submit();
}

function adminInfoConfirm() {
	if(document.regF.aId.value.length == 0) {
		alert("아이디는 필수사항입니다..");
		reg_frm.mId.focus();
		return;
	}
	
	if(document.regF.aId.value.length < 4) {
		alert("아이디는 4자 이상 입력하세요.");
		regF.aId.focus();
		return;
	}
	
	if(document.regF.aPw.value.length == 0) {
		alert("패스워드는 필수사항입니다..");
		regF.aPw.focus();
		return;
	}
	
	if(document.regF.aPw.value.length < 4) {
		alert("패스워드는 4자 이상입니다..");
		regF.aPw.focus();
		return;
	}
	
	if(document.regF.aName.value.length == 0) {
		alert("이름은 필수사항입니다..");
		regF.aName.focus();
		return;
	}
	
	document.regF.submit();
}

function loginConfirm() {
	if(document.loginF.id.value.length == 0) {
		alert("아이디는 필수사항입니다..");
		loginF.id.focus();
		return;
	}
	
	if(document.loginF.id.value.length < 4) {
		alert("아이디는 4자 이상 입력하세요.");
		loginF.id.focus();
		return;
	}
	
	if(document.loginF.pw.value.length == 0) {
		alert("패스워드는 필수사항입니다..");
		loginF.pw.focus();
		return;
	}
	
	if(document.loginF.pw.value.length < 4) {
		alert("패스워드는 4자 이상입니다..");
		loginF.pw.focus();
		return;
	}
	
	document.loginF.submit()
}

function updateInfoConfirm() {
	if(document.modF.pw.value.length == 0) {
		alert("패스워드는 필수사항입니다..");
		modF.pw.focus();
		return;
	}
	
	if(document.modF.pw.value.length < 4) {
		alert("패스워드는 4자 이상입니다..");
		modF.pw.focus();
		return;
	}
	
	if(document.modF.pw.value != document.modF.chkPw.value) {
		alert("패스워드가 일치하지 않습니다..");
		modF.pw.focus();
		return;
	}
	
	if(document.modF.name.value.length == 0) {
		alert("이름은 필수사항입니다..");
		modF.name.focus();
		return;
	}
	
	if(document.modF.rrn01.value.length == 0) {
		alert("주민등록번호는 필수사항입니다..");
		modF.rrn01.focus();
		return;
	}
	
	if(document.modF.rrn01.value.length < 6 || document.modF.rrn01.value.length > 6 ) {
		alert("주민등록번호 앞자리는 6자리입니다..");
		modF.rrn01.focus();
		return;
	}
	
	if(isNaN(document.modF.rrn01.value) || isNaN(document.modF.rrn02.value) ) {
		alert("주민등록번호는 숫자만 입력 가능합니다.");
		modF.rrn01.focus();
		return;
	}
	
	if(document.modF.rrn02.value.length == 0) {
		alert("주민등록번호는 필수사항입니다..");
		modF.rrn02.focus();
		return;
	}
	
	if(document.modF.rrn02.value.length < 7 || document.modF.rrn02.value.length > 7) {
		alert("주민등록번호 뒷자리는 7자리입니다..");
		modF.rrn02.focus();
		return;
	}
	
	if(document.modF.addr.value.length == 0) {
		alert("주소는 필수사항입니다..");
		modF.addr.focus();
		return;
	}
	
	if(document.modF.email01.value.length == 0) {
		alert("이메일은 필수사항입니다..");
		modF.email01.focus();
		return;
	}
	if(document.modF.email02.value.length == 0) {
		alert("메일은 필수사항입니다..");
		modF.email02.focus();
		return;
	}
	
	if(checkEmail(document.modF.email02.value)) {
		alert("메일 형식이 잘못되었습니다.")
		modF.email02.focus();
		return;
	}
	
	if(document.modF.phone02.value.length == 0) {
		alert("핸드폰은 필수사항입니다..");
		modF.phone02.focus();
		return;
	}
	
	if(document.modF.phone03.value.length == 0) {
		alert("핸드폰은 필수사항입니다..");
		modF.phone03.focus();
		return;
	}
	
	if(isNaN(document.modF.phone02.value) || isNaN(document.modF.phone03.value)) {
		alert("핸드폰 번호는 숫자만 입력 가능합니다.");
		modF.phone02.focus();
		return;
	}
	
	document.modF.submit();
}

function searchId() {
	if(document.findF.name.value.length == 0) {
		alert("이름은 필수사항입니다..");
		modF.name.focus();
		return;
	}
	
	if(document.findF.rrn01.value.length == 0) {
		alert("주민등록번호는 필수사항입니다..");
		modF.rrn01.focus();
		return;
	}
	
	if(document.findF.rrn01.value.length < 6 || document.findF.rrn01.value.length > 6 || document.findF.rrn01.value.trim().length < 6 ) {
		alert("주민등록번호 앞자리는 6자리입니다..");
		modF.rrn01.focus();
		return;
	}
	
	if(isNaN(document.findF.rrn01.value) || isNaN(document.findF.rrn02.value) ) {
		alert("주민등록번호는 숫자만 입력 가능합니다.");
		modF.rrn01.focus();
		return;
	}
	
	if(document.findF.rrn02.value.length == 0) {
		alert("주민등록번호는 필수사항입니다..");
		modF.rrn02.focus();
		return;
	}
	
	if(document.findF.rrn02.value.length < 7 || document.findF.rrn02.value.length > 7 || document.findF.rrn02.value.trim().length < 7) {
		alert("주민등록번호 뒷자리는 7자리입니다..");
		modF.rrn02.focus();
		return;
	}
	
	$.ajax({
		url : 'findId',
		method : 'post',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data : {
			name : $("#name").val(),
			rrn01 : $("#rrn01").val(),
			rrn02 : $("#rrn02").val()
		},
		success : function(data) {
			console.log(data);
			if(data == '1') {
				window.open('/popup/showId', 'showID', 'width=400, height=200, location=no, resizeable=no, scrollbars=no');  
				document.location.href='/member/login_view';
				return;
			} else if(data == '0') {
				alert('일치하는 정보가 없습니다.');
				document.location.href='/member/login_view';
				return;
			} else {
				alert("잘못된 접근입니다.");
				document.location.href='/member/login_view';
				return;
			}
			
		}
	})
}

function searchPw() {
	if(document.findF.id.value.length == 0) {
		alert("아이디는 필수사항입니다..");
		loginF.id.focus();
		return;
	}
	
	if(document.findF.id.value.length < 4) {
		alert("아이디는 4자 이상 입력하세요.");
		loginF.id.focus();
		return;
	}
	
	if(document.findF.name.value.length == 0) {
		alert("이름은 필수사항입니다..");
		modF.name.focus();
		return;
	}
	
	if(document.findF.rrn01.value.length == 0) {
		alert("주민등록번호는 필수사항입니다..");
		modF.rrn01.focus();
		return;
	}
	
	if(document.findF.rrn01.value.length < 6 || document.findF.rrn01.value.length > 6 ) {
		alert("주민등록번호 앞자리는 6자리입니다..");
		modF.rrn01.focus();
		return;
	}
	
	if(isNaN(document.findF.rrn01.value) || isNaN(document.findF.rrn02.value) ) {
		alert("주민등록번호는 숫자만 입력 가능합니다.");
		modF.rrn01.focus();
		return;
	}
	
	if(document.findF.rrn02.value.length == 0) {
		alert("주민등록번호는 필수사항입니다..");
		modF.rrn02.focus();
		return;
	}
	
	if(document.findF.rrn02.value.length < 7 || document.findF.rrn02.value.length > 7) {
		alert("주민등록번호 뒷자리는 7자리입니다..");
		modF.rrn02.focus();
		return;
	}

	$.ajax({
		url : 'findPw',
		method : 'post',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data : {
			id : $("#id").val(),
			name : $("#name").val(),
			rrn01 : $("#rrn01").val(),
			rrn02 : $("#rrn02").val()
		},
		success : function(data) {
			if(data == '1') {
				window.open('/popup/showPw', 'showPW', 'width=400, height=200, location=no, resizeable=no, scrollbars=no');  
				document.location.href='/member/login_view';
				return;
			} else if(data == '0') {
				alert('일치하는 정보가 없습니다.');
				document.location.href='/member/login_view';
				return;
			} else {
				alert("잘못된 접근입니다.");
				document.location.href='/member/login_view';
				return;
			}
			
		}
	})
}

function modifyPw() {
	$('#modPw').prop('type', 'hidden');
	$('#pw').prop('type', 'password');
	$('#chkPw').prop('type', 'password');
}

function checkYes() {
	if($("#yes").is(':checked')) {
		document.noticeF.submit();
		return;
	} else {
		alert('전입신고 유의사항을 체크해주세요.');
		return;
	}
}

function checkStep1() {
	if(document.step1F.phone02.value.length == 0) {
		alert("핸드폰은 필수사항입니다.");
		step1F.phone02.focus();
		return;
	}
	
	if(document.step1F.phone03.value.length == 0) {
		alert("핸드폰은 필수사항입니다.");
		step1F.phone03.focus();
		return;
	}
	
	if(isNaN(document.step1F.phone02.value) || isNaN(document.step1F.phone03.value)) {
		alert("핸드폰 번호는 숫자만 입력 가능합니다.");
		step1F.phone02.focus();
		return;
	}
	
	if(document.step1F.reason.value == 0) {
		alert('전입 사유를 선택하세요.');
		return;
	}
	
	document.step1F.submit();
}

function checkStep2() {
	if($("#selectList").is(':checked')) {
		document.step2F.submit();
		return;
	} else {
		alert('전입 인원을 선택해주세요.');
		return;
	}
}

function checkStep3() {
	if(document.step3F.addr.value.length == 0) {
		alert("주소는 필수사항입니다..");
		step3F.addr.focus();
		return;
	}
	if(!$("input[name=howMI]:checked").val()) {
		alert("세대 유형을 선택해주세요.");
		return;
	}
	document.step3F.submit();
}

function allCheck() {
	if($("#allList").is(':checked')) {
		$("input[name=selectList]:not(:disabled)").prop("checked", true);
	} else {
		$("input[name=selectList]").prop("checked", false);
	}
}

function listCheck() {
	if($("input[name=selectList]:not(:disabled)").length == $("input[name=selectList]:checked").length) {
		$('#allList').prop("checked", true);
	} else {
		$('#allList').prop("checked", false);
	}
}

function setEmail() {
	if(document.title =='Sign-Up'){
		if(document.reg_frm.selectEmail.options[document.reg_frm.selectEmail.selectedIndex].value == '0') {
			document.reg_frm.email02.disabled = true;
			document.reg_frm.email02.value = "";
		} else if(document.reg_frm.selectEmail.options[document.reg_frm.selectEmail.selectedIndex].value == '1') {
			document.reg_frm.email02.disabled = false;
			document.reg_frm.email02.value = "";
		} else {
			document.reg_frm.email02.disabled = true;
			document.reg_frm.email02.value = document.reg_frm.selectEmail.options[document.reg_frm.selectEmail.selectedIndex].value;
		}
	} else if(document.title='Modify') {
		if(document.modF.selectEmail.options[document.modF.selectEmail.selectedIndex].value == '0') {
			document.modF.email02.disabled = true;
			document.modF.email02.value = "";
		} else if(document.modF.selectEmail.options[document.modF.selectEmail.selectedIndex].value == '1') {
			document.modF.email02.disabled = false;
			document.modF.email02.value = "";
		} else {
			document.modF.email02.disabled = true;
			document.modF.email02.value = document.modF.selectEmail.options[document.modF.selectEmail.selectedIndex].value;
		}
	}
}

function keyupPw() {
	document.getElementById('checkPw').innerHTML = "";
}

function checkPw() {
	if(document.title =='Sign-Up'){
		if(document.reg_frm.mPw.value == document.reg_frm.chkPw.value) {
			document.getElementById('checkPw').innerHTML = "비밀번호가 일치합니다.";
			document.getElementById('checkPw').style.color = 'blue';
		} else {
			document.getElementById('checkPw').innerHTML = "비밀번호가 일치하지 않습니다.";
			document.getElementById('checkPw').style.color = 'red';
		}
	} else if(document.title='Modify') {
		if(document.modF.pw.value == document.modF.chkPw.value) {
			document.getElementById('checkPw').innerHTML = "비밀번호가 일치합니다.";
			document.getElementById('checkPw').style.color = 'blue';
		} else {
			document.getElementById('checkPw').innerHTML = "비밀번호가 일치하지 않습니다.";
			document.getElementById('checkPw').style.color = 'red';
		}
	}
}

function isLogin() {
	if(document.mainF.id.value.length != 0) {
		document.mainF.submit();
	} else {
		alert("로그인이 필요합니다.");
		window.location = "/member/login_view";
		return;
	}
}

function checkEmail(str) {
	var reg_email = /^([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/i;

	if(reg_email.test(str)) {
		return false;
	} else {
		return true;
	}
	
}

function popupRR() {
	var url = "/popup/RateReduction";
	var name = "rate";
	var option = "width = 700, height= 500, location=no scrollbars=yes";
	window.open(url, name, option);
}

function popupBN() {
	var url = "/popup/BuildingNum";
	var name = "BuildingNumber";
	var option = "width = 500, height = 400, location=no, resizeable=no, scrollbars=no";
	window.open(url, name, option);
}

function popupMF() {
	var url = "/popup/MultiFamily";
	var name="MultiFamily";
	var option = "width=400, height=200, location=no, resizeable=no, scrollbars=no";
	window.open(url, name, option);
}

function withdrawalMember() {
	if(confirm("회원 탈퇴 하시겠습니까?")) {//확인
		document.withdrawalF.submit();
		return; 
	} else {
		return false;
	}
}

function withdrawalAdmin() {
	if(confirm("관리자 탈퇴 하시겠습니까?")) {//확인
		document.withdrawalF.submit();
		return; 
	} else {
		return false;
	}
}

function checkDel() {
	if(confirm("정말 삭제하시겠습니까?")) {
		document.delF.submit();
		return;
	} else {
		return false;
	}
}

function acceptState(ren) {
	var state = $('input[name=accept]').val();
	console.log($('input[name=accept]').val());
	if(confirm("승인하시겠습니까?")) {
		$('input[name=hidRen]').val(ren+0);
		$('input[name=hidState]').val("승인");
		document.stateF.submit();
		return;
	} else {
		return false;
	}
}

function denyState(ren) {
	var state = $('input[name=deny]').val();
	if(confirm("반려하시겠습니까?")) {
		$('input[name=hidRen]').val(ren+0);
		$('input[name=hidState]').val("반려");
		document.stateF.submit();
		return;
	} else {
		return false;
	}
}

$('document').ready(function() {
	var area0 = ["시도 선택","서울특별시","부산광역시","대구광역시","인천광역시","광주광역시","대전광역시","울산광역시","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주특별자치도", "세종특별자치시"];
	var area1 = ["시군구 선택","종로구","중구","용산구","성동구","광진구","동대문구","중랑구","성북구","강북구","도봉구","노원구","은평구","서대문구","마포구","양천구","강서구","구로구","금천구","영등포구","동작구","관악구","서초구","강남구","송파구","강동구"];
	var area2 = ["시군구 선택","중구","서구","동구","영도구","부산진구","동래구","남구","북구","해운대구","사하구","금정구","강서구","연제구","수영구","사상구","기장군"];
	var area3 = ["시군구 선택","중구","동구","서구","남구","북구","수성구","달서구","달성군"];
	var area4 = ["시군구 선택","중구","동구","연수구","남동구","부평구","계양구","서구","미추홀구","강화군","옹진군"];
	var area5 = ["시군구 선택","동구","서구","남구","북구","광산구"];
	var area6 = ["시군구 선택","동구","중구","서구","유성구","대덕구"];
	var area7 = ["시군구 선택","중구","남구","동구","북구","울주군"];
	var area8 = ["시군구 선택","수원시 장안구","수원시 권선구","수원시 팔달구","수원시 영통구","성남시 수정구","성남시 중원구","성남시 분당구","의정부시","안양시 만안구","안양시 동안구","부천시","광명시","평택시","동두천시","안산시 상록구","안산시 단원구","고양시 덕양구","고양시 일산동구","고양시 일산서구","과천시","구리시","남양주시","오산시","시흥시","군포시","의왕시","하남시","용인시 처인구","용인시 기흥구","용인시 수지구","파주시","이천시","안성시","김포시","화성시","광주시","양주시","포천시","여주시","연천군","가평군","양평군"];
	var area9 = ["시군구 선택","춘천시","원주시","강릉시","동해시","태백시","속초시","삼척시","홍천군","횡성군","영월군","평창군","정선군","철원군","화천군","양구군","인제군","고성군","양양군"];
	var area10 = ["시군구 선택","충주시","제천시","청주시 상당구","청주시 서원구","청주시 흥덕구","청주시 청원구","보은군","옥천군","영동군","진천군","괴산군","음성군","단양군","증평군"];
	var area11 = ["시군구 선택","천안시 동남구","천안시 서북구","공주시","보령시","아산시","서산시","논산시","계룡시","당진시","금산군","부여군","서천군","청양군","홍성군","예산군","태안군"];
	var area12 = ["시군구 선택","전주시 완산구","전주시 덕진구","군산시","익산시","정읍시","남원시","김제시","완주군","진안군","무주군","장수군","임실군","순창군","고창군","부안군"];
	var area13 = ["시군구 선택","목포시","여수시","순천시","나주시","광양시","담양군","곡성군","구례군","고흥군","보성군","화순군","장흥군","강진군","해남군","영암군","무안군","함평군","영광군","장성군","완도군","진도군","신안군"];
	var area14 = ["시군구 선택","포항시 남구","포항시 북구","경주시","김천시","안동시","구미시","영주시","영천시","상주시","문경시","경산시","군위군","의성군","청송군","영양군","영덕군","청도군","고령군","성주군","칠곡군","예천군","봉화군","울진군","울릉군"];
	var area15 = ["시군구 선택","진주시","통영시","사천시","김해시","밀양시","거제시","양산시","창원시 의창구","창원시 성산구","창원시 마산합포구","창원시 마산회원구","창원시 진해구","의령군","함안군","창녕군","고성군","남해군","하동군","산청군","함양군","거창군","합천군"];
	var area16 = ["시군구 선택","제주시","서귀포시"];
	var area17 = ["시군구 선택", "세종특별자치시"];
	

 // 시/도 선택 박스 초기화
	$("select[name^=sido]").each(function() {
		$selsido = $(this);
		$.each(eval(area0), function() {
			$selsido.append("<option value='"+this+"'>"+this+"</option>");
		});
		$selsido.next().append("<option value=''>시군구 선택</option>");
	});
	
	// 시/도 선택시 구/군 설정
	$("select[name^=sido]").change(function() {
		var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 구군 Array
		var $gugun = $(this).next(); // 선택영역 군구 객체
		$("option",$gugun).remove(); // 구군 초기화
	
		if(area == "area0")
			$gugun.append("<option value=''>시군구 선택</option>");
		else {
			$.each(eval(area), function() {
				$gugun.append("<option value='"+this+"'>"+this+"</option>");
			});
		}
	});
});

function checkAddr() {
	if($("#sido option:selected").val() == "시도 선택" || $("#gugun option:selected").val() == "시군구 선택" || $("#gugun option:selected").val() == "") {
		alert('신청인의 정보가 해당 시군구에 존재하지 않습니다.\n 다시 조회하여 주십시오.');
		return;
	}
	$.ajax({
		url : 'checkAddr',
		method : 'post',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data : {
			sido : $("#sido option:selected").val(),
			gugun : $("#gugun option:selected").val()
		},
		success : function(data) {
			if(data == '1') {
				$('#addr_lb').text($('#addr').val());
				$('#dAddr_lb').text($('#dAddr').val());
				document.getElementById('movMem').style.display = 'block';
			} else if(data == '0') {
				alert('신청인의 정보가 해당 시군구에 존재하지 않습니다.\n 다시 조회하여 주십시오.');
				return;
			}
			
		}
	})
}

function setMF() {
	if(document.getElementById('mfSelect').options[document.getElementById('mfSelect').selectedIndex].value == '아니요' || document.getElementById('mfSelect').options[document.getElementById('mfSelect').selectedIndex].value == '모름') {
		document.getElementById('mfInput').disabled = true;
		document.getElementById('mfInput').value = "";
	} else if(document.getElementById('mfSelect').options[document.getElementById('mfSelect').selectedIndex].value == '예') {
		document.getElementById('mfInput').disabled = false;
		document.getElementById('mfInput').value = "";
	}
}

//<input type="text" id="sample6_postcode" placeholder="우편번호">
//<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
//<input type="text" id="sample6_address" placeholder="주소"><br>
//<input type="text" id="sample6_detailAddress" placeholder="상세주소">
//<input type="text" id="sample6_extraAddress" placeholder="참고항목">

function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
//                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
//                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
//            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("addr").value = addr;
            document.getElementById("sigunguCode").value = data.sigunguCode;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("dAddr").focus();
        }
    }).open();
}

