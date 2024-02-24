package web_project.seveltjsp.jsp_PRJ.controller.post;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.controller.Controller;
import web_project.seveltjsp.jsp_PRJ.controller.ModelView;
import web_project.seveltjsp.jsp_PRJ.model.VO.PostVO;
import web_project.seveltjsp.jsp_PRJ.model.service.PostService;

import java.io.IOException;

public class PostUpdateFormController implements Controller {
    private PostService service;

    public PostUpdateFormController() {
        this.service = new PostService();
    }

    @Override
    public ModelView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tableId = request.getParameter("tableId");
        PostVO post = service.findPostByTableId(tableId);

        request.setAttribute("post",post);
        return new ModelView("/post/updateForm");
    }
}
