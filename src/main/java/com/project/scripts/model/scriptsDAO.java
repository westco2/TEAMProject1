package com.project.scripts.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.util.JdbcUtil;



public class scriptsDAO{
	private static scriptsDAO instance = new scriptsDAO();
	private scriptsDAO() {
		try {
			
			InitialContext init = new InitialContext();
			
			dataSource=(DataSource)init.lookup("java:comp/env/jdbc/oracle");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public static scriptsDAO getInstance() {
		return instance;
	}

	private DataSource dataSource;
	public int saveMessage(String id, String detail, String send_id,String date) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="Insert into Scripts(Letter_send_id,letter_detail,letter_date,user_id)values(?,?,?,?)";
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, send_id);
			pstmt.setString(2, detail);
			pstmt.setString(3, date);
			pstmt.setString(4, id);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		
		return result;
	}
	public scriptsVO getMessage(String send_id, String detail) {
		scriptsVO vo=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="Select * from scripts where Letter_send_id=? AND letter_detail=?";
		
			try {
				conn=dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, send_id);
				pstmt.setString(2, detail);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					vo= new scriptsVO();
					vo.setLetter_date(rs.getString("letter_date"));
					vo.setLetter_detail(rs.getString("letter_detail"));
					vo.setLetter_send_id(rs.getString("Letter_send_id"));
					vo.setUser_id(rs.getString("user_id"));
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				JdbcUtil.close(conn, pstmt, rs);
			}
		System.out.println(vo.toString());
		return vo;
		
	}
	
}
