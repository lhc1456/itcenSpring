package com.hclim.movein.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hclim.movein.VO.AdminVO;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.hclim.movein.DAO.AdminDAO";
	
	@Override
	public List<AdminVO> listAdmin() {
		return sqlSession.selectList(namespace + ".listAdmin");
	}

	@Override
	public AdminVO getAdmin(AdminVO vo) {
		return sqlSession.selectOne(namespace + ".getAdmin", vo);
	}

	@Override
	public void insertAdmin(AdminVO vo) {
		sqlSession.insert(namespace + ".insertAdmin", vo);
	}

	@Override
	public void deleteAdmin(AdminVO vo) {
		sqlSession.delete(namespace + ".deleteAdmin", vo);
	}

	@Override
	public String confirmId(AdminVO vo) {
		return sqlSession.selectOne(namespace + ".confirmId", vo);
	}

	@Override
	public String userCheck(AdminVO vo) {
		return sqlSession.selectOne(namespace + ".userCheck", vo);
	}

}
