package com.hclim.movein.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hclim.movein.VO.AdminVO;
import com.hclim.movein.VO.MemberVO;
import com.hclim.movein.VO.MoveInVO;
import com.hclim.movein.service.MAdminService;
import com.hclim.movein.service.MMoveInService;
import com.hclim.movein.service.MUserService;

@Controller("userController")
@RequestMapping("/member")
public class MUserController {

	@Inject
	private MUserService userService;

	@Inject
	private MAdminService adminService;

	@Inject
	private MMoveInService moveinService;

	@RequestMapping("/main")
	public String main() {
		return "/member/Main";
	}

	@RequestMapping("/login_view")
	public String login_view(Model model) {
		return "/member/Login";
	}

	@RequestMapping("/signup_view")
	public String signup_view(Model model) {
		return "/member/Signup";
	}

	@RequestMapping("/findId_view")
	public String findId_view(Model model) throws IOException {
		return "/member/findId";
	}

	@RequestMapping("/findPw_view")
	public String findPw_view(Model model) throws IOException {
		return "/member/findPw";
	}

	@RequestMapping("/addAdmin_view")
	public String addAdmin_view(Model model) {
		return "/member/addAdmin";
	}

	@RequestMapping("/withdrawal_view")
	public String withdrawal_view(Model model) {
		return "/member/withdrawal";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();

		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String who, String id, String pw, HttpSession session, Model model) throws IOException {
		System.out.println(who);
		if (who.equals("member")) {
			MemberVO login = new MemberVO();
			login.setMId(id);
			login.setMPw(pw);
			if (userService.userCheck(login) == null || "".equals(userService.userCheck(login))) {
				return "redirect:/member/login_view";
			} else {
				login = userService.getMember(login);
				session.setAttribute("id", login.getMId());
				session.setAttribute("name", login.getMName());
				session.setAttribute("who", "member");
			}

		} else if (who.equals("admin")) {
			AdminVO login = new AdminVO();
			login.setAId(id);
			login.setAPw(pw);
			if (adminService.userCheck(login) == null) {
				return "redirect:/member/login_view";
			} else {
				login = adminService.getAdmin(login);
				session.setAttribute("id", login.getAId());
				session.setAttribute("name", login.getAId());
				session.setAttribute("who", "admin");
			}
		} else {
			return "redirect:/member/login_view";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(MemberVO vo, String selectEmail, Model model) throws IOException {
		if (vo.getEmail02() == null) {
			vo.setEmail02(selectEmail);
		}
		if (userService.confirmId(vo) == null) {
			userService.insertMember(vo);
			return "redirect:/";
		} else {
			return "redirect:signup_view";
		}
	}

	@RequestMapping("/page")
	public String page(MoveInVO vo, HttpSession session, Model model) throws IOException {
		String who = (String) session.getAttribute("who");

		if (who.equals("member")) {
			vo.setMId((String) session.getAttribute("id"));

			List<MoveInVO> moveIn = moveinService.getMoveInList(vo);
			model.addAttribute("moveIn", moveIn);

		} else if (who.equals("admin")) {
			List<MoveInVO> moveIn = moveinService.listMoveIn();

			model.addAttribute("moveIn", moveIn);

		} else {
			return "redirect:/";
		}

		return "/member/page";
	}

	@RequestMapping("/memberList")
	public String memberList(HttpSession session, Model model) throws IOException {
		session.setAttribute("list", "member");

		model.addAttribute("memberList", userService.listMember());

		return "/member/list";
	}

	@RequestMapping("/detailMember")
	public String detailMember(MemberVO vo, HttpSession session, Model model) throws IOException {

		vo.setMId((String) session.getAttribute("id"));

		model.addAttribute("dMember", userService.getMember(vo));

		return "/member/detailMember";
	}

	@RequestMapping("/modifyMember_view")
	public String modifyMember_view(MemberVO vo, HttpSession session, Model model) throws IOException {
		vo.setMId((String) session.getAttribute("id"));

		model.addAttribute("dMember", userService.getMember(vo));

		return "/member/modifyMember";
	}

	@RequestMapping(value = "/modifyMember", method = RequestMethod.POST)
	public String modifyMember(MemberVO vo, String selectEmail, Model model) throws IOException {
		if (vo.getEmail02() == null) {
			vo.setEmail02(selectEmail);
		}

		userService.updateMember(vo);

		return "redirect:/member/detailMember";
	}

	@RequestMapping("/withdrawalMember")
	public String withdrawalMember(MemberVO vo, HttpSession session, Model model) throws IOException {
		String id = (String) session.getAttribute("id");
		vo.setMId(id);
		userService.deleteMember(vo);

		return "redirect:/member/logout";
	}

	@RequestMapping(value = "/deleteMemberList", method = RequestMethod.POST)
	public String deleteMemberList(MemberVO vo, String[] selectList, Model model) throws IOException {

		for (int i = 0; i < selectList.length; i++) {
			vo.setMId(selectList[i]);
			userService.deleteMember(vo);
		}

		return "redirect:/member/memberList";
	}

	@RequestMapping("/adminList")
	public String adminList(HttpSession session, Model model) throws IOException {

		session.setAttribute("list", "admin");

		model.addAttribute("adminList", adminService.listAdmin());

		return "/member/list";
	}

	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public String addAdmin(AdminVO vo, Model model) throws IOException {

		if (adminService.confirmId(vo) == null) {
			adminService.insertAdmin(vo);
		}

		return "redirect:/member/adminList";
	}

	@RequestMapping("/withdrawalAdmin")
	public String withdrawalAdmin(AdminVO vo, HttpSession session, Model model) throws IOException {
		String id = (String) session.getAttribute("id");
		vo.setAId(id);
		adminService.deleteAdmin(vo);

		return "redirect:/member/logout";
	}

	@RequestMapping(value = "/deleteAdminList", method = RequestMethod.POST)
	public String deleteAdminList(AdminVO vo, String[] selectList, Model model) throws IOException {
		for (int i = 0; i < selectList.length; i++) {
			vo.setAId(selectList[i]);
			adminService.deleteAdmin(vo);
		}
		return "redirect:/member/adminList";
	}

	@RequestMapping(value = "/updateState", method = RequestMethod.POST)
	public String updateState(MoveInVO vo, int hidRen, String hidState, Model model) throws IOException {
		vo.setRen(hidRen);
		if (hidState.equals("승인")) {
			hidState = "처리완료";
			vo.setState(hidState);
			moveinService.updateMoveIn(vo);
			vo = moveinService.getMoveIn(vo);

			MemberVO memberVO = new MemberVO();
			memberVO.setMId(vo.getMId());
			memberVO = userService.getMember(memberVO);

			memberVO.setAddr(vo.getAfterAddr());
			memberVO.setDAddr(vo.getAfterdAddr());
			memberVO.setSigunguCode(vo.getSigungu());

			userService.updateMember(memberVO);
		} else if (hidState.equals("반려")) {
			hidState = "반려됨";
			vo.setState(hidState);
			moveinService.updateMoveIn(vo);
		}

		return "redirect:/member/page";
	}

	@RequestMapping("/findId")
	public void findId(String name, String rrn01, String rrn02, HttpSession session, HttpServletResponse response,
			Model model) throws IOException {

		MemberVO vo = new MemberVO();
		vo.setMName(name);
		vo.setRrn01(rrn01);
		vo.setRrn02(rrn02);

		String id = userService.findId(vo);

		if (id == null) {
			PrintWriter writer = response.getWriter();
			writer.print("0");
			return;
		} else {
			session.setAttribute("findId", id);
			session.setAttribute("findName", vo.getMName());
			PrintWriter writer = response.getWriter();
			writer.print("1");
			return;
		}

	}

	@RequestMapping("/findPw")
	public void findPw(String id, String name, String rrn01, String rrn02, HttpSession session,
			HttpServletResponse response, Model model) throws IOException {
		MemberVO vo = new MemberVO();
		vo.setMId(id);
		vo.setMName(name);
		vo.setRrn01(rrn01);
		vo.setRrn02(rrn02);

		String pw = userService.findPw(vo);

		if (pw == null) {
			PrintWriter writer = response.getWriter();
			writer.print("0");
			return;
		} else {
			session.setAttribute("findPw", pw);
			session.setAttribute("findName", vo.getMName());
			PrintWriter writer = response.getWriter();
			writer.print("1");
			return;
		}

	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		return "/errors/viewError";
	}
}
