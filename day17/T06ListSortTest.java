package day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T06ListSortTest {
	public static void main(String[] args) {
		
		List<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "011-1111-1111"));
		memList.add(new Member(5, "변학도", "011-1111-2222"));
		memList.add(new Member(9, "성춘향", "011-1111-3333"));
		memList.add(new Member(3, "이순신", "011-1111-4444"));
		memList.add(new Member(6, "강감찬", "011-1111-5555"));
		memList.add(new Member(2, "일지매", "011-1111-6666"));
		
		System.out.println("정렬 전 : ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------------------");
		
		Collections.sort(memList);
		
		System.out.println("정렬 후 : ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------------------");
		
		
		Collections.shuffle(memList);
		
		System.out.println("섞은 후 : ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------------------");
		
		Collections.sort(memList, new SortName());
		
		System.out.println("외부정렬자 이용하여 정렬 후 : ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------------------");
	}

}


// Member객체의 번호(num)의 내림차순으로 정렬하기
class Member implements Comparable<Member> {
	
	private int num;		// 번호
	private String name;	// 이름
	private String tel;		// 전화번호
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tell=" + tel +"]";
	}
	
	@Override
	public int compareTo(Member mem) {
		
		/*if(this.getNum() > mem.getNum()) {
			return -1;
		} else if(this.getNum() == mem.getNum()) {
			return 0;
		} else {
			return 1;
		}*/
		
		/*return Integer.valueOf(this.getNum())
				.compareTo(mem.getNum());*/
		
		return Integer.compare(this.getNum(), mem.getNum()) * -1;
	}
}

// Member객체의 이름의 오름차순 정렬기능 부여하기
class SortName implements Comparator<Member> {

	@Override
	public int compare(Member mem1, Member mem2) {
		
		return mem1.getName().compareTo(mem2.getName());
	}
	
}