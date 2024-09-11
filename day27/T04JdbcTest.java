package day27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T04JdbcTest {
/*
	LPROD 테이블에 새로운 데이터 추가하기
	
	lprod_gu와 lprod_nm은 직접 입력받아 처리하고
	lprod_id는 현재의 lprod_id들 중 제일 큰 값보다 1 증가된 값으로 한다.
	(lprod_gu가 중복되는지 검사하도록 처리한다.)
*/
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = 0; // 중복 체크용
		
		String lprodGu = "";
		
		// JDBC 작업에 필요한 객체변수 선언하기
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		do {
			System.out.print("상품 분류 코드(LPROD_GU) 입력 >> ");
			lprodGu = scan.next();
			
			try {
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1588/FREEPDB1",
						"sem",
						"java");
				
				stmt = conn.createStatement();
				String sql = " select count(*) as cnt from lprod  "
						     + " where lprod_gu = '" + lprodGu + "' ";
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					count = rs.getInt("CNT");
					System.out.println("count : " + count);
				}
				
			}catch(SQLException ex) {
				ex.printStackTrace();
			}finally {
				// ★★다 쓴 자원 반납하기(필수)★★
				if(rs != null) try {rs.close();}catch(SQLException ex){}
				if(stmt != null) try {stmt.close();}catch(SQLException ex){}
				if(pstmt != null) try {pstmt.close();}catch(SQLException ex){}
				if(conn != null) try {conn.close();}catch(SQLException ex){}
			}
			
		}while(count > 0);
		
		System.out.print("상품명(LPROD_NM) 입력 >> ");
		String lprodNm = scan.next();
		
		//////////////////////////////////////////////
		
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1588/FREEPDB1",
					"sem",
					"java");
			
			stmt = conn.createStatement();
			String sql = " select max(lprod_id) + 1 as lprod_id from lprod ";
			
			rs = stmt.executeQuery(sql);
			
			int lprodId = 0;
					
			if(rs.next()) {
				lprodId = rs.getInt(1);
			}
			
			//////////////////////////////////////////////
			
			sql = " insert into lprod (lprod_id, lprod_gu, lprod_nm) "
			         + " values (?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, lprodId);
			pstmt.setString(2, lprodGu);
			pstmt.setString(3, lprodNm);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("정상적으로 등록되었습니다.");
			}
		
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			// ★★다 쓴 자원 반납하기(필수)★★
			if(rs != null) try {rs.close();}catch(SQLException ex){}
			if(stmt != null) try {stmt.close();}catch(SQLException ex){}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex){}
		}
	}
}