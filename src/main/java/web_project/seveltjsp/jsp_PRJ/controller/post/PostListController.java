package web_project.seveltjsp.jsp_PRJ.controller.post;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import web_project.seveltjsp.jsp_PRJ.entity.Post;
import web_project.seveltjsp.jsp_PRJ.service.PostService;

import java.io.IOException;
import java.util.List;

@WebServlet("/post/list")
public class PostListController extends HttpServlet {
    private final PostService service;

    @SneakyThrows
    public PostListController() {
        this.service = new PostService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> postList = service.getList();
        request.setAttribute("PostList", postList);
        request.getRequestDispatcher("/WEB-INF/menu/view/posting/post.jsp").forward(request,response);
    }
}
