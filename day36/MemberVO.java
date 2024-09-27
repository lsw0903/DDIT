package day36;

import java.util.List;

public class MemberVO {
	private String name;
	private long age;
	private String job;
	private String addr;
	private List<MemberVO> memList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public List<MemberVO> getMemList() {
		return memList;
	}
	public void setMemList(List<MemberVO> memList) {
		this.memList = memList;
	}
	
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", age=" + age + ", job=" + job + ", addr=" + addr + "]";
	}
}