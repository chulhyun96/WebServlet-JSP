package web_project.seveltjsp.jsp_PRJ.model.repository;

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
        return -2; // 데이터베이스 오류
    }
}
