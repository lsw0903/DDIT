package day06;

public class ArrayCopyExample {
	public static void main(String[] args) {
		
		String[] oldStrArray = { "java", "array", "copy" };
		String[] newStrArray = new String[5];
		String[] newStrArray2 = new String[5];
		
		
		
		
		System.arraycopy( oldStrArray, 0, newStrArray, 0, oldStrArray.length );
		
		for(int i=0; i<newStrArray.length; i++) {
			System.out.print(newStrArray[i] + ", ");
		}
		
		oldStrArray[0] = "python";
		
		System.out.println("newStrArray2 내용 시작....");
		for(int i=0; i<newStrArray2.length; i++) {
			System.out.print(newStrArray2[i] + ", ");
		}
	}

}
