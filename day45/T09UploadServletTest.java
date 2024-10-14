package day45;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload3")
@MultipartConfig(fileSizeThreshold = 1024*1024,
				 maxFileSize = 1024*1024*20,
				 maxRequestSize = 1024*1024*50)
public class T09UploadServletTest extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * System.out.println("===========================================");
		 * 
		 * BufferedReader br = new BufferedReader( new InputStreamReader(
		 * req.getInputStream()));
		 * 
		 * String readLine = ""; while((readLine = br.readLine()) != null) {
		 * System.out.println(readLine);
		 * 
		 * System.out.println("===========================================");
		 */
		
		// Multipart 파싱 전 파라미터 값 조회하기
		req.setCharacterEncoding("UTF-8");
		System.out.println("Multipart 파싱 전 파라미터 값 => "
				+ req.getParameter("sender"));
		
		String uploadPath = req.getServletContext().getRealPath("/")
				+ "upload_files";
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		try {
			String fileName = "";
			
			for(Part part : req.getParts()) {
				
				System.out.println(part.getHeader("content-disposition"));
				
				System.out.println("전송된 Part명 : " + part.getName());
				fileName = part.getSubmittedFileName(); // 전송된 파일명
				
				if(fileName != null && !fileName.equals("")) {
					// 폼필드가 아니거나 파일이 비어있지 않은 경우...(첨부파일 존재할 경우)
					part.write(uploadPath + File.separator + fileName); // 파일저장
					System.out.println("파일명 : " 
							+ uploadPath + File.separator + fileName + "업로드 완료!");
				}
				
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}