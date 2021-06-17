package com.hclim.movein.DAO;

import java.util.List;

import com.hclim.movein.VO.MoveInVO;

public interface MoveInDAO {
	
	// 전체 MoveIn 출력
	public List<MoveInVO> listMoveIn();
	
	// 아이디 당 MoveIn 출력
	public List<MoveInVO> getMoveInList(MoveInVO vo);
	
	// 하나의 MoveIn 출력
	public MoveInVO getMoveIn(MoveInVO vo);
	
	// MoveIn insert
	public void insertMoveIn(MoveInVO vo);
	
	// MoveIn update
	public void updateMoveIn(MoveInVO vo);
	
}
