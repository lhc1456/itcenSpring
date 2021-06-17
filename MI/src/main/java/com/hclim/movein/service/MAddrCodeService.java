package com.hclim.movein.service;

import java.util.List;

import com.hclim.movein.VO.AddrCodeVO;

public interface MAddrCodeService {

	// AddrCode 전체 출력
	public List<AddrCodeVO> listAddrCode();
	
	// 하나의 AddrCode 가져오기
	public AddrCodeVO getAddrCode(AddrCodeVO vo);

}
