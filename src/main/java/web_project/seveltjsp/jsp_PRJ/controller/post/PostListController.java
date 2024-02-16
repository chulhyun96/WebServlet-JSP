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
    private static final String VIEW_PATH = "/WEB-INF/post/list.jsp";
    private static final String ERROR_VIEW  = "/WEB-INF/error/error.jsp";

    private final PostService service;

    public PostListController() {
        this.service = new PostService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);

        if (loginUser(request, response, session)) return;

        request.getRequestDispatcher(ERROR_VIEW).forward(request, response);
    }

    private boolean loginUser(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        if (session != null && session.getAttribute("userID") != null) {
            int pageNumber = getPageNumber(request);
            List<PostVO> findAll = service.findAll(pageNumber);

            int totalPages = service.getTotalPages();
            request.setAttribute("pages",totalPages);
            request.setAttribute("size",findAll);
            request.getRequestDispatcher(VIEW_PATH).forward(request, response);
            return true;
        }
        return false;
    }

    private int getPageNumber(HttpServletRequest request) {
        String page = request.getParameter("page");
        final int DEFAULT_PAGE = 1;
        return (page == null) ? DEFAULT_PAGE : Integer.parseInt(page);
    }
}

