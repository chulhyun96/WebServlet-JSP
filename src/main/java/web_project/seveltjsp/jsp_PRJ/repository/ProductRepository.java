package web_project.seveltjsp.jsp_PRJ.repository;

import jakarta.servlet.http.HttpServlet;
import web_project.seveltjsp.jsp_PRJ.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//rep
public class ProductRepository extends HttpServlet {
    private final String url = "jdbc:oracle:thin:@db.newlecture.com:1521/xepdb1";
    private final String user = "RLAND";
    private final String password = "0530";

    public ProductRepository() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }

    public List<Product> findAll() {
        try {
                String sql = "select * from ZXC_LIST";

                Connection c = DriverManager.getConnection(url, user, password);
                PreparedStatement st = c.prepareStatement(sql);
                ResultSet rs = st.executeQuery();


                List<Product> list = new ArrayList<>();
                while (rs.next()) {
                    Product product = new Product();
                    product.setName(rs.getString("NAME"));
                    product.setImg(rs.getString("IMG"));
                    product.setPrice(rs.getInt("PRICE"));
                    product.setCategory(rs.getInt("CATEGORY"));
                    list.add(product);
                }

                return list;
            } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Product> findByCategory(int category) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from ZXC_LIST where CATEGORY = ?";

        try {
            Connection c = DriverManager.getConnection(url, "RLAND", "0530");
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1,category);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString("NAME"));
                p.setPrice(rs.getInt("PRICE"));
                p.setImg(rs.getString("IMG"));
                p.setCategory(rs.getInt("CATEGORY"));
                list.add(p);
            }
            return list;
         }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
