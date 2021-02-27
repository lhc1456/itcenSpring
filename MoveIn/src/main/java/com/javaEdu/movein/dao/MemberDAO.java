package com.javaEdu.movein.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javaEdu.movein.dto.MemberDTO;


public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public ArrayList<MemberDTO> listMember() {
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = getConnection();
			
			String query = "select mId, mPw, mName, rrn01, rrn02, addr, dAddr, email01, email02, tel01, tel02, tel03, phone01, phone02, phone03, sigunguCode from member_MI";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String mId = rs.getString("mId");
				String mPw = rs.getString("mPw");
				String mName = rs.getString("mName");
				String rrn01 = rs.getString("rrn01");
				String rrn02 = rs.getString("rrn02");
				String addr = rs.getString("addr");
				String dAddr = rs.getString("dAddr");
				String email01 = rs.getString("email01");
				String email02 = rs.getString("email02");
				String tel01 = rs.getString("tel01");
				String tel02 = rs.getString("tel02");
				String tel03 = rs.getString("tel03");
				String phone01 = rs.getString("phone01");
				String phone02 = rs.getString("phone02");
				String phone03 = rs.getString("phone03");
				String sigunguCode = rs.getString("sigunguCode");
				
				MemberDTO dto = new MemberDTO(mId, mPw, mName, rrn01, rrn02, addr, dAddr, email01, email02, tel01, tel02, tel03, phone01, phone02, phone03, sigunguCode);
				dtos.add(dto);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
		return dtos;
	}
	
	public int insertMember(MemberDTO dto) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into member_MI values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			con = getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getmId());
			pstmt.setString(2, dto.getmPw());
			pstmt.setString(3, dto.getmName());
			pstmt.setString(4, dto.getRrn01());
			pstmt.setString(5, dto.getRrn02());
			pstmt.setString(6, dto.getAddr());
			pstmt.setString(7, dto.getdAddr());
			pstmt.setString(8, dto.getEmail01());
			pstmt.setString(9, dto.getEmail02());
			pstmt.setString(10, dto.getTel01());
			pstmt.setString(11, dto.getTel02());
			pstmt.setString(12, dto.getTel03());
			pstmt.setString(13, dto.getPhone01());
			pstmt.setString(14, dto.getPhone02());
			pstmt.setString(15, dto.getPhone03());
			pstmt.setString(16, dto.getSigunguCode());
			pstmt.executeUpdate();
			
			ri = 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public int confirmId(String mId) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select mId from member_MI where mId = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ri = 1;
			} else {
				ri = 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if( rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public int userCheck(String mId, String mPw) {
		int ri = 0;
		String dbPw;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select mPw from member_MI where mId = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPw = rs.getString("mPw");
				if(dbPw.equals(mPw)) {
					ri = 1;	// �α��� OK
				} else {
					ri = 0;	// ���? X
				}
			} else {
				ri = -1;	//ȸ�� X
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return ri;
	}
	
	public MemberDTO getMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from member_MI where mId = ?";
		MemberDTO dto = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setmId(rs.getString("mId"));
				dto.setmPw(rs.getString("mPw"));
				dto.setmName(rs.getString("mName"));
				dto.setRrn01(rs.getString("rrn01"));
				dto.setRrn02(rs.getString("rrn02"));
				dto.setAddr(rs.getString("addr"));
				dto.setdAddr(rs.getString("dAddr"));
				dto.setEmail01(rs.getString("email01"));
				dto.setEmail02(rs.getString("email02"));
				dto.setTel01(rs.getString("tel01"));
				dto.setTel02(rs.getString("tel02"));
				dto.setTel03(rs.getString("tel03"));
				dto.setPhone01(rs.getString("phone01"));
				dto.setPhone02(rs.getString("phone02"));
				dto.setPhone03(rs.getString("phone03"));
				dto.setSigunguCode(rs.getString("sigunguCode"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public int updateMember(MemberDTO dto) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update member_MI set mPw=?, mName=?, rrn01=?, rrn02=?, addr=?, dAddr=?, email01=?, email02=?, tel01=?, tel02=?, tel03=?, phone01=?, phone02=?, phone03=?, sigunguCode=? where mId=?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getmPw());
			pstmt.setString(2, dto.getmName());
			pstmt.setString(3, dto.getRrn01());
			pstmt.setString(4, dto.getRrn02());
			pstmt.setString(5, dto.getAddr());
			pstmt.setString(6, dto.getdAddr());
			pstmt.setString(7, dto.getEmail01());
			pstmt.setString(8, dto.getEmail02());
			pstmt.setString(9, dto.getTel01());
			pstmt.setString(10, dto.getTel02());
			pstmt.setString(11, dto.getTel03());
			pstmt.setString(12, dto.getPhone01());
			pstmt.setString(13, dto.getPhone02());
			pstmt.setString(14, dto.getPhone03());
			pstmt.setString(15, dto.getSigunguCode());
			pstmt.setString(16, dto.getmId());
			
			ri = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public int deleteMember(String id) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "delete from member_MI where mId=?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ri = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	private Connection getConnection() {
		Context context = null;
		DataSource dataSource = null;
		Connection con = null;
		
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			con = dataSource.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}

}
