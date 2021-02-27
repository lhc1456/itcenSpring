package com.javaEdu.movein.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javaEdu.movein.dao.MemberDAO;
import com.javaEdu.movein.dto.MemberDTO;


public class MDetailService implements MService {

	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
	
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = (String)request.getSession().getAttribute("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO dto = dao.getMember(id);
		
		model.addAttribute("dMember", dto);
	}
	
}
