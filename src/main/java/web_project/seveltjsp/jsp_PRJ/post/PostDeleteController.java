package web_project.seveltjsp.jsp_PRJ.front_controller.post;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.VO.PostVO;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.service.PostService;

import java.io.IOException;

public class PostDeleteController implements Controller {
    private PostService service;

    public PostDeleteController() {
        this.service = new PostService();
    }

    @Override
    public ModelView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tableId = request.getParameter("tableId");
        PostVO postVO = service.findPostByTableId(tableId);
        service.delete(postVO);
        return new ModelView("/post/list");
    }
}
