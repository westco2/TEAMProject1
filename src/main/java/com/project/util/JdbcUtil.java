package com.project.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtil {
	public static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	public static final String uid="JSP";
	public static final String upw="JSP";
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			if(conn!=null)conn.close();
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("CLOSE ERROR");
		}
		
		
	}
}
