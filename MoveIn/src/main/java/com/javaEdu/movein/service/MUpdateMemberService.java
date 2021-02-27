package com.javaEdu.movein.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.javaEdu.movein.dao.MemberDAO;
import com.javaEdu.movein.dto.MemberDTO;


public class MUpdateMemberService implements MService {

	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");

		String mId = request.getParameter("id");
		String mPw = request.getParameter("pw");
		String mName = request.getParameter("name");
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
		
		int ri = dao.updateMember(dto);
		
		if(ri == 1) {
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('회원 정보 수정이 완료되었습니다.');document.location.href='main.do';</script>");
			writer.close();
			return;
		} else {
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('회원 정보 수정이 실패되었습니다.');history.go(-1);</script>");
			writer.close();
			return;
		}
	}

}
