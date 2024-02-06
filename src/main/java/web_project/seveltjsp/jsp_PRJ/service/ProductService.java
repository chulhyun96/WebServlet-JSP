package web_project.seveltjsp.jsp_PRJ.service;

import web_project.seveltjsp.jsp_PRJ.entity.Product;
import web_project.seveltjsp.jsp_PRJ.repository.ProductRepository;

import java.util.List;

//service
public class ProductService {
    private final ProductRepository rep;

    public ProductService() throws ClassNotFoundException {
        this.rep = new ProductRepository();
    }

    public List<Product> findAll() {
        return rep.findAll();

    }

    public List<Product> findByCategory(int category) {
        return rep.findByCategory(category);
    }
}
