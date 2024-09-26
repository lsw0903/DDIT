package day35;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class T02DomParsingTest {
	
	public void parse() throws ParserConfigurationException, SAXException, IOException {
	
		// XML문서를 생성하기 위한 DocumentBuilder객체 생성하기
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		// DOM 파서를 이용하여 Document 객체 생성
		Document document = db.parse(
							new File("new_book.xml"));
		
		// Document 객체로부터 루트 앨리먼트 객체 가져오기
		Element root = document.getDocumentElement();
		System.out.println("루트 엘리먼트 태그명 : " + root.getTagName());
		
		// 하위 앨리먼트 접근하기 (getElementByTagName() 사용)
		NodeList bookNodeList = root.getElementsByTagName("book");
		Node firstBookNode = bookNodeList.item(0); // 첫번째 항목
		Element firstBookElement = (Element) firstBookNode;
		
		// 속성값 접근하기 (getAttribute() 사용)
		System.out.println("첫번째 책의 ISBN값 : " 
				+ firstBookElement.getAttribute("isbn"));
		 
		// 전체 책 내용 출력하기
		System.out.println("---------------------------------------");
		System.out.printf("%8s %8s %12s %10s %8s\n", 
						  "ISBN", "분류", "제목", "저자", "가격");
		System.out.println("---------------------------------------");
		
		for(int i=0; i<bookNodeList.getLength(); i++) {
			
			Element bookEl = (Element) bookNodeList.item(i);
			
			String isbn = bookEl.getAttribute("isbn");
			String kind = bookEl.getAttribute("kind");
			String title = bookEl.getElementsByTagName("title").
										item(0).getTextContent();			
			String author = bookEl.getElementsByTagName("author").
					item(0).getTextContent();
			String price = bookEl.getElementsByTagName("price").
					item(0).getTextContent();
			
			System.out.printf("%8s %8s %12s %10s %8s\n", 
							  isbn, kind, title, author, price);
		}
	}
	
	public static void main(String[] args) throws Exception {
		new T02DomParsingTest().parse();
	}
}