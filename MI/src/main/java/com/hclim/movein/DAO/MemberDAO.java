package com.hclim.movein.DAO;

import java.util.List;

import com.hclim.movein.VO.MemberVO;

public interface MemberDAO {
	// Member 전체 출력
	public List<MemberVO> listMember();

	// 하나의 Member 출력
	public MemberVO getMember(MemberVO vo);

	// Member insert
	public void insertMember(MemberVO vo);

	// Member update
	public void updateMember(MemberVO vo);

	// Member delete
	public void deleteMember(MemberVO vo);

	// ID 확인
	public String confirmId(MemberVO vo);

	// PW 확인
	public String userCheck(MemberVO vo);

	// ID 찾기
	public String findId(MemberVO vo);

	// PW 찾기
	public String findPw(MemberVO vo);
}
