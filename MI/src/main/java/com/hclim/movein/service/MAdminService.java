package com.hclim.movein.service;

import java.util.List;

import com.hclim.movein.VO.AdminVO;

public interface MAdminService {

	// Admin 전체 출력
	public List<AdminVO> listAdmin();

	// 하나의 Admin 출력
	public AdminVO getAdmin(AdminVO vo);

	// Admin insert
	public void insertAdmin(AdminVO vo);

	// Admin delete
	public void deleteAdmin(AdminVO vo);

	// ID 확인
	public String confirmId(AdminVO vo);

	// PW 확인
	public String userCheck(AdminVO vo);
}
