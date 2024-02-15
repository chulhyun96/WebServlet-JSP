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
    private final PostService service;

    public PostListController() {
        this.service = new PostService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("userID") != null) {
            String page = request.getParameter("page");

            final int DEFAULT_PAGE = 1;
            int pageNumber = (page == null) ? DEFAULT_PAGE : Integer.parseInt(page);

            List<PostVO> findAll = service.findAll(pageNumber);



            String viewPath = "/WEB-INF/post/list.jsp";
            request.setAttribute("size",findAll);
            request.getRequestDispatcher(viewPath).forward(request, response);
            return;
        }
        String viewPath = "/WEB-INF/error/error.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
