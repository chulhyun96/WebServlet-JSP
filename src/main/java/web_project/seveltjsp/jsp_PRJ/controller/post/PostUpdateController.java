package web_project.seveltjsp.jsp_PRJ.controller.post;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.model.VO.PostVO;
import web_project.seveltjsp.jsp_PRJ.model.service.PostService;

import java.io.IOException;

@WebServlet("/post/update")
public class PostUpdateController extends HttpServlet {
    private PostService service;

    public PostUpdateController() {
        this.service = new PostService();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tableId = Integer.parseInt(request.getParameter("tableId"));
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        PostVO postVO = PostVO.updatePost(tableId, subject, content);

        int result = service.update(postVO);
        if (result > 0) {
            response.sendRedirect("/post/list");
            return;
        }

        String viewPath = "/WEB-INF/error/updateError.jsp";
        request.getRequestDispatcher(viewPath).forward(request,response);
    }
}
