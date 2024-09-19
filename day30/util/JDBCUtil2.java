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

/*
 	JDBC 드라이버 로딩 및 커넥션 객체를 생성하기 위한  메서드 제공 유틸클래스
*/
public class JDBCUtil2 {
/*
	db.properties파일의 내용으로 DB정보를 설정하는 방법
	방법1) Properties 객체 이용하기
*/
	
	static Properties prop; // Properties 객체 변수 선언
	
	static {  // 스태틱 블록 - 블럭안에 작성한 코드는 스태틱
		
		prop = new Properties();
		
		try {
			prop.load(new FileInputStream("db.properties"));
			
			Class.forName(prop.getProperty("driver"));
			System.out.println("드라이버 로딩 완료!!");
			
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 	커넥션 객체를 생성하기 위한 메서드
	 	@return 생성된 커넥션 객체
	*/
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("username"),
					prop.getProperty("password"));
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