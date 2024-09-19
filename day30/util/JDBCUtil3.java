package day30.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

/*
 	JDBC 드라이버 로딩 및 커넥션 객체를 생성하기 위한  메서드 제공 유틸클래스
*/
public class JDBCUtil3 {
/*
	db.properties파일의 내용으로 DB정보를 설정하는 방법
	방법2) ResourceBundle 객체 이용하기
*/
	
	static ResourceBundle bundle; // Properties 객체 변수 선언
	
	static {  // 스태틱 블록 - 블럭안에 작성한 코드는 스태틱
		
		bundle = ResourceBundle.getBundle("db");
		
		try {	
			Class.forName(bundle.getString("driver"));
			System.out.println("드라이버 로딩 완료!!");
			
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	 	커넥션 객체를 생성하기 위한 메서드
	 	@return 생성된 커넥션 객체
	*/
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("username"),
					bundle.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
	
	/*
	 	자원반납 위한 메서드
	 	@param conn
	 	@param stmt
	 	@param pstmt
	 	@param rs
	*/
	public static void close(Connection conn, Statement stmt,
			                 PreparedStatement pstmt, ResultSet rs) {
		// ★★다 쓴 자원 반납하기(필수)★★
	    if(rs != null) try {rs.close();}catch(SQLException ex){}
		if(stmt != null) try {stmt.close();}catch(SQLException ex){}
		if(pstmt != null) try {pstmt.close();}catch(SQLException ex){}
		if(conn != null) try {conn.close();}catch(SQLException ex){}
	}
}