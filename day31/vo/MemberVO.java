package day31.vo;

import java.time.LocalDate;

/*
	DB 테이블에 있는 컬럼명을 참조하여 데이터를 객체화 하기 위한 클래스이다.
	
	<p>
	  DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.
	</p>
*/
public class MemberVO {
	private String memId;
	private String memName;
	private String memTel;
	private String memAddr;
	private LocalDate regDt;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String memId, String memName, String memTel, String memAddr) {
		super();
		this.memId = memId;
		this.memName = memName;
		this.memTel = memTel;
		this.memAddr = memAddr;
	}
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemTel() {
		return memTel;
	}
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	public LocalDate getRegDt() {
		return regDt;
	}
	public void setRegDt(LocalDate regDt) {
		this.regDt = regDt;
	}
	
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memName=" + memName + ", memTel=" + memTel + ", memAddr=" + memAddr
				+ "]";
	}
	
	
}