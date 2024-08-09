package homework;

public class Hw6 {
	public static void main(String[] args) {
		
		for(int i=2; i<=9; i++) {
			System.out.println("[" + i + "단]");
			for(int a=1; a<=9; a++) {
				System.out.println(i + " x " + a + " = " + i*a);
			}
		}
	}

}
