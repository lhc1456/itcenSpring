package com.javaEdu.movein.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.javaEdu.movein.dao.AdminDAO;
import com.javaEdu.movein.dao.MemberDAO;


public class MDeleteService implements MService {

	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		String[] selectList = request.getParameterValues("selectList");
		String list = (String)request.getAttribute("list");
		
		
		if(list.equals("admin")) {
			AdminDAO dao = AdminDAO.getInstance();
			int checkNum = 0;
			for (int i = 0; i < selectList.length; i++) {
				checkNum = dao.deleteAdmin(selectList[i]);
				
				 if(checkNum == 0) {
					PrintWriter writer = response.getWriter();
					writer.println("<script>alert('"+ selectList[i] +"관리자 삭제에 실패했습니다.'); history.go(-1);</script>");
					writer.close();
					return;
				}
			}
			if(checkNum == 1) {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('관리자 삭제에 성공했습니다.');document.location.href='/adminList'</script>");
				writer.close();
				return;
			}
		} else {
			MemberDAO dao = MemberDAO.getInstance();
			int checkNum = 0;
			for (int i = 0; i < selectList.length; i++) {
				checkNum = dao.deleteMember(selectList[i]);
				
				if(checkNum == 0) {
					PrintWriter writer = response.getWriter();
					writer.println("<script>alert('"+ selectList[i] +"회원 삭제에 실패했습니다.'); history.go(-1);</script>");
					writer.close();
					return;
				}
			}
			if(checkNum == 1) {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert(회원 삭제에 성공했습니다.');document.location.href='/memberList';</script>");
				writer.close();
				return;
			}
		}
	}
	
}
