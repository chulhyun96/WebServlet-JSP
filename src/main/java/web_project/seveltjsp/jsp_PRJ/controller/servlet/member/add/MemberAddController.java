package web_project.seveltjsp.jsp_PRJ.controller.servlet.member.add;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.VO.MemberVO;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.service.MemberService;

import java.io.IOException;

@WebServlet("/member/add")
public class MemberAddController extends HttpServlet {
    private MemberService service;

    public MemberAddController() {
        this.service = new MemberService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String userPassword = request.getParameter("userPassword");
        String name = request.getParameter("userName");


        MemberVO memberVO = MemberVO.createMember(userID, userPassword, name);
        service.addMember(memberVO);
        response.sendRedirect("/");
    }
}
