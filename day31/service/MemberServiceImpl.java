package day31.service;

import java.util.List;

import day31.dao.IMemberDao;
import day31.dao.MemberDaoImplForJDBC;
import day31.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	
	private static IMemberService memsService = new MemberServiceImpl();
	
	private IMemberDao memDao;
	
	private MemberServiceImpl() {
		memDao = MemberDaoImplForJDBC.getInstance();
	}
	
	public static IMemberService getInstance() {
		return memsService;
	}

	@Override
	public int registMember(MemberVO mv) {
		
		int cnt = memDao.insertMember(mv);
		
		// 신규회원에게 환영메일 발송기능 호출
		
		return cnt;
	}

	@Override
	public int modifyMember(MemberVO mv) {

		int cnt = memDao.updateMember(mv);
		
		return cnt;
	}

	@Override
	public int removeMember(String memId) {

		int cnt = memDao.deleteMember(memId);
		
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {

		return memDao.checkMember(memId);
	}

	@Override
	public List<MemberVO> displayAllmember() {
		List<MemberVO> memList = memDao.selectAllMember();
		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {

		List<MemberVO> memList = memDao.searchMember(mv);
		
		return memList;
	}
}