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

public class PostListController implements Controller {
    private static final String VIEW_PATH = "/WEB-INF/post/list.jsp";
    private static final String ERROR_VIEW  = "/WEB-INF/error/error.jsp";

    private final PostService service;

    public PostListController() {
        this.service = new PostService();
    }


    @Override
    public ModelView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        return getModelView(request, response, session);
    }
    private ModelView getModelView(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        if (session != null && session.getAttribute("userID") != null) {
            int pageNumber = getPageNumber(request);
            List<PostVO> findAll = service.findAll(pageNumber);

            int totalPages = service.getTotalPages();
            request.setAttribute("pages",totalPages);
            request.setAttribute("size",findAll);
            request.getRequestDispatcher(VIEW_PATH).forward(request, response);
            return new ModelView("/post/list");
        }

        return new ModelView("/error/error");
    }

    private int getPageNumber(HttpServletRequest request) {
        String page = request.getParameter("page");
        final int DEFAULT_PAGE = 1;
        return (page == null) ? DEFAULT_PAGE : Integer.parseInt(page);
    }
}

