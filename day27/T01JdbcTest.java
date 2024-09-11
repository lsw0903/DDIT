package day27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class T01JdbcTest {
/*
 	JDBC를 이용한 작업처리 방법...
 	
 	1. JDBC드라이버 로딩하기(오라클 기준)
 	  => JDBC 드라이버(관련클래스)는 DB를 만든 회사에서 제공한다.
 	 Class.forName("oracle.jdbc.driver.OracleDriver");
 	 
 	2. 접속하기 : 접속에 성공하면 Connection객체가 생성된다.
 		 DriverManger.getConnection() 메서드를 이용한다.
 		 
    3. 쿼리문 실행 : Statement 또는 PreparedStatement 객체를 이용하여 SQL문을 실행한다.
    
    4. 결과 : 
      1) Sql문이 select 일 경우에는 ResultSet 객체가 반환된다.
         ResultSet객체에는 select 한 결과가 저장된다.
      2) SQL문이 insert, update, delete 일 경우 정수값을 반환한다.
         (정수값은 실행에 성공한 레코드 수를 의미한다.)
         
    5. 자원반납 (매우 중요!!!)
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
			
			// 3. Statement객체 생성 => Connection객체를 이용한다.
			stmt = conn.createStatement();
			
			// 4. SQL문을 Statement객체를 이용하여 실행하고
			//	  실행결과를 ResultSet객체에 저장한다.
			String sql = "select * from lprod";
			
			// 실행할 SQL문이 select인 경우에는 executeQuery()를 실행하고,
			// update, insert, delete 일 경우에는 executeUpdate()를 실행한다.
			rs = stmt.executeQuery(sql);
			
			// 5. ResultSet객체에 저장되어 있는 데이터를 반복문과 next()메서드를 이용하여
			//    차례대로 읽어와 처리한다.
			System.out.println("실행한 쿼리문 : " + sql);
			System.out.println("=== 쿼리문 실행 결과 ===");
			
			// rs.next() => ResultSet객체의 데이터를 가리키는 포인터를 다음 레코드로
			//              이동시키고 그 곳에 데이터가 있으면 true, 없으면 false 반환
			while(rs.next()) {
				// 컬럼의 데이터를 가져오는 방법
				// 방법1) rs.get자료형이름("컬럼명")
				// 방법2) rs.get자료형이름(컬럼번호) => 1 부터 시작
				System.out.println("lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("lprod_gu : " + rs.getString("lprod_gu"));
				System.out.println("lprod_nm : " + rs.getString(3)); // 순서를 지정해서도 가능하다
				System.out.println("------------------------------");
			}
			
			System.out.println("출력 끝...");
			
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