package web_project.seveltjsp.jsp_PRJ.controller.servlet.post;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.VO.PostVO;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.service.PostService;

import java.io.IOException;

@WebServlet("/post/update-form")
public class PostUpdateFormController extends HttpServlet {
    private PostService service;

    public PostUpdateFormController() {
        this.service = new PostService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tableId = request.getParameter("tableId");
        PostVO post = service.findPostByTableId(tableId);

        request.setAttribute("post",post);
        response.sendRedirect("/list");
    }
}
