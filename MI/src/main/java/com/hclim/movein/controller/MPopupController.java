package com.hclim.movein.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("popupController")
@RequestMapping("/popup")
public class MPopupController {

	// 요금 감면 혜택 팝업
	@RequestMapping("/RateReduction")
	public String popupRR(Model model) {
		return "/popup/RateReduction";
	}

	// 건물 번호란? 팝업
	@RequestMapping("/BuildingNum")
	public String popupBN(Model model) {
		return "/popup/BuildingNum";
	}

	// 다가구 주택이란? 팝업
	@RequestMapping("/MultiFamily")
	public String popupMF(Model model) {
		return "/popup/MultiFamily";
	}

	// 아이디 찾기 결과 팝업
	@RequestMapping("/showId")
	public String showId(Model model) {
		return "/popup/showId";
	}

	// 비밀번호 찾기 결과 팝업
	@RequestMapping("/showPw")
	public String showPw(Model model) {
		return "/popup/showPw";
	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		return "/errors/viewError";
	}
}
