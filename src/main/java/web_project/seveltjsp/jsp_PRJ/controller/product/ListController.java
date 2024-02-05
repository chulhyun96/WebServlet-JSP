package web_project.seveltjsp.jsp_PRJ.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.entity.Product;
import web_project.seveltjsp.jsp_PRJ.service.ProductService;

import java.io.IOException;
import java.util.List;


//controller
@WebServlet("/category/list")
public class ListController extends HttpServlet {
    private final ProductService service;

    public ListController() throws ClassNotFoundException {
        this.service = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category_ = request.getParameter("category");
        int category = (category_ == null) ? 0 : Integer.parseInt(category_);

        List<Product> list;
        if (category > 0) {
            list = service.findByCategory(category);
        } else {
            list = service.findAll();
        }

        request.setAttribute("list",list);
        request.getRequestDispatcher("/WEB-INF/menu/view/list.jsp").forward(request, response);
    }
}
