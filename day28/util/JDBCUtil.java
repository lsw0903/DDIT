package day28.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 	JDBC 드라이버 로딩 및 커넥션 객체를 생성하기 위한  메서드 제공 유틸클래스
*/
public class JDBCUtil {
	
	static {  // 스태틱 블록 - 블럭안에 작성한 코드는 스태틱
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
					"jdbc:oracle:thin:@localhost:1588/FREEPDB1",
					"sem",
					"java");
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