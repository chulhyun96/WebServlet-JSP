package web_project.seveltjsp.jsp_PRJ.controller.post;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web_project.seveltjsp.jsp_PRJ.model.VO.PostVO;
import web_project.seveltjsp.jsp_PRJ.model.entity.Member;
import web_project.seveltjsp.jsp_PRJ.model.service.PostService;

import java.io.IOException;

@WebServlet("/post/add")
public class PostAddController extends HttpServlet {
   private PostService service;

    public PostAddController() {
        this.service = new PostService();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        HttpSession session = request.getSession(false);
        String userId = (String) session.getAttribute("userID");
        Member member = service.findByUserId(userId);

        PostVO postVO = PostVO.createPost(subject, content, member.getUserID());
        service.submitPost(postVO.getSubject(), postVO.getContent(), member);
        response.sendRedirect("list");
    }
}
