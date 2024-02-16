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

@WebServlet("/post/detail")
public class PostDetailController extends HttpServlet {
    private PostService service;
    public PostDetailController() {
        this.service = new PostService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        String userId = (String) session.getAttribute("userID");
        String postWriter = request.getParameter("userId");

        if (userId.equals(postWriter)) {
            PostVO postVO = service.findPostByUserId(userId);
            request.setAttribute("postVO", postVO);
            String viewPath = "/WEB-INF/post/deleteUpdate.jsp";
            request.getRequestDispatcher(viewPath).forward(request, response);
            return;
        }

        //로그인한 사람것의 게시글이 아닐경우
        String tableId = request.getParameter("tableId");
        PostVO post = service.getPost(tableId);
        request.setAttribute("post",post);
        String viewPath = "/WEB-INF/post/detail.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
