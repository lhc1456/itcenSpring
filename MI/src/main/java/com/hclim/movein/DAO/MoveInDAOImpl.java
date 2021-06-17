package com.hclim.movein.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hclim.movein.VO.MoveInVO;

@Repository("moveinDAO")
public class MoveInDAOImpl implements MoveInDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.hclim.movein.DAO.MoveInDAO";

	@Override
	public List<MoveInVO> listMoveIn() {
		return sqlSession.selectList(namespace + ".listMoveIn");
	}

	@Override
	public List<MoveInVO> getMoveInList(MoveInVO vo) {
		return sqlSession.selectList(namespace + ".getMoveInList", vo);
	}

	@Override
	public MoveInVO getMoveIn(MoveInVO vo) {
		return sqlSession.selectOne(namespace + ".getMoveIn", vo);
	}

	@Override
	public void insertMoveIn(MoveInVO vo) {
		sqlSession.insert(namespace + ".insertMoveIn", vo);
	}

	@Override
	public void updateMoveIn(MoveInVO vo) {
		sqlSession.update(namespace + ".updateMoveIn", vo);
	}

}
