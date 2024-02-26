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

@WebServlet("/post/list")
public class PostListController extends HttpServlet {

    private final PostService service;

    public PostListController() {
        this.service = new PostService();
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        ModelView modelView = getModelView(request, response, session);
        String viewPath = "/WEB-INF" + modelView.getViewName() + ".jsp";

        request.getRequestDispatcher(viewPath).forward(request,response);
    }
    private ModelView getModelView(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        if (session != null && session.getAttribute("userID") != null) {
            int pageNumber = getPageNumber(request);
            List<PostVO> findAll = service.findAll(pageNumber);

            int totalPages = service.getTotalPages();
            request.setAttribute("pages",totalPages);
            request.setAttribute("size",findAll);
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

