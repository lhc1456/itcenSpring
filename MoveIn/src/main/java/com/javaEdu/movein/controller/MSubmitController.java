package com.javaEdu.movein.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaEdu.movein.service.MCheckAddrService;
import com.javaEdu.movein.service.MDeleteService;
import com.javaEdu.movein.service.MDetailService;
import com.javaEdu.movein.service.MListMoveInService;
import com.javaEdu.movein.service.MListService;
import com.javaEdu.movein.service.MLoginService;
import com.javaEdu.movein.service.MLogoutService;
import com.javaEdu.movein.service.MNotImplService;
import com.javaEdu.movein.service.MService;
import com.javaEdu.movein.service.MSignupService;
import com.javaEdu.movein.service.MSubmitService;
import com.javaEdu.movein.service.MUpdateMemberService;
import com.javaEdu.movein.service.MUpdateStateService;
import com.javaEdu.movein.service.MWithdrawalService;


@Controller
public class MSubmitController {
	
	MService service = null;
	
	@RequestMapping("/notice")
	public String notice(Model model) {
		
		return "Notice";
	}
	
	@RequestMapping(value = "/step1", method = RequestMethod.POST)
	public String step1(HttpServletRequest request, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		model.addAttribute("request", request);
		service = new MDetailService();
		service.execute(model);
		
		return "step1";
	}
	
	@RequestMapping(value = "/step2", method = RequestMethod.POST)
	public String step2(HttpServletRequest request, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		model.addAttribute("request", request);
		service = new MDetailService();
		service.execute(model);
		
		return "step2";
	}
	
	@RequestMapping(value = "/step3", method = RequestMethod.POST)
	public String step3(HttpServletRequest request, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		model.addAttribute("request", request);
		service = new MDetailService();
		service.execute(model);
		
		return "step3";
	}
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public void submit(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		service = new MSubmitService();
		service.execute(model);
		
		return;
	}
	
	@RequestMapping(value = "/checkAddr", method = RequestMethod.POST)
	public void checkAddr(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		service = new MCheckAddrService();
		service.execute(model);
		
		return;
	}
	
	
	@RequestMapping("/popup/BuildingNum")
	public String popupBN(Model model) {
		return "popup/BuildingNum";
	}
	
	@RequestMapping("/popup/MultiFamily")
	public String popupMF(Model model) {
		return "popup/MultiFamily";
	}
	
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		return "errors/viewError";
	}

}
