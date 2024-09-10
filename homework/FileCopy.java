package homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("d:/D_Other/Tulips.jpg");
			fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");
			
			int a = 0;
			
			while((a = fis.read()) != -1) {
				fos.write(a);
			}
			System.out.println("파일 복사 완료");
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}