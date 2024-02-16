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

        // 세션값으로 들어온 userId로 게시글을 찾아야 되는데 현재 코드 처럼 돼있으면 무조건 true가 뜬다.
        // 이렇게 되면 로그인한 사람이랑 게시글을 작성한 사람이랑 달라야되는데 무조건 똑같다
        // 그럼 게시글을 선택하면 작성자Id를 받아야 되는데

        String userId = (String) session.getAttribute("userID");
        String tableId = request.getParameter("tableId");
        PostVO post = service.getPost(tableId);


        if (userId.equals(post.getUserId())) {
            request.setAttribute("postVO", post);
            String viewPath = "/WEB-INF/post/deleteUpdate.jsp";
            request.getRequestDispatcher(viewPath).forward(request, response);
            return;
        }


        //로그인한 사람것의 게시글이 아닐경우
        request.setAttribute("post",post);
        String viewPath = "/WEB-INF/post/detail.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
