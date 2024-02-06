package web_project.seveltjsp.jsp_PRJ.repository;

import jakarta.servlet.http.HttpServlet;
import web_project.seveltjsp.jsp_PRJ.entity.Post;
import web_project.seveltjsp.jsp_PRJ.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository extends HttpServlet {
    private final String url = "jdbc:oracle:thin:@db.newlecture.com:1521/xepdb1";
    private final String user = "RLAND";
    private final String password = "0530";

    public ProductRepository() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public List<Product> findAll() {
        String sql = "select * from ZXC_LIST";

        try (Connection c = getConnection();
             PreparedStatement st = c.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            List<Product> list = new ArrayList<>();

            while (rs.next()) {
                list.add(setUpData(rs));
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Product> findByCategory(int category) {
        String sql = "select * from ZXC_LIST where CATEGORY = ?";

        try (Connection c = getConnection();
             PreparedStatement s = c.prepareStatement(sql)) {

            s.setInt(1, category);

            try (ResultSet rs = s.executeQuery()) {
                List<Product> list = new ArrayList<>();
                while (rs.next()) {
                    list.add(setUpData(rs));
                }
                return list;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Product setUpData(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setName(rs.getString("NAME"));
        product.setImg(rs.getString("IMG"));
        product.setPrice(rs.getInt("PRICE"));
        product.setCategory(rs.getInt("CATEGORY"));
        return product;
    }
}
