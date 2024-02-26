package web_project.seveltjsp.jsp_PRJ.post;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web_project.seveltjsp.jsp_PRJ.controller.servlet.Controller;
import web_project.seveltjsp.jsp_PRJ.controller.servlet.ModelView;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.VO.PostVO;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.service.PostService;

import java.io.IOException;
import java.util.List;

public class PostMyListController implements Controller {
    private PostService service;
    public PostMyListController() {
        this.service = new PostService();
    }
    @Override
    public ModelView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String userId = (String) session.getAttribute("userID");
        System.out.println("userId = " + userId);
        List<PostVO> list = service.findPostByUserId(userId);

        request.setAttribute("myList",list);
        return new ModelView("/post/myList");
    }
}
