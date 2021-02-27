package com.javaEdu.movein.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javaEdu.movein.dto.AddrCodeDTO;


public class AddrCodeDAO {
	
	private static AddrCodeDAO instance = new AddrCodeDAO();
	
	private AddrCodeDAO() {
		
	}
	
	public AddrCodeDTO getCode(String sido, String gugun) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from sigungu where sido=? and gugun=?";
		AddrCodeDTO dto = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, sido);
			pstmt.setString(2, gugun);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new AddrCodeDTO();
				
				dto.setCode(rs.getString("code"));
				dto.setSido(rs.getString("sido"));
				dto.setGugun(rs.getString("gugun"));
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
	
	public static AddrCodeDAO getInstance() {
		return instance; 
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
