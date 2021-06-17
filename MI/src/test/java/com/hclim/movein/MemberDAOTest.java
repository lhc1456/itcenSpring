package com.hclim.movein;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hclim.movein.DAO.MemberDAO;
import com.hclim.movein.VO.MemberVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
@Log4j
public class MemberDAOTest {

	@Resource(name="memberDAO")
	public MemberDAO dao;
	
//	@Ignore
//	@Test
//	public void insertMember() throws Exception {
//		MemberVO vo = new MemberVO();
//		
//		vo.setMId("user02");
//		vo.setMPw("user02");
//		vo.setMName("유저02");
//		vo.setIsAdmin("no");
//		
//		dao.insertMember(vo);
//	}
//	
//	@Ignore
//	@Test
//	public void deleteMember() throws Exception {
//		MemberVO vo = new MemberVO();
//		
//		vo.setMId("user02");
//		
//		dao.deleteMember(vo);
//	}
//	
//	@Ignore
//	@Test
//	public void updateMember() throws Exception {
//		MemberVO vo = new MemberVO();
//		
//		vo.setMPw("user-1");
//		vo.setMName("유저-1");
//		vo.setMId("user00");
//		
//		dao.updateMember(vo);
//	}
//	
//	@Ignore
	@Test
	public void selectMember() throws Exception  {
		MemberVO vo = new MemberVO();
		vo.setMName("qqqq");
		vo.setRrn01("111111");
		vo.setRrn02("1111111");
		log.info(dao.findId(vo));
	}
	
	@Test
	public void login() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setMId("qqqq");
		vo.setMPw("1234");
		log.info(dao.userCheck(vo));
	}
}
