package web_project.seveltjsp.jsp_PRJ.front_controller.model.repository;

import web_project.seveltjsp.jsp_PRJ.front_controller.model.VO.PostVO;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.entity.Member;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.entity.Post;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private static final int PER_PAGE_POST = 5;

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
        String sql = "SELECT * FROM WEB.Post WHERE Post.Available = 1 ORDER BY TableID DESC limit 5 offset ? ";
        System.out.println("sql = " + sql);
        try {
            int offset = (pageNumber - 1) * PER_PAGE_POST;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, offset);
            rs = pstmt.executeQuery();

            PostVO postVO;
            while (rs.next()) {
                int tableId = rs.getInt("TableID");
                String subject = rs.getString("Subject");
                String content = rs.getString("Content");
                String userId = rs.getString("UserID");
                LocalDateTime createdDate = rs.getTimestamp("Created_Date").toLocalDateTime();
                postVO = new PostVO(tableId, subject, content, userId, createdDate);
                list.add(postVO);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int countPage() {
        String sql = "select COUNT(*) from WEB.Post where Available = 1";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            int totalPages = 0;
            if (rs.next()) {
                totalPages = rs.getInt(1);
            }
            return (int) Math.ceil((double) totalPages / PER_PAGE_POST);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public PostVO findPostByTableId(String tableId) {
        String sql = "select * from WEB.Post where TableID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tableId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                PostVO postVO = new PostVO();
                postVO.setTableId(rs.getInt("TableID"));
                postVO.setUserId(rs.getString("UserID"));
                postVO.setSubject(rs.getString("Subject"));
                postVO.setContent(rs.getString("Content"));
                return postVO;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    public List<PostVO> findPostByUserId(String userId) {
        String sql = "select * from WEB.Post JOIN WEB.Member ON WEB.Member.UserID = WEB.Post.UserID" +
                " WHERE Member.UserID = ? and Available = 1";

        List<PostVO> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userId);
            rs = pstmt.executeQuery();
            PostVO postVO;
            while (rs.next()) {


                int tableId = rs.getInt("TableID");
                String subject = rs.getString("Subject");
                String content = rs.getString("Content");
                String userID = rs.getString("UserID");
                LocalDateTime createdDate = rs.getTimestamp("Created_Date").toLocalDateTime();
                postVO = new PostVO(tableId, subject, content, userID, createdDate);
                list.add(postVO);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public int update(Post updatePost) {
        String sql = "Update Post set Subject = ?, Content = ? where TableId = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, updatePost.getSubject());
            pstmt.setString(2, updatePost.getContent());
            pstmt.setInt(3, updatePost.getId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(PostVO postVO) {
        String sql = "Update Post set Available = 0 where TableID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, postVO.getTableId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
