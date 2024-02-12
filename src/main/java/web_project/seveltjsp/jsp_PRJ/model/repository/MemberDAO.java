package web_project.seveltjsp.jsp_PRJ.model.repository;

import web_project.seveltjsp.jsp_PRJ.model.entity.Member;

import java.sql.*;

public class MemberDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public MemberDAO() {
        try {
            String url = "jdbc:mysql://localhost:3306/WEB?serverTimezone=UTC";
            String user ="root";
            String pw = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pw);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("데이터베이스 연결 실패: " + e.getMessage());

        }
    }
    public int login(String userID, String userPassword) {
        String sql = "select UserPassword from WEB.Member where UserID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                if (rs.getString(1).equals(userPassword)) {
                    return 1; //로그인 성공
                }
                return 0; // PW 틀림
            }
            return -1; // 회원 목록없음
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -2; // 걍 오류
    }

    public int addMember(Member member) {
        String sql = "insert into Member values (?, ?, ?)";
        try {
            if (validateDup(member.getUserID())) {
                final int DUP_ID = -100;
                return DUP_ID;
            }
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getUserID());
            pstmt.setString(2, member.getUserName());
            pstmt.setString(3, member.getUserPassword());
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[ERROR]" + e.getMessage());
        }
        return -2; //데이터베이스 오류
    }
    private boolean validateDup(String userID) {
        String sql = "select UserID from Member where UserID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                if(rs.getString(1).equals(userID)) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
