package com.javaEdu.movein.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public class MNotImplService implements MService {

	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('아직 구현되지 않은 기능입니다.');history.go(-1)</script>");
		writer.close();
		return;
	}

}
