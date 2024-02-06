package web_project.seveltjsp.jsp_PRJ.repository;

import web_project.seveltjsp.jsp_PRJ.entity.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {

    public PostRepository() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }
    public List<Post> getPostList() {
        String sql = "select * from ASD_POST";
        List<Post> list;

        try (Connection c = getConnection();
             PreparedStatement s = c.prepareStatement(sql);
             ResultSet rs = s.executeQuery();) {

            list = new ArrayList<>();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getLong("ID"));
                post.setTitle(rs.getString("TITLE"));
                post.setContent(rs.getString("CONTENT"));
                post.setAuthor(rs.getString("AUTHOR"));
                post.setCreatedAt(rs.getString("REG_DATE"));
                list.add(post);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@db.newlecture.com:1521/xepdb1";
        String user = "RLAND";
        String password = "0530";
        return DriverManager.getConnection(url, user, password);
    }
}
