package com.javaEdu.movein.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javaEdu.movein.dao.AdminDAO;
import com.javaEdu.movein.dao.MemberDAO;
import com.javaEdu.movein.dto.AdminDTO;
import com.javaEdu.movein.dto.MemberDTO;


public class MListService implements MService {

	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String who = (String)request.getAttribute("list");
		if(who.equals("admin")) {
			AdminDAO dao = AdminDAO.getInstance();
			ArrayList<AdminDTO> dtos = dao.listAdmin();
			model.addAttribute("adminList", dtos);
		} else {
			MemberDAO dao = MemberDAO.getInstance();
			ArrayList<MemberDTO> dtos = dao.listMember();
			model.addAttribute("memberList", dtos);
		}
	}
	
}
