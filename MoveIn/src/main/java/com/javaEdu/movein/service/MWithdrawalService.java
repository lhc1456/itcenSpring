package com.javaEdu.movein.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.javaEdu.movein.dao.AdminDAO;
import com.javaEdu.movein.dao.MemberDAO;


public class MWithdrawalService implements MService {
	
	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		String id = (String)request.getSession().getAttribute("id");
		String who = (String)request.getAttribute("who");
		
		if(who.equals("admin")) {
			AdminDAO dao = AdminDAO.getInstance();
			int checkNum = dao.deleteAdmin(id);
			
			if(checkNum == 0) {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('관리자 탈퇴에 실패했습니다.'); history.go(-1);</script>");
				writer.close();
				return;
			} else {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('관리자 탈퇴에 성공했습니다.');document.location.href='main';</script>");
				writer.close();
				request.getSession().invalidate();
				return;
			}
			
		} else {
			MemberDAO dao = MemberDAO.getInstance();
			int checkNum = dao.deleteMember(id);
			
			if(checkNum == 0) {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('회원 탈퇴에 실패했습니다.'); history.go(-1);</script>");
				writer.close();
				return;
			} else {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('회원 탈퇴에 성공했습니다.');document.location.href='main';</script>");
				writer.close();
				request.getSession().invalidate();
				return;
			}
			
		}
		
	}

}
