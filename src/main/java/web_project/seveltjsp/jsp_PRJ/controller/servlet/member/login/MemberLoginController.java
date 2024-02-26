package web_project.seveltjsp.jsp_PRJ.controller.servlet.member.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.VO.MemberVO;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.service.MemberService;

import java.io.IOException;


@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
    private final MemberService service;

    public MemberLoginController() {
        this.service = new MemberService();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String userPassword = request.getParameter("userPassword");

        MemberVO memberVO = MemberVO.login(userID, userPassword);
        int result = service.login(memberVO.getUserId(), memberVO.getUserPassword());


        if (result == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("userID", memberVO.getUserId());
            response.sendRedirect("/post/list");
            return;
        }

        request.setAttribute("result",result);
        String viewPath = "/WEB-INF/member/loginFail.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
