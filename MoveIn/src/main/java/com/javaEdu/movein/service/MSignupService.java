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


public class MSignupService implements MService {

	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");

		String who = (String)request.getAttribute("who");
		
		if(who.equals("admin")) {
			String aId = request.getParameter("aId");
			String aPw = request.getParameter("aPw");
			String aName = request.getParameter("aName");
			
			AdminDAO dao = AdminDAO.getInstance();
			AdminDTO dto = new AdminDTO(aId, aPw, aName);
			
			int ri = dao.insertAdmin(dto);
			
			if(ri == 1) {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('관리자 추가에 성공하였습니다.');document.location.href='main';</script>");
				writer.close();
				return;
			} else {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('관리자 추가에 실패하였습니다.');document.location.href='main';</script>");
				writer.close();
				return;
			}
			
		} else {
			String mId = request.getParameter("mId");
			String mPw = request.getParameter("mPw");
			String mName = request.getParameter("mName");
			String rrn01 = request.getParameter("rrn01");
			String rrn02 = request.getParameter("rrn02");
			String addr = request.getParameter("addr");
			String dAddr = request.getParameter("dAddr");
			String email01 = request.getParameter("email01");
			String email02 = request.getParameter("email02");
			if(email02 == null) {
				email02 = request.getParameter("selectEmail");
			}
			String tel01 = request.getParameter("tel01");
			String tel02 = request.getParameter("tel02");
			String tel03 = request.getParameter("tel03");
			String phone01 = request.getParameter("phone01");
			String phone02 = request.getParameter("phone02");
			String phone03 = request.getParameter("phone03");
			String sigunguCode = request.getParameter("sigunguCode");
			
			MemberDAO dao = MemberDAO.getInstance();
			MemberDTO dto = new MemberDTO(mId, mPw, mName, rrn01, rrn02, addr, dAddr, email01, email02, tel01, tel02, tel03, phone01, phone02, phone03, sigunguCode);
			
			if(dao.confirmId(mId) == 1) {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('아이디가 이미 존재 합니다.');history.back();</script>");
				writer.close();
				return;
			} else {
				int ri = dao.insertMember(dto);
				if(ri == 1) {
					PrintWriter writer = response.getWriter();
					writer.println("<script>alert('회원가입을 축하 합니다.');document.location.href='main';</script>");
					writer.close();
					return;
				} else {
					PrintWriter writer = response.getWriter();
					writer.println("<script>alert('회원가입에 실패하였습니다.');document.location.href='main';</script>");
					writer.close();
					return;
				}
				
			}
		}
	}

}
