package web_project.seveltjsp.jsp_PRJ.model.repository;

import web_project.seveltjsp.jsp_PRJ.model.entity.Member;
import web_project.seveltjsp.jsp_PRJ.model.entity.Post;

import java.sql.*;

public class PostDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public PostDAO() {
        try{
            String url = "jdbc:mysql://localhost:3306/WEB?serverTimezone=UTC";
            String user ="root";
            String pw = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pw);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" [ERROR] " + e.getMessage());
        }
    }

    public Member findByUserId(String userId) {
        String sql = "select * from WEB.Member where UserID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                String userID = rs.getString(1);
                return new Member(userID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("e = " + e.getMessage());
        }
        return null;
    }

    public int submitPost(Post post) {
        String sql = "insert into Post(Subject,Content,UserID,Available) values(?,?,?,?)";
        /*String sql = "INSERT INTO WEB.Post (Subject,Content,UserID,Available)" +
                "        SELECT ? , ? , UserID, 1" +
                "        FROM Member" +
                "        WHERE UserID = ?";*/

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,post.getSubject());
            pstmt.setString(2,post.getContent());
            pstmt.setString(3,post.getMember().getUserID());
            pstmt.setInt(4,1);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
