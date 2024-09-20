package day31.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import day31.vo.MemberVO;

public class MyBatisTest {
	public static void main(String[] args) {
		// MyBatis를 이용하여 DB작업을 처리하는 순서
		// 1. MyBatis 환경설정파일을 읽어와 객체를 생성한다.
		
		SqlSessionFactory sessionFactory = null;
		
		try {
			// 1-1. 설정파일 읽어오기
			// 설정파일의 인코딩정보 설정(한글처리를 위해서...)
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");
			
			// 1-2 Reader객체를 사용하여 SqlSessionFactory 객체 생성하기
			sessionFactory = new SqlSessionFactoryBuilder().build(rd);
			
			rd.close(); // 스트림객체 닫기
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		// 2. 실행할 SQL문에 맞는 쿼리문을 호출하여 원하는 작업을 수행한다.
		// 2-1. insert 작업 연습
		System.out.println("insert작업 시작...");
		
		// 1) 저장할 데이터를 VO에 담는다.
		MemberVO mv = new MemberVO("d001", "최종윤", "999-33", "부산시");
		
		// 2) SqlSession객체를 이용하여 해당 쿼리문을 실행한다.
		//	ex) sqlSession.insert("namespace값.id값", 파라미터객체);
		//		반환값 : 성공한 레코드 수
		SqlSession sqlSession = sessionFactory.openSession(false); // 오토커밋 여부
		
		try {
			int cnt = sqlSession.insert("memberTest.insertMember", mv);
			
			if(cnt > 0) {
				System.out.println("insert작업 성공!");
				sqlSession.commit(); // 커밋수행...
			}else {
				System.out.println("insert작업 실패!!!");
			}
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close(); // 세션닫기
		}
		
		System.out.println("-----------------------------");
		
		// 2-1. update작업 연습
		System.out.println("update작업 시작...");
		
		mv = new MemberVO();
		mv.setMemId("d001");
		mv.setMemName("이지용");
		mv.setMemTel("333-333");
		mv.setMemAddr("서울");
		
	    sqlSession = sessionFactory.openSession();
	    
	    try {
	    	int cnt = sqlSession.update("memberTest.updateMember", mv);
	    	
	    	if(cnt > 0) {
	    		System.out.println("update작업 성공!");
	    		sqlSession.commit(); // 커밋수행...
	    	}else {
	    		System.out.println("update작업 실패!!!");
	    	}
	    	
	    }catch(PersistenceException ex) {
	    	ex.printStackTrace();
	    }finally {
	    	sqlSession.close();
	    }
	    System.out.println("-----------------------------");
	    
	    /*
	    // 2-3. delete 연습
	    System.out.println("delete작업 시작...");
	    
	    sqlSession = sessionFactory.openSession();
	    
	    try {
	    	int cnt = sqlSession.delete("memberTest.deleteMember", "d001");
	    	
	    	if(cnt > 0) {
	    		System.out.println("delete작업 성공!");
	    		sqlSession.commit(); // 커밋수행..
	    	}else {
	    		System.out.println("delete작업 실패!!!");
	    	}
	    	
	    }catch(PersistenceException ex) {
	    	ex.printStackTrace();
	    }finally {
	    	sqlSession.close();
	    }
	    */
	    
	    // 2-4. select 연습
	    // 1) 응답의 결과가 여러개일 경우
	    System.out.println("select 연습(응답결과가 여러개일 경우...)");
	    
	    sqlSession = sessionFactory.openSession(true);
	    
	    try{
	    	//응답결과가 여러개 일 경우에는 selectList()를 사용한다.
	    	List<MemberVO> memList = sqlSession.selectList("memberTest.getAllMember");
	    	for(MemberVO mv2 : memList) {
	    		System.out.println("ID : " + mv2.getMemId());
	    		System.out.println("이름 : " + mv2.getMemName());
	    		System.out.println("전화 : " + mv2.getMemTel());
	    		System.out.println("주소 : " + mv2.getMemAddr());
	    		System.out.println("등록일 : " + mv2.getRegDt());
	    		System.out.println("-----------------------------");
	    	}
	    	System.out.println("출력 끝...");
	    	
	    }catch(PersistenceException ex) {
	    	ex.printStackTrace();
	    }finally {
	    	sqlSession.close();
	    }
	    
	    // 2) 응답결과가 1개인 경우
	    System.out.println("select 연습 시작(응답결과가 1개인 경우...)");
	    
	    sqlSession = sessionFactory.openSession(true);
	    
	    try {
	    	// 응답결과가 1개인 경우에는 selectOne()를 이용한다.
	    	mv = sqlSession.selectOne("memberTest.getMember", "d001");
	    	
	    	System.out.println("ID : " + mv.getMemId());
    		System.out.println("이름 : " + mv.getMemName());
    		System.out.println("전화 : " + mv.getMemTel());
    		System.out.println("주소 : " + mv.getMemAddr());
    		System.out.println("등록일 : " + mv.getRegDt());
	    	
	    }catch(PersistenceException ex) {
	    	ex.printStackTrace();
	    }finally {
	    	sqlSession.close();
	    }
	    
	}
}