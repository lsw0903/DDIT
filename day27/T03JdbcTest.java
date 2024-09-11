package day27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class T03JdbcTest {
/*
 	lprod_id : 101, lprod_gu : N101, lprod_nm : 농산물
 	lprod_id : 102, lprod_gu : N102, lprod_nm : 수산물
 	lprod_id : 103, lprod_gu : N103, lprod_nm : 축산물
 	
 	위 3개의 데이터를 추가하기.
*/
	public static void main(String[] args) {
		
		// JDBC 작업에 필요한 객체변수 선언하기
				Connection conn = null;
				Statement stmt = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
		
		try {
			// 1. 드라이버 로딩(옵션)
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			// 2. DB에 접속하기(Connection 객체 생성)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1588/FREEPDB1",
					"sem",
					"java");
			
			stmt = conn.createStatement();
			
			String sql = " insert into lprod (lprod_id, lprod_gu, lprod_nm) "
					     + " values (101, 'N101', '농산물') ";
			
			int cnt = stmt.executeUpdate(sql);
			System.out.println("실행 후 결과값 : " + cnt);
			//--------------------------------------------------------
			
			sql = " insert into lprod (lprod_id, lprod_gu, lprod_nm) "
				     + " values (102, 'N102', '수산물') ";
		
		    cnt = stmt.executeUpdate(sql);
		    System.out.println("실행 후 결과값 : " + cnt);
		  //--------------------------------------------------------
		    
		    sql = " insert into lprod (lprod_id, lprod_gu, lprod_nm) "
				     + " values (103, 'N103', '축산물') ";
		
		    cnt = stmt.executeUpdate(sql);
		    System.out.println("실행 후 결과값 : " + cnt);
			
		    
			if(cnt > 0) {
				System.out.println("정상적으로 등록되었습니다.");
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