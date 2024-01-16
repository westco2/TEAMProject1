package com.project.scripts.model;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.util.JdbcUtil;



public class scriptsDAO{
	private static scriptsDAO instance = new scriptsDAO();
	private scriptsDAO() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
		}
	}
	public static scriptsDAO getInstance() {
		return instance;
	}
	private String url = JdbcUtil.url;
	private String uid = JdbcUtil.uid;
	private String upw = JdbcUtil.upw;

	public int saveMessage(String id, String detail, String send_id) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="Insert into letter(bno,Letter_send_id,letter_detail,letter_date,user_id)values(Scripts_SEQ.nextval,?,?,SYSDATE,?)";
		try {
			conn= DriverManager.getConnection(url, uid, upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, send_id);
			pstmt.setString(2, detail);
			pstmt.setString(3, id);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		
		return result;
	}
	public ArrayList<scriptsVO> getMessage(String id) {
		ArrayList<scriptsVO> list = new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		String sql="select * from letter where letter_send_id = ? or user_id = ?  order by letter_date desc";
		
		try {
			conn= DriverManager.getConnection(url, uid, upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String bno=rs.getString("bno");
				String letter_detail=rs.getString("letter_detail");
				String user_id=rs.getString("user_id");
				String letter_send_id=rs.getString("letter_send_id");
				Timestamp letter_date=rs.getTimestamp("letter_date");
				scriptsVO vo= new scriptsVO(letter_send_id, letter_detail, letter_date, user_id, bno);
				list.add(vo);
			}
		} catch (SQLException e) {
			
			return list;
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}
	public scriptsVO selectMessage(String bno) {
		scriptsVO vo = new scriptsVO();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * FROM letter where bno=?";
		
		try {
			conn= DriverManager.getConnection(url, uid, upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo.setBno(rs.getString("bno"));
				vo.setLetter_date(rs.getTimestamp("letter_date"));
				vo.setLetter_detail(rs.getString("letter_detail"));
				vo.setLetter_send_id(rs.getString("letter_send_id"));
				vo.setUser_id(rs.getString("user_id"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return vo;
	}
	public void deleteMessage(String bno) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="Delete From letter where bno=?";
		
		try {
			conn= DriverManager.getConnection(url, uid, upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
	}
	public boolean idCheck(String id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql="select * From users where user_id = ?";
		
		try {
			conn= DriverManager.getConnection(url, uid, upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		return false;
	}
	public String getLetter(String id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql="select count(*) as num from letter group by letter_send_id having letter_send_id = ?";

		try {
			conn= DriverManager.getConnection(url, uid, upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getString("num");
			}else{
				return "0";
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		return "0";
	}
	
	
}
