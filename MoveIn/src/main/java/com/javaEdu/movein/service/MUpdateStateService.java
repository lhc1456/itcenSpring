package com.javaEdu.movein.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.javaEdu.movein.dao.MemberDAO;
import com.javaEdu.movein.dao.MoveInDAO;
import com.javaEdu.movein.dto.MemberDTO;
import com.javaEdu.movein.dto.MoveInDTO;


public class MUpdateStateService implements MService {
	
	@Override
	public void execute(Model model) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		int ren = Integer.parseInt(request.getParameter("hidRen"));
		String state = request.getParameter("hidState");
		MoveInDAO dao = MoveInDAO.getinstance();
		
		if(state.equals("승인")) {
			state = "처리완료";
			int ri = dao.updateState(ren, state);

			if(ri == 1) {
				MoveInDTO dto = dao.getMoveIn(ren);
				MemberDAO mDAO = MemberDAO.getInstance();
				MemberDTO mDTO = mDAO.getMember(dto.getmId());
				mDTO.setAddr(dto.getAfterAddr());
				mDTO.setdAddr(dto.getAfterdAddr());
				mDTO.setSigunguCode(dto.getSigungu());
				int rn = mDAO.updateMember(mDTO);
				
				if(rn == 1) {
					PrintWriter writer = response.getWriter();
					writer.println("<script>alert('승인이 완료되었습니다.');document.location.href='main';</script>");
					writer.close();
					return;
				} else {
					PrintWriter writer = response.getWriter();
					writer.println("<script>alert('승인이 실패되었습니다.');history.go(-1);</script>");
					writer.close();
					return;
				}
				
			} else {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('승인이 실패되었습니다.');history.go(-1);</script>");
				writer.close();
				return;
			}
		} else if(state.equals("반려")){
			state = "반려됨";
			int ri = dao.updateState(ren, state);
			
			if(ri == 1) {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('반려가 완료되었습니다.');document.location.href='main';</script>");
				writer.close();
				return;
			} else {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('반려가 실패되었습니다.');history.go(-1);</script>");
				writer.close();
				return;
			}
		} else {
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('잘못된 접근입니다.');history.go(-1);</script>");
			writer.close();
			return;
		}
	}
	

}
