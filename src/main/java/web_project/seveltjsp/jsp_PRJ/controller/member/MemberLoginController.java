package web_project.seveltjsp.jsp_PRJ.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
        System.out.println("result = " + result);



        request.setAttribute("result",result);
        request.setAttribute("memberVO",memberVO);

        String viewPath = "/WEB-INF/member/loginCom.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);

    }
}
