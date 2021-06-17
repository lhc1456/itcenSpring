package com.hclim.movein.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hclim.movein.DAO.AddrCodeDAO;
import com.hclim.movein.VO.AddrCodeVO;

@Service("addrCodeService")
public class MAddrCodeServiceImpl implements MAddrCodeService {

	@Resource(name = "addrCodeDAO")
	private AddrCodeDAO dao;
	
	@Override
	public List<AddrCodeVO> listAddrCode() {
		return dao.listAddrCode();
	}

	@Override
	public AddrCodeVO getAddrCode(AddrCodeVO vo) {
		return dao.getAddrCode(vo);
	}

}
