package com.project.post.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.project.util.JdbcUtil;

public class postDAO {
	private static postDAO instance = new postDAO();

	private postDAO() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
		}

	}

	public static postDAO getInstance() {
		return instance;
	}

	/////////////////////////////////////////////
	private String url = JdbcUtil.url;
	private String uid = JdbcUtil.uid;
	private String upw = JdbcUtil.upw;

	public void insertPost(postVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql ="insert into post(pno, title, category, sellType, price, content, address, user_ID) values(post_seq.nextval, ?,?,?,?,?,?,?)";

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getCategori());
			pstmt.setString(3,vo.getSellType());
			pstmt.setString(4,vo.getPrice());
			pstmt.setString(5,vo.getContent());
			pstmt.setString(6,vo.getAddress());
			pstmt.setString(7,vo.getWiter());


			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}


	}
	public void insertKey(String key1, String key2, String key3) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into key_word(key_word1, key_word2, key_word3, pno) values(?, ?, ?, key_word_seq.nextval)";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, key1);
			pstmt.setString(2, key2);
			pstmt.setString(3, key3);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	public void updateKey(String key1, String key2, String key3, String pno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update key_word set key_word1 = ?, key_word2 = ?, key_word3 = ? where pno =?";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, key1);
			pstmt.setString(2, key2);
			pstmt.setString(3, key3);
			pstmt.setString(4, pno);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	//	public void deletePost(postVO vo) {
	//		Connection conn = null;
	//		PreparedStatement pstmt = null;
	//
	//		String sql= "delete from post where pno = ?";
	//
	//		try {
	//			conn=DriverManager.getConnection(url,uid,upw);
	//			pstmt=conn.prepareStatement(sql);
	//			pstmt.setString(1, vo.getPno());
	//			pstmt.executeUpdate();
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		} finally {
	//			JdbcUtil.close(conn, pstmt, null);
	//		}
	//	}
	 
	//게시글 삭제
	public void deleteP(String pno) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql= "delete from post where pno = ?";

		try {
			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pno);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}

	//게시글 수정
	public int updateP(String pno, String title, String content, String address, String price, String category, String sellType) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update post set title = ?, content = ?, address = ?, price = ?, category = ?, sellType = ? where pno = ?";

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, address);
			pstmt.setString(4, price);
			pstmt.setString(5, category);
			pstmt.setString(6, sellType);
			pstmt.setString(7, pno);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}


		return result;
	}
	//내용 조회
	public postVO content(String pno) {

		postVO vo = new postVO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * \n" +
				"from (select p1.*, path, file_name \n" +
				"      from post p1 \n" +
				"      join up_file u1 \n" +
				"      on p1.pno = u1.pno) a\n" +
				"where a.pno = ?";

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pno);

			rs = pstmt.executeQuery();


			if(rs.next()) {

				String pno2 = rs.getString("pno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String address = rs.getString("address");
				String price = rs.getString("price");
				String witer = rs.getString("user_id");
				String categori = rs.getString("category");
				int hit = rs.getInt("hit");
				String sellType = rs.getString("sellType");
				String path = rs.getString("path")+rs.getString("file_name");
				System.out.println(path);
				vo.setPno(pno2);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setAddress(address);
				vo.setPrice(price);
				vo.setWiter(witer);
				vo.setCategori(categori);
				vo.setHit(hit);
				vo.setSellType(sellType);
				vo.setPath(path);
				System.out.println(path);
				System.out.println("실행");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

		return vo;
	}
	//조회수
	public void hitUpdate(String pno) {

		Connection conn = null; 
		PreparedStatement pstmt = null;

		String sql = "update post set hit = hit + 1 where pno = ?";

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pno);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}


	}

	public ArrayList<listVO> getList(String sort){ //게시판 리스트 출력 sort = 기준
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(sort);
		ArrayList<listVO> list = new ArrayList<>();

		String sql = "select  p2.*,nvl(num,0) as attention\n" +
				"from (select p1.pno, p1.user_id, p1.price, p1.address, hit, title, regdate,path, file_name \n" +
				"      from post p1 \n" +
				"      left join up_file u1 \n" +
				"      on p1.pno = u1.pno ) p2\n" +
				"left join (select pno, count(*)as num \n" +
				"            from attention \n" +
				"            group by pno) a1\n" +
				"on p2.pno = a1.pno\n" +
				"order by ? desc";

		try{
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sort);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String pno = rs.getString("pno");
				String writer = rs.getString("user_id");
				String price = rs.getString("price");
				String address = rs.getString("address");
				int hit = rs.getInt("hit");
				String title = rs.getString("title");
				Timestamp regdate = rs.getTimestamp("regdate");
				String path = rs.getString("path");
				String file = rs.getString("file_name");
				String attention = rs.getString("attention");
				String p = (path+file);
				list.add(new listVO(pno, writer, price, address, hit, title, attention, regdate,p));
				System.out.println(p);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	public ArrayList<listVO> search (String sch, String sort){ //검색기능

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    ArrayList<listVO> list = new ArrayList<>();
	    String sql = "SELECT a.*, NVL(num, 0) AS num\n" +
				"FROM (select p2.*, key_word1,key_word2,key_word3\n" +
				"      FROM (select p1.pno, p1.user_id, p1.price, p1.address, hit, title, regdate,path, file_name ,content\n" +
				"            from post p1 \n" +
				"            left join up_file u1 \n" +
				"            on p1.pno = u1.pno ) p2 \n" +
				"     JOIN key_word k1\n" +
				"     ON p2.pno = k1.pno) a\n" +
				"LEFT JOIN (SELECT pno, COUNT(*) AS num\n" +
				"            FROM attention\n" +
				"            GROUP BY pno) b\n" +
				"ON a.pno = b.pno\n" +
				"WHERE (COALESCE(key_word1, '') || ' ' || COALESCE(key_word2, '') || ' ' || COALESCE(key_word3, '') || ' ' || title || ' ' || content || ' ' || address) LIKE '%' || ? || '%'\n" +
				"ORDER BY \n" +
				"CASE WHEN ? = 'pno' THEN a.pno END DESC,\n" +
				"CASE WHEN ? = 'hit' THEN hit END DESC,\n" +
				"CASE WHEN ? = 'num' THEN num END DESC,\n" +
				"CASE WHEN ? = 'price' THEN price END DESC";
	    try{
	        conn = DriverManager.getConnection(url, uid, upw);
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(2, sort);
	        pstmt.setString(3, sort);
	        pstmt.setString(4, sort);
	        pstmt.setString(5, sort);
	        pstmt.setString(1, sch);
	        rs = pstmt.executeQuery();

	        while(rs.next()){
	            String title = rs.getString("title");
	            String writer = rs.getString("user_id");
	            String price = rs.getString("price");
	            String address = rs.getString("address");
	            int hit = rs.getInt("hit");
	            Timestamp regDate = rs.getTimestamp("regDate");
	            String pno = rs.getString("pno");
	            String attention = rs.getString("num");
				String path = rs.getString("path");
				String file = rs.getString("file_name");

	            String f = (path+file);
	            
	           list.add(new listVO(pno, writer, price, address, hit, title, attention, regDate, f));
	            


	        }
	    }catch (Exception e){
	        e.printStackTrace();
	    }finally {
	        JdbcUtil.close(conn, pstmt, rs);
	    }

	    return list;
	}public ArrayList<listVO> getList2(String category, String sort) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<listVO> list = new ArrayList<>();

		String sql = "SELECT p2.*, NVL(num, 0) AS attention\n" +
				"FROM (\n" +
				"    SELECT p1.pno, p1.user_id, p1.price, p1.address, hit, title, regdate, path, file_name, category\n" +
				"    FROM post p1\n" +
				"    LEFT JOIN up_file u1 ON p1.pno = u1.pno\n" +
				") p2\n" +
				"LEFT JOIN (\n" +
				"    SELECT pno, count(*) AS num FROM attention GROUP BY pno\n" +
				") a1 ON p2.pno = a1.pno\n" +
				"WHERE category = ?\n" +
				"ORDER BY ";

		// 동적으로 정렬 방식을 추가
		if ("hit".equalsIgnoreCase(sort)) {
			sql += "hit DESC, p2.pno DESC";
		} else if ("price".equalsIgnoreCase(sort)) {
			sql += "price DESC, p2.pno DESC";
		} else if ("pno".equals(sort)){
			// 정렬 방식이 지정되지 않았을 때의 기본값
			sql += "p2.pno DESC";
		}else if("num".equals(sort)){
			sql += "attention DESC, p2.pno DESC";
		}
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String pno = rs.getString("pno");
				String writer = rs.getString("user_id");
				String price = rs.getString("price");
				String address = rs.getString("address");
				int hit = rs.getInt("hit");
				String title = rs.getString("title");
				String attention = rs.getString("attention");
				Timestamp regdate = rs.getTimestamp("regdate");
				String path = rs.getString("path");
				String file = rs.getString("file_name");
				list.add(new listVO(pno, writer, price, address, hit, title, attention, regdate,path+file));
			}

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public String getKey( String pno) { //키워드 조회
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String str = "";
		String sql = "Select COALESCE(key_word1, '-') as key_word1,COALESCE(key_word2,'-') as key_word2 ,COALESCE(key_word3, '-')as key_word3 from key_word where pno = ?";
		try {
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String key1 = rs.getString("key_word1");
				String key2 = rs.getString("key_word2");
				String key3 = rs.getString("key_word3");
				
				str = key1 + " " + key2 + " " + key3;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return str;
	}
	public ArrayList<listVO> getListMy(String id){ //게시판 리스트 출력 sort = 기준
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<listVO> list = new ArrayList<>();

		String sql = "select p2.*, nvl(num,0) as attention\n" +
				"from (select p1.pno, p1.user_id, p1.price, p1.address, hit, title, regdate,path, file_name, category \n" +
				"      from post p1 \n" +
				"      left join up_file u1 \n" +
				"      on p1.pno = u1.pno ) p2\n" +
				"left join (select pno, count(*)as num from attention group by pno) a1\n" +
				"on p2.pno = a1.pno \n" +
				"where user_id = ?\n" +
				"order by p2.pno desc";

		try{
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String pno = rs.getString("pno");
				String writer = rs.getString("user_id");
				String price = rs.getString("price");
				String address = rs.getString("address");
				int hit = rs.getInt("hit");
				String title = rs.getString("title");
				String attention = rs.getString("attention");
				Timestamp regdate = rs.getTimestamp("regdate");
				String path = rs.getString("path");
				String file = rs.getString("file_name");
				list.add(new listVO(pno, writer, price, address, hit, title, attention, regdate, path+file));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	public ArrayList<listVO> getAttention(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<listVO> list = new ArrayList<>();

		String sql = "select * \n" +
				"from (select * from attention where user_id = ?)a \n" +
				"left join (select p2.* ,nvl(num,0) as attention\n" +
				"            from (select p1.pno, p1.user_id, p1.price, p1.address, hit, title, regdate,path, file_name, category \n" +
				"      from post p1 \n" +
				"      left join up_file u1 \n" +
				"      on p1.pno = u1.pno ) p2\n" +
				"left join (select pno, count(*)as num from attention group by pno) a1\n" +
				"on p2.pno = a1.pno \n" +
				"order by p2.pno desc) p \n" +
				"on a.pno = p.pno \n" +
				"order by a.pno desc";

		try{
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String pno2 = rs.getString("pno");
				String writer = rs.getString("user_id");
				String price = rs.getString("price");
				String address = rs.getString("address");
				int hit = rs.getInt("hit");
				String title = rs.getString("title");
				String attention = rs.getString("attention");
				Timestamp regdate = rs.getTimestamp("regdate");
				String path = rs.getString("path");
				String file = rs.getString("file_name");
				list.add(new listVO(pno2, writer, price, address, hit, title, attention, regdate,path+file));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	public void insertAtention(String pno, String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into attention(attention, user_id, pno) values(0,?,? )";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, id);
			pstmt.setString(2, pno);
			;
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	public void deleteAtention(String pno, String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from attention where user_id = ? and pno = ? ";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, id);
			pstmt.setString(2, pno);
			;
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	public int checkAtention(String pno, String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from attention where user_id = ? and pno = ? ";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, id);
			pstmt.setString(2, pno);
			;
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		return 0;
	}
	public void deleteKey(String pno) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql= "delete from key_word where pno = ?";

		try {
			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pno);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	public void deleteAtentionPost(String pno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from attention where pno = ? ";

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);


			pstmt.setString(1, pno);
			;

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
}
