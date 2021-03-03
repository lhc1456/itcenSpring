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
public class MUserController {
	
	MService service = null;
	
	@RequestMapping("/main")
	public String main(Model model) {
		return "Main";
	}
	
	@RequestMapping("/login_view")
	public String login_view(Model model) {
		return "Login";
	}
	
	@RequestMapping("/signup_view")
	public String signup_view(Model model) {
		return "Signup";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		service = new MLoginService();
		service.execute(model);
		
		return ;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public void signup(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("who", "member");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		service = new MSignupService();
		service.execute(model);
		
		return;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		model.addAttribute("request", request);
		service = new MLogoutService();
		service.execute(model);
		
		return "redirect:main";
	}
	
	@RequestMapping("/page")
	public String page(HttpServletRequest request, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		model.addAttribute("request", request);
		service = new MListMoveInService();
		service.execute(model);
		
		return "page";
	}
	
	@RequestMapping("/memberList")
	public String memberList(HttpServletRequest request, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("list", "member");
		model.addAttribute("request", request);
		service = new MListService();
		service.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/adminList")
	public String adminList(HttpServletRequest request, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("list", "admin");
		model.addAttribute("request", request);
		service = new MListService();
		service.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/withdrawal_view")
	public String withdrawal_view(Model model) {
		return "withdrawal";
	}
	
	@RequestMapping("/withdrawalMember")
	public void withdrawalMember(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("who", "member");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		service = new MWithdrawalService();
		service.execute(model);
		
		return ;
	}
	
	@RequestMapping("/withdrawalAdmin")
	public void withdrawalAdmin(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("who", "admin");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		service = new MWithdrawalService();
		service.execute(model);
		
		return;
	}
	
	@RequestMapping("/detailMember")
	public String detailMember(HttpServletRequest request, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		model.addAttribute("request", request);
		service = new MDetailService();
		service.execute(model);
		
		return "detailMember";
	}
	
	@RequestMapping("/addAdmin_view")
	public String addAdmin_view(Model model) {
		return "addAdmin";
	}
	
	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public String addAdmin(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("who", "admin");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		service = new MSignupService();
		service.execute(model);
		
		return "redirect:adminList";
	}
	
	@RequestMapping(value = "/deleteMemberList", method = RequestMethod.POST)
	public void deleteMemberList(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("list", "member");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		service = new MDeleteService();
		service.execute(model);
		
		return;
	}
	
	@RequestMapping(value = "/deleteAdminList", method = RequestMethod.POST)
	public void deleteAdminList(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("list", "admin");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		service = new MDeleteService();
		service.execute(model);
		
		return;
	}
	
	@RequestMapping("/modifyMember_view")
	public String modifyMember_view(HttpServletRequest request, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		model.addAttribute("request", request);
		service = new MDetailService();
		service.execute(model);
		
		return "modifyMember";
	}
	
	@RequestMapping(value = "/modifyMember", method = RequestMethod.POST)
	public void modifyMember(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		service = new MUpdateMemberService();
		service.execute(model);
		
		return;
	}
	
	@RequestMapping(value = "/updateState", method = RequestMethod.POST)
	public void updateState(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		service = new MUpdateStateService();
		service.execute(model);
		
		return;	
	}
	
	@RequestMapping("/popup/RateReduction")
	public String popupRR(Model model) {
		return "popup/RateReduction";
	}
	
	@RequestMapping("/findId_view")
	public String findId_view(HttpServletResponse response, Model model) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		model.addAttribute("response", response);
		service = new MNotImplService();
		service.execute(model);
		
		return "redirect:login_view";
	}
	
	@RequestMapping("/findPw_view")
	public String findPw_view(HttpServletResponse response, Model model) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		model.addAttribute("response", response);
		service = new MNotImplService();
		service.execute(model);
		
		return "redirect:login_view";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		return "errors/viewError";
	}

}
