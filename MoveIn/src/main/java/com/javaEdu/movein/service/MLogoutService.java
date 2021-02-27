package com.javaEdu.movein.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class MLogoutService implements MService {

	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		request.getSession().invalidate();
	}

}
