package web_project.seveltjsp.jsp_PRJ.controller.post;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
        // 유효한 세션인지 검증
        // 세션에 맞는 게시글 들어가면 수정 및 삭제 가능한 페이지
        // 세션에 맞지 않다면,
        String tableId = request.getParameter("tableId");
        PostVO post = service.getPost(tableId);
        System.out.println("제목 : "+post.getSubject());
        System.out.println("내용 : "+post.getContent());


        request.setAttribute("post",post);
        String viewPath = "/WEB-INF/post/detail.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
