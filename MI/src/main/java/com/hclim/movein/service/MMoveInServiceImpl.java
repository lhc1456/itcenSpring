package com.hclim.movein.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hclim.movein.DAO.MoveInDAO;
import com.hclim.movein.VO.MoveInVO;

@Service("moveinService")
public class MMoveInServiceImpl implements MMoveInService {

	@Resource(name = "moveinDAO")
	private MoveInDAO dao;

	@Override
	public List<MoveInVO> listMoveIn() {
		return dao.listMoveIn();
	}

	@Override
	public List<MoveInVO> getMoveInList(MoveInVO vo) {
		return dao.getMoveInList(vo);
	}

	@Override
	public MoveInVO getMoveIn(MoveInVO vo) {
		return dao.getMoveIn(vo);
	}

	@Override
	public void insertMoveIn(MoveInVO vo) {
		dao.insertMoveIn(vo);
	}

	@Override
	public void updateMoveIn(MoveInVO vo) {
		dao.updateMoveIn(vo);
	}

}
