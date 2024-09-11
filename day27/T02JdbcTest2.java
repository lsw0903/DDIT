package day27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T02JdbcTest2 {
/*
 	문제2) lprod_id값을 2개 입력받아서 두 값 중 작은 값부터
 	      큰 값 사이의 레코드 값을 출력하시오.
*/
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// JDBC 작업에 필요한 객체변수 선언하기
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//System.out.print("lprod_id값 입력 >> ");
		//int lprod_id = scan.nextInt();
		
		//System.out.println("lprod_id => " + lprod_id);
		
		System.out.print("lprod_id값 2개 입력 >> ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		
		int max = Math.max(num1, num2);
		int min = Math.min(num1, num2);
		
		try {
			// 1. 드라이버 로딩(옵션)
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			// 2. DB에 접속하기(Connection 객체 생성)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1588/FREEPDB1",
					"sem",
					"java");
			
			stmt = conn.createStatement();
			
			//String sql = "select * from lprod where lprod_id > " + lprod_id;
			
			String sql ="select * from lprod "
					   +" where lprod_id between "
					   + min + " and " + max;
			
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