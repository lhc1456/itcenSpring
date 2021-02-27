package com.javaEdu.movein.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javaEdu.movein.dto.AdminDTO;


public class AdminDAO {

	private static AdminDAO instance = new AdminDAO();
	
	private AdminDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static AdminDAO getInstance() {
		return instance;
	}
	
	public ArrayList<AdminDTO> listAdmin() {
		ArrayList<AdminDTO> dtos = new ArrayList<AdminDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = getConnection();
			
			String query = "select aId, aPw, aName from admin_MI"; 
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String aId = rs.getString("aId");
				String aPw = rs.getString("aPw");
				String aName = rs.getString("aName");
				
				AdminDTO dto = new AdminDTO(aId, aPw, aName);
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
	
	public int insertAdmin(AdminDTO dto) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into admin_MI values (?, ?, ?)";
		
		try {
			con = getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getaId());
			pstmt.setString(2, dto.getaPw());
			pstmt.setString(3, dto.getaName());
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
	
	public int confirmId(String aId) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select aId from admin_MI where aId = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, aId);
			rs = pstmt.executeQuery();
			if( rs.next()) {
				ri = 1;
			} else {
				ri = 0;
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
		
		return ri;
	}
	
	public int userCheck(String aId, String aPw) {
		int ri = 0;
		String dbPw;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select aPw from admin_MI where aId = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, aId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPw = rs.getString("aPw");
				if(dbPw.equals(aPw)) {
					ri = 1;	// ÎπÑÎ?Î≤àÌò∏ ?ùºÏπ?
				} else {
					ri = 0;	// ÎπÑÎ?Î≤àÌò∏ Î∂àÏùºÏπ?
				}
			} else {
				ri = -1;	// db ?ïÑ?ù¥?îî ?óÜ?ùå
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
		
		return ri;
	}
	
	public AdminDTO getAdmin(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from admin_MI where aId = ?";
		AdminDTO dto = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new AdminDTO();
				dto.setaId(rs.getString("aId"));
				dto.setaPw(rs.getString("aPw"));
				dto.setaName(rs.getString("aName"));
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
	
	public int deleteAdmin(String id) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "delete from admin_MI where aId=?";
		
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
