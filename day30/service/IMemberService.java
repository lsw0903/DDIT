package day30.service;

import java.util.List;

import day30.vo.MemberVO;

/*
 	Service 객체는 컨트롤러의 요청을 받아 필요한 기능을 제공하는 객체이다.
 	DB 작업이 필요하다면 DAO 객체에게 위임하여 결과를 받아와 처리한다.
*/
public interface IMemberService {
	
	/*
	 	MemberVO에 담겨진 데이터를 이용해서 회원등록 처리를 하기 위한 메서드
	 	@param mv 회원정보를 담은 MemberVO 객체
	 	@return 회원등록이 성공하면 1, 실패하면 0 리턴함
	*/
	public int registMember(MemberVO mv);
	
	/*
 		MemberVO에 담겨진 데이터를 이용해서 회원수정 처리를 하기 위한 메서드
 		@param mv 회원정보를 담은 MemberVO 객체
 		@return 회원수정이 성공하면 1, 실패하면 0 리턴함
    */
	public int modifyMember(MemberVO mv);
	
	/*
		회원정보 삭제 처리를 위한 메서드
		@param memId 삭제할 회원ID
		@return 회원삭제 성공하면 1, 실패하면 0 리턴함.
	*/
	public int removeMember(String memId);
	
	/*
		회원정보가 존재하는지 확인하기 위한 메서드
		@param memId 회원정보 존재여부 확인하기 위한 회원ID
		@return 해당 회원이 존재하면 true, 존재하지 않으면 false 리턴함.
	*/
	public boolean checkMember(String memId);
	
	/*
		전체 회원정보를 가져오기 위한 메서드
		@return 전체 회원정보를 담은 List 객체
	*/
	public List<MemberVO> displayAllmember();
	
	/*
	  	회원정보를 검색하기 위한 메서드
	  	@param mv 회원정보를 담은 MemberVO 객체
	  	@return 검색된 회원정보를 담은 List 객체
	*/
	public List<MemberVO> searchMember(MemberVO mv);
}