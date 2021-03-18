package com.javaEdu.movein.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.javaEdu.movein.dao.MemberDAO;

public class MFindInfoService implements MService {

	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		String thing = (String)request.getAttribute("thing");
		
		if(thing.equals("id")) {
			String name = request.getParameter("name");
			String rrn01 = request.getParameter("rrn01");
			String rrn02 = request.getParameter("rrn02");
			
			MemberDAO dao = MemberDAO.getInstance();
			String id = dao.findId(name, rrn01, rrn02);
			
			request.getSession().setAttribute("findId", id);
			request.getSession().setAttribute("findName", name);
			
			if(id == null) {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('일치하는 정보가 없습니다.');document.location.href='login_view';</script>");
				writer.close();
				return;
			} else {
				PrintWriter writer = response.getWriter();
				writer.println("<script> window.open('popup/showId', 'showID', 'width=400, height=200, location=no, resizeable=no, scrollbars=no');  document.location.href='login_view';</script>");
				writer.close();
				return;
			}
			
		} else if(thing.equals("pw")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String rrn01 = request.getParameter("rrn01");
			String rrn02 = request.getParameter("rrn02");
			
			MemberDAO dao = MemberDAO.getInstance();
			String pw = dao.findPw(id, name, rrn01, rrn02);
			
			request.getSession().setAttribute("findPw", pw);
			request.getSession().setAttribute("findName", name);
			
			if(id == null) {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('일치하는 정보가 없습니다.');document.location.href='login_view';</script>");
				writer.close();
				return;
			} else {
				PrintWriter writer = response.getWriter();
				writer.println("<script>window.open('popup/showPw', 'showPW', 'width=400, height=200, location=no, resizeable=no, scrollbars=no');  document.location.href='login_view';</script>");
				writer.close();
				return;
			}
		} else {
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('잘못된 접근입니다.');document.location.href='login_view';</script>");
			writer.close();
			return;
		}
		

	}

}
