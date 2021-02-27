package com.javaEdu.movein.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.javaEdu.movein.dao.AdminDAO;
import com.javaEdu.movein.dao.MemberDAO;
import com.javaEdu.movein.dto.AdminDTO;
import com.javaEdu.movein.dto.MemberDTO;


public class MLoginService implements MService {

	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		String who = request.getParameter("who");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(who.equals("admin")) {
			AdminDAO dao = AdminDAO.getInstance();
			
			int checkNum = dao.userCheck(id, pw);
			if(checkNum == -1) {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('아이디가 존재하지 않습니다.');	history.go(-1);</script>");
				writer.flush();
				writer.close();
				return;
			} else if(checkNum == 0) {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('비밀번호가 틀립니다.');	history.go(-1);</script>");
				writer.flush();
				writer.close();
				return;
			} else if(checkNum == 1) {
				AdminDTO dto = dao.getAdmin(id);
				if(dto == null) {
					PrintWriter writer = response.getWriter();
					writer.println("<script>alert('존재하지 않는 회원입니다.');	history.go(-1);</script>");
					writer.flush();
					writer.close();
					return;
				} else {
					String name = dto.getaName();
					request.getSession().setAttribute("id", id);
					request.getSession().setAttribute("name", name);
					request.getSession().setAttribute("who", "admin");
					PrintWriter writer = response.getWriter();
					writer.println("<script>alert('"+ name +"님 환영합니다.');	document.location.href='main';</script>");
					writer.flush();
					writer.close();
					return;
				}
			}
		} else if(who.equals("member") ) {
			MemberDAO dao = MemberDAO.getInstance();
			
			int checkNum = dao.userCheck(id, pw);
			if(checkNum == -1) {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('아이디가 존재하지 않습니다.');	history.back();</script>");
				writer.close();
				return;
			} else if(checkNum == 0) {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('비밀번호가 틀립니다.');	history.back();</script>");
				writer.close();
				return;
			} else if(checkNum == 1) {
				MemberDTO dto = dao.getMember(id);
				if(dto == null) {
					PrintWriter writer = response.getWriter();
					writer.println("<script>alert('존재하지 않는 회원입니다.');	history.go(-1);</script>");
					writer.close();
					return;
				} else {
					String name = dto.getmName();
					request.getSession().setAttribute("id", id);
					request.getSession().setAttribute("name", name);
					request.getSession().setAttribute("who", "member");
					PrintWriter writer = response.getWriter();
					writer.println("<script>alert('"+ name +"님 환영합니다.');	document.location.href='main';</script>");
					writer.close();
					return;
				}
			}
		} else {
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('잘못된 접근입니다.');	history.go(-1);</script>");
			writer.close();
			return;
		}
	}

}
