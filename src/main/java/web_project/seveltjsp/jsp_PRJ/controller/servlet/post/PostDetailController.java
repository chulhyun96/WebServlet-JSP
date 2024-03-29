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

@WebServlet("/post/detail")
public class PostDetailController extends HttpServlet {
    private PostService service;
    public PostDetailController() {
        this.service = new PostService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        String userId = (String) session.getAttribute("userID");
        String tableId = request.getParameter("tableId");
        PostVO post = service.findPostByTableId(tableId);


        boolean result = service.checkIfEquals(userId, post.getUserId());

        request.setAttribute("result",result);
        request.setAttribute("post",post);
        String viewPath ="/WEB-INF/post/detail.jsp";
        request.getRequestDispatcher(viewPath).forward(request,response);
    }
}
