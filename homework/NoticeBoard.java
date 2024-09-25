package homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;
import day28.util.JDBCUtil2;

/*
    게시판 관리 프로그램을 구현한 코드
    게시글 목록, 글 작성, 수정, 삭제, 검색 기능을 제공
*/

public class NoticeBoard {
    
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    private Scanner scan = new Scanner(System.in);
    
    public void displayMenu() {
    	System.out.println();
        System.out.println("----------------------");
        System.out.println("  === 작 업 선 택 ===");
        System.out.println("  1. 게시글 작성");
        System.out.println("  2. 게시글 삭제");
        System.out.println("  3. 게시글 수정");
        System.out.println("  4. 전체 게시글 출력");
        System.out.println("  5. 게시글 검색");
        System.out.println("  6. 작업 끝.");
        System.out.println("----------------------");
        System.out.print("원하는 작업 선택 >> ");
    }
    
    public void start() {
        int choice;
        do {
            displayMenu();
            choice = scan.nextInt();
            switch (choice) {
                case 1:  // 게시글 작성
                    insertBoard();
                    break;
                case 2:  // 게시글 삭제
                    deleteBoard();
                    break;
                case 3:  // 게시글 수정
                    updateBoard();
                    break;
                case 4:  // 전체 게시글 출력
                    displayAllBoards();
                    break;
                case 5:  // 게시글 검색
                    searchBoard();
                    break;
                case 6:  // 작업 끝
                    System.out.println("작업을 마칩니다.");
                    break;
                default:
                    System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
            }
        } while (choice != 6);
    }
    
    // 전체 게시글 출력
    private void displayAllBoards() {
        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println(" 번호\t제목\t작성자\t작성일\t내용");
        System.out.println("--------------------------------------------------------");
        
        try {
            conn = JDBCUtil2.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM jdbc_board ORDER BY board_no";
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int no = rs.getInt("board_no");
                String title = rs.getString("board_title");
                String writer = rs.getString("board_writer");
                LocalDateTime date = rs.getTimestamp("board_date").toLocalDateTime();
                String content = rs.getString("board_content");
                
                System.out.println(no + "\t" + title + "\t" + writer + "\t" + date + "\t" + content);
            }
            System.out.println("--------------------------------------------------------");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil2.close(conn, stmt, pstmt, rs);
        }
    }
    
    // 게시글 작성
    private void insertBoard() {
        System.out.print("제목 >> ");
        String title = scan.next();
        
        System.out.print("작성자 >> ");
        String writer = scan.next();
        
        System.out.print("내용 >> ");
        scan.nextLine();  // 버퍼비우기
        String content = scan.nextLine();
        
        try {
            conn = JDBCUtil2.getConnection();
            String sql = "INSERT INTO jdbc_board (board_no, board_title, board_writer, board_date, board_content) "
                       + "VALUES (board_seq.NEXTVAL, ?, ?, SYSDATE, ?)";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, writer);
            pstmt.setString(3, content);
            
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println("게시글 작성 완료!");
            } else {
                System.out.println("게시글 작성 실패!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil2.close(conn, stmt, pstmt, rs);
        }
    }
    
    // 게시글 수정
    private void updateBoard() {
        System.out.print("수정할 게시글 번호 >> ");
        int no = scan.nextInt();
        
        System.out.print("새 제목 >> ");
        String title = scan.next();
        
        System.out.print("새 내용 >> ");
        scan.nextLine();  // 버퍼비우기
        String content = scan.nextLine();
        
        try {
            conn = JDBCUtil2.getConnection();
            String sql = "UPDATE jdbc_board SET board_title = ?, board_content = ? WHERE board_no = ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, no);
            
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println("게시글 수정 완료!");
            } else {
                System.out.println("게시글 수정 실패!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil2.close(conn, stmt, pstmt, rs);
        }
    }
    
    // 게시글 삭제
    private void deleteBoard() {
        System.out.print("삭제할 게시글 번호 >> ");
        int no = scan.nextInt();
        
        try {
            conn = JDBCUtil2.getConnection();
            String sql = "DELETE FROM jdbc_board WHERE board_no = ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);
            
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println("게시글 삭제 완료!");
            } else {
                System.out.println("게시글 삭제 실패!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil2.close(conn, stmt, pstmt, rs);
        }
    }
    
    // 게시글 검색
    private void searchBoard() {
        System.out.print("검색할 키워드 >> ");
        String keyword = scan.next();
        
        try {
            conn = JDBCUtil2.getConnection();
            String sql = "SELECT * FROM jdbc_board WHERE board_title LIKE ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
            
            rs = pstmt.executeQuery();
            
            System.out.println("--------------------------------------------------------");
            System.out.println(" 번호\t제목\t작성자\t작성일\t내용");
            System.out.println("--------------------------------------------------------");
            
            while (rs.next()) {
                int no = rs.getInt("board_no");
                String title = rs.getString("board_title");
                String writer = rs.getString("board_writer");
                LocalDateTime date = rs.getTimestamp("board_date").toLocalDateTime();
                String content = rs.getString("board_content");
                
                System.out.println(no + "\t" + title + "\t" + writer + "\t" + date + "\t" + content);
            }
            System.out.println("--------------------------------------------------------");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil2.close(conn, stmt, pstmt, rs);
        }
    }
    
    public static void main(String[] args) {
        NoticeBoard boardManager = new NoticeBoard();
        boardManager.start();
    }
}