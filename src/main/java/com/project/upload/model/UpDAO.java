package com.project.upload.model;

import com.project.util.JdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class UpDAO {
	//싱글톤
		//1. 객체 1개 생성
		private static UpDAO instance = new UpDAO();
		//2. 생성자 private
		private UpDAO() {
			
			try {
				//드라이버 호출문장
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
			} catch (Exception e) {
			}
			
		}
		//3. getter메서드
		public static UpDAO getInstance() {
			return instance;
		}
		
		/////////////////////////////////////////////
		private String url = JdbcUtil.url;
		private String uid = JdbcUtil.uid;
		private String upw = JdbcUtil.upw;
		
		public void upFile(String file) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "insert into up_file(path, file_name, pno) values(?, ?, up_file_seq.nextval)";
			String path = "/img/";
			file = file.replace(" ","%20");
			try {
				conn = DriverManager.getConnection(url, uid, upw);
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, path);
				pstmt.setString(2, file);
				
				pstmt.executeUpdate();
				
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, pstmt, null);
			}
			
		}
	public void reFile(String file, String pno) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update up_file set file_name = ? where pno = ? ";
		file = file.replace(" ","%20");
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, file);
			pstmt.setString(2, pno);

			pstmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}

	}

		
		
}
