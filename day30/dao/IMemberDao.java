package day30.dao;

import java.time.LocalDate;
import java.util.List;

import day30.vo.MemberVO;

/*
 	실제 DB에 연결해서 SQL문을 수행한 후 결과를 Service에 전달하는 DAO 인터페이스
*/
public interface IMemberDao {
	
	/*
	 	MemberVO에 담겨진 회원정보를 DB에 insert하기 위한 메서드
	 	@param mv 등록할 회원정보를 담은 MemberVO 객체
	 	@return 등록작업이 성공하면 1 이 반환되고 실패하면 0 이 반환됨
	*/
	public int insertMember(MemberVO mv);
	
	/*
	 	해당 회원이 DB에 존재하는지 체크하기 위한 메서드
	 	@param memId 존재여부를 체크할 회원ID
	 	@return 회원이 존재하면 true, 존재하지 않으면 false 리턴함.
	*/
	public boolean checkMember(String memId);
	
	/*
 		MemberVO에 담겨진 회원정보를 DB에 update하기 위한 메서드
 		@param mv 수정할 회원정보를 담은 MemberVO 객체
 		@return 수정작업이 성공하면 1 이 반환되고 실패하면 0 이 반환됨
    */
	public int updateMember(MemberVO mv);
	
	/*
		DB에 존재하는 회원정보를 삭제하기 위한 메서드
		@param memId 삭제할 회원ID
		@return 삭제작업이 성공하면 1 이 반환되고 실패하면 0 이 반환됨
	 */
	public int deleteMember(String memId);
	
	/*
		DB에 존재하는 모든 회원정보를 조회하기 위한 메서드
		@return 전체 회원정보를 담은 List객체
	*/
	public List<MemberVO> selectAllMember();
	
	
	/*
		회원정보를 이용한 회원 검색기능을 제공하기 위한 메서드 
		@param mv 검색할 회원정보를 담은 MemberVO객체
		@return 검색된 회원정보를 담은 List 객체
	*/
	public List<MemberVO>  searchMember(MemberVO mv);
	
	

}