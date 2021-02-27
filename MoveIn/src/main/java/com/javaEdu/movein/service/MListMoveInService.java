package com.javaEdu.movein.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javaEdu.movein.dao.MoveInDAO;
import com.javaEdu.movein.dto.MoveInDTO;


public class MListMoveInService implements MService {

	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String who = (String)request.getSession().getAttribute("who");
		if(who.equals("admin")) {
			MoveInDAO dao = MoveInDAO.getinstance();
			ArrayList<MoveInDTO> dtos = dao.listMoveIn();
			model.addAttribute("moveIn", dtos);
		} else {
			String id = (String)request.getSession().getAttribute("id");
			MoveInDAO dao = MoveInDAO.getinstance();
			ArrayList<MoveInDTO> dtos = dao.getMoveIn(id);
			model.addAttribute("moveIn", dtos);
		}
	}
	
}
