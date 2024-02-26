package web_project.seveltjsp.jsp_PRJ.controller.servlet.post;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.VO.PostVO;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.service.PostService;

import java.io.IOException;
import java.util.List;

@WebServlet("/post/MyList")
public class PostMyListController extends HttpServlet {
    private PostService service;
    public PostMyListController() {
        this.service = new PostService();
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String userId = (String) session.getAttribute("userID");
        System.out.println("userId = " + userId);
        List<PostVO> list = service.findPostByUserId(userId);

        request.setAttribute("myList",list);
        String viewPath = "/WEB-INF/post/list.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
