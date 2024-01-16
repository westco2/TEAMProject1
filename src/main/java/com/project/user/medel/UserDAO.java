package com.project.user.medel;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.project.util.JdbcUtil;



public class UserDAO {
	
	
	private static UserDAO instance = new UserDAO();
	
	private UserDAO() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
		}
		
	}
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	/////////////////////////////////////////////
	private String url = JdbcUtil.url;
	private String uid = JdbcUtil.uid;
	private String upw = JdbcUtil.upw;
	
	
	public int idCheck(String id) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from users where user_id = ?";
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if( rs.next() ) { 
				result = 1; 
			} else { 
				result = 0; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public int nickCheck(String nick) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from users where user_nick = ?";
		
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nick);
			
			rs = pstmt.executeQuery();
			
			if( rs.next() ) { 
				result = 1; 
			} else { 
				result = 0; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public void insertUser(UserVO vo) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into users(user_id,user_pw,user_name,user_email,user_address,user_nick)"
				+ "values(?,?,?,?,?,?)";
		
		
		try {
			
			conn = DriverManager.getConnection(url,uid,upw);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getNick());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
	}
	
	public UserVO login(String id, String pw) {
		UserVO vo =null;
		System.out.println("실행");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select user_name from users where user_id = ? and user_pw = ? ";
		
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new UserVO(); 
				vo.setId(id);
				vo.setName(rs.getString("user_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
		
		
	}

	
	public UserVO getUserInfo(String id) {

		UserVO vo =null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from users where user_id =?";
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				String name=rs.getString("user_name");
				String email=rs.getString("user_email");
				String address=rs.getString("user_address");
				String gender=rs.getString("gender");
				String nick=rs.getString("user_nick");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				vo = new UserVO(id, null, name, email, address, nick, gender, regdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	public int update(UserVO vo) {
		int result=0;
		Connection conn = null;
		PreparedStatement pstmt =null;
		
		String sql="update users set user_pw=?, user_name=?, user_email=?, user_address=?, user_nick=? where user_id=?";
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getNick());
			pstmt.setString(6, vo.getId());
			
			result = pstmt.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		return result;
	}
	
	public void delete(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql="delete from users where user_id=?";
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
	}
	public void setLetter(String id, String num) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql="update users set user_class = ? where user_id =?";

		try {
			conn = DriverManager.getConnection(url,uid,upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, id);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}

	}
	public String getLetter(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select user_class from users where user_id =?";

		try {
			conn = DriverManager.getConnection(url,uid,upw);

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs=pstmt.executeQuery();

			if(rs.next()) {

				return rs.getString("user_class");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return "0";
	}
}
