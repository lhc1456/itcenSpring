package com.javaEdu.movein.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javaEdu.movein.dto.MoveInDTO;


public class MoveInDAO {
	
	private static MoveInDAO instance = new MoveInDAO();
	
	private MoveInDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static MoveInDAO getinstance( ) {
		return instance;
	}
	
	public ArrayList<MoveInDTO> listMoveIn() {
		ArrayList<MoveInDTO> dtos = new ArrayList<MoveInDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String query = "select * from MoveIn order by ren desc";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int ren = rs.getInt("ren");
				String state = rs.getString("state");
				String beforeAddr = rs.getString("beforeAddr");
				String beforedAddr = rs.getString("beforedAddr");
				String afterAddr = rs.getString("afterAddr");
				String afterdAddr = rs.getString("afterdAddr");
				String mId = rs.getString("mId");
				
				MoveInDTO dto = new MoveInDTO(ren, state, beforeAddr, beforedAddr, afterAddr, afterdAddr, mId);
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
	
	public int insertMoveIn(MoveInDTO dto) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into MoveIn values (mi_seq.nextval, '처리중', ?, ?, ?, ?, ?)";
		
		try {
			con = getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getBeforeAddr());
			pstmt.setString(2, dto.getBeforedAddr());
			pstmt.setString(3, dto.getAfterAddr());
			pstmt.setString(4, dto.getAfterdAddr());
			pstmt.setString(5, dto.getmId());
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
	
	public ArrayList<MoveInDTO> getMoveIn(String id) {
		ArrayList<MoveInDTO> dtos = new ArrayList<MoveInDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from moveIn where mid=? order by ren desc";
		MoveInDTO dto = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new MoveInDTO();
				dto.setRen(rs.getInt("ren"));
				dto.setState(rs.getString("state"));
				dto.setBeforeAddr(rs.getString("beforeAddr"));
				dto.setBeforedAddr(rs.getString("beforedAddr"));
				dto.setAfterAddr(rs.getString("afterAddr"));
				dto.setAfterdAddr(rs.getString("afterdAddr"));
				dto.setmId(rs.getString("mId"));
				
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
	
	public MoveInDTO getMoveIn(int ren) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from moveIn where ren=?";
		MoveInDTO dto = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ren);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new MoveInDTO();
				dto.setRen(rs.getInt("ren"));
				dto.setState(rs.getString("state"));
				dto.setBeforeAddr(rs.getString("beforeAddr"));
				dto.setBeforedAddr(rs.getString("beforedAddr"));
				dto.setAfterAddr(rs.getString("afterAddr"));
				dto.setAfterdAddr(rs.getString("afterdAddr"));
				dto.setmId(rs.getString("mId"));
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
	
	public int updateState(int ren, String state) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update MoveIn set state=? where ren=?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, state);
			pstmt.setInt(2, ren);
			
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
