package web_project.seveltjsp.jsp_PRJ.repository;

import web_project.seveltjsp.jsp_PRJ.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//rep
public class ProductRepository {

    public List<Product> findAll() {
        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String url = "jdbc:oracle:thin:@db.newlecture.com:1521/xepdb1";
                String sql = "select * from menu";

                Connection c = DriverManager.getConnection(url, "RLAND", "0530");
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(sql);

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
            } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
