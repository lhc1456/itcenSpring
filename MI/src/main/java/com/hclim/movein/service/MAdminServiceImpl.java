package com.hclim.movein.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hclim.movein.DAO.AdminDAO;
import com.hclim.movein.VO.AdminVO;

@Service("adminService")
public class MAdminServiceImpl implements MAdminService {

	@Resource(name = "adminDAO")
	private AdminDAO dao;

	@Override
	public List<AdminVO> listAdmin() {
		return dao.listAdmin();
	}

	@Override
	public AdminVO getAdmin(AdminVO vo) {
		return dao.getAdmin(vo);
	}

	@Override
	public void insertAdmin(AdminVO vo) {
		dao.insertAdmin(vo);
	}

	@Override
	public void deleteAdmin(AdminVO vo) {
		dao.deleteAdmin(vo);
	}

	@Override
	public String confirmId(AdminVO vo) {
		return dao.confirmId(vo);
	}

	@Override
	public String userCheck(AdminVO vo) {
		return dao.userCheck(vo);
	}

}