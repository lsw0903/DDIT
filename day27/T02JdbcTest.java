package day27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T02JdbcTest {
/*
 	문제1) 사용자로부터 lprod_id값을 입력받아 입력한 값보다
 	      lprod_id가 큰 레코드값을 출력하시오.
*/
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// JDBC 작업에 필요한 객체변수 선언하기
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.print("lprod_id값 입력 >> ");
		int lprod_id = scan.nextInt();
		
		System.out.println("lprod_id => " + lprod_id);
		
		try {
			// 1. 드라이버 로딩(옵션)
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			// 2. DB에 접속하기(Connection 객체 생성)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1588/FREEPDB1",
					"sem",
					"java");
			
			stmt = conn.createStatement();
			
			String sql = "select * from lprod where lprod_id > " + lprod_id;
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("lprod_gu : " + rs.getString("lprod_gu"));
				System.out.println("lprod_nm : " + rs.getString("lprod_nm"));
				System.out.println("-------------------------------------");
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			// ★★다 쓴 자원 반납하기(필수)★★
			if(rs != null) try {rs.close();}catch(SQLException ex){}
			if(stmt != null) try {stmt.close();}catch(SQLException ex){}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex){}
			
		}
	}
}