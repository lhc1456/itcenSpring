package com.javaEdu.movein.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.javaEdu.movein.dao.MoveInDAO;
import com.javaEdu.movein.dto.MoveInDTO;


public class MSubmitService implements MService {

	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		String beforeAddr = request.getParameter("beforeAddr");
		String beforedAddr = request.getParameter("beforedAddr");
		String afterAddr = request.getParameter("afterAddr");
		String afterdAddr = request.getParameter("afterdAddr");
		String mId = request.getParameter("mId");
		
		MoveInDAO dao = MoveInDAO.getinstance();
		MoveInDTO dto = new MoveInDTO(0, "", beforeAddr, beforedAddr, afterAddr, afterdAddr, mId);

		int ri = dao.insertMoveIn(dto);

		if(ri == 1) {
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('민원이 신청되었습니다.');document.location.href='main';</script>");
			writer.close();
			return;
		} else {
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('민원이 신청이 실패하였습니다.');document.location.href='main';</script>");
			writer.close();
			return;
		}

	}

}
