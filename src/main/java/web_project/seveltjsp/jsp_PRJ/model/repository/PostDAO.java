package web_project.seveltjsp.jsp_PRJ.model.repository;

import web_project.seveltjsp.jsp_PRJ.model.VO.PostVO;
import web_project.seveltjsp.jsp_PRJ.model.entity.Member;
import web_project.seveltjsp.jsp_PRJ.model.entity.Post;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class PostDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public PostDAO() {
        try {
            String url = "jdbc:mysql://localhost:3306/WEB?serverTimezone=UTC";
            String user = "root";
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
            if (rs.next()) {
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
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, post.getSubject());
            pstmt.setString(2, post.getContent());
            pstmt.setString(3, post.getMember().getUserID());
            pstmt.setInt(4, 1);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[ERROR] = " + e.getMessage());
        }
        return -1; //데이터베이스 오류
    }

    public List<PostVO> findAll(int pageNumber) {
        List<PostVO> list = new ArrayList<>();
        String sql = "SELECT * FROM WEB.Post WHERE Post.Available = 1 ORDER BY TableID desc limit 5 offset ? ";
        System.out.println("sql = " + sql);
        try {
            int limit = 5;
            int offset = (pageNumber - 1) * limit;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, offset);
            rs = pstmt.executeQuery();
            PostVO postVO = null;
            while (rs.next()) {
                int tableId = rs.getInt("TableID");
                String subject = rs.getString("Subject");
                String content = rs.getString("Content");
                String userId = rs.getString("UserID");

                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
                Timestamp timestamp = rs.getTimestamp("Created_Date", cal);
                LocalDateTime createdDate = timestamp.toLocalDateTime();

                postVO = new PostVO(tableId, subject, content, userId, createdDate);
                list.add(postVO);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
