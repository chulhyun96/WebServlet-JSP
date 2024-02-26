package web_project.seveltjsp.jsp_PRJ.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.controller.servlet.Controller;
import web_project.seveltjsp.jsp_PRJ.controller.servlet.ModelView;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.VO.PostVO;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.service.PostService;

import java.io.IOException;


public class PostUpdateController implements Controller {
    private PostService service;

    public PostUpdateController() {
        this.service = new PostService();
    }

    @Override
    public ModelView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tableId = Integer.parseInt(request.getParameter("tableId"));
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        PostVO postVO = PostVO.updatePost(tableId, subject, content);

        int result = service.update(postVO);

        if (result > 0) {
            return new ModelView("/post/list");
        }
        return new ModelView("/error/updateError");
    }
}
