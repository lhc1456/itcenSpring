package com.hclim.movein.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hclim.movein.VO.AddrCodeVO;

@Repository("addrCodeDAO")
public class AddrCodeDAOImpl implements AddrCodeDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.hclim.movein.DAO.AddrCodeDAO";

	@Override
	public List<AddrCodeVO> listAddrCode() {
		return sqlSession.selectList(namespace + ".listAddrCode");
	}

	@Override
	public AddrCodeVO getAddrCode(AddrCodeVO vo) {
		return sqlSession.selectOne(namespace + ".getAddrCode", vo);
	}

}
