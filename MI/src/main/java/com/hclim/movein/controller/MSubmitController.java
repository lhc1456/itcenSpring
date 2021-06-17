package com.hclim.movein.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hclim.movein.VO.AddrCodeVO;
import com.hclim.movein.VO.MemberVO;
import com.hclim.movein.VO.MoveInVO;
import com.hclim.movein.service.MAddrCodeService;
import com.hclim.movein.service.MAdminService;
import com.hclim.movein.service.MMoveInService;
import com.hclim.movein.service.MUserService;

@Controller("submitController")
@RequestMapping("/submit")
public class MSubmitController {

	@Inject
	private MUserService userService;

	@Inject
	private MAdminService adminService;

	@Inject
	private MAddrCodeService addrCodeSerivce;

	@Inject
	private MMoveInService moveinService;

	@RequestMapping("/notice")
	public String notice(Model model) {
		return "/submit/Notice";
	}
	
	@RequestMapping(value = {"/step1", "/step2", "/step3", "/submit"}, method = RequestMethod.GET)
	public String submitProcessGet() {
		return "redirect:/";
	}

	@RequestMapping(value = "/step1", method = RequestMethod.POST)
	public String step1(MemberVO vo, HttpSession session, Model model) throws IOException {
		vo.setMId((String) session.getAttribute("id"));

		model.addAttribute("dMember", userService.getMember(vo));

		return "/submit/step1";
	}

	@RequestMapping(value = "/step2", method = RequestMethod.POST)
	public String step2(MemberVO vo, HttpSession session, Model model) throws IOException {
		vo.setMId((String) session.getAttribute("id"));

		model.addAttribute("dMember", userService.getMember(vo));

		return "/submit/step2";
	}

	@RequestMapping(value = "/step3", method = RequestMethod.POST)
	public String step3(MemberVO vo, HttpSession session, Model model) throws IOException {
		vo.setMId((String) session.getAttribute("id"));

		model.addAttribute("dMember", userService.getMember(vo));

		return "/submit/step3";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(MoveInVO vo, String sigunguCode, Model model) throws IOException {
		vo.toString();
		vo.setSigungu(sigunguCode);
		moveinService.insertMoveIn(vo);

		return "redirect:/";
	}

//	
	@RequestMapping(value = "/checkAddr", method = RequestMethod.POST)
	public void checkAddr(AddrCodeVO vo, HttpSession session, HttpServletResponse response, Model model)
			throws IOException {

		vo = addrCodeSerivce.getAddrCode(vo);

		MemberVO memberVO = new MemberVO();
		memberVO.setMId((String) session.getAttribute("id"));
		memberVO = userService.getMember(memberVO);

		if (vo.getCode().equals(memberVO.getSigunguCode())) {
			PrintWriter writer = response.getWriter();
			writer.print("1");
			return;
		} else {
			PrintWriter writer = response.getWriter();
			writer.print("0");
			return;
		}
	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		return "/errors/viewError";
	}
}