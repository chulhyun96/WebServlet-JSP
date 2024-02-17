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
        String tableId = request.getParameter("tableId");
        PostVO post = service.getPost(tableId);


        boolean result = service.checkIfEquals(userId, post.getUserId());

        /*if (userId.equals(post.getUserId())){
            request.setAttribute("post", post);
            String viewPath = "/WEB-INF/post/detail.jsp";
            request.getRequestDispatcher(viewPath).forward(request, response);
            return;
        }*/
        
        request.setAttribute("result",result);
        request.setAttribute("post",post);
        String viewPath = "/WEB-INF/post/detail.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
    
}
