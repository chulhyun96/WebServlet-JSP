package web_project.seveltjsp.jsp_PRJ.model.repository;

import web_project.seveltjsp.jsp_PRJ.model.VO.PostVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public List<PostVO> findAll() {
        return new ArrayList<PostVO>();
    }

}
