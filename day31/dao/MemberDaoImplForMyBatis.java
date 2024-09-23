package day31.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import day31.vo.MemberVO;
import day31.util.MyBatisUtil;

public class MemberDaoImplForMyBatis implements IMemberDao{
	
	private static IMemberDao memDao = new MemberDaoImplForMyBatis();
	
	private MemberDaoImplForMyBatis() {
		
	}
	
	public static IMemberDao getInstance() {
		return memDao;
	}

	@Override
	public int insertMember(MemberVO mv) {

		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.insert("member.insertMember", mv);
			sqlSession.commit(); // 커밋...
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		
		boolean isExist = false;
		
		try {
			int cnt = sqlSession.selectOne("member.checkMember", memId);
			
			if(cnt > 0) {
				isExist = true;
			}
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return isExist;
	}

	@Override
	public int updateMember(MemberVO mv) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(false);
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.insert("member.updateMember", mv);
			sqlSession.commit(); // 커밋...
		}catch(PersistenceException ex) {
			sqlSession.rollback();
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {

		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.insert("member.deleteMember", memId);
			sqlSession.commit(); // 커밋...
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		
	    List<MemberVO> memList = new ArrayList<MemberVO>();
	    
	    SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
	    
	    try {
	    	
	    	memList = sqlSession.selectList("member.getAllMember");
	    	
	    }catch(PersistenceException ex) {
	    	ex.printStackTrace();
	    }finally {
	    	sqlSession.close();
	    }
		
		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		
		try {
			memList = sqlSession.selectList("member.searchMember", mv);
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return memList;
	}
}