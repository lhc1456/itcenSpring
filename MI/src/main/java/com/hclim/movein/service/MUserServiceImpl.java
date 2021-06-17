package com.hclim.movein.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hclim.movein.DAO.MemberDAO;
import com.hclim.movein.VO.MemberVO;

@Service("userService")
public class MUserServiceImpl implements MUserService {

	@Resource(name = "memberDAO")
	private MemberDAO dao;
	
	@Override
	public List<MemberVO> listMember() {
		return dao.listMember();
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		return dao.getMember(vo);
	}

	@Override
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		dao.updateMember(vo);
	}

	@Override
	public void deleteMember(MemberVO vo) {
		dao.deleteMember(vo);
	}

	@Override
	public String confirmId(MemberVO vo) {
		return dao.confirmId(vo);
	}

	@Override
	public String userCheck(MemberVO vo) {
		return dao.userCheck(vo);
	}

	@Override
	public String findId(MemberVO vo) {
		return dao.findId(vo);
	}

	@Override
	public String findPw(MemberVO vo) {
		return dao.findPw(vo);
	}

}
