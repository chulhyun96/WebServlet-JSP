package web_project.seveltjsp.jsp_PRJ.controller.post;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web_project.seveltjsp.jsp_PRJ.controller.Controller;
import web_project.seveltjsp.jsp_PRJ.controller.ModelView;
import web_project.seveltjsp.jsp_PRJ.model.VO.PostVO;
import web_project.seveltjsp.jsp_PRJ.model.entity.Member;
import web_project.seveltjsp.jsp_PRJ.model.service.PostService;

import java.io.IOException;

/*@WebServlet("/post/add")*/
public class PostAddController implements Controller {
   private PostService service;

    public PostAddController() {
        this.service = new PostService();
    }

    @Override
    public ModelView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        HttpSession session = request.getSession(false);
        String userId = (String) session.getAttribute("userID");
        Member member = service.findByUserId(userId);

        PostVO postVO = PostVO.createPost(subject, content, member.getUserID());
        int result = service.submitPost(postVO.getSubject(), postVO.getContent(), member);

        final int FAIL = 0;
        if (result > FAIL) {
            return new ModelView("/post/list");
        }

        return new ModelView("../");
    }
}
