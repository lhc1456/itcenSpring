package com.javaEdu.movein.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.javaEdu.movein.dao.AddrCodeDAO;
import com.javaEdu.movein.dao.MemberDAO;
import com.javaEdu.movein.dto.AddrCodeDTO;
import com.javaEdu.movein.dto.MemberDTO;


public class MCheckAddrService implements MService {

	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		String sido = request.getParameter("sido");
		String gugun = request.getParameter("gugun");
		AddrCodeDAO codeDAO = AddrCodeDAO.getInstance();
		AddrCodeDTO codeDTO = codeDAO.getCode(sido, gugun);
		
		MemberDAO memDAO = MemberDAO.getInstance();
		MemberDTO memDTO = memDAO.getMember((String)request.getSession().getAttribute("id"));
		if(codeDTO.getCode().equals(memDTO.getSigunguCode())) {
			PrintWriter writer = response.getWriter();
			writer.print("1");
			writer.close();
		} else {
			PrintWriter writer = response.getWriter();
			writer.print("0");
			writer.close();
		}
	}

}
