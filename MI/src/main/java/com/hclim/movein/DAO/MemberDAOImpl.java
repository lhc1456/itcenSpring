package com.hclim.movein.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hclim.movein.VO.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.hclim.movein.DAO.MemberDAO";

	@Override
	public List<MemberVO> listMember() {
		return sqlSession.selectList(namespace + ".listMember");
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		return sqlSession.selectOne(namespace + ".getMember", vo);
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace + ".insertMember", vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update(namespace + ".updateMember", vo);
	}

	@Override
	public void deleteMember(MemberVO vo) {
		sqlSession.delete(namespace + ".deleteMember", vo);
	}

	@Override
	public String confirmId(MemberVO vo) {
		return sqlSession.selectOne(namespace + ".confirmId", vo);
	}

	@Override
	public String userCheck(MemberVO vo) {
		return sqlSession.selectOne(namespace + ".userCheck", vo);
	}

	@Override
	public String findId(MemberVO vo) {
		return sqlSession.selectOne(namespace + ".findId", vo);
	}

	@Override
	public String findPw(MemberVO vo) {
		return sqlSession.selectOne(namespace + ".findPw", vo);
	}

}
