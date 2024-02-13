package web_project.seveltjsp.jsp_PRJ.controller.post;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web_project.seveltjsp.jsp_PRJ.model.VO.PostVO;
import web_project.seveltjsp.jsp_PRJ.model.service.PostService;

import java.io.IOException;
import java.util.List;

@WebServlet("/post/list")
public class PostListController extends HttpServlet {
    private PostService service;

    public PostListController() {
        this.service = new PostService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(false);
        String userId = null;
        List<PostVO> findAll = service.findAll();

        if (session != null) {
            userId = (String) session.getAttribute("userID");
            request.setAttribute("UserID", userId);

        }

        String viewPath = "/WEB-INF/post/postList.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
