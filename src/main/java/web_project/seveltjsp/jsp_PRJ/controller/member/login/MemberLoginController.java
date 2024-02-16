package web_project.seveltjsp.jsp_PRJ.controller.member.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web_project.seveltjsp.jsp_PRJ.model.VO.MemberVO;
import web_project.seveltjsp.jsp_PRJ.model.service.MemberService;

import java.io.IOException;


@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
    private final MemberService service;

    public MemberLoginController() {
        this.service = new MemberService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        System.out.println("asd");


        request.setAttribute("result",result);
        request.setAttribute("memberVO",memberVO);
        String viewPath = "/WEB-INF/member/loginFail.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);


    }
}
