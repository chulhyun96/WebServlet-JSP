package web_project.seveltjsp.jsp_PRJ.controller.member.add;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.model.VO.MemberVO;
import web_project.seveltjsp.jsp_PRJ.model.service.MemberService;

import java.io.IOException;

@WebServlet("/member/add")
public class MemberAddController extends HttpServlet {
    private MemberService service;
    public MemberAddController() {
        this.service = new MemberService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String userPassword = request.getParameter("userPassword");
        String userName = request.getParameter("userName");

        MemberVO memberVO = MemberVO.createMember(userID, userPassword, userName);
        int result = service.addMember(memberVO);



        request.setAttribute("memberVO", memberVO);
        request.setAttribute("result", result);

        String viewPath = "/WEB-INF/member/loginWelcome.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);

    }
}
