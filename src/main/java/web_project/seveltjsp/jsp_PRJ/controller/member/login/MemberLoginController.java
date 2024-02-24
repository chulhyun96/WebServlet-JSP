package web_project.seveltjsp.jsp_PRJ.controller.member.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web_project.seveltjsp.jsp_PRJ.controller.Controller;
import web_project.seveltjsp.jsp_PRJ.controller.ModelView;
import web_project.seveltjsp.jsp_PRJ.model.VO.MemberVO;
import web_project.seveltjsp.jsp_PRJ.model.service.MemberService;

import java.io.IOException;


/*@WebServlet("/member/login")*/
public class MemberLoginController implements Controller {
    private final MemberService service;

    public MemberLoginController() {
        this.service = new MemberService();
    }

    @Override
    public ModelView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String userPassword = request.getParameter("userPassword");

        MemberVO memberVO = MemberVO.login(userID, userPassword);
        int result = service.login(memberVO.getUserId(), memberVO.getUserPassword());


        if (result == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("userID", memberVO.getUserId());
            return new ModelView("../post/list");
        }

        request.setAttribute("result",result);
        request.setAttribute("memberVO",memberVO);
        return new ModelView("loginFail");
    }
}
